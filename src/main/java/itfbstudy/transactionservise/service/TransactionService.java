package itfbstudy.transactionservise.service;

import itfbstudy.transactionservise.enteties.Transaction;
import itfbstudy.transactionservise.exception.TransactionError;
import itfbstudy.transactionservise.repository.TransactionRepository;
import org.springframework.stereotype.Service;


@Service
public class TransactionService {
    private final TransactionRepository repository;

    public TransactionService(TransactionRepository repository) {
        this.repository = repository;
    }

    public Transaction addTransaction(Transaction transaction) throws TransactionError {
        Transaction t = repository.findByGuid(transaction.getGuid());
        if(repository.findByGuid(transaction.getGuid()) != null) {
            throw new TransactionError();
        }
        return repository.save(transaction);
    }
}

