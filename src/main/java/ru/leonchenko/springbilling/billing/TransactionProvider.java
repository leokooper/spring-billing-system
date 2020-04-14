package ru.leonchenko.springbilling.billing;

import java.util.List;
import java.util.concurrent.BlockingQueue;

/**
 * @author Igor Leonchenko
 * @version 1.0
 */

public interface TransactionProvider {
    public void drainToDB(BlockingQueue srcCollection, List dstCollection);
}
