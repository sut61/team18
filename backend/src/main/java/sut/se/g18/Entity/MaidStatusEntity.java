package sut.se.g18.Entity;

import lombok.*;

import javax.persistence.*;


@Entity
@Data
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "MAIDSTATUS")
public class MaidStatusEntity {
    @Id
    @SequenceGenerator(name="maidstatus_seq",sequenceName="maidstatus_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="maidstatus_seq")
    @Column(name="maidStatusId",unique = true, nullable = false)
    private @NonNull Long maidStatusId;
    private @NonNull String status;

    public Long getMaidStatusId() {
        return maidStatusId;
    }

    public void setMaidStatusId(Long maidStatusId) {
        this.maidStatusId = maidStatusId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
