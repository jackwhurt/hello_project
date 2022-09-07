package com.kainos.ea;

import com.kainos.ea.employee_stuff.Employee;

import java.io.FileInputStream;
import java.sql.*;
import java.util.*;


public class HR {

    private static Connection conn;

    public static void main(String[] args) {

        long t1, t2;
        List<Employee> bigEmps = new ArrayList<>();
        Statement st = null;
        ResultSet rs = null;

        try(Connection myCon = getConnection()) {

            st = myCon.createStatement();
            rs = st.executeQuery(
                    "SELECT emp_no AS `number`, "
                            + "CONCAT_WS (' ', first_name, last_name) AS `name`, "
                            + "salary * 100 AS `salary` "
                            + "FROM employees JOIN salaries USING(emp_no) ");

            while (rs.next()) {
                Employee dbEmp = new Employee((short) rs.getInt("number"),
                        rs.getInt("salary"), rs.getString("name"));
                bigEmps.add(dbEmp);

            }

        } catch(SQLException ex) {

            System.out.println(ex.getMessage());

        } finally {

//            DbUtils.closeQuietly(rs);
//            DbUtils.closeQuietly(st);

        }

        //OptionalDouble avgSalaries = bigEmps.stream().mapToDouble(emp -> emp.getSalary()).average();

        OptionalDouble avgSalaries = bigEmps.stream().filter(emp -> emp.getName().split(" ")[1].trim().equals("Farris"))
                .sorted((x, y) -> (int) (x.getSalary() - y.getSalary()))
                .mapToDouble(x->x.getSalary()).average();

        System.out.println(String.format("Average salary is £%,.2f.", avgSalaries.getAsDouble()/100));

        t1 = System.nanoTime();
        t2 = System.nanoTime();
        System.err.println("Printing: Trace took " + (t2-t1) + " nanos.");

    }

    private static Connection getConnection() {
        String user;
        String password;
        String host;

        if (conn != null) {
            return conn;
        }

        try(FileInputStream propsStream =
                    new FileInputStream("employeesdb.properties")) {

            Properties props = new Properties();
            props.load(propsStream);

            user = props.getProperty("user");
            password = props.getProperty("password");
            host = props.getProperty("host");

            if (user == null || password == null || host == null)
                throw new IllegalArgumentException(
                        "Properties file must exist and must contain " + "user, password, and host properties.");
            conn = DriverManager.getConnection("jdbc:mysql://" + host +
                    "/employees?useSSL=false", user, password);
            return conn;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void orderByName(List<Employee> emps) {

        emps.stream().filter(emp -> emp.getSalary() > 25000_00)
                .sorted(Comparator.comparing(emp -> emp.getName()
                        .substring(emp.getName().indexOf(" ") + 1,emp.getName().indexOf(" ") + 2)))
                .forEach(System.out::println);


    }

}
