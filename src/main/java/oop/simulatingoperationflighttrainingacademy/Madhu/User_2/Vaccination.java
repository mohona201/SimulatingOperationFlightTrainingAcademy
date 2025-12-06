package oop.simulatingoperationflighttrainingacademy.Madhu.User_2;

import java.io.Serializable;
import java.time.LocalDate;

public class Vaccination implements Serializable {
    private String vacName, name, administer;
    private LocalDate vaccinationDate;
    private int studentId;

    public Vaccination(String vacName, String name, String administer, LocalDate vaccinationDate, int studentId) {
        this.vacName = vacName;
        this.name = name;
        this.administer = administer;
        this.vaccinationDate = vaccinationDate;
        this.studentId = studentId;
    }

    public String getVacName() {
        return vacName;
    }

    public String getName() {
        return name;
    }

    public String getAdminister() {
        return administer;
    }

    public LocalDate getVaccinationDate() {
        return vaccinationDate;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setVacName(String vacName) {
        this.vacName = vacName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAdminister(String administer) {
        this.administer = administer;
    }

    public void setVaccinationDate(LocalDate vaccinationDate) {
        this.vaccinationDate = vaccinationDate;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "Vaccination{" +
                "vacName='" + vacName + '\'' +
                ", name='" + name + '\'' +
                ", administer='" + administer + '\'' +
                ", vaccinationDate=" + vaccinationDate +
                ", studentId=" + studentId +
                '}';
    }
}

