package edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Entity;

public class Exercise {

   private String name;
   private Integer numOfSets;
   private Integer numOfReps;
   private Equipment equipment;

   public Exercise(String name, Integer numOfReps, Integer numOfSets, Equipment equipment) {
      this.name = name;
      this.numOfReps = numOfReps;
      this.numOfSets = numOfSets;
      this.equipment = equipment;
   }
   
   public String getName() {
      return name;
   }
   public Integer getNumOfSets() {
      return numOfSets;
   }
   public void setNumOfSets(Integer numOfSets) {
      this.numOfSets = numOfSets;
   }
   
   public Integer getNumOfReps() {
      return numOfReps;
   }

   public void setNumOfReps(Integer numOfReps) {
      this.numOfReps = numOfReps;
   }

   public Equipment getEquipment() {
      return equipment;
   }

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
      return name + ", numOfSets: " + numOfSets + ", numOfReps: " + numOfReps + ", equipment: "
            + equipmentName +"\n";
   }
}
