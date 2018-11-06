package edu.colostate.cs.cs414.ctrlaltdefeat.System;

import java.io.File;
import java.util.ArrayList;

import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Entity.Equipment;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Entity.Exercise;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Entity.WorkoutRoutine;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.Customer;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.Manager;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.Trainer;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.User;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.UserInfo.Address;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.UserInfo.PersonalInformation;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.UserInfo.Weekday;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.UserInfo.WorkTime;

public class GymSystemCreator {
   
   private static final GymSystemCreator instance = new GymSystemCreator();
   
   public static GymSystemCreator getInstance(){ return instance; }
   
   private GymSystemCreator()
   {
      
   }
   
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
   
   public Manager createManager(User userInfo, PersonalInformation personalInfo)
   {
      Manager m = null;
      if(userInfo != null || personalInfo != null)
      {
         m = new Manager(userInfo, personalInfo);
      }
      
      return m;
   }

   public Trainer createTrainer(User userInfo, PersonalInformation personalInfo)
   {
      Trainer t = null;
      if(userInfo != null || personalInfo != null)
      {
         t = new Trainer(userInfo, personalInfo);
      }
      
      return t;
   }
   
   public Customer createCustomer(PersonalInformation personalInfo)
   {
      Customer c = null;
      if(personalInfo != null)
      {
         c = new Customer(personalInfo);
      }
      
      return c;
   }
   
   public WorkTime createWorkTime(String start, String end, Weekday day)
   {
      WorkTime wt = null;
      if(start != null && end != null && day != null)
      {
         if(!start.equals("") && !end.equals(""))
         {
            wt = new WorkTime(start, end, day);
         }
      }
      
      return wt;
   }
   
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
   
   public WorkoutRoutine createWorkoutRoutine(String name, ArrayList<Exercise> exercises)
   {
      WorkoutRoutine wr = null;
      if(name != null && exercises != null)
      {
         if(!name.equals(""))
         {
            wr = new WorkoutRoutine(name, exercises);
         }
      }
      
      return wr;
   }
   
}
