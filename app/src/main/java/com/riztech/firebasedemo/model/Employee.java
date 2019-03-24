package com.riztech.firebasedemo.model;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Employee {

    public String name;
    public String address;
    public String designation;
    public String department;


    public Employee() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public Employee(String name, String address, String designation, String department) {
        this.name = name;
        this.address = address;
        this.department = department;
        this.designation = designation;
    }

}