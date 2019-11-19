package trainingapp.domain;

import trainingapp.dao.AssignmentDao;
import trainingapp.dao.PlayerDao;

public class AssignmentService {
    
    private AssignmentDao assignmentDao;
    private PlayerDao playerDao;
    private Player loggedIn;

    public AssignmentService(AssignmentDao assignmentDao, PlayerDao playerDao) {
        this.assignmentDao = assignmentDao;
        this.playerDao = playerDao;
    }
    
    public boolean login(String username, String password) {
        Player player = playerDao.findByUsernameAndPassword(username, password);
        
        if (player == null) {
            return false;
        }
        
        loggedIn = player;
        
        return true;
    }
    
    public Player getLoggedPlayer() {
        return loggedIn;
    }
    
    public void logout() {
        loggedIn = null;
    }
}
