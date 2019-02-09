package sut.se.g18;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import sut.se.g18.Entity.*;
import sut.se.g18.Repository.*;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(SpringRunner.class)
@DataJpaTest
public class LearnedTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private LearnedRepository learnedRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private MaidRegisterRepository maidRegisterRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private SkillRepository skillRepository;

    private Validator validator;

    private CompanyEntity company1;
    private MaidRegisterEntity maid;
    private CourseEntity course;
    private CourseEntity course2;
    private SkillEntity rank;

    private SimpleDateFormat formatter5 = new SimpleDateFormat("E, MMM dd yyyy HH:mm:ss");

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        company1 = companyRepository.findBycompanyName("บริษัทพีกาซัส");
        maid = maidRegisterRepository.findBymaidName("Ping Kasinan");
        course = courseRepository.findByCourseTitle("คอร์สอบรมการตกแต่งกิ่งต้นบอนไซ");
        course2 = courseRepository.findByCourseTitle("คอร์สฝึกสอนทำอาหารอีสาน");
        rank = skillRepository.findBySkillRank("Guru");
    }

    // ////////////////////////////////////////////////////////////////////////////////
    // //****************************************************************************//
    // //**********************TEST CASE FOR LEARNED ENTITY**************************//
    // //****************************************************************************//
    // ////////////////////////////////////////////////////////////////////////////////

    // TEST LEARN ENTITY SUCCESS
    @Test
    public void testLearnedEntitySuccess() {
        LearnedEntity L = new LearnedEntity();
        L.setDetail("คอร์สเรียนตัดหญ้า");
        L.setCompany(company1);
        L.setMaid(maid);
        L.setCourse(course);
        L.setSkill(rank);
        L.setCheckObject(true);

        try {
            L.setDateLearned(formatter5.parse("Thu, Oct 18 2019 00:00:00"));
        } catch (ParseException e) {
            System.out.println("===========In tsetLearnedEntitySuccess============");
            System.out.println(e);
            e.printStackTrace();
        }
        entityManager.persist(L);
        entityManager.flush();
        System.out.println("TEST LEARNED ENTITY ALL VALID SUCCESS");
    }

    // TEST NULL RELATION BETWEEN LEARNED ENTITY AND COMPANY ENTITY
    @Test
    public void testLearnedEntityRelationToCompanyEntityNull() {
        LearnedEntity L = new LearnedEntity();
        L.setDetail("คอร์สเรียนตัดหญ้า");
        L.setCompany(null);
        L.setMaid(maid);
        L.setCourse(course);
        L.setSkill(rank);
        L.setCheckObject(true);

        try {
            L.setDateLearned(formatter5.parse("Thu, Oct 18 2019 00:00:00"));
            entityManager.persist(L);
            entityManager.flush();
            System.out.println("TEST LEARNED ENTITY ALL VALID SUCCESS");
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("===========In testLearnedEntityRelationToCompanyEntityNull============");
            System.out.println(e.getConstraintViolations());
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        } catch (ParseException e) {
            System.out.println("===========In testLearnedEntityRelationToCompanyEntityNull============");
            System.out.println(e);
            e.printStackTrace();
        }
    }

    // TEST NULL RELATION BETWEEN LEARNED ENTITY AND MAID REGISTER ENTITY
    @Test
    public void testLearnedEntityRelationToMaidRegisterEntityNull() {
        LearnedEntity L = new LearnedEntity();
        L.setDetail("คอร์สเรียนตัดหญ้า");
        L.setCompany(company1);
        L.setMaid(null);
        L.setCourse(course);
        L.setSkill(rank);
        L.setCheckObject(true);

        try {
            L.setDateLearned(formatter5.parse("Thu, Oct 18 2019 00:00:00"));
            entityManager.persist(L);
            entityManager.flush();
            System.out.println("TEST LEARNED ENTITY ALL VALID SUCCESS");
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("===========In testLearnedEntityRelationToMaidRegisterEntityNull============");
            System.out.println(e.getConstraintViolations());
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        } catch (ParseException e) {
            System.out.println("===========In testLearnedEntityRelationToMaidRegisterEntityNull============");
            System.out.println(e);
            e.printStackTrace();
        }
    }

    // TEST NULL RELATION BETWEEN LEARNED ENTITY AND COURSE ENTITY
    @Test
    public void testLearnedEntityRelationToCourseEntityNull() {
        LearnedEntity L = new LearnedEntity();
        L.setDetail("คอร์สเรียนตัดหญ้า");
        L.setCompany(company1);
        L.setMaid(maid);
        L.setCourse(null);
        L.setSkill(rank);
        L.setCheckObject(true);

        try {
            L.setDateLearned(formatter5.parse("Thu, Oct 18 2019 00:00:00"));
            entityManager.persist(L);
            entityManager.flush();
            System.out.println("TEST LEARNED ENTITY ALL VALID SUCCESS");
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("===========In testLearnedEntityRelationToCourseEntityNull============");
            System.out.println(e.getConstraintViolations());
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        } catch (ParseException e) {
            System.out.println("===========In testLearnedEntityRelationToCourseEntityNull============");
            System.out.println(e);
            e.printStackTrace();
        }
    }

    // TEST NULL RELATION BETWEEN LEARNED ENTITY AND SKILL ENTITY
    @Test
    public void testLearnedEntityRelationToSkillEntityNull() {
        LearnedEntity L = new LearnedEntity();
        L.setDetail("คอร์สเรียนตัดหญ้า");
        L.setCompany(company1);
        L.setMaid(maid);
        L.setCourse(course);
        L.setSkill(null);
        L.setCheckObject(true);

        try {
            L.setDateLearned(formatter5.parse("Thu, Oct 18 2019 00:00:00"));
            entityManager.persist(L);
            entityManager.flush();
            System.out.println("TEST LEARNED ENTITY ALL VALID SUCCESS");
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("===========In testLearnedEntityRelationToCourseEntityNull============");
            System.out.println(e.getConstraintViolations());
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        } catch (ParseException e) {
            System.out.println("===========In testLearnedEntityRelationToCourseEntityNull============");
            System.out.println(e);
            e.printStackTrace();
        }
    }

    // TEST NULL DETAIL
    @Test
    public void testLearnedEntityNullDetail() {
        LearnedEntity L = new LearnedEntity();
        L.setDetail(null);
        L.setCompany(company1);
        L.setMaid(maid);
        L.setCourse(course);
        L.setSkill(rank);
        L.setCheckObject(true);

        try {
            L.setDateLearned(formatter5.parse("Thu, Oct 18 2019 00:00:00"));
            entityManager.persist(L);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("===========In testLearnedEntityNullDetail============");
            System.out.println(e.getConstraintViolations());
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        } catch (ParseException e) {
            System.out.println("===========In testLearnedEntityNullDetail============");
            System.out.println(e);
            e.printStackTrace();
        }
    }

    // TEST MIN SIZE DETAIL
    @Test
    public void testLearnedEntityMinSizeDetail() {
        LearnedEntity L = new LearnedEntity();
        L.setDetail("คอร์");
        L.setCompany(company1);
        L.setMaid(maid);
        L.setCourse(course);
        L.setSkill(rank);
        L.setCheckObject(true);

        try {
            L.setDateLearned(formatter5.parse("Thu, Oct 18 2019 00:00:00"));
            entityManager.persist(L);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("===========In testLearnedEntityMinSizeDetail============");
            System.out.println(e.getConstraintViolations());
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2); //ผิด Pattern ด้วย
        } catch (ParseException e) {
            System.out.println("===========In testLearnedEntityMinSizeDetail============");
            System.out.println(e);
            e.printStackTrace();
        }
    }

    // TEST MAX SIZE DETAIL
    @Test
    public void testLearnedEntityMaxSizeDetail() {
        LearnedEntity L = new LearnedEntity();
        L.setDetail("คอร์สเรียนแต่งหน้า นั่งสมาธิ ดำน้ำ ปลูกปะการัง ทำอาหาร นวดสปา ปลูกป่า ดำนา ดูดิสนีย์ออนไอซ์ แรลลี่ตีกอล์ฟ ล่องเรือ ส่องสัตว์ ช๊อปปิ้ง ดูงิ้ว ดูละครเวที ดูคอนเสิร์ต " +
                "ดินเนอร์ ทำขนม จัดดอกไม้ เที่ยวตลาดน้ำ เรียนถ่ายรูป ดูกายกรรม ชมเมืองเก่า เข้าสัมมนา ทัวร์ธรรมมะ เรียนเต้นแล้วก็ร้องเพลง");
        L.setCompany(company1);
        L.setMaid(maid);
        L.setCourse(course);
        L.setSkill(rank);
        L.setCheckObject(true);

        try {
            L.setDateLearned(formatter5.parse("Thu, Oct 18 2019 00:00:00"));
            entityManager.persist(L);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("===========In testLearnedEntityMaxSizeDetail============");
            System.out.println(e.getConstraintViolations());
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        } catch (ParseException e) {
            System.out.println("===========In testLearnedEntityMaxSizeDetail============");
            System.out.println(e);
            e.printStackTrace();
        }
    }

    // TEST INVALID PATTERN DETAIL
    @Test
    public void testLearnedEntityInvalidPatternDetail() {
        LearnedEntity L = new LearnedEntity();
        L.setDetail("คอร์เรียนแต่งหน้า นั่งสมาธิ ดำน้ำ ปลูกปะการัง");
        L.setCompany(company1);
        L.setMaid(maid);
        L.setCourse(course);
        L.setSkill(rank);
        L.setCheckObject(true);

        try {
            L.setDateLearned(formatter5.parse("Thu, Oct 18 2019 00:00:00"));
            entityManager.persist(L);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("===========In testLearnedEntityInvalidPatternDetail============");
            System.out.println(e.getConstraintViolations());
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        } catch (ParseException e) {
            System.out.println("===========In testLearnedEntityInvalidPatternDetail============");
            System.out.println(e);
            e.printStackTrace();
        }
    }

    //TEST INVALID DATE
    @Test
    public void testLearnedEntityInvalidDate() {
        LearnedEntity L = new LearnedEntity();
        L.setDetail("คอร์สเรียนตัดหญ้า");
        L.setCompany(company1);
        L.setMaid(maid);
        L.setCourse(course);
        L.setSkill(rank);
        L.setCheckObject(true);

        try {
            L.setDateLearned(formatter5.parse("Thu, Oct 18 2018 00:00:00"));
            entityManager.persist(L);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("===========In testLearnedEntityInvalidDate============");
            System.out.println(e.getConstraintViolations());
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        } catch (ParseException e) {
            System.out.println("===========In testLearnedEntityInvalidDate============");
            System.out.println(e);
            e.printStackTrace();
        }
    }

    // TEST RE INSERT SAME OBJECT (MAID AND COURSE)
    @Test
    public void testLearnedEntityReInsertObject() {
        LearnedEntity L = new LearnedEntity();
        L.setDetail("คอร์สเรียนตัดหญ้า");
        L.setCompany(company1);
        L.setMaid(maid);
        L.setCourse(course);
        L.setSkill(rank);
        L.setCheckObject(true);
        try {
            L.setDateLearned(formatter5.parse("Fri, Oct 18 2019 00:00:00"));

        } catch (ParseException e) {
            System.out.println("===========In testLearnedEntityReInsertObject============");
            System.out.println(e);
            e.printStackTrace();
        }
        entityManager.persist(L);
        entityManager.flush();

        LearnedEntity L2 = new LearnedEntity();
        L2.setDetail("คอร์สเรียนตัดหญ้า");
        L2.setCompany(company1);
        L2.setMaid(maid);
        L2.setCourse(course);
        L2.setSkill(rank);
        if (learnedRepository.findBycourseAndMaid(course, maid) == null) {
            L2.setCheckObject(true);
        }

        try {
            L2.setDateLearned(formatter5.parse("Sat, Oct 19 2019 00:00:00"));
            entityManager.persist(L2);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("===========In testLearnedEntityReInsertObject============");
            System.out.println(e.getConstraintViolations());
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        } catch (ParseException e) {
            System.out.println("===========In testLearnedEntityReInsertObject============");
            System.out.println(e);
            e.printStackTrace();
        }
    }

    // TEST LEARN 2 OR MORE COURSES IN 1 DAY
    @Test
    public void testLearnedEntityLearnMoreCourseInOneDay() {
        LearnedEntity L = new LearnedEntity();
        L.setDetail("คอร์สเรียนตัดหญ้า");
        L.setCompany(company1);
        L.setMaid(maid);
        L.setCourse(course);
        L.setSkill(rank);
        L.setCheckObject(true);
        try {
            L.setDateLearned(formatter5.parse("Fri, Oct 18 2019 00:00:00"));

        } catch (ParseException e) {
            System.out.println("===========In testLearnedEntityLearnMoreCourseInOneDay============");
            System.out.println(e);
            e.printStackTrace();
        }
        entityManager.persist(L);
        entityManager.flush();

        LearnedEntity L2 = new LearnedEntity();
        L2.setDetail("คอร์สเรียนตัดหญ้า");
        L2.setCompany(company1);
        L2.setMaid(maid);
        L2.setCourse(course2);
        L2.setSkill(rank);
        if (learnedRepository.findBycourseAndMaid(course2, maid) == null) {
            L2.setCheckObject(true);
        }

        try {
            L2.setDateLearned(formatter5.parse("Fri, Oct 18 2019 00:00:00"));
            entityManager.persist(L2);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("===========In testLearnedEntityLearnMoreCourseInOneDay============");
            System.out.println(e.getConstraintViolations());
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        } catch (ParseException e) {
            System.out.println("===========In testLearnedEntityLearnMoreCourseInOneDay============");
            System.out.println(e);
            e.printStackTrace();
        } catch (javax.persistence.PersistenceException e) {
            System.out.println("===========In testLearnedEntityLearnMoreCourseInOneDay============");
            e.printStackTrace();
            System.out.println(e);
        }
    }

    // ////////////////////////////////////////////////////////////////////////////////
    // //****************************************************************************//
    // //***********************TEST CASE FOR SKILL ENTITY***************************//
    // //****************************************************************************//
    // ////////////////////////////////////////////////////////////////////////////////

    // TEST SKILL ENTITY SUCCESS
    @Test
    public void testSkillEntitySuccess() {
        SkillEntity K = new SkillEntity();
        K.setSkillRank("Noob");
        entityManager.persist(K);
        entityManager.flush();
        System.out.println("TEST SKILL ENTITY ALL VALID SUCCESS");
    }

    // TEST NULL SKILL RANK ENTITY
    @Test
    public void testSkillEntitySkillRankNull() {
        SkillEntity K = new SkillEntity();
        K.setSkillRank(null);
        try {
            entityManager.persist(K);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("===========In testSkillEntitySuccessSkillRankNull============");
            System.out.println(e.getConstraintViolations());
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    // TEST UNIQUE SKILL RANK
    @Test
    public void testSkillEntitySkillRankUnique() {
        SkillEntity K = new SkillEntity();
        K.setSkillRank("MasterZ");
        entityManager.persist(K);
        entityManager.flush();

        SkillEntity K2 = new SkillEntity();
        K2.setSkillRank("MasterZ");
        try {
            entityManager.persist(K2);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("===========In testSkillEntitySuccessSkillRankUnique============");
            System.out.println(e.getConstraintViolations());
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        } catch (javax.persistence.PersistenceException e) {
            System.out.println("===========In testSkillEntitySuccessSkillRankUnique============");
            System.out.println("===================UNIQUE COLUMN======================");
            e.printStackTrace();
        }
    }

    // TEST INVALID PATTERN SKILL RANK
    @Test
    public void testSkillEntitySkillRankInvalidPattern() {
        SkillEntity K = new SkillEntity();
        K.setSkillRank("Master193");
        try {
            entityManager.persist(K);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("===========In testSkillEntitySkillRankInvalidPattern============");
            System.out.println(e.getConstraintViolations());
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    // ////////////////////////////////////////////////////////////////////////////////
    // //****************************************************************************//
    // //********************TEST CASE FOR COURSE TYPE ENTITY************************//
    // //****************************************************************************//
    // ////////////////////////////////////////////////////////////////////////////////

    // TEST COURSE ENTITY SUCCESS
    @Test
    public void testCourseTypeEntitySuccess() {
        CourseTypeEntity C = new CourseTypeEntity();
        C.setCourseType("งานในบ้าน");
        entityManager.persist(C);
        entityManager.flush();
        System.out.println("TEST COURSE TYPE ENTITY ALL VALID SUCCESS");
    }

    // TEST NULL COURSE TYPE
    @Test
    public void testCourseTypeEntityNullCourseType() {
        CourseTypeEntity C = new CourseTypeEntity();
        C.setCourseType(null);
        try {
            entityManager.persist(C);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("===========In testCourseTypeEntityNullCourseType============");
            System.out.println(e.getConstraintViolations());
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    // TEST UNIQUE COURSE TYPE
    @Test
    public void testCourseTypeEntityUniqueCourseType() {
        CourseTypeEntity C = new CourseTypeEntity();
        C.setCourseType("งานบ้าน");
        entityManager.persist(C);
        entityManager.flush();

        CourseTypeEntity C2 = new CourseTypeEntity();
        C2.setCourseType("งานบ้าน");
        try {
            entityManager.persist(C2);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("===========In testCourseTypeEntityUniqueCourseType============");
            System.out.println(e.getConstraintViolations());
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        } catch (javax.persistence.PersistenceException e) {
            System.out.println("===========In testCourseTypeEntityUniqueCourseType============");
            e.printStackTrace();
        }
    }

    // TEST INVALID PATTERN COURSE TYPE
    @Test
    public void testCourseTypeEntityInvalidPatternCourseType() {
        CourseTypeEntity C = new CourseTypeEntity();
        C.setCourseType("งานบ้าน123");
        try {
            entityManager.persist(C);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("===========In testCourseTypeEntityInvalidPatternCourseType============");
            System.out.println(e.getConstraintViolations());
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    // ////////////////////////////////////////////////////////////////////////////////
    // //****************************************************************************//
    // //***********************TEST CASE FOR COURSE ENTITY**************************//
    // //****************************************************************************//
    // ////////////////////////////////////////////////////////////////////////////////

    // TEST COURSE ENTITY SUCCESS
    @Test
    public void testCourseEntitySuccess() {
        CourseEntity C = new CourseEntity();
        C.setCourseTitle("เรียนดำน้ำ");
        C.setCourseDetail("เรียนที่นี่ที่เดียว");
        entityManager.persist(C);
        entityManager.flush();
        System.out.println("TEST COURSE ENTITY ALL VALID SUCCESS");

    }

    // TEST NULL COURSE TITLE
    @Test
    public void testCourseEntityNullCourseTitle() {
        CourseEntity C = new CourseEntity();
        C.setCourseTitle(null);
        C.setCourseDetail("เรียนที่นี่ที่เดียว");
        try {
            entityManager.persist(C);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("===========In testCourseEntityNullCourseTitle============");
            System.out.println(e.getConstraintViolations());
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    // TEST NULL COURSE DETAIL
    @Test
    public void testCourseEntityNullCourseDetail() {
        CourseEntity C = new CourseEntity();
        C.setCourseTitle("เรียนขับเรือดำน้ำ");
        C.setCourseDetail(null);
        try {
            entityManager.persist(C);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("===========In testCourseEntityNullCourseDetail============");
            System.out.println(e.getConstraintViolations());
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
}
