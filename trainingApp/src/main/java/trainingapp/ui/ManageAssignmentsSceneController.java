package trainingapp.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import trainingapp.domain.AssignmentService;

public class ManageAssignmentsSceneController implements Initializable {
    
    private MainApp application;
    private AssignmentService assignmentService;
    
    public void setApplication(MainApp application) {
        this.application = application;
    }
    
    public void setAssignmentService(AssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }
    
    @FXML
    private Button playerButton;
    
    @FXML
    private void handleLogOut(ActionEvent event) {
        assignmentService.logout();
        application.setLogInScene();
    }
    
    @FXML
    private void handlePractice(ActionEvent event) {
        System.out.println(assignmentService.getLoggedPlayer().getName() + " wants to practice!");
        application.setTrainingScene();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
