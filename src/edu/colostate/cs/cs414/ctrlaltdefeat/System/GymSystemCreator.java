package edu.colostate.cs.cs414.ctrlaltdefeat.System;

import java.io.File;
import java.util.ArrayList;

import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Entity.Equipment;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Entity.Exercise;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Entity.FitnessClass;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Entity.WorkoutRoutine;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.Customer;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.Manager;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.Trainer;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.User;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.UserInfo.Address;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.UserInfo.PersonalInformation;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.UserInfo.Schedule;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.UserInfo.TimeOfDay;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.UserInfo.Weekday;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.UserInfo.WorkTime;

/**
 * Creator used to validate and create objects for the Gym Management system
 *
 */
public class GymSystemCreator {
   
   private static final GymSystemCreator instance = new GymSystemCreator();
   
   /**
    * Singleton pattern so only 1 GymSystemCreator can be used
    * @return GymSystemCreator
    */
   public static GymSystemCreator getInstance(){ return instance; }
   
   private GymSystemCreator()
   {}
   /**
    * Creates a new user on the system
    * @param userName - user name for the user on the system
    * @param password - password for the user on the system
    * @return u - the created user on the system
    */
   public User createUser(String userName, String password) {
      User u = null;
      if(userName != null && password != null)
      {
         if(!userName.equals("") && !password.equals(""))
         {
            u = new User(userName, password);           
         }
      }
      return u;      
   }
   /**
    * Creates an Address on the system
    * @param street
    * @param state
    * @param city
    * @param zipCode
    * @return a - the Address created on the system
    */
   
   public Address createAddress(String street, String state, String city, String zipCode)
   {
      Address a = null;
      if(street != null && state != null && city != null && zipCode != null)
      {
         if(!street.equals("") && !city.equals("") && 
               !state.equals("") && !zipCode.equals(""))
         {
            a = new Address(street, state, city, zipCode);
         }
      }      
      return a;
   }
   /**
    * Creates personal information on the system
    * @param firstName
    * @param lastName
    * @param email
    * @param phone
    * @param healthInsuranceProvider
    * @param address
    * @return pi - the created personal information
    */
   
   public PersonalInformation createPI(String firstName, String lastName, String email, String phone,
         String healthInsuranceProvider, Address address) 
   {
      PersonalInformation pi = null;
      if(firstName != null && lastName != null && email != null && phone != null && 
            healthInsuranceProvider != null && address != null)
      {
         if(!firstName.equals("")  && !lastName.equals("") && !email.equals("") && 
               !phone.equals("") && !healthInsuranceProvider.equals(""))
         {
            pi = new PersonalInformation(firstName, lastName, email, phone, healthInsuranceProvider, address);
         }
      }      
      return pi;
   }
   /**
    * Creates a Manager on the system
    * @param userInfo - the login information for the user
    * @param personalInfo - the personal information for the user
    * @return m - the created manager
    */
   
   public Manager createManager(User userInfo, PersonalInformation personalInfo)
   {
      Manager m = null;
      if(userInfo != null || personalInfo != null)
      {
         m = new Manager(userInfo, personalInfo);
      }
      
      return m;
   }
   /**
    * Creates a Trainer on the system
    * @param userInfo - the login information for the user
    * @param personalInfo - the personal information for the user
    * @return t - the created Trainer
    */

   public Trainer createTrainer(User userInfo, PersonalInformation personalInfo)
   {
      Trainer t = null;
      if(userInfo != null || personalInfo != null)
      {
         t = new Trainer(userInfo, personalInfo);
      }
      
      return t;
   }
   /** 
    * Creates a customer on the system
    * @param personalInfo - the personal information for the user
    * @return
    */
   public Customer createCustomer(PersonalInformation personalInfo)
   {
      Customer c = null;
      if(personalInfo != null)
      {
         c = new Customer(personalInfo);
      }
      
      return c;
   }
   /**
    * Creates a WorkTime on the system
    * @param start - the enumerated time of day indicating the start time
    * @param end - the enumerated time of day indicating the end time
    * @param day - the weekd day the worktime is on
    * @return
    */
   public WorkTime createWorkTime(TimeOfDay start, TimeOfDay end, Weekday day)
   {
      WorkTime wt = null;
      if(start != null && end != null && day != null)
      {
         // Validate that start time is before end time
         if(start.ordinal() < end.ordinal())
         {
            wt = new WorkTime(start, end, day);
         }        
      }
      
      return wt;
   }
   /**
    * Creates an Exercise on the system
    * @param name - name of the exercise
    * @param numOfRepsStr - number of repetitions
    * @param numOfSetsStr - number of sets
    * @param equipmentStr - the equipment to be used
    * @return e - the created exercise
    */
   
   public Exercise createExercise(String name, String numOfRepsStr, String numOfSetsStr, String equipmentStr)
   {
      Exercise e = null;
      if(name != null && numOfRepsStr != null && numOfSetsStr != null && equipmentStr != null)
      {
        int numOfReps = Integer.parseInt(numOfRepsStr);
        int numOfSets = Integer.parseInt(numOfSetsStr); 
        
        if(!name.equals(""))
        {       
           if(equipmentStr.equals(""))
           {
              Equipment eq = GymSystemController.getInstance().searchEquipment(equipmentStr);
              e = new Exercise(name, numOfReps, numOfSets, eq);
           }
           else
           {
              Equipment eq = GymSystemController.getInstance().searchEquipment(equipmentStr);
              if(eq != null)
              {
                 e = new Exercise(name, numOfReps, numOfSets, eq);
              }
           }
        }
      }
      
      return e;
   }
   /**
    * Creates a new Equipment object on the system
    * @param name - Equipment name
    * @param picturePath - path to the corresponding picture
    * @param quantityStr - quantity of the equipment in the gym's inventory
    * @return e - the created Equipment
    */
   
   public Equipment createEquipment(String name, String picturePath, String quantityStr)
   {
      Equipment e = null;

      if(name != null && picturePath != null && quantityStr != null)
      {
         File picture = new File(picturePath);
         
         if(!name.equals("") && !quantityStr.equals("") && picture.exists())
         {
            int quantity = Integer.parseInt(quantityStr);
            e = new Equipment(name, picture, quantity);
         }
      }
      
      return e;
   }
   /**
    * Creates a new WorkoutRoutine
    * @param name - name of the routine
    * @param exercise - the exercise to be used in the routine
    * @return wr - the created WorkoutRoutine
    */
   
   public WorkoutRoutine createWorkoutRoutine(String name, Exercise exercise)
   {
      WorkoutRoutine wr = null;
      if(name != null)
      {
         if(!name.equals(""))
         {
            ArrayList<Exercise> exercises = new ArrayList<>();
            exercises.add(exercise);
            wr = new WorkoutRoutine(name, exercises);
         }
      }
      
      return wr;
   }
   /**
    * Creates a new FitnessClass on the system
    * @param name - the name of the fitness class
    * @param t - the Instructor of the class
    * @param s - the class schedule
    * @param m - the maximum size of attendees allowed in the class
    * @return fc - the created FitnessClass
    */
   public FitnessClass createFitnessClass(String name, Trainer t, Schedule s, String m)
   {
	  FitnessClass fc = null;
	  
	  Integer max = Integer.parseInt(m);
      if(name != null && !name.equals("") && t != null && s != null && max > 0)
      {
    	  fc = new FitnessClass(name, t, s, max);
      }
      
      return fc;
   }
   
}
