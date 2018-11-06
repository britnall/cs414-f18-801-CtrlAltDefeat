package edu.colostate.cs.cs414.ctrlaltdefeat.Test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.UserInfo.Address;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.UserInfo.PersonalInformation;

class PersonalInformationTest {
   PersonalInformation testPI;
   Address address;

   @BeforeEach
   void setUp() throws Exception {
      address = new Address("1234 west maroon circle", "CO", "Littleton", "78758");
      testPI = new PersonalInformation("Melissa", "Smith", "melissaval@me.com", "8304565514", "BlueCrossBlueShield", address);
   }

   @AfterEach
   void tearDown() throws Exception {
      testPI = null;
   }

	@Test
	void testPersonalInformation() {
		Assertions.assertEquals("Melissa", testPI.getFirstName());
		Assertions.assertEquals("Smith", testPI.getLastName());
		Assertions.assertEquals("melissaval@me.com", testPI.getEmail());
		Assertions.assertEquals("BlueCrossBlueShield", testPI.getHealthInsuranceProvider());
	}

	@Test
	void testGetFirstName() {
			Assertions.assertEquals("Melissa", testPI.getFirstName());
	}

	@Test
	void testGetLastName() {
			Assertions.assertEquals("Smith", testPI.getLastName());
	}

	@Test
	void testGetEmail() {
			Assertions.assertEquals("melissaval@me.com", testPI.getEmail());
	}

	@Test
	void testSetEmail() {
			testPI.setEmail("test@me.com");
	}

	@Test
	void testGetPhone() {
			Assertions.assertEquals("8304565514", testPI.getPhone());
	}

	@Test
	void testSetPhone() {
			testPI.setPhone("8304565515");
			Assertions.assertEquals("8304565515", testPI.getPhone());
	}

	@Test
	void testGetHealthInsuranceProvider() {
			Assertions.assertEquals("BlueCrossBlueShield", testPI.getHealthInsuranceProvider());
	}

	@Test
	void testSetHealthInsuranceProvider() {
			testPI.setHealthInsuranceProvider("Humana");
			Assertions.assertEquals("Humana", testPI.getHealthInsuranceProvider());
	}
	
	@Test
	void testGetAddress() {
			Assertions.assertEquals(address, testPI.getAddress());
	}

	@Test
	void testSetAddress() {
			Address a = new Address("123 Street", "testCity", "CO", "78725");
			testPI.setAddress(a);
			Assertions.assertEquals(a, testPI.getAddress());
	}
	
	@Test
	void testHashCode() {
			PersonalInformation copy = new PersonalInformation("Melissa", "Smith", "melissaval@me.com", "8304565514", "BlueCrossBlueShield", address);
			Assertions.assertEquals(testPI.hashCode(), copy.hashCode());
	}
	@Test
	void testEquals() {
			PersonalInformation copy = new PersonalInformation("Melissa", "Smith", "melissaval@me.com", "8304565514", "BlueCrossBlueShield", address);
			Assertions.assertTrue(testPI.equals(copy));
	}
	@Test
	void testNotEquals() {
			PersonalInformation comp = new PersonalInformation("Nancy", "Smith", "melissaval@me.com", "8304565514", "BlueCrossBlueShield", address);
			Assertions.assertFalse(testPI.equals(comp));
	}

}
