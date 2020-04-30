package springbilling;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.leonchenko.springbilling.billing.TransactionValidation;
import ru.leonchenko.springbilling.entity.FinancialTransaction;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author Igor Leonchenko
 * @version 1.0
 */

public class TransactionValidationTest {

    @Autowired
    TransactionValidation transactionValidation;

    FinancialTransaction financialTransaction = new FinancialTransaction(1, 10, 20, 30L);

    @Test
    public void TransactionIdMustPositive() {
        financialTransaction.setId(-1);
        assertThrows(IllegalArgumentException.class, () -> transactionValidation.validation(financialTransaction));
    }

    @Test
    public void TransactionSourceAndDestinationMustVary() {
        financialTransaction.setSrcId(10);
        financialTransaction.setDstId(10);
        assertThrows(IllegalArgumentException.class, () -> transactionValidation.validation(financialTransaction));
    }

    @Test
    public void TransactionAmountMustBePositive() {
        financialTransaction.setAmount(-10L);
        assertThrows(IllegalArgumentException.class, () -> transactionValidation.validation(financialTransaction));
    }

}
