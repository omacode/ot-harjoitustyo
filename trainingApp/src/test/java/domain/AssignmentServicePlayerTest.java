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
    public void existingPlayerCanLogin() {
        boolean result = assignmentService.login("tester1", "tim1");
        assertTrue(result);
        
        Player loggedIn = assignmentService.getLoggedPlayer();
        assertEquals("Tim S", loggedIn.getName());
    }
}
