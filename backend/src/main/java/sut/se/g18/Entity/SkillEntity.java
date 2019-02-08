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
@Table(name = "SKILL")
public class SkillEntity {
    @Id
    @SequenceGenerator(name="skill_seq",sequenceName="skill_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="skill_seq")
    @Column(name="skillId",unique = true, nullable = false)
    @NotNull
    private Long skillId;
    @NotNull
    @Column(unique = true)
    @Pattern(regexp = "([ก-ู]|[เ-์]| |[a-z]|[A-Z])+")
    private String skillRank;

    /**
     * @return the skillId
     */
    public Long getSkillId() {
        return skillId;
    }

    /**
     * @param skillId the skillId to set
     */
    public void setSkillId(Long skillId) {
        this.skillId = skillId;
    }

    /**
     * @return the skillRank
     */
    public String getSkillRank() {
        return skillRank;
    }

    /**
     * @param skillRank the skillRank to set
     */
    public void setSkillRank(String skillRank) {
        this.skillRank = skillRank;
    }

    
}
