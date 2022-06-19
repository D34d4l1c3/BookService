package itfbstudy.transactionservise.repository;

import itfbstudy.transactionservise.enteties.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    @Transactional
    public Transaction findByGuid(String guid);
}