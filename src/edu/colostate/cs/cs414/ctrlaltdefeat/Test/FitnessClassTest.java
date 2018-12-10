package edu.colostate.cs.cs414.ctrlaltdefeat.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Entity.FitnessClass;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.Customer;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.Manager;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.Trainer;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.User;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.UserInfo.Address;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.UserInfo.PersonalInformation;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.UserInfo.Schedule;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.UserInfo.TimeOfDay;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.UserInfo.Weekday;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.UserInfo.WorkTime;

class FitnessClassTest {
	FitnessClass testFitnessClass;
	Trainer testTrainer;
	Address address;
	PersonalInformation pi;
	User ui;
	Schedule testSchedule;
	WorkTime worktime;
	Customer testCustomer;

	@BeforeEach
	   void setUp() throws Exception {
		address = new Address("1234 west maroon circle", "CO", "Littleton", "78758");
	    pi = new PersonalInformation("Melissa", "Smith", "melissaval@me.com", "8304565514", "BlueCrossBlueShield", address);
	    ui = new User("mvsmith", "pass");
	    testTrainer = new Trainer(ui, pi);
	    testSchedule = new Schedule();
	    worktime = new WorkTime(TimeOfDay._8AM, TimeOfDay._10AM, Weekday.MONDAY);
		testFitnessClass = new FitnessClass("Test", testTrainer, testSchedule, 3);
		testCustomer = new Customer(pi);
	   }

	   @AfterEach
	   void tearDown() throws Exception {
		   testFitnessClass = null;
		   testTrainer = null;
		   address = null;
		   pi = null;
		   ui = null;
		   testSchedule = null;
		   worktime = null;
		   testCustomer = null;
	   }

	@Test
	void testFitnessClass() {
		Integer size = 3;
		Assertions.assertEquals("Test", testFitnessClass.getName());
		Assertions.assertEquals(testTrainer, testFitnessClass.getInstructor());
		Assertions.assertEquals(testSchedule, testFitnessClass.getClassSchedule());
		Assertions.assertEquals(size, testFitnessClass.getMaxClassSize());
	}

	@Test
	void testGetName() {
		Assertions.assertEquals("Test", testFitnessClass.getName());
	}

	@Test
	void testSetName() {
		testFitnessClass.setName("Test2");
		Assertions.assertEquals("Test2", testFitnessClass.getName());
	}

	@Test
	void testGetInstructor() {
		Assertions.assertEquals(testTrainer, testFitnessClass.getInstructor());
	}

	@Test
	void testSetInstructor() {
		Address address2 = new Address("1234 west maroon circle", "CO", "Littleton", "78758");
	    PersonalInformation pi2 = new PersonalInformation("Nancy", "Smith", "melissaval@me.com", "8304565514", "BlueCrossBlueShield", address2);
	    User ui2 = new User("nSmith", "pass");
	    Trainer testTrainer2 = new Trainer(ui2, pi2);
	    testFitnessClass.setInstructor(testTrainer2);
	    Assertions.assertEquals(testTrainer2, testFitnessClass.getInstructor());
	}
	@Test
	void testAddAttendee() {
		testFitnessClass.addAttendee(testCustomer);
		Assertions.assertTrue(testFitnessClass.getAttendees().contains(testCustomer));
	}

	@Test
	void testRemoveAttendee() {
		testFitnessClass.removeAttendee(testCustomer);
		Assertions.assertFalse(testFitnessClass.getAttendees().contains(testCustomer));
	}

	@Test
	void testGetAttendees() {
		testFitnessClass.addAttendee(testCustomer);
		Assertions.assertTrue(testFitnessClass.getAttendees().contains(testCustomer));
	}
	@Test
	void testGetClassSchedule() {
		 Assertions.assertEquals(testSchedule, testFitnessClass.getClassSchedule());
	}
	
	@Test
	void testSetClassSchedule() {
		Schedule s = new Schedule();
		s.addWorkTime(worktime);
		testFitnessClass.setClassSchedule(s);
		Assertions.assertEquals(s, testFitnessClass.getClassSchedule());
	}

	@Test
	void testGetClassSize() {
		Integer size = testFitnessClass.getAttendees().size();
		Assertions.assertEquals(size, testFitnessClass.getClassSize());
	}

	@Test
	void testGetMaxClassSize() {
		Integer size = 3;
		Assertions.assertEquals(size, testFitnessClass.getMaxClassSize());
	}

	@Test
	void testSetMaxClassSize() {
		Integer size = 5;
		testFitnessClass.setMaxClassSize(size);
		Assertions.assertEquals(size, testFitnessClass.getMaxClassSize());
	}

	@Test
	void testEqualsObject() {
		FitnessClass testClass = new FitnessClass ("Test", testTrainer, testSchedule, 3);
		Assertions.assertTrue(testFitnessClass.equals(testClass));
	}
	@Test
	void testHashCode() {
		FitnessClass testClass = new FitnessClass ("Test", testTrainer, testSchedule, 3);
		Assertions.assertEquals(testFitnessClass.hashCode(), testClass.hashCode());
	}

}
