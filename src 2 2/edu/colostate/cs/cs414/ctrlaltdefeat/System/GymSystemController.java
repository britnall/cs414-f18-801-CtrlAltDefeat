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

public class GymSystemController {

   private static final GymSystemController instance = new GymSystemController();
   
   SystemDao dao;
   List list;
   
   private GymSystemController(){
      String path = Paths.get(".").toAbsolutePath().normalize().toString();
      PersistenceStrategy strategy = new FilePersistenceStrategy(new File(path));
      list = new XmlArrayList(strategy);
      if (list.isEmpty())
      {
    	 //list.remove(0);
         dao = SystemDao.getInstance();
         
         // Add default user Manager
         User ui = new User("user", "password");
         Manager default_m = new Manager(ui, null);
         dao.addManager(default_m);
         // Add default user Trainer
         User ui2 = new User("tester", "password");
         Manager default_t = new Manager(ui, null);
         dao.addManager(default_t);
         
         list.add(dao);
      }
      else
      {
         dao = (SystemDao) list.get(0);
         
      }
   }
   
   public static GymSystemController getInstance(){ return instance; }
   
   private void storeData()
   {
      assert list.size() == 1;
      list.remove(0);
      list.add(dao);
   }
   
   public Employee authenticateUser(String username, String password)
   {
      User login = new User(username, password);
      
      for(Trainer t: getTrainers())
      {
         if(t.getUserInfo().equals(login))
         {
            return t;
         }
      }
      
      for(Manager m: getManagers())
      {
         if(m.getUserInfo().equals(login))
         {
            return m;
         }
      }
      
      
      return null;
   }
   
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
   /**MVSMITH**11-20*/
   public Response addRoutine(WorkoutRoutine routine){
	      
	      Response response = new Response();
	      response.info = "Failed to add equipment.";
	      
	      if(dao.addRoutines(routine)){
	         response.successful = true;
	         response.info = "Equipment added successfully!";
	         storeData();
	      }
	      
	      return response;
	      
   }
   public Response addExercise(Exercise exercise){
	      
	      Response response = new Response();
	      response.info = "Failed to add Exercise.";
	      if(dao.addExercise(exercise)){
	         response.successful = true;
	         response.info = "Exercise added successfully!";
	         storeData();
	      }
	      return response;
	}
   
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

   public Response removeRoutine(WorkoutRoutine routine){
	      Response response = new Response();
	      response.info = "Failed to remove Exercise.";
	      if(dao.deleteRoutine(routine)){
	         response.successful = true;
	         response.info = "Exercise removed successfully!";
	         storeData();
	      }
	      return response;
	}
   public Response removeExercise(Exercise exercise){
	      Response response = new Response();
	      response.info = "Failed to remove Exercise.";
	      if(dao.removeExercise(exercise)){
	         response.successful = true;
	         response.info = "Exercise removed successfully!";
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
   public WorkoutRoutine searchRoutines(String name)
   {
      return dao.searchRoutines(name);
   }
   public FitnessClass searchGymClasses(String name)
   {
      return dao.searchFitnessClasses(name);
   }
  
   /**MVSMITH return equipment inventory**/
   public Set<Equipment> getEquipmentInventory()
   {
      return dao.equipmentInventory;
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
	    return dao.getGymExercises();
   }
   public Set<WorkoutRoutine> getRoutines(){      
	    return dao.getGymRoutines();
  }
   public Set<FitnessClass> getGymClasses(){      
	    return dao.getGymClasses();
 }
   
}
