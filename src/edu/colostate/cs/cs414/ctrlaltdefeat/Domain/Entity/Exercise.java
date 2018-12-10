package edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Entity;

/**
 * Exercise for a Workout Routine
 *
 */
public class Exercise {

   private String name;          // name of the exercise
   private Integer numOfSets;    // number of sets
   private Integer numOfReps;    // number of repetitions
   private Equipment equipment;  // equipment used for exercise

   /**
    * @param name - name of the exercise
    * @param numOfReps - number of repetitions
    * @param numOfSets - number of sets
    * @param equipment - equipment used for exercise (null can be passed in)
    */
   public Exercise(String name, Integer numOfReps, Integer numOfSets, Equipment equipment) {
      this.name = name;
      this.numOfReps = numOfReps;
      this.numOfSets = numOfSets;
      this.equipment = equipment;
   }
   
   /**
    * @return name of the exercise
    */
   public String getName() {
      return name;
   }
   
   /**
    * @return number of sets
    */
   public Integer getNumOfSets() {
      return numOfSets;
   }
   
   /**
    * @param numOfSets - number of sets
    */
   public void setNumOfSets(Integer numOfSets) {
      this.numOfSets = numOfSets;
   }
   
   /**
    * @return number of repetitions
    */
   public Integer getNumOfReps() {
      return numOfReps;
   }

   /**
    * @param numOfReps - number of repetitions
    */
   public void setNumOfReps(Integer numOfReps) {
      this.numOfReps = numOfReps;
   }

   /**
    * @return equipment used for exercise
    */
   public Equipment getEquipment() {
      return equipment;
   }

   /**
    * @param equipment - equipment used for exercise
    */
   public void setEquipment(Equipment equipment) {
      this.equipment = equipment;
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((equipment == null) ? 0 : equipment.hashCode());
      result = prime * result + ((name == null) ? 0 : name.hashCode());
      result = prime * result + ((numOfReps == null) ? 0 : numOfReps.hashCode());
      result = prime * result + ((numOfSets == null) ? 0 : numOfSets.hashCode());
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
      Exercise other = (Exercise) obj;
      if (equipment == null) {
         if (other.equipment != null)
            return false;
      } else if (!equipment.equals(other.equipment))
         return false;
      if (name == null) {
         if (other.name != null)
            return false;
      } else if (!name.equals(other.name))
         return false;
      if (numOfReps == null) {
         if (other.numOfReps != null)
            return false;
      } else if (!numOfReps.equals(other.numOfReps))
         return false;
      if (numOfSets == null) {
         if (other.numOfSets != null)
            return false;
      } else if (!numOfSets.equals(other.numOfSets))
         return false;
      return true;
   }

   @Override
   public String toString() {
      // can handle null equipment
      String equipmentName = "None";
      if(equipment != null)
      {
         equipmentName = equipment.getName();
      }
      return "Exercise [Name=" + name + ", Sets=" + numOfSets + ", Reps=" + numOfReps + ", Equipment="
            + equipmentName + "]";
   }
}
