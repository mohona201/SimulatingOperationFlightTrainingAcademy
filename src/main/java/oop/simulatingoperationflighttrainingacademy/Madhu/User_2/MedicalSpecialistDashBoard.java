package oop.simulatingoperationflighttrainingacademy.Madhu.User_2;

import java.io.Serializable;
import java.time.LocalDate;

public class MedicalSpecialistDashBoard implements Serializable {
    private String name, reason,status;
    private LocalDate date;

    public MedicalSpecialistDashBoard(String name, String reason, String status, LocalDate date) {
        this.name = name;
        this.reason = reason;
        this.status = status;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public String getReason() {
        return reason;
    }

    public String getStatus() {
        return status;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "medicalSpecialistDashBoard{" +
                "name='" + name + '\'' +
                ", reason='" + reason + '\'' +
                ", status='" + status + '\'' +
                ", date=" + date +
                '}';
    }

    ;

}
