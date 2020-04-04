package ru.leonchenko.springbilling.entity;

/**
 * @author Igor Leonchenko
 * @version 1.0
 */

public class FinancialTransaction {

    private Integer id;

    private Integer srcId;

    private Integer dstId;

    private Long amount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSrcId() {
        return srcId;
    }

    public void setSrcId(Integer srcId) {
        this.srcId = srcId;
    }

    public Integer getDstId() {
        return dstId;
    }

    public void setDstId(Integer dstId) {
        this.dstId = dstId;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public FinancialTransaction(Integer id, Integer srcId, Integer dstId, Long amount) {
        this.id = id;
        this.srcId = srcId;
        this.dstId = dstId;
        this.amount = amount;
    }

    public FinancialTransaction() {
    }

    @Override
    public String toString() {
        return "FinancialTransaction{" +
                "id=" + id +
                ", srcId=" + srcId +
                ", dstId=" + dstId +
                ", ammount=" + amount +
                '}';
    }
}
