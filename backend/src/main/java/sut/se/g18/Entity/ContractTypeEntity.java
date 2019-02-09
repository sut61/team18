package sut.se.g18.Entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


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
    @NotNull
    private Long contractTypeId;
    @NotNull
    @Column(unique = true)
    private String contractType;

    /**
     * @return the contractTypeId
     */
    public Long getContractTypeId() {
        return contractTypeId;
    }

    /**
     * @param contractTypeId the contractTypeId to set
     */
    public void setContractTypeId(Long contractTypeId) {
        this.contractTypeId = contractTypeId;
    }

    /**
     * @return the contractType
     */
    public String getContractType() {
        return contractType;
    }

    /**
     * @param contractType the contractType to set
     */
    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

}
