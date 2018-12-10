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
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.UserInfo.MembershipStatus;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.UserInfo.PersonalInformation;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.UserInfo.Schedule;

/**
 * Contains sets of all users and information in the Gym Management System
 * 
 * This object is serialized to XML using XStream
 */
public class SystemDao {
   
   Set<Manager> managers;
   Set<Trainer> trainers;
   Set<Customer> customers;
   Set<Equipment> equipmentInventory;
   Set<Exercise> exercises;
   Set<WorkoutRoutine> workouts;
   Set<FitnessClass> fitnessClasses;
   
   private static final SystemDao instance = new SystemDao();

   private SystemDao(){
      managers = new HashSet<Manager>();
      trainers = new HashSet<Trainer>();
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
    * Adds a manager to the managers list on the system
    * @param manager - the manager to be added to the managers list
    * @return boolean indicating the success or failure of adding the manager to the system
    */
   
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
   /**
    * Updates a manager
    * @param manager - manager to be updated
    * @param pi - new personal info to update the manger with
    * @param password - new password for the manager
    * @return boolean indicating the success of updating the manager
    */
   public boolean updateManager(Manager manager, PersonalInformation pi, User password)
   {
      try {
         Manager update = this.getManager(manager);
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
    * Deletes a manager
    * @param manager - manager to be deleted
    * @return indicator of success of deleting the manager
    */
   public boolean deleteManager(Manager manager){
      try {
         this.managers.remove(manager);     
      }
      catch(Exception e) {
         return false;
      }
      return true;
   }
   /**
    * Adds a Trainer to the trainers list
    * @param trainer - trainer to be added
    * @return boolean indicator of success of adding the Trainer
    */
   public boolean addTrainer(Trainer trainer){
      try {
         this.trainers.add(trainer);     
      }
      catch(Exception e) {
         return false;
      }
      return true;
   }
   /**
    * Updates a Trainer
    * @param trainer - Trainer to be updated
    * @param pi - new personal information for the Trainer
    * @param password - new password for the Trainer
    * @return boolean indicator of the success of updating the Trainer
    */
   public boolean updateTrainer(Trainer trainer, PersonalInformation pi, User password)
   {
      try {
         Trainer update = this.getTrainer(trainer);
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
    * Deletes a Trainer
    * @param trainer - Trainer to be deleted
    * @return boolean indicator of success
    */
   
   public boolean deleteTrainer(Trainer trainer){
      try {
         this.trainers.remove(trainer);     
      }
      catch(Exception e) {
         return false;
      }
      return true;
   }
   /**
    * Adds a Customer to the Gym's Customers list
    * @param customer - customer to be added
    * @return boolean indicator of success
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
    * Updates a Customer
    * @param customer - Customer to be updated
    * @param pi - new personal information for the customer
    * @param status - new status for the customer
    * @param routines - new routines for the Customer
    * @return boolean indicator of success
    */
   
   public boolean updateCustomer(Customer customer, PersonalInformation pi, 
         MembershipStatus status, Set<WorkoutRoutine> routines)
   {
      try {
         Customer update = this.getCustomer(customer);
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
    * Deletes a Customer from the gym system
    * @param customer - Customer to be deleted
    * @return boolean indicator of success
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
    * Adds Equipment to the Gym's equipment inventory 
    * @param equipment - equipment to be added
    * @return boolean indicator of success
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
    * Updates Equipment on the system
    * @param equipment - equipment to be updated
    * @param picture - associated picture for the equipment
    * @param quantity - quantity of the equipment in the Gym inventory
    * @return boolean indicator of success
    */
   public boolean updateEquipment(Equipment equipment, File picture, int quantity){
      try {
         Equipment update = this.getEquipment(equipment);
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
    * Deletes Equipment from the system
    * @param equipment - the equipment to be deleted
    * @return boolean indicator of success
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
    * Adds an exercise to the system
    * @param exercise - the exercise to be added
    * @return boolean indicator of success
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
    * Deletes the Exercise from the system
    * @param exercise - exercise to be removed
    * @return boolean indicator of succcess
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
    * Add WorkoutRoutine to the system
    * @param workout - WorkoutRoutine to be added
    * @return boolean indicator of success
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
    * Deletes WorkoutRoutine from the system
    * @param workout - Routine to be deleted
    * @return boolean indicator of success
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
    * Gets a list of all managers on the system
    * @return list of all managers 
    */
   public Set<Manager> getManagers() {
      return this.managers;
   }
   /**
    * Searches for a specific Manager 
    * @param manager - Manager to be searched for
    * @return m- manager to be returned or null if not found
    */
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
   /**
    * Gets list of all Trainers on the system
    * @return list of all Trainers
    */
   
   public Set<Trainer> getTrainers(){
      return this.trainers;
   }
   /**
    * Searches for a specific Trainer
    * @param trainer - trainer to to be found
    * @return t - searched for Trainer or null if not found
    */
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
   /**
    * Gets all customers on the system
    * @return list of all Customers
    */
   public Set<Customer> getCustomers(){
        return this.customers;
   }
	/**
	 * Returns a specific Customer
	 * @param customer - Customer to be searched for
	 * @return c - searched for Customer or null if not found
	 */
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
   /**
    * Gets all Equipment on the system
    * @return list of the Gym's equipment
    */

   public Set<Equipment> getEquipmentInventory() {
      return this.equipmentInventory;
   }
	/**
	 * Searches for a specific equipment
	 * @param equipment - equipment to be searched
	 * @return e - the searched for Equipment or null if not found
	 */
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
   /**
    * Gets all exercise on the system
    * @return list of all exercises 
    */
   public Set<Exercise> getExercises()
   {
      return this.exercises;
   }
   /**
    * Gets all WorkoutRoutines on the system
    * @return list of all WorkoutRoutines
    */
   
   public Set<WorkoutRoutine> getWorkoutRoutines()
   {
      return this.workouts;
   }
   /**
    * Searches for a specific User by first and last name
    * @param firstName - first name of the user to be searched for
    * @param lastName - last name of the user to be searched for
    * @return m - if the searched for user is a Manager, t - if the searched for user is a Trainer, and null if the user is not found
    */
   public Employee searchUser(String firstName, String lastName)
   {
      for(Manager m: this.managers)
      {
         if(!m.getUserInfo().getUserName().equals("user") && 
               m.getPersonalInfo().getFirstName().toLowerCase().equals(firstName.toLowerCase()) && 
               m.getPersonalInfo().getLastName().toLowerCase().equals(lastName.toLowerCase()))
         {
            return m;
         }
      }
      
      for(Trainer t: this.trainers)
      {
         if(t.getPersonalInfo().getFirstName().toLowerCase().equals(firstName.toLowerCase()) && 
               t.getPersonalInfo().getLastName().toLowerCase().equals(lastName.toLowerCase()))
         {
            return t;
         }
      }
      
      return null;
   }
   /**
    * Customer to be searched
    * @param firstName - first name of the Customer to be searched
    * @param lastName - last name of the Customer to be searched
    * @return c - the found Customer or null if not found
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
    * Searches for a specific Equipment in the Gym's Inventory
    * @param name - name of the Equipment to be searched for
    * @return e - Equipment if the equipment is found, null if not found
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
    * Searches for a specific exercise
    * @param name - name of exercise to be searched for
    * @return e - the found exercise, or null if not found
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
    * Searches for a specific WorkoutRoutine
    * @param name - name of the routine to be searched for
    * @return w - the found WorkoutRoutine or null if not found
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
   /**
    * Adds a FitnessClass to the system
    * @param fitnessClass - the Fitness Class to be added
    * @return boolean indicator of success
    */
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
   /**
    * Updates a FitnessClass on the system
    * @param fc - FitnessClass to be updated
    * @param name - updated name
    * @param t - updated Trainer
    * @param s - updated Schedule
    * @param max - updated max class size
    * @param attendees - updated list of attendees
    * @return Boolean indicator of Success
    */
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
   /**
    * Removes a Fitness Class from the system
    * @param fitnessClass - Fitness Class to be removed
    * @return boolean indicator of success
    */
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
   /**
    * Gets a specific Fitness Class on the system
    * @param fc - fitness class to be searched for
    * @return c - if the class is found or null if not found
    */
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
   /**
    * Searches for a specific Fitness Class by name
    * @param name - name of the class to be searched
    * @return fc - if the Fitness Class is found null if not found
    */
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
   /**
    * Gets all the Fitness class on the system
    * @return list of all Fitness Classes
    */
   public Set<FitnessClass> getGymClasses() {
	   return this.fitnessClasses;
   }
}
