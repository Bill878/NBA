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



public class ErrorController extends Controller<InputException> {
    @FXML private Label errorLbl;

    @FXML private void close() {
        stage.close();
    }

    @FXML private void initialize() {
        // Optional default message
        errorLbl.setText(model.getMessage());
    }
}
