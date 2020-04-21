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

    private LoggerContainer loggerContainer;

    @Autowired
    public BillingAPIImpl(LoggerContainer loggerContainer) {
        this.loggerContainer = loggerContainer;
    }

    @Override
    public void send(FinancialTransaction financialTransaction) {

        if (TransactionValidation.validation(financialTransaction)) {
            loggerContainer.push(financialTransaction);
        }
    }

}

