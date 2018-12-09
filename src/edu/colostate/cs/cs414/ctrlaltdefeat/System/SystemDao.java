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
   
   public boolean deleteEquipment(Equipment equipment){
      try {
         this.equipmentInventory.remove(equipment);     
      }
      catch(Exception e) {
         return false;
      }
      return true;
   }
   
   public boolean addExercise(Exercise exercise){
      try {
         this.exercises.add(exercise);     
      }
      catch(Exception e) {
         return false;
      }
      return true;
      
   }
   
   public boolean deleteExercise(Exercise exercise){
      try {
         this.exercises.remove(exercise);     
      }
      catch(Exception e) {
         return false;
      }
      return true;
   }
   
   public boolean addWorkoutRoutine(WorkoutRoutine workout){
      try {
         this.workouts.add(workout);     
      }
      catch(Exception e) {
         return false;
      }
      return true;
      
   }
   
   public boolean deleteWorkoutRoutine(WorkoutRoutine workout){
      try {
         this.workouts.remove(workout);     
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
   
   public Set<Exercise> getExercises()
   {
      return this.exercises;
   }
   
   public Set<WorkoutRoutine> getWorkoutRoutines()
   {
      return this.workouts;
   }
   
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
