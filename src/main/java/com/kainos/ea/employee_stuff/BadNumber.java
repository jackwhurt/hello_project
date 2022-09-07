package com.kainos.ea.employee_stuff;

public class BadNumber extends NumberFormatException {

    public BadNumber () {
        super();
    }
    public BadNumber (String s) {
        super (s);
    }

}
