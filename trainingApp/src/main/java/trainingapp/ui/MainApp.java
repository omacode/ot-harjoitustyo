package trainingapp.ui;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import trainingapp.dao.FakeAssignmentDao;
import trainingapp.dao.FakePlayerDao;
import trainingapp.domain.AssignmentService;


public class MainApp extends Application {
    
    private Stage stage;
    private AssignmentService assignmentService;
    private Scene logInScene;
    private Scene newUserScene;
    private Scene trainingScene;
    
    @Override
    public void init() throws Exception {
        assignmentService = new AssignmentService(new FakeAssignmentDao(), new FakePlayerDao());
        
        FXMLLoader loginSceneLoader = new FXMLLoader(getClass().getResource("/fxml/LogInScene.fxml"));
        Parent logInPane = loginSceneLoader.load();
        LogInSceneController logInSceneController = loginSceneLoader.getController();
        logInSceneController.setAssignmentService(assignmentService);
        logInSceneController.setApplication(this);
        logInScene = new Scene(logInPane);
        
        FXMLLoader newUserSceneLoader = new FXMLLoader(getClass().getResource("/fxml/NewUserScene.fxml"));
        Parent newUserPane = newUserSceneLoader.load();
        NewUserSceneController newUserSceneController = newUserSceneLoader.getController();
        newUserSceneController.setAssignmentService(assignmentService);
        newUserSceneController.setApplication(this);
        newUserScene = new Scene(newUserPane);
        
        FXMLLoader trainingSceneLoader = new FXMLLoader(getClass().getResource("/fxml/TrainingScene.fxml"));
        Parent trainingPane = trainingSceneLoader.load();
        TrainingSceneController trainingSceneController = trainingSceneLoader.getController();
        trainingSceneController.setAssignmentService(assignmentService);
        trainingSceneController.setApplication(this);
        trainingScene = new Scene(trainingPane);  
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        
        stage.setTitle("TrainingApp");
        setLogInScene();
        stage.show();
    }

    public void setLogInScene() {
        stage.setScene(logInScene);
    }
    
    public void setNewUserScene() {
        stage.setScene(newUserScene);
    }
    
    public void setTrainingScene() {
        stage.setScene(trainingScene);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
