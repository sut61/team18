package sut.se.g18.Entity;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Getter 
@Setter

@ToString @EqualsAndHashCode
@Table (name = " ElectricalEquipmentEntity ")

public class ElectricalEquipmentEntity {
    @Id 
    @SequenceGenerator(name="electricId_seq",sequenceName="electricId_seq")     
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="electricId_seq")
    
    private @NonNull Long electricId;
    @NotNull private String electric;

    public  ElectricalEquipmentEntity(String electric) {

        this.electric = electric;
    }
    public ElectricalEquipmentEntity() {
	}
	public Long getElectricId() {
        return electricId;
    }
    public void setElectricId(Long electricId) {
        this.electricId = electricId;
    }
    public String getElectric() {
        return electric;
    }
    public void setElectric(String electric) {
        this.electric = electric;
    }

    
}