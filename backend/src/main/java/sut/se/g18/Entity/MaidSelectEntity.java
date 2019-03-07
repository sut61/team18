package sut.se.g18.Entity;

import lombok.*;
import java.util.Date;
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

    //@NotNull
    @Future
    private Date datepick;
    @NotNull
    @Pattern(regexp = "([ก-ู]|[เ-์]||[0-9]| |-)+")
    @Size(min = 3,max = 40)
    private String workingday;
    @NotNull
    @Pattern(regexp = "([ก-ู]|[เ-์]||[0-9]| )+")
    @Size(min = 3,max = 40)
    private String mainjob;
    @NotNull
    @Pattern(regexp = "([ก-ู]|[เ-์]||[0-9]| )+")
    @Size(min = 3,max = 40)
    private String secondaryjob;
    @NotNull
    @Pattern(regexp = "([ก-ู]|[เ-์]||[0-9]| )+")
    @Size(min = 3,max = 40)
    private String place;

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
     * @return the place
     */
    public String getPlace() {
        return place;
    }

    /**
     * @param place the place to set
     */
    public void setPlace(String place) {
        this.place = place;
    }

    /**
     * @return the secondaryjob
     */
    public String getSecondaryjob() {
        return secondaryjob;
    }

    /**
     * @param secondaryjob the secondaryjob to set
     */
    public void setSecondaryjob(String secondaryjob) {
        this.secondaryjob = secondaryjob;
    }

    /**
     * @return the mainjob
     */
    public String getMainjob() {
        return mainjob;
    }

    /**
     * @param mainjob the mainjob to set
     */
    public void setMainjob(String mainjob) {
        this.mainjob = mainjob;
    }

    /**
     * @return the workingday
     */
    public String getWorkingday() {
        return workingday;
    }

    /**
     * @param workingday the workingday to set
     */
    public void setWorkingday(String workingday) {
        this.workingday = workingday;
    }

    /**
     * @return the datepick
     */
    public Date getDatepick() {
        return datepick;
    }

    /**
     * @param datepick the datepick to set
     */
    public void setDatepick(Date datepick) {
        this.datepick = datepick;
    }

    /**
     * @param maidId the maidId to set
     */
    public void setMaidId(Long maidId) {
        this.maidId = maidId;
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
