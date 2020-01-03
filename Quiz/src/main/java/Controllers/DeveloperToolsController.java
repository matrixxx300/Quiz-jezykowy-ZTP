package Controllers;

import MainPackage.Main;
import MainPackage.Menu;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class DeveloperToolsController {
    public Stage window;
    public Button DF1button;
    private String DF1name = "convert 'newline dict' to 'hyphen dict'";

    @FXML
    public void initialize() {
        this.window = Main.window;
        this.DF1button.setText(DF1name);
    }

    public void developerFunction1(ActionEvent actionEvent) {

    }
}
