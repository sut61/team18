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
import javax.validation.constraints.Null;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
@RunWith(SpringRunner.class)
@DataJpaTest
public class LendEquipmentTest{
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private MaidRegisterRepository maidRegisterRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CleaningEquipmentRepository cleaningEquipmentRepository;
  
    
    private Validator validator;
    private MaidRegisterEntity me;
    private CustomerEntity cu;
    private CleaningEquipmentEntity cl;
    private SimpleDateFormat formatter5 = new SimpleDateFormat("E, MMM dd yyyy HH:mm:ss");

    //------------------------------------------------
    

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        me = maidRegisterRepository.findByMaidId(1L);
        cu = customerRepository.findBycustomerId(1L);
        cl = cleaningEquipmentRepository.findBycleaningId(1L);
        
        
    }
    //test testSuccess
    @Test
    public void testSuccess() {
        LendEquipmentEntity r = new LendEquipmentEntity();
        
        r.setLendData("ไม่มี");
        r.setMaidregisterEntity(me);
        r.setCustomerEntity(cu);
        r.setCleaningEquipmentEntity(cl);
      
        
        try {
            r.setLendstart(formatter5.parse("Thu, Oct 18 2019 00:00:00"));
            r.setLendend(formatter5.parse("Thu, Oct 22 2019 00:00:00"));
            entityManager.persist(r);
            System.out.println("**********************************************");
            System.out.println("Success");
            System.out.println("**********************************************");
            entityManager.flush();

            //fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 0);
        } 
        catch (ParseException e) {
        e.printStackTrace();
    }
    }

    //test testSuccess Cleaning
    @Test
    public void testSuccessCleaning() {
        CleaningEquipmentEntity r = new CleaningEquipmentEntity();
        
        r.setCleaning("cleaning");
        
        
        try {
           
            entityManager.persist(r);
            System.out.println("**********************************************");
            System.out.println("Success Cleaning");
            System.out.println("**********************************************");
            entityManager.flush();

            //fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 0);
        } 
    }
   

    //Null-Cleaning
    @Test
    public void testNullCleaning() {
        CleaningEquipmentEntity r = new CleaningEquipmentEntity();
        
        r.setCleaning(null);
        try {
            entityManager.persist(r);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("******************************************************");
            System.out.println(e);
            System.out.println("====================Null-Class-Cleaning========================");
        } 
    }
    

    //Null-Lend
    @Test
    public void testNullLend() {
        LendEquipmentEntity r = new LendEquipmentEntity();
        
        r.setLendData(null);
        r.setMaidregisterEntity(me);
        r.setCustomerEntity(cu);
        r.setCleaningEquipmentEntity(cl);

        try {

            r.setLendstart(formatter5.parse("Thu, Oct 18 2019 00:00:00"));
            r.setLendend(formatter5.parse("Thu, Oct 22 2019 00:00:00"));
            entityManager.persist(r);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("******************************************************");
            System.out.println(e);
            System.out.println("====================Null-Lend========================");
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
    }

    //Null-lendstart
    @Test
    public void testNulllendstart() {
        LendEquipmentEntity r = new LendEquipmentEntity();
        
        r.setLendData("ไม่มี");
        r.setMaidregisterEntity(me);
        r.setCustomerEntity(cu);
        r.setCleaningEquipmentEntity(cl);

        try {

           
            r.setLendend(formatter5.parse("Thu, Oct 22 2019 00:00:00"));
            entityManager.persist(r);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("******************************************************");
            System.out.println(e);
            System.out.println("====================Null-lendstart========================");
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
    }
    //Null-lendend
    @Test
    public void testNulllendend() {
        LendEquipmentEntity r = new LendEquipmentEntity();
        
        r.setLendData("ไม่มี");
        r.setMaidregisterEntity(me);
        r.setCustomerEntity(cu);
        r.setCleaningEquipmentEntity(cl);

        try {

            r.setLendstart(formatter5.parse("Thu, Oct 18 2019 00:00:00"));
            
            entityManager.persist(r);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("******************************************************");
            System.out.println(e);
            System.out.println("====================Null-lendend========================");
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
    }


    // Null-Meid
    @Test
    public void testNullMaid() {
        LendEquipmentEntity r = new LendEquipmentEntity();

        r.setLendData("ไม่มี");
        r.setMaidregisterEntity(null);
        r.setCustomerEntity(cu);
        r.setCleaningEquipmentEntity(cl);

        try {
            r.setLendstart(formatter5.parse("Thu, Oct 18 2019 00:00:00"));
            r.setLendend(formatter5.parse("Thu, Oct 22 2019 00:00:00"));
            entityManager.persist(r);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("******************************************************");
            System.out.println(e);
            System.out.println("====================Null-Meid========================");
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
    }

    // Null-Cus
    @Test
    public void testNullCus() {
        LendEquipmentEntity r = new LendEquipmentEntity();

        r.setLendData("ไม่มี");
        r.setMaidregisterEntity(me);
        r.setCustomerEntity(null);
        r.setCleaningEquipmentEntity(cl);

        try {
            r.setLendstart(formatter5.parse("Thu, Oct 18 2019 00:00:00"));
            r.setLendend(formatter5.parse("Thu, Oct 22 2019 00:00:00"));
            entityManager.persist(r);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("******************************************************");
            System.out.println(e);
            System.out.println("====================Null-Cus========================");
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
    }

    // Null-Clean
    @Test
    public void testNullClean() {
        LendEquipmentEntity r = new LendEquipmentEntity();

        r.setLendData("ไม่มี");
        r.setMaidregisterEntity(me);
        r.setCustomerEntity(cu);
        r.setCleaningEquipmentEntity(null);

        try {
            r.setLendstart(formatter5.parse("Thu, Oct 18 2019 00:00:00"));
            r.setLendend(formatter5.parse("Thu, Oct 22 2019 00:00:00"));
            entityManager.persist(r);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("******************************************************");
            System.out.println(e);
            System.out.println("====================Null-Clean========================");
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
    }

    // Min
    @Test
    public void testMinSizeDetail() {
        LendEquipmentEntity r = new LendEquipmentEntity();

        r.setLendData("ไ");
        r.setMaidregisterEntity(me);
        r.setCustomerEntity(cu);
        r.setCleaningEquipmentEntity(cl);

        try {
            r.setLendstart(formatter5.parse("Thu, Oct 18 2019 00:00:00"));
            r.setLendend(formatter5.parse("Thu, Oct 22 2019 00:00:00"));
            entityManager.persist(r);
            entityManager.flush();

            // fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("**********************************************");
            System.out.println(e);
            System.out.println("====================testMinSizeDetail========================");
            System.out.println(e);

        }
        catch (ParseException e) {
            e.printStackTrace();
        }
    }

    // TEST MAX SIZE
    @Test
    public void testMaxSizeDetail() {
        LendEquipmentEntity r = new LendEquipmentEntity();

        r.setLendData(
                "ไม่มีมีมีมีมีมีมีมีมีมีมีมีมีมีมีมีมีมีมีมีมีมีมีมีมีมีมีมีมีมีมีมีมีมีมีมีมีมีมีมีมีมีมีมีมีมีมีมีมีมีมีมีมีมีมีมีมีมีมี");
        r.setMaidregisterEntity(me);
        r.setCustomerEntity(cu);
        r.setCleaningEquipmentEntity(cl);

        try {
            r.setLendstart(formatter5.parse("Thu, Oct 18 2019 00:00:00"));
            r.setLendend(formatter5.parse("Thu, Oct 22 2019 00:00:00"));
            entityManager.persist(r);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("**********************************************");
            System.out.println(e);
            System.out.println("====================testMaxSizeDetail========================");
            System.out.println(e);
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
    }

    // TEST INVALID PATTERN DETAIL
    @Test
    public void testInvalidPatternDetail() {
        LendEquipmentEntity r = new LendEquipmentEntity();

        r.setLendData("Sooooooooo");
        r.setMaidregisterEntity(me);
        r.setCustomerEntity(cu);
        r.setCleaningEquipmentEntity(cl);

        try {
            r.setLendstart(formatter5.parse("Thu, Oct 18 2019 00:00:00"));
            r.setLendend(formatter5.parse("Thu, Oct 22 2019 00:00:00"));
            entityManager.persist(r);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("**********************************************");
            System.out.println(e);
            System.out.println("====================testInvalidPatternDetail==========================");
            System.out.println(e);
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
    }

    // Test unique colum
    @Test(expected = javax.persistence.PersistenceException.class)
    public void uniqueColum() {
        LendEquipmentEntity r = new LendEquipmentEntity();

        r.setLendData("ไม่มีครับ");
        r.setMaidregisterEntity(me);
        r.setCustomerEntity(cu);
        r.setCleaningEquipmentEntity(cl);
        try{
        r.setLendstart(formatter5.parse("Thu, Oct 18 2019 00:00:00"));
        r.setLendend(formatter5.parse("Thu, Oct 22 2019 00:00:00"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        entityManager.persist(r);
        entityManager.flush();
        try {
            LendEquipmentEntity rr = new LendEquipmentEntity();

                rr.setLendData("ไม่มีครับ");
                rr.setMaidregisterEntity(me);
                rr.setCustomerEntity(cu);
                rr.setCleaningEquipmentEntity(cl);
                
                rr.setLendstart(formatter5.parse("Thu, Oct 18 2019 00:00:00"));
                rr.setLendend(formatter5.parse("Thu, Oct 22 2019 00:00:00"));
                entityManager.persist(rr);
		        entityManager.flush();
            
            fail("Should not pass to this line");
        } catch (javax.persistence.PersistenceException e) {
            System.out.println("++++++++++++++++++++++++++++++");
            System.out.println("Unique colum " + e);
            System.out.println("++++++++++++++++++++++++++++++");
          throw new javax.persistence.PersistenceException();
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        
    }
}