package edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.UserInfo;

public class PersonalInformation {
   
   private String firstName;
   private String lastName;
   private String email;
   private String phone;
   private String healthInsuranceProvider;
   private Address address;
   
   public PersonalInformation(String firstName, String lastName, String email, String phone, String ID,
         String healthInsuranceProvider, Address address) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
      this.phone = phone;
      this.healthInsuranceProvider = healthInsuranceProvider;
      this.address = address;
   }

   public String getFirstName() {
      return firstName;
   }
   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }
   public String getLastName() {
      return lastName;
   }
   public void setLastName(String lastName) {
      this.lastName = lastName;
   }
   public String getEmail() {
      return email;
   }
   public void setEmail(String email) {
      this.email = email;
   }
   public String getPhone() {
      return phone;
   }
   public void setPhone(String phone) {
      this.phone = phone;
   }
   public String getHealthInsuranceProvider() {
      return healthInsuranceProvider;
   }
   public void setHealthInsuranceProvider(String healthInsuranceProvider) {
      this.healthInsuranceProvider = healthInsuranceProvider;
   }
   public Address getAddress() {
	      return this.address;
	}
   public void setAddress(Address address) {
      this.address = address;
   }
   
   public boolean isValid()
   {
      if(firstName.equals("")  && lastName.equals("") && email.equals("") && 
            phone.equals("") && healthInsuranceProvider.equals(""))
      {
         return false;
      }
      return true;
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
