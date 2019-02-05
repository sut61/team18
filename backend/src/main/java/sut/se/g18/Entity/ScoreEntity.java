package sut.se.g18.Entity;

import lombok.*;
import javax.persistence.*;

@Data
@Entity
@Getter 
@Setter
@ToString 
@EqualsAndHashCode
@Table (name = " ScoreEntity ")

public class ScoreEntity{
    @Id 
    @SequenceGenerator(name="scoreId_seq",sequenceName="scoreId_seq")     
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="scoreId_seq")
    private @NonNull Long scoreId;
    private @NonNull String score;


    

public ScoreEntity() {
	}
	public ScoreEntity(String score2) {
	}

	public Long getScoreId() {
        return scoreId;
    }
    public void setScoreId(Long scoreId) {
        this.scoreId = scoreId;
    }
    public String getScore() {
        return score;
    }
    public void setScore(String score) {
        this.score = score;
    }

    


}