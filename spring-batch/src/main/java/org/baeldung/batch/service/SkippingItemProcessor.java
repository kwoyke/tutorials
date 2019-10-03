package org.baeldung.batch.service;

import org.baeldung.batch.model.Transaction;
import org.springframework.batch.item.ItemProcessor;

public class SkippingItemProcessor implements ItemProcessor<Transaction, Transaction> {

    private static final int MAX_USER_ID = 2000;

    @Override
    public Transaction process(Transaction transaction) throws Exception {
        System.out.println("Processing : " + transaction);

        int userId = transaction.getUserId();
        if(userId > MAX_USER_ID){
            String message = String.format("User ID (%d) exceeds maximum value allowed", userId);
            System.out.println(message);
            throw new InvalidIdException(message);
        }

        return transaction;
    }
}
