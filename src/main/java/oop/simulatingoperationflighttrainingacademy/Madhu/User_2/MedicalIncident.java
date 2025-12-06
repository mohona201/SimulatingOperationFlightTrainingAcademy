package oop.simulatingoperationflighttrainingacademy.Madhu.User_2;

import java.io.Serializable;
import java.time.LocalDate;

public class MedicalIncident implements Serializable {
    private Integer studentId;
    private String name, incidentType, severity, incidentStatus;
    private LocalDate incidentDate;

    public MedicalIncident(Integer studentId, String name, String incidentType, String severity, String incidentStatus, LocalDate incidentDate) {
        this.studentId = studentId;
        this.name = name;
        this.incidentType = incidentType;
        this.severity = severity;
        this.incidentStatus = incidentStatus;
        this.incidentDate = incidentDate;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getIncidentType() {
        return incidentType;
    }

    public String getSeverity() {
        return severity;
    }

    public String getIncidentStatus() {
        return incidentStatus;
    }

    public LocalDate getIncidentDate() {
        return incidentDate;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIncidentType(String incidentType) {
        this.incidentType = incidentType;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public void setIncidentStatus(String incidentStatus) {
        this.incidentStatus = incidentStatus;
    }

    public void setIncidentDate(LocalDate incidentDate) {
        this.incidentDate = incidentDate;
    }

    @Override
    public String toString() {
        return "MedicalIncident{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", incidentType='" + incidentType + '\'' +
                ", severity='" + severity + '\'' +
                ", incidentStatus='" + incidentStatus + '\'' +
                ", incidentDate=" + incidentDate +
                '}';
    }
}

