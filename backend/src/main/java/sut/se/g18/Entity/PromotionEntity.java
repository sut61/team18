package sut.se.g18.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "PROMOTION")
public class PromotionEntity {
    @Id
    @SequenceGenerator(name="promotion_seq",sequenceName="promotion_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="promotion_seq")
    @Column(name="promotionId",unique = true, nullable = false)
    private @NonNull Long promotionId;
    private @NonNull String title;

    //Many To One with Company
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = CompanyEntity.class)
    private CompanyEntity company;

    public Long getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(Long promotionId) {
        this.promotionId = promotionId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public CompanyEntity getCompany() {
        return company;
    }

    public void setCompany(CompanyEntity company) {
        this.company = company;
    }
}
