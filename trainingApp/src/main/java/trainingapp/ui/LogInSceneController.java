package trainingapp.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import trainingapp.domain.AssignmentService;

public class LogInSceneController implements Initializable {
    
    private MainApp application;
    private AssignmentService assignmentService;
    
    public void setApplication(MainApp application) {
        this.application = application;
    }
    
    public void setAssignmentService(AssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }
    
    private void clearForm() {
        username.clear();
        password.clear(); 
        errorMessage.setText("");
    }
    
    @FXML
    private TextField username;
    
    @FXML
    private PasswordField password;
    
    @FXML
    private Text errorMessage;
    
    @FXML
    private void handleLogIn(ActionEvent event) {
        if (assignmentService.login(username.getText(), password.getText())) {
            clearForm();
            application.setTrainingScene();
        } else {
            errorMessage.setText("Wrong username or password, try again!");
            username.clear();
            password.clear();
        }
    }
    
    @FXML
    private void handleNewUser(ActionEvent event) {
        clearForm();
        application.setNewUserScene();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
