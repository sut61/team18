package sut.se.g18.Entity;
import javax.persistence.*;
import lombok.*;

@Entity
@Data
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "CONTRACT")
public class ContractEntity {
    @Id
    @SequenceGenerator(name="contract_seq",sequenceName="contract_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="contract_seq")
    @Column(name="contractId",unique = true, nullable = false)
    private @NonNull Long contractId;

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }
}
