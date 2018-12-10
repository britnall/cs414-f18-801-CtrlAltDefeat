package edu.colostate.cs.cs414.ctrlaltdefeat.System;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.thoughtworks.xstream.persistence.FilePersistenceStrategy;
import com.thoughtworks.xstream.persistence.PersistenceStrategy;
import com.thoughtworks.xstream.persistence.XmlArrayList;

import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Entity.Equipment;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Entity.Exercise;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Entity.FitnessClass;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Entity.WorkoutRoutine;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.Customer;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.Employee;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.Manager;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.Trainer;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.User;

/**
 * Controller used to manipulate data and objects in the Gym Management system
 *
 */
public class GymSystemController {

   private static final GymSystemController instance = new GymSystemController();
   
   SystemDao dao;
   List list;
   
   /**
    * Sets up Gym Management System with a default user 
    * or use gym system from deserialization 
    */
   private GymSystemController(){
      
      // Use persistence XML serialization using XStream
      String path = Paths.get(".").toAbsolutePath().normalize().toString();
      PersistenceStrategy strategy = new FilePersistenceStrategy(new File(path));
      list = new XmlArrayList(strategy);
      if (list.isEmpty()) // Setup Gym System if it isn't already serialized
      {
         dao = SystemDao.getInstance();
         
         // Add default user
         User ui = new User("user", "password");
         Manager default_m = new Manager(ui, null);
         dao.addManager(default_m);
         
         list.add(dao);
      }
      else  // Use system from deserialized xml
      {
         dao = (SystemDao) list.get(1);
      }
   }
   
   /**
    * Singleton pattern so only 1 GymSystemController can be used
    * @return GymSystemController
    */
   public static GymSystemController getInstance(){ return instance; }
   
   /**
    * Writes the data to XML using XStream
    * 
    * This method is called any time anything in the system changes
    */
   private void storeData()
   {
      assert list.size() == 1;
      list.remove(0);
      list.add(dao);
   }
   
   /**
    * See if the login information is an employee in the system
    * @param username - username used for login
    * @param password - password used for login
    * @return Employee with login information
    */
   public Employee authenticateUser(String username, String password)
   {
      User login = new User(username, password);
      
      // Check managers for login information
      for(Manager m: getManagers())
      {
         if(m.getUserInfo().equals(login))
         {
            // Login provided is a manager
            return m;
         }
      }
      
      // Check trainers for login information
      for(Trainer t: getTrainers())
      {
         if(t.getUserInfo().equals(login))
         {
            // Login provided is a trainer
            return t;
         }
      }
      
      // No employee found with login information
      return null;
   }
   
   /**
    * Add a Manager to the system
    * @param manager - Manager to add
    * @return Indicates whether manager was added
    */
   public Response addManager(Manager manager){
      
      Response response = new Response();
      response.info = "Failed to add manager.";
      
      if(dao.addManager(manager)){
         response.successful = true;
         response.info = "Manager added successfully!";
         storeData();
      }
      
      return response;
   }
   
   /**
    * Add a Trainer to the system
    * @param trainer - Trainer to add
    * @return Indicates whether trainer was added
    */
   public Response addTrainer(Trainer trainer){
      
      Response response = new Response();
      response.info = "Failed to add trainer.";
      
      if(dao.addTrainer(trainer)){
         response.successful = true;
         response.info = "Trainer added successfully!";
         storeData();
      }
      
      return response;
   }
   
   /**
    * Add a Customer to the system
    * @param customer - Customer to add
    * @return Indicates whether customer was added
    */
   public Response addCustomer(Customer customer){
      
      Response response = new Response();
      response.info = "Failed to add customer.";
      
      if(dao.addCustomer(customer)){
         response.successful = true;
         response.info = "Customer added successfully!";
         storeData();
      }
      
      return response;
   }
   
   /**
    * Add Equipment to the system
    * @param equipment - equipment to add
    * @return Indicates whether equipment was added
    */
   public Response addEquipment(Equipment equipment){
      
      Response response = new Response();
      response.info = "Failed to add equipment.";
      
      if(dao.addEquipment(equipment)){
         response.successful = true;
         response.info = "Equipment added successfully!";
         storeData();
      }
      
      return response;    
   }

   /**
    * Add exercise to the system
    * @param exercise - exercise to add
    * @return Indicates whether exercise was added
    */
   public Response addExercise(Exercise exercise){
      
      Response response = new Response();
      response.info = "Failed to add exercise.";
      
      if(dao.addExercise(exercise)){
         response.successful = true;
         response.info = "Exercise added successfully!";
         storeData();
      }
      
      return response;     
   }
   
   /**
    * Add workout routine to the system
    * @param workout - workout routine to add
    * @return Indicates whether workout routine was added
    */
   public Response addWorkoutRoutine(WorkoutRoutine workout){
      
      Response response = new Response();
      response.info = "Failed to add workout routine.";
      
      if(dao.addWorkoutRoutine(workout)){
         response.successful = true;
         response.info = "Workout Routine added successfully!";
         storeData();
      }
      
      return response;     
   }
   
   /**
    * Remove a manager from the system
    * @param manager - manager to remove
    * @return Indicates whether manager was removed
    */
   public Response removeManager(Manager manager){
      
      Response response = new Response();
      response.info = "Failed to remove manager.";
      
      if(dao.deleteManager(manager)){
         response.successful = true;
         response.info = "Manager removed successfully!";
         storeData();
      }
      
      return response;
   }
   
   /**
    * Remove a trainer from the system
    * @param trainer - trainer to remove
    * @return Indicates whether trainer was removed
    */
   public Response removeTrainer(Trainer trainer){
      
      Response response = new Response();
      response.info = "Failed to remove trainer.";
      
      if(dao.deleteTrainer(trainer)){
         response.successful = true;
         response.info = "Trainer removed successfully!";
         storeData();
      }
      
      return response;
   }
   
   /**
    * Remove a customer from the system
    * @param customer - customer to remove
    * @return Indicates whether customer was removed
    */
   public Response removeCustomer(Customer customer){
      
      Response response = new Response();
      response.info = "Failed to remove customer.";
      
      if(dao.deleteCustomer(customer)){
         response.successful = true;
         response.info = "Customer removed successfully!";
         storeData();
      }
      
      return response;
   }
   
   /**
    * Remove an equipment from the system
    * @param equipment - equipment to remove
    * @return Indicates whether equipment was removed
    */
   public Response removeEquipment(Equipment equipment){
      
      Response response = new Response();
      response.info = "Failed to remove equipment.";
      
      if(dao.deleteEquipment(equipment)){
         response.successful = true;
         response.info = "Equipment removed successfully!";
         storeData();
      }
      
      return response;  
   }
   
   /**
    * Remove an exercise from the system
    * @param exercise - exercise to remove
    * @return Indicates whether exercise was removed
    */
   public Response removeExercise(Exercise exercise){
      
      Response response = new Response();
      response.info = "Failed to remove exercise.";
      
      if(dao.deleteExercise(exercise)){
         response.successful = true;
         response.info = "Exercise removed successfully!";
         storeData();
      }
      
      return response;  
   }
   
   /**
    * Remove a workout from the system
    * @param workout - workout to remove
    * @return Indicates whether workout was removed
    */
   public Response removeWorkoutRoutine(WorkoutRoutine workout){
      
      Response response = new Response();
      response.info = "Failed to remove workout routine.";
      
      if(dao.deleteWorkoutRoutine(workout)){
         response.successful = true;
         response.info = "Workout Routine removed successfully!";
         storeData();
      }
      
      return response;  
   }
   /**
    * Updates an existing manager on the system
    * @param old - the existing manager on the system
    * @param update - manager containing the updated info
    * @return indicates whether the manager was successfully updated
    */
   public Response updateManager(Manager old, Manager update)
   {
      Response response = new Response();
      response.info = "Failed to update manager.";
      
      if(update != null && dao.updateManager(old, update.getPersonalInfo(), update.getUserInfo()))
      {
         response.successful = true;
         response.info = "Manager information updated successfully!";
         storeData();
      }
      
      return response; 
   }
   /**
    * Updates an exiting trainer on the system
    * @param old - the existing trainer on the system
    * @param update - the trainer containing the updated information
    * @return indicates whether the trainer was successfully updated
    */
   public Response updateTrainer(Trainer old, Trainer update)
   {
      Response response = new Response();
      response.info = "Failed to update trainer.";
      
      if(update != null && dao.updateTrainer(old, update.getPersonalInfo(), update.getUserInfo()))
      {
         response.successful = true;
         response.info = "Trainer information updated successfully!";
         storeData();
      }
      
      return response; 
   }
   /**
    * Updates an existing customer on the system
    * @param old - the existing customer on the system
    * @param update - the customer with the updated information
    * @return indicates whether the customer was successfully updated
    */
   
   public Response updateCustomer(Customer old, Customer update)
   {
      Response response = new Response();
      response.info = "Failed to update customer.";
      
      if(update != null && dao.updateCustomer(old, update.getPersonalInfo(), update.getStatus(), 
            update.getWorkoutRoutines()))
      {
         response.successful = true;
         response.info = "Customer information updated successfully!";
         storeData();
      }
      
      return response; 
   }
   /**
    * Updates the existing equipment on the system
    * @param old - the existing the equipment on the system
    * @param update - the customer with the updated information
    * @return indicates whether the equipment was successfully updated
    */
   public Response updateEquipment(Equipment old, Equipment update)
   {
      Response response = new Response();
      response.info = "Failed to update equipment.";
      
      
      if(update != null && dao.updateEquipment(old, update.getPicture(), update.getQuantity())){
         response.successful = true;
         response.info = "Equipment information updated successfully!";
         storeData();
      }
      
      return response; 
   }
   /**
    * Adds an exercise to a routine
    * @param exercise - exercise to be added to a WorkoutRoutine
    * @param workoutRoutine - WorkoutRoutine to add the exercise to
    * @return indicates whether the exercise was successfully added to the WorkoutRoutine
    */
   public Response addExerciseToWorkout(Exercise exercise, WorkoutRoutine workoutRoutine){
      
      Response response = new Response();
      response.info = "Failed to add exercise to workout routine.";
      
      ArrayList<Exercise> exercises = workoutRoutine.getExercises();
      
      if(exercises.contains(exercise))
      {
         response.info = "Exercise already in workout routine.";
      }
      else
      {
         exercises.add(exercise);
         workoutRoutine.setExercises(exercises);
         
         response.successful = true;
         response.info = "Added Exercise to Workout Routine Successfully!";
         storeData();         
      }
      
      return response;
   }
   /**
    * Assigns a WorkoutRoutine to a customer
    * @param customer - customer to assign routine to
    * @param workoutRoutine - WorkoutRoutine to be assigned
    * @return Indicates whether the routine was susccessfully assigned to the customer
    */
   
   public Response assignWorkoutRoutine(Customer customer, WorkoutRoutine workoutRoutine){
      
      Response response = new Response();
      response.info = "Failed to assign workout routine.";
      
      customer.addRoutine(workoutRoutine);
      response.successful = true;
      response.info = "Assigned Workout Successfully!";
      storeData();

      return response;
   }
   /**
    * Unassigns a WorkoutRoutine from a customer
    * @param customer - customer to un-assign the workout routine from
    * @param workoutRoutineName - routine name to remove from the customer's list of routines
    * @return indicates whether the routine was successfully removed from teh customer
    */
   
   public Response unassignWorkoutRoutine(Customer customer, String workoutRoutineName){
      
      Response response = new Response();
      response.info = "Failed to unassign workout routine.";
      
      for(WorkoutRoutine wr: customer.getWorkoutRoutines())
      {
         if(wr.getName().equals(workoutRoutineName))
         {
            customer.removeRoutine(wr);
            response.successful = true;
            response.info = "Unassigned Workout successfully!";
            storeData();
         }
      }

      return response;    
   }
   /**
    * Searches for a specific user on the system
    * @param firstName - first name of the user to search for
    * @param lastName - last name of the user to search for 
    * @return the searched for user
    */
   
   public Employee searchUser(String firstName, String lastName)
   {
      return dao.searchUser(firstName, lastName);
   }
   /**
    * Searches for a specific customer by first & last name
    * @param firstName - first name of customer to search for
    * @param lastName - last name of customer to search for
    * @return searched for customer
    */
   
   public Customer searchCustomer(String firstName, String lastName)
   {
      return dao.searchCustomer(firstName, lastName);
   }
   /**
    * Searches for a specific equipment
    * @param name - name of the specific equipment to search for
    * @return searched equipment
    */
   
   public Equipment searchEquipment(String name)
   {
      return dao.searchEquipment(name);
   }
   /**
    * Searches for a specific exercise
    * @param name - name of the exercise to search for
    * @return searched exercise
    */
   
   public Exercise searchExercise(String name)
   {
      return dao.searchExercise(name);
   }
   /**
    * Searches for a specific workout-routine   
    * @param name - name of the WorkoutRoutine to find
    * @return searched WorkoutRoutine
    */
   public WorkoutRoutine searchWorkoutRoutine(String name)
   {
      return dao.searchWorkoutRoutine(name);
   }
   /**
    * Gets all the managers on the system
    * @return list of all managers on the system
    */

   public Set<Manager> getManagers(){ 
      return dao.getManagers();
   }
   /**
    * Gets all the Trainers on the system
    * @return list of all trainers on the system
    */
   
   public Set<Trainer> getTrainers(){     
      return dao.getTrainers();
   }
   /**
    * Gets all the customers on the system
    * @return list of all customers
    */
   public Set<Customer> getCustomers(){
      return dao.getCustomers();    
   }
   /**
    * Gets a list of all the equipment on the system
    * @return list of equipment on the system
    */
   public Set<Equipment> getEquipment(){      
      return dao.getEquipmentInventory();
   }
   /**
    * Gets all the exercises on the system
    * @return list of all the exercises on the system
    */
   
   public Set<Exercise> getExercises(){      
      return dao.getExercises();
   }
   /**
    * Gets all the workout routines on the system
    * @return list of all WorkoutRoutines on the system
    */
   public Set<WorkoutRoutine> getWorkoutRoutines(){      
      return dao.getWorkoutRoutines();
   }
   
   /**
    * Adds a gym class to the system
    * @param fc - the fitness class to add to the system
    * @return response - indicates whether or not the gym class was added to the system
    */
   public Response addGymClass(FitnessClass fc){
	      
	      Response response = new Response();
	      response.info = "Failed to add Gym Class.";
	      
	      if(dao.addFitnessClass(fc)){
	         response.successful = true;
	         response.info = "Gym Class added successfully!";
	         storeData();
	      }
	      
	      return response;
	      
   }
   /**
    * Removes a specified gym class from the system's list of gym classes
    * @param fc - the fitness class to remove
    * @return Indicates whether the gym class was successfully removed
    */
   public Response removeGymClass(FitnessClass fc){
	      
	      Response response = new Response();
	      response.info = "Failed to remove Gym Class.";
	      
	      if(dao.removeFitnessClass(fc)){
	         response.successful = true;
	         response.info = "Gym Class removed successfully!";
	         storeData();
	      }
	      
	      return response;
	      
	}
   /**
    * Searches for an existing gym class in the list of gym classes on the system
    * @param name
    * @return the gym class 
    */
   public FitnessClass searchGymClasses(String name)
   {
      return dao.searchFitnessClasses(name);
   }
   /**
    * Returns a list of all Gym class on the system
    * @return list of Gym classes 
    */
   public Set<FitnessClass> getGymClasses(){      
	    return dao.getGymClasses();
   }
   /**
    * Updates an existing fitness class
    * @param old - Fitness class the exists in the system
    * @return update - Fitness class that contains the updated information for the existing fitness class
    */
   public Response updateFitnessClass(FitnessClass old, FitnessClass update)
   {
      Response response = new Response();
      response.info = "Failed to update Fitness Class.";
      if(update != null && dao.updateFitnessClass(old, update.getName(), update.getInstructor(), update.getClassSchedule(), update.getClassSize(), update.getAttendees())){
         response.successful = true;
         response.info = "Fitness Class information updated successfully!";
         storeData();
      }
      
      return response; 
   }
}
