package sut.se.g18.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.NonNull;
@Data
@Entity
@Table(
    name = "PROMOTIONTYPE"
)
public class PromotionTypeEntity {
    @Id
    @SequenceGenerator(
    name = "promotiontype_seq",
    sequenceName = "promotiontype_seq"
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "promotiontype_seq"
    )
    @Column(
        name = "PROMOTIONTYPE_ID",
        unique = true,
        nullable = false
    )
    @NonNull
    private Long promotionTypeId;
    @NonNull
    private String promotionType;

    public PromotionTypeEntity() {
        
    }
    
    
    public Long getPromotionTypeId() {
        return this.promotionTypeId;
    }

    public void setPromotionTypeId(Long promotionTypeId) {
        this.promotionTypeId = promotionTypeId;
    }

    public String getPromotionType() {
        return this.promotionType;
    }

    public void setPromotionType(String promotionType) {
        this.promotionType = promotionType;
    }

    public PromotionTypeEntity(Long promotionTypeId, String promotionType) { //constructor 
        this.promotionTypeId = promotionTypeId;
        this.promotionType = promotionType;
    }

}
