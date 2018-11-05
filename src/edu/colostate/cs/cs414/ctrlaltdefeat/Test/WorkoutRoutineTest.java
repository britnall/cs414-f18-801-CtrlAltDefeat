package edu.colostate.cs.cs414.ctrlaltdefeat.Test;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Entity.Exercise;
import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Entity.WorkoutRoutine;

class WorkoutRoutineTest {
   WorkoutRoutine testRoutine;
   ArrayList<Exercise> exercises;
   Exercise e1;
   
   @BeforeEach
   void setUp() throws Exception {
      exercises = new ArrayList<Exercise>();
      e1 = new Exercise("arm-Stretch", 3, 4, null);
      testRoutine = new WorkoutRoutine("Warm-up", exercises);
   }

   @AfterEach
   void tearDown() throws Exception {
      testRoutine = null;
   }

	@Test
	void testGetName() {
			Assertions.assertEquals("Warm-up", testRoutine.getName());
	}

	@Test
	void testGetExercises() {
			Assertions.assertTrue(testRoutine.getExercises().equals(exercises));
	}

	@Test
	void testSetExercises() {
			ArrayList<Exercise> eList1= new ArrayList<Exercise>();
			Exercise e = new Exercise("arm-Stretch", 3, 4, null);
			Exercise e1 = new Exercise("Shoulder Stretch", 3, 4, null);
			Exercise e2 = new Exercise("Trapizoid Stretch", 3, 4, null);
			eList1.add(e);
			eList1.add(e1);
			eList1.add(e2);
			testRoutine.setExercises(eList1);
			Assertions.assertTrue(testRoutine.getExercises().equals(eList1));
	}
	
	@Test
	void testHashCode() {
			WorkoutRoutine wr1 = new WorkoutRoutine("Warm-up", exercises);
			Assertions.assertEquals(testRoutine.hashCode(), wr1.hashCode());
	}
	@Test
	void testEqual() {
			WorkoutRoutine wr1 = new WorkoutRoutine("Warm-up", exercises);
			Assertions.assertTrue(testRoutine.equals(wr1));
	}
	@Test
	void testNotEqual() {
			WorkoutRoutine wr1 = new WorkoutRoutine("Cool-down", exercises);
			Assertions.assertFalse(testRoutine.equals(wr1));
	}

}
