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
@Table(name = "COURSE")
public class CourseEntity {
    @Id
    @SequenceGenerator(name="course_seq",sequenceName="course_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="course_seq")
    @Column(name="courseId",unique = true, nullable = false)
    @NotNull
    private Long courseId;
    @NotNull
    private String courseTitle;
    @NotNull
    private String courseDetail;

    //Many To One with Company
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = CompanyEntity.class)
    private CompanyEntity company;

    //Many To One with CourseType
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = CourseTypeEntity.class)
    private CourseTypeEntity courseType;

    /**
     * @return the courseId
     */
    public Long getCourseId() {
        return courseId;
    }

    /**
     * @param courseId the courseId to set
     */
    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    /**
     * @return the courseTitle
     */
    public String getCourseTitle() {
        return courseTitle;
    }

    /**
     * @param courseTitle the courseTitle to set
     */
    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    /**
     * @return the courseDetail
     */
    public String getCourseDetail() {
        return courseDetail;
    }

    /**
     * @param courseDetail the courseDetail to set
     */
    public void setCourseDetail(String courseDetail) {
        this.courseDetail = courseDetail;
    }

    /**
     * @return the company
     */
    public CompanyEntity getCompany() {
        return company;
    }

    /**
     * @param company the company to set
     */
    public void setCompany(CompanyEntity company) {
        this.company = company;
    }

    /**
     * @return the courseType
     */
    public CourseTypeEntity getCourseType() {
        return courseType;
    }

    /**
     * @param courseType the courseType to set
     */
    public void setCourseType(CourseTypeEntity courseType) {
        this.courseType = courseType;
    }

    
}
