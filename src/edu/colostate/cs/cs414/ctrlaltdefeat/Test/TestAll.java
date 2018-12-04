package edu.colostate.cs.cs414.ctrlaltdefeat.Test;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses( { AddressTest.class, CustomerTest.class, 
                  EmployeeTest.class, EmployeeTest.class,
                  ExerciseTest.class, UserTest.class,
                  PersonalInformationTest.class,
                  ScheduleTest.class, WorkoutRoutineTest.class,
                  WorkTimeTest.class} )

public class TestAll
{
}