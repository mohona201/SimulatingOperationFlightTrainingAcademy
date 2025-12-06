package oop.simulatingoperationflighttrainingacademy.Madhu.User_1;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class TrainingSession implements Serializable {

    private  Integer flightId;
    private String instructorName,CourseName;
    private LocalDate sessionDate;
    private LocalDateTime sessionTime;
    private LocalDate date;


    public TrainingSession(Integer flightId, String instructorName, String courseName, LocalDate sessionDate, LocalDateTime sessionTime, LocalDate date) {
        this.flightId = flightId;
        this.instructorName = instructorName;
        CourseName = courseName;
        this.sessionDate = sessionDate;
        this.sessionTime = sessionTime;
        this.date = date;
    }

    public Integer getFlightId() {
        return flightId;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public String getCourseName() {
        return CourseName;
    }

    public LocalDate getSessionDate() {
        return sessionDate;
    }

    public LocalDateTime getSessionTime() {
        return sessionTime;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setFlightId(Integer flightId) {
        this.flightId = flightId;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public void setCourseName(String courseName) {
        CourseName = courseName;
    }

    public void setSessionDate(LocalDate sessionDate) {
        this.sessionDate = sessionDate;
    }

    public void setSessionTime(LocalDateTime sessionTime) {
        this.sessionTime = sessionTime;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "TrainingSession{" +
                "flightId=" + flightId +
                ", instructorName='" + instructorName + '\'' +
                ", CourseName='" + CourseName + '\'' +
                ", sessionDate=" + sessionDate +
                ", sessionTime=" + sessionTime +
                ", date=" + date +
                '}';
    }
}
