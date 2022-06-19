package itfbstudy.transactionservise.enteties;

import lombok.Getter;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;
import org.hibernate.annotations.Type;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "TRANSACTION")
@Getter
@Setter
public class Transaction {
    @Id
    @Getter
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Type(type = "org.hibernate.type.TextType")
    @Column(nullable = false)
    private String operation;

    @NotNull
    @Column(name = "GUID",unique = true,nullable = false)
    private String guid;
}
