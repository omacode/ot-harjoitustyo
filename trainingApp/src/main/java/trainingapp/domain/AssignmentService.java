package trainingapp.domain;

import trainingapp.dao.AssignmentDao;
import trainingapp.dao.PlayerDao;

/**
 * Sovelluslogiikasta vastaava luokka 
 */
public class AssignmentService {
    
    private AssignmentDao assignmentDao;
    private PlayerDao playerDao;
    private Player loggedIn;

    public AssignmentService(AssignmentDao assignmentDao, PlayerDao playerDao) {
        this.assignmentDao = assignmentDao;
        this.playerDao = playerDao;
    }
    
    /**
     * sisäänkirjautuminen
     * 
     * @param   username   käyttäjätunnus
     * @param   password   käyttäjän salasana
     * 
     * @return true jos käyttäjä on olemassa, muuten false 
     */
    public boolean login(String username, String password) {
        Player player = playerDao.findByUsernameAndPassword(username, password);
        
        if (player == null) {
            return false;
        }
        
        loggedIn = player;
        player.setAssignments(assignmentDao.findByPlayerId(loggedIn.getId()));
        
        System.out.println("player: " + loggedIn.getName());
        loggedIn.getAssignments().forEach(a -> System.out.println(a.getId() + " " + a.getQuestion() + " " + a.getAnswer()));
        
        return true;
    }
    
    /**
     * kirjautuneena oleva käyttäjä
     * 
     * @return kirjautuneena oleva käyttäjä 
     */
    public Player getLoggedPlayer() {
        return loggedIn;
    }
    
    /**
     * uloskirjautuminen
     */
    public void logout() {
        loggedIn = null;
    }

    /**
     * uuden käyttäjän luominen
     * 
     * @param   username    käyttäjätunnus
     * @param   password    käyttäjän salasana
     * @param   name        käyttäjän nimi
     * 
     * @return true jos käyttäjätunnus on luotu onnistuneesti, muuten false 
     */
    public boolean createPlayer(String username, String password, String name) {
        if (username.length() < 4 || password.length() < 4 || playerDao.findByUsername(username) != null) {
            return false;
        }
        
        Player player = new Player(username, password, name);
        
        playerDao.create(player);
        
        return true;
    }
    
    /**
     * uuden tehtävän luominen
     * 
     * @param   question    kysymys
     * @param   answer      oikea vastaus kysymykseen
     * 
     * @return true jos tehtävä on luotu onnistuneesti, muuten false 
     */
    public boolean createAssignment(String question, String answer) {
        if (question.length() < 4 || answer.length() < 1 || loggedIn == null) {
            return false;
        }
        
        Assignment assignment = new Assignment(loggedIn.getId(), question, answer, null, null);
        
        assignmentDao.create(assignment);
        loggedIn.setAssignments(assignmentDao.findByPlayerId(loggedIn.getId()));
        
        return true;
    }
}
