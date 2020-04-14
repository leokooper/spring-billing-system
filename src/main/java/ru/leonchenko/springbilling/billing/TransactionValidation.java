package ru.leonchenko.springbilling.billing;

import ru.leonchenko.springbilling.entity.FinancialTransaction;

import java.util.logging.Logger;

/**
 * @author Igor Leonchenko
 * @version 1.0
 */

public class TransactionValidation {

    private static Logger log = Logger.getLogger(TransactionValidation.class.getName());

    public static boolean validation(FinancialTransaction financialTransaction) {

        if (financialTransaction.getId() > 0) {
            log.info("Id is valid");
        } else {
            throw new IllegalArgumentException("Id is not valid");
        }

        if (!financialTransaction.getSrcId().equals(financialTransaction.getDstId())) {
            log.info("Source and destination are valid");
        } else {
            throw new IllegalArgumentException("Source and destination are not valid");
        }

        if (financialTransaction.getAmount() > 0) {
            log.info("Amount is valid");
        } else {
            throw new IllegalArgumentException("Amount is not valid");
        }

        return true;
    }
}
