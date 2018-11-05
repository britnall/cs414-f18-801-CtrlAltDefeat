package edu.colostate.cs.cs414.ctrlaltdefeat.Test;

import java.io.File;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Entity.Equipment;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Entity.Exercise;

class ExerciseTest {
   Exercise testExercise;

   @BeforeEach
   void setUp() throws Exception {
      testExercise = new Exercise("Squats", 3, 4, null);
   }

   @AfterEach
   void tearDown() throws Exception {
      testExercise = null;
   }

   @Test
   void testGetName() {
      Assertions.assertEquals("Squats", testExercise.getName());
   }
   
   @Test
   void testGetNumOfReps() {
      Assertions.assertTrue(testExercise.getNumOfReps() == 3);
   }

   @Test
   void testSetNumOfReps() {
      testExercise.setNumOfReps(9);
      Assertions.assertTrue(testExercise.getNumOfReps() == 9);
   }

   @Test
   void testGetNumOfSets() {
      Assertions.assertTrue(testExercise.getNumOfSets() == 4);
   }

   @Test
   void testSetNumOfSets() {
      testExercise.setNumOfSets(6);
      Assertions.assertTrue(testExercise.getNumOfSets() == 6);
   }

   @Test
   void testGetEquipment() {
      File f = new File("temp");
      Equipment eq = new Equipment("DumbBells", f, 3);
      testExercise.setEquipment(eq);
      Assertions.assertEquals(eq, testExercise.getEquipment());
   }

   @Test
   void testSetEquipment() {
      File f = new File("temp");
      Equipment eq = new Equipment("DumbBells", f, 3);
      testExercise.setEquipment(eq);
      Assertions.assertEquals(eq, testExercise.getEquipment());
   }
   
   @Test
   void testHashCode() {
      Exercise exercise = new Exercise("Squats", 3, 4, null);
      Assertions.assertEquals(testExercise.hashCode(), exercise.hashCode());
   }

   @Test
   void testEquals() {
      Exercise exercise = new Exercise("Squats", 3, 4, null);
      Assertions.assertTrue(testExercise.equals(exercise));
   }

   @Test
   void testNotEquals() {
      Exercise exercise = new Exercise("Rows", 3, 4, null);
      Assertions.assertFalse(testExercise.equals(exercise));
   }

}
