package com.example.medailast.Models;

public class Project_model {
    private String name;
    private String status;
    private String id, nomProjet, prenomClient, start_date, date_end, phone, email, note;

    public Project_model(String name, String status, String id, String nomProjet, String prenomClient, String start_date, String date_end, String phone, String email, String note) {
        this.name = name;
        this.status = status;
        this.id = id;
        this.nomProjet = nomProjet;
        this.prenomClient = prenomClient;
        this.start_date = start_date;
        this.date_end = date_end;
        this.phone = phone;
        this.email = email;
        this.note = note;
    }

    public String getId() {
        return id;
    }

    public String getNomProjet() {
        return nomProjet;
    }

    public String getPrenomClient() {
        return prenomClient;
    }

    public String getStart_date() {
        return start_date;
    }

    public String getDate_end() {
        return date_end;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getNote() {
        return note;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNomProjet(String nomProjet) {
        this.nomProjet = nomProjet;
    }

    public void setPrenomClient(String prenomClient) {
        this.prenomClient = prenomClient;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public void setDate_end(String date_end) {
        this.date_end = date_end;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNote(String note) {
        this.note = note;
    }

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
