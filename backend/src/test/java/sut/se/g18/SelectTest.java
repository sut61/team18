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

@RunWith(SpringRunner.class)
@DataJpaTest
public class SelectTest {
    @Autowired
    private TestEntityManager entityManager;

    private Validator validator;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();

    }

    // TEST MIN SIZE DETAIL
    @Test
    public void testNull() {
        MaidSelectEntity L = new MaidSelectEntity();
        L.setMaidEmail(null);

        try {

            entityManager.persist(L);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1); // ผิด Pattern ด้วย
            System.out.println("==============================testNull=============================");
            System.out.println(e);
        } catch (javax.persistence.PersistenceException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testMin() {
        MaidSelectEntity L = new MaidSelectEntity();
        L.setMaidEmail("q@.het9s.com");

        try {

            entityManager.persist(L);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2); // ผิด Pattern ด้วย
            System.out.println("==============================testMin=============================");
            System.out.println(e);
        } catch (javax.persistence.PersistenceException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testMax() {
        MaidSelectEntity L = new MaidSelectEntity();
        L.setMaidEmail("q@.hhfffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffset9s");

        try {

            entityManager.persist(L);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2); // ผิด Pattern ด้วย
            System.out.println("==============================testMax=============================");
            System.out.println(e);
        } catch (javax.persistence.PersistenceException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testPattern() {
        MaidSelectEntity L = new MaidSelectEntity();
        L.setMaidEmail("qhhfffffffffffffffffffset9s");

        try {

            entityManager.persist(L);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1); // ผิด Pattern ด้วย
            System.out.println("==============================testPattern=============================");
            System.out.println(e);
        } catch (javax.persistence.PersistenceException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSuccess() {
        MaidSelectEntity L = new MaidSelectEntity();
        L.setMaidEmail("thiwab59@gmail.com");

        try {

            entityManager.persist(L);
            entityManager.flush();

            // fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1); // ผิด Pattern ด้วย
            System.out.println("==============================testSuccess=============================");
            System.out.println(e);
        } catch (javax.persistence.PersistenceException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUnique() {
        MaidSelectEntity L = new MaidSelectEntity();
        L.setMaidEmail("thiwab59@gmail.com");

        try {

            entityManager.persist(L);
            entityManager.flush();

            // fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1); // ผิด Pattern ด้วย
            System.out.println("==============================testUnique=============================");
            System.out.println(e);
        } catch (javax.persistence.PersistenceException e) {
            e.printStackTrace();
        }

        MaidSelectEntity L2 = new MaidSelectEntity();
        L.setMaidEmail("thiwab59@gmail.com");

        try {

            entityManager.persist(L2);
            entityManager.flush();

            //fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("==============================testUnique=============================");
            System.out.println(e);
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1); // ผิด Pattern ด้วย
        } catch (javax.persistence.PersistenceException e) {
            e.printStackTrace();
        }
    }
    
}