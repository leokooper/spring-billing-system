package ru.leonchenko.springbilling.billing;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author Igor Leonchenko
 * @version 1.0
 */

@Component
public class TransactionProviderImpl implements TransactionProvider{
    @Override
    public void drainToDB(BlockingQueue srcCollection, List dstCollection){
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        Runnable drain = new Runnable() {
            @Override
            public void run() {
                srcCollection.drainTo(dstCollection);
            }
        };
        executorService.schedule(drain, 5, TimeUnit.SECONDS);
    }
}
