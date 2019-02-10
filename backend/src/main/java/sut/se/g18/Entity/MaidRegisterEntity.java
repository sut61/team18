package sut.se.g18.Entity;
import lombok.*;
import  javax.persistence.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
@Entity
@Data
@Getter @Setter
@ToString
@EqualsAndHashCode
@Table (name = "Register")
public class MaidRegisterEntity {
    @Id
    @SequenceGenerator(name="registerSeq",sequenceName="registerSeq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="registerSeq")
    @Column(name="maidId",unique = true, nullable = false)
    private @NonNull Long maidId;
    @NotNull
    private String maidName;
    @NotNull
    private String maidAddress;
    @Email
    private String maidEmail;
    @NotNull
    @Size(min = 10, max = 10)
    @Pattern(regexp = "^0([0-9])+")
    private String maidPhone;
    @NotNull
    private String province;
    @NotNull
    private String district;
    @NotNull
    private String canton;

    

    //Many To One with Company
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = CompanyEntity.class)
    private CompanyEntity companyForMaid;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = TitleNameEntity.class)
    private TitleNameEntity titleNameEntity;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = TypeworkingEntity.class)
    private TypeworkingEntity typeworkingEntity;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = WorkingDateEntity.class)
    private WorkingDateEntity workingDateEntity;

    //Many To One with WelfareAndSalaryEntity
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = WelfareAndSalaryEntity.class)
    private WelfareAndSalaryEntity welfareAndSalaryEntity;


    public MaidRegisterEntity(){}
    public MaidRegisterEntity(String maidName, String maidAddress, String maidEmail, String maidPhone, String province,
                              String district, String canton, TitleNameEntity titleNameEntity, TypeworkingEntity typeworkingEntity,
                              WorkingDateEntity workingDateEntity,WelfareAndSalaryEntity welfareAndSalaryEntity,CompanyEntity companyForMaid){
            this.maidName=maidName;
            this.maidAddress=maidAddress;
            this.maidEmail=maidEmail;
            this.maidPhone=maidPhone;
            this.province=province;
            this.district=district;
            this.canton=canton;
            this.titleNameEntity = titleNameEntity;
            this.typeworkingEntity = typeworkingEntity;
            this.workingDateEntity = workingDateEntity;
            this.companyForMaid = companyForMaid;
            this.welfareAndSalaryEntity = welfareAndSalaryEntity;
            

    }

    public Long getMaidId() {
        return maidId;
    }
    public void setMaidId(Long maidId) {
        this.maidId = maidId;
    }
    public String getMaidName() {
        return maidName;
    }
    public void setMaidName(String maidName) {
        this.maidName = maidName;
    }
    public String getMaidAddress() {
        return maidAddress;
    }
    public void setMaidAddress(String maidAddress) {
        this.maidAddress = maidAddress;
    }
    public String getMaidEmail() {
        return maidEmail;
    }
    public void setMaidEmail(String maidEmail) {
        this.maidEmail = maidEmail;
    }
    public String getMaidPhone() {
        return maidPhone;
    }
    public void setMaidPhone(String maidPhone) {
        this.maidPhone = maidPhone;
    }
    public String getProvince() { return province; }
    public void setProvince(String province) { this.province = province; }
    public String getDistrict() { return district; }
    public void setDistrict(String district) { this.district = district; }
    public String getCanton() { return canton; }
    public void setCanton(String canton) { this.canton = canton; }
    public TitleNameEntity getTitleNameEntity() {
        return titleNameEntity;
    }
    public void setTitleNameEntity(TitleNameEntity titleNameEntity) {
        this.titleNameEntity = titleNameEntity;
    }
    public TypeworkingEntity getTypeworkingEntity() {
        return typeworkingEntity;
    }
    public void setTypeworkingEntity(TypeworkingEntity typeworkingEntity) {
        this.typeworkingEntity = typeworkingEntity;
    }

    public CompanyEntity getCompanyForMaid() {
        return companyForMaid;
    }

    public void setCompanyForMaid(CompanyEntity companyForMaid) {
        this.companyForMaid = companyForMaid;
    }

    public WorkingDateEntity getWorkingDateEntity() {
        return workingDateEntity;
    }
    public void setWorkingDateEntity(WorkingDateEntity workingDateEntity) {
        this.workingDateEntity = workingDateEntity;
    }

    /**
     * @return the welfareAndSalaryEntity
     */
    public WelfareAndSalaryEntity getWelfareAndSalaryEntity() {
        return welfareAndSalaryEntity;
    }

    /**
     * @param welfareAndSalaryEntity the welfareAndSalaryEntity to set
     */
    public void setWelfareAndSalaryEntity(WelfareAndSalaryEntity welfareAndSalaryEntity) {
        this.welfareAndSalaryEntity = welfareAndSalaryEntity;
    }
   
}
