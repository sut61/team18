// package sut.se.g18;

// import org.junit.Before;
// import org.junit.Test;
// import org.junit.runner.RunWith;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
// import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
// import org.springframework.test.context.junit4.SpringRunner;
// import sut.se.g18.Entity.*;
// import sut.se.g18.Repository.*;

// import javax.validation.ConstraintViolation;
// import javax.validation.Validation;
// import javax.validation.Validator;
// import javax.validation.ValidatorFactory;
// import javax.validation.constraints.Null;

// import java.text.ParseException;
// import java.text.SimpleDateFormat;
// import java.util.Set;

// import static org.junit.Assert.assertEquals;
// import static org.junit.Assert.fail;
// @RunWith(SpringRunner.class)
// @DataJpaTest
// public class ReviewTest{
//     @Autowired
//     private TestEntityManager entityManager;
//     @Autowired
//     private MaidRegisterRepository maidRegisterRepository;
//     @Autowired
//     private ReviewRepository reviewRepository;
//     @Autowired
//     private ScoreExpertiseRepository scoreExpertiseRepository;
//     @Autowired
//     private ScorePersonalityRepository scorePersonalityRepository;
//     @Autowired
//     private ScoreTimeRepository scoreTimeRepository;
//     @Autowired
//     private ScoreRepository scoreRepository;
    
//     private Validator validator;
//     private ScoreExpertiseEntity se;
//     private ScorePersonalityEntity sp;
//     private ScoreTimeEntity st;
//     private ScoreEntity sc;
//     private MaidRegisterEntity me;

//     @Before
//     public void setup() {
//         ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
//         validator = factory.getValidator();
//         se = scoreExpertiseRepository.findByscoreExId(5L);
//         sp = scorePersonalityRepository.findByscorePerId(5L);
//         st = scoreTimeRepository.findByscoreTiId(5L);
//         sc = scoreRepository.findByscoreId(5L);
//         me = maidRegisterRepository.findByMaidId(1L);
        
//     }
//     //test testSuccess
//     @Test
//     public void testSuccess() {
//         ReviewEntity r = new ReviewEntity();
//         r.setReview("ดีมากกกกกกกกก");
//         r.setScoreExpertiseEntity(se);
//         r.setScorePersonalityEntity(sp);
//         r.setScoreTimeEntity(st);
//         r.setScoreEntity(sc);
//         r.setMaidRegisterEntity(me);
        
//         try {
           
//             entityManager.persist(r);
//             System.out.println("**********************************************");
//             System.out.println("Success");
//             System.out.println("**********************************************");
//             entityManager.flush();

//             //fail("Should not pass to this line");
//         } catch (javax.validation.ConstraintViolationException e) {
//             Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
//             assertEquals(violations.isEmpty(), false);
//             assertEquals(violations.size(), 0);
//         } 
//     }

//     //test testSuccessScore
//     @Test
//     public void testSuccessScore() {
//         ScoreEntity r = new ScoreEntity();
//         r.setScore("score");
        
//         try {
           
//             entityManager.persist(r);
//             System.out.println("**********************************************");
//             System.out.println("Success-Score");
//             System.out.println("**********************************************");
//             entityManager.flush();

//             //fail("Should not pass to this line");
//         } catch (javax.validation.ConstraintViolationException e) {
//             Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
//             assertEquals(violations.isEmpty(), false);
//             assertEquals(violations.size(), 0);
//         } 
//     }
//     //test testSuccessScoreEx
//     @Test
//     public void testSuccessScoreEx() {
//         ScoreExpertiseEntity r = new ScoreExpertiseEntity();
//         r.setScoreEx("scoreex");
        
//         try {
           
//             entityManager.persist(r);
//             System.out.println("**********************************************");
//             System.out.println("Success-Score-Ex");
//             System.out.println("**********************************************");
//             entityManager.flush();

//             //fail("Should not pass to this line");
//         } catch (javax.validation.ConstraintViolationException e) {
//             Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
//             assertEquals(violations.isEmpty(), false);
//             assertEquals(violations.size(), 0);
//         } 
//     }
//     //test testSuccessScorePe
//     @Test
//     public void testSuccessScorePe() {
//         ScorePersonalityEntity r = new ScorePersonalityEntity();
//         r.setScorePer("scorepe");
        
//         try {
           
//             entityManager.persist(r);
//             System.out.println("**********************************************");
//             System.out.println("Success-Score-Pe");
//             System.out.println("**********************************************");
//             entityManager.flush();

//             //fail("Should not pass to this line");
//         } catch (javax.validation.ConstraintViolationException e) {
//             Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
//             assertEquals(violations.isEmpty(), false);
//             assertEquals(violations.size(), 0);
//         } 
//     }
//     //test testSuccessScoreTi
//     @Test
//     public void testSuccessScoreTi() {
//         ScoreTimeEntity r = new ScoreTimeEntity();
//         r.setScoreTi("scoreti");
        
//         try {
           
//             entityManager.persist(r);
//             System.out.println("**********************************************");
//             System.out.println("Success-Score-Ti");
//             System.out.println("**********************************************");
//             entityManager.flush();

//             //fail("Should not pass to this line");
//         } catch (javax.validation.ConstraintViolationException e) {
//             Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
//             assertEquals(violations.isEmpty(), false);
//             assertEquals(violations.size(), 0);
//         } 
//     }

//     //Null-Review
//     @Test
//     public void testNullDetail() {
//         ReviewEntity r = new ReviewEntity();
//         r.setReview(null);
//         r.setScoreExpertiseEntity(se);
//         r.setScorePersonalityEntity(sp);
//         r.setScoreTimeEntity(st);
//         r.setScoreEntity(sc);
//         r.setMaidRegisterEntity(me);
//         try {
//             entityManager.persist(r);
//             entityManager.flush();
//             fail("Should not pass to this line");
//         } catch (javax.validation.ConstraintViolationException e) {
//             Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
//             assertEquals(violations.isEmpty(), false);
//             assertEquals(violations.size(), 1);
//             System.out.println("******************************************************");
//             System.out.println(e);
//             System.out.println("====================Null-Review========================");
//         } 
//     }
//     //Null-ScoreClass
//     @Test
//     public void testNullCleassScor() {
//         ScoreEntity r = new ScoreEntity();
//         r.setScore(null);
        
//         try {
//             entityManager.persist(r);
//             entityManager.flush();
//             fail("Should not pass to this line");
//         } catch (javax.validation.ConstraintViolationException e) {
//             Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
//             assertEquals(violations.isEmpty(), false);
//             assertEquals(violations.size(), 1);
//             System.out.println("******************************************************");
//             System.out.println(e);
//             System.out.println("====================Null-Class-Score========================");
//         } 
//     }
//     //Null-ScoreExClass
//     @Test
//     public void testNullCleassScoreEx() {
//         ScoreExpertiseEntity r = new ScoreExpertiseEntity();
//         r.setScoreEx(null);
        
//         try {
//             entityManager.persist(r);
//             entityManager.flush();
//             fail("Should not pass to this line");
//         } catch (javax.validation.ConstraintViolationException e) {
//             Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
//             assertEquals(violations.isEmpty(), false);
//             assertEquals(violations.size(), 1);
//             System.out.println("******************************************************");
//             System.out.println(e);
//             System.out.println("====================Null-Class-Score-Ex========================");
//         } 
//     }

//     //Null-ScorePeClass
//     @Test
//     public void testNullCleassScorePe() {
//         ScorePersonalityEntity r = new ScorePersonalityEntity();
//         r.setScorePer(null);
        
//         try {
//             entityManager.persist(r);
//             entityManager.flush();
//             fail("Should not pass to this line");
//         } catch (javax.validation.ConstraintViolationException e) {
//             Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
//             assertEquals(violations.isEmpty(), false);
//             assertEquals(violations.size(), 1);
//             System.out.println("******************************************************");
//             System.out.println(e);
//             System.out.println("====================Null-Class-Score-Pe========================");
//         } 
//     }

//     //Null-ScoreTiClass
//     @Test
//     public void testNullCleassScoreTi() {
//         ScoreTimeEntity r = new ScoreTimeEntity();
//         r.setScoreTi(null);
        
//         try {
//             entityManager.persist(r);
//             entityManager.flush();
//             fail("Should not pass to this line");
//         } catch (javax.validation.ConstraintViolationException e) {
//             Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
//             assertEquals(violations.isEmpty(), false);
//             assertEquals(violations.size(), 1);
//             System.out.println("******************************************************");
//             System.out.println(e);
//             System.out.println("====================Null-Class-Score-Ti========================");
//         } 
//     }

//     //Null-Score
//     @Test
//     public void testNullScore() {
//         ReviewEntity r = new ReviewEntity();
//         r.setReview("ดีมากกกกกกกกก");
//         r.setScoreExpertiseEntity(se);
//         r.setScorePersonalityEntity(sp);
//         r.setScoreTimeEntity(st);
//         r.setScoreEntity(null);
//         r.setMaidRegisterEntity(me);
//         try {
//             entityManager.persist(r);
//             entityManager.flush();
//             fail("Should not pass to this line");
//         } catch (javax.validation.ConstraintViolationException e) {
//             Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
//             assertEquals(violations.isEmpty(), false);
//             assertEquals(violations.size(), 1);
//             System.out.println("******************************************************");
//             System.out.println(e);
//             System.out.println("====================Null-Score========================");
//         } 
//     }

//     //Null-ScoreEx
//     @Test
//     public void testNullScoreEx() {
//         ReviewEntity r = new ReviewEntity();
//         r.setReview("ดีมากกกกกกกกก");
//         r.setScoreExpertiseEntity(null);
//         r.setScorePersonalityEntity(sp);
//         r.setScoreTimeEntity(st);
//         r.setScoreEntity(sc);
//         r.setMaidRegisterEntity(me);
//         try {
//             entityManager.persist(r);
//             entityManager.flush();
//             fail("Should not pass to this line");
//         } catch (javax.validation.ConstraintViolationException e) {
//             Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
//             assertEquals(violations.isEmpty(), false);
//             assertEquals(violations.size(), 1);
//             System.out.println("******************************************************");
//             System.out.println(e);
//             System.out.println("====================Null-Score-Ex========================");
//         } 
//     }

//     //Null-ScorePer
//     @Test
//     public void testNullScorePer() {
//         ReviewEntity r = new ReviewEntity();
//         r.setReview("ดีมากกกกกกกกก");
//         r.setScoreExpertiseEntity(se);
//         r.setScorePersonalityEntity(null);
//         r.setScoreTimeEntity(st);
//         r.setScoreEntity(sc);
//         r.setMaidRegisterEntity(me);
//         try {
//             entityManager.persist(r);
//             entityManager.flush();
//             fail("Should not pass to this line");
//         } catch (javax.validation.ConstraintViolationException e) {
//             Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
//             assertEquals(violations.isEmpty(), false);
//             assertEquals(violations.size(), 1);
//             System.out.println("******************************************************");
//             System.out.println(e);
//             System.out.println("====================Null-Score-Per========================");
//         } 
//     }

//     //Null-ScoreTi
//     @Test
//     public void testNullScoreTi() {
//         ReviewEntity r = new ReviewEntity();
//         r.setReview("ดีมากกกกกกกกก");
//         r.setScoreExpertiseEntity(se);
//         r.setScorePersonalityEntity(sp);
//         r.setScoreTimeEntity(null);
//         r.setScoreEntity(sc);
//         r.setMaidRegisterEntity(me);
//         try {
//             entityManager.persist(r);
//             entityManager.flush();
//             fail("Should not pass to this line");
//         } catch (javax.validation.ConstraintViolationException e) {
//             Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
//             assertEquals(violations.isEmpty(), false);
//             assertEquals(violations.size(), 1);
//             System.out.println("******************************************************");
//             System.out.println(e);
//             System.out.println("====================Null-Score-Time========================");
//         } 
//     }
//     //Null-Maid
//     @Test
//     public void testNullScoreMaid() {
//         ReviewEntity r = new ReviewEntity();
//         r.setReview("ดีมากกกกกกกกก");
//         r.setScoreExpertiseEntity(se);
//         r.setScorePersonalityEntity(sp);
//         r.setScoreTimeEntity(st);
//         r.setScoreEntity(sc);
//         r.setMaidRegisterEntity(null);
//         try {
//             entityManager.persist(r);
//             entityManager.flush();
//             fail("Should not pass to this line");
//         } catch (javax.validation.ConstraintViolationException e) {
//             Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
//             assertEquals(violations.isEmpty(), false);
//             assertEquals(violations.size(), 1);
//             System.out.println("******************************************************");
//             System.out.println(e);
//             System.out.println("====================Null-Maid========================");
//         } 
//     }
//     //Min
//     @Test
//     public void testMinSizeDetail() {
//         ReviewEntity r = new ReviewEntity();
//         r.setReview("ดี");
//         r.setScoreExpertiseEntity(se);
//         r.setScorePersonalityEntity(sp);
//         r.setScoreTimeEntity(st);
//         r.setScoreEntity(sc);
//         r.setMaidRegisterEntity(me);
//         try {
           
//             entityManager.persist(r);
//             entityManager.flush();

//             //fail("Should not pass to this line");
//         } catch (javax.validation.ConstraintViolationException e) {
//             Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
//             assertEquals(violations.isEmpty(), false);
//             assertEquals(violations.size(), 1);
//             System.out.println("**********************************************");
//             System.out.println(e);
//             System.out.println("====================testMinSizeDetail========================");
//             System.out.println(e);
            
//         } 
//     }


//     // TEST MAX SIZE DETAIL
//     @Test
//     public void testMaxSizeDetail() {
//         ReviewEntity r = new ReviewEntity();
//         r.setReview("ดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดีดี");
//         r.setScoreExpertiseEntity(se);
//         r.setScorePersonalityEntity(sp);
//         r.setScoreTimeEntity(st);
//         r.setScoreEntity(sc);
//         r.setMaidRegisterEntity(me);

//         try {
           
//             entityManager.persist(r);
//             entityManager.flush();

//             fail("Should not pass to this line");
//         } catch (javax.validation.ConstraintViolationException e) {
//             Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
//             assertEquals(violations.isEmpty(), false);
//             assertEquals(violations.size(), 1);
//             System.out.println("**********************************************");
//             System.out.println(e);
//             System.out.println("====================testMaxSizeDetail========================");
//              System.out.println(e);
//         } 
//     }

//      // TEST INVALID PATTERN DETAIL
//      @Test
//      public void testInvalidPatternDetail() {
//         ReviewEntity r = new ReviewEntity();
//         r.setReview("So Good");
//         r.setScoreExpertiseEntity(se);
//         r.setScorePersonalityEntity(sp);
//         r.setScoreTimeEntity(st);
//         r.setScoreEntity(sc);
//         r.setMaidRegisterEntity(me);
 
//          try {
            
//              entityManager.persist(r);
//              entityManager.flush();
 
//              fail("Should not pass to this line");
//          } catch (javax.validation.ConstraintViolationException e) {
//              Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
//              assertEquals(violations.isEmpty(), false);
//              assertEquals(violations.size(), 1);
//              System.out.println("**********************************************");
//              System.out.println(e);
//              System.out.println("====================testInvalidPatternDetail==========================");
//              System.out.println(e);
//          } 
//      }
//      //Test unique colum
//     @Test(expected=javax.persistence.PersistenceException.class)
//     public void uniqueColum(){
//         ReviewEntity r = new ReviewEntity();
        
//         r.setReview("ดีดีดีดีดีดีดี");
//         r.setScoreExpertiseEntity(se);
//         r.setScorePersonalityEntity(sp);
//         r.setScoreTimeEntity(st);
//         r.setScoreEntity(sc);
//         r.setMaidRegisterEntity(me);


//         entityManager.persist(r);
// 		entityManager.flush();
//         try{
//             ReviewEntity rr = new ReviewEntity();
//             rr.setReview("ดีดีดีดีดีดีดี");
//             rr.setScoreExpertiseEntity(se);
//             rr.setScorePersonalityEntity(sp);
//             rr.setScoreTimeEntity(st);
//             rr.setScoreEntity(sc);
//             rr.setMaidRegisterEntity(me);

//             entityManager.persist(rr);
// 		    entityManager.flush();
            
//             fail("Should not pass to this line");
//         } catch (javax.persistence.PersistenceException e) {
//             System.out.println("++++++++++++++++++++++++++++++");
//             System.out.println("Unique colum " + e);
//             System.out.println("++++++++++++++++++++++++++++++");
//           throw new javax.persistence.PersistenceException();
//         }
        
//     }
// }