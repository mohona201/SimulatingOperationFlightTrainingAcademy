package oop.simulatingoperationflighttrainingacademy.Madhu.User_1;

import java.time.LocalDate;

public class LogBook {
    private String instructorName, aircraftModel, flightDuration, remarks;
    private LocalDate date;

    public LogBook(String instructorName, String aircraftModel, String flightDuration, String remarks, LocalDate date) {
        this.instructorName = instructorName;
        this.aircraftModel = aircraftModel;
        this.flightDuration = flightDuration;
        this.remarks = remarks;
        this.date = date;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public String getAircraftModel() {
        return aircraftModel;
    }

    public String getFlightDuration() {
        return flightDuration;
    }

    public String getRemarks() {
        return remarks;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public void setAircraftModel(String aircraftModel) {
        this.aircraftModel = aircraftModel;
    }

    public void setFlightDuration(String flightDuration) {
        this.flightDuration = flightDuration;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "LogBook{" +
                "instructorName='" + instructorName + '\'' +
                ", aircraftModel='" + aircraftModel + '\'' +
                ", flightDuration='" + flightDuration + '\'' +
                ", remarks='" + remarks + '\'' +
                ", date=" + date +
                '}';
    }
}

