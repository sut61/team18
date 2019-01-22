package sut.se.g18.Entity;
import lombok.*;
import javax.persistence.*;

@Entity
@Data
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table (name = "TitleNameEntity")
public class TitleNameEntity {
    @Id
    @SequenceGenerator(name="titlenameSeq",sequenceName="titlenameSeq")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="titlenameSeq")
    @Column(name="titlenameId",unique = true, nullable = false)

    private @NonNull Long titlenameId;
    private @NonNull String titlenameType;

    public Long getTitlenameId() { return titlenameId; }
    public void setTitlenameId(Long titlenameId) {
        this.titlenameId = titlenameId;
    }
    public String getTitlenameType() {
        return titlenameType;
    }
    public void setTitlenameType(String titlenameType) {
        this.titlenameType = titlenameType;
    }
}
