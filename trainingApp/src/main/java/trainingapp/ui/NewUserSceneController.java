package trainingapp.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import trainingapp.domain.AssignmentService;

public class NewUserSceneController implements Initializable {
    
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
        name.clear();
        errorMessage.setText("");
    }
    
    @FXML
    private TextField username;
    
    @FXML
    private TextField password;
    
    @FXML
    private TextField name;
    
    @FXML
    private Text errorMessage;
    
    @FXML
    private void handleCreate(ActionEvent event) {
        if (assignmentService.createPlayer(username.getText(), password.getText(), name.getText())) {    
            clearForm();
            application.setLogInScene();
        } else {
            errorMessage.setText("Incorrect username or password! \nCheck tooltips and try again!");
        }
    }
    
    @FXML
    private void handleBack(ActionEvent event) {
        clearForm();
        application.setLogInScene();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
}
