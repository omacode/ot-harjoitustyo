package trainingapp.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Sovelluksen käyttäjää edustava luokka
 */
public class Player {

    private int id;
    private String username;
    private String password;
    private String name;
    private List<Assignment> assignments;

    public Player(String username, String password, String name) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.assignments = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<Assignment> assignments) {
        this.assignments = assignments;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Player other = (Player) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        return Objects.equals(this.name, other.name);
    }
}
