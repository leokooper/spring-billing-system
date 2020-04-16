package ru.leonchenko.springbilling.billing;

import org.springframework.stereotype.Component;
import ru.leonchenko.springbilling.entity.FinancialTransaction;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


/**
 * @author Igor Leonchenko
 * @version 1.0
 */

@Component
public class LoggerContainerImpl implements Runnable, LoggerContainer {

    private List<FinancialTransaction> financialTransactions;

    public LoggerContainerImpl(List<FinancialTransaction> financialTransactions) {
        this.financialTransactions = financialTransactions;
    }

    private BlockingQueue<FinancialTransaction> financialTransactionList = new LinkedBlockingQueue<>();

    public void push(FinancialTransaction financialTransaction) {
        financialTransactionList.add(financialTransaction);
    }

    @Override
    public void run() {
        financialTransactionList.drainTo(financialTransactions);
    }
}

