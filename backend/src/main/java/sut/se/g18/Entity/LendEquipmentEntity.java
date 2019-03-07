package sut.se.g18.Entity;

import lombok.*;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.*;

@Data
@Entity
@Getter 
@Setter

//@NoArgsConstructor
@ToString 
@EqualsAndHashCode
@Table (name = " LendEquipmentEntity ")
public class LendEquipmentEntity {
    @Id 
    @SequenceGenerator(name="lendId_seq",sequenceName="lendId_seq")     
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="lendId_seq")
    private @NonNull Long lendId;

    @NotNull
    private Date lendstart;

    @NotNull
    private Date lendend;

    @NotNull
    @Column(unique = true)
    @Size(min = 3,max = 40)
    @Pattern(regexp = "([ก-ู]|[เ-์]||[0-9]| )+")
    private String lendData;

    //---ของอุปกรณ์----
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = CleaningEquipmentEntity.class)
    private CleaningEquipmentEntity cleaningEquipmentEntity;

   

    //----ของลูกค้า-----
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = CustomerEntity.class)
    private CustomerEntity customerEntity;

    //----ของแม่บ้าน-----
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = MaidRegisterEntity.class)
    private MaidRegisterEntity maidregisterEntity;

    public LendEquipmentEntity(){
        
    }
    

    public LendEquipmentEntity(String lendData2, Date lendstart2, Date lendend2, CleaningEquipmentEntity clean,
			CustomerEntity cuss, MaidRegisterEntity med) {
                this.lendData=lendData2;
                this.lendstart=lendstart2;
                this.lendend=lendend2;
                this.cleaningEquipmentEntity=clean;
                this.customerEntity=cuss;
                this.maidregisterEntity=med;
                
	}

    public Long getLendId() {
        return lendId;
    }
    public void setLendId(Long lendId) {
        this.lendId = lendId;
    }
    public Date getLendstart() {
        return lendstart;
    }
    public void setLendstart(Date date) {
        this.lendstart = date;
    }
    public Date getLendend() {
        return lendend;
    }
    public void setLendend(Date lendend) {
        this.lendend = lendend;
    }
    public String getLendData() {
        return lendData;
    }
    public void setLendData(String lendData) {
        this.lendData = lendData;
    }
    public CleaningEquipmentEntity getCleaningEquipmentEntity() {
        return cleaningEquipmentEntity;
    }
    public void setCleaningEquipmentEntity(CleaningEquipmentEntity cleaningEquipmentEntity) {
        this.cleaningEquipmentEntity = cleaningEquipmentEntity;
    }
    public CustomerEntity getCustomerEntity() {
        return customerEntity;
    }
    public void setCustomerEntity(CustomerEntity customerEntity) {
        this.customerEntity = customerEntity;
    }
    public MaidRegisterEntity getMaidregisterEntity() {
        return maidregisterEntity;
    }
    public void setMaidregisterEntity(MaidRegisterEntity maidregisterEntity) {
        this.maidregisterEntity = maidregisterEntity;
    }

    
    

}