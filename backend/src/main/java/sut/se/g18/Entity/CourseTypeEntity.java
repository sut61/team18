package sut.se.g18.Entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Data
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "COURSE_TYPE")
public class CourseTypeEntity {
    @Id
    @SequenceGenerator(name="courseType_seq",sequenceName="courseType_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="courseType_seq")
    @Column(name="courseTypeId",unique = true, nullable = false)
    @NotNull
    private Long courseTypeId;
    @NotNull
    @Column(unique = true)
    @Pattern(regexp = "([ก-ู]|[เ-์]| |[a-z]|[A-Z])+")
    private String courseType;

    /**
     * @return the courseTypeId
     */
    public Long getCourseTypeId() {
        return courseTypeId;
    }

    /**
     * @param courseTypeId the courseTypeId to set
     */
    public void setCourseTypeId(Long courseTypeId) {
        this.courseTypeId = courseTypeId;
    }

    /**
     * @return the courseType
     */
    public String getCourseType() {
        return courseType;
    }

    /**
     * @param courseType the courseType to set
     */
    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }
    
}
