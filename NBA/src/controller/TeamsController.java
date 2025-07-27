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


public class TeamsController extends Controller<Teams> {
    @FXML private Button addBtn;
    @FXML private Button manageBtn;
    @FXML private Button deleteBtn;
    @FXML private TableView<Team> teamsTv;
    @FXML private TableColumn<Team, String> avgCreditColumn;
    @FXML private TableColumn<Team, String> avgAgeColumn;



    @FXML private void initialize() {
        teamsTv.setItems(model.currentTeams());
        avgCreditColumn.setCellValueFactory(cellData -> cellData.getValue().countAvgCreditProperty().asString("%.2f"));
        avgAgeColumn.setCellValueFactory(cellData -> cellData.getValue().countAvgAgeProperty().asString("%.2f"));
    
    
        teamsTv.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue) -> {
                manageBtn.setDisable(newValue == null);
                deleteBtn.setDisable(newValue == null);
                addBtn.setDisable(newValue != null);
            });
                    
    }

    @FXML private void handleAdd() {
        try {
            Stage stage = new Stage();
            stage.setX(ViewLoader.X + 601);
            stage.setY(ViewLoader.Y);
            stage.getIcons().add(new Image("/view/edit.png"));
            
            ViewLoader.showStage(model, "/view/AddTeam.fxml", "Adding New Team", stage);
        } catch (IOException ex) {
            Logger.getLogger(AssociationController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML private void handleManage() {
        try {
            Stage stage = new Stage();
            stage.setX(ViewLoader.X + 601);
            stage.setY(ViewLoader.Y);
            stage.getIcons().add(new Image("/view/edit.png"));

            Team team = teamsTv.getSelectionModel().getSelectedItem();
            
            ViewLoader.showStage(team, "/view/ManageTeamView.fxml", "Managing team: " + teamsTv.getSelectionModel().getSelectedItem().getName(), stage);
        } catch (IOException ex) {
            Logger.getLogger(AssociationController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML private void handleDelete() {
        Team team = teamsTv.getSelectionModel().getSelectedItem();
        model.remove(team);
    }

    @FXML private void close() {stage.close();}



}

