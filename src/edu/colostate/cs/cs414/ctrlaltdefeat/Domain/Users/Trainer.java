package edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users;

import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.UserInfo.PersonalInformation;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.UserInfo.Schedule;

public class Trainer extends Employee{
   private Schedule schedule;
   
   public Trainer(User userInfo, PersonalInformation personalInfo) {
      super(userInfo, personalInfo, UserType.TRAINER);    
   }
   
   public void setSchedule(Schedule schedule)
   {
      this.schedule = schedule;
   }
   
   public Schedule getSchedule()
   {
      return this.schedule;
   }
}
