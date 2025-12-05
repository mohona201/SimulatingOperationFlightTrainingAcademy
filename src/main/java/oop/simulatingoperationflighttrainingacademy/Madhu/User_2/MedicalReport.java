package oop.simulatingoperationflighttrainingacademy.Madhu.User_2;

import java.io.Serializable;
import java.time.LocalDate;

public class MedicalReport implements Serializable {
    private String reportName, reportStatus, statusCategory, statValue;
    private LocalDate reportDate;
    private LocalDate statYear;

    public MedicalReport(String reportName, String reportStatus, String statusCategory, String statValue, LocalDate reportDate, LocalDate statYear) {
        this.reportName = reportName;
        this.reportStatus = reportStatus;
        this.statusCategory = statusCategory;
        this.statValue = statValue;
        this.reportDate = reportDate;
        this.statYear = statYear;
    }

    public String getReportName() {
        return reportName;
    }

    public String getReportStatus() {
        return reportStatus;
    }

    public String getStatusCategory() {
        return statusCategory;
    }

    public String getStatValue() {
        return statValue;
    }

    public LocalDate getReportDate() {
        return reportDate;
    }

    public LocalDate getStatYear() {
        return statYear;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public void setReportStatus(String reportStatus) {
        this.reportStatus = reportStatus;
    }

    public void setStatusCategory(String statusCategory) {
        this.statusCategory = statusCategory;
    }

    public void setStatValue(String statValue) {
        this.statValue = statValue;
    }

    public void setReportDate(LocalDate reportDate) {
        this.reportDate = reportDate;
    }

    public void setStatYear(LocalDate statYear) {
        this.statYear = statYear;
    }

    @Override
    public String toString() {
        return "MedicalReport{" +
                "reportName='" + reportName + '\'' +
                ", reportStatus='" + reportStatus + '\'' +
                ", statusCategory='" + statusCategory + '\'' +
                ", statValue='" + statValue + '\'' +
                ", reportDate=" + reportDate +
                ", statYear=" + statYear +
                '}';
    }
}

