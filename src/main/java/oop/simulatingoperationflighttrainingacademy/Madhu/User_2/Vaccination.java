package oop.simulatingoperationflighttrainingacademy.Madhu.User_2;

import java.io.Serializable;
import java.time.LocalDate;

public class Vaccination implements Serializable {
    private String vacName,studentName , administer;
    private LocalDate vaccinationDate;
    private int studentId;

    public Vaccination(String vacName, String studentName, String administer, LocalDate vaccinationDate, Integer studentId) {
        this.vacName = vacName;
        this.studentName = studentName;
        this.administer = administer;
        this.vaccinationDate = vaccinationDate;
        this.studentId = studentId;
    }

    public String getVacName() {
        return vacName;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getAdminister() {
        return administer;
    }

    public LocalDate getVaccinationDate() {
        return vaccinationDate;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setVacName(String vacName) {
        this.vacName = vacName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setAdminister(String administer) {
        this.administer = administer;
    }

    public void setVaccinationDate(LocalDate vaccinationDate) {
        this.vaccinationDate = vaccinationDate;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "Vaccination{" +
                "vacName='" + vacName + '\'' +
                ", studentName='" + studentName + '\'' +
                ", administer='" + administer + '\'' +
                ", vaccinationDate=" + vaccinationDate +
                ", studentId=" + studentId +
                '}';
    }



}
