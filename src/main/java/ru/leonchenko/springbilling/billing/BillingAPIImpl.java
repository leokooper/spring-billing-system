package ru.leonchenko.springbilling.billing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.leonchenko.springbilling.entity.FinancialTransaction;

/**
 * @author Igor Leonchenko
 * @version 1.0
 */

@Component
class BillingAPIImpl implements BillingAPI {

    private boolean isTransactionSucceed;

    @Autowired
    private LoggerContainer loggerContainer;

    @Override
    public void send(FinancialTransaction financialTransaction) {

        if (isTransactionSucceed = TransactionValidation.validation(financialTransaction)) {
            loggerContainer.push(financialTransaction);
        }
    }

}

