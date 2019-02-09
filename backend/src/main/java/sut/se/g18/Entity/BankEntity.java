package sut.se.g18.Entity;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@Entity
@Table(name = "bank")
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Getter @Setter
public class BankEntity {
    @Id
    @SequenceGenerator(name = "bank_seq",sequenceName = "bank_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "bank_seq")
    @Column(name = "bank_id",unique = true, nullable = false)
    private @NotNull Long  bankId;
    @Pattern(regexp = "^ธนาคาร([ก-ู]|[เ-์])+")@Column(unique=true)
    private @NotNull String bankName;
    

    
    public Long getBankid() {
        return bankId;
    }

    public void setBankid(Long bankid) {
        this.bankId = bankid;
    }

    public String getBankname() {
        return bankName;
    }

    public void setBankname(String bankname) {
        this.bankName = bankname;
    }
}