package ru.leonchenko.springbilling.billing;

import ru.leonchenko.springbilling.entity.FinancialTransaction;

/**
 * @author Igor Leonchenko
 * @version 1.0
 */

public class TransactionValidation {

    public boolean validation(FinancialTransaction financialTransaction) {

        if (financialTransaction.getId() > 0)
            System.out.println("Id is valid");
        else throw new IllegalArgumentException("Id is not valid");

        if (!financialTransaction.getSrcId().equals(financialTransaction.getDstId()))
            System.out.println("Source and destination are valid");
        else throw new IllegalArgumentException("Source and destination are not valid");

        if (financialTransaction.getAmount() > 0)
            System.out.println("Amount is valid");
        else throw new IllegalArgumentException("Amount is not valid");

        return true;
    }
}
