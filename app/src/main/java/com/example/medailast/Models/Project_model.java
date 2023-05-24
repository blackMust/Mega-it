package com.example.medailast.Models;

public class Project_model {
    private String name;

    public Project_model(String name, String status) {
        this.name = name;
        this.status = status;
    }

    private String status;

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
