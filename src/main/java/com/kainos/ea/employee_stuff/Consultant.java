package com.kainos.ea.employee_stuff;

public class Consultant implements IPayable {

    protected String name;
    protected int dailyRate;
    protected int daysWorked;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(int dailyRate) {
        this.dailyRate = dailyRate;
    }

    public int getDaysWorked() {
        return daysWorked;
    }

    public void setDaysWorked(int daysWorked) {
        this.daysWorked = daysWorked;
    }

    public Consultant(String name, int dailyRate, int daysWorked) {
        this.name = name;
        this.dailyRate = dailyRate;
        this.daysWorked = daysWorked;
    }

    @Override
    public int calcPay() {
        return dailyRate*daysWorked;
    }

    public String getCheque() {
        return(getName() + ", " + calcPay());
    }
}
