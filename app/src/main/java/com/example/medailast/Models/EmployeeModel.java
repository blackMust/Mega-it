package com.example.medailast.Models;

public class EmployeeModel {
    private String name;
    private String num_project;

    public EmployeeModel(String name, String num_project) {
        this.name = name;
        this.num_project = num_project;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNum_project(String num_project) {
        this.num_project = num_project;
    }

    public String getName() {
        return name;
    }

    public String getNum_project() {
        return num_project;
    }
}
