package com.mindex.challenge.data;

import java.util.List;

public class Compensation {
    private int salary ;
    private String effectiveDate; // Avoid date-time timezone issues. Use string until a different format is needed

    public Compensation() {}

    public Compensation(int salary, String effectiveDate) {
        this.salary = salary;
        this.effectiveDate = effectiveDate;
    }

    public int getSalary() {
        return salary;
    }

    public String getEffectiveDate(){
        return effectiveDate;
    }
}


