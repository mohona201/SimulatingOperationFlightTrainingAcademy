package oop.simulatingoperationflighttrainingacademy.Madhu.User_2;

import java.io.Serializable;
import java.time.LocalDate;

public class MedicalReport implements Serializable {
    private Integer reportId;
    private String reportName, reportStatus;
    private LocalDate reportDate;

    public MedicalReport(Integer reportId, String reportName, String reportStatus, LocalDate reportDate) {
        this.reportId = reportId;
        this.reportName = reportName;
        this.reportStatus = reportStatus;
        this.reportDate = reportDate;
    }

    public Integer getReportId() {
        return reportId;
    }

    public String getReportName() {
        return reportName;
    }

    public String getReportStatus() {
        return reportStatus;
    }

    public LocalDate getReportDate() {
        return reportDate;
    }

    public void setReportId(Integer reportId) {
        this.reportId = reportId;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public void setReportStatus(String reportStatus) {
        this.reportStatus = reportStatus;
    }

    public void setReportDate(LocalDate reportDate) {
        this.reportDate = reportDate;
    }

    @Override
    public String toString() {
        return "MedicalReport{" +
                "reportId=" + reportId +
                ", reportName='" + reportName + '\'' +
                ", reportStatus='" + reportStatus + '\'' +
                ", reportDate=" + reportDate +
                '}';
    }
}

