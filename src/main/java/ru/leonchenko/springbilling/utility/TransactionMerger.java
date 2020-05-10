package ru.leonchenko.springbilling.utility;

import ru.leonchenko.springbilling.entity.FinancialTransaction;
import ru.leonchenko.springbilling.entity.MergedFinancialTransaction;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Igor Leonchenko
 * @version 1.0
 */

public class TransactionMerger {

    public static List<MergedFinancialTransaction> mergeTransactions(List<FinancialTransaction> financialTransactions) {

        Map<String, Long> mergedTransactions = new HashMap<>();

        for (FinancialTransaction ft: financialTransactions) {

            String key = ft.getSrcId() + "" + ft.getDstId();

            Long value = ft.getAmount();

            mergedTransactions.merge(key, value, Long::sum);

        }

        financialTransactions.clear();

        return mergedTransactions.entrySet()
                            .stream()
                            .map(e ->
                            new MergedFinancialTransaction(e.getKey(), e.getValue()))
                            .collect(Collectors.toList());

    }
}
