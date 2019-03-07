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
import java.util.logging.ErrorManager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(SpringRunner.class)
@DataJpaTest
public class SelectTest {
    @Autowired
    private TestEntityManager entityManager;

    private Validator validator;

    private SimpleDateFormat formatter5 = new SimpleDateFormat("E, MMM dd yyyy HH:mm:ss");

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();

    }

    // TEST SELECT ENTITY SUCCESS
    @Test
    public void testSelectEntitySuccess() {
        MaidSelectEntity m = new MaidSelectEntity();
        m.setWorkingday("เสาร์-อาทิตย์");
        m.setMainjob("กวาดบ้าน");
        m.setSecondaryjob("ล้างจาน");
        m.setPlace("เรียนรวม");
        try {
            m.setDatepick(formatter5.parse("Thu, Oct 18 2019 00:00:00"));
            entityManager.persist(m);
            entityManager.flush();
            System.out.println("TEST SELECT ENTITY SUCCESS");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("=======================FROM testSelectEntitySuccess========================");
            System.out.println(e.getConstraintViolations());
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 0);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    // TEST SELECT ENTITY NULL WORKING DAY
    @Test
    public void testSelectEntityNullWorkingDate() {
        MaidSelectEntity m = new MaidSelectEntity();
        m.setWorkingday(null);
        m.setMainjob("กวาดบ้าน");
        m.setSecondaryjob("ล้างจาน");
        m.setPlace("เรียนรวม");
        try {
            m.setDatepick(formatter5.parse("Thu, Oct 18 2019 00:00:00"));
            entityManager.persist(m);
            entityManager.flush();
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("=======================FROM testSelectEntityNullWorkingDate========================");
            System.out.println(e.getConstraintViolations());
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    // TEST SELECT ENTITY MIN LENGTH WORKING DAY
    @Test
    public void testSelectEntityMinLengthWorkingDate() {
        MaidSelectEntity m = new MaidSelectEntity();
        m.setWorkingday("อา");
        m.setMainjob("กวาดบ้าน");
        m.setSecondaryjob("ล้างจาน");
        m.setPlace("เรียนรวม");
        try {
            m.setDatepick(formatter5.parse("Thu, Oct 18 2019 00:00:00"));
            entityManager.persist(m);
            entityManager.flush();
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println(
                    "=======================FROM testSelectEntityMinLengthWorkingDate========================");
            System.out.println(e.getConstraintViolations());
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    // TEST SELECT ENTITY MAX LENGTH WORKING DAY
    @Test
    public void testSelectEntityMaxLengthWorkingDate() {
        MaidSelectEntity m = new MaidSelectEntity();
        m.setWorkingday(
                "อาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาทิตตตตตตตตตตตตตตตตตตตตตตตตตตตตตตตย์");
        m.setMainjob("กวาดบ้าน");
        m.setSecondaryjob("ล้างจาน");
        m.setPlace("เรียนรวม");
        try {
            m.setDatepick(formatter5.parse("Thu, Oct 18 2019 00:00:00"));
            entityManager.persist(m);
            entityManager.flush();
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println(
                    "=======================FROM testSelectEntityMaxLengthWorkingDate========================");
            System.out.println(e.getConstraintViolations());
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    // TEST SELECT ENTITY INVALID PATTERN WORKING DAY
    @Test
    public void testSelectEntityInvalidPatternWorkingDate() {
        MaidSelectEntity m = new MaidSelectEntity();
        m.setWorkingday("Sunday");
        m.setMainjob("กวาดบ้าน");
        m.setSecondaryjob("ล้างจาน");
        m.setPlace("เรียนรวม");
        try {
            m.setDatepick(formatter5.parse("Thu, Oct 18 2019 00:00:00"));
            entityManager.persist(m);
            entityManager.flush();
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println(
                    "=======================FROM testSelectEntityInvalidPatternWorkingDate========================");
            System.out.println(e.getConstraintViolations());
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    // TEST SELECT ENTITY NULL MAIN JOB
    @Test
    public void testSelectEntityNullMainJob() {
        MaidSelectEntity m = new MaidSelectEntity();
        m.setWorkingday("เสาร์-อาทิตย์");
        m.setMainjob(null);
        m.setSecondaryjob("ล้างจาน");
        m.setPlace("เรียนรวม");
        try {
            m.setDatepick(formatter5.parse("Thu, Oct 18 2019 00:00:00"));
            entityManager.persist(m);
            entityManager.flush();
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("=======================FROM testSelectEntityNullMainJob========================");
            System.out.println(e.getConstraintViolations());
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
    // TEST SELECT ENTITY MIN LENGTH MAIN JOB
    @Test
    public void testSelectEntityMinLengthMainJob() {
        MaidSelectEntity m = new MaidSelectEntity();
        m.setWorkingday("เสาร์-อาทิตย์");
        m.setMainjob("ล้");
        m.setSecondaryjob("ล้างจาน");
        m.setPlace("เรียนรวม");
        try {
            m.setDatepick(formatter5.parse("Thu, Oct 18 2019 00:00:00"));
            entityManager.persist(m);
            entityManager.flush();
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("=======================FROM testSelectEntityMinLengthMainJob========================");
            System.out.println(e.getConstraintViolations());
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
    // TEST SELECT ENTITY MAX LENGTH MAIN JOB
    @Test
    public void testSelectEntityMaxLengthMainJob() {
        MaidSelectEntity m = new MaidSelectEntity();
        m.setWorkingday("เสาร์-อาทิตย์");
        m.setMainjob("ล้าาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาางงงงงงงงงงงงงงงงงงงงงงงงงงงงงงงงงงงงงงงงงจจจจจจจจจจจจจจจจจาาาาาาาาาาาาาาาาาาาาาาานนนนนนนนนนนนนนนน");
        m.setSecondaryjob("ล้างจาน");
        m.setPlace("เรียนรวม");
        try {
            m.setDatepick(formatter5.parse("Thu, Oct 18 2019 00:00:00"));
            entityManager.persist(m);
            entityManager.flush();
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("=======================FROM testSelectEntityMaxLengthMainJob========================");
            System.out.println(e.getConstraintViolations());
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
    // TEST SELECT ENTITY INVALID PATTERN MAIN JOB
    @Test
    public void testSelectEntityInvalidPatternMainJob() {
        MaidSelectEntity m = new MaidSelectEntity();
        m.setWorkingday("เสาร์-อาทิตย์");
        m.setMainjob("Wash");
        m.setSecondaryjob("ล้างจาน");
        m.setPlace("เรียนรวม");
        try {
            m.setDatepick(formatter5.parse("Thu, Oct 18 2019 00:00:00"));
            entityManager.persist(m);
            entityManager.flush();
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("=======================FROM testSelectEntityInvalidPatternMainJob========================");
            System.out.println(e.getConstraintViolations());
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
    // TEST SELECT ENTITY NULL SECONDARY JOB
    @Test
    public void testSelectEntityNullSecondaryJob() {
        MaidSelectEntity m = new MaidSelectEntity();
        m.setWorkingday("เสาร์-อาทิตย์");
        m.setMainjob("กวาดบ้าน");
        m.setSecondaryjob(null);
        m.setPlace("เรียนรวม");
        try {
            m.setDatepick(formatter5.parse("Thu, Oct 18 2019 00:00:00"));
            entityManager.persist(m);
            entityManager.flush();
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("=======================FROM testSelectEntityNullSecondaryJob========================");
            System.out.println(e.getConstraintViolations());
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
    // TEST SELECT ENTITY MIN LENGTH SECONDARY JOB
    @Test
    public void testSelectEntityMinLengthSecondaryJob() {
        MaidSelectEntity m = new MaidSelectEntity();
        m.setWorkingday("เสาร์-อาทิตย์");
        m.setMainjob("กวาดบ้าน");
        m.setSecondaryjob("ล้");
        m.setPlace("เรียนรวม");
        try {
            m.setDatepick(formatter5.parse("Thu, Oct 18 2019 00:00:00"));
            entityManager.persist(m);
            entityManager.flush();
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("=======================FROM testSelectEntityMinLengthSecondaryJob========================");
            System.out.println(e.getConstraintViolations());
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
    // TEST SELECT ENTITY MAX LENGTH SECONDARY JOB
    @Test
    public void testSelectEntityMaxLengthSecondaryJob() {
        MaidSelectEntity m = new MaidSelectEntity();
        m.setWorkingday("เสาร์-อาทิตย์");
        m.setMainjob("กวาดบ้าน");
        m.setSecondaryjob("ล้าาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาางงงงงงงงงงงงงงงงงงงงงงงงงงงงงงจจจจจจจจจจจจาาาาาาาาาาาาาาาาาาาานนนนนนนนนนนนนนนนนน");
        m.setPlace("เรียนรวม");
        try {
            m.setDatepick(formatter5.parse("Thu, Oct 18 2019 00:00:00"));
            entityManager.persist(m);
            entityManager.flush();
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("=======================FROM testSelectEntityMaxLengthSecondaryJob========================");
            System.out.println(e.getConstraintViolations());
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
    // TEST SELECT ENTITY INVALID PATTERN SECONDARY JOB
    @Test
    public void testSelectEntityInvalidPatternSecondaryJob() {
        MaidSelectEntity m = new MaidSelectEntity();
        m.setWorkingday("เสาร์-อาทิตย์");
        m.setMainjob("กวาดบ้าน");
        m.setSecondaryjob("Wash");
        m.setPlace("เรียนรวม");
        try {
            m.setDatepick(formatter5.parse("Thu, Oct 18 2019 00:00:00"));
            entityManager.persist(m);
            entityManager.flush();
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("=======================FROM testSelectEntityInvalidPatternSecondaryJob========================");
            System.out.println(e.getConstraintViolations());
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
    // TEST SELECT ENTITY NULL PLACE
    @Test
    public void testSelectEntityNullPlace() {
        MaidSelectEntity m = new MaidSelectEntity();
        m.setWorkingday("เสาร์-อาทิตย์");
        m.setMainjob("กวาดบ้าน");
        m.setSecondaryjob("ล้างจาน");
        m.setPlace(null);
        try {
            m.setDatepick(formatter5.parse("Thu, Oct 18 2019 00:00:00"));
            entityManager.persist(m);
            entityManager.flush();
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("=======================FROM testSelectEntityNullPlace========================");
            System.out.println(e.getConstraintViolations());
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
    // TEST SELECT ENTITY MIN LENGTH PLACE
    @Test
    public void testSelectEntityMinLengthPlace() {
        MaidSelectEntity m = new MaidSelectEntity();
        m.setWorkingday("เสาร์-อาทิตย์");
        m.setMainjob("กวาดบ้าน");
        m.setSecondaryjob("ล้างจาน");
        m.setPlace("เร");
        try {
            m.setDatepick(formatter5.parse("Thu, Oct 18 2019 00:00:00"));
            entityManager.persist(m);
            entityManager.flush();
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("=======================FROM testSelectEntityMinLengthPlace========================");
            System.out.println(e.getConstraintViolations());
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
    // TEST SELECT ENTITY MAX LENGTH PLACE
    @Test
    public void testSelectEntityMaxLengthPlace() {
        MaidSelectEntity m = new MaidSelectEntity();
        m.setWorkingday("เสาร์-อาทิตย์");
        m.setMainjob("กวาดบ้าน");
        m.setSecondaryjob("ล้างจาน");
        m.setPlace("เเเเเเเเเเเรียยยยยยยยยยยยยยยยยยยยยนนนนนนนนนนนนนนนนนนรรรรรรรรรรรรรรรรรรรรรรรรรรรววววววววววววววววววววววววววมมมมมมมมมมมมมมมมม");
        try {
            m.setDatepick(formatter5.parse("Thu, Oct 18 2019 00:00:00"));
            entityManager.persist(m);
            entityManager.flush();
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("=======================FROM testSelectEntityMaxLengthPlace========================");
            System.out.println(e.getConstraintViolations());
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
    // TEST SELECT ENTITY NULL PLACE
    @Test
    public void testSelectEntityInvalidPatternPlace() {
        MaidSelectEntity m = new MaidSelectEntity();
        m.setWorkingday("เสาร์-อาทิตย์");
        m.setMainjob("กวาดบ้าน");
        m.setSecondaryjob("ล้างจาน");
        m.setPlace("ZZZZZ");
        try {
            m.setDatepick(formatter5.parse("Thu, Oct 18 2019 00:00:00"));
            entityManager.persist(m);
            entityManager.flush();
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("=======================FROM testSelectEntityInvalidPatternPlace========================");
            System.out.println(e.getConstraintViolations());
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

}