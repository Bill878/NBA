package controller;


import au.edu.uts.ap.javafx.ViewLoader;
import au.edu.uts.ap.javafx.Controller;
import java.io.IOException;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.stage.*;
import javafx.scene.image.Image;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import model.*;



public class ManageTeamController extends Controller<Team> {
    @FXML private Button addBtn;
    @FXML private Button updateBtn;
    @FXML private Button deleteBtn;
    @FXML private TableView<Player> playersTv;
    @FXML private TextField nameTf;



    @FXML private void initialize() {
        playersTv.setItems(model.getCurrentPlayers());
        nameTf.setText(model.getName());

        playersTv.getSelectionModel().selectedItemProperty().addListener(
        (observable, oldValue, newValue) -> {
            addBtn.setDisable(newValue != null);
            updateBtn.setDisable(newValue == null);
            deleteBtn.setDisable(newValue == null);
        });


    }

    @FXML private void handleAdd() {
        try {
            Stage stage = new Stage();
            stage.setX(ViewLoader.X + 601);
            stage.setY(ViewLoader.Y);
            stage.getIcons().add(new Image("/view/edit.png"));
            Player player = new Player("", -1.0, -1, -1);
            player.setTeam(model);
    
            ViewLoader.showStage(player, "/view/PlayerUpdateView.fxml", "Add New Player", stage);
        } catch (IOException ex) {
            Logger.getLogger(AssociationController.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    

    @FXML private void handleUpdate() {
        Player player = getSelectedPlayer();
        try {
            Stage stage = new Stage();
            stage.setX(ViewLoader.X + 601);
            stage.setY(ViewLoader.Y);
            stage.getIcons().add(new Image("/view/edit.png"));
            ViewLoader.showStage(player, "/view/PlayerUpdateView.fxml", "Updating Player: " + player.getName(), stage);
        } catch (IOException ex) {
            Logger.getLogger(AssociationController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML private void handleDelete() {
        Player player = getSelectedPlayer();
        model.getPlayers().removePlayer(player);
    }

    @FXML private void close() {
        String name = nameTf.getText();
        if (name.isEmpty()) {
            try {
                Stage stage = new Stage();
                stage.setX(ViewLoader.X + 601);
                stage.setY(ViewLoader.Y);
                stage.getIcons().add(new Image("/view/error.png"));
                InputException exception = new InputException("Please enter a team name.");
                ViewLoader.showStage(exception, "/view/error.fxml", "Error!", stage);
        
            } catch (IOException e) {
                System.err.println("Error loading error stage: " + e.getMessage());
                e.printStackTrace();
            }

        } else {
            model.setName(name);;
            stage.close();
        }

    }

    private Player getSelectedPlayer() {
        return playersTv.getSelectionModel().getSelectedItem();
    }

}
