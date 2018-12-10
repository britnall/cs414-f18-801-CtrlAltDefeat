package edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users;

/**
 * User login information of an Employee
 *
 */
public class User {
   private String userName;   // username used for login
   private String password;   // password used for login
   
   /**
    * @param userName - username used for login
    * @param password - password used for login
    */
   public User(String userName, String password) {
      this.userName = userName;
      this.password = password;
   }
   
   /**
    * @return username used for login
    */
   public String getUserName() {
      return userName;
   }

   /**
    * @return password used for login
    */
   public String getPassword() {
      return password;
   }

   /**
    * @param password - password used for login
    */
   public void setPassword(String password) {
      this.password = password;
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((password == null) ? 0 : password.hashCode());
      result = prime * result + ((userName == null) ? 0 : userName.hashCode());
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
      User other = (User) obj;
      if (password == null) {
         if (other.password != null)
            return false;
      } else if (!password.equals(other.password))
         return false;
      if (userName == null) {
         if (other.userName != null)
            return false;
      } else if (!userName.equals(other.userName))
         return false;
      return true;
   }
   
}
