package sut.se.g18;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Before;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import sut.se.g18.Entity.ContractEntity;
import sut.se.g18.Repository.ContractRepository;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ContractTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ContractRepository contractRepository;

    private Validator validator;

    private SimpleDateFormat formatter5 = new SimpleDateFormat("E, MMM dd yyyy HH:mm:ss");

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void contextLoads() {
        System.out.println("Test Successful");
    }

    @Test
    public void testSuccess() {
        ContractEntity c = new ContractEntity();
        c.setCost(400);
        c.setDetail("ทำสัญญาแม่บ้าน");

        try {
            c.setDateStart(formatter5.parse("Thu, Oct 18 2019 00:00:00"));
            entityManager.persist(c);
            entityManager.flush();

            //fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 0);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    //ถ้า int มีค่า null จะเซทเป็น 0
    @Test
    public void testZeroInt() {
        ContractEntity c = new ContractEntity();
        c.setCost(0);
        c.setDetail("ทำสัญญาแม่บ้าน");

        try {
            c.setDateStart(formatter5.parse("Thu, Oct 18 2019 00:00:00"));
            entityManager.persist(c);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    //กำหนดให้แม่บ้านทำสัญญาต่ำสุด 1 วัน ค่าแรงขั้นต่ำ ไม่น่าจะน้อยกว่า 300 บาท
    @Test
    public void testCostMin() {
        ContractEntity c = new ContractEntity();
        c.setCost(299);
        c.setDetail("ทำสัญญาแม่บ้าน");

        try {
            c.setDateStart(formatter5.parse("Thu, Oct 18 2019 00:00:00"));
            entityManager.persist(c);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    //กำหนดให้แม่บ้านทำสัญญาสูงสุด 1 ปี โดยค่าสัญญาไม่เกิน 99999 บาท
    @Test
    public void testCostMax() {
        ContractEntity c = new ContractEntity();
        c.setCost(100000);
        c.setDetail("ทำสัญญาแม่บ้าน");

        try {
            c.setDateStart(formatter5.parse("Thu, Oct 18 2019 00:00:00"));
            entityManager.persist(c);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    //ต้องเป็นวันที่ในอนาคตเท่านั้น
    @Test
    public void testDateFutureOnly() {
        ContractEntity c = new ContractEntity();
        c.setCost(500);
        c.setDetail("ทำสัญญาแม่บ้าน");

        try {
            c.setDateStart(formatter5.parse("Thu, Oct 18 2018 00:00:00"));
            entityManager.persist(c);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testNullDetail() {
        ContractEntity c = new ContractEntity();
        c.setCost(400);
        c.setDetail(null);

        try {
            c.setDateStart(formatter5.parse("Thu, Oct 18 2019 00:00:00"));
            entityManager.persist(c);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testMinLengthDetail() {
        ContractEntity c = new ContractEntity();
        c.setCost(400);
        c.setDetail("ทำสัญ");

        try {
            c.setDateStart(formatter5.parse("Thu, Oct 18 2019 00:00:00"));
            entityManager.persist(c);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2); //Size เท่ากับ 2 เพราะผิด Pattern ด้วย
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testMaxLengthDetail() {
        ContractEntity c = new ContractEntity();
        c.setCost(400);
        c.setDetail("ทำสัญญากับแม่บ้านเป็นระยะเวลาหนึ่งปีเป็นจำนวนเงินหนึ่งแสนบาท");

        try {
            c.setDateStart(formatter5.parse("Thu, Oct 18 2019 00:00:00"));
            entityManager.persist(c);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testPatternDetail() {
        ContractEntity c = new ContractEntity();
        c.setCost(400);
        c.setDetail("ทำสัญากับแม่บ้าน");

        try {
            c.setDateStart(formatter5.parse("Thu, Oct 18 2019 00:00:00"));
            entityManager.persist(c);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
