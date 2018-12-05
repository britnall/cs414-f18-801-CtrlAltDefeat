package edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users;

import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.UserInfo.PersonalInformation;

/**
 * Manager of the Gym System
 *
 */
public class Manager extends Employee {

   /**
    * @param userInfo - user information for login
    * @param personalInfo - personal information
    */
   public Manager(User userInfo, PersonalInformation personalInfo) {
      super(userInfo, personalInfo, UserType.MANAGER);    
   }
}
