package sut.se.g18.Entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;


@Getter @Setter
@ToString
@EqualsAndHashCode
@Data
@Entity
@Table(
    name = "PROMOTION"
)
@NoArgsConstructor
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
    @NotNull
    private Long promotionID;

    @NotNull
    @Size(min = 5,max = 50)
    @Pattern(regexp = "^โปรโมชั่น([ก-ู]|[เ-์]| )+")
    @Column(unique = true)
    private  String  title;
    
    @NotNull
    private  Date dateStart;

    @NotNull
    
    private  Date dateEnd;

    @NotNull
    @Min(value = 0)
    @Max(value = 100)
    @Positive
    private int discount;

    // open join table
    //Many To One with PromotionTypeEntity
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = PromotionTypeEntity.class)
    private PromotionTypeEntity promotionTypeEntity;
    
     //Many To One with MaidRegister
     @ManyToOne(fetch = FetchType.EAGER, targetEntity = MaidRegisterEntity.class)
     private MaidRegisterEntity maid;
    

    //Many To One with CompanyEntity
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = CompanyEntity.class)
    private CompanyEntity companyEntity;




    public Long getPromotionID() {
        return this.promotionID;
    }

    public void setPromotionID(Long promotionID) {
        this.promotionID = promotionID;
    }



    public String getTitle() {
        return this.title;
    }

    public void setTitle(String detail) {
        this.title = detail;
    }

    public Date getDateStart() {
        return this.dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return this.dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public int getDiscount() {
        return this.discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public PromotionTypeEntity getPromotionTypeEntity() {
        return this.promotionTypeEntity;
    }

    public void setPromotionTypeEntity(PromotionTypeEntity promotionTypeEntity) {
        this.promotionTypeEntity = promotionTypeEntity;
    }


    public MaidRegisterEntity getMaid() {
        return this.maid;
    }

    public void setMaid(MaidRegisterEntity maid) {
        this.maid = maid;
    }

    public PromotionEntity maid(MaidRegisterEntity maid) {
        this.maid = maid;
        return this;
    }
   

    public CompanyEntity getCompanyEntity() {
        return this.companyEntity;
    }

    public void setCompanyEntity(CompanyEntity companyEntity) {
        this.companyEntity = companyEntity;
    }
    


    
    
    




}
