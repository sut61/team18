package sut.se.g18.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import sut.se.g18.Entity.*;
import sut.se.g18.Repository.*;

import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class LearnedController {
    @Autowired
    private SkillRepository skillRepository;
    @Autowired
    private CourseTypeRepository courseTypeRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private MaidRegisterRepository maidRegisterRepository;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private LearnedRepository learnedRepository;

    public LearnedController(SkillRepository skillRepository, CourseTypeRepository courseTypeRepository,
                             CourseRepository courseRepository, MaidRegisterRepository maidRegisterRepository,
                             CompanyRepository companyRepository, LearnedRepository learnedRepository) {
        this.skillRepository = skillRepository;
        this.courseTypeRepository = courseTypeRepository;
        this.courseRepository = courseRepository;
        this.maidRegisterRepository = maidRegisterRepository;
        this.companyRepository = companyRepository;
        this.learnedRepository = learnedRepository;
    }

    @GetMapping(path = "/skill", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<SkillEntity> AllSkill() {
        return skillRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping(path = "/courseType", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<CourseTypeEntity> AllCourseType() {
        return courseTypeRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping(path = "/course", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<CourseEntity> AllCourse() {
        return courseRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping(path = "/maidInCompany/{companySelect}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<MaidRegisterEntity> getMaidInCompany(@PathVariable String companySelect) {
        CompanyEntity company = companyRepository.findBycompanyName(companySelect);
        return maidRegisterRepository.findBycompanyForMaid(company);
    }

    @GetMapping(path = "/courseInCompany/{companySelect}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<CourseEntity> getCourseInCompany(@PathVariable String companySelect) {
        CompanyEntity company = companyRepository.findBycompanyName(companySelect);
        return courseRepository.findByCompany(company);
    }

    @PostMapping("/learned/{companySelect}/{maidSelect}/{courseSelect}/{skillRankSelect}/{dateInput}/" +
            "{detailInput}")
    public LearnedEntity newLearn(@RequestBody LearnedEntity learnedEntity, @PathVariable String companySelect,
                                  @PathVariable String maidSelect, @PathVariable String courseSelect,
                                  @PathVariable String skillRankSelect, @PathVariable Date dateInput,
                                  @PathVariable String detailInput) {

        CompanyEntity company = companyRepository.findBycompanyName(companySelect);
        MaidRegisterEntity maidName = maidRegisterRepository.findBymaidName(maidSelect);
        CourseEntity course = courseRepository.findByCourseTitle(courseSelect);
        SkillEntity rank = skillRepository.findBySkillRank(skillRankSelect);
        LearnedEntity newLearn = new LearnedEntity();
        newLearn.setCompany(company);
        newLearn.setMaid(maidName);
        newLearn.setCourse(course);
        newLearn.setSkill(rank);
        newLearn.setDateLearned(dateInput);
        newLearn.setDetail(detailInput);
        if (learnedRepository.findBycourseAndMaid(course, maidName) == null) {
            newLearn.setCheckObject(true);
        }

        return learnedRepository.save(newLearn);
    }
}
