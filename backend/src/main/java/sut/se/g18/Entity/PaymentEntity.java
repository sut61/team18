package sut.se.g18.Entity;

import lombok.*;
import javax.persistence.*;

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
    private @NonNull Long payId;
    private @NonNull String name;

    //many-to-one  with bankEntity
    @ManyToOne(fetch = FetchType.EAGER ,targetEntity = BankEntity.class)
    private BankEntity bankEntity;

   

    //many-to-one with typepaymentEntity
    @ManyToOne(fetch = FetchType.EAGER ,targetEntity = TypepaymentEntity.class)
    private TypepaymentEntity typepaymentEntity;

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
}