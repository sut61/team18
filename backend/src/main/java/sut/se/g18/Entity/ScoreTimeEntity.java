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
@Table (name = " ScoreTimeEntity ")

public class ScoreTimeEntity{
    @Id 
    @SequenceGenerator(name="scoreTiId_seq",sequenceName="scoreTiId_seq")     
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="scoreTiId_seq")
    private @NonNull Long scoreTiId;
    @NotNull private String scoreTi;


public ScoreTimeEntity() {
	}
    public ScoreTimeEntity(String scoreTi2) {
}
	public Long getScoreTiId() {
        return scoreTiId;
    }
    public void setScoreTiId(Long scoreTiId) {
        this.scoreTiId = scoreTiId;
    }
    public String getScoreTi() {
        return scoreTi;
    }
    public void setScoreTi(String scoreTi) {
        this.scoreTi = scoreTi;
    }
    
    
	

}