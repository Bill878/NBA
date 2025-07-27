package controller;


import au.edu.uts.ap.javafx.ViewLoader;
import au.edu.uts.ap.javafx.Controller;
import java.io.IOException;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.fxml.FXML;
import javafx.stage.*;
import javafx.scene.image.Image;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import model.*;



public class CurrentRoundTeamsController extends Controller<Season> {
    @FXML private TableView<Game> gamesTv;
    @FXML private TableColumn<Game, String> team1;
    @FXML private TableColumn<Game, String> vs;
    @FXML private TableColumn<Game, String> team2;
    @FXML private Label roundLbl;

    @FXML private void initialize() {
        roundLbl.setText("Round " + (model.round() + 1));
        gamesTv.setItems(model.getCurrentSchedule());
        team1.setCellValueFactory(cellData -> cellData.getValue().team1());
        vs.setCellValueFactory(cellData -> new ReadOnlyStringWrapper("vs"));
        team2.setCellValueFactory(cellData -> cellData.getValue().team2());
        team1.setStyle("-fx-alignment: CENTER;");
        vs.setStyle("-fx-alignment: CENTER;");
        team2.setStyle("-fx-alignment: CENTER;");

    }


    @FXML private void close() {
        stage.close();
    }




  
}







