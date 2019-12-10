package trainingapp.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import trainingapp.domain.Assignment;
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
    
    private void clearForm() {
        question.clear();
        answer.clear();
    }
    
    @FXML
    private TableView<Assignment> tableView;
    
    @FXML
    private TextField question;
    
    @FXML
    private TextField answer;
    
    @FXML
    private void handleLogOut(ActionEvent event) {
        assignmentService.logout();
        application.setLogInScene();
    }
    
    @FXML
    private void handlePractice(ActionEvent event) {
        application.setTrainingScene();
    }
    
    @FXML
    private void handleAdd(ActionEvent event) {
        assignmentService.createAssignment(question.getText(), answer.getText());
        clearForm();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
