package edu.colostate.cs.cs414.ctrlaltdefeat.Test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.colostate.cs.cs414.ctrlaltdefeat.Domain.Users.User;

class UserTest {
   User testUser;
   
   @BeforeEach
   void setUp() throws Exception {
      testUser = new User("username", "password");
   }

   @AfterEach
   void tearDown() throws Exception {
      testUser = null;
   }
   
   @Test
   void testGetUserName() {
        Assertions.assertEquals(testUser.getUserName(), "username");
   }

	@Test
	void testGetPassword() {
			Assertions.assertEquals(testUser.getPassword(), "password");
	}

	@Test
	void testSetPassword() {
	   testUser.setPassword("password02");
			Assertions.assertEquals(testUser.getPassword(), "password02");
	}
	
	@Test
	void testHashCode() {
			User user1 = new User("username", "password");
			Assertions.assertEquals(testUser.hashCode(), user1.hashCode());
	}
	@Test
	void testEquals() {
			User user1 = new User("username", "password");
			Assertions.assertTrue(testUser.equals(user1));
	}
	@Test
	void testUnEqual() {
			User user1 = new User("mvsmith", "pass");
			Assertions.assertFalse(testUser.equals(user1));
	}
}
