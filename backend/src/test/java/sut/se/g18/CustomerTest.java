// package sut.se.g18;
// import org.junit.Test;
// import org.junit.runner.RunWith;
// import org.springframework.test.context.junit4.SpringRunner;

// import java.util.Set;

// import javax.validation.ConstraintViolation;
// import javax.validation.Validation;
// import javax.validation.Validator;
// import javax.validation.ValidatorFactory;

// import org.junit.Before;


// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
// import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;


// import sut.se.g18.Entity.CustomerEntity;

// import sut.se.g18.Repository.CustomerRepository;

// import static org.junit.Assert.*;

// @RunWith(SpringRunner.class)

// @DataJpaTest

// public class CustomerTest {
//     @Autowired
//     private TestEntityManager entityManager;

//     @Autowired
//     private CustomerRepository customerRepository;

//     private Validator validator;


//     @Before
//     public void setup() {
//         ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
//         validator = factory.getValidator();
//     }

//     @Test
//     public void contextLoads() {
//         System.out.println("Test Successful");
//     }

//     @Test
//     public void testSuccess() {
//         CustomerEntity c = new CustomerEntity();
//         c.setCustomerName("Mine mine");
//         c.setCustomerphone("0890000000");
//         c.setCustomerper("1234567890000");
//         c.setCustomerEmail("mine@sut.com");
//         c.setCustomeraddress("222 หมู่ 8 มทส.");
//         c.setCustomerpass("111111");
//         try {

//             entityManager.persist(c);
//             entityManager.flush();

//             //fail("Should not pass to this line");
//         } catch (javax.validation.ConstraintViolationException e) {
//             System.out.println("================================ From testSuccess ==================");
//             System.out.println(e.getConstraintViolations());
//             Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
//             assertEquals(violations.isEmpty(), false);
//             assertEquals(violations.size(), 1);
//         }
//     }

//     @Test
//     public void testNameNull() {
//         CustomerEntity c = new CustomerEntity();
//         c.setCustomerName(null);
//         c.setCustomerphone("0890000000");
//         c.setCustomerper("1234567890000");
//         c.setCustomerEmail("mine@sut.com");
//         c.setCustomeraddress("222 หมู่ 8 มทส.");
//         c.setCustomerpass("111111");
//         try {

//             entityManager.persist(c);
//             entityManager.flush();

//             fail("Should not pass to this line");
//         } catch (javax.validation.ConstraintViolationException e) {
//             System.out.println("============================ From testNameNull ======================");
//             System.out.println(e.getConstraintViolations());
//             Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
//             assertEquals(violations.isEmpty(), false);
//             assertEquals(violations.size(), 1);
//         }
//     }
//     @Test
//     public void testOversize() {
//         CustomerEntity c = new CustomerEntity();
//         c.setCustomerName("d");
//         c.setCustomerphone("0935152478");
//         c.setCustomerper("1234567890000");
//         c.setCustomerEmail("mine@sut.com");
//         c.setCustomeraddress("222 หมู่ 8 มทส.");
//         c.setCustomerpass("111111");
//         try {

//             entityManager.persist(c);
//             entityManager.flush();

//             fail("Should not pass to this line");
//         } catch (javax.validation.ConstraintViolationException e) {
//             System.out.println("========================= From testOversize ======================");
//             System.out.println(e.getConstraintViolations());
//             Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
//             assertEquals(violations.isEmpty(), false);
//             assertEquals(violations.size(), 1);
//         }
//     }
//     @Test
//     public void testMaxsize() {
//         CustomerEntity c = new CustomerEntity();
//         c.setCustomerName("ddddddddddddddddddddddddddddddddddddddd");
//         c.setCustomerphone("0935395533");
//         c.setCustomerper("1234567890000");
//         c.setCustomerEmail("mine@sut.com");
//         c.setCustomeraddress("222 หมู่ 8 มทส.");
//         c.setCustomerpass("111111");
//         try {

//             entityManager.persist(c);
//             entityManager.flush();

//             fail("Should not pass to this line");
//         } catch (javax.validation.ConstraintViolationException e) {
//             System.out.println("====================== From testMaxsize ==========================");
//             System.out.println(e.getConstraintViolations());
//             Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
//             assertEquals(violations.isEmpty(), false);
//             assertEquals(violations.size(), 1);
//         }
//     }
//     @Test
//     public void testPatternDetail() {
//         CustomerEntity c = new CustomerEntity();
//         c.setCustomerName("Mine Mineee");
//         c.setCustomerphone("123456");
//         c.setCustomerper("1234567890000");
//         c.setCustomerEmail("mine@sut.com");
//         c.setCustomeraddress("222 หมู่ 8 มทส.");
//         c.setCustomerpass("111111");

//         try{
//             entityManager.persist(c);
//             entityManager.flush();

//             fail("Should not pass to this line");
//         } catch(javax.validation.ConstraintViolationException e) {
//             System.out.println("================================ From testPatternDetail ==========================");
//             System.out.println(e.getConstraintViolations());
//             Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
//             assertEquals(violations.isEmpty(), false);
//             assertEquals(violations.size(), 1);
//         }
//     }
//     @Test
//     public void testAddressNull() {
//         CustomerEntity c = new CustomerEntity();
//         c.setCustomerName("Mine Mine");
//         c.setCustomerphone("0890000000");
//         c.setCustomerper("1234567890000");
//         c.setCustomerEmail("mine@sut.com");
//         c.setCustomeraddress(null);
//         c.setCustomerpass("111111");
//         try {

//             entityManager.persist(c);
//             entityManager.flush();

//             fail("Should not pass to this line");
//         } catch (javax.validation.ConstraintViolationException e) {
//             System.out.println("========================== From testAddressNull ========================");
//             System.out.println(e.getConstraintViolations());
//             Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
//             assertEquals(violations.isEmpty(), false);
//             assertEquals(violations.size(), 1);
//         }
//     }
//     @Test
//     public void testCustomerEmailNotEmail() {
//        CustomerEntity c = new CustomerEntity();
//         c.setCustomerName("Mine Mine");
//         c.setCustomerphone("0890000000");
//         c.setCustomerper("1234567890000");
//         c.setCustomerEmail("aaaaaa");
//         c.setCustomeraddress("222 หมู่ 8 มทส.");
//         c.setCustomerpass("111111");

//         try {

//             entityManager.persist(c);
//             entityManager.flush();
//             fail("Should not pass to this line");
//         } catch (javax.validation.ConstraintViolationException e) {
//             Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
//             System.out.println();
//             System.out.println();
//             System.out.println();
//             System.out.println();
//             System.out.println();
//             System.out.println(
//                     "[SHOWERROR]===============================================================================[SHOWERROR]");
//             System.out.println(e.getMessage());
//             System.out.println(
//                     "[SHOWERROR]===============================================================================[SHOWERROR]");
//             System.out.println();
//             System.out.println();
//             System.out.println();
//             System.out.println();
//             System.out.println();
//             assertEquals(violations.isEmpty(), false);
//             assertEquals(violations.size(), 1);
//         } catch (javax.persistence.PersistenceException e) {
//             e.printStackTrace();
//         }
//     }
//     @Test
//     public void testPhoneNull() {
//         CustomerEntity c = new CustomerEntity();
//         c.setCustomerName("Mine Mine");
//         c.setCustomerphone(null);
//         c.setCustomerper("1234567890000");
//         c.setCustomerEmail("mine@sut.com");
//         c.setCustomeraddress("222 หมู่ 8 มทส.");
//         c.setCustomerpass("111111");
//         try {

//             entityManager.persist(c);
//             entityManager.flush();

//             fail("Should not pass to this line");
//         } catch (javax.validation.ConstraintViolationException e) {
//             System.out.println("================== From testPhoneNull =================" );
//             System.out.println(e.getConstraintViolations());
//             Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
//             assertEquals(violations.isEmpty(), false);
//             assertEquals(violations.size(), 1);
//         }
//     }
//     @Test
//     public void testMinPass() {
//         CustomerEntity c = new CustomerEntity();
//         c.setCustomerName("Mine Mine");
//         c.setCustomerphone("0890000000");
//         c.setCustomerper("1234567890000");
//         c.setCustomerEmail("mine@sut.com");
//         c.setCustomeraddress("222 หมู่ 8 มทส.");
//         c.setCustomerpass("555");
//         try {

//             entityManager.persist(c);
//             entityManager.flush();

//             fail("Should not pass to this line");
//         } catch (javax.validation.ConstraintViolationException e) {
//             System.out.println("========================= From testMinPass ====================");
//             System.out.println(e.getConstraintViolations());
//             Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
//             assertEquals(violations.isEmpty(), false);
//             assertEquals(violations.size(), 1);
//         }
//     }
//     @Test
//     public void testPerNull() {
//         CustomerEntity c = new CustomerEntity();
//         c.setCustomerName("Mine Mine");
//         c.setCustomerphone("0890000000");
//         c.setCustomerper(null);
//         c.setCustomerEmail("mine@sut.com");
//         c.setCustomeraddress("222 หมู่ 8 มทส.");
//         c.setCustomerpass("111111");
//         try {

//             entityManager.persist(c);
//             entityManager.flush();

//             fail("Should not pass to this line");
//         } catch (javax.validation.ConstraintViolationException e) {
//             System.out.println("======================== From testPerNull =============================");
//             System.out.println(e.getConstraintViolations());
//             Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
//             assertEquals(violations.isEmpty(), false);
//             assertEquals(violations.size(), 1);
//         }
//     }
// }


