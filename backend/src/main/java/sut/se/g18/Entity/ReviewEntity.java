package sut.se.g18.Entity;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Entity
@Getter 
@Setter
@ToString 
@EqualsAndHashCode
@Table (name = " ReviewEntity ")

public class ReviewEntity{
    @Id 
    @SequenceGenerator(name="reviewId_seq",sequenceName="reviewId_seq")     
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="reviewId_seq")
    
    private @NonNull Long reviewId;

    //review
    @Column(unique = true)
    @NotNull 
    @Size(min = 3,max = 40)
    @Pattern(regexp = "([ก-ู]|[เ-์]||[0-9]| )+")
    private  String review;


    @NotNull 
    private String adjust;


    //---คะแนน----
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = ScoreEntity.class)
    private ScoreEntity scoreEntity;

    //---แม่บ้าน----
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = MaidRegisterEntity.class)
    private MaidRegisterEntity maidRegisterEntity;

    //--ประเภทขขข
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = TypeReviewEntity.class)
    private TypeReviewEntity typeReviewEntity;


  
    public ReviewEntity() {
	}

    public ReviewEntity(MaidRegisterEntity med, ScoreEntity sco, TypeReviewEntity ty, String review2, String adjust2) {
        this.maidRegisterEntity=med;
        this.scoreEntity=sco;
        this.typeReviewEntity=ty;
        this.review=review2;
        this.adjust=adjust2;

	}

	public Long getReviewId() {
        return reviewId;
    }
    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
    }
    public String getReview() {
        return review;
    }
    public void setReview(String review) {
        this.review = review;
    }
    public String getAdjust() {
        return adjust;
    }
    public void setAdjust(String adjust) {
        this.adjust = adjust;
    }
    public ScoreEntity getScoreEntity() {
        return scoreEntity;
    }
    public void setScoreEntity(ScoreEntity scoreEntity) {
        this.scoreEntity = scoreEntity;
    }
    public MaidRegisterEntity getMaidRegisterEntity() {
        return maidRegisterEntity;
    }
    public void setMaidRegisterEntity(MaidRegisterEntity maidRegisterEntity) {
        this.maidRegisterEntity = maidRegisterEntity;
    }
    public TypeReviewEntity getTypeReviewEntity() {
        return typeReviewEntity;
    }
    public void setTypeReviewEntity(TypeReviewEntity typeReviewEntity) {
        this.typeReviewEntity = typeReviewEntity;
    }

   

	

	
	




}
