package trainingapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import trainingapp.domain.Assignment;

/**
 * Luokka tarjoaa metodeja tehtävien tietokantakyselyihin
 */
public class SqliteAssignmentDao implements AssignmentDao {

    private Database database;

    public SqliteAssignmentDao(Database database) {
        this.database = database;
    }

    /**
     * Käyttäjän tehtävien haku
     *
     * @param id Käyttäjän id
     *
     * @return tehtävälista
     */
    @Override
    public List<Assignment> findByPlayerId(int id) {
        List<Assignment> assignments = new ArrayList<>();

        try {
            Connection conn = database.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Assignment WHERE player_id = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Assignment a = new Assignment(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                assignments.add(a);
            }

            stmt.close();
            rs.close();
            conn.close();
        } catch (SQLException ex) {
            return null;
        }

        return assignments;
    }

    /**
     * Uuden tehtävän tallentaminen
     *
     * @param assignment talletettava tehtävä
     *
     * @return tallennettu tehtävä
     */
    @Override
    public Assignment create(Assignment assignment) {

        try {
            Connection conn = database.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Assignment (player_id, question, answer) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, assignment.getPlayerId());
            stmt.setString(2, assignment.getQuestion());
            stmt.setString(3, assignment.getAnswer());

            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            assignment.setId(rs.getInt(1));

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            return null;
        }

        return assignment;
    }
}
