package edu.colostate.cs.cs414.ctrlaltdefeat.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Entity.Exercise;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Entity.WorkoutRoutine;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.Customer;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.UserInfo.Address;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.UserInfo.MembershipStatus;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.UserInfo.PersonalInformation;

class CustomerTest {
   WorkoutRoutine routine;
   ArrayList<Exercise> exercises;
   Exercise e1;
   PersonalInformation pi;
   Address address;
   Customer testCustomer;

   @BeforeEach
   void setUp() throws Exception {
      exercises = new ArrayList<Exercise>();
      e1 = new Exercise("arm-Stretch", 3, 4, null);
      routine = new WorkoutRoutine("Warm-up", exercises);
      address = new Address("1234 west maroon circle", "CO", "Littleton", "78758");
      pi = new PersonalInformation("Melissa", "Smith", "melissaval@me.com", "8304565514", "BlueCrossBlueShield",
            address);
      testCustomer = new Customer(pi);
   }

   @AfterEach
   void tearDown() throws Exception {
      testCustomer = null;
   }

   @Test
   void testGetPersonalInfo() {
      Assertions.assertEquals(pi, testCustomer.getPersonalInfo());
   }

   @Test
   void testUpdatePersonalInfo() {
      PersonalInformation update = new PersonalInformation("Brittany", "Nall", "brittany.nall@gmail.com", "5095543182",
            "BlueCrossBlueShield", address);
      testCustomer.updatePersonalInfo(update);
      Assertions.assertEquals("Melissa", testCustomer.getPersonalInfo().getFirstName());
      Assertions.assertEquals("Smith", testCustomer.getPersonalInfo().getLastName());
      Assertions.assertEquals("brittany.nall@gmail.com", testCustomer.getPersonalInfo().getEmail());
      Assertions.assertEquals("5095543182", testCustomer.getPersonalInfo().getPhone());
      Assertions.assertEquals("BlueCrossBlueShield", testCustomer.getPersonalInfo().getHealthInsuranceProvider());
      Assertions.assertEquals(address, testCustomer.getPersonalInfo().getAddress());
   }

   @Test
   void testGetMembershipStatus() {
      Assertions.assertEquals(MembershipStatus.ACTIVE, testCustomer.getStatus());
   }

   @Test
   void testSetMembershipStatus() {
      testCustomer.setStatus(MembershipStatus.INACTIVE);
      Assertions.assertEquals(MembershipStatus.INACTIVE, testCustomer.getStatus());
   }

   @Test
   void testAddWorkoutRoutine() {
      WorkoutRoutine wr = new WorkoutRoutine("Cool-Down", exercises);
      testCustomer.addRoutine(wr);
      Assertions.assertTrue(testCustomer.getWorkoutRoutines().contains(wr));
   }

   @Test
   void testRemoveWorkoutRoutine() {
      testCustomer.addRoutine(routine);
      testCustomer.removeRoutine(routine);
      Assertions.assertFalse(testCustomer.getWorkoutRoutines().contains(routine));
   }

   @Test
   void testSetWorkoutRoutines() {
      WorkoutRoutine wr = new WorkoutRoutine("Cool-Down", exercises);
      Set<WorkoutRoutine> routines = new HashSet<WorkoutRoutine>();
      routines.add(wr);
      routines.add(routine);
      testCustomer.setWorkoutRoutines(routines);
      Assertions.assertEquals(testCustomer.getWorkoutRoutines(), routines);
   }

   @Test
   void testGetWorkoutRoutines() {
      WorkoutRoutine wr = new WorkoutRoutine("Cool-Down", exercises);
      testCustomer.addRoutine(routine);
      testCustomer.addRoutine(wr);
      Set<WorkoutRoutine> routines = new HashSet<WorkoutRoutine>();
      routines.add(wr);
      routines.add(routine);
      Assertions.assertEquals(testCustomer.getWorkoutRoutines(), routines);
   }

   @Test
   void testHashCode() {
      Customer copy = new Customer(pi);
      Assertions.assertEquals(testCustomer.hashCode(), copy.hashCode());
   }

   @Test
   void testEquals() {
      Customer copy = new Customer(pi);
      Assertions.assertTrue(testCustomer.equals(copy));
   }

   @Test
   void testNotEquals() {
      PersonalInformation update = new PersonalInformation("Brittany", "Nall", "brittany.nall@gmail.com", "5095543182",
            "BlueCrossBlueShield", address);
      Customer copy = new Customer(update);
      Assertions.assertFalse(testCustomer.equals(copy));
   }

}
