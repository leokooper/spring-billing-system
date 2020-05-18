package ru.leonchenko.springbilling.utility;

import ru.leonchenko.springbilling.entity.FinancialTransaction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Igor Leonchenko
 * @version 1.0
 */

public class TransactionMerger {

    public static Map<String, FinancialTransaction> mergeTransactions(List<FinancialTransaction> financialTransactions) {

        Map<String, FinancialTransaction> mergedTransactions = new HashMap<>();

        for (FinancialTransaction ft: financialTransactions) {

            String key = ft.getSrcId() + "/" + ft.getDstId();

            if (mergedTransactions.containsKey(key)) {
                mergedTransactions.get(key).setAmount(mergedTransactions.get(key).getAmount() + ft.getAmount());
            } else {
                FinancialTransaction financialTransaction = new FinancialTransaction();
                financialTransaction.setSrcId(ft.getSrcId());
                financialTransaction.setDstId(ft.getDstId());
                financialTransaction.setAmount(ft.getAmount());
                mergedTransactions.put(key, financialTransaction);
            }
        }

        financialTransactions.clear();
        return mergedTransactions;
    }

}
