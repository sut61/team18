package sut.se.g18.Model;
import lombok.*;

@Data
@Getter
@Setter

public class DataReview{
  

    private Long scoreId;
    private Long maidId;
    private String review;
    private String adjust;
    private Long typereviewId;

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
    public String getAdjust() {
        return adjust;
    }
    public void setAdjust(String adjust) {
        this.adjust = adjust;
    }
    public Long getTypereviewId() {
        return typereviewId;
    }
    public void setTypereviewId(Long typereviewId) {
        this.typereviewId = typereviewId;
    }

    
    
   
    


}