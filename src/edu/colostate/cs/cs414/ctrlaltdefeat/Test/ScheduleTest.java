package edu.colostate.cs.cs414.ctrlaltdefeat.Test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.UserInfo.Schedule;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.UserInfo.Weekday;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.UserInfo.WorkTime;

class ScheduleTest {
   Schedule testSchedule;
   WorkTime worktime;
   
   @BeforeEach
   void setUp() throws Exception {
      testSchedule = new Schedule();
      worktime = new WorkTime("09:00", "06:00", Weekday.MONDAY);
   }

   @AfterEach
   void tearDown() throws Exception {
      worktime = null;
   }
   
   @Test
   void testAddWorkTime() {
      testSchedule.addWorkTime(worktime);
      Assertions.assertTrue(testSchedule.getWorkTime().contains(worktime));
   }
   
   void testRemoveWorkTime() 
   {
      testSchedule.addWorkTime(worktime);
      testSchedule.removeWorkTime(worktime);
      Assertions.assertFalse(testSchedule.getWorkTime().contains(worktime));
   }

}
