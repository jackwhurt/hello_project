package com.kainos.ea;

import com.kainos.ea.employee_stuff.Consultant;
import com.kainos.ea.employee_stuff.Employee;
import com.kainos.ea.employee_stuff.PayrollSystem;
import com.kainos.ea.employee_stuff.SalesEmployee;

import java.io.FileInputStream;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.*;
import java.util.stream.Collectors;

public class HR {

    private static Connection conn;

    public static void main(String[] args) {

//        try(Connection myCon = getConnection()) {
//
//            Statement st = myCon.createStatement();
//            ResultSet rs = st.executeQuery(
//                    "SELECT emp_no AS `number`, "
//                            + "CONCAT_WS (' ', first_name, last_name) AS `name`, "
//                            + "salary * 100 AS `salary` "
//                            + "FROM employees JOIN salaries USING(emp_no) "
//                            + "WHERE to_date > NOW() AND salary = 100000");
//
//            while (rs.next()) {
//                Employee dbEmp = new Employee((short) rs.getInt("number"),
//                        rs.getInt("salary"), rs.getString("name"));
//                System.out.println(dbEmp);
//
//            }
//
//        } catch(SQLException ex) {
//
//            System.out.println(ex.getMessage());
//
//        }

        long t1, t2;
        List<Employee> bigEmps = new ArrayList<>();

        try(Connection myCon2 = getConnection()) {

            Statement st = myCon2.createStatement();
            ResultSet rs = st.executeQuery(
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

        }

        //OptionalDouble avgSalaries = bigEmps.stream().mapToDouble(emp -> emp.getSalary()).average();

        OptionalDouble avgSalaries = bigEmps.stream().filter(emp -> emp.getName().split(" ")[1].trim().equals("Farris"))
                .sorted((x, y) -> (int) (x.getSalary() - y.getSalary()))
                .mapToDouble(x->x.getSalary()).average();

        System.out.println(String.format("Average salary is £%,.2f.", avgSalaries.getAsDouble()/100));

        t1 = System.nanoTime();
        t2 = System.nanoTime();
        System.err.println("Printing: Trace took " + (t2-t1) + " nanos.");

//        Employee a = new Employee( (short) 1,40000_00, "A. Smith");
//        Employee b = new Employee( (short) 2, 20000_00, "B. Jones");
//        Employee c = new Employee( (short) 3, 10000_00, "C. Doe");
//        Employee d = new Employee( (short) 4, 30000_00, "D. Wong");
//        Employee e = new Employee( (short) 5, 60000_00, "E. Williams");
//        Employee f = new Employee( (short) 6, 15000_00, "F. Carley");
//
//        Employee g = new SalesEmployee( (short) 7, 50000_00, "G. Boyle",10, 3000_00);
//        Employee h = new SalesEmployee( (short) 8, 45000_00, "H. Clink",12,1000_00);
//
//        List<Employee> emps = new ArrayList<>();
//
//        emps.add(a);
//        emps.add(b);
//        emps.add(c);
//        emps.add(d);
//        emps.add(e);
//        emps.add(f);
//        emps.add(g);
//        emps.add(h);
//
//        emps.parallelStream().forEach(emp -> System.out.println(emp));
//
//        System.out.println("BREAK --------------");
//
//        emps.stream().filter(emp -> emp.getSalary() > 25000_00)
//                .sorted(Comparator.comparing(emp -> emp.getName()
//                        .substring(emp.getName().indexOf(" ") + 1,emp.getName().indexOf(" ") + 2)))
//                .forEach(System.out::println);
//
//        System.out.println("BREAK --------------");
//
//        emps.stream().filter(emp -> emp.getClass() == SalesEmployee.class)
//                .forEach(emp -> System.out.printf("This month, %s sold £%,.2f. worth of goods%n",
//                        emp.getName(), (float) ((SalesEmployee) emp).getSalesTotal()/100));
//
//        System.out.println("BREAK --------------");
//
//        System.out.println(String.format("Total Payroll: £%,.2f.",
//                (float) (Integer) emps.stream().mapToInt(Employee::getSalary).sum() /100));
//
//        System.out.println("BREAK --------------");
//
//        System.out.println(String.format("Total Sales:  £%,.2f.", (float)
//                emps.stream().filter(emp -> emp.getClass() == SalesEmployee.class)
//                        .mapToInt(emp -> ((SalesEmployee) emp).getSalesTotal()).sum()/100));
//


//        for(Object x : emps) {
//
//            Employee e = (Employee) x;
//            System.out.println(e.getName() + " earns " + e.calcPay());
//
//        }
//
//        Collections.sort(emps);
//
//        for(Employee e : emps){
//
//            System.out.println(e);
//
//        }
//
//        System.out.println("Highest earner: " + Collections.max(emps));
//        System.out.println("Lowest earner: " + Collections.min(emps));
//

//        try {
//
//            Class eClass = Class.forName("com.kainos.ea.employee_stuff.Employee");
//
//            Employee emp1 = (Employee) eClass.getDeclaredConstructor().newInstance();
//            Employee emp2 = new SalesEmployee((short) 13, 20000_00, "H. Williams", 10);
//
//
//            emp1.setSalary(2000_00);
//
//            Employee johnE = new Employee((short) 815, 18200_00, "John Smith");
//            Employee johnS = new SalesEmployee((short) 815, 18200_00, "John Smith",
//                    (float) 1.4, 2450_00);
//
//            Consultant consultant = new Consultant("L. Robins", 100, 50);
//
//            PayrollSystem ps = new PayrollSystem();
//            double emp1_pay = ps.netPay(emp1);
//            double emp2_pay = ps.netPay(emp2);
//
//            System.out.println(emp1);
//            System.out.println(emp2);
//
//            Employee m1 = johnE;
//            Employee m2 = johnS;
//
//            System.out.println(String.format("Take home pay: £%,.2f, £%,.2f. ", emp1_pay / 100, emp2_pay / 100));
//
//            System.out.println("Consultant total pay: £" + consultant.calcPay());
//
//        } catch(ClassNotFoundException e) {
//
//            System.err.println("Class not found: " + e.getMessage());
//
//        } catch (InvocationTargetException e) {
//
//            System.err.println("Invocation Target Exception: " + e.getMessage());
//
//        } catch (InstantiationException e) {
//
//            System.err.println("Instantiation Error: " + e.getMessage());
//
//        } catch (IllegalAccessException e) {
//
//            System.err.println("Illegal Access: " + e.getMessage());
//
//        } catch (NoSuchMethodException e) {
//
//            System.err.println("Method not found: " + e.getMessage());
//
//        }

    }

    private static Connection getConnection() {
        String user;
        String password;
        String host;

        if (conn != null) {
            return conn;
        }

        try {
            // Bad practice alert!
            FileInputStream propsStream =
                    new FileInputStream("employeesdb.properties");

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
