package edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users;

import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.UserInfo.PersonalInformation;

public class Employee {
   private User userInfo;
   private UserType userType;
   private PersonalInformation personalInfo;
   
   public Employee(User userInfo, PersonalInformation personalInfo, UserType userType) {
      this.userInfo = userInfo;
      this.personalInfo = personalInfo;
      this.setUserType(userType);
   }
   
   public User getUserInfo() {
      return userInfo;
   }
   public void setUserInfo(User userInfo) {
      this.userInfo = userInfo;
   }
   public PersonalInformation getPersonalInfo() {
      return personalInfo;
   }
   public void setPersonalInfo(PersonalInformation personalInfo) {
      this.personalInfo = personalInfo;
   }

   public UserType getUserType() {
      return userType;
   }

   public void setUserType(UserType userType) {
      this.userType = userType;
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
