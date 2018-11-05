package edu.colostate.cs.cs414.ctrlaltdefeat.Test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.UserInfo.Weekday;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.UserInfo.WorkTime;

class WorkTimeTest {
   WorkTime testWorkTime;

   @BeforeEach
   void setUp() throws Exception {
      testWorkTime = new WorkTime("09:00", "06:00", Weekday.MONDAY);
   }

   @AfterEach
   void tearDown() throws Exception {
      testWorkTime = null;
   }

   @Test
   void testGetStartTime() {
      Assertions.assertEquals("09:00", testWorkTime.getStartTime());
   }

   @Test
   void testSetStartTime() {
      testWorkTime.setStartTime("08:00");
      Assertions.assertEquals("08:00", testWorkTime.getStartTime());
   }

   @Test
   void testGetEndTime() {
      Assertions.assertEquals("06:00", testWorkTime.getEndTime());
   }

   @Test
   void testSetEndTime() {
      testWorkTime.setEndTime("05:00");
      Assertions.assertEquals("05:00", testWorkTime.getEndTime());
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
      WorkTime copy = new WorkTime("09:00", "06:00", Weekday.MONDAY);
      Assertions.assertEquals(testWorkTime.hashCode(), copy.hashCode());
   }

   @Test
   void testEquals() {
      WorkTime copy = new WorkTime("09:00", "06:00", Weekday.MONDAY);
      Assertions.assertTrue(testWorkTime.equals(copy));
   }

   @Test
   void testNotEquals() {
      WorkTime comp = new WorkTime("09:00", "06:00", Weekday.TUESDAY);
      Assertions.assertFalse(testWorkTime.equals(comp));
   }

}
