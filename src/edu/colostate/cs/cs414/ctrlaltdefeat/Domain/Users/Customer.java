package edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users;

import java.util.HashSet;
import java.util.Set;

import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Entity.WorkoutRoutine;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.UserInfo.MembershipStatus;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.UserInfo.PersonalInformation;

public class Customer {

   private PersonalInformation personalInfo;
   private MembershipStatus status;
   private Set<WorkoutRoutine> routines;
   
   public Customer(PersonalInformation personalInfo) {
      this.personalInfo = personalInfo;
      this.status = MembershipStatus.ACTIVE;
      routines = new HashSet<WorkoutRoutine>();
   }
   
   public PersonalInformation getPersonalInfo() {
      return personalInfo;
   }
   public void setPersonalInfo(PersonalInformation personalInfo) {
      this.personalInfo = personalInfo;
   }
   public MembershipStatus getStatus() {
      return status;
   }
   public void setStatus(MembershipStatus status) {
      this.status = status;
   }
   public void addRoutine(WorkoutRoutine r) {
	   routines.add(r);
   }
   public void removeRoutine(WorkoutRoutine r) {
	   routines.remove(r);
   }

   public void setWorkoutRoutines(Set<WorkoutRoutine> workoutRoutines) {
      routines = workoutRoutines;   
   }

   public Set<WorkoutRoutine> getWorkoutRoutines() {
      return routines;
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
