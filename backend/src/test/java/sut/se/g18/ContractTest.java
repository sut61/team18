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
import sut.se.g18.Entity.ContractTypeEntity;
import sut.se.g18.Entity.MaidStatusEntity;
import sut.se.g18.Entity.PaymentStatusEntity;
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

    // ////////////////////////////////////////////////////////////////////////////////
    // //****************************************************************************//
    // //**********************TEST CASE FOR CONTRACT ENTITY*************************//
    // //****************************************************************************//
    // ////////////////////////////////////////////////////////////////////////////////

    @Test
    public void testContractEntitySuccess() {
        ContractEntity c = new ContractEntity();
        c.setCost(400);
        c.setDetail("ทำสัญญาแม่บ้าน");

        try {
            c.setDateStart(formatter5.parse("Thu, Oct 18 2019 00:00:00"));
            entityManager.persist(c);
            entityManager.flush();
            System.out.println("=======================FROM testSuccess========================");
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
    public void testContractEntityZeroInt() {
        ContractEntity c = new ContractEntity();
        c.setCost(0);
        c.setDetail("ทำสัญญาแม่บ้าน");

        try {
            c.setDateStart(formatter5.parse("Thu, Oct 18 2019 00:00:00"));
            entityManager.persist(c);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("=======================FROM testContractEntityZeroInt========================");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    //กำหนดให้แม่บ้านทำสัญญาต่ำสุด 1 วัน ค่าแรงขั้นต่ำ ไม่น่าจะน้อยกว่า 300 บาท
    @Test
    public void testContractEntityCostMin() {
        ContractEntity c = new ContractEntity();
        c.setCost(299);
        c.setDetail("ทำสัญญาแม่บ้าน");

        try {
            c.setDateStart(formatter5.parse("Thu, Oct 18 2019 00:00:00"));
            entityManager.persist(c);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("=======================FROM testContractEntityCostMin========================");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    //กำหนดให้แม่บ้านทำสัญญาสูงสุด 1 ปี โดยค่าสัญญาไม่เกิน 99999 บาท
    @Test
    public void testContractEntityCostMax() {
        ContractEntity c = new ContractEntity();
        c.setCost(100000);
        c.setDetail("ทำสัญญาแม่บ้าน");

        try {
            c.setDateStart(formatter5.parse("Thu, Oct 18 2019 00:00:00"));
            entityManager.persist(c);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("=======================FROM testContractEntityCostMax========================");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    //ต้องเป็นวันที่ในอนาคตเท่านั้น
    @Test
    public void testContractEntityDateFutureOnly() {
        ContractEntity c = new ContractEntity();
        c.setCost(500);
        c.setDetail("ทำสัญญาแม่บ้าน");

        try {
            c.setDateStart(formatter5.parse("Thu, Oct 18 2018 00:00:00"));
            entityManager.persist(c);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("=======================FROM testContractEntityDateFutureOnly========================");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testContractEntityNullDetail() {
        ContractEntity c = new ContractEntity();
        c.setCost(400);
        c.setDetail(null);

        try {
            c.setDateStart(formatter5.parse("Thu, Oct 18 2019 00:00:00"));
            entityManager.persist(c);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("=======================FROM testContractEntityNullDetail========================");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testContractEntityMinLengthDetail() {
        ContractEntity c = new ContractEntity();
        c.setCost(400);
        c.setDetail("ทำสัญ");

        try {
            c.setDateStart(formatter5.parse("Thu, Oct 18 2019 00:00:00"));
            entityManager.persist(c);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("=======================FROM testContractEntityMinLengthDetail========================");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2); //Size เท่ากับ 2 เพราะผิด Pattern ด้วย
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testContractEntityMaxLengthDetail() {
        ContractEntity c = new ContractEntity();
        c.setCost(400);
        c.setDetail("ทำสัญญากับแม่บ้านเป็นระยะเวลาหนึ่งปีเป็นจำนวนเงินหนึ่งแสนบาท");

        try {
            c.setDateStart(formatter5.parse("Thu, Oct 18 2019 00:00:00"));
            entityManager.persist(c);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("=======================FROM testContractEntityMaxLengthDetail========================");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testContractEntityPatternDetail() {
        ContractEntity c = new ContractEntity();
        c.setCost(400);
        c.setDetail("ทำสัญากับแม่บ้าน");

        try {
            c.setDateStart(formatter5.parse("Thu, Oct 18 2019 00:00:00"));
            entityManager.persist(c);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("=======================FROM testContractEntityPatternDetail========================");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    // ////////////////////////////////////////////////////////////////////////////////
    // //****************************************************************************//
    // //*******************TEST CASE FOR CONTRACT TYPE ENTITY***********************//
    // //****************************************************************************//
    // ////////////////////////////////////////////////////////////////////////////////

    @Test
    public void testContractTypeEntitySuccess() {
        ContractTypeEntity c = new ContractTypeEntity();
        c.setContractType("1 Year KK");
        try {
            entityManager.persist(c);
            entityManager.flush();

            //fail("Should not pass to this line");
            System.out.println("=======================FROM testContractTypeEntitySuccess========================");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("=======================FROM testContractTypeEntityNullContractType========================");
            System.out.println(e);
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 0);
        }
    }

    @Test
    public void testContractTypeEntityNullContractType() {
        ContractTypeEntity c = new ContractTypeEntity();
        c.setContractType(null);
        try {
            entityManager.persist(c);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("=======================FROM testContractTypeEntityNullContractType========================");
            System.out.println(e);
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testContractTypeEntityUniqueContractType() {
        ContractTypeEntity c = new ContractTypeEntity();
        c.setContractType("1 Monthh");
        entityManager.persist(c);
        entityManager.flush();

        ContractTypeEntity c2 = new ContractTypeEntity();
        c2.setContractType("1 Monthh");
        try {
            entityManager.persist(c2);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("=======================FROM testContractTypeEntityUniqueContractType========================");
            System.out.println(e);
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        } catch (javax.persistence.PersistenceException e) {
            e.printStackTrace();
        }
    }

    // ////////////////////////////////////////////////////////////////////////////////
    // //****************************************************************************//
    // //*********************TEST CASE FOR MAID STATUS ENTITY***********************//
    // //****************************************************************************//
    // ////////////////////////////////////////////////////////////////////////////////

    @Test
    public void testMaidStatusEntitySuccess() {
        MaidStatusEntity m = new MaidStatusEntity();
        m.setStatus("ว่าง");
        try {
            entityManager.persist(m);
            entityManager.flush();

            //fail("Should not pass to this line");
            System.out.println("=======================FROM testMaidStatusEntitySuccess========================");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("=======================FROM testMaidStatusEntitySuccess========================");
            System.out.println(e);
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 0);
        }
    }

    @Test
    public void testMaidStatusEntityNullStatus() {
        MaidStatusEntity m = new MaidStatusEntity();
        m.setStatus(null);
        try {
            entityManager.persist(m);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("=======================FROM testMaidStatusEntityNullStatus========================");
            System.out.println(e);
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testMaidStatusEntityUniqueStatus() {
        MaidStatusEntity m = new MaidStatusEntity();
        m.setStatus("ว่าง");
        entityManager.persist(m);
        entityManager.flush();

        MaidStatusEntity m2 = new MaidStatusEntity();
        m2.setStatus("ว่าง");
        try {
            entityManager.persist(m2);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("=======================FROM testMaidStatusEntityUniqueStatus========================");
            System.out.println(e);
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        } catch (javax.persistence.PersistenceException e) {
            e.printStackTrace();
        }
    }

    // ////////////////////////////////////////////////////////////////////////////////
    // //****************************************************************************//
    // //********************TEST CASE FOR PAYMENT STATUS ENTITY*********************//
    // //****************************************************************************//
    // ////////////////////////////////////////////////////////////////////////////////

    @Test
    public void testPaymentStatusEntitySuccess() {
        PaymentStatusEntity p = new PaymentStatusEntity();
        p.setPaymentStatus("จ่าย");
        try {
            entityManager.persist(p);
            entityManager.flush();

            //fail("Should not pass to this line");
            System.out.println("=======================FROM testPaymentStatusEntitySuccess========================");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("=======================FROM testPaymentStatusEntitySuccess========================");
            System.out.println(e);
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 0);
        }
    }

    @Test
    public void testPaymentStatusEntityNullStatus() {
        PaymentStatusEntity p = new PaymentStatusEntity();
        p.setPaymentStatus(null);
        try {
            entityManager.persist(p);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("=======================FROM testPaymentStatusEntityNullStatus========================");
            System.out.println(e);
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testPaymentStatusEntityUniqueStatus() {
        PaymentStatusEntity p = new PaymentStatusEntity();
        p.setPaymentStatus("จ่าย");
        entityManager.persist(p);
        entityManager.flush();

        PaymentStatusEntity p2 = new PaymentStatusEntity();
        p2.setPaymentStatus("จ่าย");
        try {
            entityManager.persist(p2);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("=======================FROM testPaymentStatusEntityUniqueStatus========================");
            System.out.println(e);
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        } catch (javax.persistence.PersistenceException e) {
            e.printStackTrace();
        }
    }
}
