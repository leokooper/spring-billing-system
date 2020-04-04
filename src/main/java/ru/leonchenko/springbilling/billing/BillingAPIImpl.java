package ru.leonchenko.springbilling.billing;

import org.springframework.stereotype.Component;
import ru.leonchenko.springbilling.entity.FinancialTransaction;

/**
 * @author Igor Leonchenko
 * @version 1.0
 */

@Component
class BillingAPIImpl implements BillingAPI {

    @Override
    public boolean send(FinancialTransaction financialTransaction) {

        return new TransactionValidation().validation(financialTransaction);

    }
}

