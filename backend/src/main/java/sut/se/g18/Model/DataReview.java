package sut.se.g18.Model;
import lombok.*;

@Data
@Getter
@Setter

public class DataReview{
    private Long scoreExId;
    private Long scorePerId;
    private Long scoreTiId;

    private Long scoreId;
    private Long maidId;
    private String review;

    
    public Long getScoreId() {
        return scoreId;
    }
    public void setScoreId(Long scoreId) {
        this.scoreId = scoreId;
    }
    public Long getMaidId() {
        return maidId;
    }
    public void setMaidId(Long maidId) {
        this.maidId = maidId;
    }
    public String getReview() {
        return review;
    }
    public void setReview(String review) {
        this.review = review;
    }
    public Long getScoreExId() {
        return scoreExId;
    }
    public void setScoreExId(Long scoreExId) {
        this.scoreExId = scoreExId;
    }
    public Long getScorePerId() {
        return scorePerId;
    }
    public void setScorePerId(Long scorePerId) {
        this.scorePerId = scorePerId;
    }
    public Long getScoreTiId() {
        return scoreTiId;
    }
    public void setScoreTiId(Long scoreTiId) {
        this.scoreTiId = scoreTiId;
    }
    


}