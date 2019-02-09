package sut.se.g18;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Collections;
import java.util.OptionalInt;
import java.util.Set;
import java.text.ParseException;

import javax.persistence.PersistenceException;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Before;
import org.junit.Test;

import sut.se.g18.Entity.*;
import sut.se.g18.Repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@RunWith(SpringRunner.class)
@DataJpaTest
public class WelfareAndSalaryTest{
    @Autowired
    private TestEntityManager entityManager;
    
    private Validator validator;
    @Autowired
    private CompanyRepository compaR;

    @Autowired
    private TypeworkingRepository typeR;

    @Autowired
    private TypewelfareRepository typewelR;

    @Before
	public void setup() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();

    }
    
    //888888888888888888888888888888888888888888888888888888888888888888//
    //888888888888888888888888888888888888888888888888888888888888888888//
    //8888888888888888Test for WelfareAndSalaryEntity888888888888888888//
    //888888888888888888888888888888888888888888888888888888888888888888//
    //888888888888888888888888888888888888888888888888888888888888888888//


    //Test Add Data Success//
    @Test
    public void addDataSuccess(){
        WelfareAndSalaryEntity welsa = new WelfareAndSalaryEntity();
        welsa.setWelsaName("รถประจำตำแหน่ง");
        welsa.setSalary(300);
        welsa.setDatail("มีรถประจำตำแหน่งทั้งหมด 5 คันเป็นรถเก๋งสองคัน เบนซ์ 3คัน");
        welsa.setTermCon("ต้องมาทำงานตรงเวลาทุกๆวันและไม่มีการประพฤติกฎระเบียบราชการ");
        try {
            entityManager.persist(welsa);
            entityManager.flush();
            System.out.println("=================================================");
            System.out.println("Add Data WelfareAndSalary Success");
            System.out.println("=================================================");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("=================================================");
            System.out.println("Error" + e.getMessage());
            System.out.println("=================================================");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 0);
        }
    }

    //Test Data was Null//
    @Test
    public void datawasNull(){
        WelfareAndSalaryEntity welsa = new WelfareAndSalaryEntity();
        welsa.setWelsaName(null);
        welsa.setSalary(900);
        welsa.setDatail(null);
        welsa.setTermCon(null);
        try {
            entityManager.persist(welsa);
            entityManager.flush();
            fail("Should not pass this line");
        } catch(javax.validation.ConstraintViolationException e){
            System.out.println("=================================================");
            System.out.println("Error Data was Null" + e.getMessage());
            System.out.println("=================================================");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 3);
        }
    }
    //Test Salary less than min//
    @Test
    public void salarylessThanMin(){
        WelfareAndSalaryEntity welsa = new WelfareAndSalaryEntity();
        welsa.setWelsaName("รถประจำตำแหน่ง");
        welsa.setSalary(200);
        welsa.setDatail("มีรถประจำตำแหน่งทั้งหมด 5 คันเป็นรถเก๋งสองคัน เบนซ์ 3คัน");
        welsa.setTermCon("ต้องมาทำงานตรงเวลาทุกๆวันและไม่มีการประพฤติกฎระเบียบราชการ");
        try {
            entityManager.persist(welsa);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e){
            System.out.println("=================================================");
            System.out.println("Error Salary less than Min " + e.getMessage());
            System.out.println("=================================================");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    
    //Test Salary larger than max//
    @Test
    public void salarylargerThanMin(){
        WelfareAndSalaryEntity welsa = new WelfareAndSalaryEntity();
        welsa.setWelsaName("รถประจำตำแหน่ง");
        welsa.setSalary(200000);
        welsa.setDatail("มีรถประจำตำแหน่งทั้งหมด 5 คันเป็นรถเก๋งสองคัน เบนซ์ 3คัน");
        welsa.setTermCon("ต้องมาทำงานตรงเวลาทุกๆวันและไม่มีการประพฤติกฎระเบียบราชการ");
        try {
            entityManager.persist(welsa);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e){
            System.out.println("=================================================");
            System.out.println("Error Salary larger than Max " + e.getMessage());
            System.out.println("=================================================");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    //Test Detail and TermCondition less than size//
    @Test
    public void detailAndtermconLessthanSize(){
        WelfareAndSalaryEntity welsa = new WelfareAndSalaryEntity();
        welsa.setWelsaName("รถประจำตำแหน่ง");
        welsa.setSalary(300);
        welsa.setDatail("มีรถประจำตำแหน่ง");
        welsa.setTermCon("ต้องมาทำงานตรงเวลา");
        try {
            entityManager.persist(welsa);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e){
            System.out.println("=================================================");
            System.out.println("Error Detail and TermCondition less than size " + e.getMessage());
            System.out.println("=================================================");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }
    } 
    //Test Detail and TermCondition larger than size//
    @Test
    public void detailAndtermconLargerthanSize(){
        WelfareAndSalaryEntity welsa = new WelfareAndSalaryEntity();
        welsa.setWelsaName("รถประจำตำแหน่ง");
        welsa.setSalary(300);
        welsa.setDatail("มีรถประจำตำแหน่งมีรถประจำตำแหน่งมีรถประจำตำแหน่งมีรถประจำตำแหน่งมีรถประจำตำแหน่งมีรถประจำตำแหน่งมีรถประจำตำแหน่งมีรถประจำตำแหน่งมีรถประจำตำแหน่งมีรถประจำตำแหน่งมีรถประจำตำแหน่งมีรถประจำตำแหน่งมีรถประจำตำแหน่งมีรถประจำตำแหน่งมีรถประจำตำแหน่งมีรถประจำตำแหน่งมีรถประจำตำแหน่งมีรถประจำตำแหน่ง");
        welsa.setTermCon("ต้องมาทำงานตรงเวลาต้องมาทำงานตรงเวลาต้องมาทำงานตรงเวลาต้องมาทำงานตรงเวลาต้องมาทำงานตรงเวลาต้องมาทำงานตรงเวลาต้องมาทำงานตรงเวลาต้องมาทำงานตรงเวลาต้องมาทำงานตรงเวลาต้องมาทำงานตรงเวลาต้องมาทำงานตรงเวลาต้องมาทำงานตรงเวลาต้องมาทำงานตรงเวลาต้องมาทำงานตรงเวลาต้องมาทำงานตรงเวลา");
        try {
            entityManager.persist(welsa);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e){
            System.out.println("=================================================");
            System.out.println("Error Detail and TermCondition larger than size " + e.getMessage());
            System.out.println("=================================================");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }
    }
    //Test Detail and Termcondition Pattern Not match//
    @Test
    public void detailAndtermconPatternNotmatch(){
        WelfareAndSalaryEntity welsa = new WelfareAndSalaryEntity();
        welsa.setWelsaName("รถประจำตำแหน่ง");
        welsa.setSalary(300);
        welsa.setDatail("dataildataildataildatail");
        welsa.setTermCon("termContermContermContermCon");
        try {
            entityManager.persist(welsa);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e){
            System.out.println("=================================================");
            System.out.println("Error Detail and TermCondition Pattern not Match " + e.getMessage());
            System.out.println("=================================================");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }
    }
    //Test Unique column//
    @Test(expected=javax.persistence.PersistenceException.class)
    public void uniqueColumn(){
        WelfareAndSalaryEntity welsa = new WelfareAndSalaryEntity();
        welsa.setWelsaName("รถประจำตำแหน่ง");
        welsa.setSalary(300);
        welsa.setDatail("มีรถประจำตำแหน่งทั้งหมด 5 คันเป็นรถเก๋งสองคัน เบนซ์ 3คัน");
        welsa.setTermCon("ต้องมาทำงานตรงเวลาทุกๆวันและไม่มีการประพฤติกฎระเบียบราชการ");
        entityManager.persist(welsa);
        entityManager.flush();
        try {
            WelfareAndSalaryEntity welsa1 = new WelfareAndSalaryEntity();
            welsa1.setWelsaName("รถประจำตำแหน่ง");
            welsa1.setSalary(300);
            welsa1.setDatail("มีรถประจำตำแหน่งทั้งหมด 5 คันเป็นรถเก๋งสองคัน เบนซ์ 3คัน");
            welsa1.setTermCon("ต้องมาทำงานตรงเวลาทุกๆวันและไม่มีการประพฤติกฎระเบียบราชการ");
            entityManager.persist(welsa1);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.persistence.PersistenceException e){
            System.out.println("=================================================");
            System.out.println("Error Unique column " + e.getMessage());
            System.out.println("=================================================");
            
            throw new javax.persistence.PersistenceException();
        }
    }

    //888888888888888888888888888888888888888888888888888888888888888888//
    //888888888888888888888888888888888888888888888888888888888888888888//
    //8888888888888888Test for TypewelfareEntity888888888888888888888888//
    //888888888888888888888888888888888888888888888888888888888888888888//
    //888888888888888888888888888888888888888888888888888888888888888888//

    //Test add Data Success//
    @Test
    public void addDataTypeSuccess(){
        TypewelfareEntity typewel = new TypewelfareEntity();
        typewel.setTypewelName("ประกันสุขภาพ");
            try {
                entityManager.persist(typewel);
                entityManager.flush();
                System.out.println("=================================================");
                System.out.println("Add Data Typewelfare Success");
                System.out.println("=================================================");
            } catch(javax.validation.ConstraintViolationException e) {
                System.out.println("=================================================");
                System.out.println("Error" + e.getMessage());
                System.out.println("=================================================");
                Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
                assertEquals(violations.isEmpty(), false);
                assertEquals(violations.size(), 0);
            }
    }
    //Test Data was null//
    @Test
    public void dataTypewelWasNull(){
        TypewelfareEntity typewel = new TypewelfareEntity();
        typewel.setTypewelName(null);
        try {
            entityManager.persist(typewel);
            entityManager.flush();
            fail("Should not pass this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("=================================================");
            System.out.println("Error Typewelfare was Null " + e.getMessage());
            System.out.println("=================================================");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    @Test(expected=javax.persistence.PersistenceException.class)
    public void uniquecolumnTypewelfare(){
        TypewelfareEntity typewel = new TypewelfareEntity();
        typewel.setTypewelName("ประกันสุขภาพ");
        entityManager.persist(typewel);
        entityManager.flush();
            try {
                TypewelfareEntity typewel1 = new TypewelfareEntity();
                typewel1.setTypewelName("ประกันสุขภาพ");
                entityManager.persist(typewel1);
                entityManager.flush();
                
            } catch(javax.persistence.PersistenceException e) {
                System.out.println("=================================================");
                System.out.println("Error Unique Column Typewelfare " + e.getMessage());
                System.out.println("=================================================");
                throw new javax.persistence.PersistenceException();
            }
    }
    
}