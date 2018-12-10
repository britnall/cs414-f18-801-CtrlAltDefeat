package edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.UserInfo;

/**
 * Personal information for Gym System
 *
 */
public class PersonalInformation {
   
   private String firstName;              // first name of person
   private String lastName;               // last name of person
   private String email;                  // email of person
   private String phone;                  // phone number of person
   private String healthInsuranceProvider; // health insurance of person
   private Address address;               // address of person
   
   /**
    * @param firstName - first name of person
    * @param lastName - last name of person
    * @param email - email of person
    * @param phone - phone number of person
    * @param healthInsuranceProvider - health insurance of person
    * @param address - address of person
    */
   public PersonalInformation(String firstName, String lastName, String email, String phone,
         String healthInsuranceProvider, Address address) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
      this.phone = phone;
      this.healthInsuranceProvider = healthInsuranceProvider;
      this.address = address;
   }

   /**
    * @return first name of person
    */
   public String getFirstName() {
      return firstName;
   }
   
   /**
    * @return last name of person
    */
   public String getLastName() {
      return lastName;
   }
   
   /**
    * @return email of person
    */
   public String getEmail() {
      return email;
   }
   
   /**
    * Set email of person
    * @param email - email of person
    */
   public void setEmail(String email) {
      this.email = email;
   }
   
   /**
    * @return phone number of person
    */
   public String getPhone() {
      return phone;
   }
   
   /**
    * Set phone number of person
    * @param phone - phone number of person
    */
   public void setPhone(String phone) {
      this.phone = phone;
   }
   
   /**
    * @return health insurance of person
    */
   public String getHealthInsuranceProvider() {
      return healthInsuranceProvider;
   }
   
   /**
    * Set health insurance of person
    * @param healthInsuranceProvider - health insurance of person
    */
   public void setHealthInsuranceProvider(String healthInsuranceProvider) {
      this.healthInsuranceProvider = healthInsuranceProvider;
   }
   
   /**
    * @return address of person
    */
   public Address getAddress() {
	      return this.address;
	}
   
   /**
    * Set address of person
    * @param address - address of person
    */
   public void setAddress(Address address) {
      this.address = address;
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((address == null) ? 0 : address.hashCode());
      result = prime * result + ((email == null) ? 0 : email.hashCode());
      result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
      result = prime * result + ((healthInsuranceProvider == null) ? 0 : healthInsuranceProvider.hashCode());
      result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
      result = prime * result + ((phone == null) ? 0 : phone.hashCode());
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
      PersonalInformation other = (PersonalInformation) obj;
      if (address == null) {
         if (other.address != null)
            return false;
      } else if (!address.equals(other.address))
         return false;
      if (email == null) {
         if (other.email != null)
            return false;
      } else if (!email.equals(other.email))
         return false;
      if (firstName == null) {
         if (other.firstName != null)
            return false;
      } else if (!firstName.equals(other.firstName))
         return false;
      if (healthInsuranceProvider == null) {
         if (other.healthInsuranceProvider != null)
            return false;
      } else if (!healthInsuranceProvider.equals(other.healthInsuranceProvider))
         return false;
      if (lastName == null) {
         if (other.lastName != null)
            return false;
      } else if (!lastName.equals(other.lastName))
         return false;
      if (phone == null) {
         if (other.phone != null)
            return false;
      } else if (!phone.equals(other.phone))
         return false;
      return true;
   }

   
}
