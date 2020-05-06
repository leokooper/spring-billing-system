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
    public void transactionIdMustPositive_NegativeValue() {
        financialTransaction.setId(-1);
        assertThrows(IllegalArgumentException.class, () -> transactionValidation.validation(financialTransaction));
    }

    @Test
    public void transactionIdMustPositive_ZeroValue() {
        financialTransaction.setId(0);
        assertThrows(IllegalArgumentException.class, () -> transactionValidation.validation(financialTransaction));
    }

    @Test
    public void transactionSourceAndDestinationMustVary_EachPos() {
        financialTransaction.setSrcId(10);
        financialTransaction.setDstId(10);
        assertThrows(IllegalArgumentException.class, () -> transactionValidation.validation(financialTransaction));
    }


    @Test
    public void transactionSourceAndDestinationMustVary_PosAndNeg() {
        financialTransaction.setSrcId(10);
        financialTransaction.setDstId(-10);
        assertThrows(IllegalArgumentException.class, () -> transactionValidation.validation(financialTransaction));
    }

    @Test
    public void transactionSourceAndDestinationMustVary_NegAndPos() {
        financialTransaction.setSrcId(-10);
        financialTransaction.setDstId(10);
        assertThrows(IllegalArgumentException.class, () -> transactionValidation.validation(financialTransaction));
    }

    @Test
    public void transactionSourceAndDestinationMustVary_EachNeg() {
        financialTransaction.setSrcId(-10);
        financialTransaction.setDstId(-10);
        assertThrows(IllegalArgumentException.class, () -> transactionValidation.validation(financialTransaction));
    }

    @Test
    public void transactionAmountMustBePositive_NegativeValue() {
        financialTransaction.setAmount(-10L);
        assertThrows(IllegalArgumentException.class, () -> transactionValidation.validation(financialTransaction));
    }

    @Test
    public void transactionAmountMustBePositive_ZeroValue() {
        financialTransaction.setAmount(0L);
        assertThrows(IllegalArgumentException.class, () -> transactionValidation.validation(financialTransaction));
    }

}
