package sut.se.g18.Entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@Entity
@Data
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "COMPLAINT")
public class ComplaintEntity {
    @Id
    @SequenceGenerator(name="complaint_seq",sequenceName="complaint_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="complaint_seq")
    @Column(name="complaintId",unique = true, nullable = false)
    
    @NotNull 
    private Long complaintId;
    
    @NotNull
    @Size(min = 5,max = 50)
    @Pattern(regexp = "^เรื่อง([ก-ู]|[เ-์]| )+")
    @Column(unique = true)
    private String comDetail;

    @NotNull

    private Date complaintDate;
    //Many To One with Company
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = CompanyEntity.class)
    private CompanyEntity companyEntity;
    
     //Many To One with MaidRegister
     @ManyToOne(fetch = FetchType.EAGER, targetEntity = MaidRegisterEntity.class)
     private MaidRegisterEntity maid;

      //Many To One with ComplaintType
      @ManyToOne(fetch = FetchType.EAGER, targetEntity = ComplaintTypeEntity.class)
      private ComplaintTypeEntity complaintTypeEntity;
 
     
     

    public Long getComplaintId() {
        return this.complaintId;
    }

    public void setComplaintId(Long complaintId) {
        this.complaintId = complaintId;
    }

    public String getComDetail() {
        return this.comDetail;
    }

    public void setComDetail(String comDetail) {
        this.comDetail = comDetail;
    }

    public CompanyEntity getCompanyEntity() {
        return this.companyEntity;
    }

    public void setCompanyEntity(CompanyEntity companyEntity) {
        this.companyEntity = companyEntity;
    }

    public MaidRegisterEntity getMaid() {
        return this.maid;
    }

    public void setMaid(MaidRegisterEntity maid) {
        this.maid = maid;
    }

    public ComplaintTypeEntity getComplaintTypeEntity() {
        return this.complaintTypeEntity;
    }

    public void setComplaintTypeEntity(ComplaintTypeEntity complaintTypeEntity) {
        this.complaintTypeEntity = complaintTypeEntity;
    }

	public ComplaintEntity save(ComplaintEntity cpe) {
		return null;
	}


    public Date getComplaintDate() {
        return this.complaintDate;
    }

    public void setComplaintDate(Date complaintDate) {
        this.complaintDate = complaintDate;
    }
    

    

}
