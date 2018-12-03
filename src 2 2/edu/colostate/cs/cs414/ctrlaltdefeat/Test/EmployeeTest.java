package edu.colostate.cs.cs414.ctrlaltdefeat.Test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.Employee;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.Manager;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.Trainer;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.User;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.UserType;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.UserInfo.Address;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.UserInfo.PersonalInformation;

class EmployeeTest {
   PersonalInformation pi;
   Address address;
   User ui;
   Manager testManager;
   Trainer testTrainer;
   Employee testEmployee;
   
   @BeforeEach
   void setUp() throws Exception {
      address = new Address("1234 west maroon circle", "CO", "Littleton", "78758");
      pi = new PersonalInformation("Melissa", "Smith", "melissaval@me.com", "8304565514", "BlueCrossBlueShield", address);
      ui = new User("mvsmith", "pass");
      testManager = new Manager(ui, pi);
      testTrainer = new Trainer(ui, pi);
      
      testEmployee = (Employee) testManager;
      
   }

   @AfterEach
   void tearDown() throws Exception {
      testManager = null;
      testTrainer = null;
      testEmployee = null;
   }

	@Test
	void testGetUserType() {
		Assertions.assertEquals(UserType.MANAGER, testManager.getUserType());
		Assertions.assertEquals(UserType.TRAINER, testTrainer.getUserType());
	}

	@Test
	void testGetPersonalInfo() {
		Assertions.assertEquals(pi, testEmployee.getPersonalInfo());
	}

	@Test
	void testGetUserInfo() {
      Assertions.assertEquals(ui, testEmployee.getUserInfo());
	}
	
	@Test
	void testUpdatePersonalInfo()
	{
	   PersonalInformation update = new PersonalInformation("Brittany", "Nall", "brittany.nall@gmail.com", 
	                              "5095543182", "BlueCrossBlueShield", address);
	   testEmployee.updatePersonalInfo(update);
	   Assertions.assertEquals("Melissa", testEmployee.getPersonalInfo().getFirstName());
      Assertions.assertEquals("Smith", testEmployee.getPersonalInfo().getLastName());
      Assertions.assertEquals("brittany.nall@gmail.com", testEmployee.getPersonalInfo().getEmail());
      Assertions.assertEquals("5095543182", testEmployee.getPersonalInfo().getPhone());
      Assertions.assertEquals("BlueCrossBlueShield", testEmployee.getPersonalInfo().getHealthInsuranceProvider());
      Assertions.assertEquals(address, testEmployee.getPersonalInfo().getAddress());
	}

	void testUpdatePassword() 
	{
	   User update = new User("user", "password");
	   testEmployee.updatePassword(update);
	   Assertions.assertEquals("mvsmith", testEmployee.getUserInfo().getUserName());
	   Assertions.assertEquals("password", testEmployee.getUserInfo().getPassword());
	}
	
	@Test
	void testHashCode() 
	{	   			
	   Manager update = testManager;
	   Assertions.assertEquals(update.hashCode(), testManager.hashCode());
	}
	@Test
	void testEquals() {
			Assertions.assertTrue(testEmployee.equals(testManager));
	}
	@Test
	void testNotEquals() {
	   PersonalInformation update = new PersonalInformation("Brittany", "Nall", "brittany.nall@gmail.com", 
            "5095543182", "BlueCrossBlueShield", address);
	   testTrainer.updatePersonalInfo(update);
	   Assertions.assertFalse(testEmployee.equals(testTrainer));
	}

}
