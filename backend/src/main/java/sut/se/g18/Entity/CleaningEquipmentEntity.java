package sut.se.g18.Entity;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Getter 
@Setter

@ToString @EqualsAndHashCode
@Table (name = " CleaningEquipmentEntity ")

public class CleaningEquipmentEntity {
    @Id 
    @SequenceGenerator(name="cleaningId_seq",sequenceName="cleaningId_seq")     
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="cleaningId_seq")
    private @NonNull Long cleaningId;
    @NotNull private String cleaning;



    public  CleaningEquipmentEntity(String cleaning) {
        this.cleaning=cleaning;
    }
    public CleaningEquipmentEntity() {
	}
	public Long getCleaningId() {
        return cleaningId;
    }
    public void setCleaningId(Long cleaningId) {
        this.cleaningId = cleaningId;
    }
    public String getCleaning() {
        return cleaning;
    }
    public void setCleaning(String cleaning) {
        this.cleaning = cleaning;
    }

    
}