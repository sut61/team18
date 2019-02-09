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
import sut.se.g18.Entity.CompanyTypeEntity;
import sut.se.g18.Entity.CustomerEntity;

import sut.se.g18.Entity.ProvinceEntity;
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
    public void testSuccess() {
        CompanyEntity c = new CompanyEntity();
        c.setCompanyName("บริษัทบ้านสะอาดจำกัดมหาชน");
        c.setCompanyAddress("19/1 หมู่ 3 มหาวิทยาลัยเทคโนโลยีสุรนารี");
        c.setCompanyPhone("055555555");
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
        c.setCompanyPhone("066666666");
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
        c.setCompanyPhone("077777777");
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
        c.setCompanyPhone("088888888");
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
        c.setCompanyPhone("099999999");


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
        c.setCompanyPhone("012222222");
        entityManager.persist(c);
        entityManager.flush();

        CompanyEntity c1 = new CompanyEntity();
        c1.setCompanyName("บริษัทร้านสะอาดจำกัดมหาชน");
        c1.setCompanyAddress("250 หมู่ 3");
        c.setCompanyPhone("012222222");

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
    @Test
    public void testMinsizephone() {
        CompanyEntity c = new CompanyEntity();
        c.setCompanyName("dd");
        c.setCompanyAddress("18/1 หมู่ 3 มหาวิทยาลัยเทคโนโลยีสุรนารี");
        c.setCompanyPhone("7777777");
        try {

            entityManager.persist(c);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("=========== from testMinsizephone ====================");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }
    }
    @Test
    public void testMaxsizephone() {
        CompanyEntity c = new CompanyEntity();
        c.setCompanyName("aaaaaaddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd");
        c.setCompanyAddress("20/1 หมู่ 3 มหาวิทยาลัยเทคโนโลยีสุรนารี");
        c.setCompanyPhone("88888888888888");
        try {

            entityManager.persist(c);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("=============== from testMaxsizephone ================================");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }
    }
    @Test
    public void testPatternPhone() {
        CompanyEntity c = new CompanyEntity();
        c.setCompanyName("บ้านสะอาดจำกัดมหาชน");
        c.setCompanyAddress("22/1 หมู่ 3 มหาวิทยาลัยเทคโนโลยีสุรนารี");
        c.setCompanyPhone("999999999");


        try{
            entityManager.persist(c);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("=========================== from testPatternPhone ========================");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    @Test
    public void testCompanyTypeUnique() {
        CompanyTypeEntity ct = new CompanyTypeEntity();
        ct.setCompanyType("บริษัทอิอิอิ");
        entityManager.persist(ct);
        entityManager.flush();

        CompanyTypeEntity ct1 = new CompanyTypeEntity();
        ct.setCompanyType("บริษัทอิอิอิ");

        try{
            entityManager.persist(ct1);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("================FROM testCompanyTypeUnique ======================");
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
    @Test
    public void testProvinceUnique() {
        ProvinceEntity p = new ProvinceEntity();
        p.setProvinceName("กทม");
        entityManager.persist(p);
        entityManager.flush();

        ProvinceEntity p1 = new ProvinceEntity();
        p1.setProvinceName("กทม");

        try{
            entityManager.persist(p1);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("================FROM testProvinceUnique ======================");
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


