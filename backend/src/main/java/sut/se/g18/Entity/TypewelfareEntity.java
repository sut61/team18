package sut.se.g18.Entity;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "typewelfare")
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Getter @Setter
public class TypewelfareEntity {
    @Id
    @SequenceGenerator(name = "typewel_seq",sequenceName = "typewel_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "typewel_seq")
    @Column(name = "typewel_id",unique = true, nullable = false)

    @NotNull private Long typwelId;
    @Column(unique = true)
    @NotNull private String typewelName;

    public Long getTypwelId() {
        return this.typwelId;
    }

    public void setTypwelId(Long typwelId) {
        this.typwelId = typwelId;
    }

    public String getTypewelName() {
        return this.typewelName;
    }

    public void setTypewelName(String typewelName) {
        this.typewelName = typewelName;
    }

}