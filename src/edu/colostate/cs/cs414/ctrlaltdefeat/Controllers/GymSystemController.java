package edu.colostate.cs.cs414.ctrlaltdefeat.Controllers;

import java.io.File;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;

import com.thoughtworks.xstream.persistence.FilePersistenceStrategy;
import com.thoughtworks.xstream.persistence.PersistenceStrategy;
import com.thoughtworks.xstream.persistence.XmlArrayList;

import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Entity.Equipment;
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
         dao = SystemDao.getInstance();
         
         // Add default user
         User ui = new User("user", "password");
         Manager default_m = new Manager(ui, null);
         dao.addManager(default_m);
         
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
      
      for(Manager m: getManagers())
      {
         if(m.getUserInfo().equals(login))
         {
            return m;
         }
      }
      
      for(Trainer t: getTrainers())
      {
         if(t.getUserInfo().equals(login))
         {
            return t;
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
   
   public Response updateManager(Manager old, Manager update)
   {
      Response response = new Response();
      response.info = "Failed to update manager.";
      
      if(dao.deleteManager(old) && dao.addManager(update)){
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
      
      if(dao.deleteTrainer(old) && dao.addTrainer(update)){
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
      
      if(dao.deleteCustomer(old) && dao.addCustomer(update)){
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
      
      if(dao.deleteEquipment(old) && dao.addEquipment(update)){
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
      for(Manager m: getManagers())
      {
         if(!m.getUserInfo().getUserName().equals("user") && 
               m.getPersonalInfo().getFirstName().toLowerCase().equals(firstName.toLowerCase()) && 
               m.getPersonalInfo().getLastName().toLowerCase().equals(lastName.toLowerCase()))
         {
            return m;
         }
      }
      
      for(Trainer t: getTrainers())
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
      for(Customer c: getCustomers())
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
      for(Equipment e: getEquipment())
      {
         if(e.getName().toLowerCase().equals(name.toLowerCase())) {
            return e;
         }
      }
      return null;
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
   
}
