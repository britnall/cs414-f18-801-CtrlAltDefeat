package edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users;

import java.util.HashSet;
import java.util.Set;

import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Entity.WorkoutRoutine;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.UserInfo.MembershipStatus;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.UserInfo.PersonalInformation;

/**
 * Customer for the Gym System
 *
 */
public class Customer {

   private PersonalInformation personalInfo;    // Personal information
   private MembershipStatus status;             // Status of Membership
   private Set<WorkoutRoutine> routines;        // Assigned workout routine
   
   /**
    * Creates customer with an active membership and no workout routines
    * @param personalInfo - Personal information
    */
   public Customer(PersonalInformation personalInfo) {
      this.personalInfo = personalInfo;
      this.status = MembershipStatus.ACTIVE;
      routines = new HashSet<WorkoutRoutine>();
   }
   
   /**
    * @return Personal information
    */
   public PersonalInformation getPersonalInfo() {
      return personalInfo;
   }
   
   /**
    * @param personalInfo - Personal information
    */
   public void updatePersonalInfo(PersonalInformation personalInfo) {
      this.personalInfo.setAddress(personalInfo.getAddress());
      this.personalInfo.setEmail(personalInfo.getEmail());
      this.personalInfo.setHealthInsuranceProvider(personalInfo.getHealthInsuranceProvider());
      this.personalInfo.setPhone(personalInfo.getPhone());
   }
   
   /**
    * @return Status of Membership
    */
   public MembershipStatus getStatus() {
      return status;
   }
   
   /**
    * @param status - Status of Membership
    */
   public void setStatus(MembershipStatus status) {
      this.status = status;
   }
  
   /**
    * @param r - workout routine to assign
    */
   public void addRoutine(WorkoutRoutine r) {
	   this.routines.add(r);
   }
   
   /**
    * @param r - remove assigned workout routine
    */
   public void removeRoutine(WorkoutRoutine r) {
	   this.routines.remove(r);
   }
   
   /**
    * @param wr - list of workout routines
    */
   public void setWorkoutRoutines(Set<WorkoutRoutine> wr) {
      this.routines = wr;
   }
   
   /**
    * @return list of workout routines
    */
   public Set<WorkoutRoutine> getWorkoutRoutines() {
      return this.routines;
   }
   
   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((personalInfo == null) ? 0 : personalInfo.hashCode());
      result = prime * result + ((routines == null) ? 0 : routines.hashCode());
      result = prime * result + ((status == null) ? 0 : status.hashCode());
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
      Customer other = (Customer) obj;
      if (personalInfo == null) {
         if (other.personalInfo != null)
            return false;
      } else if (!personalInfo.equals(other.personalInfo))
         return false;
      if (routines == null) {
         if (other.routines != null)
            return false;
      } else if (!routines.equals(other.routines))
         return false;
      if (status != other.status)
         return false;
      return true;
   }
   

}
