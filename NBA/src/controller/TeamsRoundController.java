package controller;


import au.edu.uts.ap.javafx.ViewLoader;
import au.edu.uts.ap.javafx.Controller;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.stage.*;
import javafx.scene.image.Image;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import model.*;


public class TeamsRoundController extends Controller<Season> {
    @FXML private Button arrangeSeasonBtn;
    @FXML private Button sendBtn;
    @FXML private Label roundLbl;
    @FXML private ListView<Team> teamsLv;
    @FXML private TableView<Game> gamesTv;
    @FXML private TableColumn<Game, Number> game;
    @FXML private TableColumn<Game, String> team1;
    @FXML private TableColumn<Game, String> team2;




    @FXML private void initialize() {
        roundLbl.setText("Round " + (model.round() + 1));
        teamsLv.setItems(model.getCurrentTeams());
        teamsLv.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        teamsLv.getSelectionModel().getSelectedItems().addListener((ListChangeListener<Team>) change -> {
            ObservableList<Team> selectedTeams = teamsLv.getSelectionModel().getSelectedItems();
            sendBtn.setDisable(selectedTeams.size() != 2);
        });

        teamsLv.getItems().addListener((ListChangeListener<Team>) change -> {
            if (teamsLv.getItems().isEmpty()) {
                arrangeSeasonBtn.setDisable(false);
            }
        });

        gamesTv.setItems(model.getCurrentSchedule());
        game.setCellValueFactory(cellData -> cellData.getValue().termProperty());
        team1.setCellValueFactory(cellData -> cellData.getValue().team1());
        team2.setCellValueFactory(cellData -> cellData.getValue().team2());


    }


    @FXML private void handleSend() {
        ObservableList<Team> teams = teamsLv.getSelectionModel().getSelectedItems();
        model.addTeams(teams);
    }

    @FXML private void handleArrangeSeason() {
        stage.close();
    }
}



