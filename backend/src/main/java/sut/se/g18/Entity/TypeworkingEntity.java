package sut.se.g18.Entity;
import lombok.*;
import javax.persistence.*;

@Entity
@Data
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table (name = "TypeworkingEntity")
public class TypeworkingEntity {
    @Id
    @SequenceGenerator(name="typeworkingSeq",sequenceName="typeworkingSeq")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="typeworkingSeq")
    @Column(name="TypeworkingId",unique = true, nullable = false)

    private @NonNull Long typeworkingId;
    private @NonNull String typeworking;




        public Long getTypeworkingId() {
            return typeworkingId;
        }
        public void setTypeworkingId(Long typeworkingId) {
            this.typeworkingId = typeworkingId;
        }
        public String getTypeworking() {
            return typeworking;
        }
        public void setTypeworking(String typeworking) {
            this.typeworking = typeworking;
        }

}
