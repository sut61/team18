package sut.se.g18;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Before;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;


import sut.se.g18.Entity.CompanyEntity;
import sut.se.g18.Entity.CustomerEntity;

import sut.se.g18.Repository.CustomerRepository;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)

@DataJpaTest

public class CompanyTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CustomerRepository customerRepository;

    private Validator validator;


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
        CompanyEntity c = new CompanyEntity();
        c.setCompanyName("บริษัทบ้านสะอาดจำกัดมหาชน");
        c.setCompanyAddress("19/1 หมู่ 3 มหาวิทยาลัยเทคโนโลยีสุรนารี");
        try {

            entityManager.persist(c);
            entityManager.flush();

            //fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("================ from testSuccess =================");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testNameNull() {
        CompanyEntity c = new CompanyEntity();
        c.setCompanyName(null);
        c.setCompanyAddress("19/1 หมู่ 3 มหาวิทยาลัยเทคโนโลยีสุรนารี");
        try {

            entityManager.persist(c);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("==================== from testNameNull =====================");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    @Test
    public void testMinsize() {
        CompanyEntity c = new CompanyEntity();
        c.setCompanyName("d");
        c.setCompanyAddress("19/1 หมู่ 3 มหาวิทยาลัยเทคโนโลยีสุรนารี");
        try {

            entityManager.persist(c);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("=========== from testMinsize ====================");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }
    }
    @Test
    public void testMaxsize() {
        CompanyEntity c = new CompanyEntity();
        c.setCompanyName("ddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd");
        c.setCompanyAddress("19/1 หมู่ 3 มหาวิทยาลัยเทคโนโลยีสุรนารี");
        try {

            entityManager.persist(c);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("=============== from testMaxsize ================================");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }
    }
    @Test
    public void testPatternDetail() {
        CompanyEntity c = new CompanyEntity();
        c.setCompanyName("บ้านสะอาดจำกัดมหาชน");
        c.setCompanyAddress("19/1 หมู่ 3 มหาวิทยาลัยเทคโนโลยีสุรนารี");


        try{
            entityManager.persist(c);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("=========================== from testPatternDetail ========================");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testinvalidvariable() {
        CompanyEntity c = new CompanyEntity();
        c.setCompanyName("บริษัทบ้านสะอาดจำกัดมหาชน");
        c.setCompanyAddress("250 หมู่ 3");
        entityManager.persist(c);
        entityManager.flush();

        CompanyEntity c1 = new CompanyEntity();
        c1.setCompanyName("บริษัทร้านสะอาดจำกัดมหาชน");
        c1.setCompanyAddress("250 หมู่ 3");


        try{
            entityManager.persist(c1);
            entityManager.flush();

            fail("Should not pass to this line");
    } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("================FROM testinvalidvariable ======================");
            e.printStackTrace();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
        catch (javax.persistence.PersistenceException e){
            System.out.println("==================================================================");
            e.printStackTrace();
        }
    }
}


