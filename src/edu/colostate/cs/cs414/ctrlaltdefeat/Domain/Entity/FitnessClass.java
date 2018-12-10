package edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Entity;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.Customer;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.Trainer;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.UserInfo.Schedule;

import java.util.ArrayList;


/**
 * 
 *Fitness Class in the Gym
 *
 */
public class FitnessClass {
	private Trainer instructor;
	private String name;
	private String description;
	private ArrayList<Customer> attendees;
	private Schedule classSchedule;
	private Integer maxClassSize;
	
	/**
    * @param name - name of the class
    * @param Trainer - instructor for the class
    * @param Schedule - class schedule
    * @param max - max number of customers for the class
    */
	
	public FitnessClass(String name, Trainer i, Schedule s, Integer max) {
		this.name = name;
		this.instructor = i;
		attendees = new ArrayList<Customer>();
		classSchedule = s;
		maxClassSize = max;
	}
	/**
    * @return name - name of the class
    */
	public String getName() {
		return this.name;
	}
	/**
    * @param name - name of the class
    */
	public void setName(String name) {
		this.name = name;
	}
	/**
    * @return instructor - return assigned trainer for the class
    */
	public Trainer getInstructor() {
		return this.instructor;
	}
	/**
    * @param t - instructor for the class
    */
	public void setInstructor(Trainer t) {
		this.instructor = t;
	}
	/**
    * @param c - customer who attends the class
    * @return success - boolean indicating whether the customer was successfully added to the list of attendees for the class
    */
	public boolean addAttendee(Customer c) {
		boolean success = false;
		if(this.getClassSize() < this.maxClassSize) {
			this.attendees.add(c);
			success = true;
		}
		return success;
	}
	/**
    * @param c - customer who attends the class
    * @return success - boolean indicating whether the customer was successfully removed from the list of attendees for the class
    */
	public boolean removeAttendee(Customer c) {
		boolean success = false;
		this.attendees.remove(c);
		if(!this.getAttendees().contains(c)) {
			success = true;
		}
		return success;
	}
	/**
	 * @return attendees - list of customers who are attending the gym class
	 */
	public ArrayList<Customer> getAttendees() {
		return this.attendees;
	}
	/**
	 * 
	 * @param s - class schedule
	 */
	public void setClassSchedule(Schedule s) {
		this.classSchedule = s;
	}
	/**
	 * 
	 * @return classSchedule - the schedule for the class
	 */
	public Schedule getClassSchedule() {
		return this.classSchedule;
	}
	/**
	 * 
	 * @return size of the list of customer who attend the class
	 */
	public Integer getClassSize() {
		return this.attendees.size();
	}
	/**
	 * 
	 * @return maxClassSize - maximum number of attendees for the class
	 */
	public Integer getMaxClassSize() {
		return this.maxClassSize;
	}
	/**
	 * 
	 * @param size - the maximum size the class can be
	 */
	public void setMaxClassSize(Integer size) {
		this.maxClassSize = size;
	}

	@Override
   public String toString() {
      return this.name + " Instructor: " + this.instructor.getPersonalInfo().getLastName() + ", " + this.instructor.getPersonalInfo().getFirstName() + " Size: " + this.getClassSize() + "Max Size: " + this.getMaxClassSize() + "\n" ;
   }
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((attendees == null) ? 0 : attendees.hashCode());
		result = prime * result + ((classSchedule == null) ? 0 : classSchedule.hashCode());
		result = prime * result + ((instructor == null) ? 0 : instructor.hashCode());
		result = prime * result + ((maxClassSize == null) ? 0 : maxClassSize.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FitnessClass other = (FitnessClass) obj;
		if (attendees == null) {
			if (other.attendees != null)
				return false;
		} else if (!attendees.equals(other.attendees))
			return false;
		if (classSchedule == null) {
			if (other.classSchedule != null)
				return false;
		} else if (!classSchedule.equals(other.classSchedule))
			return false;
		if (instructor == null) {
			if (other.instructor != null)
				return false;
		} else if (!instructor.equals(other.instructor))
			return false;
		if (maxClassSize == null) {
			if (other.maxClassSize != null)
				return false;
		} else if (!maxClassSize.equals(other.maxClassSize))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}	
	
}
