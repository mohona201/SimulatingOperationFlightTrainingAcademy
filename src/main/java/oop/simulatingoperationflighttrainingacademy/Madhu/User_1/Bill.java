package oop.simulatingoperationflighttrainingacademy.Madhu.User_1;

import java.time.LocalDate;

public class Bill {
    private  String billName;
    private  Float amount;
    private LocalDate lastPaymentDate;

    public Bill(String billName, Float amount, LocalDate lastPaymentDate) {
        this.billName = billName;
        this.amount = amount;
        this.lastPaymentDate = lastPaymentDate;
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
                "billName='" + billName + '\'' +
                ", amount=" + amount +
                ", lastPaymentDate=" + lastPaymentDate +
                '}';
    }
}
