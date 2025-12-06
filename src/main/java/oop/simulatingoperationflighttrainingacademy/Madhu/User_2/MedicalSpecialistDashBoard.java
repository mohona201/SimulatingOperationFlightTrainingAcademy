package oop.simulatingoperationflighttrainingacademy.Madhu.User_2;

import java.io.Serializable;
import java.time.LocalDate;

public class MedicalSpecialistDashBoard implements Serializable {
    private String name;
    private LocalDate date;
    private Integer id;

    public MedicalSpecialistDashBoard(String name, LocalDate date, Integer id) {
        this.name = name;
        this.date = date;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }

    public Integer getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "MedicalSpecialistDashBoard{" +
                "name='" + name + '\'' +
                ", date=" + date +
                ", id=" + id +
                '}';
    }
}

