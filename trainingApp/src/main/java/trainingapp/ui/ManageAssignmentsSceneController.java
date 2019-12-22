package trainingapp.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
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

    public void setUser() {
        user.setText(assignmentService.getLoggedPlayer().getUsername());
    }

    public void setTableData() {
        tableView.getItems().setAll(assignmentService.getLoggedPlayer().getAssignments());
    }

    private void clearForm() {
        questionTF.clear();
        answerTF.clear();
    }

    @FXML
    private Text user;

    @FXML
    private TableView<Assignment> tableView;

    @FXML
    private TableColumn<Assignment, String> question, answer;

    @FXML
    private TextField questionTF;

    @FXML
    private TextField answerTF;

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
        boolean result = assignmentService.createAssignment(questionTF.getText(), answerTF.getText());

        if (!result) {
            return;
        }

        setTableData();
        clearForm();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        question.setCellValueFactory(new PropertyValueFactory<>("question"));
        answer.setCellValueFactory(new PropertyValueFactory<>("answer"));
    }
}
