package sut.se.g18.Entity;

import lombok.*;
import javax.persistence.*;

@Data
@Entity
@Table(name = "typepayment")
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Getter @Setter
public class TypepaymentEntity {
    @Id
    @SequenceGenerator(name = "type_seq",sequenceName = "type_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "type_seq")
    @Column(name = "type_id",unique = true, nullable = false)
    private @NonNull Long typeId;
    private @NonNull String typeName;


    public Long getTypeid() {
        return typeId;
    }

    public void setTypeid(Long type_id) {
        this.typeId = type_id;
    }

    public String getTypename() {
        return typeName;
    }

    public void setTypename(String type_name) {
        this.typeName = type_name;
    }
}