package sut.se.g18.Entity;

import lombok.*;

import javax.persistence.*;


@Entity
@Data
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "PAYMENTSTATUS")
public class PaymentStatusEntity {
    @Id
    @SequenceGenerator(name="paymentStatus_seq",sequenceName="paymentStatus_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="paymentStatus_seq")
    @Column(name="paymentStatusId",unique = true, nullable = false)
    private @NonNull Long paymentStatusId;
    private @NonNull String paymentStatus;

    public Long getPaymentStatusId() {
        return paymentStatusId;
    }

    public void setPaymentStatusId(Long paymentStatusId) {
        this.paymentStatusId = paymentStatusId;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
