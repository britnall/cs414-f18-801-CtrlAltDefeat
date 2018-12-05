package edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users;

import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.UserInfo.PersonalInformation;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.UserInfo.Schedule;

/**
 * Trainer of Gym System
 *
 */
public class Trainer extends Employee{
   private Schedule schedule;       // Schedule of trainer
   
   /**
    * @param userInfo - user information for login
    * @param personalInfo - personal information
    */   
   public Trainer(User userInfo, PersonalInformation personalInfo) {
      super(userInfo, personalInfo, UserType.TRAINER);    
   }
   
   /**
    * @param schedule - schedule of trainer
    */
   public void setSchedule(Schedule schedule)
   {
      this.schedule = schedule;
   }
   
   /**
    * @return schedule of trainer
    */
   public Schedule getSchedule()
   {
      return this.schedule;
   }
}
