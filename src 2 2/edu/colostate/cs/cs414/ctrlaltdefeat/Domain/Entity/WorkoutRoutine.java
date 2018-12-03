
package edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Entity;

import java.util.ArrayList;

public class WorkoutRoutine {
   private String name;
   private ArrayList<Exercise> exercises;
   
   
   public WorkoutRoutine(String name) {
	      this.name = name;
	      this.exercises = new ArrayList<Exercise>();
	   } 
   public WorkoutRoutine(String name, ArrayList<Exercise> exercises) {
      this.name = name;
      this.exercises = exercises;
   }
   
   public String getName() {
      return name;
   }
   public void setName(String name) {
	      this.name =  name;
	   }

   public ArrayList<Exercise> getExercises() {
      return exercises;
   }
   
   public void setExercises(ArrayList<Exercise> exercises) {
      this.exercises = exercises;
   }


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((exercises == null) ? 0 : exercises.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		WorkoutRoutine other = (WorkoutRoutine) obj;
		if (exercises == null) {
			if (other.exercises != null)
				return false;
		} else if (!exercises.equals(other.exercises))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

   @Override
   public String toString() {
      return name + "\n";
   }
   
   
   
}
