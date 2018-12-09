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
   
   public Response assignWorkoutRoutine(Customer customer, WorkoutRoutine workoutRoutine){
      
      Response response = new Response();
      response.info = "Failed to assign workout routine.";
      
      customer.addRoutine(workoutRoutine);
      response.successful = true;
      response.info = "Assigned Workout Successfully!";
      storeData();

      return response;
   }
   
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
   
   public Employee searchUser(String firstName, String lastName)
   {
      return dao.searchUser(firstName, lastName);
   }
   
   public Customer searchCustomer(String firstName, String lastName)
   {
      return dao.searchCustomer(firstName, lastName);
   }
   
   public Equipment searchEquipment(String name)
   {
      return dao.searchEquipment(name);
   }
   
   public Exercise searchExercise(String name)
   {
      return dao.searchExercise(name);
   }
   
   public WorkoutRoutine searchWorkoutRoutine(String name)
   {
      return dao.searchWorkoutRoutine(name);
   }

   public Set<Manager> getManagers(){ 
      return dao.getManagers();
   }
   
   public Set<Trainer> getTrainers(){     
      return dao.getTrainers();
   }
   
   public Set<Customer> getCustomers(){
      return dao.getCustomers();    
   }
   
   public Set<Equipment> getEquipment(){      
      return dao.getEquipmentInventory();
   }
   
   public Set<Exercise> getExercises(){      
      return dao.getExercises();
   }
   
   public Set<WorkoutRoutine> getWorkoutRoutines(){      
      return dao.getWorkoutRoutines();
   }
   /*** Fitness Classes ***/
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
   public FitnessClass searchGymClasses(String name)
   {
      return dao.searchFitnessClasses(name);
   }
   public Set<FitnessClass> getGymClasses(){      
	    return dao.getGymClasses();
   }
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
