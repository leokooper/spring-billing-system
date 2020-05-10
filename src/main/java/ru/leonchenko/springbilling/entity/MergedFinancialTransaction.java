package ru.leonchenko.springbilling.entity;

/**
 * @author Igor Leonchenko
 * @version 1.0
 */

public class MergedFinancialTransaction {

    private String id;

    private Long amount;

    public MergedFinancialTransaction() {
    }

    public MergedFinancialTransaction(String id, Long amount) {
        this.id = id;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "MergedFinancialTransaction{" +
                "id='" + id + '\'' +
                ", amount=" + amount +
                '}';
    }
}
