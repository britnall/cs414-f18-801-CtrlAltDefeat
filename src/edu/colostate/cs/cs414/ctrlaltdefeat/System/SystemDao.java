package edu.colostate.cs.cs414.ctrlaltdefeat.System;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Entity.Equipment;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Entity.Exercise;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Entity.FitnessClass;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Entity.WorkoutRoutine;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.Customer;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.Employee;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.Manager;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.Trainer;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.User;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.UserType;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.UserInfo.MembershipStatus;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.UserInfo.PersonalInformation;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.UserInfo.Schedule;

/**
 * Contains sets of all users and information in the Gym Management System
 * 
 * This object is serialized to XML using XStream
 */
public class SystemDao {
   Set<Employee> employees;
   Set<Customer> customers;
   Set<Equipment> equipmentInventory;
   Set<Exercise> exercises;
   Set<WorkoutRoutine> workouts;
   Set<FitnessClass> fitnessClasses;
   
   private static final SystemDao instance = new SystemDao();

   private SystemDao(){
      employees = new HashSet<Employee>();
      customers = new HashSet<Customer>();
      equipmentInventory = new HashSet<Equipment>(); 
      exercises = new HashSet<Exercise>(); 
      workouts = new HashSet<WorkoutRoutine>();
      fitnessClasses = new HashSet<FitnessClass>();
   }
   
   /**
    * Singleton pattern so only 1 SystemDao can be used
    * @return SystemDao
    */
   public static SystemDao getInstance(){
      return instance;
   }
   
   /**
    * Add a manager to the system
    * @param manager - manager to add
    * @return true if manager was added
    */
   public boolean addManager(Manager manager)
   {
      try {
         this.employees.add(manager);   
      }
      catch(Exception e) {
         return false;
      }
      return true;
   }
   
   /**
    * Update a manager in the system
    * @param manager - manager to update
    * @param pi - personal information to update
    * @param password - user password to update
    * @return true if manager was updated
    */
   public boolean updateManager(Manager manager, PersonalInformation pi, User password)
   {
      try {
         Manager update = (Manager) this.searchUser(manager.getPersonalInfo().getFirstName(), 
               manager.getPersonalInfo().getLastName()); 
         if(update != null)
         {
            update.updatePersonalInfo(pi);
            update.updatePassword(password);
            return true;
         }
         else
         {
            return false;
         }
         
      }
      catch(Exception e) {
         return false;
      }  
   }
   
   /**
    * Delete a manager from the system
    * @param manager - manager to remove
    * @return true if manager was removed
    */
   public boolean deleteManager(Manager manager){
      try {
         this.employees.remove(manager);     
      }
      catch(Exception e) {
         return false;
      }
      return true;
   }
   
   /**
    * Add a trainer to the system
    * @param trainer - trainer to add
    * @return true if trainer was added
    */
   public boolean addTrainer(Trainer trainer){
      try {
         this.employees.add(trainer);     
      }
      catch(Exception e) {
         return false;
      }
      return true;
   }
   
   /**
    * Update a trainer in the system
    * @param trainer - trainer to update
    * @param pi - personal information to update
    * @param password - user password to update
    * @return true if trainer was updated
    */
   public boolean updateTrainer(Trainer trainer, PersonalInformation pi, User password)
   {
      try {
         Trainer update = (Trainer) this.searchUser(trainer.getPersonalInfo().getFirstName(), 
               trainer.getPersonalInfo().getLastName());              
         if(update != null)
         {
            update.updatePersonalInfo(pi);
            update.updatePassword(password);
            return true;
         }
         else
         {
            return false;
         }
         
      }
      catch(Exception e) {
         return false;
      }  
   }
   
   /**
    * Delete a trainer from the system
    * @param trainer - trainer to remove
    * @return true if trainer was removed
    */  
   public boolean deleteTrainer(Trainer trainer){
      try {
         this.employees.remove(trainer);     
      }
      catch(Exception e) {
         return false;
      }
      return true;
   }
   
   /**
    * Add a customer to the system
    * @param customer - customer to add
    * @return true if customer was added
    */
   public boolean addCustomer(Customer customer){
      try {
         this.customers.add(customer);     
      }
      catch(Exception e) {
         return false;
      }
      return true;
   }
   
   /**
    * Update a customer in the system
    * @param customer - customer to update
    * @param pi - personal information to update
    * @param status - membership status to update
    * @param routines - workout routines to update
    * @return true if customer was updated
    */
   public boolean updateCustomer(Customer customer, PersonalInformation pi, 
         MembershipStatus status, Set<WorkoutRoutine> routines)
   {
      try {
         Customer update = this.searchCustomer(customer.getPersonalInfo().getFirstName(), 
               customer.getPersonalInfo().getLastName());
         if(update != null)
         {
            update.updatePersonalInfo(pi);
            update.setStatus(status);
            update.setWorkoutRoutines(routines);
            return true;
         }
         else
         {
            return false;
         }
         
      }
      catch(Exception e) {
         return false;
      }     
   }
   
   /**
    * Delete a customer from the system
    * @param customer - customer to remove
    * @return True if customer was removed
    */
   public boolean deleteCustomer(Customer customer){
      try {
         this.customers.remove(customer);     
      }
      catch(Exception e) {
         return false;
      }
      return true;
   }
   
   /**
    * Add equipment to the system
    * @param equipment - equipment to add
    * @return True if equipment was added
    */
   public boolean addEquipment(Equipment equipment){
      try {
         this.equipmentInventory.add(equipment);     
      }
      catch(Exception e) {
         return false;
      }
      return true;
      
   }
   
   /**
    * Update equipment in the system
    * @param equipment - equipment to update
    * @param picture - picture of equipment to update
    * @param quantity - quantity to update
    * @return True if the equipment was updated
    */
   public boolean updateEquipment(Equipment equipment, File picture, int quantity){
      try {
         Equipment update = this.searchEquipment(equipment.getName());
         if(update != null)
         {
            update.setPicture(picture);
            update.setQuantity(quantity);
            return true;
         }
         else {
            return false;
         }
            
      }
      catch(Exception e) {
         return false;
      }
   }
   
   /**
    * Delete a equipment in the system
    * @param equipment - equipment to remove
    * @return True if the equipment was removed
    */
   public boolean deleteEquipment(Equipment equipment){
      try {
         this.equipmentInventory.remove(equipment);     
      }
      catch(Exception e) {
         return false;
      }
      return true;
   }
   
   /**
    * Add an exercise to the system
    * @param exercise - exercise to add
    * @return True if the exercise was added
    */
   public boolean addExercise(Exercise exercise){
      try {
         this.exercises.add(exercise);     
      }
      catch(Exception e) {
         return false;
      }
      return true;
      
   }
   
   /**
    * Delete an exercise from the system
    * @param exercise - exercise to remove
    * @return True if the exercise was removed
    */
   public boolean deleteExercise(Exercise exercise){
      try {
         this.exercises.remove(exercise);     
      }
      catch(Exception e) {
         return false;
      }
      return true;
   }
   
   /**
    * Add workout routine to the system
    * @param workout - workout to add to the system
    * @return True if the workout routine was added 
    */
   public boolean addWorkoutRoutine(WorkoutRoutine workout){
      try {
         this.workouts.add(workout);     
      }
      catch(Exception e) {
         return false;
      }
      return true;
      
   }
   
   /**
    * Delete a workout routine from the system
    * @param workout - workout to be removed from the system
    * @return True if the workout routine was removed
    */
   public boolean deleteWorkoutRoutine(WorkoutRoutine workout){
      try {
         this.workouts.remove(workout);     
      }
      catch(Exception e) {
         return false;
      }
      return true;
   }
   
   /**
    * @return a list of managers in the system
    */
   public Set<Manager> getManagers() {
      Set<Manager> managers = new HashSet<Manager>();
      for(Employee e: this.employees)
      {
         if(e.getUserType() == UserType.MANAGER)
         {
            managers.add((Manager)e);
         }
      }
      return managers;
   }
   
   /**
    * @return a list of trainers in the system
    */
   public Set<Trainer> getTrainers(){
      Set<Trainer> trainers = new HashSet<Trainer>();
      for(Employee e: this.employees)
      {
         if(e.getUserType() == UserType.TRAINER)
         {
            trainers.add((Trainer)e);
         }
      }
      return trainers;
   }
   
   /**
    * @return a list of customers in the system
    */
   public Set<Customer> getCustomers(){
        return this.customers;
   }

   /**
    * @return a list of equipment in the system
    */
   public Set<Equipment> getEquipmentInventory() {
      return this.equipmentInventory;
   }
   
   /**
    * @return a list of exercises in the system
    */
   public Set<Exercise> getExercises()
   {
      return this.exercises;
   }
   
   /**
    * @return a list of workout routines in the system
    */
   public Set<WorkoutRoutine> getWorkoutRoutines()
   {
      return this.workouts;
   }
   
   /**
    * Search user by first and last name
    * @param firstName - first name to search by
    * @param lastName - last name to search by
    * @return Employee found or null if not found
    */
   public Employee searchUser(String firstName, String lastName)
   {
      for(Employee e: this.employees)
      {
         if(e.getPersonalInfo().getFirstName().toLowerCase().equals(firstName.toLowerCase()) && 
            e.getPersonalInfo().getLastName().toLowerCase().equals(lastName.toLowerCase()))
         {
            return e;
         }
      }
      
      return null;
   }
   
   /**
    * Search customer by first and last name
    * @param firstName - first name to search by
    * @param lastName - last name to search by
    * @return Customer found or null if not found
    */
   public Customer searchCustomer(String firstName, String lastName)
   {
      for(Customer c: this.customers)
      {
         if(c.getPersonalInfo().getFirstName().toLowerCase().equals(firstName.toLowerCase()) && 
               c.getPersonalInfo().getLastName().toLowerCase().equals(lastName.toLowerCase()))
         {
            return c;
         }
      }
      
      return null;
   }
   
   /**
    * Search equipment by name
    * @param name - name to search by
    * @return Equipment found or null if not found
    */
   public Equipment searchEquipment(String name)
   {
      for(Equipment e: this.equipmentInventory)
      {
         if(e.getName().toLowerCase().equals(name.toLowerCase())) {
            return e;
         }
      }
      return null;
   }
   
   /**
    * Search exercise by name
    * @param name - name to search by
    * @return Exercise found or null if not found
    */
   public Exercise searchExercise(String name)
   {
      for(Exercise e: this.exercises)
      {
         if(e.getName().toLowerCase().equals(name.toLowerCase())) {
            return e;
         }
      }
      return null;
   }
   
   /**
    * Search workout routine by name
    * @param name - name to search by
    * @return Workout routine found or null if not found
    */
   public WorkoutRoutine searchWorkoutRoutine(String name)
   {
      for(WorkoutRoutine w: this.workouts)
      {
         if(w.getName().toLowerCase().equals(name.toLowerCase())) {
            return w;
         }
      }
      return null;
   }
   /***Fitness Classes**/
   public boolean addFitnessClass(FitnessClass fitnessClass)
   {
      try {
         this.fitnessClasses.add(fitnessClass);     
      }
      catch(Exception e) {
         return false;
      }
      return true;
   }
   public boolean updateFitnessClass(FitnessClass fc, String name, Trainer t, Schedule s, Integer max, ArrayList<Customer> attendees){
      try {
    	  FitnessClass update = this.getFitnessClass(fc);
         if(update != null)
         {
            update.setName(name);
            update.setInstructor(t);
            update.setClassSchedule(s);
            for(Customer a: attendees) {
            	if(!update.getAttendees().contains(a)) {
            		update.addAttendee(a);
            	}
            }
            return true;
         }
         else {
            return false;
         }
            
      }
      catch(Exception e) {
         return false;
      }
   }
   public boolean removeFitnessClass(FitnessClass fitnessClass)
   {
      try {
         this.fitnessClasses.remove(fitnessClass);     
      }
      catch(Exception e) {
         return false;
      }
      return true;
   }
   public FitnessClass getFitnessClass(FitnessClass fc){
      for(FitnessClass c: this.fitnessClasses)
      {
         if(c.equals(fc))
         {
            return c;
         }
      }
      return null;
   }
   public FitnessClass searchFitnessClasses(String name)
   {
      for(FitnessClass fc: this.fitnessClasses)
      {
         if(fc.getName().toLowerCase().equals(name.toLowerCase())) {
            return fc;
         }
      }
      return null;
   }
   public Set<FitnessClass> getGymClasses() {
	   return this.fitnessClasses;
   }
}
