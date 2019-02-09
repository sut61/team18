package sut.se.g18.Entity;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

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

    @NotNull
    private Long welsaId;

    @Min(300)@Max(100000)
    @NotNull private int salary;

    @Column(unique = true)
    @NotNull private String welsaName;

    @Size(min=20, max = 250) @Pattern(regexp = "([ก-ู]|[เ-์]|\\s|[0-9])+")@Column(unique = true)
    @NotNull private String termCon;

    @Size(min=20, max = 250) @Pattern(regexp = "([ก-ู]|[เ-์]|\\s|[0-9])+")@Column(unique = true)
    @NotNull private String datail;

    //many-to-one with companyentity
    @ManyToOne(fetch = FetchType.EAGER ,targetEntity = CompanyEntity.class)
    private CompanyEntity company;

    //many-to-one with workingdateentity
    @ManyToOne(fetch = FetchType.EAGER ,targetEntity = WorkingDateEntity.class)
    private WorkingDateEntity workingdate;

    //many-to-one with typewelfareentity
    @ManyToOne(fetch = FetchType.EAGER ,targetEntity = TypewelfareEntity.class)
    private TypewelfareEntity typewelfare;

    public String getWelsaName() {
        return this.welsaName;
    }

    public void setWelsaName(String welsaName) {
        this.welsaName = welsaName;
    }

    public String getTermCon() {
        return this.termCon;
    }

    public void setTermCon(String termCon) {
        this.termCon = termCon;
    }

    public WorkingDateEntity getWorkingdate() {
        return this.workingdate;
    }

    public void setWorkingdate(WorkingDateEntity workingdate) {
        this.workingdate = workingdate;
    }


    public Long getWelsaId() {
        return this.welsaId;
    }

    public void setWelsaId(Long walsaId) {
        this.welsaId = walsaId;
    }

    public int getSalary() {
        return this.salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDatail() {
        return this.datail;
    }

    public void setDatail(String datail) {
        this.datail = datail;
    }

    public CompanyEntity getCompany() {
        return this.company;
    }

    public void setCompany(CompanyEntity company) {
        this.company = company;
    }

  

    public TypewelfareEntity getTypewelfare() {
        return this.typewelfare;
    }

    public void setTypewelfare(TypewelfareEntity typewelfare) {
        this.typewelfare = typewelfare;
    }

    

}