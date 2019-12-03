
package trainingapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {
    
    private final String databaseAddress;
    
    public Database(String databaseAddress) {
        this.databaseAddress = databaseAddress;
        this.createTablesIfNotExists();
    }
    
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(databaseAddress);
    }

    private void createTablesIfNotExists() {
        try {
            Connection conn = this.getConnection();
            Statement stmt = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS Player (id INTEGER PRIMARY KEY, username VARCHAR(30) NOT NULL UNIQUE, password VARCHAR(30) NOT NULL, name VARCHAR(60));";
            stmt.execute(sql);
            
            sql = "CREATE TABLE IF NOT EXISTS Assignment (id INTEGER PRIMARY KEY, player_id INTEGER, question VARCHAR(255) NOT NULL, answer VARCHAR(255) NOT NULL, tip VARCHAR(255), explanation VARCHAR(255), FOREIGN KEY (player_id) REFERENCES Player(id));";
            stmt.execute(sql);
            
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
