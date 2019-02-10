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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Set;
import java.util.logging.ErrorManager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@DataJpaTest
@RunWith(SpringRunner.class)
public class MaidRegisterTest {

    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private MaidRegisterRepository maidRegisterRepository;
    @Autowired
    private CompanyRepository companyRepository;

    private Validator validator;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();

    }

    @Test
    public void testDataAll() {
        MaidRegisterEntity mr = new MaidRegisterEntity();
        mr.setMaidId(1L);
        mr.setMaidName("Paging");
        mr.setMaidEmail("srcment@gmail.com");
        mr.setCompanyForMaid(companyRepository.findBycompanyName("บริษัทสวนรักษ์"));
        mr.setMaidAddress("BanNongtaKai Muang Muang 141/22");
        mr.setCanton("Bankok");
        mr.setMaidPhone("0909876543");
        mr.setDistrict("Khean");
        mr.setProvince("Korat#2");

        try {

            entityManager.persist(mr);
            entityManager.flush();
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "[SHOWERROR]===============================================================================[SHOWERROR]");
            System.out.println(e.getMessage());
            System.out.println(
                    "[SHOWERROR]===============================================================================[SHOWERROR]");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        } catch (javax.persistence.PersistenceException e) {
            e.printStackTrace();
        }
    }
// //=============================================================================================//
    @Test
    public void testMaidNameNotNull() {
        MaidRegisterEntity mr = new MaidRegisterEntity();
        mr.setMaidId(1L);
        mr.setMaidName(null);
        mr.setMaidEmail("srcment@gmail.com");
        mr.setCompanyForMaid(companyRepository.findBycompanyName("บริษัทสวนรักษ์"));
        mr.setMaidAddress("BanNongtaKai Muang Muang 141/22");
        mr.setCanton("Bankok");
        mr.setMaidPhone("0909876543");
        mr.setDistrict("Khean");
        mr.setProvince("Korat#2");

        try {

            entityManager.persist(mr);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "[SHOWERROR]===============================================================================[SHOWERROR]");
            System.out.println(e.getMessage());
            System.out.println(
                    "[SHOWERROR]===============================================================================[SHOWERROR]");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        } catch (javax.persistence.PersistenceException e) {
            e.printStackTrace();
        }
    }
//     //==============================================================================//
    @Test
    public void testMaidAddressNotNull() {
        MaidRegisterEntity mr = new MaidRegisterEntity();
        mr.setMaidId(1L);
        mr.setMaidName("panthiwa");
        mr.setMaidEmail("srcment@gmail.com");
        mr.setCompanyForMaid(companyRepository.findBycompanyName("บริษัทสวนรักษ์"));
        mr.setMaidAddress(null);
        mr.setCanton("Bankok");
        mr.setMaidPhone("0909876543");
        mr.setDistrict("Khean");
        mr.setProvince("Korat#2");

        try {

            entityManager.persist(mr);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "[SHOWERROR]===============================================================================[SHOWERROR]");
            System.out.println(e.getMessage());
            System.out.println(
                    "[SHOWERROR]===============================================================================[SHOWERROR]");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        } catch (javax.persistence.PersistenceException e) {
            e.printStackTrace();
        }
    }

//=======================================================================================//
    @Test
    public void testMaidPhoneNotNull() {
        MaidRegisterEntity mr = new MaidRegisterEntity();
        mr.setMaidId(1L);
        mr.setMaidName("Paging");
        mr.setMaidEmail("srcment@gmail.com");
        mr.setCompanyForMaid(companyRepository.findBycompanyName("บริษัทสวนรักษ์"));
        mr.setMaidAddress("BanNongtaKai Muang Muang 141/22");
        mr.setCanton("Bankok");
        mr.setMaidPhone(null);
        mr.setDistrict("Khean");
        mr.setProvince("Korat#2");

        try {

            entityManager.persist(mr);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "[SHOWERROR]===============================================================================[SHOWERROR]");
            System.out.println(e.getMessage());
            System.out.println(
                    "[SHOWERROR]===============================================================================[SHOWERROR]");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        } catch (javax.persistence.PersistenceException e) {
            e.printStackTrace();
        }
    }

//=============================================================================================//
    @Test
    public void testMaidEmailNotEmail() {
        MaidRegisterEntity mr = new MaidRegisterEntity();
        mr.setMaidId(1L);
        mr.setMaidName("Paging");
        mr.setMaidEmail("srcment");
        mr.setCompanyForMaid(companyRepository.findBycompanyName("บริษัทสวนรักษ์"));
        mr.setMaidAddress("BanNongtaKai Muang Muang 141/22");
        mr.setCanton("Bankok");
        mr.setMaidPhone("0909876543");
        mr.setDistrict("Khean");
        mr.setProvince("Korat#2");

        try {

            entityManager.persist(mr);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "[SHOWERROR]===============================================================================[SHOWERROR]");
            System.out.println(e.getMessage());
            System.out.println(
                    "[SHOWERROR]===============================================================================[SHOWERROR]");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        } catch (javax.persistence.PersistenceException e) {
            e.printStackTrace();
        }
    }
    //==================================================================//
    @Test
    public void testProvinceNotNull() {
        MaidRegisterEntity mr = new MaidRegisterEntity();
        mr.setMaidId(1L);
        mr.setMaidName("Paging");
        mr.setMaidEmail("srcment@gmail.com");
        mr.setCompanyForMaid(companyRepository.findBycompanyName("บริษัทสวนรักษ์"));
        mr.setMaidAddress("BanNongtaKai Muang Muang 141/22");
        mr.setCanton("Bankok");
        mr.setMaidPhone("0987657867");
        mr.setDistrict("Khean");
        mr.setProvince(null);

        try {

            entityManager.persist(mr);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "[SHOWERROR]===============================================================================[SHOWERROR]");
            System.out.println(e.getMessage());
            System.out.println(
                    "[SHOWERROR]===============================================================================[SHOWERROR]");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        } catch (javax.persistence.PersistenceException e) {
            e.printStackTrace();
        }
    }
//===================================================================//
@Test
public void testCantonNotNull() {
    MaidRegisterEntity mr = new MaidRegisterEntity();
    mr.setMaidId(1L);
    mr.setMaidName("Paging");
    mr.setMaidEmail("srcment@gmail.com");
    mr.setCompanyForMaid(companyRepository.findBycompanyName("บริษัทสวนรักษ์"));
    mr.setMaidAddress("BanNongtaKai Muang Muang 141/22");
    mr.setCanton(null);
    mr.setMaidPhone("0987657867");
    mr.setDistrict("Khean");
    mr.setProvince("Korat#2");

    try {

        entityManager.persist(mr);
        entityManager.flush();
        fail("Should not pass to this line");
    } catch (javax.validation.ConstraintViolationException e) {
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println(
                "[SHOWERROR]===============================================================================[SHOWERROR]");
        System.out.println(e.getMessage());
        System.out.println(
                "[SHOWERROR]===============================================================================[SHOWERROR]");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        assertEquals(violations.isEmpty(), false);
        assertEquals(violations.size(), 1);
    } catch (javax.persistence.PersistenceException e) {
        e.printStackTrace();
    }
}
    //========================================================================================//
    @Test
    public void testMaidPhoneNotPattern() {
        MaidRegisterEntity mr = new MaidRegisterEntity();
        mr.setMaidId(1L);
        mr.setMaidName("Paging");
        mr.setMaidEmail("srcment");
        mr.setCompanyForMaid(companyRepository.findBycompanyName("บริษัทสวนรักษ์"));
        mr.setMaidAddress("BanNongtaKai Muang Muang 141/22");
        mr.setCanton("Bankok");
        mr.setMaidPhone("1111111111");
        mr.setDistrict("Khean");
        mr.setProvince("Korat#2");

        try {

            entityManager.persist(mr);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "[SHOWERROR]===============================================================================[SHOWERROR]");
            System.out.println(e.getMessage());
            System.out.println(
                    "[SHOWERROR]===============================================================================[SHOWERROR]");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        } catch (javax.persistence.PersistenceException e) {
            e.printStackTrace();
        }
    }
//=============================================================================================//
    @Test
    public void testMaidPhoneMax() {
        MaidRegisterEntity mr = new MaidRegisterEntity();
        mr.setMaidId(1L);
        mr.setMaidName("Paging");
        mr.setMaidEmail("srcment");
        mr.setCompanyForMaid(companyRepository.findBycompanyName("บริษัทสวนรักษ์"));
        mr.setMaidAddress("BanNongtaKai Muang Muang 141/22");
        mr.setCanton("Bankok");
        mr.setMaidPhone("090987654321012345");
        mr.setDistrict("Khean");
        mr.setProvince("Korat#2");

        try {

            entityManager.persist(mr);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "[SHOWERROR]===============================================================================[SHOWERROR]");
            System.out.println(e.getMessage());
            System.out.println(
                    "[SHOWERROR]===============================================================================[SHOWERROR]");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        } catch (javax.persistence.PersistenceException e) {
            e.printStackTrace();
        }
    }
//====================================================================================================//
    @Test
    public void testMaidPhoneMin() {
        MaidRegisterEntity mr = new MaidRegisterEntity();
        mr.setMaidId(1L);
        mr.setMaidName("Paging");
        mr.setMaidEmail("srcment");
        mr.setCompanyForMaid(companyRepository.findBycompanyName("บริษัทสวนรักษ์"));
        mr.setMaidAddress("BanNongtaKai Muang Muang 141/22");
        mr.setCanton("Bankok");
        mr.setMaidPhone("090355");
        mr.setDistrict("Khean");
        mr.setProvince("Korat#2");

        try {

            entityManager.persist(mr);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "[SHOWERROR]===============================================================================[SHOWERROR]");
            System.out.println(e.getMessage());
            System.out.println(
                    "[SHOWERROR]===============================================================================[SHOWERROR]");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        } catch (javax.persistence.PersistenceException e) {
            e.printStackTrace();
        }
    }
}
