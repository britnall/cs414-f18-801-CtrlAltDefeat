package edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users;

import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.UserInfo.PersonalInformation;

/**
 * Employee of the Gym System (Trainer or Manager)
 *
 */
public class Employee {
   
   private User userInfo;             // user information for login       
   private UserType userType;         // specifies whether employee is trainer or manager
   private PersonalInformation personalInfo; // personal information
   
   /**
    * @param userInfo - user information for login 
    * @param personalInfo - personal information
    * @param userType - specifies whether employee is trainer or manager
    */
   public Employee(User userInfo, PersonalInformation personalInfo, UserType userType) {
      this.userInfo = userInfo;
      this.personalInfo = personalInfo;
      this.userType = userType;
   }
   
   /**
    * @return user information for login
    */
   public User getUserInfo() {
      return userInfo;
   }
   
   /**
    * @param userInfo - user information for login to update password
    */
   public void updatePassword(User userInfo) {
      this.userInfo.setPassword(userInfo.getPassword());
   }
   
   /**
    * @return personal information
    */
   public PersonalInformation getPersonalInfo() {
      return personalInfo;
   }
   
   /**
    * @param personalInfo - personal information to update address, email, health insurance
    *                       and phone number
    */
   public void updatePersonalInfo(PersonalInformation personalInfo) {
      this.personalInfo.setAddress(personalInfo.getAddress());
      this.personalInfo.setEmail(personalInfo.getEmail());
      this.personalInfo.setHealthInsuranceProvider(personalInfo.getHealthInsuranceProvider());
      this.personalInfo.setPhone(personalInfo.getPhone());
   }  
   
   /**
    * @return specifies whether employee is trainer or manager
    */
   public UserType getUserType() {
      return userType;
   }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((personalInfo == null) ? 0 : personalInfo.hashCode());
		result = prime * result + ((userInfo == null) ? 0 : userInfo.hashCode());
		result = prime * result + ((userType == null) ? 0 : userType.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (personalInfo == null) {
			if (other.personalInfo != null)
				return false;
		} else if (!personalInfo.equals(other.personalInfo))
			return false;
		if (userInfo == null) {
			if (other.userInfo != null)
				return false;
		} else if (!userInfo.equals(other.userInfo))
			return false;
		if (userType != other.userType)
			return false;
		return true;
	}
}
