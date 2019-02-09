package sut.se.g18;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import sut.se.g18.Entity.*;
import sut.se.g18.Repository.CompanyRepository;
import sut.se.g18.Repository.ComplaintRepository;
import sut.se.g18.Repository.ComplaintTypeRepository;
import sut.se.g18.Repository.MaidRegisterRepository;

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

import org.junit.Before;
import org.junit.Test;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ComplaintTest {

    @Autowired
    private ComplaintRepository complaintRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private MaidRegisterRepository maidRegisterRepository;

    @Autowired
    private ComplaintTypeRepository complaintTypeRepository;


    @Autowired
    private TestEntityManager entityManager;

    private Validator validator;

    private CompanyEntity company1;

    private ComplaintTypeEntity comType1;

    private MaidRegisterEntity maid;

    private SimpleDateFormat formatter5 = new SimpleDateFormat("E, MMM dd yyyy HH:mm:ss");

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        company1 = companyRepository.findBycompanyName("พีกาซัส");
        maid = maidRegisterRepository.findBymaidName("Ping Kasinan");
        comType1 = complaintTypeRepository.findBycomplaintType("พฤติกรรมไม่เหมาะสม");

    }

    @Test
    public void testComplaintSuccess() {
        ComplaintEntity comEn = new ComplaintEntity();
        comEn.setCompanyEntity(company1);
        comEn.setMaid(maid);
        comEn.setComplaintTypeEntity(comType1);
        comEn.setComDetail("เรื่อง ชอบเถียงเวลาสอนงาน");

        try {
            comEn.setComplaintDate(formatter5.parse("Thu, Oct 18 2019 00:00:00"));
            entityManager.persist(comEn);
            entityManager.flush();

       // fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("========================testComplaintSuccess============================");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 0);
        }catch (ParseException e) {
            e.printStackTrace();
        }
    }

    //TEST NULL CompanyEntiy
    @Test
    public void testNullCompany()  {
        ComplaintEntity comEn = new ComplaintEntity();
        comEn.setCompanyEntity(null);
        comEn.setMaid(maid);
        comEn.setComplaintTypeEntity(comType1);
        comEn.setComDetail("เรื่อง ชอบเถียงเวลาสอนงาน");


        try {
            comEn.setComplaintDate(formatter5.parse("Thu, Oct 18 2019 00:00:00"));
            entityManager.persist(comEn);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("========================testNullCompany============================");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    //TEST NULL MaidEntiy
    @Test
    public void testNullMaid()  {
        ComplaintEntity comEn = new ComplaintEntity();
        comEn.setCompanyEntity(company1);
        comEn.setMaid(null);
        comEn.setComplaintTypeEntity(comType1);
        comEn.setComDetail("เรื่อง ชอบเถียงเวลาสอนงาน");


        try {
            comEn.setComplaintDate(formatter5.parse("Thu, Oct 18 2019 00:00:00"));
            entityManager.persist(comEn);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("========================testNullMaid============================");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

     //TEST NULL ComplaintTypeEntiy
     @Test
     public void testNullComplaintType()  {
         ComplaintEntity comEn = new ComplaintEntity();
         comEn.setCompanyEntity(company1);
         comEn.setMaid(maid);
         comEn.setComplaintTypeEntity(null);
         comEn.setComDetail("เรื่อง ชอบเถียงเวลาสอนงาน");


         try {
             comEn.setComplaintDate(formatter5.parse("Thu, Oct 18 2019 00:00:00"));
             entityManager.persist(comEn);
             entityManager.flush();

             fail("Should not pass to this line");
         } catch (javax.validation.ConstraintViolationException e) {
             System.out.println("========================testNullComplaintType============================");
             System.out.println(e);
             Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
             assertEquals(violations.isEmpty(), false);
             assertEquals(violations.size(), 1);
         } catch (ParseException e) {
             e.printStackTrace();
         }
     }

      //TEST NULL dateNull
      @Test
      public void testNullDate()  {
          ComplaintEntity comEn = new ComplaintEntity();
          comEn.setCompanyEntity(company1);
          comEn.setMaid(maid);
          comEn.setComplaintTypeEntity(null);
          comEn.setComDetail("เรื่อง ชอบเถียงเวลาสอนงาน");
          comEn.setComplaintDate(null);

          try {

              entityManager.persist(comEn);
              entityManager.flush();

              fail("Should not pass to this line");
          } catch (javax.validation.ConstraintViolationException e) {
              System.out.println("========================testNullDate============================");
              System.out.println(e);
              Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
              assertEquals(violations.isEmpty(), false);
              assertEquals(violations.size(), 1);
          }
      }


    // TEST NULL comDETAIL
    @Test
    public void testNullcomDetail()  {
        ComplaintEntity comEn = new ComplaintEntity();
        comEn.setCompanyEntity(company1);
        comEn.setMaid(maid);
        comEn.setComplaintTypeEntity(comType1);
        comEn.setComDetail(null);


        try {
            comEn.setComplaintDate(formatter5.parse("Thu, Oct 18 2019 00:00:00"));
            entityManager.persist(comEn);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("========================testNullcomDetail============================");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    // TEST MIN SIZE ComDETAIL
    @Test
    public void testMinSizeComDetail() {
        ComplaintEntity comEn = new ComplaintEntity();
        comEn.setCompanyEntity(company1);
        comEn.setMaid(maid);
        comEn.setComplaintTypeEntity(comType1);
        comEn.setComDetail("เรื");

        try {
            comEn.setComplaintDate(formatter5.parse("Thu, Oct 18 2019 00:00:00"));
            entityManager.persist(comEn);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("========================testMinSizeComDetail============================");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    // TEST MAX SIZE DETAIL
    @Test
    public void testMaxSizeComDetail() {
        ComplaintEntity comEn = new ComplaintEntity();
        comEn.setCompanyEntity(company1);
        comEn.setMaid(maid);
        comEn.setComplaintTypeEntity(comType1);
        comEn.setComDetail("AAAAAAAAAABBBBBBBBBCCCCCCCCCCDDDDDDDDDDEEEEEEEEEFFFFFFFFF");

        try {
            comEn.setComplaintDate(formatter5.parse("Thu, Oct 18 2019 00:00:00"));
            entityManager.persist(comEn);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("========================testMaxSizeComDetail============================");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

      // TEST INVALID PATTERN DETAIL
      @Test
      public void testInvalidPatternComDetail() {
         ComplaintEntity comEn = new ComplaintEntity();
         comEn.setCompanyEntity(company1);
         comEn.setMaid(maid);
         comEn.setComplaintTypeEntity(comType1);
         comEn.setComDetail("เรอง แม่บ้านขี้เกียจ");


          try {
              comEn.setComplaintDate(formatter5.parse("Thu, Oct 18 2019 00:00:00"));
              entityManager.persist(comEn);
              entityManager.flush();

              fail("Should not pass to this line");
          } catch (javax.validation.ConstraintViolationException e) {
              System.out.println("========================testInvalidPatternComDetail============================");
              System.out.println(e);
              Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
              assertEquals(violations.isEmpty(), false);
              assertEquals(violations.size(), 1);
          } catch (ParseException e) {
             e.printStackTrace();
         }
      }

    // test uniquedetail
      @Test
      public void testUniqueDetail() {
        ComplaintEntity comEn = new ComplaintEntity();
        comEn.setComDetail("เรื่อง ขี้น้อยใจ");

          try {

              entityManager.persist(comEn);
              entityManager.flush();

              // fail("Should not pass to this line");
          } catch (javax.validation.ConstraintViolationException e) {
              Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
              assertEquals(violations.isEmpty(), false);
              assertEquals(violations.size(), 1);
              System.out.println("==============================testUniqueDetail=============================");
              System.out.println(e);
          } catch (javax.persistence.PersistenceException e) {
              e.printStackTrace();
          }

          ComplaintEntity comEn2 = new ComplaintEntity();
          comEn2.setComDetail("เรื่อง ขี้น้อยใจ");

          try {

              entityManager.persist(comEn2);
              entityManager.flush();

              //fail("Should not pass to this line");
          } catch (javax.validation.ConstraintViolationException e) {
              Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
              System.out.println("==============================testUnique=============================");
              System.out.println(e);
              assertEquals(violations.isEmpty(), false);
              assertEquals(violations.size(), 1);
          } catch (javax.persistence.PersistenceException e) {
              e.printStackTrace();
          }
      }

       //TEST INVALID DATE
    @Test
    public void testConplaintInvalidDate() {
        ComplaintEntity comEn = new ComplaintEntity();
         comEn.setCompanyEntity(company1);
         comEn.setMaid(maid);
         comEn.setComplaintTypeEntity(comType1);
         comEn.setComDetail("เรื่อง แม่บ้านขี้เกียจ");

        try {
            comEn.setComplaintDate(formatter5.parse("Thu, Oct 18 2018 00:00:00"));
            entityManager.persist(comEn);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("===========In testConplaintInvalidDate============");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        } catch (ParseException e) {
            System.out.println("===========In testConplaintInvalidDate============");
            System.out.println(e);
            e.printStackTrace();
        }
    }


}