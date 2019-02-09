package sut.se.g18.Entity;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "payment")
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Getter @Setter
public class PaymentEntity {
    @Id
    @SequenceGenerator(name = "pay_seq",sequenceName = "pay_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "pay_seq")
    @Column(name = "pay_id",unique = true, nullable = false)
    private @NotNull Long payId;
    private @NotNull String name;
    private @NotNull String address;
    private @NotNull @Size(min=9,max=10) @Pattern(regexp="([0-9])+")String phonenum;
    private @NotNull String accountNumber;

    

    
    //many-to-one  with bankEntity
    @ManyToOne(fetch = FetchType.EAGER ,targetEntity = BankEntity.class)
    private BankEntity bankEntity;

   
    //many-to-one with CustomerEntity
    @ManyToOne(fetch = FetchType.EAGER ,targetEntity = CustomerEntity.class)
    private CustomerEntity customerEntity;


    //many-to-one with typepaymentEntity
    @ManyToOne(fetch = FetchType.EAGER ,targetEntity = TypepaymentEntity.class)
    private TypepaymentEntity typepaymentEntity;

    //one-to-one with ContractEntity
    @OneToOne(fetch = FetchType.EAGER , targetEntity = ContractEntity.class)
    private ContractEntity contractEntity;
    
    public CustomerEntity getCustomerEntity() {
        return this.customerEntity;
    }

    public void setCustomerEntity(CustomerEntity customerEntity) {
        this.customerEntity = customerEntity;
    }
    public ContractEntity getContractEntity() {
        return this.contractEntity;
    }

    public void setContractEntity(ContractEntity contractEntity) {
        this.contractEntity = contractEntity;
    }
    public TypepaymentEntity getTypepaymentEntity() {
        return this.typepaymentEntity;
    }

    public void setTypepaymentEntity(TypepaymentEntity typepaymentEntity) {
        this.typepaymentEntity = typepaymentEntity;
    }

     public BankEntity getBankEntity() {
        return this.bankEntity;
    }

    public void setBankEntity(BankEntity bankEntity) {
        this.bankEntity = bankEntity;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPayId() {
        return this.payId;
    }

    public void setPayId(Long payId) {
        this.payId = payId;
    }
    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhonenum() {
        return this.phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }
    public String getAccountNumber() {
        return this.accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}