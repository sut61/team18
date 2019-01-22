package sut.se.g18.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "MAID")
public class MaidSelectEntity {
    @Id
    @SequenceGenerator(name="maid_seq",sequenceName="maid_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="maid_seq")
    @Column(name="maidId",unique = true, nullable = false)
    private @NonNull Long maidId;

    //Many To One with Customer
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = CustomerEntity.class)
    private CustomerEntity customer;

    //Many To One with MaidRegister
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = MaidRegisterEntity.class)
    private MaidRegisterEntity maid;

    //Many To One with MaidStatus
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = MaidStatusEntity.class)
    private MaidStatusEntity status;

    public Long getMaidId() {
        return maidId;
    }

    public void setMaidId(Long maidId) {
        this.maidId = maidId;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    public MaidStatusEntity getStatus() {
        return status;
    }

    public void setStatus(MaidStatusEntity status) {
        this.status = status;
    }

    public MaidRegisterEntity getMaid() {
        return maid;
    }

    public void setMaid(MaidRegisterEntity maid) {
        this.maid = maid;
    }
}
