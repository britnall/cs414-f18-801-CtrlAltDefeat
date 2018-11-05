 package edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.UserInfo;

import java.util.HashSet;
import java.util.Set;

public class Schedule {
   
   private Set<WorkTime> workSchedule;
	
	public Schedule() {
	   workSchedule = new HashSet<WorkTime>();
	}
	
	public boolean addWorkTime(WorkTime w)
	{
	   return workSchedule.add(w);
	}
	
	public boolean removeWorkTime(WorkTime w)
	{
	   return workSchedule.remove(w);
	}
	
	public WorkTime getWorkTime(Weekday w) 
	{
	   for(WorkTime wk: workSchedule)
	   {
	      if(wk.getDayOfWeek().equals(w))
	      {
	         return wk;
	      }
	   }
	   
	   return null;
	}

   @Override
   public String toString() {
      String s  = "";
      for(WorkTime w: workSchedule)
      {
         s += w.toString() + "\n";
      }
      return s;
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((workSchedule == null) ? 0 : workSchedule.hashCode());
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
      Schedule other = (Schedule) obj;
      if (workSchedule == null) {
         if (other.workSchedule != null)
            return false;
      } else if (!workSchedule.equals(other.workSchedule))
         return false;
      return true;
   }
	
	
	
}
