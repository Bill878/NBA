package controller;

import au.edu.uts.ap.javafx.ViewLoader;
import au.edu.uts.ap.javafx.Controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.stage.*;
import javafx.scene.image.Image;
import javafx.scene.control.*;
import model.*;



public class ExploreTeamsController extends Controller<Teams> {
    @FXML private Button teamsBtn;
    @FXML private Button viewBtn;
    
    @FXML private void initialize() {
    }

    @FXML private void close() { stage.close(); }

    @FXML private void handleTeamsMenu() {
        try {
            Stage stage = new Stage();
            stage.setX(ViewLoader.X + 601);
            stage.setY(ViewLoader.Y);
            stage.getIcons().add(new Image("/view/nba.png"));
            
            ViewLoader.showStage(model, "/view/TeamsTable.fxml", "Teams Menu", stage);
        } catch (IOException ex) {
            Logger.getLogger(AssociationController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML private void handleViewPlayers() {
        Players players = new Players();
        players.addPlayers(new ArrayList<>(model.allPlayersList()));
        players.filterList("", "", 0, 0); 

        try {
            Stage stage = new Stage();
            stage.setX(ViewLoader.X + 601);
            stage.setY(ViewLoader.Y);
            stage.getIcons().add(new Image("/view/nba.png"));
            
            ViewLoader.showStage(players, "/view/PlayersView.fxml", "View All Players", stage);
        } catch (IOException ex) {
            Logger.getLogger(AssociationController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


}

