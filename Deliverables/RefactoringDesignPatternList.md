# Design Patterns
The original implementation of the system used the Singleton, Creator, and Controller patterns so there was not much refactoring done in the second iteration. 
The code was also organized into packages that seperated the System classes from the Domain classes.

### Singleton Pattern
The singleton pattern was used in the GymSystemCreator, GymSystemController, and SystemDao classes to make sure that only one object could be created and used from the user interface.

### Creator GRASP Pattern
The creator pattern was used in the GymSystemCreator class so that inputs from the user interface can be evaluated in a common place rather than in the user inteface code. 
This made it clear what the expectations were when creating objects in the gym management system.

### Controller GRASP Pattern
The controller pattern was used in the GymSystemController class so the user interface didnt directly manipulate the system data access object.
This kept common functionality explicity defined in the Controller class instead of cluttering the user interface code. The controller was also responsible for serializing the system to XML using XStream whenever the data changed.

### SystemDao
Since data persistance was implemented using XStream, it was easiest to serialize an entire object to XML rather than bits of the system. 
The SystemDao object was designed to be the object that contained lists of all the different data objects in the system and represent the entire system as a whole.



# Refactoring
The implementation was changed so the exercises and workout routines were now stored as part of the SystemDao rather than only allowing them to be stored in the Customer object.
This allowed exercises and workout routines to be assigned to different customers. Most of the refactoring was done in the user interface code rather than in the system code. The user interface was modified to add this capibility. Methods to add, search, remove, and get exercises and workout routines were also added to the GymSystemController, GymSystemCreator, and SystemDao classes for this functionality to be implemented.

The system and domain classes were also cleaned up to remove methods that were not used and did not provide value to the system. 
There was also some validation added to the system that was not initially implemented, for example, the start and end times for a trainers schedule.
