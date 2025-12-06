package oop.simulatingoperationflighttrainingacademy.Madhu.User_2;

import java.io.Serializable;
import java.time.LocalDate;

public class RegularPatients implements Serializable {
    private int id;
    private String name,notes;
    private String healthStatus;
    private LocalDate date;


    public RegularPatients(int id, String name, String notes, String healthStatus, LocalDate date) {
        this.id = id;
        this.name = name;
        this.notes = notes;
        this.healthStatus = healthStatus;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNotes() {
        return notes;
    }

    public String getHealthStatus() {
        return healthStatus;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setHealthStatus(String healthStatus) {
        this.healthStatus = healthStatus;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "RegularPatient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", notes='" + notes + '\'' +
                ", healthStatus='" + healthStatus + '\'' +
                ", date=" + date +
                '}';
    }
}


