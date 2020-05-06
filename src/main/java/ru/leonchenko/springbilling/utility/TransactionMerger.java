package ru.leonchenko.springbilling.utility;

import ru.leonchenko.springbilling.entity.FinancialTransaction;

import java.util.List;
import java.util.Map;

/**
 * @author Igor Leonchenko
 * @version 1.0
 */

public class TransactionMerger {
    public static void mergeTransactions(List<FinancialTransaction> financialTransactions, Map<String, Long> mergedTransactions) {

        for (FinancialTransaction ft: financialTransactions) {

            String key = ft.getSrcId() + "" + ft.getDstId();
            Long value = ft.getAmount();

            mergedTransactions.merge(key, value, Long::sum);

        }
        financialTransactions.clear();
    }
}
