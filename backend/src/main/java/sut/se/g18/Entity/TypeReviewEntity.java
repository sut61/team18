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
@Table (name = " TypeReviewEntity ")

public class TypeReviewEntity{
    @Id 
    @SequenceGenerator(name="typereviewId_seq",sequenceName="typereviewId_seq")     
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="typereviewId_seq")

    private @NonNull Long typereviewId;

    @NotNull private String typereview;

    public TypeReviewEntity(){

    }

    public TypeReviewEntity(String typereview2) {
	}

	public Long getTypereviewId() {
        return typereviewId;
    }
    public void setTypereviewId(Long typereviewId) {
        this.typereviewId = typereviewId;
    }
    public String getTypereview() {
        return typereview;
    }
    public void setTypereview(String typereview) {
        this.typereview = typereview;
    }
    
}