package controller;

import au.edu.uts.ap.javafx.ViewLoader;
import au.edu.uts.ap.javafx.Controller;
import java.io.IOException;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.stage.*;
import javafx.scene.image.Image;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import model.*;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.ObservableList;



public class RecordController extends Controller<ObservableList<Record>> {
    @FXML private TableView<Record> recordTv;
    @FXML private TableColumn<Record, Number> round;
    @FXML private TableColumn<Record, Number> game;
    @FXML private TableColumn<Record, String> win;
    @FXML private TableColumn<Record, String> lose;


    @FXML private void initialize() {
        recordTv.setItems(model);
        round.setCellValueFactory(cellData -> cellData.getValue().roundProperty());
        game.setCellValueFactory(cellData -> cellData.getValue().gameNumberProperty());
        win.setCellValueFactory(cellData -> cellData.getValue().winTeamProperty());
        lose.setCellValueFactory(cellData -> cellData.getValue().loseTeamProperty());
        round.setStyle("-fx-alignment: CENTER;");
        game.setStyle("-fx-alignment: CENTER;");
        win.setStyle("-fx-alignment: CENTER;");
        lose.setStyle("-fx-alignment: CENTER;");
    }

    @FXML private void close() {
        stage.close();
    }
    
}







