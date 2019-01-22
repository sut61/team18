package sut.se.g18.Entity;

import lombok.*;
import javax.persistence.*;

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
    private @NonNull Long  bankId;
    private @NonNull String bankName;
    

    
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