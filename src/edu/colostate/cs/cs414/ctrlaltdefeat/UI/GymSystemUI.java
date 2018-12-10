package edu.colostate.cs.cs414.ctrlaltdefeat.UI;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
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
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.UserInfo.TimeOfDay;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.UserInfo.Weekday;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.UserInfo.WorkTime;
import edu.colostate.cs.cs414.ctrlaltdefeat.System.GymSystemController;
import edu.colostate.cs.cs414.ctrlaltdefeat.System.GymSystemCreator;
import edu.colostate.cs.cs414.ctrlaltdefeat.System.Response;

public class GymSystemUI {

   Employee currentUser = null;
   Employee employeeSearched = null;
   Customer customerSearched = null;
   Equipment equipmentSearched = null;
   ArrayList<JTextField> userInfoTextFields = new ArrayList<JTextField>();
   ArrayList<JTextField> allTextFields = new ArrayList<JTextField>();
   ArrayList<Exercise> newExercises = new ArrayList<Exercise>();
   UserType newEmployeeType = null;
   String action = "";
   Schedule createdSchedule = null;
   Schedule classSchedule = null;
   FitnessClass searchedClass = null;

   private JFrame frame;
   private JPanel contentPane;
   private JPanel LoginPanel;
   private JPanel mainMenuPanel;
   private JPanel ManagerMenu;
   private JPanel TrainerMenu;
   private JPanel addEmployeePanel;
   private JPanel addEquipmentPanel;
   private JPanel assignWorkoutPanel;
   private JPanel createSchedulePanel;
   private JPanel createWorkoutsPanel;
   private JPanel loginInfoPanel;
   private JPanel searchPanel;
   private JPanel searchEquipPanel;
   private JPanel classesPanel;

   private JTextField loginUsername;
   private JPasswordField loginPassword;
   private JTextField equipmentName;
   private JTextField equipmentQuantity;
   private JTextField eqPicturePath;
   private JTextField searchEquipName;
   private JTextField uSearchFirstName;
   private JTextField workoutName;
   private JTextField exSearchFName;
   private JTextField exSearchLName;
   private JTextArea txtDisplayCustomerInfo;
   private JTextArea txtListAllWorkoutsHere;
   private JTextField uSearchLastName;
   private JTextArea txtDisplayScheduleHere;
   private ImageIcon image;
   private JLabel imageLabel;
   private JTextField exerciseName;
   private JTextField numSets;
   private JTextField numReps;
   private JTextField nameExercise;
   private JTextField equipmentExercise;
   private JTextField workoutName_2;
   private JTextArea listExercisesHere;
   private JTextArea listWorkoutRoutinesHere;

   private JComboBox customersComboBox;
   private JComboBox ClassListComboBox;
   private JComboBox trainersComboBox;
   private JComboBox classWeekday;
   private JComboBox assignedClassesComboBox;

   private JTextArea classTimesField;
   private JTextArea classScheculetextArea;
   private JTextField classNameField;
   private JTextField maxClassSizeField;
   private JTextArea classAttendeesField;
   private JPanel currUserClassesPanel;

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

      for (JTextField tf : allTextFields) {
         tf.setText("");
      }

      txtDisplayScheduleHere.setText("");
      txtListAllWorkoutsHere.setText("");
      txtDisplayCustomerInfo.setText("");
      listExercisesHere.setText("");
      listWorkoutRoutinesHere.setText("");

      imageLabel.setIcon(null);
   }

   void makeAllPanelsNotVisible() {
      mainMenuPanel.setVisible(true);
      LoginPanel.setVisible(false);
      addEquipmentPanel.setVisible(false);
      addEmployeePanel.setVisible(false);
      assignWorkoutPanel.setVisible(false);
      createWorkoutsPanel.setVisible(false);
      createSchedulePanel.setVisible(false);
      ManagerMenu.setVisible(false);
      TrainerMenu.setVisible(false);
      loginInfoPanel.setVisible(false);
      searchPanel.setVisible(false);
      searchEquipPanel.setVisible(false);
      classesPanel.setVisible(false);
      currUserClassesPanel.setVisible(false);
   }

   void findClassesforUser() {
      /***/
      assignedClassesComboBox.addItem("");
      if (GymSystemController.getInstance().getGymClasses() != null) {// &&
                                                                      // currentUser.getUserType().equals(UserType.TRAINER))
                                                                      // {
         for (FitnessClass fc : GymSystemController.getInstance().getGymClasses()) {
            if (fc.getInstructor().equals(currentUser)) {
               assignedClassesComboBox.addItem(fc.getName());
            }
         }
      }
      assignedClassesComboBox.setBounds(257, 58, 120, 27);
      currUserClassesPanel.add(assignedClassesComboBox);

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
      loginPassword = new JPasswordField();
      loginPassword.setBounds(270, 190, 168, 26);
      loginPassword.setColumns(10);
      loginPassword.setEchoChar('*');
      LoginPanel.add(loginUsername);
      LoginPanel.add(loginPassword);

      // Main Menu Panel
      mainMenuPanel = new JPanel();
      contentPane.add(mainMenuPanel, "name_49214182129467");
      mainMenuPanel.setLayout(null);
      mainMenuPanel.setVisible(false);

      JLabel lblMainMenu = new JLabel("Main Menu");
      lblMainMenu.setBounds(272, 20, 95, 21);
      lblMainMenu.setFont(new Font("Lucida Grande", Font.BOLD, 17));
      mainMenuPanel.add(lblMainMenu);

      currUserClassesPanel = new JPanel();
      currUserClassesPanel.setBounds(0, 71, 639, 367);
      mainMenuPanel.add(currUserClassesPanel);
      currUserClassesPanel.setLayout(null);

      JLabel lblAssignedClasses = new JLabel("Assigned Classes");
      lblAssignedClasses.setBounds(257, 19, 120, 16);
      currUserClassesPanel.add(lblAssignedClasses);

      classScheculetextArea = new JTextArea();
      classScheculetextArea.setEditable(false);
      classScheculetextArea.setBounds(108, 137, 418, 191);
      currUserClassesPanel.add(classScheculetextArea);

      // Manage Fitness Classes Panel

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

      JLabel lblClassAttendees = new JLabel("Class Attendees:");
      lblClassAttendees.setBounds(378, 105, 117, 16);
      classesPanel.add(lblClassAttendees);

      JLabel lblCustomers = new JLabel("Customers:");
      lblCustomers.setBounds(378, 23, 86, 16);
      classesPanel.add(lblCustomers);
      ClassListComboBox = new JComboBox();
      customersComboBox = new JComboBox();
      customersComboBox.setBounds(476, 19, 157, 27);
      customersComboBox.addItem("");
      classesPanel.add(customersComboBox);
      if (GymSystemController.getInstance().getCustomers() != null) {
         for (Customer c : GymSystemController.getInstance().getCustomers()) {
            customersComboBox.addItem(c.getPersonalInfo().getFirstName() + " " + c.getPersonalInfo().getLastName());
         }
      }
      ClassListComboBox.addItem("");
      if (GymSystemController.getInstance().getGymClasses() != null) {
         for (FitnessClass fc : GymSystemController.getInstance().getGymClasses()) {
            ClassListComboBox.addItem(fc.getName());

         }
      }
      classAttendeesField = new JTextArea();
      classAttendeesField.setBounds(398, 133, 188, 218);
      classAttendeesField.setWrapStyleWord(true);
      classAttendeesField.setLineWrap(true);
      classesPanel.add(classAttendeesField);
      JButton btnAddAttendee = new JButton("Add");
      btnAddAttendee.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            if (!customersComboBox.getSelectedItem().equals("")) {
               String[] name = customersComboBox.getSelectedItem().toString().split(" ");
               Customer c = GymSystemController.getInstance().searchCustomer(name[0], name[1]);
               FitnessClass fc = GymSystemController.getInstance().searchGymClasses(classNameField.getText());
               if (c != null) {
                  if (fc != null) {
                     fc.addAttendee(c);
                     classAttendeesField.removeAll();
                     String cList = "";
                     for (Customer customer : fc.getAttendees()) {
                        cList += customer.getPersonalInfo().getFirstName() + " "
                              + customer.getPersonalInfo().getLastName() + " \n";
                     }
                     classAttendeesField.setText(cList);

                  } else {
                     JOptionPane.showMessageDialog(mainMenuPanel, "Class does not exist in the system.");
                  }
               } else {
                  JOptionPane.showMessageDialog(mainMenuPanel, "Customer does not exist in the system.");
               }
            } else {
               JOptionPane.showMessageDialog(mainMenuPanel, "No Customer selected");
            }

         }
      });
      btnAddAttendee.setBounds(378, 71, 117, 29);
      classesPanel.add(btnAddAttendee);

      JButton btnRemoveAttendee = new JButton("Remove");
      btnRemoveAttendee.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            if (!customersComboBox.getSelectedItem().equals("")) {
               String[] name = customersComboBox.getSelectedItem().toString().split(" ");
               Customer c = GymSystemController.getInstance().searchCustomer(name[0], name[1]);
               FitnessClass fc = GymSystemController.getInstance().searchGymClasses(classNameField.getText());
               if (c != null) {
                  if (fc != null) {
                     fc.removeAttendee(c);
                     classAttendeesField.removeAll();
                     String cList = "";
                     for (Customer customer : fc.getAttendees()) {
                        cList += customer.getPersonalInfo().getFirstName() + " "
                              + customer.getPersonalInfo().getLastName() + " \n";
                     }
                     classAttendeesField.setText(cList);

                  } else {
                     JOptionPane.showMessageDialog(mainMenuPanel, "Class does not exist in the system.");
                  }
               } else {
                  JOptionPane.showMessageDialog(mainMenuPanel, "Customer does not exist in the system.");
               }
            } else {
               JOptionPane.showMessageDialog(mainMenuPanel, "No Customer selected");
            }

         }
      });
      btnRemoveAttendee.setBounds(507, 71, 117, 29);
      classesPanel.add(btnRemoveAttendee);

      assignedClassesComboBox = new JComboBox();
      assignedClassesComboBox.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            if (!assignedClassesComboBox.getSelectedItem().equals("")) {
               FitnessClass fClass = GymSystemController.getInstance()
                     .searchGymClasses(assignedClassesComboBox.getSelectedItem().toString());
               classScheculetextArea.setText(fClass.getClassSchedule().toString());
            }
         }
      });

      trainersComboBox = new JComboBox();
      trainersComboBox.setBounds(142, 73, 162, 27);
      classesPanel.add(trainersComboBox);
      trainersComboBox.addItem("");

      classNameField = new JTextField();
      classNameField.setBounds(142, 44, 160, 26);
      classesPanel.add(classNameField);
      classNameField.setColumns(10);

      JComboBox classStartField = new JComboBox();
      classStartField.setModel(new DefaultComboBoxModel(TimeOfDay.values()));
      classStartField.setBounds(90, 161, 112, 27);
      classesPanel.add(classStartField);

      JComboBox classEndField = new JComboBox();
      classEndField.setModel(new DefaultComboBoxModel(TimeOfDay.values()));
      classEndField.setBounds(90, 189, 112, 27);
      classesPanel.add(classEndField);

      maxClassSizeField = new JTextField();
      maxClassSizeField.setColumns(10);
      maxClassSizeField.setBounds(144, 100, 160, 26);
      classesPanel.add(maxClassSizeField);

      JButton btnSave_Class = new JButton("Save");
      btnSave_Class.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            FitnessClass oldfitnessClass = GymSystemController.getInstance().searchGymClasses(classNameField.getText());
            Response success;
            if (classSchedule == null) {
               classSchedule = searchedClass.getClassSchedule();
            }
            // create new class
            if (!trainersComboBox.getSelectedItem().toString().equals("") && !classNameField.equals("")
                  && classSchedule != null && !maxClassSizeField.getText().equals("")) {

               String[] temp = trainersComboBox.getSelectedItem().toString().split(", ");
               Trainer classTrainer = (Trainer) GymSystemController.getInstance().searchUser(temp[1], temp[0]);

               FitnessClass newFitnessClass = GymSystemCreator.getInstance().createFitnessClass(
                     classNameField.getText(), classTrainer, classSchedule, maxClassSizeField.getText());
               if (oldfitnessClass != null) {
                  success = GymSystemController.getInstance().updateFitnessClass(oldfitnessClass, newFitnessClass);
               } else {
                  success = GymSystemController.getInstance().addGymClass(newFitnessClass);
               }

               if (success.successful) {
                  JOptionPane.showMessageDialog(mainMenuPanel, "Gym class successfully saved.");
                  trainersComboBox.setSelectedItem("");
                  classNameField.setText("");
                  classSchedule = null;
                  classTimesField.setText("");
                  maxClassSizeField.setText("");

                  if (oldfitnessClass == null) {
                     ClassListComboBox.addItem(newFitnessClass.getName());
                  }
               } else {
                  JOptionPane.showMessageDialog(mainMenuPanel, "Unable to save Gym Class.");
               }
            } else {
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
            if (!ClassListComboBox.getSelectedItem().toString().equals("")) {
               FitnessClass fitnessClass = GymSystemController.getInstance()
                     .searchGymClasses(ClassListComboBox.getSelectedItem().toString());

               Response success = GymSystemController.getInstance().removeGymClass(fitnessClass);
               if (success.successful) {
                  JOptionPane.showMessageDialog(mainMenuPanel, "Gym class successfully deleted.");
                  trainersComboBox.setSelectedItem("");
                  classNameField.setText("");
                  classSchedule = null;
                  classTimesField.setText("");
                  maxClassSizeField.setText("");
                  ClassListComboBox.removeItem(fitnessClass.getName());
                  classAttendeesField.setText("");

               } else {
                  JOptionPane.showMessageDialog(mainMenuPanel, "Unable to delete Gym Class.");
               }
            } else {
               JOptionPane.showMessageDialog(mainMenuPanel, "Select a class to delete");
            }

         }

      });
      classesPanel.add(btnRemove_Class);

      JLabel lblClasses = new JLabel("Classes:");
      lblClasses.setBounds(6, 19, 61, 16);
      classesPanel.add(lblClasses);

      ClassListComboBox.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            if (ClassListComboBox.getSelectedItem().toString() != null
                  && !ClassListComboBox.getSelectedItem().toString().equals("")) {
               FitnessClass fc = GymSystemController.getInstance()
                     .searchGymClasses(ClassListComboBox.getSelectedItem().toString());
               if (fc != null) {
                  searchedClass = fc;
                  classNameField.setText(fc.getName());
                  trainersComboBox.setSelectedItem(fc.getInstructor().getPersonalInfo().getLastName() + ", "
                        + fc.getInstructor().getPersonalInfo().getFirstName());
                  maxClassSizeField.setText(fc.getMaxClassSize().toString());
                  classTimesField.setText(fc.getClassSchedule().toString());
                  String attendees = "";
                  for (Customer c : fc.getAttendees()) {
                     attendees += c.getPersonalInfo().getFirstName() + " " + c.getPersonalInfo().getLastName() + "\n";
                  }
                  classAttendeesField.setText(attendees);
               } else {
                  JOptionPane.showMessageDialog(mainMenuPanel, "Fitness Class does not exist in the system.");
               }
            } else {
               classNameField.setText("");
               trainersComboBox.setSelectedItem("");
               maxClassSizeField.setText("");
               classTimesField.setText("");
               classTimesField.setText("");
               classAttendeesField.setText("");
            }
         }
      });
      ClassListComboBox.setBounds(142, 15, 157, 27);
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

      classTimesField = new JTextArea();
      classTimesField.setWrapStyleWord(true);
      classTimesField.setLineWrap(true);
      classTimesField.setColumns(10);
      classTimesField.setBounds(90, 228, 276, 123);
      classesPanel.add(classTimesField);

      JButton btnAdd_Time = new JButton("Add");
      btnAdd_Time.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            FitnessClass fc = GymSystemController.getInstance().searchGymClasses(classNameField.getText());
            WorkTime w = GymSystemCreator.getInstance().createWorkTime((TimeOfDay) classStartField.getSelectedItem(),
                  (TimeOfDay) classEndField.getSelectedItem(), (Weekday) classWeekday.getSelectedItem());
            if (searchedClass != null && searchedClass.getClassSchedule() != null && fc != null) {
               classSchedule = searchedClass.getClassSchedule();
            } else if (classTimesField.getText() != null && classTimesField.getText().equals("")) {
               classSchedule = new Schedule();
            }

            if (w != null) {
               classSchedule.addWorkTime(w);
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
            WorkTime w = GymSystemCreator.getInstance().createWorkTime((TimeOfDay) classStartField.getSelectedItem(),
                  (TimeOfDay) classEndField.getSelectedItem(), (Weekday) classWeekday.getSelectedItem());
            
            if (searchedClass.getClassSchedule() != null) {
               classSchedule = searchedClass.getClassSchedule();
            }
            if (w != null) {
               classSchedule.removeWorkTime(w);
               classTimesField.setText(classSchedule.toString());
            } else {
               JOptionPane.showMessageDialog(mainMenuPanel, "Work Time not valid.");
            }
         }
      });
      btnRemove_Time.setBounds(6, 304, 86, 29);
      classesPanel.add(btnRemove_Time);

      createWorkoutsPanel = new JPanel();
      createWorkoutsPanel.setBounds(0, 53, 639, 391);
      mainMenuPanel.add(createWorkoutsPanel);
      createWorkoutsPanel.setLayout(null);

      JLabel lblExerciseName = new JLabel("Exercise Name:");
      lblExerciseName.setBounds(6, 8, 96, 16);
      createWorkoutsPanel.add(lblExerciseName);

      JLabel lblNumReps = new JLabel("Number of Repititions:");
      lblNumReps.setBounds(6, 64, 169, 16);
      createWorkoutsPanel.add(lblNumReps);

      JLabel lblNumSets = new JLabel("Number of Sets:");
      lblNumSets.setBounds(6, 36, 149, 16);
      createWorkoutsPanel.add(lblNumSets);

      exerciseName = new JTextField();
      exerciseName.setColumns(10);
      exerciseName.setBounds(114, 3, 130, 26);
      createWorkoutsPanel.add(exerciseName);
      allTextFields.add(exerciseName);

      numSets = new JTextField();
      numSets.setColumns(10);
      numSets.setBounds(114, 31, 130, 26);
      createWorkoutsPanel.add(numSets);
      allTextFields.add(numSets);

      numReps = new JTextField();
      numReps.setColumns(10);
      numReps.setBounds(152, 59, 92, 26);
      createWorkoutsPanel.add(numReps);
      allTextFields.add(numReps);

      nameExercise = new JTextField();
      nameExercise.setColumns(10);
      nameExercise.setBounds(326, 172, 130, 26);
      createWorkoutsPanel.add(nameExercise);
      allTextFields.add(nameExercise);

      equipmentExercise = new JTextField();
      equipmentExercise.setBounds(84, 92, 160, 27);
      createWorkoutsPanel.add(equipmentExercise);
      allTextFields.add(equipmentExercise);

      listWorkoutRoutinesHere = new JTextArea();
      listWorkoutRoutinesHere.setWrapStyleWord(true);
      listWorkoutRoutinesHere.setLineWrap(true);
      listWorkoutRoutinesHere.setColumns(10);
      listWorkoutRoutinesHere.setBounds(11, 230, 616, 122);
      createWorkoutsPanel.add(listWorkoutRoutinesHere);

      listExercisesHere = new JTextArea();
      listExercisesHere.setWrapStyleWord(true);
      listExercisesHere.setLineWrap(true);
      listExercisesHere.setColumns(10);
      listExercisesHere.setBounds(256, 6, 366, 154);
      createWorkoutsPanel.add(listExercisesHere);

      JButton btnAddExercise = new JButton("Add Exercise");
      btnAddExercise.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            Exercise exercise = GymSystemCreator.getInstance().createExercise(exerciseName.getText(), numReps.getText(),
                  numSets.getText(), equipmentExercise.getText());
            if (exercise != null) {
               Response success = GymSystemController.getInstance().addExercise(exercise);

               if (success.successful) {
                  JOptionPane.showMessageDialog(mainMenuPanel, success.info);

                  String s = "";

                  for (Exercise ex : GymSystemController.getInstance().getExercises()) {
                     s += ex.toString() + "\n";
                  }

                  listExercisesHere.setText(s);
               } else {
                  JOptionPane.showMessageDialog(mainMenuPanel, success.info);
               }
            } else {
               JOptionPane.showMessageDialog(mainMenuPanel, "Invalid Exercise Information.");
            }
         }
      });
      btnAddExercise.setBounds(6, 131, 106, 29);
      createWorkoutsPanel.add(btnAddExercise);

      JLabel lblWorkout = new JLabel("Workout Routine:");
      lblWorkout.setBounds(6, 177, 117, 16);
      createWorkoutsPanel.add(lblWorkout);

      workoutName_2 = new JTextField();
      workoutName_2.setColumns(10);
      workoutName_2.setBounds(114, 172, 130, 26);
      createWorkoutsPanel.add(workoutName_2);
      allTextFields.add(workoutName_2);

      JButton btnAddtoWorkout = new JButton("Add to Workout Routine");
      btnAddtoWorkout.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            Exercise exercise = GymSystemController.getInstance().searchExercise(nameExercise.getText());
            if (exercise != null) {
               WorkoutRoutine searchedWorkout = GymSystemController.getInstance()
                     .searchWorkoutRoutine(workoutName_2.getText());
               if (searchedWorkout == null) {
                  WorkoutRoutine workout = GymSystemCreator.getInstance().createWorkoutRoutine(workoutName_2.getText(),
                        exercise);
                  if (workout != null) {
                     Response success = GymSystemController.getInstance().addWorkoutRoutine(workout);

                     if (success.successful) {
                        JOptionPane.showMessageDialog(mainMenuPanel, success.info);

                        String s = "";

                        for (WorkoutRoutine wr : GymSystemController.getInstance().getWorkoutRoutines()) {
                           s += wr.toString() + "\n";
                        }

                        listWorkoutRoutinesHere.setText(s);
                     } else {
                        JOptionPane.showMessageDialog(mainMenuPanel, success.info);
                     }
                  } else {
                     JOptionPane.showMessageDialog(mainMenuPanel, "Invalid Workout Name Information.");
                  }
               } else {
                  Response success = GymSystemController.getInstance().addExerciseToWorkout(exercise, searchedWorkout);

                  if (success.successful) {
                     JOptionPane.showMessageDialog(mainMenuPanel, success.info);

                     String s = "";

                     for (WorkoutRoutine wr : GymSystemController.getInstance().getWorkoutRoutines()) {
                        s += wr.toString() + "\n";
                     }

                     listWorkoutRoutinesHere.setText(s);
                  } else {
                     JOptionPane.showMessageDialog(mainMenuPanel, success.info);
                  }
               }

            } else {
               JOptionPane.showMessageDialog(mainMenuPanel, "Exercise not in system.");
            }
         }
      });
      btnAddtoWorkout.setBounds(173, 203, 205, 26);
      createWorkoutsPanel.add(btnAddtoWorkout);

      JLabel lblEquipment = new JLabel("Equipment:");
      lblEquipment.setBounds(6, 92, 149, 16);
      createWorkoutsPanel.add(lblEquipment);

      JButton btn_done = new JButton("Done");
      btn_done.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            makeAllPanelsNotVisible();
            clearTextFields();
            TrainerMenu.setVisible(true);
         }
      });
      btn_done.setBounds(261, 356, 117, 29);
      createWorkoutsPanel.add(btn_done);

      JLabel lblWorkExer = new JLabel("Exercise:");
      lblWorkExer.setBounds(266, 177, 96, 16);
      createWorkoutsPanel.add(lblWorkExer);

      JButton btnRemoveExercise = new JButton("Remove Exercise");
      btnRemoveExercise.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            Exercise exercise = GymSystemController.getInstance().searchExercise(exerciseName.getText());
            if (exercise != null) {
               Response success = GymSystemController.getInstance().removeExercise(exercise);

               if (success.successful) {
                  JOptionPane.showMessageDialog(mainMenuPanel, success.info);

                  String s = "";

                  for (Exercise ex : GymSystemController.getInstance().getExercises()) {
                     s += ex.toString() + "\n";
                  }

                  listExercisesHere.setText(s);
                  
                  String s2 = "";

                  for (WorkoutRoutine wr : GymSystemController.getInstance().getWorkoutRoutines()) {
                     s2 += wr.toString() + "\n";
                  }

                  listWorkoutRoutinesHere.setText(s2);
                  
               } else {
                  JOptionPane.showMessageDialog(mainMenuPanel, success.info);
               }
            } else {
               JOptionPane.showMessageDialog(mainMenuPanel, "Exercise does not exist.");
            }
         }
      });
      btnRemoveExercise.setBounds(114, 131, 130, 29);
      createWorkoutsPanel.add(btnRemoveExercise);

      JButton btnRemoveFromWorkout = new JButton("Remove Workout Routine");
      btnRemoveFromWorkout.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            WorkoutRoutine searchedWorkout = GymSystemController.getInstance()
                  .searchWorkoutRoutine(workoutName_2.getText());
            if (searchedWorkout != null) {
               Response success = GymSystemController.getInstance().removeWorkoutRoutine(searchedWorkout);

               if (success.successful) {
                  JOptionPane.showMessageDialog(mainMenuPanel, success.info);

                  String s = "";

                  for (WorkoutRoutine wr : GymSystemController.getInstance().getWorkoutRoutines()) {
                     s += wr.toString() + "\n";
                  }

                  listWorkoutRoutinesHere.setText(s);
               } else {
                  JOptionPane.showMessageDialog(mainMenuPanel, success.info);
               }
            } else {
               JOptionPane.showMessageDialog(mainMenuPanel, "Workout routine not in system");
            }
         }
      });
      btnRemoveFromWorkout.setBounds(391, 202, 236, 29);
      createWorkoutsPanel.add(btnRemoveFromWorkout);

      createSchedulePanel = new JPanel();
      createSchedulePanel.setBounds(0, 71, 637, 367);
      mainMenuPanel.add(createSchedulePanel);
      createSchedulePanel.setLayout(null);

      assignWorkoutPanel = new JPanel();
      assignWorkoutPanel.setBounds(0, 53, 639, 391);
      mainMenuPanel.add(assignWorkoutPanel);
      assignWorkoutPanel.setLayout(null);

      JButton btnLogout = new JButton("Logout");
      btnLogout.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            // logout of system
            JOptionPane.showMessageDialog(mainMenuPanel, "Successfully logged out.");
            makeAllPanelsNotVisible();
            mainMenuPanel.setVisible(false);
            LoginPanel.setVisible(true);

            clearTextFields();

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

      addEquipmentPanel = new JPanel();
      addEquipmentPanel.setBounds(0, 53, 637, 385);
      mainMenuPanel.add(addEquipmentPanel);
      addEquipmentPanel.setLayout(null);

      searchPanel = new JPanel();
      searchPanel.setBounds(0, 6, 631, 82);
      addEmployeePanel.add(searchPanel);

      loginInfoPanel = new JPanel();
      loginInfoPanel.setBounds(310, 230, 251, 99);
      addEmployeePanel.add(loginInfoPanel);
      loginInfoPanel.setLayout(null);

      searchEquipPanel = new JPanel();
      searchEquipPanel.setBounds(0, 55, 631, 71);
      addEquipmentPanel.add(searchEquipPanel);

      image = new ImageIcon("");
      imageLabel = new JLabel(image);
      imageLabel.setBounds(337, 138, 275, 207);
      addEquipmentPanel.add(imageLabel);

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
            Address address = GymSystemCreator.getInstance().createAddress(street.getText(), state.getText(),
                  city.getText(), zipcode.getText());
            PersonalInformation pi = GymSystemCreator.getInstance().createPI(firstName.getText(), lastName.getText(),
                  email.getText(), phone.getText(), insurance.getText(), address);
            if (pi != null) {
               Response success = new Response();
               User u = GymSystemCreator.getInstance().createUser(userName.getText(), password02.getText());

               if (action.equals("Add") && newEmployeeType == UserType.MANAGER) {
                  Manager m = GymSystemCreator.getInstance().createManager(u, pi);
                  if (m != null) {
                     success = GymSystemController.getInstance().addManager(m);
                  } else {
                     success.info = "Failed to create manager.";
                  }

               } else if (action.equals("Update") && employeeSearched != null
                     && employeeSearched.getUserType() == UserType.MANAGER) {
                  Manager m = GymSystemCreator.getInstance().createManager(u, pi);
                  success = GymSystemController.getInstance().updateManager((Manager) employeeSearched, m);
               } else if (action.equals("Add") && newEmployeeType == UserType.TRAINER) {
                  Trainer t = GymSystemCreator.getInstance().createTrainer(u, pi);
                  if (t != null) {
                     t.setSchedule(createdSchedule);
                     success = GymSystemController.getInstance().addTrainer(t);
                  } else {
                     success.info = "Failed to create trainer.";
                  }
               } else if (action.equals("Update") && employeeSearched != null
                     && employeeSearched.getUserType() == UserType.TRAINER) {
                  Trainer t = GymSystemCreator.getInstance().createTrainer(u, pi);
                  t.setSchedule(createdSchedule);
                  success = GymSystemController.getInstance().updateTrainer((Trainer) employeeSearched, t);
               } else if (action.equals("Add") && customerSearched == null) {
                  Customer c = GymSystemCreator.getInstance().createCustomer(pi);
                  if (c != null) {
                     c.setStatus((MembershipStatus) mstatus.getSelectedItem());
                     success = GymSystemController.getInstance().addCustomer(c);
                  } else {
                     success.info = "Failed to create customer.";
                  }

               } else if (action.equals("Update") && customerSearched != null) {
                  Customer c = GymSystemCreator.getInstance().createCustomer(pi);
                  c.setStatus((MembershipStatus) mstatus.getSelectedItem());
                  success = GymSystemController.getInstance().updateCustomer(customerSearched, c);
               }

               if (!success.successful) {
                  JOptionPane.showMessageDialog(mainMenuPanel, success.info);
               } else {
                  JOptionPane.showMessageDialog(mainMenuPanel, success.info);

                  clearTextFields();

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

            } else {
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
            makeAllPanelsNotVisible();
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

               clearTextFields();
               makeAllPanelsNotVisible();

               customerSearched = null;

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

      JComboBox startTime = new JComboBox();
      startTime.setModel(new DefaultComboBoxModel(TimeOfDay.values()));
      startTime.setBounds(155, 40, 130, 26);
      createSchedulePanel.add(startTime);

      JComboBox endTime = new JComboBox();
      endTime.setModel(new DefaultComboBoxModel(TimeOfDay.values()));
      endTime.setBounds(155, 78, 130, 26);
      createSchedulePanel.add(endTime);

      txtDisplayScheduleHere = new JTextArea();
      txtDisplayScheduleHere.setBounds(262, 163, 353, 202);
      txtDisplayScheduleHere.setLineWrap(true);
      txtDisplayScheduleHere.setWrapStyleWord(true);
      createSchedulePanel.add(txtDisplayScheduleHere);
      txtDisplayScheduleHere.setColumns(10);

      JButton btnAdd_1 = new JButton("Add");
      btnAdd_1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            WorkTime w = GymSystemCreator.getInstance().createWorkTime((TimeOfDay) startTime.getSelectedItem(),
                  (TimeOfDay) endTime.getSelectedItem(), (Weekday) weekday.getSelectedItem());

            if (w != null) {
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

                  makeAllPanelsNotVisible();

                  addEmployeePanel.setVisible(true);
                  loginInfoPanel.setVisible(true);

               } else {
                  JOptionPane.showMessageDialog(mainMenuPanel, success.info);
               }
            } else {
               makeAllPanelsNotVisible();
               addEmployeePanel.setVisible(true);
            }

         }
      });
      btnSave.setBounds(67, 336, 117, 29);
      createSchedulePanel.add(btnSave);

      JLabel lblWorkTime = new JLabel("Work Time");
      lblWorkTime.setBounds(132, 17, 75, 16);
      createSchedulePanel.add(lblWorkTime);

      JLabel lblEquipmentName = new JLabel("Equipment Name:");
      lblEquipmentName.setBounds(32, 160, 117, 16);
      addEquipmentPanel.add(lblEquipmentName);

      JLabel lblQuantity = new JLabel("Quantity:");
      lblQuantity.setBounds(88, 198, 61, 16);
      addEquipmentPanel.add(lblQuantity);

      JLabel lblPathToPicture = new JLabel("Path to Picture:");
      lblPathToPicture.setBounds(49, 236, 100, 16);
      addEquipmentPanel.add(lblPathToPicture);

      equipmentName = new JTextField();
      equipmentName.setBounds(161, 155, 130, 26);
      addEquipmentPanel.add(equipmentName);
      equipmentName.setColumns(10);
      allTextFields.add(equipmentName);

      equipmentQuantity = new JTextField();
      equipmentQuantity.setBounds(161, 193, 130, 26);
      addEquipmentPanel.add(equipmentQuantity);
      equipmentQuantity.setColumns(10);
      allTextFields.add(equipmentQuantity);

      eqPicturePath = new JTextField();
      eqPicturePath.setBounds(161, 231, 130, 26);
      addEquipmentPanel.add(eqPicturePath);
      eqPicturePath.setColumns(10);
      allTextFields.add(eqPicturePath);

      JButton btnAdd = new JButton("Save");
      btnAdd.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            Equipment equipment = GymSystemCreator.getInstance().createEquipment(equipmentName.getText(),
                  eqPicturePath.getText(), equipmentQuantity.getText());
            if (equipment != null) {
               Response success = new Response();
               if (action.equals("Add")) {
                  success = GymSystemController.getInstance().addEquipment(equipment);
               } else {
                  success = GymSystemController.getInstance().updateEquipment(equipmentSearched, equipment);
               }

               if (!success.successful) {
                  JOptionPane.showMessageDialog(mainMenuPanel, success.info);
               } else {
                  JOptionPane.showMessageDialog(mainMenuPanel, success.info);

                  clearTextFields();
                  makeAllPanelsNotVisible();

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
      btnAdd.setBounds(88, 288, 117, 29);
      addEquipmentPanel.add(btnAdd);
      searchEquipPanel.setLayout(null);

      JLabel lblSearchForEquipment = new JLabel("Search for Equipment by Name:");
      lblSearchForEquipment.setBounds(104, 11, 197, 16);
      searchEquipPanel.add(lblSearchForEquipment);

      searchEquipName = new JTextField();
      searchEquipName.setBounds(306, 6, 130, 26);
      searchEquipPanel.add(searchEquipName);
      searchEquipName.setColumns(10);
      allTextFields.add(searchEquipName);

      JButton btnSearchEquip = new JButton("Search");
      btnSearchEquip.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            Equipment equip = GymSystemController.getInstance().searchEquipment(searchEquipName.getText());
            if (equip != null) {
               image = new ImageIcon(equip.getPicture().getAbsolutePath());
               imageLabel.setIcon(image);
               equipmentSearched = equip;
               equipmentName.setText(equip.getName());
               String q = String.valueOf(equip.getQuantity());
               equipmentQuantity.setText(q);
               eqPicturePath.setText(equip.getPicture().getPath());
            } else {
               JOptionPane.showMessageDialog(mainMenuPanel, "Equipment is not found");
            }
         }
      });
      btnSearchEquip.setBounds(441, 5, 85, 29);
      searchEquipPanel.add(btnSearchEquip);

      JButton btnRemove = new JButton("Remove");
      btnRemove.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            Response success = GymSystemController.getInstance().removeEquipment(equipmentSearched);
            if (!success.successful) {
               JOptionPane.showMessageDialog(mainMenuPanel, success.info);
            } else {
               JOptionPane.showMessageDialog(mainMenuPanel, success.info);

               clearTextFields();
               makeAllPanelsNotVisible();

               if (currentUser.getUserType() == UserType.MANAGER) {
                  ManagerMenu.setVisible(true);
               } else {
                  TrainerMenu.setVisible(true);
               }
            }
         }
      });
      btnRemove.setBounds(213, 288, 117, 29);
      addEquipmentPanel.add(btnRemove);

      workoutName = new JTextField();
      workoutName.setBounds(333, 133, 130, 26);
      assignWorkoutPanel.add(workoutName);
      workoutName.setColumns(10);
      allTextFields.add(workoutName);

      JButton btnSaveWorkout = new JButton("Assign Workout To Customer");
      btnSaveWorkout.setBounds(88, 170, 210, 29);
      btnSaveWorkout.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            if (customerSearched == null) {
               JOptionPane.showMessageDialog(mainMenuPanel, "Search Customer to Assign Workout To.");
            } else {

               WorkoutRoutine addWR = GymSystemController.getInstance().searchWorkoutRoutine(workoutName.getText());
               if (addWR != null) {
                  Response success = GymSystemController.getInstance().assignWorkoutRoutine(customerSearched, addWR);

                  if (success.successful) {
                     JOptionPane.showMessageDialog(mainMenuPanel, success.info);

                     String s = customerSearched.getPersonalInfo().getFirstName() + " "
                           + customerSearched.getPersonalInfo().getLastName() + "\n";

                     for (WorkoutRoutine w : customerSearched.getWorkoutRoutines()) {
                        s += w.toString() + "\n";
                     }

                     txtDisplayCustomerInfo.setText(s);
                  } else {
                     JOptionPane.showMessageDialog(mainMenuPanel, success.info);
                  }
               } else {
                  JOptionPane.showMessageDialog(mainMenuPanel, "Workout Routine does not exist.");
               }
            }
         }
      });
      assignWorkoutPanel.add(btnSaveWorkout);

      txtListAllWorkoutsHere = new JTextArea();
      txtListAllWorkoutsHere.setBounds(22, 230, 594, 119);
      txtListAllWorkoutsHere.setLineWrap(true);
      txtListAllWorkoutsHere.setWrapStyleWord(true);
      assignWorkoutPanel.add(txtListAllWorkoutsHere);
      txtListAllWorkoutsHere.setColumns(10);

      JLabel lblWorkoutRoutineName = new JLabel("Workout Routine Name:");
      lblWorkoutRoutineName.setBounds(177, 138, 149, 16);
      assignWorkoutPanel.add(lblWorkoutRoutineName);

      JLabel lblSearchForCustomer = new JLabel("Search for Customer by Name:");
      lblSearchForCustomer.setBounds(6, 6, 195, 16);
      assignWorkoutPanel.add(lblSearchForCustomer);

      exSearchFName = new JTextField();
      exSearchFName.setBounds(107, 30, 130, 26);
      assignWorkoutPanel.add(exSearchFName);
      exSearchFName.setColumns(10);
      allTextFields.add(exSearchFName);

      exSearchLName = new JTextField();
      exSearchLName.setBounds(107, 56, 130, 26);
      assignWorkoutPanel.add(exSearchLName);
      exSearchLName.setColumns(10);
      allTextFields.add(exSearchLName);

      txtDisplayCustomerInfo = new JTextArea();
      txtDisplayCustomerInfo.setBounds(260, 8, 356, 113);
      txtDisplayCustomerInfo.setLineWrap(true);
      txtDisplayCustomerInfo.setWrapStyleWord(true);
      assignWorkoutPanel.add(txtDisplayCustomerInfo);
      txtDisplayCustomerInfo.setColumns(10);

      JButton btnSearch_2 = new JButton("Search");
      btnSearch_2.setBounds(58, 85, 117, 29);
      btnSearch_2.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            customerSearched = GymSystemController.getInstance().searchCustomer(exSearchFName.getText(),
                  exSearchLName.getText());
            if (customerSearched != null) {
               String s = customerSearched.getPersonalInfo().getFirstName() + " "
                     + customerSearched.getPersonalInfo().getLastName() + "\n";

               for (WorkoutRoutine w : customerSearched.getWorkoutRoutines()) {
                  s += w.toString() + "\n";
               }

               txtDisplayCustomerInfo.setText(s);
            } else {
               JOptionPane.showMessageDialog(mainMenuPanel, "Customer not found.");
            }

         }
      });
      assignWorkoutPanel.add(btnSearch_2);

      JLabel lblFirstName_1 = new JLabel("First Name:");
      lblFirstName_1.setBounds(26, 35, 73, 16);
      assignWorkoutPanel.add(lblFirstName_1);

      JLabel lblLastName_1 = new JLabel("Last Name:");
      lblLastName_1.setBounds(26, 61, 73, 16);
      assignWorkoutPanel.add(lblLastName_1);

      JButton btnRemoveWorkoutFrom = new JButton("Remove Workout From Customer");
      btnRemoveWorkoutFrom.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            if (!workoutName.getText().equals("")) {
               if (customerSearched == null) {
                  JOptionPane.showMessageDialog(mainMenuPanel, "Search Customer to Unassign Workout.");
               } else {

                  Response success = GymSystemController.getInstance().unassignWorkoutRoutine(customerSearched,
                        workoutName.getText());

                  if (success.successful) {
                     JOptionPane.showMessageDialog(mainMenuPanel, success.info);

                     String s = customerSearched.getPersonalInfo().getFirstName() + " "
                           + customerSearched.getPersonalInfo().getLastName() + "\n";

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
      btnRemoveWorkoutFrom.setBounds(333, 171, 240, 29);
      assignWorkoutPanel.add(btnRemoveWorkoutFrom);

      JButton btnSave_1 = new JButton("Done");
      btnSave_1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            makeAllPanelsNotVisible();
            TrainerMenu.setVisible(true);
            clearTextFields();
         }
      });
      btnSave_1.setBounds(260, 350, 117, 29);
      assignWorkoutPanel.add(btnSave_1);

      JLabel lblListOfWorkout = new JLabel("List of Workout Routines");
      lblListOfWorkout.setBounds(238, 211, 162, 16);
      assignWorkoutPanel.add(lblListOfWorkout);

      TrainerMenu = new JPanel();
      TrainerMenu.setBounds(0, 53, 637, 385);
      mainMenuPanel.add(TrainerMenu);
      TrainerMenu.setLayout(null);

      JButton btnViewClasses = new JButton("View Classes");
      btnViewClasses.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            makeAllPanelsNotVisible();
            currUserClassesPanel.setVisible(true);
         }
      });
      btnViewClasses.setBounds(385, 296, 203, 83);
      TrainerMenu.add(btnViewClasses);

      JButton btnAssignWorkouts = new JButton("Assign Workout Routines");
      btnAssignWorkouts.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            makeAllPanelsNotVisible();
            assignWorkoutPanel.setVisible(true);

            String s = "";

            for (WorkoutRoutine wr : GymSystemController.getInstance().getWorkoutRoutines()) {
               s += wr.toString() + "\n";
            }

            txtListAllWorkoutsHere.setText(s);
         }
      });
      btnAssignWorkouts.setBounds(385, 199, 203, 85);
      TrainerMenu.add(btnAssignWorkouts);

      JButton btnRegisterCustomer = new JButton("Register Customer");
      btnRegisterCustomer.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            newEmployeeType = null;

            makeAllPanelsNotVisible();
            addEmployeePanel.setVisible(true);

            btnRemoveUser.setVisible(false);
            btnAddWorkSchedule.setVisible(false);

            lblMembership.setVisible(true);
            mstatus.setVisible(true);

            action = "Add";
         }
      });
      btnRegisterCustomer.setBounds(50, 13, 213, 85);
      TrainerMenu.add(btnRegisterCustomer);

      JButton btnAddEquipmentInventory = new JButton("Add Equipment Inventory");
      btnAddEquipmentInventory.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            makeAllPanelsNotVisible();
            addEquipmentPanel.setVisible(true);

            searchEquipPanel.setVisible(false);
            btnRemove.setVisible(false);

            action = "Add";
         }
      });
      btnAddEquipmentInventory.setBounds(50, 130, 213, 85);
      TrainerMenu.add(btnAddEquipmentInventory);

      JButton btnModifyCustomerInformation = new JButton("Modify Customer Information");
      btnModifyCustomerInformation.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            newEmployeeType = UserType.MANAGER;

            makeAllPanelsNotVisible();
            addEmployeePanel.setVisible(true);
            searchPanel.setVisible(true);

            btnAddWorkSchedule.setVisible(false);

            lblMembership.setVisible(true);
            mstatus.setVisible(true);
            action = "Update";
         }
      });
      btnModifyCustomerInformation.setBounds(385, 6, 203, 92);
      TrainerMenu.add(btnModifyCustomerInformation);

      JButton btnModifyEquipment_1 = new JButton("Modify Equipment");
      btnModifyEquipment_1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            makeAllPanelsNotVisible();

            searchEquipPanel.setVisible(true);
            addEquipmentPanel.setVisible(true);
            btnRemove.setVisible(true);

            action = "Update";
         }
      });
      btnModifyEquipment_1.setBounds(385, 110, 203, 77);
      TrainerMenu.add(btnModifyEquipment_1);
      TrainerMenu.setVisible(false);

      JButton btnCreateWorkouts = new JButton("Exercises and Workout Routines");
      btnCreateWorkouts.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            makeAllPanelsNotVisible();
            createWorkoutsPanel.setVisible(true);

            String s = "";

            for (Exercise ex : GymSystemController.getInstance().getExercises()) {
               s += ex.toString() + "\n";
            }

            listExercisesHere.setText(s);

            String s2 = "";

            for (WorkoutRoutine wr : GymSystemController.getInstance().getWorkoutRoutines()) {
               s2 += wr.toString() + "\n";
            }

            listWorkoutRoutinesHere.setText(s2);
         }
      });
      btnCreateWorkouts.setBounds(50, 238, 220, 92);
      TrainerMenu.add(btnCreateWorkouts);

      ManagerMenu = new JPanel();
      mainMenuPanel.add(ManagerMenu, "name_49214182129467");
      ManagerMenu.setBounds(0, 53, 637, 385);
      ManagerMenu.setLayout(null);

      JButton btnHireManager = new JButton("Hire Manager");
      btnHireManager.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            newEmployeeType = UserType.MANAGER;

            makeAllPanelsNotVisible();
            addEmployeePanel.setVisible(true);
            loginInfoPanel.setVisible(true);

            btnRemoveUser.setVisible(false);
            btnAddWorkSchedule.setVisible(false);
            lblMembership.setVisible(false);
            mstatus.setVisible(false);

            action = "Add";
         }
      });
      btnHireManager.setBounds(50, 17, 180, 72);
      ManagerMenu.add(btnHireManager);

      JButton btnHireTrainer = new JButton("Hire Trainer");
      btnHireTrainer.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            newEmployeeType = UserType.TRAINER;

            makeAllPanelsNotVisible();
            addEmployeePanel.setVisible(true);
            loginInfoPanel.setVisible(true);

            btnRemoveUser.setVisible(false);
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
            makeAllPanelsNotVisible();
            addEmployeePanel.setVisible(true);

            btnRemoveUser.setVisible(false);
            btnAddWorkSchedule.setVisible(false);
            lblMembership.setVisible(true);

            mstatus.setVisible(true);

            action = "Add";
         }
      });
      btnRegisterCustomer_1.setBounds(50, 185, 180, 82);
      ManagerMenu.add(btnRegisterCustomer_1);

      JButton btnAddEquipmentIventory = new JButton("Add Equipment Iventory");
      btnAddEquipmentIventory.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            makeAllPanelsNotVisible();
            addEquipmentPanel.setVisible(true);
            btnRemove.setVisible(false);
            action = "Add";
         }
      });
      btnAddEquipmentIventory.setBounds(356, 107, 180, 66);
      ManagerMenu.add(btnAddEquipmentIventory);

      JButton btnModifyUserInformation = new JButton("Modify User Information");
      btnModifyUserInformation.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            makeAllPanelsNotVisible();
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
            makeAllPanelsNotVisible();

            searchEquipPanel.setVisible(true);
            addEquipmentPanel.setVisible(true);

            btnRemove.setVisible(true);
            action = "Update";
         }
      });
      btnModifyEquipment.setBounds(356, 196, 180, 60);
      ManagerMenu.add(btnModifyEquipment);

      JButton manageClassbtn = new JButton("Manage Classes");
      manageClassbtn.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            makeAllPanelsNotVisible();
            classesPanel.setVisible(true);
            trainersComboBox.removeAllItems();
            
            for (Trainer t : GymSystemController.getInstance().getTrainers()) 
            {
               trainersComboBox.addItem(t.getPersonalInfo().getLastName() + ", " + t.getPersonalInfo().getFirstName());
            }

         }
      });
      manageClassbtn.setBounds(50, 279, 180, 82);
      ManagerMenu.add(manageClassbtn);
      ManagerMenu.setVisible(false);

      JButton btnReturn = new JButton("Return");
      btnReturn.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            if (currentUser.getUserType() == UserType.MANAGER) {
               makeAllPanelsNotVisible();
               mainMenuPanel.setVisible(true);
               ManagerMenu.setVisible(true);

            } else {
               makeAllPanelsNotVisible();
               mainMenuPanel.setVisible(true);
               TrainerMenu.setVisible(true);
            }
            clearTextFields();
         }
      });
      btnReturn.setBackground(Color.LIGHT_GRAY);
      btnReturn.setBounds(0, 2, 117, 29);
      mainMenuPanel.add(btnReturn);
      ManagerMenu.setVisible(false);

      JButton btnLogin = new JButton("Login");
      btnLogin.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            Employee user = GymSystemController.getInstance().authenticateUser(loginUsername.getText(),
                  String.copyValueOf(loginPassword.getPassword()));
            if (user == null) {
               JOptionPane.showMessageDialog(LoginPanel, "Invalid Login.");
               loginPassword.setText("");
            } else {
               currentUser = user;
               if (currentUser.getUserType() == UserType.MANAGER) {
                  makeAllPanelsNotVisible();
                  mainMenuPanel.setVisible(true);
                  ManagerMenu.setVisible(true);
               } else {
                  makeAllPanelsNotVisible();
                  findClassesforUser();
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
