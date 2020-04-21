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
import ru.leonchenko.springbilling.billing.LoggerContainer;
import ru.leonchenko.springbilling.entity.FinancialTransaction;
import java.util.List;

/**
 * @author Igor Leonchenko
 * @version 1.0
 */

@RestController
@RequestMapping(value = "/api")
public class TransactionController {

    private BillingAPI billingAPI;

    private LoggerContainer loggerContainer;

    @Autowired
    public TransactionController(BillingAPI billingAPI, LoggerContainer loggerContainer) {
        this.billingAPI = billingAPI;
        this.loggerContainer = loggerContainer;
    }

    @GetMapping("/transactions")
    public List<FinancialTransaction> getAllTransactions() {

        return loggerContainer.getFinancialTransactionDB();
    }

    @GetMapping("/transactions/{transactionId}")
    public FinancialTransaction getTransactionById(@PathVariable int transactionId) {

        return loggerContainer.getFinancialTransactionDB().get(transactionId - 1);
    }

    @PostMapping("/transaction")
    public @ResponseBody
    FinancialTransaction addTransaction(@RequestBody FinancialTransaction financialTransaction) {

        billingAPI.send(financialTransaction);

        return financialTransaction;
    }

    @PostMapping("/transactions")
    public @ResponseBody
    List<FinancialTransaction> addTransactionArray(@RequestBody List<FinancialTransaction> financialTransactions) {

        for (FinancialTransaction financialTransaction : financialTransactions) {

            billingAPI.send(financialTransaction);
        }

        return loggerContainer.getFinancialTransactionDB();
    }
}

