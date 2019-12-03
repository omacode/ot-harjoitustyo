package domain;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import trainingapp.dao.Database;
import trainingapp.dao.SqlitePlayerDao;
import trainingapp.domain.AssignmentService;

public class SqlitePlayerDaoTest {

    Database database;
    AssignmentService assignmentService;
    
    @Before
    public void setUp() {
        database = new Database("jdbc:sqlite:test.db");
        assignmentService = new AssignmentService(new trainingapp.dao.FakeAssignmentDao(), new SqlitePlayerDao(database));
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
    public void playerCanCreateAccount() {
        
    }
    
    @Test
    public void playerCanLogin() {
        boolean result = assignmentService.login("testPlayer", "passw");
        assertTrue(result);
        
        assertEquals("tP", assignmentService.getLoggedPlayer().getName());
    }
}
