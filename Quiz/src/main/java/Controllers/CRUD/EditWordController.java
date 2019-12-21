package Controllers.CRUD;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import MainPackage.Main;

public class EditWordController {
    public Stage window;

    public Button returnButton;

    @FXML
    public void initialize(){
        this.window = Main.window;
    }

    public void back(ActionEvent actionEvent) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/CRUD/DictionaryView.fxml"));
        window.setScene(new Scene(root));
        window.show();
    }
}
