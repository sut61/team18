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
@Table(name = "COURSE_TYPE")
public class CourseTypeEntity {
    @Id
    @SequenceGenerator(name="courseType_seq",sequenceName="courseType_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="courseType_seq")
    @Column(name="courseTypeId",unique = true, nullable = false)
    @NotNull
    private Long courseTypeId;
    @NotNull
    private String courseType;
}
