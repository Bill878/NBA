package controller;

import au.edu.uts.ap.javafx.ViewLoader;
import au.edu.uts.ap.javafx.Controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.stage.*;
import javafx.util.converter.NumberStringConverter;
import javafx.scene.image.Image;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import model.*;




public class PlayerUpdateController  extends Controller<Player> {
    @FXML private Button updateBtn;
    @FXML private Button addBtn;
    @FXML private Button closeBtn;
    @FXML private TextField nameTf;
    @FXML private TextField creditTf;
    @FXML private TextField ageTf;
    @FXML private TextField noTf;


@FXML
private void initialize() {
    if (model.getName().isEmpty()) {
        updateBtn.setDisable(true);
    } else {
        addBtn.setDisable(true);
    }

    nameTf.setText(model.getName());
    creditTf.setText(String.format("%.1f", model.getCredit()));
    ageTf.setText(String.valueOf(model.getAge()));
    noTf.setText(String.valueOf(model.getNo()));
}


    @FXML 
    private void handleUpdate() {
        String name = nameTf.getText();
        String ageInput = ageTf.getText();
        String noInput = noTf.getText();
        int age = -1;
        int no = -1;
        Double credit = null;
        List<String> errors = new ArrayList<>();
         
        if (name.isEmpty()) errors.add("Name cannot be empty.");

        try {
            credit = Double.parseDouble(creditTf.getText());

            if (credit < 0) errors.add("Credit must be non-negative.");
        } catch (NumberFormatException e) {
            errors.add("Credit must be a valid number.");
        }

        if (ageInput.isEmpty()) {
            errors.add("Age must be a number.");
        } else {
            try {
                age = Integer.parseInt(ageTf.getText());
                if (age < 18) errors.add("Age must be at least 18.");
            } catch (NumberFormatException e) {
                errors.add("Age must be a number.");
            }
        }

        if (noInput.isEmpty()) {
            errors.add("No cannot be empty.");
        } else {
            try {
                no = Integer.parseInt(noInput);
                if (no < 0 || no > 99) errors.add("Invalid No.");
            } catch (NumberFormatException e) {
                errors.add("No must be an integer between 0 and 99.");
            }
        }

//  implement if no already taken "no already worn by " + insert player name.
        

            if (!errors.isEmpty()) {
                try {
                    Stage errorStage = new Stage();
                    errorStage.setX(ViewLoader.X + 601);
                    errorStage.setY(ViewLoader.Y);
                    errorStage.getIcons().add(new Image("/view/error.png"));
                    String errorMessage = String.join("\n", errors);
                    InputException exception = new InputException(errorMessage);
                    ViewLoader.showStage(exception, "/view/error.fxml", "Error!", errorStage);
            
                } catch (IOException e) {
                    System.err.println("Error loading error stage: " + e.getMessage());
                    e.printStackTrace();
                }
            } else {
                Team team = model.getTeam();
                Player player = new Player(name, credit, age, no);
                player.setTeam(team);
                team.getPlayers().addPlayer(player);
                team.getPlayers().removePlayer(model);

                stage.close();
            }

    }    

    @FXML
    private void handleAdd() {
        String name = nameTf.getText();
        String ageInput = ageTf.getText();
        String noInput = noTf.getText();
        int age = -1;
        int no = -1;
        Double credit = null;
        List<String> errors = new ArrayList<>();
         
        if (name.isEmpty()) errors.add("Name cannot be empty.");

        try {
            credit = Double.parseDouble(creditTf.getText());

            if (credit < 0) errors.add("Credit must be non-negative.");
        } catch (NumberFormatException e) {
            errors.add("Credit must be a valid number.");
        }

        if (ageInput.isEmpty()) {
            errors.add("Age must be a number.");
        } else {
            try {
                age = Integer.parseInt(ageTf.getText());
                if (age < 18) errors.add("Age must be at least 18.");
            } catch (NumberFormatException e) {
                errors.add("Age must be a number.");
            }
        }

        if (noInput.isEmpty()) {
            errors.add("No cannot be empty.");
        } else {
            try {
                no = Integer.parseInt(noInput);
                if (no < 0 || no > 99) errors.add("Invalid No.");
            } catch (NumberFormatException e) {
                errors.add("No must be an integer between 0 and 99.");
            }
        }

            if (!errors.isEmpty()) {
                try {
                    Stage errorStage = new Stage();
                    errorStage.setX(ViewLoader.X + 601);
                    errorStage.setY(ViewLoader.Y);
                    errorStage.getIcons().add(new Image("/view/error.png"));
                    String errorMessage = String.join("\n", errors);
                    InputException exception = new InputException(errorMessage);
                    ViewLoader.showStage(exception, "/view/error.fxml", "Error!", errorStage);
            
                } catch (IOException e) {
                    System.err.println("Error loading error stage: " + e.getMessage());
                    e.printStackTrace();
                }
            } else {
                Team team = model.getTeam();
                Player player = new Player(name, credit, age, no);
                player.setTeam(team);
                team.getPlayers().addPlayer(player);
                stage.close();
            }
    }    

    @FXML 
    private void handleClose() {
        stage.close();
    }    


}
