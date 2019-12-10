
package trainingapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import trainingapp.domain.Player;

public class SqlitePlayerDao implements PlayerDao {

    private Database database;

    public SqlitePlayerDao(Database database) {
        this.database = database;
    }
    
    @Override
    public Player findByUsernameAndPassword(String username, String password) {
        Player p;
        
        try {
            Connection conn = database.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Player WHERE username = ? AND password = ?");
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            
            boolean hasOne = rs.next();
            if (!hasOne) {
                return null;
            }
            
            p = new Player(rs.getString(2), rs.getString(3), rs.getString(4));
            p.setId(rs.getInt(1));
            
            stmt.close();
            rs.close();
            conn.close();
        } catch (SQLException ex) {
            return null;
        }
        
        return p;
    }

    @Override
    public Player findByUsername(String username) {
        Player p;
        
        try {
            Connection conn = database.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Player WHERE username = ?");
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            
            boolean hasOne = rs.next();
            if (!hasOne) {
                return null;
            }
            
            p = new Player(rs.getString(2), rs.getString(3), rs.getString(4));
            p.setId(rs.getInt(1));

            stmt.close();
            rs.close();
            conn.close();
        } catch (SQLException ex) {
            return null;
        }
        
        return p;        
    }

    @Override
    public Player create(Player player) {
        
        try {
            Connection conn = database.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Player (username, password, name) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, player.getUsername());
            stmt.setString(2, player.getPassword());
            stmt.setString(3, player.getName());
            
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            player.setId(rs.getInt(1));
            
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            return null;
        }
        
        return player;
    }
}
