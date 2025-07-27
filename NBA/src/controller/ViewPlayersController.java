package controller;

import au.edu.uts.ap.javafx.ViewLoader;
import au.edu.uts.ap.javafx.Controller;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.stage.*;
import javafx.scene.image.Image;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import model.*;



public class ViewPlayersController extends Controller<Players> {
    @FXML private TableView<Player> allPlayersTv;
    @FXML private TextField levelTf;
    @FXML private TextField nameTf;
    @FXML private TextField fromTf;
    @FXML private TextField toTf;





    @FXML private void initialize() {
        allPlayersTv.setItems(model.getFilteredPlayersList());
        levelTf.textProperty().addListener((obs, oldVal, newVal) -> applyFilter());
        nameTf.textProperty().addListener((obs, oldVal, newVal) -> applyFilter());
        fromTf.textProperty().addListener((obs, oldVal, newVal) -> applyFilter());
        toTf.textProperty().addListener((obs, oldVal, newVal) -> applyFilter());

    }

    private void applyFilter() {
        String level = levelTf.getText().trim();
        String name = nameTf.getText().trim();
        int from = 0;
        int to = 99;
        try {
            if (!fromTf.getText().isEmpty())
                from = Integer.parseInt(fromTf.getText());
            if (!toTf.getText().isEmpty())
                to = Integer.parseInt(toTf.getText());
        } catch (NumberFormatException e) {

        }
        model.filterList(name, level, from, to);
    }


    @FXML private void close() {stage.close();}


}

