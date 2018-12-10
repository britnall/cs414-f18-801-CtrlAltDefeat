package edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Entity;

import java.io.File;

/**
 * Equipment in the Gym
 *
 */
public class Equipment {
   
   private String name;       // name of the equipment
   private File picture;      // file of equipment picture
   private Integer quantity;  // quantity of equipment
   
   /**
    * Create Equipment
    * @param name - name of the equipment
    * @param picture - file of equipment picture 
    * @param quantity - quantity of equipment
    */
   public Equipment(String name, File picture, Integer quantity) {
      this.name = name;
      this.picture = picture;
      this.quantity = quantity;
   }
   
   
   /**
    * @return name of the equipment
    */
   public String getName() {
      return name;
   }
   
   /**
    * @return file of equipment picture
    */
   public File getPicture() {
      return picture;
   }
   
   /**
    * @param picture - file of equipment picture
    */
   public void setPicture(File picture) {
      this.picture = picture;
   }
   
   /**
    * @return quantity of equipment
    */
   public Integer getQuantity() {
      return quantity;
   }
   
   /**
    * @param quantity - quantity of equipment
    */
   public void setQuantity(Integer quantity) {
      this.quantity = quantity;
   }
   
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		Equipment other = (Equipment) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
   
}
