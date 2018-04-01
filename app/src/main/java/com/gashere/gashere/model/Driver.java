package com.gashere.gashere.model;

/**
 * Created by John on 01-04-2018.
 */

public class Driver {
    private String firstName;
    private String lastName;
    private String time;
    private String totalValue;

    public Driver(String firstName, String lastName, String time, String totalValue) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.time = time;
        this.totalValue = totalValue;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(String totalValue) {
        this.totalValue = totalValue;
    }

}
