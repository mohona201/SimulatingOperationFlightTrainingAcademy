package oop.simulatingoperationflighttrainingacademy.Madhu.User_1;

import java.time.LocalDate;

public class Leave {
    private LocalDate startDate;
    private LocalDate endDate;
    private String reason;
    private LocalDate submissionDate;

    public Leave(LocalDate startDate, LocalDate endDate, String reason, LocalDate submissionDate) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.reason = reason;
        this.submissionDate = submissionDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getReason() {
        return reason;
    }

    public LocalDate getSubmissionDate() {
        return submissionDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setSubmissionDate(LocalDate submissionDate) {
        this.submissionDate = submissionDate;
    }

    @Override
    public String toString() {
        return "Leave{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                ", reason='" + reason + '\'' +
                ", submissionDate=" + submissionDate +
                '}';
    }
}
