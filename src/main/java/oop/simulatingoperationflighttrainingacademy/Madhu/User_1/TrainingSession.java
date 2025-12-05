package oop.simulatingoperationflighttrainingacademy.Madhu.User_1;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class TrainingSession implements Serializable {

    private String sessionName,instructorName,CourseName;
    private LocalDate sessionDate;
    private LocalDateTime sessionTime;

    public TrainingSession(String sessionName, String instructorName, String courseName, LocalDate sessionDate, LocalDateTime sessionTime) {
        this.sessionName = sessionName;
        this.instructorName = instructorName;
        CourseName = courseName;
        this.sessionDate = sessionDate;
        this.sessionTime = sessionTime;
    }

    public String getSessionName() {
        return sessionName;
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

    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
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

    @Override
    public String toString() {
        return "trainingSession{" +
                "sessionName='" + sessionName + '\'' +
                ", instructorName='" + instructorName + '\'' +
                ", CourseName='" + CourseName + '\'' +
                ", sessionDate=" + sessionDate +
                ", sessionTime=" + sessionTime +
                '}';
    }
}
