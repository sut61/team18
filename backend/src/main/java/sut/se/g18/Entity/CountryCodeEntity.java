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
@Table(name = "CountryCodeEntity")
public class CountryCodeEntity {
    @Id
    @SequenceGenerator(name="countryCode_seq",sequenceName="countryCode_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="countryCode_seq")
    @Column(name="CountryCode_ID",unique = true, nullable = false)
    private @NonNull Long countrycodeid;
    private @NonNull String countrycode;


    public CountryCodeEntity() {

    }

    public CountryCodeEntity(String countrycode) {
        this.countrycode = countrycode;


    }

    public void setCountrycodeid(Long countrycodeid) {
        this.countrycodeid = countrycodeid;
    }

    public Long getCountrycodeid() {
        return countrycodeid;
    }

    public void setCountryCode(String countrycode) {
        this.countrycode = countrycode;
    }

    public String getCountryCode() {
        return countrycode;
    }
}