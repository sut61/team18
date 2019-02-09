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
<<<<<<< HEAD
    @NotNull
    @Size(min = 3,max = 50)
    @Pattern(regexp = "([ก-ู]|[เ-์]||[0-9])+")
=======
    @NotNull 
    @Size(min = 3,max = 40)
    @Pattern(regexp = "([ก-ู]|[เ-์]||[0-9]| )+")
>>>>>>> update entity - colse #170
    private  String review;

    //---คะแนน----
    @NotNull
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "scoreId")
    private ScoreEntity scoreEntity;

    //---คะแนนความชำนาญ----
    @NotNull
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "scoreExId")
    private ScoreExpertiseEntity scoreExpertiseEntity;

    //---คะแนนบุคลิก----
    @NotNull
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "scorePerId")
    private ScorePersonalityEntity scorePersonalityEntity;

    //---คะแนนความเวลา----
    @NotNull
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "scoreTiId")
    private ScoreTimeEntity scoreTimeEntity;

    //---แม่บ้าน----
    @NotNull
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "maidId")
    private MaidRegisterEntity maidRegisterEntity;

    
    
    // public ReviewEntity(MaidRegisterEntity med, ScoreEntity sco, String review2) {
    //     this.maidRegisterEntity = med;
    //     this.scoreEntity = sco;
    //     this.review = review2;
    // }
    

	

    public ReviewEntity() {
	}

    public ReviewEntity(MaidRegisterEntity med, ScoreEntity sco, ScoreExpertiseEntity se
    , ScorePersonalityEntity sp,ScoreTimeEntity st, String review2) {
            this.maidRegisterEntity = med;
            this.scoreEntity = sco;
            this.review = review2;
            this.scoreExpertiseEntity=se;
            this.scorePersonalityEntity=sp;
            this.scoreTimeEntity=st;

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
     * @return the scoreExpertiseEntity
     */
    public ScoreExpertiseEntity getScoreExpertiseEntity() {
        return scoreExpertiseEntity;
    }

    /**
     * @param scoreExpertiseEntity the scoreExpertiseEntity to set
     */
    public void setScoreExpertiseEntity(ScoreExpertiseEntity scoreExpertiseEntity) {
        this.scoreExpertiseEntity = scoreExpertiseEntity;
    }

    /**
     * @return the scorePersonalityEntity
     */
    public ScorePersonalityEntity getScorePersonalityEntity() {
        return scorePersonalityEntity;
    }

    /**
     * @param scorePersonalityEntity the scorePersonalityEntity to set
     */
    public void setScorePersonalityEntity(ScorePersonalityEntity scorePersonalityEntity) {
        this.scorePersonalityEntity = scorePersonalityEntity;
    }

    /**
     * @return the scoreTimeEntity
     */
    public ScoreTimeEntity getScoreTimeEntity() {
        return scoreTimeEntity;
    }

    /**
     * @param scoreTimeEntity the scoreTimeEntity to set
     */
    public void setScoreTimeEntity(ScoreTimeEntity scoreTimeEntity) {
        this.scoreTimeEntity = scoreTimeEntity;
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
