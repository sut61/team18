package sut.se.g18.Entity;
import lombok.*;
import javax.persistence.*;

@Entity
@Data
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table (name = "WorkingDateEntity")
public class WorkingDateEntity {
    @Id
    @SequenceGenerator(name="workingDateSeq",sequenceName="workingDateSeq")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="workingDateSeq")
    @Column(name="TypeworkingDateId",unique = true, nullable = false)

    private @NonNull Long typeworkingDateId;
    private @NonNull String typeworkingDate;
        public Long getTypeworkingDateId() {
            return typeworkingDateId;
        }
        public void setTypeworkingDateId(Long typeworkingDateId) {
            this.typeworkingDateId = typeworkingDateId;
        }
        public String getTypeworkingDate() {
            return typeworkingDate;
        }
        public void setTypeworkingDate(String typeworkingDate) {
            this.typeworkingDate = typeworkingDate;
        }
}
