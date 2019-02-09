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
@Table (name = " ScorePersonalityEntity ")

public class ScorePersonalityEntity{
    @Id 
    @SequenceGenerator(name="scorePerId_seq",sequenceName="scorePerId_seq")     
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="scorePerId_seq")
    private @NonNull Long scorePerId;
    @NotNull private String scorePer;


    

public ScorePersonalityEntity() {
	}
    public ScorePersonalityEntity(String scorePer2) {
}
	public Long getScorePerId() {
        return scorePerId;
    }
    public void setScorePerId(Long scorePerId) {
        this.scorePerId = scorePerId;
    }
    public String getScorePer() {
        return scorePer;
    }
    public void setScorePer(String scorePer) {
        this.scorePer = scorePer;
    }

    
	

}