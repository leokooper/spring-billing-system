package ru.leonchenko.springbilling.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import ru.leonchenko.springbilling.entity.FinancialTransaction;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author Igor Leonchenko
 * @version 1.0
 */


//@Controller
@RestController
@RequestMapping(value = "/test", method = RequestMethod.GET)
public class TransactionController {

    File file = new File("/Users/leokooper/git/spring-billing-system/json/sample.json");
    ObjectMapper objectMapper = new ObjectMapper();
    TypeFactory typeFactory = objectMapper.getTypeFactory();
    List<FinancialTransaction> financialTransactionList;

    {
        try {
            financialTransactionList = objectMapper.readValue(file, typeFactory.constructCollectionType(List.class, FinancialTransaction.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/transactions")
    List<FinancialTransaction> getAllTransactions() {

        return financialTransactionList;
    }

    @GetMapping("/transactions/{transactionId}")
    public FinancialTransaction getTransactionById(@PathVariable int transactionId) {
        FinancialTransaction financialTransaction = financialTransactionList.get(transactionId - 1);

        return financialTransaction;
    }
}

