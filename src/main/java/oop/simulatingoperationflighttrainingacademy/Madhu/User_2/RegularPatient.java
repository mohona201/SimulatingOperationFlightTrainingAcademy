package oop.simulatingoperationflighttrainingacademy.Madhu.User_2;

import java.time.LocalDate;

public class RegularPatient {
    private int id;
    private String name;
    private String healthStatus;
    private LocalDate lastVisit;


    public RegularPatient(int id, String name, String healthStatus, LocalDate lastVisit) {
        this.id = id;
        this.name = name;
        this.healthStatus = healthStatus;
        this.lastVisit = lastVisit;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getHealthStatus() {
        return healthStatus;
    }

    public LocalDate getLastVisit() {
        return lastVisit;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHealthStatus(String healthStatus) {
        this.healthStatus = healthStatus;
    }

    public void setLastVisit(LocalDate lastVisit) {
        this.lastVisit = lastVisit;
    }

    @Override
    public String toString() {
        return "RegularPatient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", healthStatus='" + healthStatus + '\'' +
                ", lastVisit=" + lastVisit +
                '}';
    }
}
