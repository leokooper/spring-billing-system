package ru.leonchenko.springbilling.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.sun.istack.internal.FinalArrayList;
import org.springframework.web.bind.annotation.*;

import ru.leonchenko.springbilling.entity.FinancialTransaction;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Igor Leonchenko
 * @version 1.0
 */


@RestController
@RequestMapping(value = "/api")
class TransactionController {

    private List<FinancialTransaction> financialTransactionList = new ArrayList<>();

    @GetMapping("/transactions")
    private List<FinancialTransaction> getAllTransactions() {

        return financialTransactionList;
    }

    @GetMapping("/transactions/{transactionId}")
    private FinancialTransaction getTransactionById(@PathVariable int transactionId) {

        return financialTransactionList.get(transactionId - 1);
    }

    @PostMapping("/singletransaction")
    private @ResponseBody FinancialTransaction addTransaction(@RequestBody FinancialTransaction financialTransaction) {

        financialTransactionList.add(financialTransaction);
        return financialTransaction;
    }

    @PostMapping("/multitransactions")
    private @ResponseBody List<FinancialTransaction> addTransactionArray(@RequestBody List<FinancialTransaction> financialTransaction) {

        financialTransactionList.addAll(financialTransaction);

        return financialTransactionList;
    }
}

