package edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.UserInfo;


/**
 * Address Information for Gym System
 *
 */
public class Address {

   private String street;  // street of residence   
   private String state;   // state of residence   
   private String city;    // city of residence   
   private String zipCode; // zipcode of residence
   
   /**
    * @param street - street of residence  
    * @param state -  state of residence  
    * @param city - city of residence  
    * @param zipCode - zipcode of residence  
    */
   public Address(String street, String state, String city, String zipCode) {
      this.street = street;
      this.state = state;
      this.city = city;
      this.zipCode = zipCode;
   }
   
   /**
    * @return street of residence
    */
   public String getStreet() {
      return street;
   }
   
   /**
    * Set street of residence
    * @param street - street of residence
    */
   public void setStreet(String street) {
      this.street = street;
   }
   
   /**
    * @return state of residence
    */
   public String getState() {
      return state;
   }
   
   /**
    * Set state of residence
    * @param state - state of residence
    */
   public void setState(String state) {
      this.state = state;
   }
   
   /**
    * @return city of residence
    */
   public String getCity() {
      return city;
   }
   
   /**
    * Set city of residence
    * @param city - city of residence
    */
   public void setCity(String city) {
      this.city = city;
   }
   
   /**
    * @return zipcode of residence
    */
   public String getZipCode() {
      return zipCode;
   }
   
   /**
    * Set the zipcode
    * @param zipCode - zipcode of residence
    */
   public void setZipCode(String zipCode) {
      this.zipCode = zipCode;
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((city == null) ? 0 : city.hashCode());
      result = prime * result + ((state == null) ? 0 : state.hashCode());
      result = prime * result + ((street == null) ? 0 : street.hashCode());
      result = prime * result + ((zipCode == null) ? 0 : zipCode.hashCode());
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
      Address other = (Address) obj;
      if (city == null) {
         if (other.city != null)
            return false;
      } else if (!city.equals(other.city))
         return false;
      if (state == null) {
         if (other.state != null)
            return false;
      } else if (!state.equals(other.state))
         return false;
      if (street == null) {
         if (other.street != null)
            return false;
      } else if (!street.equals(other.street))
         return false;
      if (zipCode == null) {
         if (other.zipCode != null)
            return false;
      } else if (!zipCode.equals(other.zipCode))
         return false;
      return true;
   }

   
}
