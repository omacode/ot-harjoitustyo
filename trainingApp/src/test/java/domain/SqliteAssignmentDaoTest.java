package domain;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import trainingapp.dao.Database;
import trainingapp.dao.SqliteAssignmentDao;
import trainingapp.dao.SqlitePlayerDao;
import trainingapp.domain.Assignment;
import trainingapp.domain.AssignmentService;

public class SqliteAssignmentDaoTest {

    Database database;
    AssignmentService assignmentService;
    
    @Before
    public void setUp() {
        database = new Database("jdbc:sqlite:test.db");
        assignmentService = new AssignmentService(new SqliteAssignmentDao(database), new SqlitePlayerDao(database));
        assignmentService.createPlayer("testPlayer", "passw", "tP");
    }
    
    @After
    public void tearDown() {
        try {
            Connection conn = database.getConnection();
            Statement stmt = conn.createStatement();
            String sql = "DROP TABLE Player; DROP TABLE Assignment;";
            stmt.execute(sql);

            sql = "DROP TABLE Assignment;";
            stmt.execute(sql);
            
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void canCreateAssignment() {
        assignmentService.login("testPlayer", "passw");
        boolean result = assignmentService.createAssignment("Who is there?", "Tim");
        assertTrue(result);
        
        assertEquals(1, assignmentService.getLoggedPlayer().getAssignments().size());
        
        Assignment a = assignmentService.getLoggedPlayer().getAssignments().get(0);
        assertEquals(1, a.getId());
        assertEquals(1, a.getPlayerId());
        assertEquals("Who is there?", a.getQuestion());
        assertEquals("Tim", a.getAnswer());
    }
}
