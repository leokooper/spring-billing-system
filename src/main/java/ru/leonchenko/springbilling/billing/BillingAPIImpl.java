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
    public TransactionStatus send(FinancialTransaction financialTransaction) {

        if ((financialTransaction.getId() > 0)
                && (!financialTransaction.getSrcId().equals(financialTransaction.getDstId()))
                && (financialTransaction.getAmount() > 0)) {
            return TransactionStatus.OK;
        } else {
            return TransactionStatus.FALSE;
        }
    }

}
