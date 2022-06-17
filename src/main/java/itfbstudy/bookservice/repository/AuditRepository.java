package itfbstudy.bookservice.repository;

import itfbstudy.bookservice.enteties.Audit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface AuditRepository extends JpaRepository<Audit, Integer> {
}