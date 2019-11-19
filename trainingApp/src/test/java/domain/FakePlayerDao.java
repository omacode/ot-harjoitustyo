package domain;

import java.util.ArrayList;
import java.util.List;
import trainingapp.dao.PlayerDao;
import trainingapp.domain.Player;

public class FakePlayerDao implements PlayerDao {

    private List<Player> players;

    public FakePlayerDao() {
        players = new ArrayList<>();
        players.add(new Player("tester1", "tim1", "Tim S"));
    }
       
    @Override
    public Player findByUsernameAndPassword(String username, String password) {
        return players.stream().filter(p -> p.getUsername().equals(username) && p.getPassword().equals(password)).findFirst().orElse(null);
    }   
}
