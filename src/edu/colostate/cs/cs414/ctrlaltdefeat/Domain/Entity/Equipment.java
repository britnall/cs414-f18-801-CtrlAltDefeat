package edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Entity;

import java.io.File;
import java.sql.Blob;

public class Equipment {
   
   private String name;
   private File picture;
   private Integer quantity;
   
   public Equipment(String name, File picture, Integer quantity) {
      this.name = name;
      this.picture = picture;
      this.quantity = quantity;
   }
   
   public String getName() {
      return name;
   }
   
   public File getPicture() {
      return picture;
   }
   
   public void setPicture(File picture) {
      this.picture = picture;
   }
   
   public Integer getQuantity() {
      return quantity;
   }
   
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

   public void setImageBlob(Blob imageBlob) {
      // TODO Auto-generated method stub
      
   }
   
}
