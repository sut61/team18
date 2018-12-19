package com.example.backend.Entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Getter 
@Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
@Table (name = " LendEquipment ")
public class LendEquipment {
    @Id 
    @SequenceGenerator(name="lend_id_seq",sequenceName="lend_id_seq")     
    @GeneratedValue
    private @NonNull Long lend_id;
    private @NonNull String lendData;

    

    public  LendEquipment(String lendData) {

        this.lendData=lendData;
    }

    
}