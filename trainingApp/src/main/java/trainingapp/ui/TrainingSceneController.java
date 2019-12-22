package trainingapp.ui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import trainingapp.domain.Assignment;
import trainingapp.domain.AssignmentService;

public class TrainingSceneController implements Initializable {

    private MainApp application;
    private AssignmentService assignmentService;
    private List<Assignment> assignments;
    private Assignment currentAssignment;
    private int assignmentIndex;

    public void setApplication(MainApp application) {
        this.application = application;
    }

    public void setAssignmentService(AssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }

    public void setUser() {
        user.setText(assignmentService.getLoggedPlayer().getUsername());
    }

    public void setAssignments() {
        assignments = assignmentService.getLoggedPlayer().getAssignments();

        if (assignments.isEmpty()) {
            question.setVisible(false);
            answer.setVisible(false);
            information.setText("Click manage assignments button and add first assignment!");
            checkButton.setVisible(false);
            nextButton.setVisible(false);
            return;
        }

        question.setVisible(true);
        answer.setVisible(true);
        clearForm();
        checkButton.setVisible(true);
        nextButton.setVisible(true);

        assignmentIndex = 0;
        nextAssignment();
    }

    private void nextAssignment() {
        if (assignmentIndex >= assignments.size()) {
            assignmentIndex = 0;
        }

        currentAssignment = assignments.get(assignmentIndex);
        question.setText("(" + (assignmentIndex + 1) + "/" + assignments.size() + ") " + currentAssignment.getQuestion());

        assignmentIndex++;
    }

    private void clearForm() {
        answer.clear();
        information.setText("");
        information.setFill(Color.BLACK);
    }

    @FXML
    private Text user;

    @FXML
    private Label question;

    @FXML
    private TextField answer;

    @FXML
    private Text information;

    @FXML
    private Button checkButton;

    @FXML
    private Button nextButton;

    @FXML
    private void handleLogOut(ActionEvent event) {
        clearForm();
        assignmentService.logout();
        application.setLogInScene();
    }

    @FXML
    private void handleAssignments(ActionEvent event) {
        clearForm();
        application.setManageAssignmentsScene();
    }

    @FXML
    private void handleCheck(ActionEvent event) {
        if (currentAssignment.getAnswer().equals(answer.getText())) {
            information.setFill(Color.GREEN);
            information.setText("Correct answer, take next question!");
        } else {
            information.setFill(Color.RED);
            information.setText("Incorrect answer, Try again or take next question!");
        }
    }

    @FXML
    private void handleNext(ActionEvent event) {
        clearForm();
        nextAssignment();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
