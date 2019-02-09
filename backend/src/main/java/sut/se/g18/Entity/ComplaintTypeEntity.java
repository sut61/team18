package sut.se.g18.Entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "COMPLAINT_TYPE")
public class ComplaintTypeEntity {
    @Id
    @SequenceGenerator(name="complaintType_seq",sequenceName="complaintType_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="complaintType_seq")
    @Column(name="complaintTypeId",unique = true, nullable = false)
    @NotNull
    private Long complaintTypeId;
    @NotNull
    private String complaintType;
    
    public Long getComplaintTypeId() {
        return this.complaintTypeId;
    }

    public void setComplaintTypeId(Long complaintTypeId) {
        this.complaintTypeId = complaintTypeId;
    }

    public String getComplaintType() {
        return this.complaintType;
    }

    public void setComplaintType(String complaintType) {
        this.complaintType = complaintType;
    }



}



   
