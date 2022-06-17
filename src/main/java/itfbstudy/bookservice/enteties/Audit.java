package itfbstudy.bookservice.enteties;

import itfbstudy.bookservice.enums.Reference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "AUDIT")
@NoArgsConstructor
public class Audit {
    public Audit(String operation, Reference.AuditStatus status, String category){
        this.operation = operation;
        this.status = status;
        this.category = category;
    }

    @Id
    @Getter
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "operation")
    private String operation;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Reference.AuditStatus status;

    @Column(name = "category")
    private String category;

    @Column(name = "call_datetime")
    @CreationTimestamp
    private LocalDateTime call_datetime;
}
