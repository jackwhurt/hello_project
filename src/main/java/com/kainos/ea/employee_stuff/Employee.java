package com.kainos.ea.employee_stuff;

import java.util.Objects;

public class Employee implements IPayable, Comparable<Employee> {

    private short number;
    protected int salary;
    private String name;
    public static final int MIN_SALARY = 7000_00;

    public boolean setNumber(short number) {

        if(number > 0) {
            this.number = number;
            return true;
        } else {
            return false;
        }

    }

    public void setNumber(String number){

        try{

            short s = Short.parseShort(number);
            setNumber(s);

        } catch(NumberFormatException e) {

            throw new BadNumber(e.getMessage());

        }

    }

    public void setSalary(int salary) {

        try{

            if(salary >= MIN_SALARY) {
                this.salary = salary;

            } else {
                throw new SalaryTooLowException(String.format("Salary £%,.2f is below the minimum salary £%,.2f.",
                        (float) salary/100,(float) MIN_SALARY/100));
            }

        } catch(SalaryTooLowException e) {

            System.out.println("SalaryTooLowException: " + e.getMessage());

        }

    }

    public void setName(String name) {
        this.name = name;
    }

    public short getNumber() {
        return number;
    }

    public int getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }
    public Employee() {

        number = -1;

    }

    public Employee(short numberToSet) {

        setNumber(numberToSet);

    }

    public Employee(short numberToSet, int salaryToSet) {

        this(numberToSet);
        setSalary(salaryToSet);

    }

    public Employee(short numberToSet, int salaryToSet, String nameToSet) {

        this(numberToSet,salaryToSet);
        setName(nameToSet);

    }
    public int calcPay() {
        return getSalary() / 12;
    }

    @Override
    public boolean equals(Object obj) {

        if(obj instanceof Employee employee){
            return employee.getSalary() == salary && Objects.equals(employee.getName(), name)
                    && employee.getNumber() == number;
        } else return false;

    }

    public String toString() {

            return String.format("Employee %d: %s, £%,.2f. " + "Monthly gross pay: £%,.2f.",
                    getNumber(), getName(), getSalary()/100.0, calcPay()/100.0);

    }

    public int compareTo(Employee x) {

        return Float.compare(this.getSalary(),x.getSalary());

    }

}
