package oop.simulatingoperationflighttrainingacademy.Madhu.User_1;

import java.time.LocalDate;

public class StudentPilot {
    private String instructorName, aircraftModel;
    private LocalDate Date;
            private String startTime, endTime;


    public StudentPilot(String instructorName, String aircraftModel, LocalDate date, String startTime, String endTime) {
        this.instructorName = instructorName;
        this.aircraftModel = aircraftModel;
        Date = date;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public String getAircraftModel() {
        return aircraftModel;
    }

    public LocalDate getDate() {
        return Date;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public void setAircraftModel(String aircraftModel) {
        this.aircraftModel = aircraftModel;
    }

    public void setDate(LocalDate date) {
        Date = date;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "StudentPilot{" +
                "instructorName='" + instructorName + '\'' +
                ", aircraftModel='" + aircraftModel + '\'' +
                ", Date=" + Date +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}



