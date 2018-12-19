package com.okta.developer.demo.Entity;


import java.util.Date;

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
    name = "PROMOTION"
)
public class PromotionEntity {
    @Id
    @SequenceGenerator(
        name = "promotion_seq",
        sequenceName = "promotion_seq"
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "promotion_seq"
    )
    @Column(
        name = "PROMOTION_ID",
        unique = true,
        nullable = false
    )
    @NonNull
    private Long promotionID;
    @NonNull
    private String promotion;

    private String datail;
    private Date dateStart;
    private Date dateEnd;

    public Long getPromotionID() {  //getter promotionID
        return this.promotionID;
    }

    public void setPromotionID(Long promotionID) { //setter promotionID
        this.promotionID = promotionID;
    }

    public String getPromotion() {   //getter promotion
        return this.promotion;
    }

    public void setPromotion(String promotion) { //setter promotion
        this.promotion = promotion;
    }
    

    public String getDatail() {   //getter datail
        return this.datail;
    }

    public void setDatail(String datail) { //setter datail
        this.datail = datail;
    }
    

    public Date getDateStart() {  //getter dateStart
        return this.dateStart;
    }

    public void setDateStart(Date dateStart) {  //setter dateStart
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {  //getter dateEnd
        return this.dateEnd;
    }

    public void setDateEnd(Date dateEnd) {  //setter dateEnd
        this.dateEnd = dateEnd;
    }





}
