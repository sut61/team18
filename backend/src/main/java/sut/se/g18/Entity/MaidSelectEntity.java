package sut.se.g18.Entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "MAID")
public class MaidSelectEntity {
    @Id
    @SequenceGenerator(name = "maid_seq", sequenceName = "maid_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "maid_seq")
    @Column(name = "maidId", unique = true, nullable = false)
    private @NotNull Long maidId;

    @NotNull
    @Size(min = 15, max = 50)
    @Column(unique = true)
    @Email
    private String maidEmail;

    // Many To One with Customer
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = CustomerEntity.class)
    private CustomerEntity customer;

    // Many To One with MaidRegister
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = MaidRegisterEntity.class)
    private MaidRegisterEntity maid;

    // Many To One with Company
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = CompanyEntity.class)
    private CompanyEntity companyForMaid;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = TypeworkingEntity.class)
    private TypeworkingEntity typeworkingEntity;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = WorkingDateEntity.class)
    private WorkingDateEntity workingDateEntity;

    // Many To One with MaidStatus
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = MaidStatusEntity.class)
    private MaidStatusEntity status;

    /**
     * @return the maidId
     */
    public Long getMaidId() {
        return maidId;
    }

    /**
     * @param maidId the maidId to set
     */
    public void setMaidId(Long maidId) {
        this.maidId = maidId;
    }

    /**
     * @return the maidEmail
     */
    public String getMaidEmail() {
        return maidEmail;
    }

    /**
     * @param maidEmail the maidEmail to set
     */
    public void setMaidEmail(String maidEmail) {
        this.maidEmail = maidEmail;
    }

    /**
     * @return the customer
     */
    public CustomerEntity getCustomer() {
        return customer;
    }

    /**
     * @param customer the customer to set
     */
    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    /**
     * @return the maid
     */
    public MaidRegisterEntity getMaid() {
        return maid;
    }

    /**
     * @param maid the maid to set
     */
    public void setMaid(MaidRegisterEntity maid) {
        this.maid = maid;
    }

    /**
     * @return the companyForMaid
     */
    public CompanyEntity getCompanyForMaid() {
        return companyForMaid;
    }

    /**
     * @param companyForMaid the companyForMaid to set
     */
    public void setCompanyForMaid(CompanyEntity companyForMaid) {
        this.companyForMaid = companyForMaid;
    }

    /**
     * @return the typeworkingEntity
     */
    public TypeworkingEntity getTypeworkingEntity() {
        return typeworkingEntity;
    }

    /**
     * @param typeworkingEntity the typeworkingEntity to set
     */
    public void setTypeworkingEntity(TypeworkingEntity typeworkingEntity) {
        this.typeworkingEntity = typeworkingEntity;
    }

    /**
     * @return the workingDateEntity
     */
    public WorkingDateEntity getWorkingDateEntity() {
        return workingDateEntity;
    }

    /**
     * @param workingDateEntity the workingDateEntity to set
     */
    public void setWorkingDateEntity(WorkingDateEntity workingDateEntity) {
        this.workingDateEntity = workingDateEntity;
    }

    /**
     * @return the status
     */
    public MaidStatusEntity getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(MaidStatusEntity status) {
        this.status = status;
    }

    
}
