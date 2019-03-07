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
public class ReviewTest{
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private MaidRegisterRepository maidRegisterRepository;
    @Autowired
    private ReviewRepository reviewRepository;
    
    @Autowired
    private ScoreRepository scoreRepository;
    @Autowired
    private TypeReviewRepository typeReviewRepository;
    
    private Validator validator;
   
    private ScoreEntity sc;
    private MaidRegisterEntity me;
    private TypeReviewEntity ty;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
       
        sc = scoreRepository.findByscoreId(5L);
        me = maidRegisterRepository.findByMaidId(1L);
        ty = typeReviewRepository.findBytypereviewId(1L);
        
    }
    //test testSuccess
    @Test
    public void testSuccess() {
        ReviewEntity r = new ReviewEntity();
        r.setReview("ดีมากกกกกกกกก");
        r.setScoreEntity(sc);
        r.setMaidRegisterEntity(me);
        r.setAdjust("นิสัย");
        r.setTypeReviewEntity(ty);
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

    //test testSuccessScore
    @Test
    public void testSuccessScore() {
        ScoreEntity r = new ScoreEntity();
        r.setScore("score");
        
        try {
           
            entityManager.persist(r);
            System.out.println("**********************************************");
            System.out.println("Success-Class-Score");
            System.out.println("**********************************************");
            entityManager.flush();

            //fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 0);
        } 
    }
    
    //Null-ScoreClass
    @Test
    public void testNullCleassScor() {
        ScoreEntity r = new ScoreEntity();
        r.setScore(null);
        
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
            System.out.println("====================Null-Class-Score========================");
        } 
    }
   
    //test testSuccesstypereview
    @Test
    public void testSuccesstypereview() {
        TypeReviewEntity r = new TypeReviewEntity();
        r.setTypereview("Ohhhhh");
        
        try {
           
            entityManager.persist(r);
            System.out.println("**********************************************");
            System.out.println("Success-Class-Typereview");
            System.out.println("**********************************************");
            entityManager.flush();

            //fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 0);
        } 
    }
    //Null-typeClass
    @Test
    public void typeClass() {
        TypeReviewEntity r = new TypeReviewEntity();
        r.setTypereview(null);
        
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
            System.out.println("====================Null-Class-Typereview========================");
        } 
    }

    //Null-Review
    @Test
    public void testNullDetail() {
        ReviewEntity r = new ReviewEntity();
        r.setReview(null);
       
        r.setScoreEntity(sc);
        r.setMaidRegisterEntity(me);
        r.setAdjust("นิสัย");
        r.setTypeReviewEntity(ty);
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
            System.out.println("====================Null-Review========================");
        } 
    }
    
    
    //Null-Score
    @Test
    public void testNullScore() {
        ReviewEntity r = new ReviewEntity();
        r.setReview("ดีมากกกกกกกกก");
   
        r.setScoreEntity(null);
        r.setMaidRegisterEntity(me);
        r.setAdjust("นิสัย");
        r.setTypeReviewEntity(ty);
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
            System.out.println("====================Null-Score========================");
        } 
    }

    //Null-Maid
    @Test
    public void testNullScoreMaid() {
        ReviewEntity r = new ReviewEntity();
        r.setReview("ดีมากกกกกกกกก");
   
        r.setScoreEntity(sc);
        r.setMaidRegisterEntity(null);
        r.setAdjust("นิสัย");
        r.setTypeReviewEntity(ty);
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
            System.out.println("====================Null-Maid========================");
        } 
    }
    //Null-adj
    @Test
    public void testNulladj() {
        ReviewEntity r = new ReviewEntity();
        r.setReview("ดีมากกกกกกกกก");
   
        r.setScoreEntity(sc);
        r.setMaidRegisterEntity(me);
        r.setAdjust(null);
        r.setTypeReviewEntity(ty);
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
            System.out.println("====================Null-adjust========================");
        } 
    }
    //Null-type
    @Test
    public void testNulltype() {
        ReviewEntity r = new ReviewEntity();
        r.setReview("ดีมากกกกกกกกก");
   
        r.setScoreEntity(sc);
        r.setMaidRegisterEntity(me);
        r.setAdjust("นิสัย");
        r.setTypeReviewEntity(null);
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
            System.out.println("====================Null-type========================");
        } 
    }
    //Min
    @Test
    public void testMinSizeDetail() {
        ReviewEntity r = new ReviewEntity();
        r.setReview("ดี");

        r.setScoreEntity(sc);
        r.setMaidRegisterEntity(me);
        r.setAdjust("นิสัย");
        r.setTypeReviewEntity(ty);
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
        ReviewEntity r = new ReviewEntity();
        r.setReview("ดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดี");

        r.setScoreEntity(sc);
        r.setMaidRegisterEntity(me);
        r.setAdjust("นิสัย");
        r.setTypeReviewEntity(ty);

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
        ReviewEntity r = new ReviewEntity();
        r.setReview("So Good");
   
        r.setScoreEntity(sc);
        r.setMaidRegisterEntity(me);
        r.setAdjust("นิสัย");
        r.setTypeReviewEntity(ty);
 
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
        ReviewEntity r = new ReviewEntity();
        
        r.setReview("ดีดีดีดีดีดีดี");

        r.setScoreEntity(sc);
        r.setMaidRegisterEntity(me);
        r.setAdjust("นิสัย");
        r.setTypeReviewEntity(ty);


        entityManager.persist(r);
		entityManager.flush();
        try{
            ReviewEntity rr = new ReviewEntity();
            rr.setReview("ดีดีดีดีดีดีดี");

            rr.setScoreEntity(sc);
            rr.setMaidRegisterEntity(me);
            rr.setAdjust("นิสัย");
            rr.setTypeReviewEntity(ty);

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