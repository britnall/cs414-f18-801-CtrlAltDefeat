package edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.UserInfo;

public class WorkTime {
	private String startTime;
	private String endTime;
	private Weekday dayOfWeek;
	
	public WorkTime(String start, String end, Weekday day) {
		this.startTime = start;
		this.endTime = end;
		this.dayOfWeek = day;
	}

   public String getStartTime() {
      return startTime;
   }

   public void setStartTime(String startTime) {
      this.startTime = startTime;
   }

   public String getEndTime() {
      return endTime;
   }

   public void setEndTime(String endTime) {
      this.endTime = endTime;
   }

   public Weekday getDayOfWeek() {
      return dayOfWeek;
   }

   public void setDayOfWeek(Weekday dayOfWeek) {
      this.dayOfWeek = dayOfWeek;
   }

   @Override
   public String toString() {
      return "[startTime=" + startTime + ", endTime=" + endTime + ", dayOfWeek=" + dayOfWeek + "]";
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((dayOfWeek == null) ? 0 : dayOfWeek.hashCode());
      result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
      result = prime * result + ((startTime == null) ? 0 : startTime.hashCode());
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
      WorkTime other = (WorkTime) obj;
      if (dayOfWeek != other.dayOfWeek)
         return false;
      if (endTime == null) {
         if (other.endTime != null)
            return false;
      } else if (!endTime.equals(other.endTime))
         return false;
      if (startTime == null) {
         if (other.startTime != null)
            return false;
      } else if (!startTime.equals(other.startTime))
         return false;
      return true;
   }

}
