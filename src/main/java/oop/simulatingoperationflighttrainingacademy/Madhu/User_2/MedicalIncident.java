package oop.simulatingoperationflighttrainingacademy.Madhu.User_2;

import java.time.LocalDate;

public class MedicalIncident {
    private Integer studentId;
    private String studentName, incidentType, severity, incidentStatus;
    private LocalDate incidentDate;

    public MedicalIncident(Integer studentId, String studentName, String incidentType, String severity, String incidentStatus, LocalDate incidentDate) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.incidentType = incidentType;
        this.severity = severity;
        this.incidentStatus = incidentStatus;
        this.incidentDate = incidentDate;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
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

    public void setStudentName(String studentName) {
        this.studentName = studentName;
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
                ", studentName='" + studentName + '\'' +
                ", incidentType='" + incidentType + '\'' +
                ", severity='" + severity + '\'' +
                ", incidentStatus='" + incidentStatus + '\'' +
                ", incidentDate=" + incidentDate +
                '}';
    }

}


