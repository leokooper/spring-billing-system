package ru.leonchenko.springbilling.billing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.leonchenko.springbilling.entity.FinancialTransaction;

/**
 * @author Igor Leonchenko
 * @version 1.0
 */

public class TransactionValidation {

    private static Logger logger = LoggerFactory.getLogger(TransactionValidation.class);

        public static void validation(FinancialTransaction financialTransaction) {

        if (financialTransaction.getId() <= 0) {
            logger.error("Financial transaction id " + financialTransaction.getId() + " isn't valid");
            throw new IllegalArgumentException("Financial transaction id " + financialTransaction.getId() + " isn't valid");
        }

        if (financialTransaction.getSrcId().equals(financialTransaction.getDstId())) {
            logger.error("In transaction Id " + financialTransaction.getId() + " src and dst are equals");
            throw new IllegalArgumentException("In transaction Id " + financialTransaction.getId() + " src and dst are equals");
        }

        if (financialTransaction.getAmount() <= 0) {
            logger.error("In transaction Id " + financialTransaction.getId() + " amount isn't valid");
            throw new IllegalArgumentException("In transaction Id " + financialTransaction.getId() + " amount isn't valid");
        }

    }
}
