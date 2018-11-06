package edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users;

import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.UserInfo.PersonalInformation;

public class Manager extends Employee {

   public Manager(User userInfo, PersonalInformation personalInfo) {
      super(userInfo, personalInfo, UserType.MANAGER);    
   }
}
