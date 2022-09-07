package com.kainos.ea.employee_stuff;

public class SalesEmployee extends Employee {

    private float commissionRate;
    private int salesTotal;

    public SalesEmployee() {
    }

    public SalesEmployee(short numberToSet) {
        super(numberToSet);
    }

    public SalesEmployee(short numberToSet, int salaryToSet) {
        super(numberToSet, salaryToSet);
    }

    public SalesEmployee(short numberToSet, int salaryToSet, String nameToSet) {
        super(numberToSet, salaryToSet, nameToSet);
    }

    public SalesEmployee(short numberToSet, int salaryToSet, String nameToSet, float commissionRate) {
        super(numberToSet, salaryToSet, nameToSet);
        setCommissionRate(commissionRate);
    }

    public SalesEmployee(short numberToSet, int salaryToSet, String nameToSet, float commissionRate, int salesTotal) {
        this(numberToSet,salaryToSet,nameToSet,commissionRate);
        setSalesTotal(salesTotal);
    }

    public float getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(float commissionRate) {
        this.commissionRate = commissionRate;
    }

    public int getSalesTotal() {
        return salesTotal;
    }

    public void setSalesTotal(int salesTotal) {
        this.salesTotal = salesTotal;
    }

    @Override
    public int calcPay() {
        return super.calcPay() + Math.round(commissionRate * salesTotal);
    }

    @Override
    public boolean equals(Object obj) {

        if(obj instanceof SalesEmployee employee){
            return super.equals(obj) && employee.getCommissionRate() == commissionRate
                    && employee.getSalesTotal() == salesTotal;
        } else return false;

    }

    @Override
    public String toString() {

        return String.format("Employee %d: %s, £%,.2f. " + "Monthly gross pay: £%,.2f.",
                getNumber(), getName(), getSalary()/100.0, calcPay()/100.0);

    }

}
