package controller;

import au.edu.uts.ap.javafx.ViewLoader;
import au.edu.uts.ap.javafx.Controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.stage.*;
import javafx.scene.image.Image;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import model.*;



public class SeasonController extends Controller<Season> {
    @FXML private Button roundBtn;
    @FXML private Button currentBtn;
    @FXML private Button gameBtn;
    @FXML private Button resultBtn;

    @FXML private void initialize() {

    }

    @FXML private void handleRound() {
        try {
            Stage stage = new Stage();
            stage.setX(ViewLoader.X + 601);
            stage.setY(ViewLoader.Y);
            stage.getIcons().add(new Image("/view/nba.png"));
            ViewLoader.showStage(model, "/view/SeasonRoundView.fxml", "Season Rounds", stage);
        } catch (IOException ex) {
            Logger.getLogger(AssociationController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML private void handleCurrent() {
        try {
            Stage stage = new Stage();
            stage.setX(ViewLoader.X + 601);
            stage.setY(ViewLoader.Y);
            stage.getIcons().add(new Image("/view/nba.png"));
            
            ViewLoader.showStage(model, "/view/CurrentRoundTeams.fxml", "Tournament", stage);
        } catch (IOException ex) {
            Logger.getLogger(AssociationController.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    @FXML private void handleGame() {
        if (model.getCurrentTeams().size() == 0) {
            model.playGame();
            try {
                String message = "";
                if (model.getCurrentTeams().size() == 1) {
                    message = "This season ends!\n" + model.getCurrentTeams().get(0).getName() + " are the champions!";
                }

                Stage errorStage = new Stage();
                errorStage.setX(ViewLoader.X + 601);
                errorStage.setY(ViewLoader.Y);
                errorStage.getIcons().add(new Image("/view/nba.png"));
                InputException exception = new InputException("All games finished!\nYou can check the results now!\n" + message);
                ViewLoader.showStage(exception, "/view/error.fxml", "All games played!", errorStage);
            } catch (IOException ex) {
                Logger.getLogger(AssociationController.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            try {
                Stage errorStage = new Stage();
                errorStage.setX(ViewLoader.X + 601);
                errorStage.setY(ViewLoader.Y);
                errorStage.getIcons().add(new Image("/view/nba.png"));
                InputException exception = new InputException("No games to play!\nPlease add games to this round.");
                ViewLoader.showStage(exception, "/view/error.fxml", "No games played!", errorStage);
            } catch (IOException ex) {
                Logger.getLogger(AssociationController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML private void handleResult() {
        ObservableList<Record> records = model.record(); 
        try {
            Stage stage = new Stage();
            stage.setX(ViewLoader.X + 601);
            stage.setY(ViewLoader.Y);
            stage.getIcons().add(new Image("/view/nba.png"));
            ViewLoader.showStage(records, "/view/RecordView.fxml", "Season Record", stage);
        } catch (IOException ex) {
            Logger.getLogger(AssociationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML private void close() { stage.close(); }



}

