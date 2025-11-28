package oop.simulatingoperationflighttrainingacademy.Madhu.User_1;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Exm {
    private String exmName;
    private LocalDate exmDate;
    private LocalDateTime startTime, endTime;
    private Integer availableSeats, roomNumber;

    public Exm(String exmName, LocalDate exmDate, LocalDateTime startTime, LocalDateTime endTime, Integer availableSeats, Integer roomNumber) {
        this.exmName = exmName;
        this.exmDate = exmDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.availableSeats = availableSeats;
        this.roomNumber = roomNumber;
    }

    public String getExmName() {
        return exmName;
    }

    public LocalDate getExmDate() {
        return exmDate;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public Integer getAvailableSeats() {
        return availableSeats;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setExmName(String exmName) {
        this.exmName = exmName;
    }

    public void setExmDate(LocalDate exmDate) {
        this.exmDate = exmDate;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public void setAvailableSeats(Integer availableSeats) {
        this.availableSeats = availableSeats;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Override
    public String toString() {
        return "Exm{" +
                "exmName='" + exmName + '\'' +
                ", exmDate=" + exmDate +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", availableSeats=" + availableSeats +
                ", roomNumber=" + roomNumber +
                '}';
    }
}

