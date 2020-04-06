package ru.leonchenko.springbilling.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;


import ru.leonchenko.springbilling.billing.BillingAPI;
import ru.leonchenko.springbilling.entity.FinancialTransaction;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Igor Leonchenko
 * @version 1.0
 */

@RestController
@RequestMapping(value = "/api")
public class TransactionController {

    @Autowired
    private BillingAPI billingAPI;

    private List<FinancialTransaction> financialTransactionList = new ArrayList<>();

    private boolean isTransactionSucceed;

    @GetMapping("/transactions")
    public List<FinancialTransaction> getAllTransactions() {

        return financialTransactionList;
    }

    @GetMapping("/transactions/{transactionId}")
    public FinancialTransaction getTransactionById(@PathVariable int transactionId) {

        return financialTransactionList.get(transactionId - 1);
    }

    @PostMapping("/transaction")
    public @ResponseBody
    FinancialTransaction addTransaction(@RequestBody FinancialTransaction financialTransaction) {

        isTransactionSucceed = billingAPI.send(financialTransaction);

        if (isTransactionSucceed)
            financialTransactionList.add(financialTransaction);
        return financialTransaction;
    }

    @PostMapping("/transactions")
    public @ResponseBody
    List<FinancialTransaction> addTransactionArray(@RequestBody List<FinancialTransaction> financialTransactions) {

        for (FinancialTransaction financialTransaction : financialTransactions) {

            isTransactionSucceed = billingAPI.send(financialTransaction);

            if (isTransactionSucceed)
                financialTransactionList.add(financialTransaction);
        }
        return financialTransactionList;
    }
}

