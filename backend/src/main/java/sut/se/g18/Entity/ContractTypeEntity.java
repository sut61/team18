package sut.se.g18.Entity;

import lombok.*;

import javax.persistence.*;


@Entity
@Data
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "CONTRACTTYPE")
public class ContractTypeEntity {
    @Id
    @SequenceGenerator(name="contractType_seq",sequenceName="contractType_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="contractType_seq")
    @Column(name="contractTypeId",unique = true, nullable = false)
    private @NonNull Long contractTypeId;
    private  @NonNull String contractType;

    public Long getContractTypeId() {
        return contractTypeId;
    }

    public void setContractTypeId(Long contractTypeId) {
        this.contractTypeId = contractTypeId;
    }

    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }
}
