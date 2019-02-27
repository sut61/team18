package sut.se.g18.Entity;
import javax.persistence.*;
import javax.validation.constraints.*;

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
    @NotNull
    private Long contractId;
    @NotNull
    @Future
    private Date dateStart;
    @NotNull
    @Min(value = 300)
    @Max(value = 99999)
    @Positive
    private int cost;
    //เพิ่ม datail เพื่อเช็ค Null   Size   Pattern
    @NotNull
    @Size(min = 7,max = 30)
    @Pattern(regexp = "^ทำสัญญา([ก-ู]|[เ-์])+")
    private String detail;

    //Many To One with Promotion
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = PromotionEntity.class)
    private PromotionEntity promotion;

    //Many To One with Company
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = CompanyEntity.class)
    private CompanyEntity company;

    //Many To One with PaymentStatus
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = PaymentStatusEntity.class)
    private PaymentStatusEntity status;

    //Many To One with ContractType
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = ContractTypeEntity.class)
    private ContractTypeEntity contractType;

    //One To One with MaidSelectEntity
    @NotNull
    @OneToOne(fetch = FetchType.EAGER,targetEntity = MaidSelectEntity.class)
    private MaidSelectEntity maid;

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
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

    public PaymentStatusEntity getStatus() {
        return status;
    }

    public void setStatus(PaymentStatusEntity status) {
        this.status = status;
    }

    public ContractTypeEntity getContractType() {
        return contractType;
    }

    public void setContractType(ContractTypeEntity contractType) {
        this.contractType = contractType;
    }

    public MaidSelectEntity getMaid() {
        return maid;
    }

    public void setMaid(MaidSelectEntity maid) {
        this.maid = maid;
    }
}
