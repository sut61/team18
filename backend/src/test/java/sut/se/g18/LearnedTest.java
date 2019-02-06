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
        company1 = companyRepository.findBycompanyName("พีกาซัส");
        maid = maidRegisterRepository.findBymaidName("Ping Kasinan");
        course = courseRepository.findByCourseTitle("คอร์สอบรมการตกแต่งกิ่งต้นบอนไซ");
        course2 = courseRepository.findByCourseTitle("คอร์สฝึกสอนทำอาหารอีสาน");
        rank = skillRepository.findBySkillRank("Guru");
    }

    @Test
    public void testSuccess() {
        LearnedEntity L = new LearnedEntity();
        L.setDetail("คอร์สเรียนตัดหญ้า");
        L.setCompany(company1);
        L.setMaid(maid);
        L.setCourse(course);
        L.setSkill(rank);
        L.setCheckObject(true);

        try {
            L.setDateLearned(formatter5.parse("Thu, Oct 18 2019 00:00:00"));
            entityManager.persist(L);
            entityManager.flush();

            //fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("===========In tsetSuccess============");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 0);
        } catch (ParseException e) {
            System.out.println("===========In tsetSuccess============");
            System.out.println(e);
            e.printStackTrace();
        }
    }

    // TEST NULL DETAIL
    @Test
    public void testNullDetail() {
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
            System.out.println("===========In testNullDetail============");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        } catch (ParseException e) {
            System.out.println("===========In testNullDetail============");
            System.out.println(e);
            e.printStackTrace();
        }
    }

    // TEST MIN SIZE DETAIL
    @Test
    public void testMinSizeDetail() {
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
            System.out.println("===========In testMinSizeDetail============");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2); //ผิด Pattern ด้วย
        } catch (ParseException e) {
            System.out.println("===========In testMinSizeDetail============");
            System.out.println(e);
            e.printStackTrace();
        }
    }

    // TEST MAX SIZE DETAIL
    @Test
    public void testMaxSizeDetail() {
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
            System.out.println("===========In testMaxSizeDetail============");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        } catch (ParseException e) {
            System.out.println("===========In testMaxSizeDetail============");
            System.out.println(e);
            e.printStackTrace();
        }
    }

    // TEST INVALID PATTERN DETAIL
    @Test
    public void testInvalidPatternDetail() {
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
            System.out.println("===========In testInvalidPatternDetail============");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        } catch (ParseException e) {
            System.out.println("===========In testInvalidPatternDetail============");
            System.out.println(e);
            e.printStackTrace();
        }
    }

    //TEST INVALID DATE
    @Test
    public void testInvalidDate() {
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
            System.out.println("===========In testInvalidDate============");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        } catch (ParseException e) {
            System.out.println("===========In testInvalidDate============");
            System.out.println(e);
            e.printStackTrace();
        }
    }

    // TEST RE INSERT SAME OBJECT (MAID AND COURSE)
    @Test
    public void testReInsertObject() {
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
            System.out.println("===========In testReInsertObject============");
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
        if(learnedRepository.findBycourseAndMaid(course, maid) == null){
            L2.setCheckObject(true);
        }

        try {
            L2.setDateLearned(formatter5.parse("Sat, Oct 19 2019 00:00:00"));
            entityManager.persist(L2);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("===========In testReInsertObject============");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        } catch (ParseException e) {
            System.out.println("===========In testReInsertObject============");
            System.out.println(e);
            e.printStackTrace();
        }
    }

    // TEST LEARN 2 OR MORE COURSES IN 1 DAY
    @Test
    public void testDate() {
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
            System.out.println("===========In testDate============");
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
        if(learnedRepository.findBycourseAndMaid(course2, maid) == null){
            L2.setCheckObject(true);
        }

        try {
            L2.setDateLearned(formatter5.parse("Fri, Oct 18 2019 00:00:00"));
            entityManager.persist(L2);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("===========In testDate============");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        } catch (ParseException e) {
            System.out.println("===========In testDate============");
            System.out.println(e);
            e.printStackTrace();
        } catch (javax.persistence.PersistenceException e){
            System.out.println("===========In testDate============");
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
