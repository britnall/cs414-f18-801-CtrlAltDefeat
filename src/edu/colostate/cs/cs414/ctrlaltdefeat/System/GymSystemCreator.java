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
    * Create a User object
    * @param userName - username used for login
    * @param password - password used for login
    * @return User object or null if invalid
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
    * Create a Manager object
    * @param userInfo - user information for login
    * @param personalInfo - personal information
    * @return Manager object or null if invalid
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
    * Create a Trainer object
    * @param userInfo - user information for login
    * @param personalInfo - personal information
    * @return Trainer object or null if invalid
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
    * Create a Customer object
    * @param personalInfo - personal information
    * @return Customer object or null if invalid
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
    * Create a WorkTime object
    * @param start - time work shift start
    * @param end - time work shift ends
    * @param day - day of work shift
    * @return WorkTime object or null if invalid
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
    * Create an Exercise object
    * @param name - name of the exercise
    * @param numOfReps - number of repetitions
    * @param numOfSets - number of sets
    * @param equipment - equipment used for exercise (null can be passed in)
    * @return Exercise object or null if invalid
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
    * Create Equipment object
    * @param name - name of the equipment
    * @param picture - file of equipment picture 
    * @param quantity - quantity of equipment
    * @return Equipment object or null if invalid
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
    * Create a WorkoutRoutine object
    * @param name - name of workout routine
    * @param exercises - list of exercises
    * @return WorkoutRoutine object or null if invalid
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
