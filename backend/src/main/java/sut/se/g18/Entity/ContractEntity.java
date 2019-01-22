package sut.se.g18.Entity;
import javax.persistence.*;
import lombok.*;

import java.util.Date;

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
    private  @NonNull Date dateStart;

    //Many To One with Promotion
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = PromotionEntity.class)
    private PromotionEntity promotion;

    //Many To One with Company
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = CompanyEntity.class)
    private CompanyEntity company;

    //Many To One with PaymentStatus
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = PaymentStatusEntity.class)
    private PaymentStatusEntity status;

    //Many To One with ContractType
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = ContractTypeEntity.class)
    private ContractTypeEntity contractType;

    //Many To One with Customer
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = CustomerEntity.class)
    private CustomerEntity customer;

    //One To One with MaidSelectEntity
    @OneToOne(fetch = FetchType.EAGER,targetEntity = MaidSelectEntity.class)
    private MaidSelectEntity maid;

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public PromotionEntity getPromotion() {
        return promotion;
    }

    public void setPromotion(PromotionEntity promotion) {
        this.promotion = promotion;
    }

    public CompanyEntity getCompany() {
        return company;
    }

    public void setCompany(CompanyEntity company) {
        this.company = company;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    public MaidSelectEntity getMaid() {
        return maid;
    }

    public void setMaid(MaidSelectEntity maid) {
        this.maid = maid;
    }

    public ContractTypeEntity getContractType() {
        return contractType;
    }

    public void setContractType(ContractTypeEntity contractType) {
        this.contractType = contractType;
    }

    public PaymentStatusEntity getStatus() {
        return status;
    }

    public void setStatus(PaymentStatusEntity status) {
        this.status = status;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }
}
