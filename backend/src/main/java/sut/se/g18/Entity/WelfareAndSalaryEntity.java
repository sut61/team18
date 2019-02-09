package sut.se.g18.Entity;
import lombok.*;
import javax.persistence.*;


@Data
@Entity
@Table(name = "welfareandsalary")
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Setter

public class WelfareAndSalaryEntity {
    @Id
    @SequenceGenerator(name = "welsa_seq", sequenceName = "welsa_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "welsa_seq")
    @Column(name = "welsa_id", unique = true, nullable = false)

    
    private @NonNull Long welsaId;
    private @NonNull int salary;
    private @NonNull String welsaName;
    private @NonNull String termCon;
    private @NonNull String datail;

    /**
     * @return the welsaId
     */
    public Long getWelsaId() {
        return welsaId;
    }

    /**
     * @param welsaId the welsaId to set
     */
    public void setWelsaId(Long welsaId) {
        this.welsaId = welsaId;
    }

    /**
     * @return the salary
     */
    public int getSalary() {
        return salary;
    }

    /**
     * @param salary the salary to set
     */
    public void setSalary(int salary) {
        this.salary = salary;
    }

    /**
     * @return the welsaName
     */
    public String getWelsaName() {
        return welsaName;
    }

    /**
     * @param welsaName the welsaName to set
     */
    public void setWelsaName(String welsaName) {
        this.welsaName = welsaName;
    }

    /**
     * @return the termCon
     */
    public String getTermCon() {
        return termCon;
    }

    /**
     * @param termCon the termCon to set
     */
    public void setTermCon(String termCon) {
        this.termCon = termCon;
    }

    /**
     * @return the datail
     */
    public String getDatail() {
        return datail;
    }

    /**
     * @param datail the datail to set
     */
    public void setDatail(String datail) {
        this.datail = datail;
    }

    
}