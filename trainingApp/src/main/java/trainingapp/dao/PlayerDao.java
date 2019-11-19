package trainingapp.dao;

import trainingapp.domain.Player;

public interface PlayerDao {
    
    Player findByUsernameAndPassword(String username, String password);
}
