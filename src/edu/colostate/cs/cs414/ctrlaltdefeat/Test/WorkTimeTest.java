package edu.colostate.cs.cs414.ctrlaltdefeat.Test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.UserInfo.TimeOfDay;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.UserInfo.Weekday;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.UserInfo.WorkTime;

class WorkTimeTest {
   WorkTime testWorkTime;

   @BeforeEach
   void setUp() throws Exception {
      testWorkTime = new WorkTime(TimeOfDay._10AM, TimeOfDay._8PM, Weekday.MONDAY);
   }

   @AfterEach
   void tearDown() throws Exception {
      testWorkTime = null;
   }

   @Test
   void testGetStartTime() {
      Assertions.assertEquals(TimeOfDay._10AM, testWorkTime.getStartTime());
   }

   @Test
   void testSetStartTime() {
      testWorkTime.setStartTime(TimeOfDay._8AM);
      Assertions.assertEquals(TimeOfDay._8AM, testWorkTime.getStartTime());
   }

   @Test
   void testGetEndTime() {
      Assertions.assertEquals(TimeOfDay._8PM, testWorkTime.getEndTime());
   }

   @Test
   void testSetEndTime() {
      testWorkTime.setEndTime(TimeOfDay._5PM);
      Assertions.assertEquals(TimeOfDay._5PM, testWorkTime.getEndTime());
   }

   @Test
   void testGetDayOfWeek() {
      Assertions.assertEquals(Weekday.MONDAY, testWorkTime.getDayOfWeek());
   }

   @Test
   void testSetDayOfWeek() {
      testWorkTime.setDayOfWeek(Weekday.TUESDAY);
      Assertions.assertEquals(Weekday.TUESDAY, testWorkTime.getDayOfWeek());
   }
   
   @Test
   void testHashCode() {
      WorkTime copy = new WorkTime(TimeOfDay._10AM, TimeOfDay._8PM, Weekday.MONDAY);
      Assertions.assertEquals(testWorkTime.hashCode(), copy.hashCode());
   }

   @Test
   void testEquals() {
      WorkTime copy = new WorkTime(TimeOfDay._10AM, TimeOfDay._8PM, Weekday.MONDAY);
      Assertions.assertTrue(testWorkTime.equals(copy));
   }

   @Test
   void testNotEquals() {
      WorkTime comp = new WorkTime(TimeOfDay._10AM, TimeOfDay._8PM, Weekday.TUESDAY);
      Assertions.assertFalse(testWorkTime.equals(comp));
   }

}
