package oop.simulatingoperationflighttrainingacademy.Sabbir;

import java.time.LocalDate;

public class examOfficerDashboard {
    private String examType;
    private LocalDate examDate;
    private String time;
    private Integer capacity;

    public examOfficerDashboard(String examType, LocalDate examDate, String time, Integer capacity) {
        this.examType = examType;
        this.examDate = examDate;
        this.time = time;
        this.capacity = capacity;
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

    @Override
    public String toString() {
        return "examOfficerDashboard{" +
                "examType='" + examType + '\'' +
                ", examDate=" + examDate +
                ", time='" + time + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
