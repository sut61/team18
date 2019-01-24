package sut.se.g18.Entity;


import lombok.*;
import javax.persistence.*;

@Data
@Entity
@Getter 
@Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
@Table (name = " ElectricalEquipmentEntity ")

public class ElectricalEquipmentEntity {
    @Id 
    @SequenceGenerator(name="electricId_seq",sequenceName="electricId_seq")     
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="electricId_seq")
    
    private @NonNull Long electricId;
    private @NonNull String electric;

    public  ElectricalEquipmentEntity(String electric) {

        this.electric = electric;
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