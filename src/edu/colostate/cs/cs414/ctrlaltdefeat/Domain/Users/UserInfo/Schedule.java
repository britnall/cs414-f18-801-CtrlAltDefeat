 package edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.UserInfo;

import java.util.ArrayList;

public class Schedule {
   
   private ArrayList<WorkTime> workSchedule;
	
	public Schedule() 
	{
	   workSchedule = new ArrayList<WorkTime>();
	   
	   // Schedule should be organized by day of the week starting
      // with Sunday and ending with Saturday
	   
	   for(int i = 0; i < Weekday.values().length; i++)
	   {
	      workSchedule.add(null);
	   }
	}
	
	public boolean addWorkTime(WorkTime w)
	{
	   // Make sure the schedule doesn't already have
	   // WorkTime for that day. If so, override it.
	   
	   workSchedule.remove(w.getDayOfWeek().ordinal());
	   workSchedule.add(w.getDayOfWeek().ordinal(), w);
	   
	   return true;
	}
	
	public boolean removeWorkTime(WorkTime w)
	{
	   boolean results = workSchedule.remove(w);
	   return results;
	}
	
	public ArrayList<WorkTime> getWorkTime()
	{
	   return this.workSchedule;
	}

   @Override
   public String toString() {
      String s  = "";
      for(WorkTime w: workSchedule)
      {
         if(w != null)
         {
            s += w.toString() + "\n";
         }         
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
