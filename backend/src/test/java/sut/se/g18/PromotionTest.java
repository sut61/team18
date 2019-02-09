package sut.se.g18;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import sut.se.g18.Entity.*;
import sut.se.g18.Repository.CompanyRepository;
import sut.se.g18.Repository.PromotionRepository;
import sut.se.g18.Repository.PromotionTypeRepository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.text.ParseException;
import java.util.Collections;
import java.util.OptionalInt;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.hibernate.annotations.SourceType;
import org.junit.Before;
import org.junit.Test;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PromotionTest {


    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private PromotionTypeRepository promotionTypeRepository;

    @Autowired
    private PromotionRepository promotionRepository;


    @Autowired
    private TestEntityManager entityManager;

    private Validator validator;

    private CompanyEntity company1;

    private PromotionTypeEntity proType;

    private SimpleDateFormat formatter5 = new SimpleDateFormat("E, MMM dd yyyy HH:mm:ss");

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        company1 = companyRepository.findBycompanyName("พีกาซัส");
        proType = promotionTypeRepository.findBypromotionType("ส่วนลด");
        

    }

    @Test
    public void testPromotionSuccess() {
        PromotionEntity pe = new PromotionEntity();
        pe.setCompanyEntity(company1);
        pe.setPromotionTypeEntity(proType);
        pe.setDiscount(15);
        pe.setTitle("โปรโมชั่น ลดราคา");

        try {
            pe.setDateStart(formatter5.parse("Thu, Oct 18 2019 00:00:00"));
            pe.setDateEnd(formatter5.parse("Fri, Oct 19 2019 00:00:00"));
            entityManager.persist(pe);
            entityManager.flush();

       // fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("========================testPromotionSuccess============================");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 0);
        }catch (ParseException e) {
            e.printStackTrace();
        }
    }

    // test companyNull
    @Test
    public void testCompanyNull() {
        PromotionEntity pe = new PromotionEntity();
        pe.setCompanyEntity(null);
        pe.setPromotionTypeEntity(proType);
        pe.setDiscount(15);
        pe.setTitle("โปรโมชั่น ลดราคา");

        try {
            pe.setDateStart(formatter5.parse("Thu, Oct 18 2019 00:00:00"));
            pe.setDateEnd(formatter5.parse("Fri, Oct 19 2019 00:00:00"));
            entityManager.persist(pe);
            entityManager.flush();

       // fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("========================testCompanyNull============================");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }catch (ParseException e) {
            e.printStackTrace();
        }
    }

    // test testProtypeNull
    @Test
    public void testProtypeNull() {
        PromotionEntity pe = new PromotionEntity();
        pe.setCompanyEntity(company1);
        pe.setPromotionTypeEntity(null);
        pe.setDiscount(15);
        pe.setTitle("โปรโมชั่น ลดราคา");

        try {
            pe.setDateStart(formatter5.parse("Thu, Oct 18 2019 00:00:00"));
            pe.setDateEnd(formatter5.parse("Fri, Oct 19 2019 00:00:00"));
            entityManager.persist(pe);
            entityManager.flush();

       // fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("========================testProtypeNull============================");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }catch (ParseException e) {
            e.printStackTrace();
        }
    }
    
    // test testTitleNull
    @Test
    public void testTitleNull() {
        PromotionEntity pe = new PromotionEntity();
        pe.setCompanyEntity(company1);
        pe.setPromotionTypeEntity(null);
        pe.setDiscount(15);
        pe.setTitle(null);

        try {
            pe.setDateStart(formatter5.parse("Thu, Oct 18 2019 00:00:00"));
            pe.setDateEnd(formatter5.parse("Fri, Oct 19 2019 00:00:00"));
            entityManager.persist(pe);
            entityManager.flush();

       // fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("========================testTitleNull============================");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }catch (ParseException e) {
            e.printStackTrace();
        }
    }
        
        // test uniquetitle
      @Test
      public void testUniqueTitle() {
        PromotionEntity pe = new PromotionEntity();
        pe.setTitle("โปรโมชั่น ลดมาก");

          try {

              entityManager.persist(pe);
              entityManager.flush();

               fail("Should not pass to this line");
          } catch (javax.validation.ConstraintViolationException e) {
              Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
              assertEquals(violations.isEmpty(), false);
              assertEquals(violations.size(), 3);
              System.out.println("==============================testUniqueTitle=============================");
              System.out.println(e);
          } catch (javax.persistence.PersistenceException e) {
              e.printStackTrace();
          }

          PromotionEntity pe2= new PromotionEntity();
          pe2.setTitle("โปรโมชั่น ลดมาก");
  

          try {

              entityManager.persist(pe2);
              entityManager.flush();

              fail("Should not pass to this line");
          } catch (javax.validation.ConstraintViolationException e) {
              Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
              System.out.println("==============================testUniqueTitle=============================");
              System.out.println(e);
              assertEquals(violations.isEmpty(), false);
              assertEquals(violations.size(), 3);
          } catch (javax.persistence.PersistenceException e) {
              e.printStackTrace();
          }
      }
      
       //TEST testdateStartNull
       @Test
       public void testdateStartNull() {
        PromotionEntity pe = new PromotionEntity();
        pe.setCompanyEntity(company1);
        pe.setPromotionTypeEntity(proType);
        pe.setDiscount(15);
        pe.setTitle("โปรโมชั่น ลดราคา");
        pe.setDateStart(null);
        
        try {
            pe.setDateEnd(formatter5.parse("Fri, Oct 19 2019 00:00:00"));
            entityManager.persist(pe);
            entityManager.flush();

       // fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("========================testdateStartNull============================");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

         //TEST testdateEndNull
       @Test
       public void testdateEndNull() {
        PromotionEntity pe = new PromotionEntity();
        pe.setCompanyEntity(company1);
        pe.setPromotionTypeEntity(proType);
        pe.setDiscount(15);
        pe.setTitle("โปรโมชั่น ลดราคา");
        pe.setDateEnd(null);
        
        try {
            pe.setDateStart(formatter5.parse("Fri, Oct 19 2019 00:00:00"));
            entityManager.persist(pe);
            entityManager.flush();

        fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("========================testdateEndNull============================");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    //discount max
    @Test
    public void testMaxDiscount() {
        PromotionEntity pe = new PromotionEntity();
        pe.setCompanyEntity(company1);
        pe.setPromotionTypeEntity(proType);
        pe.setDiscount(101);
        pe.setTitle("โปรโมชั่น ลดราคา");
        try {
            pe.setDateStart(formatter5.parse("Thu, Oct 18 2019 00:00:00"));
            entityManager.persist(pe);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("=======================testMaxDiscount========================");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
 


}