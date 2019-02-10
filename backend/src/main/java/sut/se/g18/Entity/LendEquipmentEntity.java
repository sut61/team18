package sut.se.g18.Entity;

import lombok.*;
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

    @Column(unique = true)
    @NotNull 
    @Size(min = 3,max = 40)
    @Pattern(regexp = "([ก-ู]|[เ-์]||[0-9]| )+")
    private String lendData;

    //---ของอุปกรณ์----
    @NotNull
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cleaningId")
    private CleaningEquipmentEntity cleaningEquipmentEntity;

    //---ของไฟฟ้า----
    @NotNull
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "electricId")
    private ElectricalEquipmentEntity electricalEquipmentEntity;

    //----ของลูกค้า-----
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER )
    @JoinColumn(name= "customerId")
    private CustomerEntity customerEntity;

    //----ของแม่บ้าน-----
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER )
    @JoinColumn(name= "maidId")
    private MaidRegisterEntity maidregisterEntity;

    public LendEquipmentEntity(){
        
    }
    public  LendEquipmentEntity(String lendData,CleaningEquipmentEntity cleaningEquipmentEntity
    ,ElectricalEquipmentEntity electricalEquipmentEntity,CustomerEntity customerEntity,MaidRegisterEntity maidregisterEntity) {

        this.lendData=lendData;
        this.cleaningEquipmentEntity=cleaningEquipmentEntity;
        this.electricalEquipmentEntity=electricalEquipmentEntity;
        this.customerEntity = customerEntity;
        this.maidregisterEntity = maidregisterEntity;
    }
    public Long getLendId() {
        return lendId;
    }
    public void setLendId(Long lendId) {
        this.lendId = lendId;
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
    public ElectricalEquipmentEntity getElectricalEquipmentEntity() {
        return electricalEquipmentEntity;
    }
    public void setElectricalEquipmentEntity(ElectricalEquipmentEntity electricalEquipmentEntity) {
        this.electricalEquipmentEntity = electricalEquipmentEntity;
    }
    public CustomerEntity getCustomerEntity() {
        return customerEntity;
    }
    public void setCustomerEntity(CustomerEntity customerEntity) {
        this.customerEntity = customerEntity;
    }
    public MaidRegisterEntity getRegisterEntity() {
        return maidregisterEntity;
    }
    public void setRegisterEntity(MaidRegisterEntity maidregisterEntity) {
        this.maidregisterEntity = maidregisterEntity;
    }

}