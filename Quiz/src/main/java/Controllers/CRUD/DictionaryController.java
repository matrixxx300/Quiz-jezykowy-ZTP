package Controllers.CRUD;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import MainPackage.Main;

public class DictionaryController {
    public Stage window;

    public Button returnButton;

    @FXML
    public void initialize(){
        this.window = Main.window;
    }

    public void addWord(ActionEvent actionEvent) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/CRUD/AddWordView.fxml"));
        window.setScene(new Scene(root));
        window.show();
    }

    public void editWord(ActionEvent actionEvent) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/CRUD/EditWordView.fxml"));
        window.setScene(new Scene(root));
        window.show();
    }

    public void removeWord(ActionEvent actionEvent) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/CRUD/RemoveWordView.fxml"));
        window.setScene(new Scene(root));
        window.show();
    }

    public void back(ActionEvent actionEvent) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/MenuView.fxml"));
        window.setScene(new Scene(root));
        window.show();
    }
}
