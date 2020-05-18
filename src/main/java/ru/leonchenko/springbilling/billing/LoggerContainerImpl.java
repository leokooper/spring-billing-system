package ru.leonchenko.springbilling.billing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ru.leonchenko.springbilling.entity.FinancialTransaction;
import ru.leonchenko.springbilling.utility.TransactionMerger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


/**
 * @author Igor Leonchenko
 * @version 1.0
 */

@Component
public class LoggerContainerImpl implements LoggerContainer {

    private static Logger logger = LoggerFactory.getLogger(TransactionValidation.class);

    private ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

    private List<FinancialTransaction> financialTransactionDB = new ArrayList<>();

    private List<FinancialTransaction> mergedFinancialTransactionTempList = new ArrayList<>();

    private BlockingQueue<FinancialTransaction> financialTransactionBQ = new LinkedBlockingQueue<>();

    @PostConstruct
    public void drainToArrayJob() {
        Runnable runnable = () -> {
            financialTransactionBQ.drainTo(financialTransactionDB);
            System.out.println("Financial transaction: " + financialTransactionDB);
            logger.debug("Collection drained!");
            mergedFinancialTransactionTempList.addAll(TransactionMerger.mergeTransactions(financialTransactionDB).values());
            System.out.println("Merged DFTTemp: " + mergedFinancialTransactionTempList);
        };
        executorService.scheduleAtFixedRate(runnable, 0, 5, TimeUnit.SECONDS);
    }

    public void push(FinancialTransaction financialTransaction) {
        financialTransactionBQ.add(financialTransaction);
    }

    public List<FinancialTransaction> getFinancialTransactionDB() {
        return financialTransactionDB;
    }

    @PreDestroy
    public void shutdown() {
        executorService.shutdown();
    }
}

