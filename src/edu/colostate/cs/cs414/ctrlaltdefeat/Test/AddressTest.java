package edu.colostate.cs.cs414.ctrlaltdefeat.Test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.UserInfo.Address;

class AddressTest {
   Address testAddress;

   @BeforeEach
   void setUp() throws Exception {
      testAddress = new Address("1234 west maroon circle", "CO", "Littleton", "78758");
   }

   @AfterEach
   void tearDown() throws Exception {
      testAddress = null;
   }

   @Test
   void testGetStreet() {
      Assertions.assertEquals("1234 west maroon circle", testAddress.getStreet(), "Unexpected Street");
   }

   @Test
   void testSetStreet() {
      testAddress.setStreet("1234 west Ken Caryl");
      Assertions.assertEquals("1234 west Ken Caryl", testAddress.getStreet(), "Unexpected Street");
   }

   @Test
   void testGetState() {
      Assertions.assertEquals("CO", testAddress.getState());
   }

   @Test
   void testSetState() {
      testAddress.setState("TX");
      Assertions.assertEquals("TX", testAddress.getState());
   }

   @Test
   void testGetCity() {
      Assertions.assertEquals("Littleton", testAddress.getCity());
   }

   @Test
   void testSetCity() {
      testAddress.setCity("Austin");
   }

   @Test
   void testGetZipCode() {
      Assertions.assertEquals("78758", testAddress.getZipCode());
   }

   @Test
   void testSetZipCode() {
      testAddress.setZipCode("800123");
      Assertions.assertEquals("800123", testAddress.getZipCode());
   }

   @Test
   void testHashCode() {
      Address compAddress = new Address("1234 west maroon circle", "CO", "Littleton", "78758");
      Assertions.assertEquals(testAddress.hashCode(), compAddress.hashCode());
   }

   @Test
   void testEquals() {
      Address compAddress = new Address("1234 west maroon circle", "CO", "Littleton", "78758");
      Assertions.assertTrue(testAddress.equals(compAddress));
   }

   @Test
   void testNotEquals() {
      Address compAddress = new Address("1234 west maroon circle", "TX", "Austin", "78758");
      Assertions.assertFalse(testAddress.equals(compAddress));
   }

}
