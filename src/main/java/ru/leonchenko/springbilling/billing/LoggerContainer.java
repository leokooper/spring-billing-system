package ru.leonchenko.springbilling.billing;

import ru.leonchenko.springbilling.entity.FinancialTransaction;

import java.util.List;

/**
 * @author Igor Leonchenko
 * @version 1.0
 */

public interface LoggerContainer {

    public void push(FinancialTransaction financialTransaction);

    public List<FinancialTransaction> getFinancialTransactionDB();

}
