package sut.se.g18.Entity;

import lombok.*;
import javax.persistence.*;

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
    
    @Column(unique = true)
    @NotNull 
    @Size(min = 3,max = 50)
    @Pattern(regexp = "([ก-ู]|[เ-์]||[0-9])+")

    //---คะแนน----
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "scoreId")
    private ScoreEntity scoreEntity;

    //---แม่บ้าน----
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "maidId")
    private MaidRegisterEntity maidRegisterEntity;

    
    // public ReviewEntity(MaidRegisterEntity med, ScoreEntity sco, String review2) {
    //     this.maidRegisterEntity = med;
    //     this.scoreEntity = sco;
    //     this.review = review2;
    // }
    

	public ReviewEntity(MaidRegisterEntity med, ScoreEntity sco, String review2) {
        this.maidRegisterEntity = med;
         this.scoreEntity = sco;
         this.review = review2;
	}

    /**
     * @return the reviewId
     */
    public Long getReviewId() {
        return reviewId;
    }

    /**
     * @param reviewId the reviewId to set
     */
    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
    }

    /**
     * @return the review
     */
    public String getReview() {
        return review;
    }

    /**
     * @param review the review to set
     */
    public void setReview(String review) {
        this.review = review;
    }

    /**
     * @return the scoreEntity
     */
    public ScoreEntity getScoreEntity() {
        return scoreEntity;
    }

    /**
     * @param scoreEntity the scoreEntity to set
     */
    public void setScoreEntity(ScoreEntity scoreEntity) {
        this.scoreEntity = scoreEntity;
    }

    /**
     * @return the maidRegisterEntity
     */
    public MaidRegisterEntity getMaidRegisterEntity() {
        return maidRegisterEntity;
    }

    /**
     * @param maidRegisterEntity the maidRegisterEntity to set
     */
    public void setMaidRegisterEntity(MaidRegisterEntity maidRegisterEntity) {
        this.maidRegisterEntity = maidRegisterEntity;
    }
	




}