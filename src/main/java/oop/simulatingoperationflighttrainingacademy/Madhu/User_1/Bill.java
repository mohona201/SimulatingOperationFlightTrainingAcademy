package oop.simulatingoperationflighttrainingacademy.Madhu.User_1;

import java.io.Serializable;
import java.time.LocalDate;

public class Bill implements Serializable {
    private Integer billId;

    private String billName;
    private Float amount;
    private LocalDate lastPaymentDate;

    public Bill(Integer billId, String billName, Float amount, LocalDate lastPaymentDate) {
        this.billId = billId;
        this.billName = billName;
        this.amount = amount;
        this.lastPaymentDate = lastPaymentDate;
    }

    public Integer getBillId() {
        return billId;
    }

    public String getBillName() {
        return billName;
    }

    public Float getAmount() {
        return amount;
    }

    public LocalDate getLastPaymentDate() {
        return lastPaymentDate;
    }

    public void setBillId(Integer billId) {
        this.billId = billId;
    }

    public void setBillName(String billName) {
        this.billName = billName;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public void setLastPaymentDate(LocalDate lastPaymentDate) {
        this.lastPaymentDate = lastPaymentDate;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "billId=" + billId +
                ", billName='" + billName + '\'' +
                ", amount=" + amount +
                ", lastPaymentDate=" + lastPaymentDate +
                '}';
    }
}

