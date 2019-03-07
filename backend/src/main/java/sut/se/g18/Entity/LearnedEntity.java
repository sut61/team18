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
@Table(name = "LEARNED")
public class LearnedEntity {
    @Id
    @SequenceGenerator(name="learned_seq",sequenceName="learned_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="learned_seq")
    @Column(name="learnedId",unique = true, nullable = false)
    @NotNull
    private Long learnedId;
    @PastOrPresent
    @Column(unique = true)
    private Date dateLearned;
    @NotNull
    @Size(min = 5,max = 50)
    @Pattern(regexp = "^คอร์ส([ก-ู]|[เ-์]| )+")
    private String detail;
    @AssertTrue
    private boolean checkObject;

    //Many To One with Course
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = CourseEntity.class)
    private CourseEntity course;

    //Many To One with MaidRegister
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = MaidRegisterEntity.class)
    private MaidRegisterEntity maid;

    //Many To One with Skill
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = SkillEntity.class)
    private SkillEntity skill;

    public Long getLearnedId() {
        return learnedId;
    }

    public void setLearnedId(Long learnedId) {
        this.learnedId = learnedId;
    }

    public Date getDateLearned() {
        return dateLearned;
    }

    public void setDateLearned(Date dateLearned) {
        this.dateLearned = dateLearned;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public boolean isCheckObject() {
        return checkObject;
    }

    public void setCheckObject(boolean checkObject) {
        this.checkObject = checkObject;
    }

    public CourseEntity getCourse() {
        return course;
    }

    public void setCourse(CourseEntity course) {
        this.course = course;
    }

    public MaidRegisterEntity getMaid() {
        return maid;
    }

    public void setMaid(MaidRegisterEntity maid) {
        this.maid = maid;
    }

    public SkillEntity getSkill() {
        return skill;
    }

    public void setSkill(SkillEntity skill) {
        this.skill = skill;
    }
}
