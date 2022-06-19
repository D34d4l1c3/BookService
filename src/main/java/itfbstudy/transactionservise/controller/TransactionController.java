package itfbstudy.transactionservise.controller;

import itfbstudy.transactionservise.enteties.Transaction;
import itfbstudy.transactionservise.exception.TransactionError;
import itfbstudy.transactionservise.service.TransactionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {
    private TransactionService service;
    public TransactionController(TransactionService service){
        this.service = service;
    }
    @PostMapping("transaction/add")
    public Transaction addTransaction(@RequestBody Transaction transaction) throws TransactionError {
        return service.addTransaction(transaction);
    }

}
