package sut.se.g18.Entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Getter @Setter

@ToString
@EqualsAndHashCode
@Table(name = "CompanyTypeEntity")
public class CompanyTypeEntity {
    @Id
    @SequenceGenerator(name="companyType_seq",sequenceName="companyType_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="companyType_seq")
    @Column(name="companyType_Id",unique = true, nullable = false)
    @NotNull
    private Long companyTypeId;
    @NotNull
    @Column(unique = true)
    private  String companyType;


    public CompanyTypeEntity() {

    }

    public CompanyTypeEntity(String companyType) {
        this.companyType = companyType;

    }

    public Long getCompanyTypeId() {
        return companyTypeId;
    }

    public void setCompanyTypeId(Long companyTypeId) {
        this.companyTypeId = companyTypeId;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }
}
