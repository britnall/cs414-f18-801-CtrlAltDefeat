package edu.colostate.cs.cs414.ctrlaltdefeat.Test;

import java.io.File;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Entity.Equipment;


class EquipmentTest {
   Equipment testEquipment;
   File equipPic;

   @BeforeEach
   void setUp() throws Exception {
      equipPic = new File("temp.png");
      testEquipment = new Equipment("Stair Climber", equipPic, 5);
   }

   @AfterEach
   void tearDown() throws Exception {
      testEquipment = null;
   }

   @Test
   void testGetName() {
      Assertions.assertEquals("Stair Climber", testEquipment.getName());
   }

   @Test
   void testGetPicture() {
      Assertions.assertEquals(equipPic, testEquipment.getPicture());
   }

   @Test
   void testSetPicture() {
      File temp = new File("temp02.png");
      testEquipment.setPicture(temp);
      Assertions.assertEquals(temp, testEquipment.getPicture());
   }

   @Test
   void testGetQuantity() {
      Assertions.assertTrue(testEquipment.getQuantity() == 5);
   }

   @Test
   void testSetQuantity() {
      testEquipment.setQuantity(9);
      Assertions.assertTrue(testEquipment.getQuantity() == 9);
   }

   @Test
   void testHashCode() {
      Equipment eq1 = new Equipment("Stair Climber", equipPic, 5);
      testEquipment.setQuantity(9);
      Assertions.assertEquals(testEquipment.hashCode(), eq1.hashCode());
   }

   @Test
   void testEqual() {
      Equipment eq1 = new Equipment("Stair Climber", equipPic, 5);
      Assertions.assertTrue(testEquipment.equals(eq1));
   }

   @Test
   void testNotEqual() {
      Equipment eq1 = new Equipment("Stair Master", equipPic, 5);
      Assertions.assertFalse(testEquipment.equals(eq1));
   }

}
