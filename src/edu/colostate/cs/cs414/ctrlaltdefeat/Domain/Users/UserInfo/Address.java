package edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.UserInfo;


public class Address {

   private String street;
   private String state;
   private String city;
   private String zipCode;
   
   public Address(String street, String state, String city, String zipCode) {
      this.street = street;
      this.state = state;
      this.city = city;
      this.zipCode = zipCode;
   }
   
   public String getStreet() {
      return street;
   }
   public void setStreet(String street) {
      this.street = street;
   }
   public String getState() {
      return state;
   }
   public void setState(String state) {
      this.state = state;
   }
   public String getCity() {
      return city;
   }
   public void setCity(String city) {
      this.city = city;
   }
   public String getZipCode() {
      return zipCode;
   }
   public void setZipCode(String zipCode) {
      this.zipCode = zipCode;
   }
   
   public boolean isValid()
   {
      if(street.equals("") && city.equals("") && 
            state.equals("") && zipCode.equals(""))
      {
         return false;
      }
      return true;
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
