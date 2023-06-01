package com.example.medailast.Models;

public class EmployeeModel {
    private String id;
    private String name;
    private String phone;
    private String Email;
    private String num_project;

    public EmployeeModel(String id,String name, String phone, String email, String num_project) {
        this.name = name;
        this.phone = phone;
        Email = email;
        this.num_project = num_project;
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNum_project(String num_project) {
        this.num_project = num_project;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return Email;
    }

    public String getName() {
        return name;
    }

    public String getNum_project() {
        return num_project;
    }
}
