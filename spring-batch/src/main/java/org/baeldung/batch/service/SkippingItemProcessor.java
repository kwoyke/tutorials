package org.baeldung.batch.service;

import org.baeldung.batch.model.Transaction;
import org.springframework.batch.item.ItemProcessor;

public class SkippingItemProcessor implements ItemProcessor<Transaction, Transaction> {

    @Override
    public Transaction process(Transaction transaction) {

        System.out.println("SkippingItemProcessor: " + transaction);

        if (transaction.getUsername() == null || transaction.getUsername().isEmpty()) {
            throw new MissingUsernameException();
        }

        if (transaction.getAmount() < 0) {
            throw new NegativeAmountException();
        }

        return transaction;
    }
}
