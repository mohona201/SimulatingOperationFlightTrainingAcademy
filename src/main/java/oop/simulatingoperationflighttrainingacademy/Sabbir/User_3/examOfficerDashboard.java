package oop.simulatingoperationflighttrainingacademy.Sabbir.User_3;

import java.io.Serializable;
import java.time.LocalDate;

public class examOfficerDashboard implements Serializable {
    private String examType;
    private LocalDate examDate;
    private String time;
    private Integer capacity;
    private String course;

    public examOfficerDashboard(String examType, LocalDate examDate, String time, Integer capacity, String course) {
        this.examType = examType;
        this.examDate = examDate;
        this.time = time;
        this.capacity = capacity;
        this.course = course;
    }

    public String getExamType() {
        return examType;
    }

    public void setExamType(String examType) {
        this.examType = examType;
    }

    public LocalDate getExamDate() {
        return examDate;
    }

    public void setExamDate(LocalDate examDate) {
        this.examDate = examDate;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "examOfficerDashboard{" +
                "examType='" + examType + '\'' +
                ", examDate=" + examDate +
                ", time='" + time + '\'' +
                ", capacity=" + capacity +
                ", course='" + course + '\'' +
                '}';
    }
}
