package edu.colostate.cs.cs414.ctrlaltdefeat.Controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Entity.Equipment;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Entity.Exercise;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Entity.WorkoutRoutine;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.Customer;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.Manager;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.Trainer;

public class SystemDao {
   
   Set<Manager> managers;
   Set<Trainer> trainers;
   Set<Customer> customers;
   Set<Equipment> equipmentInventory;
   
   private static final SystemDao instance = new SystemDao();

   private SystemDao(){
      managers = new HashSet<Manager>();
      trainers = new HashSet<Trainer>();
      customers = new HashSet<Customer>();
      equipmentInventory = new HashSet<Equipment>();            
   }
   
   public static SystemDao getInstance(){
      return instance;
   }
   
   public boolean addManager(Manager manager)
   {
      try {
         this.managers.add(manager);     
      }
      catch(Exception e) {
         return false;
      }
      return true;
   }
   
   public boolean deleteManager(Manager manager){
      try {
         this.managers.remove(manager);     
      }
      catch(Exception e) {
         return false;
      }
      return true;
   }
   
   public boolean addTrainer(Trainer trainer){
      try {
         this.trainers.add(trainer);     
      }
      catch(Exception e) {
         return false;
      }
      return true;
   }
   
   public boolean deleteTrainer(Trainer trainer){
      try {
         this.trainers.remove(trainer);     
      }
      catch(Exception e) {
         return false;
      }
      return true;
   }
   
   public boolean addCustomer(Customer customer){
      try {
         this.customers.add(customer);     
      }
      catch(Exception e) {
         return false;
      }
      return true;
   }
   
   public boolean deleteCustomer(Customer customer){
      try {
         this.customers.remove(customer);     
      }
      catch(Exception e) {
         return false;
      }
      return true;
   }
   
   public boolean addEquipment(Equipment equipment){
      try {
         this.equipmentInventory.add(equipment);     
      }
      catch(Exception e) {
         return false;
      }
      return true;
      
   }
   
   public boolean deleteEquipment(Equipment equipment){
      try {
         this.equipmentInventory.remove(equipment);     
      }
      catch(Exception e) {
         return false;
      }
      return true;
   }
   
   public Set<Manager> getManagers() {
      return this.managers;
   }
   
   public Manager getManager(Manager manager) {
      for(Manager m: this.managers)
      {
         if(m.equals(manager))
         {
            return m;
         }
      }
      return null;
   }
   
   public Set<Trainer> getTrainers(){
      return this.trainers;
   }
   
   public Trainer getTrainer(Trainer trainer){
      for(Trainer t: this.trainers)
      {
         if(t.equals(trainer))
         {
            return t;
         }
      }
      return null;
   }
   
   public Set<Customer> getCustomers(){
        return this.customers;
   }

   public Customer getCustomer(Customer customer) {
      for(Customer c: this.customers)
      {
         if(c.equals(customer))
         {
            return c;
         }
      }
      return null;
   }

   public Set<Equipment> getEquipmentInventory() {
      return this.equipmentInventory;
   }

   public Equipment getEquipment(Equipment equipment) {
      for(Equipment e: this.equipmentInventory)
      {
         if(e.equals(equipment))
         {
            return e;
         }
      }
      return null;
   }
   
}
