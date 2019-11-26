package domain;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import trainingapp.domain.AssignmentService;
import trainingapp.domain.Player;

public class AssignmentServicePlayerTest {
    
    FakeAssignmentDao assignmentDao;
    FakePlayerDao playerDao;
    AssignmentService assignmentService;
    
    @Before
    public void setUp() {
        assignmentDao = new FakeAssignmentDao();
        playerDao = new FakePlayerDao();
        assignmentService = new AssignmentService(assignmentDao, playerDao);
    }

    @Test
    public void existingPlayerCanLogIn() {
        boolean result = assignmentService.login("tester1", "tim1");
        assertTrue(result);
        
        assertEquals("Tim S", assignmentService.getLoggedPlayer().getName());
    }
    
    @Test
    public void nonExistingPlayerCanLogIn() {
        boolean result = assignmentService.login("nonexisting", "passw");
        assertFalse(result);
        
        assertEquals(null, assignmentService.getLoggedPlayer());
    }
    
    @Test
    public void loggedInPlayerCanLogOut() {
        boolean result = assignmentService.login("tester1", "tim1");
        assertTrue(result);
        
        assignmentService.logout();
        assertEquals(null, assignmentService.getLoggedPlayer());
    }
    
    @Test
    public void playerCreationFailsIfUsernameIsTooShort() {
        boolean result = assignmentService.createPlayer("tes", "tim2", "Tim O");
        assertFalse(result);
    }
    
    @Test
    public void playerCreationFailsIfPasswordIsTooShort() {
        boolean result = assignmentService.createPlayer("tester2", "tim", "Tim O");
        assertFalse(result);
    }
    
    @Test
    public void playerCreationFailsIfUsernameNotUnique() {
        boolean result = assignmentService.createPlayer("tester1", "tim", "Tim O");
        assertFalse(result);
    }
    
    @Test
    public void successfullyCreatedPlayerCanLogIn() {
        boolean result = assignmentService.createPlayer("tester2", "tim2", "Tim O");
        assertTrue(result);
        
        assertTrue(assignmentService.login("tester2", "tim2"));
        assertEquals("Tim O", assignmentService.getLoggedPlayer().getName());
    }
}
