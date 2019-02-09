package sut.se.g18.Entity;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Getter 
@Setter
@ToString 
@EqualsAndHashCode
@Table (name = " ScoreExpertiseEntity ")

public class ScoreExpertiseEntity{
    @Id 
    @SequenceGenerator(name="scoreExId_seq",sequenceName="scoreExId_seq")     
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="scoreExId_seq")
    private @NonNull Long scoreExId;
    @NotNull private String scoreEx;


    

public ScoreExpertiseEntity() {
	}

    public ScoreExpertiseEntity(String scoreEx2) {
}

	public Long getScoreExId() {
        return scoreExId;
    }
    public void setScoreExId(Long scoreExId) {
        this.scoreExId = scoreExId;
    }
    public String getScoreEx() {
        return scoreEx;
    }
    public void setScoreEx(String scoreEx) {
        this.scoreEx = scoreEx;
    }
	

}