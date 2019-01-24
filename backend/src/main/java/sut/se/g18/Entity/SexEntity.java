package sut.se.g18.Entity;

import javax.persistence.Entity;
//import java.util.List;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.*;
@Entity
@Data
@Getter @Setter

@ToString
@EqualsAndHashCode
@Table(name = "SexEntity")
public class SexEntity {
    @Id
    @SequenceGenerator(name="sex_seq",sequenceName="sex_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sex_seq")
    @Column(name="Sex_ID",unique = true, nullable = false)
    private@NonNull Long sexid;
    private @NonNull String customersex;


    public SexEntity() {

    }

    public SexEntity(String customersex) {
        this.customersex = customersex;


    }

    public void setSexid(Long sexid) {
        this.sexid = sexid;
    }

    public Long getSexid() {
        return sexid;
    }

    public void setCustomersex(String customersex) {
        this.customersex = customersex;
    }

    public String getCustomersex() {
        return customersex;
    }
}