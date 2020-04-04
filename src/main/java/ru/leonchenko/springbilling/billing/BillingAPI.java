package ru.leonchenko.springbilling.billing;

import ru.leonchenko.springbilling.entity.FinancialTransaction;

/**
 * @author Igor Leonchenko
 * @version 1.0
 */

public interface BillingAPI {
    boolean send(FinancialTransaction financialTransaction);
}
