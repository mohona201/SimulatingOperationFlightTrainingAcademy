package oop.simulatingoperationflighttrainingacademy.Sabbir.User_4;

import java.io.Serializable;

public class feeStructure implements Serializable {
    public String feeId;
    public String feeName;
    public String program;
    public String category;
    public String currency;
    public double amount;
    public String effectiveFrom;
    public String effectiveTo;
    public String remarks;

    public feeStructure(String feeId, String feeName, String program, String category, String currency, double amount, String effectiveFrom, String effectiveTo, String remarks) {
        this.feeId = feeId;
        this.feeName = feeName;
        this.program = program;
        this.category = category;
        this.currency = currency;
        this.amount = amount;
        this.effectiveFrom = effectiveFrom;
        this.effectiveTo = effectiveTo;
        this.remarks = remarks;
    }

    public String getFeeId() {
        return feeId;
    }

    public void setFeeId(String feeId) {
        this.feeId = feeId;
    }

    public String getFeeName() {
        return feeName;
    }

    public void setFeeName(String feeName) {
        this.feeName = feeName;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getEffectiveFrom() {
        return effectiveFrom;
    }

    public void setEffectiveFrom(String effectiveFrom) {
        this.effectiveFrom = effectiveFrom;
    }

    public String getEffectiveTo() {
        return effectiveTo;
    }

    public void setEffectiveTo(String effectiveTo) {
        this.effectiveTo = effectiveTo;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "feeStructure{" +
                "feeId='" + feeId + '\'' +
                ", feeName='" + feeName + '\'' +
                ", program='" + program + '\'' +
                ", category='" + category + '\'' +
                ", currency='" + currency + '\'' +
                ", amount=" + amount +
                ", effectiveFrom='" + effectiveFrom + '\'' +
                ", effectiveTo='" + effectiveTo + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
