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
    @Autowired
    private ElectricalEquipmentRepository electricalEquipmentRepository;
    
    private Validator validator;
    private MaidRegisterEntity me;
    private CustomerEntity cu;
    private CleaningEquipmentEntity cl;
    private ElectricalEquipmentEntity el;

    //------------------------------------------------
    

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        me = maidRegisterRepository.findByMaidId(1L);
        cu = customerRepository.findBycustomerId(1L);
        cl = cleaningEquipmentRepository.findBycleaningId(1L);
        el = electricalEquipmentRepository.findByelectricId(1L);
        
    }
    //test testSuccess
    @Test
    public void testSuccess() {
        LendEquipmentEntity r = new LendEquipmentEntity();
        
        r.setLendData("ไม่มี");
        r.setRegisterEntity(me);
        r.setCustomerEntity(cu);
        r.setCleaningEquipmentEntity(cl);
        r.setElectricalEquipmentEntity(el);
        
        try {
           
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
    //test testSuccess Elect
    @Test
    public void testSuccessElect() {
        ElectricalEquipmentEntity r = new ElectricalEquipmentEntity();
        
        r.setElectric("Elect");
        
        
        try {
           
            entityManager.persist(r);
            System.out.println("**********************************************");
            System.out.println("Success Elect");
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
    //Null-Elect
    @Test
    public void testNullElectinClass() {
        ElectricalEquipmentEntity r = new ElectricalEquipmentEntity();
        
        r.setElectric(null);
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
            System.out.println("====================Null-Class-Elect========================");
        } 
    }

    //Null-Lend
    @Test
    public void testNullDetail() {
        LendEquipmentEntity r = new LendEquipmentEntity();
        
        r.setLendData(null);
        r.setRegisterEntity(me);
        r.setCustomerEntity(cu);
        r.setCleaningEquipmentEntity(cl);
        r.setElectricalEquipmentEntity(el);
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
            System.out.println("====================Null-Lend========================");
        } 
    }
     //Null-Meid
     @Test
     public void testNullMaid() {
         LendEquipmentEntity r = new LendEquipmentEntity();
         
         r.setLendData("ไม่มี");
         r.setRegisterEntity(null);
         r.setCustomerEntity(cu);
         r.setCleaningEquipmentEntity(cl);
         r.setElectricalEquipmentEntity(el);
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
             System.out.println("====================Null-Meid========================");
         } 
     }
     //Null-Cus
     @Test
     public void testNullCus() {
         LendEquipmentEntity r = new LendEquipmentEntity();
         
         r.setLendData("ไม่มี");
         r.setRegisterEntity(me);
         r.setCustomerEntity(null);
         r.setCleaningEquipmentEntity(cl);
         r.setElectricalEquipmentEntity(el);
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
             System.out.println("====================Null-Cus========================");
         } 
     }
     //Null-Clean
     @Test
     public void testNullClean() {
         LendEquipmentEntity r = new LendEquipmentEntity();
         
         r.setLendData("ไม่มี");
         r.setRegisterEntity(me);
         r.setCustomerEntity(cu);
         r.setCleaningEquipmentEntity(null);
         r.setElectricalEquipmentEntity(el);
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
             System.out.println("====================Null-Clean========================");
         } 
     }
     //Null-Elect
     @Test
     public void testNullElect() {
         LendEquipmentEntity r = new LendEquipmentEntity();
         
         r.setLendData("ไม่มี");
         r.setRegisterEntity(me);
         r.setCustomerEntity(cu);
         r.setCleaningEquipmentEntity(cl);
         r.setElectricalEquipmentEntity(null);
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
             System.out.println("====================Null-Elect========================");
         } 
     }
    //Min
    @Test
    public void testMinSizeDetail() {
        LendEquipmentEntity r = new LendEquipmentEntity();
         
         r.setLendData("ไ");
         r.setRegisterEntity(me);
         r.setCustomerEntity(cu);
         r.setCleaningEquipmentEntity(cl);
         r.setElectricalEquipmentEntity(el);
        try {
           
            entityManager.persist(r);
            entityManager.flush();

            //fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("**********************************************");
            System.out.println(e);
            System.out.println("====================testMinSizeDetail========================");
            System.out.println(e);
            
        } 
    }


    // TEST MAX SIZE DETAIL
    @Test
    public void testMaxSizeDetail() {
        LendEquipmentEntity r = new LendEquipmentEntity();
         
         r.setLendData("ไม่มีมีมีมีมีมีมีมีมีมีมีมีมีมีมีมีมีมีมีมีมีมีมีมีมีมีมีมีมีมีมีมีมีมีมีมีมีมีมีมีมีมีมีมีมีมีมีมีมีมีมีมีมีมีมีมีมีมีมี");
         r.setRegisterEntity(me);
         r.setCustomerEntity(cu);
         r.setCleaningEquipmentEntity(cl);
         r.setElectricalEquipmentEntity(el);

        try {
           
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
    }

     // TEST INVALID PATTERN DETAIL
     @Test
     public void testInvalidPatternDetail() {
        LendEquipmentEntity r = new LendEquipmentEntity();
         
         r.setLendData("Sooooooooo");
         r.setRegisterEntity(me);
         r.setCustomerEntity(cu);
         r.setCleaningEquipmentEntity(cl);
         r.setElectricalEquipmentEntity(el);
 
         try {
            
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
     }


     //Test unique colum
    @Test(expected=javax.persistence.PersistenceException.class)
    public void uniqueColum(){
        LendEquipmentEntity r = new LendEquipmentEntity();
         
         r.setLendData("ไม่มีครับ");
         r.setRegisterEntity(me);
         r.setCustomerEntity(cu);
         r.setCleaningEquipmentEntity(cl);
         r.setElectricalEquipmentEntity(el);
        entityManager.persist(r);
		entityManager.flush();
        try{
            LendEquipmentEntity rr = new LendEquipmentEntity();
         
                rr.setLendData("ไม่มีครับ");
                rr.setRegisterEntity(me);
                rr.setCustomerEntity(cu);
                rr.setCleaningEquipmentEntity(cl);
                rr.setElectricalEquipmentEntity(el);
                entityManager.persist(rr);
		        entityManager.flush();
            
            fail("Should not pass to this line");
        } catch (javax.persistence.PersistenceException e) {
            System.out.println("++++++++++++++++++++++++++++++");
            System.out.println("Unique colum " + e);
            System.out.println("++++++++++++++++++++++++++++++");
          throw new javax.persistence.PersistenceException();
        }
        
    }
}