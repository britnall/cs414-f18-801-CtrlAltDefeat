package edu.colostate.cs.cs414.ctrlaltdefeat.UI;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Entity.Equipment;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Entity.Exercise;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Entity.FitnessClass;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Entity.WorkoutRoutine;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.Customer;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.Employee;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.Manager;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.Trainer;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.User;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.UserType;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.UserInfo.Address;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.UserInfo.MembershipStatus;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.UserInfo.PersonalInformation;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.UserInfo.Schedule;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.UserInfo.Weekday;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.UserInfo.WorkTime;
import edu.colostate.cs.cs414.ctrlaltdefeat.System.GymSystemController;
import edu.colostate.cs.cs414.ctrlaltdefeat.System.GymSystemCreator;
import edu.colostate.cs.cs414.ctrlaltdefeat.System.Response;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollBar;
import javax.swing.ImageIcon;

public class GymSystemUI {

   Employee currentUser = null;
   Employee employeeSearched = null;
   Customer customerSearched = null;
   Equipment equipmentSearched = null;
   FitnessClass searchedClass = null;
   ArrayList<JTextField> userInfoTextFields = new ArrayList<JTextField>();
   ArrayList<JTextField> allTextFields = new ArrayList<JTextField>();
   ArrayList<Exercise> newExercises = new ArrayList<Exercise>();
   UserType newEmployeeType = null;
   String action = "";
   Schedule createdSchedule = null;
   Schedule classSchedule = null;

   private JFrame frame;
   private JPanel contentPane;
   private JPanel LoginPanel;
   private JPanel mainMenuPanel;
   private JPanel ManagerMenu;
   private JPanel TrainerMenu;
   private JPanel addEmployeePanel;
   private JPanel addEquipmentPanel;
   private JPanel createWorkoutPanel;
   private JPanel assignRoutinesPanel;
   private JPanel loginInfoPanel;
   private JPanel searchPanel;
   private JPanel searchEquipPanel;
   private JPanel classesPanel;
   
   private JTextField loginUsername;
   private JTextField loginPassword;
   private JTextField equipmentName;
   private JTextField equipmentQuantity;
   private JTextField eqPicturePath;
   private JTextField uSearchFirstName;
   private JTextField exerciseNamefield;
   private JTextField numReps;
   private JTextField numSets;
   private JTextField workoutName;
   private JTextField exSearchFName;
   private JTextField exSearchLName;
   private JTextField uSearchLastName;
   private JTextField startTime;
   private JTextField endTime;
   private JTextField classAttendeesField;
   private JTextField classNameField;
   private JTextField maxClassSizeField;
   private JTextField classStartTextField;
   private JTextField classEndField;
   
   private JTextArea txtListGymRoutines;
   private JTextArea txtDisplayCustomerInfo;
   private JTextArea exercisesInRoutine;
   private JTextArea txtDisplayScheduleHere;
   private JTextArea classTimesField;
   private JTextArea classScheculetextArea;
   
   private JComboBox eInventoryComboBox;
   private JComboBox exercisesListComboBox;
   private JComboBox customersComboBox;
   private JComboBox ClassListComboBox;
   private JComboBox trainersComboBox;
   private JComboBox classWeekday;
   
   private JLabel lblpicDisplay;
   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               GymSystemUI frame = new GymSystemUI();
               frame.getFrame().setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   void clearTextFields() {
      // clear fields
      for (JTextField tf : allTextFields) {
         tf.setText("");
      }
   }

   public GymSystemUI() {
      setFrame(new JFrame());
      getFrame().setBounds(100, 100, 649, 476);
      getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      getFrame().getContentPane().setLayout(null);

      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      frame.setContentPane(contentPane);
      contentPane.setLayout(new CardLayout(0, 0));

      // Login Panel
      LoginPanel = new JPanel();
      LoginPanel.setLayout(null);
      contentPane.add(LoginPanel, BorderLayout.CENTER);
      JLabel lblUsername = new JLabel("Username:");
      lblUsername.setBounds(192, 167, 66, 16);
      JLabel lblPassword = new JLabel("Password:");
      lblPassword.setBounds(195, 195, 63, 16);
      LoginPanel.setLayout(null);
      JLabel lblLoginToGym = new JLabel("Login To Gym System");
      lblLoginToGym.setFont(new Font("Lucida Grande", Font.BOLD, 22));
      lblLoginToGym.setBounds(193, 98, 252, 40);
      LoginPanel.add(lblLoginToGym);
      LoginPanel.add(lblUsername);
      LoginPanel.add(lblPassword);
      loginUsername = new JTextField();
      loginUsername.setBounds(270, 162, 168, 26);
      loginUsername.setColumns(10);
      loginPassword = new JTextField();
      loginPassword.setBounds(270, 190, 168, 26);
      loginPassword.setColumns(10);
      LoginPanel.add(loginUsername);
      LoginPanel.add(loginPassword);

      // Main Menu Panel
      mainMenuPanel = new JPanel();
      contentPane.add(mainMenuPanel, "name_49214182129467");
      mainMenuPanel.setLayout(null);
      mainMenuPanel.setVisible(false);
      									
                                          
                                          JPanel currUserClassesPanel = new JPanel();
                                          currUserClassesPanel.setBounds(0, 71, 639, 367);
                                          mainMenuPanel.add(currUserClassesPanel);
                                          currUserClassesPanel.setLayout(null);
                                          
                                          JLabel lblAssignedClasses = new JLabel("Assigned Classes");
                                          lblAssignedClasses.setBounds(257, 19, 120, 16);
                                          currUserClassesPanel.add(lblAssignedClasses);
                                          
                                          JComboBox assignedClassesComboBox = new JComboBox();
                                          assignedClassesComboBox.addActionListener(new ActionListener() {
                                          	public void actionPerformed(ActionEvent e) {
                                          		if(!assignedClassesComboBox.getSelectedItem().equals("")) {
                                          			FitnessClass fClass = GymSystemController.getInstance().searchGymClasses(assignedClassesComboBox.getSelectedItem().toString());
                                          			classScheculetextArea.setText(fClass.getClassSchedule().toString());
                                          		}
                                          	}
                                          });
                                          assignedClassesComboBox.addItem("");
                                          if(GymSystemController.getInstance().getGymClasses()!=null) {// && currentUser.getUserType().equals(UserType.TRAINER)) {
                                        	  for(FitnessClass fc: GymSystemController.getInstance().getGymClasses()) {
                                        		  if(fc.getInstructor().equals(currentUser)) {
                                        			  assignedClassesComboBox.addItem(fc.getName());
                                        		  }
                                        	  }
                                          }
                                          assignedClassesComboBox.setBounds(257, 58, 120, 27);
                                          currUserClassesPanel.add(assignedClassesComboBox);
                                          
                                          classScheculetextArea = new JTextArea();
                                          classScheculetextArea.setBounds(188, 137, 261, 191);
                                          currUserClassesPanel.add(classScheculetextArea);
                                    
                                          createWorkoutPanel = new JPanel();
                                          createWorkoutPanel.setBounds(0, 53, 639, 391);
                                          mainMenuPanel.add(createWorkoutPanel);
                                          createWorkoutPanel.setLayout(null);
                                          
                                                JLabel lblExerciseName = new JLabel("Exercise Name:");
                                                lblExerciseName.setBounds(6, 211, 96, 16);
                                                createWorkoutPanel.add(lblExerciseName);
                                                
                                                      JLabel lblNumReps = new JLabel("Number of Repititions:");
                                                      lblNumReps.setBounds(6, 275, 169, 16);
                                                      createWorkoutPanel.add(lblNumReps);
                                                      
                                                            JLabel lblNumSets = new JLabel("Number of Sets:");
                                                            lblNumSets.setBounds(6, 247, 149, 16);
                                                            createWorkoutPanel.add(lblNumSets);
                                                            
                                                                  exerciseNamefield = new JTextField();
                                                                  exerciseNamefield.setBounds(167, 206, 138, 26);
                                                                  exerciseNamefield.setColumns(10);
                                                                  createWorkoutPanel.add(exerciseNamefield);
                                                                  allTextFields.add(exerciseNamefield);
                                                                  
                                                                        numReps = new JTextField();
                                                                        numReps.setBounds(167, 270, 138, 26);
                                                                        numReps.setColumns(10);
                                                                        createWorkoutPanel.add(numReps);
                                                                        allTextFields.add(numReps);
                                                                        
                                                                              numSets = new JTextField();
                                                                              numSets.setBounds(167, 242, 138, 26);
                                                                              numSets.setColumns(10);
                                                                              createWorkoutPanel.add(numSets);
                                                                              allTextFields.add(numSets);
                                                                              
                                                                                    workoutName = new JTextField();
                                                                                    workoutName.setBounds(175, 67, 130, 26);
                                                                                    createWorkoutPanel.add(workoutName);
                                                                                    workoutName.setColumns(10);
                                                                                    allTextFields.add(workoutName);
                                                                                    
                                                                                          JButton btnAddToWorkout = new JButton("Add to Workout Routine");
                                                                                          btnAddToWorkout.setBounds(380, 223, 195, 29);
                                                                                          btnAddToWorkout.addActionListener(new ActionListener() {
                                                                                             public void actionPerformed(ActionEvent e) {
                                                                                          	  WorkoutRoutine wr = GymSystemController.getInstance().searchRoutines(workoutName.getText());
                                                                                                Exercise ex = GymSystemController.getInstance().searchExercise(exerciseNamefield.getText());
                                                                                                if(wr!=null)
                                                                                                {
                                                                                                   if(ex!=null) {
                                                                                                  	 wr.getExercises().add(ex);
                                                                                                  	 String temp = "";
                                                                                                  	 for(Exercise exercise : wr.getExercises()) {
                                                                                                  		 temp+=exercise.toString();
                                                                                                  	 }
                                                                                                  	exercisesInRoutine.setText(temp);
                                                                                                  	 
                                                                                                   }
                                                                                                   else {
                                                                                                  	 JOptionPane.showMessageDialog(mainMenuPanel, "Exercise does not exist in the system.");
                                                                                                   }
                                                                                                } 
                                                                                                else {
                                                                                              	  JOptionPane.showMessageDialog(mainMenuPanel, "Workout Routine does not exist in the system.");
                                                                                                }
                                                                                             }
                                                                                          });
                                                                                          createWorkoutPanel.add(btnAddToWorkout);
                                                                                          
                                                                                                JLabel lblWorkoutRoutineName = new JLabel("Workout Routine Name:");
                                                                                                lblWorkoutRoutineName.setBounds(6, 72, 149, 16);
                                                                                                createWorkoutPanel.add(lblWorkoutRoutineName);
                                                                                                
                                                                                                      JLabel lblEquipment = new JLabel("Equipment:");
                                                                                                      lblEquipment.setBounds(6, 306, 149, 16);
                                                                                                      createWorkoutPanel.add(lblEquipment);
                                                                                                      
                                                                                                            JButton btnSave_1 = new JButton("Done");
                                                                                                            btnSave_1.addActionListener(new ActionListener() {
                                                                                                               public void actionPerformed(ActionEvent e) {
                                                                                                                  createWorkoutPanel.setVisible(false);
                                                                                                                  TrainerMenu.setVisible(true);
                                                                                                                  clearTextFields();
                                                                                                                  txtDisplayCustomerInfo.setText("");
                                                                                                                  txtListGymRoutines.setText("");
                                                                                                               }
                                                                                                            });
                                                                                                            btnSave_1.setBounds(423, 341, 117, 29);
                                                                                                            createWorkoutPanel.add(btnSave_1);
                                                                                                            
                                                                                                            eInventoryComboBox = new JComboBox();
                                                                                                            eInventoryComboBox.setBounds(167, 302, 138, 27);
                                                                                                            createWorkoutPanel.add(eInventoryComboBox);
                                                                                                            
                                                                                                            JComboBox gymRoutinesCombobox = new JComboBox();
                                                                                                            gymRoutinesCombobox.addActionListener(new ActionListener() {
                                                                                                            	public void actionPerformed(ActionEvent e) {
                                                                                                            		WorkoutRoutine routine = GymSystemController.getInstance().searchRoutines(gymRoutinesCombobox.getSelectedItem().toString());
                                                                                                            		if(routine != null) {
	                                                                                                            		workoutName.setText(routine.getName());
	                                                                                                            		String exerciseList = "";
	                                                                                                            		for(Exercise ex: routine.getExercises()) {
	                                                                                                            			exerciseList += ex.toString();
	                                                                                                            		}
	                                                                                                            		exercisesInRoutine.setText(exerciseList);
                                                                                                            		}
                                                                                                            	}
                                                                                                            });
                                                                                                            gymRoutinesCombobox.setBounds(156, 20, 149, 27);
                                                                                                            gymRoutinesCombobox.addItem("");
                                                                                                            createWorkoutPanel.add(gymRoutinesCombobox);
                                                                                                            
                                                                                                            JLabel lblWorkoutRoutines = new JLabel("Workout Routines");
                                                                                                            lblWorkoutRoutines.setBounds(6, 24, 127, 16);
                                                                                                            createWorkoutPanel.add(lblWorkoutRoutines);
                                                                                                            
                                                                                                            JLabel lblExercises = new JLabel("Exercises:");
                                                                                                            lblExercises.setBounds(16, 171, 96, 16);
                                                                                                            createWorkoutPanel.add(lblExercises);
                                                                                                            
                                                                                                            exercisesListComboBox = new JComboBox();
                                                                                                            exercisesListComboBox.addItem("");
                                                                                                            exercisesListComboBox.addActionListener(new ActionListener() {
                                                                                                            	public void actionPerformed(ActionEvent e) {
	                                                                                                            	if(!exercisesListComboBox.getSelectedItem().toString().equals("")) {
	                                                                                                            		Exercise ex = GymSystemController.getInstance().searchExercise(exercisesListComboBox.getSelectedItem().toString());
	                                                                                                            		if(ex != null) {
		                                                                                                            		exerciseNamefield.setText(ex.getName());
		                                                                                                            		numReps.setText(ex.getNumOfReps().toString());
		                                                                                                            		numSets.setText(ex.getNumOfSets().toString());
		                                                                                                            		eInventoryComboBox.setSelectedItem(ex.getEquipment().getName());
	                                                                                                            		}
	                                                                                                            		else {
	                                                                                                            			JOptionPane.showMessageDialog(mainMenuPanel, "Exercise does not exist in the system.");
	                                                                                                            		}
	                                                                                                            	}
	                                                                                                            	else {
	                                                                                                            		exerciseNamefield.setText("");
	                                                                                                            		numReps.setText("");
	                                                                                                            		numSets.setText("");
	                                                                                                            		eInventoryComboBox.setSelectedItem("");
	                                                                                                            	}
                                                                                                            	}
                                                                                                            });
                                                                                                            exercisesListComboBox.setBounds(113, 167, 137, 27);
                                                                                                            createWorkoutPanel.add(exercisesListComboBox);
                                                                                                            
                                                                                                            exercisesInRoutine = new JTextArea();
                                                                                                            exercisesInRoutine.setWrapStyleWord(true);
                                                                                                            exercisesInRoutine.setLineWrap(true);
                                                                                                            exercisesInRoutine.setEditable(false);
                                                                                                            exercisesInRoutine.setBounds(360, 46, 242, 124);
                                                                                                            createWorkoutPanel.add(exercisesInRoutine);
                                                                                                            
                                                                                                            JLabel lblExercisesInRoutine = new JLabel("Exercises In Routine:");
                                                                                                            lblExercisesInRoutine.setBounds(360, 24, 149, 16);
                                                                                                            createWorkoutPanel.add(lblExercisesInRoutine);
                                                                                                            
                                                                                                            JButton btnRemoveFromWorkout = new JButton("Remove from Workout Routine");
                                                                                                            btnRemoveFromWorkout.addActionListener(new ActionListener() {
                                                                                                            	public void actionPerformed(ActionEvent e) {
                                                                                                            		WorkoutRoutine wr = GymSystemController.getInstance().searchRoutines(workoutName.getText());
                                                                                                                  Exercise ex = GymSystemController.getInstance().searchExercise(exerciseNamefield.getText());
                                                                                                                  if(wr!=null)
                                                                                                                  {
                                                                                                                     if(ex!=null) {
                                                                                                                    	 wr.getExercises().remove(ex);
                                                                                                                    	 String exerciseList = "";
                                                                                                                    	 for(Exercise exercise: wr.getExercises()) {
                                                                                                                    		exerciseList += exercise.toString();
                                                                                                                    	 }
                                                                                                                    	exercisesInRoutine.setText(exerciseList);
                                                                                                                    	 
                                                                                                                     }
                                                                                                                     else {
                                                                                                                    	 JOptionPane.showMessageDialog(mainMenuPanel, "Exercise does not exist in the system.");
                                                                                                                     }
                                                                                                                  } 
                                                                                                                  else {
                                                                                                                	  JOptionPane.showMessageDialog(mainMenuPanel, "Workout Routine does not exist in the system.");
                                                                                                                  }
                                                                                                            	}
                                                                                                            });
                                                                                                            btnRemoveFromWorkout.setBounds(370, 182, 228, 29);
                                                                                                            createWorkoutPanel.add(btnRemoveFromWorkout);
                                                                                                            
                                                                                                            JButton btnSaveExercise = new JButton("Save");
                                                                                                            btnSaveExercise.addActionListener(new ActionListener() {
                                                                                                    	  public void actionPerformed(ActionEvent e) {
                                                                                                    		  
                                                                                                    		  Exercise exercise = GymSystemCreator.getInstance().createExercise(exerciseNamefield.getText(), numReps.getText(), numSets.getText(), eInventoryComboBox.getSelectedItem().toString());
                                                                                                    
                                                                                                    		  if(exercise != null)
                                                                                                                    {
                                                                                                                       Response success = new Response();
                                                                                                                       success = GymSystemController.getInstance().addExercise(exercise);
                                                                                                                       
                                                                                                                       if (!success.successful) {
                                                                                                                          JOptionPane.showMessageDialog(mainMenuPanel, success.info);
                                                                                                                       } else {
                                                                                                                          JOptionPane.showMessageDialog(mainMenuPanel, success.info);

                                                                                                                          // clear fields
                                                                                                                          clearTextFields();
                                                                                                                          //TODO: Display the current TO THE EXERCISE LIST
                                                                                                                          exercisesListComboBox.addItem(exercise.getName());
                                                                                                                       }
                                                                                                                    } else {
                                                                                                                       JOptionPane.showMessageDialog(mainMenuPanel, "Exercise Information is not valid");
                                                                                                                    }
                                                                                                    		  
                                                                                                    	  }
                                                                                                            });
                                                                                                            btnSaveExercise.setBounds(16, 341, 117, 29);
                                                                                                            createWorkoutPanel.add(btnSaveExercise);
                                                                                                            
                                                                                                            JButton btnDeleteExercise = new JButton("Delete");
                                                                                                            btnDeleteExercise.addActionListener(new ActionListener() {
                                                                                                            	public void actionPerformed(ActionEvent e) {
                                                                                                            	Exercise exerciseSearched = GymSystemController.getInstance().searchExercise(exerciseNamefield.getText());
                                                                                                            	if(exerciseSearched != null)
                                                                                                                  {
                                                                                                                     Response success = new Response();
                                                                                                                     success = GymSystemController.getInstance().removeExercise(exerciseSearched);
                                                                                                                     
                                                                                                                     if (!success.successful) {
                                                                                                                        JOptionPane.showMessageDialog(mainMenuPanel, success.info);
                                                                                                                     } else {
                                                                                                                        JOptionPane.showMessageDialog(mainMenuPanel, success.info);

                                                                                                                        // clear fields
                                                                                                                        clearTextFields();
                                                                                                                        exercisesListComboBox.removeItem(exerciseSearched.getName());
                                                                                                                     }
                                                                                                                  }
                                                                                                            	else {
                                                                                                                     JOptionPane.showMessageDialog(mainMenuPanel, "Exercise was not found in the Gym's exercises");
                                                                                                                  }
                                                                                                            	}
                                                                                                            });
                                                                                                            btnDeleteExercise.setBounds(175, 341, 117, 29);
                                                                                                            createWorkoutPanel.add(btnDeleteExercise);
                                                                                                            
                                                                                                            JButton btnSaveRoutine = new JButton("Save");
                                                                                                            btnSaveRoutine.addActionListener(new ActionListener() {
                                                                                                            	public void actionPerformed(ActionEvent e) {
                                                                                                            		//TODO ADD WORKOUT ROUTINE TO GYM
                                                                                                            		WorkoutRoutine routine = GymSystemCreator.getInstance().createWorkoutRoutine(workoutName.getText());
                                                                                                            		if(routine != null)
                                                                                                                  {
                                                                                                                     Response success = new Response();
                                                                                                                     success = GymSystemController.getInstance().addRoutine(routine);
                                                                                                                     
                                                                                                                     if (!success.successful) {
                                                                                                                        JOptionPane.showMessageDialog(mainMenuPanel, success.info);
                                                                                                                     } else {
                                                                                                                        JOptionPane.showMessageDialog(mainMenuPanel, success.info);

                                                                                                                        // clear fields
                                                                                                                        clearTextFields();
                                                                                                                        //exercisesListComboBox.removeItem(exerciseSearched);
                                                                                                                        gymRoutinesCombobox.addItem(routine);
                                                                                                                     }
                                                                                                                  } else {
                                                                                                                     JOptionPane.showMessageDialog(mainMenuPanel, "Routine Information was invalid");
                                                                                                                  }
                                                                                                            		
                                                                                                            	}
                                                                                                            });
                                                                                                            btnSaveRoutine.setBounds(16, 110, 117, 29);
                                                                                                            createWorkoutPanel.add(btnSaveRoutine);
                                                                                                            
                                                                                                            JButton btnDeleteRoutine = new JButton("Delete");
                                                                                                            btnDeleteRoutine.addActionListener(new ActionListener() {
                                                                                                            	public void actionPerformed(ActionEvent e) {
                                                                                                            		WorkoutRoutine routine = GymSystemController.getInstance().searchRoutines(workoutName.getText());
                                                                                                            		if(routine != null)
                                                                                                                  {
                                                                                                                     Response success = new Response();
                                                                                                                     //TODO WHAT IF A CUSTOMER HAS THE ROUTINE ASSIGNED TO THEM???
                                                                                                                     //RETURN NAMES OF CUSTOMERS WITH THE ROUTINE ASSIGNED??
                                                                                                                     success = GymSystemController.getInstance().removeRoutine(routine);
                                                                                                                     
                                                                                                                     if (!success.successful) {
                                                                                                                        JOptionPane.showMessageDialog(mainMenuPanel, success.info);
                                                                                                                     } else {
                                                                                                                        JOptionPane.showMessageDialog(mainMenuPanel, success.info);

                                                                                                                        // clear fields
                                                                                                                        clearTextFields();
                                                                                                                        
                                                                                                                        gymRoutinesCombobox.removeItem(routine);
                                                                                                                     }
                                                                                                                  } else {
                                                                                                                     JOptionPane.showMessageDialog(mainMenuPanel, "Routine Information was invalid");
                                                                                                                  }
                                                                                                            		
                                                                                                            	}
                                                                                                            	
                                                                                                            });
                                                                                                            btnDeleteRoutine.setBounds(175, 110, 117, 29);
                                                                                                            createWorkoutPanel.add(btnDeleteRoutine);
                                                                                                            
                                                                                                            JButton btnAssingRoutines = new JButton("Assign Workout Routines");
                                                                                                            btnAssingRoutines.addActionListener(new ActionListener() {
                                                                                                            	public void actionPerformed(ActionEvent e) {
                                                                                                            		createWorkoutPanel.setVisible(false);
                                                                                                            		assignRoutinesPanel.setVisible(true);
                                                                                                            	}
                                                                                                            });
                                                                                                            btnAssingRoutines.setBounds(380, 275, 215, 29);
                                                                                                            createWorkoutPanel.add(btnAssingRoutines);
                              
                              classesPanel = new JPanel();
                              classesPanel.setBounds(0, 53, 639, 391);
                              classesPanel.setVisible(false);
                              mainMenuPanel.add(classesPanel);
                              classesPanel.setLayout(null);
                              
                              JLabel lblClassName = new JLabel("Class Name:");
                              lblClassName.setBounds(6, 49, 86, 16);
                              classesPanel.add(lblClassName);
                              
                              JLabel lblInstructor = new JLabel("Instructor:");
                              lblInstructor.setBounds(6, 77, 86, 16);
                              classesPanel.add(lblInstructor);
                              
                              JLabel lblMaxClassSize = new JLabel("Max Class Size:");
                              lblMaxClassSize.setBounds(6, 105, 106, 16);
                              classesPanel.add(lblMaxClassSize);
                              
                              JLabel lblSchedule_1 = new JLabel("Class Schedule");
                              lblSchedule_1.setBounds(68, 137, 134, 16);
                              classesPanel.add(lblSchedule_1);
                              
                              classAttendeesField = new JTextField();
                              classAttendeesField.setBounds(378, 133, 255, 229);
                              classesPanel.add(classAttendeesField);
                              classAttendeesField.setColumns(10);
                              
                              JLabel lblClassAttendees = new JLabel("Class Attendees:");
                              lblClassAttendees.setBounds(378, 105, 117, 16);
                              classesPanel.add(lblClassAttendees);
                              
                              JLabel lblCustomers = new JLabel("Customers:");
                              lblCustomers.setBounds(378, 23, 86, 16);
                              classesPanel.add(lblCustomers);
                              
                              customersComboBox = new JComboBox();
                              customersComboBox.setBounds(476, 19, 157, 27);
                              customersComboBox.addItem("");
                              classesPanel.add(customersComboBox);
                              if(GymSystemController.getInstance().getCustomers() != null) {
                                  for(Customer c: GymSystemController.getInstance().getCustomers()) {
                                		  customersComboBox.addItem(c.getPersonalInfo().getFirstName() + " " + c.getPersonalInfo().getLastName());
                                  }
								}
                              if(GymSystemController.getInstance().getGymClasses()!= null) {
                                  for(FitnessClass fc: GymSystemController.getInstance().getGymClasses()) {
                                	  ClassListComboBox.addItem(fc.getName());
                                  }
                              }
                              
                              JButton btnAddAttendee = new JButton("Add");
                              btnAddAttendee.addActionListener(new ActionListener() {
                              	public void actionPerformed(ActionEvent e) {
                              		String[] name = customersComboBox.getSelectedItem().toString().split(" ");
                              		Customer c = GymSystemController.getInstance().searchCustomer(name[0], name[1]);
                              		FitnessClass fc = GymSystemController.getInstance().searchGymClasses(classNameField.getText());
                              		if(c != null) {
                              			if(fc != null) {
                              				fc.addAttendee(c);
                              				classAttendeesField.removeAll();
                              				String cList = "";
                              				for(Customer customer : fc.getAttendees()) {
                              					cList += customer.getPersonalInfo().getFirstName() + " " + customer.getPersonalInfo().getLastName() + " \n";
                              				}
                              				classAttendeesField.setText(cList);
                              				
                              			}
                              			else{
                              				JOptionPane.showMessageDialog(mainMenuPanel, "Class does not exist in the system.");
                              			}
                              		}
                              		else {
                              			JOptionPane.showMessageDialog(mainMenuPanel, "Customer does not exist in the system.");
                              		}
                              		
                              	}
                              });
                              btnAddAttendee.setBounds(378, 71, 117, 29);
                              classesPanel.add(btnAddAttendee);
                              
                              JButton btnRemoveAttendee = new JButton("Remove");
                              btnRemoveAttendee.addActionListener(new ActionListener() {
                              	public void actionPerformed(ActionEvent e) {
                              		String[] name = customersComboBox.getSelectedItem().toString().split(" ");
                              		Customer c = GymSystemController.getInstance().searchCustomer(name[0], name[1]);
                              		FitnessClass fc = GymSystemController.getInstance().searchGymClasses(classNameField.getText());
                              		if(c != null) {
                              			if(fc != null) {
                              				fc.removeAttendee(c);
                              				classAttendeesField.removeAll();
                              				String cList = "";
                              				for(Customer customer : fc.getAttendees()) {
                              					cList += customer.getPersonalInfo().getFirstName() + " " + customer.getPersonalInfo().getLastName() + " \n";
                              				}
                              				classAttendeesField.setText(cList);
                              				
                              			}
                              			else{
                              				JOptionPane.showMessageDialog(mainMenuPanel, "Class does not exist in the system.");
                              			}
                              		}
                              		else {
                              			JOptionPane.showMessageDialog(mainMenuPanel, "Customer does not exist in the system.");
                              		}
                              		
                              	}
                              });
                              btnRemoveAttendee.setBounds(507, 71, 117, 29);
                              classesPanel.add(btnRemoveAttendee);
                              
                              trainersComboBox = new JComboBox();
                              trainersComboBox.setBounds(142, 73, 162, 27);
                              classesPanel.add(trainersComboBox);
                              trainersComboBox.addItem("");
                              for(Trainer t : GymSystemController.getInstance().getTrainers()) {
                            	  trainersComboBox.addItem(t.getPersonalInfo().getLastName() + ", " + t.getPersonalInfo().getFirstName());
                              }
                              
                              classNameField = new JTextField();
                              classNameField.setBounds(142, 44, 160, 26);
                              classesPanel.add(classNameField);
                              classNameField.setColumns(10);
                              
                              maxClassSizeField = new JTextField();
                              maxClassSizeField.setColumns(10);
                              maxClassSizeField.setBounds(144, 100, 160, 26);
                              classesPanel.add(maxClassSizeField);
                              
                              JButton btnSave_Class = new JButton("Save");
                              btnSave_Class.addActionListener(new ActionListener() {
                              	public void actionPerformed(ActionEvent e) {
                              		if(!trainersComboBox.getSelectedItem().toString().equals("") && !classNameField.equals("") && classSchedule != null && !maxClassSizeField.getText().equals("")) {
                              			String [] temp = trainersComboBox.getSelectedItem().toString().split(", ");
                              			Trainer classTrainer = (Trainer) GymSystemController.getInstance().searchUser(temp[1], temp[0]);
                                        FitnessClass fitnessClass = GymSystemCreator.getInstance().createFitnessClass(classNameField.getText(), classTrainer, classSchedule, maxClassSizeField.getText());
                                        
                                        Response success = GymSystemController.getInstance().addGymClass(fitnessClass);
                                        if(success.successful) {
                                        	JOptionPane.showMessageDialog(mainMenuPanel, "Gym class successfully saved.");
                                        	trainersComboBox.setSelectedItem("");
                                        	classNameField.setText("");
                                        	classSchedule = null;
                                        	classTimesField.setText("");
                                        	maxClassSizeField.setText("");
                                        	ClassListComboBox.addItem(fitnessClass.getName());
                                        }
                                        else {
                                        	JOptionPane.showMessageDialog(mainMenuPanel, "Unable to create Gym Class.");
                                        }
                              		}
                              		else {
                              			JOptionPane.showMessageDialog(mainMenuPanel, "Invlalid Class Information");
                              		}
                              		
                              	}
                              });
                              
                              btnSave_Class.setBounds(6, 356, 117, 29);
                              classesPanel.add(btnSave_Class);
                              
                              JButton btnRemove_Class = new JButton("Remove");
                              btnRemove_Class.setBounds(179, 356, 117, 29);
                              btnRemove_Class.addActionListener(new ActionListener() {
                                	public void actionPerformed(ActionEvent e) {
                                		if(!ClassListComboBox.getSelectedItem().toString().equals("")) {
                                            FitnessClass fitnessClass = GymSystemController.getInstance().searchGymClasses(ClassListComboBox.getSelectedItem().toString());
                                            		
                                            		
                                            Response success = GymSystemController.getInstance().removeGymClass(fitnessClass);
                                            if(success.successful) {
                                            	JOptionPane.showMessageDialog(mainMenuPanel, "Gym class successfully deleted.");
                                            	trainersComboBox.setSelectedItem("");
                                            	classNameField.setText("");
                                            	classSchedule = null;
                                            	classTimesField.setText("");
                                            	maxClassSizeField.setText("");
                                            	ClassListComboBox.removeItem(fitnessClass.getName());
                                            	classStartTextField.setText("");
                                            	classEndField.setText("");
                                            	
                                            }
                                            else {
                                            	JOptionPane.showMessageDialog(mainMenuPanel, "Unable to delete Gym Class.");
                                            }
                                  		}
                                  		else {
                                  			JOptionPane.showMessageDialog(mainMenuPanel, "Select a class to delete");
                                  		}
                                	
                                	}
                                	
                               });
                              classesPanel.add(btnRemove_Class);
                              
                              JLabel lblClasses = new JLabel("Classes:");
                              lblClasses.setBounds(6, 19, 61, 16);
                              classesPanel.add(lblClasses);
                              
                              ClassListComboBox = new JComboBox();
                              ClassListComboBox.addActionListener(new ActionListener() {
                              	public void actionPerformed(ActionEvent e) {
                              		if(ClassListComboBox.getSelectedItem().toString()!= null && !ClassListComboBox.getSelectedItem().toString().equals("")) {
	                                          		FitnessClass fc = GymSystemController.getInstance().searchGymClasses(ClassListComboBox.getSelectedItem().toString());
	                                          		if(fc != null) {
	                                          			searchedClass = fc;
		                                          		classNameField.setText(fc.getName());
		                                          		trainersComboBox.setSelectedItem(fc.getInstructor());
		                                          		maxClassSizeField.setText(fc.getMaxClassSize().toString());
		                                          		classTimesField.setText(fc.getClassSchedule().toString());
		                                          		String attendees = "";
		                                          		for(Customer c: fc.getAttendees()) {
		                                          			attendees += c.getPersonalInfo().getFirstName() + " " + c.getPersonalInfo().getLastName() + "\n";
		                                          		}
		                                          		classAttendeesField.setText(attendees);
	                                          		}
	                                          		else {
	                                          			JOptionPane.showMessageDialog(mainMenuPanel, "Fitness Class does not exist in the system.");
	                                          		}
                              		}
                              	}
                              });
                              ClassListComboBox.setBounds(142, 15, 157, 27);
                              ClassListComboBox.addItem("");
                              classesPanel.add(ClassListComboBox);
                              
                              JLabel startTimeClassLabel = new JLabel("Start Time:");
                              startTimeClassLabel.setBounds(6, 165, 92, 16);
                              classesPanel.add(startTimeClassLabel);
                              
                              JLabel endTimeClassLabel = new JLabel("End Time: ");
                              endTimeClassLabel.setBounds(6, 193, 81, 16);
                              classesPanel.add(endTimeClassLabel);
                              
                              JLabel weekdayClassLabel = new JLabel("Weekday:");
                              weekdayClassLabel.setBounds(270, 165, 61, 16);
                              classesPanel.add(weekdayClassLabel);
                              
                              classWeekday = new JComboBox();
                              classWeekday.setModel(new DefaultComboBoxModel(Weekday.values()));
                              classWeekday.setBounds(241, 189, 136, 27);
                              classesPanel.add(classWeekday);
                              
                              classStartTextField = new JTextField();
                              classStartTextField.setColumns(10);
                              classStartTextField.setBounds(99, 160, 130, 26);
                              classesPanel.add(classStartTextField);
                              
                              classEndField = new JTextField();
                              classEndField.setColumns(10);
                              classEndField.setBounds(99, 189, 130, 26);
                              classesPanel.add(classEndField);
                              
                              classTimesField = new JTextArea();
                              classTimesField.setWrapStyleWord(true);
                              classTimesField.setLineWrap(true);
                              classTimesField.setColumns(10);
                              classTimesField.setBounds(90, 228, 276, 123);
                              classesPanel.add(classTimesField);
                              
                              JButton btnAdd_Time = new JButton("Add");
                              btnAdd_Time.addActionListener(new ActionListener() {
                              	public void actionPerformed(ActionEvent e) {
                              		WorkTime w =  GymSystemCreator.getInstance().createWorkTime(classStartTextField.getText(), classEndField.getText(), (Weekday) classWeekday.getSelectedItem());
                              		if(searchedClass != null && searchedClass.getClassSchedule() != null) {
                                    	classSchedule = searchedClass.getClassSchedule();
                                    }
                                    else {
                                    	classSchedule = new Schedule();
                                    }
                                    
                                    if(w != null)
                                    {
                                       classSchedule.addWorkTime(w);
                                       classTimesField.setText(classSchedule.toString());
                                       classTimesField.setText(classSchedule.toString());
                                    } else {
                                       JOptionPane.showMessageDialog(mainMenuPanel, "Work Time not valid.");
                                    }
                              	}
                              });
                              btnAdd_Time.setBounds(6, 256, 86, 29);
                              classesPanel.add(btnAdd_Time);
                              
                              JButton btnRemove_Time = new JButton("Remove");
                              btnRemove_Time.addActionListener(new ActionListener() {
                              	public void actionPerformed(ActionEvent e) {
                              		WorkTime w =  GymSystemCreator.getInstance().createWorkTime(classStartTextField.getText(), classEndField.getText(), (Weekday) classWeekday.getSelectedItem());
                              		if(searchedClass.getClassSchedule() != null) {
                                    	classSchedule = searchedClass.getClassSchedule();
                                    }
                                    if(w != null)
                                    {
                                       classSchedule.removeWorkTime(w);
                                       classTimesField.setText(classSchedule.toString());
                                    } else {
                                       JOptionPane.showMessageDialog(mainMenuPanel, "Work Time not valid.");
                                    }
                              	}
                              });
                              btnRemove_Time.setBounds(6, 304, 86, 29);
                              classesPanel.add(btnRemove_Time);
                              
                                    addEquipmentPanel = new JPanel();
                                    addEquipmentPanel.setBounds(0, 53, 639, 391);
                                    mainMenuPanel.add(addEquipmentPanel);
                                    addEquipmentPanel.setLayout(null);
                                    
                                          JPanel searchEquipPanel_1 = new JPanel();
                                          searchEquipPanel_1.setBounds(0, 55, 631, 71);
                                          addEquipmentPanel.add(searchEquipPanel_1);
                                          
                                                JLabel lblEquipmentName = new JLabel("Equipment Name:");
                                                lblEquipmentName.setBounds(252, 213, 117, 16);
                                                addEquipmentPanel.add(lblEquipmentName);
                                                
                                                      JLabel lblQuantity = new JLabel("Quantity:");
                                                      lblQuantity.setBounds(269, 253, 61, 16);
                                                      addEquipmentPanel.add(lblQuantity);
                                                      
                                                            JLabel lblPathToPicture = new JLabel("Path to Picture:");
                                                            lblPathToPicture.setBounds(269, 291, 100, 16);
                                                            addEquipmentPanel.add(lblPathToPicture);
                                                            
                                                                  equipmentName = new JTextField();
                                                                  equipmentName.setBounds(381, 208, 130, 26);
                                                                  addEquipmentPanel.add(equipmentName);
                                                                  equipmentName.setColumns(10);
                                                                  allTextFields.add(equipmentName);
                                                                  
                                                                        equipmentQuantity = new JTextField();
                                                                        equipmentQuantity.setBounds(381, 248, 130, 26);
                                                                        addEquipmentPanel.add(equipmentQuantity);
                                                                        equipmentQuantity.setColumns(10);
                                                                        allTextFields.add(equipmentQuantity);
                                                                        
                                                                              eqPicturePath = new JTextField();
                                                                              eqPicturePath.setBounds(381, 286, 130, 26);
                                                                              addEquipmentPanel.add(eqPicturePath);
                                                                              eqPicturePath.setColumns(10);
                                                                              allTextFields.add(eqPicturePath);
                                                                              
                                                                                    JButton btnAdd = new JButton("Save");
                                                                                    btnAdd.addActionListener(new ActionListener() {
                                                                                       public void actionPerformed(ActionEvent e) {
                                                                                          Equipment equipment = GymSystemCreator.getInstance().createEquipment(equipmentName.getText(), eqPicturePath.getText(), equipmentQuantity.getText());
                                                                                       
                                                                                          if(equipment != null)
                                                                                          {
                                                                                             Response success = new Response();
                                                                                             if (action.equals("Add")) {
                                                                                                success = GymSystemController.getInstance().addEquipment(equipment);
                                                                                                
                                                                                             } else {
                                                                                                success = GymSystemController.getInstance().updateEquipment(equipmentSearched, equipment);
                                                                                             }

                                                                                             if (!success.successful) {
                                                                                                JOptionPane.showMessageDialog(mainMenuPanel, success.info);
                                                                                                eInventoryComboBox.addItem(equipment);
                                                                                             } else {
                                                                                                JOptionPane.showMessageDialog(mainMenuPanel, success.info);

                                                                                                // clear fields
                                                                                                clearTextFields();

                                                                                                addEquipmentPanel.setVisible(false);
                                                                                                searchEquipPanel_1.setVisible(false);

                                                                                                if (currentUser.getUserType() == UserType.MANAGER) {
                                                                                                   ManagerMenu.setVisible(true);
                                                                                                } else {
                                                                                                   TrainerMenu.setVisible(true);
                                                                                                }
                                                                                             }
                                                                                          } else {
                                                                                             JOptionPane.showMessageDialog(mainMenuPanel, "Equipment Information is not valid");
                                                                                          }
                                                                                       }
                                                                                    });
                                                                                    btnAdd.setBounds(252, 356, 117, 29);
                                                                                    addEquipmentPanel.add(btnAdd);
                                                                                    searchEquipPanel_1.setLayout(null);
                                                                                    
                                                                                          JLabel lblSearchForEquipment = new JLabel("Search for Equipment by Name:");
                                                                                          lblSearchForEquipment.setBounds(101, 10, 197, 16);
                                                                                          searchEquipPanel_1.add(lblSearchForEquipment);
                                                                                          JComboBox searchEquip = new JComboBox();
                                                                                          searchEquip.addActionListener(new ActionListener() {
                                                                                          public void actionPerformed(ActionEvent e) {
                                                                                          	if(!searchEquip.getSelectedItem().toString().equals("")) {
                                                                                          	 Equipment equip = GymSystemController.getInstance().searchEquipment(searchEquip.getSelectedItem().toString());
                                                                                               if (equip != null) {
                                                                                                  equipmentSearched = equip;
                                                                                                  equipmentName.setText(equip.getName());
                                                                                                  String q = String.valueOf(equip.getQuantity());
                                                                                                  equipmentQuantity.setText(q);
                                                                                                  eqPicturePath.setText(equip.getPicture().getPath());
                                                                                                  lblpicDisplay.setIcon(new ImageIcon(eqPicturePath.getText()));
                                                                                               }
                                                                                              }
                                                                                          }
                                                                                          });
                                                                                          searchEquip.setEditable(true);
                                                                                          searchEquip.setBounds(348, 5, 195, 27);
                                                                                          searchEquip.addItem("");
                                                                                          searchEquipPanel_1.add(searchEquip);
                                                                                          
                                                                                                JButton btnRemove = new JButton("Remove");
                                                                                                btnRemove.addActionListener(new ActionListener() {
                                                                                                   public void actionPerformed(ActionEvent e) {
                                                                                                      Response success = GymSystemController.getInstance().removeEquipment(equipmentSearched);
                                                                                                      if (!success.successful) {
                                                                                                         JOptionPane.showMessageDialog(mainMenuPanel, success.info);
                                                                                                      } else {
                                                                                                         JOptionPane.showMessageDialog(mainMenuPanel, success.info);
                                                                                                         // clear fields
                                                                                                         clearTextFields();

                                                                                                         customerSearched = null;
                                                                                                         addEquipmentPanel.setVisible(false);
                                                                                                         searchEquipPanel_1.setVisible(false);

                                                                                                         if (currentUser.getUserType() == UserType.MANAGER) {
                                                                                                            ManagerMenu.setVisible(true);
                                                                                                         } else {
                                                                                                            TrainerMenu.setVisible(true);
                                                                                                         }
                                                                                                      }
                                                                                                   }
                                                                                                });
                                                                                                btnRemove.setBounds(394, 356, 117, 29);
                                                                                                addEquipmentPanel.add(btnRemove);
                                                                                                
                                                                                                lblpicDisplay = new JLabel("");
                                                                                                lblpicDisplay.setIcon(new ImageIcon(eqPicturePath.getText()));
                                                                                                lblpicDisplay.setBounds(25, 213, 212, 149);
                                                                                                addEquipmentPanel.add(lblpicDisplay);
                              
                              assignRoutinesPanel = new JPanel();
                              assignRoutinesPanel.setBounds(0, 53, 639, 391);
                              mainMenuPanel.add(assignRoutinesPanel);
                              assignRoutinesPanel.setLayout(null);
                              
                                    JButton btnSaveWorkout = new JButton("Assign Workout To Customer");
                                    btnSaveWorkout.setBounds(314, 186, 229, 29);
                                    assignRoutinesPanel.add(btnSaveWorkout);
                                    
                                          txtListGymRoutines = new JTextArea();
                                          txtListGymRoutines.setEditable(false);
                                          txtListGymRoutines.setBounds(256, 244, 348, 141);
                                          assignRoutinesPanel.add(txtListGymRoutines);
                                          txtListGymRoutines.setLineWrap(true);
                                          txtListGymRoutines.setWrapStyleWord(true);
                                          txtListGymRoutines.setColumns(10);
                                          String gymRoutines = "";
                                          for(WorkoutRoutine wr: GymSystemController.getInstance().getRoutines()) {
                                        	  gymRoutines += wr.toString();
                                          }
                                          txtListGymRoutines.setText(gymRoutines);
                                          
                                                JLabel lblSearchForCustomer = new JLabel("Search for Customer by Name:");
                                                lblSearchForCustomer.setBounds(6, 6, 195, 16);
                                                assignRoutinesPanel.add(lblSearchForCustomer);
                                                
                                                      txtDisplayCustomerInfo = new JTextArea();
                                                      txtDisplayCustomerInfo.setEditable(false);
                                                      txtDisplayCustomerInfo.setBounds(269, 33, 335, 105);
                                                      assignRoutinesPanel.add(txtDisplayCustomerInfo);
                                                      txtDisplayCustomerInfo.setLineWrap(true);
                                                      txtDisplayCustomerInfo.setWrapStyleWord(true);
                                                      txtDisplayCustomerInfo.setColumns(10);
                                                      
                                                            exSearchFName = new JTextField();
                                                            exSearchFName.setBounds(96, 28, 130, 26);
                                                            assignRoutinesPanel.add(exSearchFName);
                                                            exSearchFName.setColumns(10);
                                                            allTextFields.add(exSearchFName);
                                                            
                                                                  exSearchLName = new JTextField();
                                                                  exSearchLName.setBounds(96, 64, 130, 26);
                                                                  assignRoutinesPanel.add(exSearchLName);
                                                                  exSearchLName.setColumns(10);
                                                                  allTextFields.add(exSearchLName);
                                                                  
                                                                        JButton btnSearch_2 = new JButton("Search");
                                                                        btnSearch_2.setBounds(41, 104, 117, 29);
                                                                        assignRoutinesPanel.add(btnSearch_2);
                                                                        
                                                                              JButton btnRemoveWorkoutFrom = new JButton("Remove Workout From Customer");
                                                                              btnRemoveWorkoutFrom.setBounds(303, 145, 240, 29);
                                                                              assignRoutinesPanel.add(btnRemoveWorkoutFrom);
                                                                              
                                                                                    JLabel lblFirstName_1 = new JLabel("First Name:");
                                                                                    lblFirstName_1.setBounds(6, 33, 73, 16);
                                                                                    assignRoutinesPanel.add(lblFirstName_1);
                                                                                    
                                                                                          JLabel lblLastName_1 = new JLabel("Last Name:");
                                                                                          lblLastName_1.setBounds(6, 69, 73, 16);
                                                                                          assignRoutinesPanel.add(lblLastName_1);
                                                                                          
                                                                                          JLabel lblsearchedCustomer = new JLabel("Customer's Workout Routines");
                                                                                          lblsearchedCustomer.setBounds(268, 6, 339, 16);
                                                                                          assignRoutinesPanel.add(lblsearchedCustomer);
                                                                                          
                                                                                          JLabel lblGymsWorkoutRoutines = new JLabel("Gym's Workout Routines");
                                                                                          lblGymsWorkoutRoutines.setBounds(256, 226, 174, 16);
                                                                                          assignRoutinesPanel.add(lblGymsWorkoutRoutines);
                                                                                          btnRemoveWorkoutFrom.addActionListener(new ActionListener() {
                                                                                             public void actionPerformed(ActionEvent e) {
                                                                                                if (!txtDisplayCustomerInfo.getSelectedText().equals("")) {
                                                                                                   if (customerSearched == null) {
                                                                                                      JOptionPane.showMessageDialog(mainMenuPanel, "Search Customer to Unassign Workout.");
                                                                                                   } else {

                                                                                                      Response success = GymSystemController.getInstance().unassignWorkoutRoutine(customerSearched, txtDisplayCustomerInfo.getSelectedText());

                                                                                                      if (success.successful) {
                                                                                                         JOptionPane.showMessageDialog(mainMenuPanel, success.info);

                                                                                                         String s = "";

                                                                                                         for (WorkoutRoutine w : customerSearched.getWorkoutRoutines()) {
                                                                                                            s += w.toString() + "\n";
                                                                                                         }

                                                                                                         txtDisplayCustomerInfo.setText(s);
                                                                                                      } else {
                                                                                                         JOptionPane.showMessageDialog(mainMenuPanel, success.info);
                                                                                                      }
                                                                                                   }

                                                                                                } else {
                                                                                                   JOptionPane.showMessageDialog(mainMenuPanel, "Provide workout routine to remove.");
                                                                                                }

                                                                                             }
                                                                                          });
                                                                                          btnSearch_2.addActionListener(new ActionListener() {
                                                                                             public void actionPerformed(ActionEvent e) {
                                                                                                customerSearched = GymSystemController.getInstance().searchCustomer(exSearchFName.getText(),
                                                                                                      exSearchLName.getText());
                                                                                                if (customerSearched != null) {
                                                                                                   String customerName = customerSearched.getPersonalInfo().getFirstName() + " "
                                                                                                         + customerSearched.getPersonalInfo().getLastName() + "'s assigned Workout Routines:\n";
                                                                                                   lblsearchedCustomer.setText(customerName);
                                                                                                   String customerRoutines = "";
                                                                                                   for (WorkoutRoutine w : customerSearched.getWorkoutRoutines()) {
                                                                                                	   customerRoutines += w.toString() + "\n";
                                                                                                   }

                                                                                                   txtDisplayCustomerInfo.setText(customerRoutines);
                                                                                                } else {
                                                                                                   JOptionPane.showMessageDialog(mainMenuPanel, "Customer not found.");
                                                                                                }

                                                                                             }
                                                                                          });
                                                                                          btnSaveWorkout.addActionListener(new ActionListener() {
                                                                                             public void actionPerformed(ActionEvent e) {
                                                                                                if (customerSearched == null) {
                                                                                                   JOptionPane.showMessageDialog(mainMenuPanel, "Search Customer to Assign Workout To.");
                                                                                                } else {
                                                                                                   WorkoutRoutine wr = GymSystemCreator.getInstance().createWorkoutRoutine(txtListGymRoutines.getSelectedText());
                                                                                                   if(wr != null)
                                                                                                   {
                                                                                                      Response success = GymSystemController.getInstance().assignWorkoutRoutine(customerSearched, wr);
                                                                                                      
                                                                                                      if(success.successful) {
                                                                                                         JOptionPane.showMessageDialog(mainMenuPanel, success.info);
                                                                                                         String s = "";

                                                                                                         for (WorkoutRoutine w : customerSearched.getWorkoutRoutines()) {
                                                                                                            s += w.toString() + "\n";
                                                                                                         }

                                                                                                         txtDisplayCustomerInfo.setText(s);
                                                                                                      }
                                                                                                      else
                                                                                                      {
                                                                                                         JOptionPane.showMessageDialog(mainMenuPanel, success.info);
                                                                                                      }
                                                                                                   }
                                                                                                   else
                                                                                                   {
                                                                                                      JOptionPane.showMessageDialog(mainMenuPanel, "Workout Routine needs a name.");
                                                                                                   }
                                                                                                }
                                                                                             }
                                                                                          });
                                                                                          assignRoutinesPanel.setVisible(false);
                                                                                                      
                                                                                                      /***MVSMITH***/
                                                                                                      for(Equipment e : GymSystemController.getInstance().getEquipmentInventory()) {
                                                                                                    	  eInventoryComboBox.addItem(e.getName());
                                                                                                      }
                                                                                                      for(WorkoutRoutine wr: GymSystemController.getInstance().getRoutines()) {
                                                                                                    	  gymRoutinesCombobox.addItem(wr.toString());
                                                                                                      }
                                                                                                      if(GymSystemController.getInstance().getExercises()!= null) {
	                                                                                                      for(Exercise e: GymSystemController.getInstance().getExercises()) {
	                                                                                                    	  exercisesListComboBox.addItem(e);
	                                                                                                      }
                                                                                                      }
                                                                                    /**MVSMITH view equipment inventory**/
																					for(Equipment e : GymSystemController.getInstance().getEquipmentInventory()) {
                                                                                    	searchEquip.addItem(e.getName());
                                                                                    }

      JLabel lblMainMenu = new JLabel("Main Menu");
      lblMainMenu.setBounds(272, 20, 95, 21);
      lblMainMenu.setFont(new Font("Lucida Grande", Font.BOLD, 17));
      mainMenuPanel.add(lblMainMenu);
      
      JPanel createSchedulePanel = new JPanel();
      createSchedulePanel.setBounds(0, 71, 637, 367);
      mainMenuPanel.add(createSchedulePanel);
      createSchedulePanel.setLayout(null);

      JButton btnLogout = new JButton("Logout");
      btnLogout.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            // logout of system
            JOptionPane.showMessageDialog(mainMenuPanel, "Successfully logged out.");
            LoginPanel.setVisible(true);
            addEquipmentPanel.setVisible(false);
            addEmployeePanel.setVisible(false);
            createWorkoutPanel.setVisible(false);
            createSchedulePanel.setVisible(false);
            mainMenuPanel.setVisible(false);
            ManagerMenu.setVisible(false);
            TrainerMenu.setVisible(false);
            assignRoutinesPanel.setVisible(false);
            classesPanel.setVisible(false);
            currUserClassesPanel.setVisible(false);
            
            
            clearTextFields();

            txtDisplayScheduleHere.setText("");
            txtListGymRoutines.setText("");
            txtDisplayCustomerInfo.setText("");
            
            currentUser = null;
         }
      });
      btnLogout.setBounds(516, 6, 117, 21);
      mainMenuPanel.add(btnLogout);

      addEmployeePanel = new JPanel();
      mainMenuPanel.add(addEmployeePanel, "name_58547762841183");
      addEmployeePanel.setBounds(0, 71, 637, 367);
      addEmployeePanel.setLayout(null);
      addEmployeePanel.setVisible(false);

      searchPanel = new JPanel();
      searchPanel.setBounds(0, 6, 631, 82);
      addEmployeePanel.add(searchPanel);

      loginInfoPanel = new JPanel();
      loginInfoPanel.setBounds(310, 230, 251, 99);
      addEmployeePanel.add(loginInfoPanel);
      loginInfoPanel.setLayout(null);

      JLabel lblLoginInformation = new JLabel("Login Information");
      lblLoginInformation.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
      lblLoginInformation.setBounds(30, 5, 113, 16);
      loginInfoPanel.add(lblLoginInformation);

      JLabel lblUserName = new JLabel("User Name:");
      lblUserName.setBounds(23, 30, 72, 16);
      loginInfoPanel.add(lblUserName);

      JLabel lblPassword02 = new JLabel("Password: ");
      lblPassword02.setBounds(30, 58, 67, 16);
      loginInfoPanel.add(lblPassword02);

      JTextField userName = new JTextField();
      userName.setBounds(96, 26, 130, 26);
      loginInfoPanel.add(userName);
      userName.setColumns(10);
      userInfoTextFields.add(userName);
      allTextFields.add(userName);

      JTextField password02 = new JTextField();
      password02.setColumns(10);
      password02.setBounds(96, 53, 130, 26);
      loginInfoPanel.add(password02);
      userInfoTextFields.add(password02);
      allTextFields.add(password02);

      JLabel lblPersonalInformation = new JLabel("Personal Information");
      lblPersonalInformation.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
      lblPersonalInformation.setBounds(29, 94, 141, 16);
      addEmployeePanel.add(lblPersonalInformation);

      JLabel lblFirstName = new JLabel("First Name:");
      lblFirstName.setBounds(39, 118, 85, 16);
      addEmployeePanel.add(lblFirstName);

      JLabel lblLastName = new JLabel("Last Name:");
      lblLastName.setBounds(39, 146, 85, 16);
      addEmployeePanel.add(lblLastName);

      JLabel lblEmail = new JLabel("Email:");
      lblEmail.setBounds(39, 174, 85, 16);
      addEmployeePanel.add(lblEmail);

      JLabel lblPhone = new JLabel("Phone:");
      lblPhone.setBounds(39, 202, 85, 16);
      addEmployeePanel.add(lblPhone);

      JLabel lblHealthinsuranceProvider = new JLabel("Health Insurance Provider:");
      lblHealthinsuranceProvider.setBounds(39, 240, 171, 16);
      addEmployeePanel.add(lblHealthinsuranceProvider);

      JTextField firstName = new JTextField();
      firstName.setColumns(10);
      firstName.setBounds(117, 113, 173, 26);
      addEmployeePanel.add(firstName);
      userInfoTextFields.add(firstName);
      allTextFields.add(firstName);

      JTextField lastName = new JTextField();
      lastName.setColumns(10);
      lastName.setBounds(117, 141, 173, 26);
      addEmployeePanel.add(lastName);
      userInfoTextFields.add(lastName);
      allTextFields.add(lastName);

      JTextField email = new JTextField();
      email.setColumns(10);
      email.setBounds(117, 169, 173, 26);
      addEmployeePanel.add(email);
      userInfoTextFields.add(email);
      allTextFields.add(email);

      JTextField phone = new JTextField();
      phone.setColumns(10);
      phone.setBounds(117, 202, 173, 26);
      addEmployeePanel.add(phone);
      userInfoTextFields.add(phone);
      allTextFields.add(phone);

      JTextField insurance = new JTextField();
      insurance.setColumns(10);
      insurance.setBounds(39, 258, 251, 26);
      addEmployeePanel.add(insurance);
      userInfoTextFields.add(insurance);
      allTextFields.add(insurance);

      JLabel lblAddress = new JLabel("Address");
      lblAddress.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
      lblAddress.setBounds(324, 94, 119, 16);
      addEmployeePanel.add(lblAddress);

      JLabel lblStreet = new JLabel("Street:");
      lblStreet.setBounds(334, 118, 61, 16);
      addEmployeePanel.add(lblStreet);

      JLabel lblCity = new JLabel("City:");
      lblCity.setBounds(334, 146, 61, 16);
      addEmployeePanel.add(lblCity);

      JLabel lblState = new JLabel("State:");
      lblState.setBounds(334, 174, 61, 16);
      addEmployeePanel.add(lblState);

      JLabel lblZipCode = new JLabel("Zipcode:");
      lblZipCode.setBounds(334, 202, 61, 16);
      addEmployeePanel.add(lblZipCode);

      JLabel lblMembership = new JLabel("Membership:");
      lblMembership.setBounds(37, 296, 87, 16);
      addEmployeePanel.add(lblMembership);

      JComboBox mstatus = new JComboBox();
      mstatus.setModel(new DefaultComboBoxModel(MembershipStatus.values()));
      mstatus.setBounds(139, 292, 102, 27);
      addEmployeePanel.add(mstatus);

      JTextField street = new JTextField();
      street.setColumns(10);
      street.setBounds(401, 113, 194, 26);
      addEmployeePanel.add(street);
      userInfoTextFields.add(street);
      allTextFields.add(street);

      JTextField city = new JTextField();
      city.setColumns(10);
      city.setBounds(401, 141, 194, 26);
      addEmployeePanel.add(city);
      userInfoTextFields.add(city);
      allTextFields.add(city);

      JTextField state = new JTextField();
      state.setColumns(10);
      state.setBounds(401, 169, 194, 26);
      addEmployeePanel.add(state);
      userInfoTextFields.add(state);
      allTextFields.add(state);

      JTextField zipcode = new JTextField();
      zipcode.setColumns(10);
      zipcode.setBounds(401, 197, 194, 26);
      addEmployeePanel.add(zipcode);
      userInfoTextFields.add(zipcode);
      allTextFields.add(zipcode);

      JButton btnSave_2 = new JButton("Save");
      btnSave_2.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            Address address = GymSystemCreator.getInstance().createAddress(street.getText(), state.getText(), city.getText(), zipcode.getText());
            PersonalInformation pi = GymSystemCreator.getInstance().createPI(firstName.getText(), lastName.getText(), email.getText(),
                  phone.getText(), insurance.getText(), address);
            if(pi != null)
            {
               Response success = new Response();
               User u = GymSystemCreator.getInstance().createUser(userName.getText(), password02.getText());
              
               if (action.equals("Add") && newEmployeeType == UserType.MANAGER) {
                  Manager m = GymSystemCreator.getInstance().createManager(u, pi);
                  if(m != null)
                  {
                     success = GymSystemController.getInstance().addManager(m); 
                  }
                  else
                  {
                     success.info = "Failed to create manager.";
                  }
                  
               } 
               else if (action.equals("Update") && employeeSearched != null
                     && employeeSearched.getUserType() == UserType.MANAGER) 
               {
                  Manager m = GymSystemCreator.getInstance().createManager(u, pi);
                  success = GymSystemController.getInstance().updateManager((Manager) employeeSearched, m); 
               } 
               else if (action.equals("Add") && newEmployeeType == UserType.TRAINER) 
               {
                  Trainer t = GymSystemCreator.getInstance().createTrainer(u, pi);
                  if(t != null)
                  {
                     t.setSchedule(createdSchedule);
                     success = GymSystemController.getInstance().addTrainer(t);
                  }
                  else
                  {
                     success.info = "Failed to create trainer.";
                  }
               }
               else if (action.equals("Update") && employeeSearched != null
                     && employeeSearched.getUserType() == UserType.TRAINER) {
                   Trainer t = GymSystemCreator.getInstance().createTrainer(u, pi);
                   t.setSchedule(createdSchedule);
                   success = GymSystemController.getInstance().updateTrainer((Trainer) employeeSearched, t);                   
               } 
               else if (action.equals("Add") && customerSearched == null) 
               {
                  Customer c = GymSystemCreator.getInstance().createCustomer(pi);
                  if(c != null)
                  {
                     c.setStatus((MembershipStatus) mstatus.getSelectedItem());
                     success = GymSystemController.getInstance().addCustomer(c);
                  }
                  else
                  {
                     success.info = "Failed to create customer.";
                  }
                  
               } 
               else if (action.equals("Update") && customerSearched != null) 
               {
                  Customer c = GymSystemCreator.getInstance().createCustomer(pi);
                  c.setStatus((MembershipStatus) mstatus.getSelectedItem());
                  success = GymSystemController.getInstance().updateCustomer(customerSearched, c);               
               }
               
               if (!success.successful) {
                  JOptionPane.showMessageDialog(mainMenuPanel, success.info);
               } else {
                  JOptionPane.showMessageDialog(mainMenuPanel, success.info);
                  // clear fields
                  clearTextFields();

                  txtDisplayScheduleHere.setText("");

                  customerSearched = null;
                  employeeSearched = null;
                  newEmployeeType = null;
                  createdSchedule = null;

                  addEmployeePanel.setVisible(false);
                  if (currentUser.getUserType() == UserType.MANAGER) {
                     ManagerMenu.setVisible(true);
                  } else {
                     TrainerMenu.setVisible(true);
                  }
               }
               
            }
            else
            {
               JOptionPane.showMessageDialog(mainMenuPanel, "User Information is not valid");
            }
         }
      });
      btnSave_2.setBounds(260, 335, 117, 29);
      addEmployeePanel.add(btnSave_2);
      searchPanel.setLayout(null);

      JLabel lblSearchForUser = new JLabel("Search For User By Name:");
      lblSearchForUser.setBounds(6, 10, 159, 16);
      searchPanel.add(lblSearchForUser);

      uSearchFirstName = new JTextField();
      uSearchFirstName.setBounds(195, 25, 130, 26);      
      searchPanel.add(uSearchFirstName);
      uSearchFirstName.setColumns(10);
      allTextFields.add(uSearchFirstName);

      uSearchLastName = new JTextField();
      uSearchLastName.setBounds(195, 53, 130, 26);
      searchPanel.add(uSearchLastName);
      uSearchLastName.setColumns(10);
      allTextFields.add(uSearchLastName);

      JLabel lblSearchFirstName = new JLabel("First Name:");
      lblSearchFirstName.setBounds(117, 30, 72, 16);
      searchPanel.add(lblSearchFirstName);

      JLabel lblSearchLastName = new JLabel("Last Name:");
      lblSearchLastName.setBounds(117, 58, 70, 16);
      searchPanel.add(lblSearchLastName);



      JButton btnAddWorkSchedule = new JButton("Work Schedule");
      btnAddWorkSchedule.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            addEmployeePanel.setVisible(false);
            loginInfoPanel.setVisible(false);
            createSchedulePanel.setVisible(true);

            if (employeeSearched != null) {
               createdSchedule = ((Trainer) employeeSearched).getSchedule();
               txtDisplayScheduleHere.setText(createdSchedule.toString());
            } else {
               createdSchedule = new Schedule();
            }

         }
      });
      btnAddWorkSchedule.setBounds(69, 293, 156, 29);
      addEmployeePanel.add(btnAddWorkSchedule);

      JButton btnSearch_1 = new JButton("Search");
      btnSearch_1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            if (currentUser.getUserType() == UserType.MANAGER) {
               employeeSearched = GymSystemController.getInstance().searchUser(uSearchFirstName.getText(),
                     uSearchLastName.getText());
               if (employeeSearched == null) {
                  customerSearched = GymSystemController.getInstance().searchCustomer(uSearchFirstName.getText(),
                        uSearchLastName.getText());
                  if (customerSearched == null) {
                     JOptionPane.showMessageDialog(mainMenuPanel, "User not found.");
                     customerSearched = null;
                     employeeSearched = null;
                  } else {
                     street.setText(customerSearched.getPersonalInfo().getAddress().getStreet());
                     state.setText(customerSearched.getPersonalInfo().getAddress().getState());
                     city.setText(customerSearched.getPersonalInfo().getAddress().getCity());
                     zipcode.setText(customerSearched.getPersonalInfo().getAddress().getZipCode());
                     firstName.setText(customerSearched.getPersonalInfo().getFirstName());
                     lastName.setText(customerSearched.getPersonalInfo().getLastName());
                     email.setText(customerSearched.getPersonalInfo().getEmail());
                     phone.setText(customerSearched.getPersonalInfo().getPhone());
                     insurance.setText(customerSearched.getPersonalInfo().getHealthInsuranceProvider());
                     loginInfoPanel.setVisible(false);
                     btnAddWorkSchedule.setVisible(false);
                     lblMembership.setVisible(true);
                     mstatus.setVisible(true);

                  }
               } else {
                  street.setText(employeeSearched.getPersonalInfo().getAddress().getStreet());
                  state.setText(employeeSearched.getPersonalInfo().getAddress().getState());
                  city.setText(employeeSearched.getPersonalInfo().getAddress().getCity());
                  zipcode.setText(employeeSearched.getPersonalInfo().getAddress().getZipCode());
                  firstName.setText(employeeSearched.getPersonalInfo().getFirstName());
                  lastName.setText(employeeSearched.getPersonalInfo().getLastName());
                  email.setText(employeeSearched.getPersonalInfo().getEmail());
                  phone.setText(employeeSearched.getPersonalInfo().getPhone());
                  insurance.setText(employeeSearched.getPersonalInfo().getHealthInsuranceProvider());
                  userName.setText(employeeSearched.getUserInfo().getUserName());
                  password02.setText(employeeSearched.getUserInfo().getPassword());
                  lblMembership.setVisible(false);
                  mstatus.setVisible(false);
                  loginInfoPanel.setVisible(true);
                  if (employeeSearched.getUserType() == UserType.TRAINER) {
                     btnAddWorkSchedule.setVisible(true);
                  }
               }
            } else {
               customerSearched = GymSystemController.getInstance().searchCustomer(uSearchFirstName.getText(),
                     uSearchLastName.getText());
               if (customerSearched == null) {
                  JOptionPane.showMessageDialog(mainMenuPanel, "User not found.");
                  customerSearched = null;
                  employeeSearched = null;
               } else {
                  street.setText(customerSearched.getPersonalInfo().getAddress().getStreet());
                  state.setText(customerSearched.getPersonalInfo().getAddress().getState());
                  city.setText(customerSearched.getPersonalInfo().getAddress().getCity());
                  zipcode.setText(customerSearched.getPersonalInfo().getAddress().getZipCode());
                  firstName.setText(customerSearched.getPersonalInfo().getFirstName());
                  lastName.setText(customerSearched.getPersonalInfo().getLastName());
                  email.setText(customerSearched.getPersonalInfo().getEmail());
                  phone.setText(customerSearched.getPersonalInfo().getPhone());
                  insurance.setText(customerSearched.getPersonalInfo().getHealthInsuranceProvider());
                  loginInfoPanel.setVisible(false);
                  btnAddWorkSchedule.setVisible(false);
                  lblMembership.setVisible(true);
                  mstatus.setVisible(true);
               }
            }
         }
      });
      btnSearch_1.setBounds(337, 45, 85, 29);
      searchPanel.add(btnSearch_1);

      JButton btnRemoveUser = new JButton("Remove User");
      btnRemoveUser.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            Response success = new Response();
            if (employeeSearched != null && employeeSearched.getUserType() == UserType.MANAGER) {
               success = GymSystemController.getInstance().removeManager((Manager) employeeSearched);
            } else if (employeeSearched != null && employeeSearched.getUserType() == UserType.TRAINER) {
               success = GymSystemController.getInstance().removeTrainer((Trainer) employeeSearched);
            } else {
               success = GymSystemController.getInstance().removeCustomer(customerSearched);
            }
            if (!success.successful) {
               JOptionPane.showMessageDialog(mainMenuPanel, success.info);
            } else {
               JOptionPane.showMessageDialog(mainMenuPanel, success.info);

               // clear fields
               clearTextFields();

               customerSearched = null;
               addEmployeePanel.setVisible(false);
               searchEquipPanel_1.setVisible(false);

               if (currentUser.getUserType() == UserType.MANAGER) {
                  ManagerMenu.setVisible(true);
               } else {
                  TrainerMenu.setVisible(true);
               }
            }
         }
      });
      btnRemoveUser.setBounds(488, 45, 117, 29);
      searchPanel.add(btnRemoveUser);

      JLabel lblStartTime = new JLabel("Start Time:");
      lblStartTime.setBounds(67, 45, 92, 16);
      createSchedulePanel.add(lblStartTime);

      JLabel lblEndTime = new JLabel("End Time: ");
      lblEndTime.setBounds(67, 83, 81, 16);
      createSchedulePanel.add(lblEndTime);

      JLabel lblWeekday = new JLabel("Weekday:");
      lblWeekday.setBounds(67, 120, 61, 16);
      createSchedulePanel.add(lblWeekday);

      JComboBox weekday = new JComboBox();
      weekday.setModel(new DefaultComboBoxModel(Weekday.values()));
      weekday.setBounds(155, 116, 136, 27);
      createSchedulePanel.add(weekday);

      startTime = new JTextField();
      startTime.setBounds(155, 40, 130, 26);
      createSchedulePanel.add(startTime);
      startTime.setColumns(10);
      allTextFields.add(startTime);

      endTime = new JTextField();
      endTime.setBounds(155, 78, 130, 26);
      createSchedulePanel.add(endTime);
      endTime.setColumns(10);
      allTextFields.add(endTime);

      txtDisplayScheduleHere = new JTextArea();
      txtDisplayScheduleHere.setBounds(262, 163, 353, 202);
      txtDisplayScheduleHere.setLineWrap(true);
      txtDisplayScheduleHere.setWrapStyleWord(true);
      createSchedulePanel.add(txtDisplayScheduleHere);
      txtDisplayScheduleHere.setColumns(10);

      JButton btnAdd_1 = new JButton("Add");
      btnAdd_1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            WorkTime w =  GymSystemCreator.getInstance().createWorkTime(startTime.getText(), endTime.getText(), (Weekday) weekday.getSelectedItem());
            
            if(w != null)
            {
               createdSchedule.addWorkTime(w);
               txtDisplayScheduleHere.setText(createdSchedule.toString());
            } else {
               JOptionPane.showMessageDialog(mainMenuPanel, "Work Time not valid.");
            }

         }
      });
      btnAdd_1.setBounds(96, 148, 117, 29);
      createSchedulePanel.add(btnAdd_1);

      JLabel lblSchedule = new JLabel("Schedule");
      lblSchedule.setBounds(407, 143, 61, 16);
      createSchedulePanel.add(lblSchedule);

      JButton btnSave = new JButton("Save");
      btnSave.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            if (employeeSearched != null) {
               Trainer t = (Trainer) employeeSearched;
               t.setSchedule(createdSchedule);

               Response success = GymSystemController.getInstance().updateTrainer((Trainer) employeeSearched, t);
               if (success.successful) {
                  JOptionPane.showMessageDialog(mainMenuPanel, success.info);
                  employeeSearched = (Employee) t;
                  startTime.setText("");
                  endTime.setText("");
                  createSchedulePanel.setVisible(false);
                  addEmployeePanel.setVisible(true);
                  loginInfoPanel.setVisible(true);
               } else {
                  JOptionPane.showMessageDialog(mainMenuPanel, success.info);
               }
            } else {
               createSchedulePanel.setVisible(false);
               addEmployeePanel.setVisible(true);
            }

         }
      });
      btnSave.setBounds(67, 336, 117, 29);
      createSchedulePanel.add(btnSave);

      JLabel lblWorkTime = new JLabel("Work Time");
      lblWorkTime.setBounds(132, 17, 75, 16);
      createSchedulePanel.add(lblWorkTime);

      JButton btnReturn = new JButton("Return");
      btnReturn.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            if (currentUser.getUserType() == UserType.MANAGER) {
               LoginPanel.setVisible(false);
               addEquipmentPanel.setVisible(false);
               addEmployeePanel.setVisible(false);
               createWorkoutPanel.setVisible(false);
               createSchedulePanel.setVisible(false);
               classesPanel.setVisible(false);
               currUserClassesPanel.setVisible(false);
               assignRoutinesPanel.setVisible(false);
               
               mainMenuPanel.setVisible(true);
               ManagerMenu.setVisible(true);
               
               
            } else {
            	lblsearchedCustomer.setText("Customer's Workout Routines");
            	assignRoutinesPanel.setVisible(false);
            	classesPanel.setVisible(false);
            	currUserClassesPanel.setVisible(false);
			   LoginPanel.setVisible(false);
			   addEquipmentPanel.setVisible(false);
			   addEmployeePanel.setVisible(false);
			   createWorkoutPanel.setVisible(false);
			   createSchedulePanel.setVisible(false);
			   mainMenuPanel.setVisible(true);              
			   TrainerMenu.setVisible(true);
            }
            clearTextFields();

            txtDisplayScheduleHere.setText("");
            txtListGymRoutines.setText("");
            txtDisplayCustomerInfo.setText("");
         }
      });
      btnReturn.setBackground(Color.LIGHT_GRAY);
      btnReturn.setBounds(0, 2, 117, 29);
      mainMenuPanel.add(btnReturn);
            
                  ManagerMenu = new JPanel();
                  mainMenuPanel.add(ManagerMenu, "name_49214182129467");
                  ManagerMenu.setBounds(0, 53, 637, 385);
                  ManagerMenu.setLayout(null);
                  
                        JButton btnHireManager = new JButton("Hire Manager");
                        btnHireManager.addActionListener(new ActionListener() {
                           public void actionPerformed(ActionEvent e) {
                              newEmployeeType = UserType.MANAGER;
                              ManagerMenu.setVisible(false);
                              addEmployeePanel.setVisible(true);
                              createSchedulePanel.setVisible(false);
                              loginInfoPanel.setVisible(true);
                              searchPanel.setVisible(false);
                              btnRemoveUser.setVisible(false);
                              btnAddWorkSchedule.setVisible(false);
                              lblMembership.setVisible(false);
                              mstatus.setVisible(false);
                              btnAddWorkSchedule.setVisible(false);
                              action = "Add";
                           }
                        });
                        btnHireManager.setBounds(50, 17, 180, 72);
                        ManagerMenu.add(btnHireManager);
                        
                              JButton btnHireTrainer = new JButton("Hire Trainer");
                              btnHireTrainer.addActionListener(new ActionListener() {
                                 public void actionPerformed(ActionEvent e) {
                                    newEmployeeType = UserType.TRAINER;
                                    ManagerMenu.setVisible(false);
                                    addEmployeePanel.setVisible(true);
                                    createSchedulePanel.setVisible(false);
                                    loginInfoPanel.setVisible(true);
                                    searchPanel.setVisible(false);
                                    btnRemoveUser.setVisible(false);
                                    btnAddWorkSchedule.setVisible(true);
                                    lblMembership.setVisible(false);
                                    mstatus.setVisible(false);
                                    btnAddWorkSchedule.setVisible(true);
                                    action = "Add";
                                 }
                              });
                              btnHireTrainer.setBounds(50, 101, 180, 72);
                              ManagerMenu.add(btnHireTrainer);
                              
                                    JButton btnRegisterCustomer_1 = new JButton("Register Customer");
                                    btnRegisterCustomer_1.addActionListener(new ActionListener() {
                                       public void actionPerformed(ActionEvent e) {
                                          newEmployeeType = null;
                                          ManagerMenu.setVisible(false);
                                          addEmployeePanel.setVisible(true);
                                          createSchedulePanel.setVisible(false);
                                          loginInfoPanel.setVisible(false);
                                          searchPanel.setVisible(false);
                                          btnRemoveUser.setVisible(false);
                                          btnAddWorkSchedule.setVisible(false);
                                          lblMembership.setVisible(true);
                                          mstatus.setVisible(true);
                                          btnAddWorkSchedule.setVisible(false);
                                          action = "Add";
                                       }
                                    });
                                    btnRegisterCustomer_1.setBounds(50, 185, 180, 82);
                                    ManagerMenu.add(btnRegisterCustomer_1);
                                    
                                          JButton btnAddEquipmentIventory = new JButton("Add Equipment Iventory");
                                          btnAddEquipmentIventory.addActionListener(new ActionListener() {
                                             public void actionPerformed(ActionEvent e) {
                                                ManagerMenu.setVisible(false);
                                                addEquipmentPanel.setVisible(true);
                                                searchEquipPanel_1.setVisible(false);
                                                btnRemove.setVisible(false);
                                                action = "Add";
                                             }
                                          });
                                          btnAddEquipmentIventory.setBounds(356, 107, 180, 66);
                                          ManagerMenu.add(btnAddEquipmentIventory);
                                          
                                                JButton btnModifyUserInformation = new JButton("Modify User Information");
                                                btnModifyUserInformation.addActionListener(new ActionListener() {
                                                   public void actionPerformed(ActionEvent e) {
                                                      ManagerMenu.setVisible(false);
                                                      addEmployeePanel.setVisible(true);
                                                      loginInfoPanel.setVisible(true);
                                                      searchPanel.setVisible(true);
                                                      btnRemoveUser.setVisible(true);
                                                      btnAddWorkSchedule.setVisible(false);
                                                      lblMembership.setVisible(false);
                                                      mstatus.setVisible(false);
                                                      action = "Update";
                                                   }
                                                });
                                                btnModifyUserInformation.setBounds(356, 20, 180, 66);
                                                ManagerMenu.add(btnModifyUserInformation);
                                                
                                                      JButton btnModifyEquipment = new JButton("Modify Equipment");
                                                      btnModifyEquipment.addActionListener(new ActionListener() {
                                                         public void actionPerformed(ActionEvent e) {
                                                            ManagerMenu.setVisible(false);
                                                            searchEquipPanel_1.setVisible(true);
                                                            addEquipmentPanel.setVisible(true);
                                                            btnRemove.setVisible(true);
                                                            action = "Update";
                                                         }
                                                      });
                                                      btnModifyEquipment.setBounds(356, 196, 180, 71);
                                                      ManagerMenu.add(btnModifyEquipment);
                                                      
                                                      JButton manageClassbtn = new JButton("Manage Classes");
                                                      manageClassbtn.addActionListener(new ActionListener() {
                                                      	public void actionPerformed(ActionEvent e) {
                                                      		ManagerMenu.setVisible(false);
                                                            addEmployeePanel.setVisible(false);
                                                            loginInfoPanel.setVisible(false);
                                                            searchPanel.setVisible(false);
                                                            btnRemoveUser.setVisible(false);
                                                            btnAddWorkSchedule.setVisible(false);
                                                            lblMembership.setVisible(false);
                                                            mstatus.setVisible(false); 
                                                            classesPanel.setVisible(true);
                                                      	}
                                                      });
                                                      manageClassbtn.setBounds(50, 279, 180, 82);
                                                      ManagerMenu.add(manageClassbtn);
                                                      ManagerMenu.setVisible(false);
      
            TrainerMenu = new JPanel();
            mainMenuPanel.add(TrainerMenu, "name_49214182129467");
            TrainerMenu.setBounds(0, 53, 637, 385);
            TrainerMenu.setLayout(null);
            
                  JButton btnCreateWorkout = new JButton("Workout Routines");
                  btnCreateWorkout.addActionListener(new ActionListener() {
                     public void actionPerformed(ActionEvent e) {
                        TrainerMenu.setVisible(false);
                        createWorkoutPanel.setVisible(true);
                     }
                  });
                  btnCreateWorkout.setBounds(72, 227, 203, 77);
                  TrainerMenu.add(btnCreateWorkout);
                  
                        JButton btnRegisterCustomer = new JButton("Register Customer");
                        btnRegisterCustomer.addActionListener(new ActionListener() {
                           public void actionPerformed(ActionEvent e) {
                              newEmployeeType = null;
                              TrainerMenu.setVisible(false);
                              addEmployeePanel.setVisible(true);
                              loginInfoPanel.setVisible(false);
                              searchPanel.setVisible(false);
                              btnRemoveUser.setVisible(false);
                              btnAddWorkSchedule.setVisible(false);
                              lblMembership.setVisible(true);
                              mstatus.setVisible(true);
                              btnAddWorkSchedule.setVisible(false);
                              action = "Add";
                           }
                        });
                        btnRegisterCustomer.setBounds(72, 18, 203, 85);
                        TrainerMenu.add(btnRegisterCustomer);
                        
                              JButton btnAddEquipmentInventory = new JButton("Add Equipment Inventory");
                              btnAddEquipmentInventory.addActionListener(new ActionListener() {
                                 public void actionPerformed(ActionEvent e) {
                                    TrainerMenu.setVisible(false);
                                    addEquipmentPanel.setVisible(true);
                                    searchEquipPanel_1.setVisible(false);
                                    btnRemove.setVisible(false);
                                    action = "Add";
                                 }
                              });
                              btnAddEquipmentInventory.setBounds(72, 123, 203, 77);
                              TrainerMenu.add(btnAddEquipmentInventory);
                              
                                    JButton btnModifyCustomerInformation = new JButton("Modify Customer Information");
                                    btnModifyCustomerInformation.addActionListener(new ActionListener() {
                                       public void actionPerformed(ActionEvent e) {
                                          newEmployeeType = UserType.MANAGER;
                                          TrainerMenu.setVisible(false);
                                          addEmployeePanel.setVisible(true);
                                          loginInfoPanel.setVisible(false);
                                          searchPanel.setVisible(true);
                                          btnAddWorkSchedule.setVisible(false);
                                          lblMembership.setVisible(true);
                                          mstatus.setVisible(true);
                                          action = "Update";
                                       }
                                    });
                                    btnModifyCustomerInformation.setBounds(344, 18, 210, 85);
                                    TrainerMenu.add(btnModifyCustomerInformation);
                                    
                                          JButton btnModifyEquipment_1 = new JButton("Modify Equipment");
                                          btnModifyEquipment_1.addActionListener(new ActionListener() {
                                             public void actionPerformed(ActionEvent e) {
                                                TrainerMenu.setVisible(false);
                                                searchEquipPanel_1.setVisible(true);
                                                addEquipmentPanel.setVisible(true);
                                                btnRemove.setVisible(true);
                                                action = "Update";
                                             }
                                          });
                                          btnModifyEquipment_1.setBounds(344, 123, 210, 77);
                                          TrainerMenu.add(btnModifyEquipment_1);
                                          
                                          JButton btnViewClasses = new JButton("View Classes");
                                          btnViewClasses.addActionListener(new ActionListener() {
                                          	public void actionPerformed(ActionEvent e) {
                                          		TrainerMenu.setVisible(false);
                                          		currUserClassesPanel.setVisible(true);
                                          	}
                                          });
                                          btnViewClasses.setBounds(344, 227, 210, 77);
                                          TrainerMenu.add(btnViewClasses);
                                          TrainerMenu.setVisible(false);

      JButton btnLogin = new JButton("Login");
      btnLogin.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            Employee user = GymSystemController.getInstance().authenticateUser(loginUsername.getText(),
                  loginPassword.getText());
            if (user == null) {
               JOptionPane.showMessageDialog(LoginPanel, "Invalid Login.");
               loginPassword.setText("");
            } else {
               currentUser = user;
               if (currentUser.getUserType() == UserType.MANAGER) {
                  LoginPanel.setVisible(false);
                  addEquipmentPanel.setVisible(false);
                  addEmployeePanel.setVisible(false);
                  createWorkoutPanel.setVisible(false);
                  classesPanel.setVisible(false);
                  currUserClassesPanel.setVisible(false);
                  createSchedulePanel.setVisible(false);
                  mainMenuPanel.setVisible(true);
                  ManagerMenu.setVisible(true);
               } else {
                  LoginPanel.setVisible(false);
                  classesPanel.setVisible(false);
                  createSchedulePanel.setVisible(false);
                  addEquipmentPanel.setVisible(false);
                  addEmployeePanel.setVisible(false);
                  createWorkoutPanel.setVisible(false);
                  currUserClassesPanel.setVisible(false);
                  mainMenuPanel.setVisible(true);
                  TrainerMenu.setVisible(true);
               }
               loginUsername.setText("");
               loginPassword.setText("");
            }

         }
      });
      btnLogin.setBounds(280, 228, 79, 29);
      LoginPanel.add(btnLogin);

   }

   public JFrame getFrame() {
      return frame;
   }

   public void setFrame(JFrame frame) {
      this.frame = frame;
   }
}
