package com.example.midtermtestapplication;

public class data {
    private String name;
    private String fees;
    private String hrs;

    public data(String name, String fees, String hrs) {
        this.name = name;
        this.fees = fees;
        this.hrs = hrs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFees() {
        return fees;
    }

    public void setFees(String fees) {
        this.fees = fees;
    }

    public String getHrs() {
        return hrs;
    }

    public void setHrs(String hrs) {
        this.hrs = hrs;
    }
}
