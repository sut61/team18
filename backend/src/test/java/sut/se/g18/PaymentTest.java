// package sut.se.g18;

// import org.junit.Test;
// import org.junit.runner.RunWith;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.test.context.junit4.SpringRunner;

// import static org.junit.Assert.assertEquals;
// import static org.junit.Assert.fail;

// import java.util.Collections;
// import java.util.OptionalInt;
// import java.util.Set;
// import java.text.ParseException;

// import javax.persistence.PersistenceException;
// import javax.validation.ConstraintViolation;
// import javax.validation.ConstraintViolationException;
// import javax.validation.Validation;
// import javax.validation.Validator;
// import javax.validation.ValidatorFactory;

// import org.junit.Before;
// import org.junit.Test;

// import sut.se.g18.Entity.*;
// import sut.se.g18.Repository.*;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
// import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

// @RunWith(SpringRunner.class)
// @DataJpaTest
// public class PaymentTest {
//     @Autowired
//     private TestEntityManager entityManager;
//     private Validator validator;

//     @Before
//     public void setup() {
//         ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
//         validator = factory.getValidator();

//     }

//     // 888888888888888888888888888888888888888888888888888888888888888888//
//     // 888888888888888888888888888888888888888888888888888888888888888888//
//     // 8888888888888888Test for PaymentEntity8888888888888888888888888888//
//     // 888888888888888888888888888888888888888888888888888888888888888888//
//     // 888888888888888888888888888888888888888888888888888888888888888888//

//     // Test Add Data Success//
//     @Test
//     public void addDataPaymentSuccess() {
//         PaymentEntity pay = new PaymentEntity();
//         pay.setName("Ball Donlawat");
//         pay.setAccountNumber("155113334576");
//         pay.setPhonenum("0807789012");
//         pay.setAddress("หอสุรนิเวศ 13");
//         try {
//             entityManager.persist(pay);
//             entityManager.flush();
//             System.out.println("=================================================");
//             System.out.println("Add Data Payment Success");
//             System.out.println("=================================================");
//         } catch (javax.validation.ConstraintViolationException e) {
//             System.out.println("=================================================");
//             System.out.println("Error" + e.getMessage());
//             System.out.println("=================================================");
//             Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
//             assertEquals(violations.isEmpty(), false);
//             assertEquals(violations.size(), 0);
//         }
//     }

//     // Test Data was Null//
//     @Test
//     public void dataPaymentwasNull() {
//         PaymentEntity pay = new PaymentEntity();
//         pay.setName(null);
//         pay.setAccountNumber(null);
//         pay.setPhonenum(null);
//         pay.setAddress(null);
//         try {
//             entityManager.persist(pay);
//             entityManager.flush();
//             fail("Should not pass this line");
//         } catch (javax.validation.ConstraintViolationException e) {
//             System.out.println("=================================================");
//             System.out.println("Error Data was Null " + e.getMessage());
//             System.out.println("=================================================");
//             Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
//             assertEquals(violations.isEmpty(), false);
//             assertEquals(violations.size(), 4);
//         }
//     }

//     // Test Phonenumber less than min size//
//     @Test
//     public void lessThanMinsize() {
//         PaymentEntity pay = new PaymentEntity();
//         pay.setName("Ball Donlawat");
//         pay.setAccountNumber("155113334576");
//         pay.setPhonenum("08089012");
//         pay.setAddress("หอสุรนิเวศ 13");
//         try {
//             entityManager.persist(pay);
//             entityManager.flush();
//             fail("Should not pass this line");
//         } catch (javax.validation.ConstraintViolationException e) {
//             System.out.println("=================================================");
//             System.out.println("Error Phonenumber lass than min size " + e.getMessage());
//             System.out.println("=================================================");
//             Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
//             assertEquals(violations.isEmpty(), false);
//             assertEquals(violations.size(), 1);
//         }
//     }

//     // Test Phonenumber larger than max size//
//     @Test
//     public void largerThanMaxsize() {
//         PaymentEntity pay = new PaymentEntity();
//         pay.setName("Ball Donlawat");
//         pay.setAccountNumber("155113334576");
//         pay.setPhonenum("08089012000");
//         pay.setAddress("หอสุรนิเวศ 13");
//         try {
//             entityManager.persist(pay);
//             entityManager.flush();
//             fail("Should not pass this line");
//         } catch (javax.validation.ConstraintViolationException e) {
//             System.out.println("=================================================");
//             System.out.println("Error Phonenumber larger than max size " + e.getMessage());
//             System.out.println("=================================================");
//             Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
//             assertEquals(violations.isEmpty(), false);
//             assertEquals(violations.size(), 1);
//         }
//     }

//     // Test Phonenumber Pattern not match//
//     @Test
//     public void phonenumberPatternNotMatch() {
//         PaymentEntity pay = new PaymentEntity();
//         pay.setName("Ball Donlawat");
//         pay.setAccountNumber("155113334576");
//         pay.setPhonenum("กขคงฟหสวาก");
//         pay.setAddress("หอสุรนิเวศ 13");
//         try {
//             entityManager.persist(pay);
//             entityManager.flush();
//             fail("Should not pass this line");
//         } catch (javax.validation.ConstraintViolationException e) {
//             System.out.println("=================================================");
//             System.out.println("Error Phonenumber pattern not match " + e.getMessage());
//             System.out.println("=================================================");
//             Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
//             assertEquals(violations.isEmpty(), false);
//             assertEquals(violations.size(), 1);
//         }
//     }
//     //888888888888888888888888888888888888888888888888888888888888888888//
//     //888888888888888888888888888888888888888888888888888888888888888888//
//     //8888888888888888Test for TypepaymentEntity888888888888888888888888//
//     //888888888888888888888888888888888888888888888888888888888888888888//
//     //888888888888888888888888888888888888888888888888888888888888888888//

//     //Test Add Data Success//
//     @Test
//     public void addDataTypepaymentSuccess(){
//         TypepaymentEntity type = new TypepaymentEntity();
//         type.setTypename("ABCD");
//         try {
//             entityManager.persist(type);
//             entityManager.flush();
//             System.out.println("=================================================");
//             System.out.println("Add Data Typepayment Success");
//             System.out.println("=================================================");
//         } catch(javax.validation.ConstraintViolationException e) {
//             System.out.println("=================================================");
//             System.out.println("Error " + e.getMessage());
//             System.out.println("=================================================");
//             Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
//             assertEquals(violations.isEmpty(), false);
//             assertEquals(violations.size(),0);
//         }
//     }
//     //Test Data was Null//
//     @Test
//     public void dataTypepaymentWasNull(){
//         TypepaymentEntity type = new TypepaymentEntity();
//         type.setTypename(null);
//         try {
//             entityManager.persist(type);
//             entityManager.flush();
//             fail("Should not pass this line");
//         } catch(javax.validation.ConstraintViolationException e) {
//             System.out.println("=================================================");
//             System.out.println("Error Data Typepayment was Null " + e.getMessage());
//             System.out.println("=================================================");
//             Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
//             assertEquals(violations.isEmpty(), false);
//             assertEquals(violations.size(),1);
//         }
//     }
//     //Test Data Typepayment pattern not match//
//     @Test
//     public void dataTypepaymentPatternNotMatch(){
//         TypepaymentEntity type = new TypepaymentEntity();
//         type.setTypename("บัตรเครดิต");
//         try {
//             entityManager.persist(type);
//             entityManager.flush();
//             fail("Should not pass this line");
//         } catch(javax.validation.ConstraintViolationException e) {
//             System.out.println("=================================================");
//             System.out.println("Error Data Typepayment Pattern not match " + e.getMessage());
//             System.out.println("=================================================");
//             Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
//             assertEquals(violations.isEmpty(), false);
//             assertEquals(violations.size(),1);
//         }
//     }
//     //Test unique column//
//     @Test(expected=javax.persistence.PersistenceException.class)
//     public void uniqueTypepaymentColumn(){
//         TypepaymentEntity type = new TypepaymentEntity();
//         type.setTypename("ABCD");
//         entityManager.persist(type);
//         entityManager.flush();
//         try {
//             TypepaymentEntity type1 = new TypepaymentEntity();
//             type1.setTypename("ABCD");
//             entityManager.persist(type1);
//             entityManager.flush();
//             fail("Should not pass this line");
//         } catch(javax.persistence.PersistenceException e) {
//             System.out.println("=================================================");
//             System.out.println("Error Unique Typepayment column " + e.getMessage());
//             System.out.println("=================================================");
//             throw new javax.persistence.PersistenceException();
//         }
//     }

//     //888888888888888888888888888888888888888888888888888888888888888888//
//     //888888888888888888888888888888888888888888888888888888888888888888//
//     //8888888888888888Test for BankEntity8888888888888888888888888888888//
//     //888888888888888888888888888888888888888888888888888888888888888888//
//     //888888888888888888888888888888888888888888888888888888888888888888//

//     //Test Add Data Success//
//     @Test
//     public void addDataBankSuccess(){
//         BankEntity bank = new BankEntity();
//         bank.setBankname("ธนาคารกรุงไทยศรี");;
//         try {
//             entityManager.persist(bank);
//             entityManager.flush();
//             System.out.println("=================================================");
//             System.out.println("Add Data Bank Success");
//             System.out.println("=================================================");
//         } catch(javax.validation.ConstraintViolationException e) {
//             System.out.println("=================================================");
//             System.out.println("Error " + e.getMessage());
//             System.out.println("=================================================");
//             Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
//             assertEquals(violations.isEmpty(), false);
//             assertEquals(violations.size(),0);
//         }
//     }
//     //Test Data was Null//
//     @Test
//     public void dataBankWasNull(){
//         BankEntity bank = new BankEntity();
//         bank.setBankname(null);
//         try {
//             entityManager.persist(bank);
//             entityManager.flush();
//             fail("Should not pass this line");
//         } catch(javax.validation.ConstraintViolationException e) {
//             System.out.println("=================================================");
//             System.out.println("Error Data Bank was Null " + e.getMessage());
//             System.out.println("=================================================");
//             Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
//             assertEquals(violations.isEmpty(), false);
//             assertEquals(violations.size(),1);
//         }
//     }
//     //Test Data Bank pattern not match//
//     @Test
//     public void dataBankPatternNotMatch(){
//         BankEntity bank = new BankEntity();
//         bank.setBankname("กรุงไทย");
//         try {
//             entityManager.persist(bank);
//             entityManager.flush();
//             fail("Should not pass this line");
//         } catch(javax.validation.ConstraintViolationException e) {
//             System.out.println("=================================================");
//             System.out.println("Error Data Bank Pattern not match " + e.getMessage());
//             System.out.println("=================================================");
//             Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
//             assertEquals(violations.isEmpty(), false);
//             assertEquals(violations.size(),1);
//         }
//     }
//     //Test unique column//
//     @Test(expected=javax.persistence.PersistenceException.class)
//     public void uniqueBankColumn(){
//         BankEntity bank = new BankEntity();
//         bank.setBankname("ธนาคารกรุงไทยศรี");
//         entityManager.persist(bank);
//         entityManager.flush();
//         try {
//             BankEntity bank1 = new BankEntity();
//             bank1.setBankname("ธนาคารกรุงไทยศรี");
//             entityManager.persist(bank1);
//             entityManager.flush();
//             fail("Should not pass this line");
//         } catch(javax.persistence.PersistenceException e) {
//             System.out.println("=================================================");
//             System.out.println("Error Unique Bank column " + e.getMessage());
//             System.out.println("=================================================");
//             throw new javax.persistence.PersistenceException();
//         }
//     }
// }