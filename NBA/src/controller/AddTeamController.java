package controller;

import au.edu.uts.ap.javafx.ViewLoader;
import au.edu.uts.ap.javafx.Controller;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.stage.*;
import javafx.scene.image.Image;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import model.*;




public class AddTeamController extends Controller<Teams> {
    @FXML private TextField nameTf;
    @FXML private Button addBtn;

    @FXML private void initialize() {
        
    }

    @FXML 
    private void handleAdd() {
        String name = nameTf.getText();
            if (name.isEmpty()) {
                try {
                    Stage errorStage = new Stage();
                    errorStage.setX(ViewLoader.X + 601);
                    errorStage.setY(ViewLoader.Y);
                    errorStage.getIcons().add(new Image("/view/error.png"));
                    InputException exception = new InputException("Name cannot be empty.");
                    ViewLoader.showStage(exception, "/view/error.fxml", "Error!", errorStage);
            
                } catch (IOException e) {
                    System.err.println("Error loading error stage: " + e.getMessage());
                    e.printStackTrace();
                }
                    }

            else if (model.hasTeam(name)) {
                try {
                    Stage errorStage = new Stage();
                    errorStage.setX(ViewLoader.X + 601);
                    errorStage.setY(ViewLoader.Y);
                    errorStage.getIcons().add(new Image("/view/error.png"));
            
                    InputException exception = new InputException("The " + model.getTeam(name) + " already exist.");
                    ViewLoader.showStage(exception, "/view/error.fxml", "Error!", errorStage);
            
                } catch (IOException e) {
                    System.err.println("Error loading error stage: " + e.getMessage());
                    e.printStackTrace();
                }
                    } else {
                Team team = new Team(name);
                model.addTeam(team);
                stage.close();
            }
    }    
}
