package sut.se.g18.Entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Data
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "PROVINCE")

public class ProvinceEntity {
    @Id
    @SequenceGenerator(name="provinces_seq",sequenceName="provinces_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="provinces_seq")
    @Column(name="provincesId",unique = true, nullable = false)
    @NotNull
    private Long provinceId;
    @NotNull
    @Column(unique = true)
    private  String provinceName;

    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }
}
