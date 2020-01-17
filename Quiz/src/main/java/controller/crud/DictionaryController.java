package controller.crud;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import main.Main;
import model.Dictionary;
import model.Level;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

public class DictionaryController {
    public Stage window;

    private String selectedLevel = "A1";
    private Dictionary dictionary;

    @FXML
    public void initialize() {
        this.window = Main.window;
    }

    public void setLevel(String selectedLevel){
        this.selectedLevel = selectedLevel;
    }

    public Dictionary getDictionary() {
        return dictionary;
    }

    public static Map<String, String> oldDict;

    public static void loadDictionary(String selectedLevel) {
    }

    public void addWord(ActionEvent actionEvent) throws Exception {
        this.dictionary = new Dictionary(new Level(this.selectedLevel));
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/crud/AddWordView.fxml"));
        Parent root = (Parent)fxmlLoader.load();
        AddWordController controller = fxmlLoader.<AddWordController>getController();
        controller.setDictionary(dictionary);
        Scene scene = new Scene(root);
        window.setScene(scene);
        window.show();
    }

    public void editWord(ActionEvent actionEvent) throws Exception {
        this.dictionary = new Dictionary(new Level(this.selectedLevel));
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/crud/EditWordView.fxml"));
        Parent root = (Parent)fxmlLoader.load();
        EditWordController controller = fxmlLoader.<EditWordController>getController();
        controller.setDictionary(dictionary);
        Scene scene = new Scene(root);
        window.setScene(scene);
        window.show();
    }

    public void removeWord(ActionEvent actionEvent) throws Exception {
        this.dictionary = new Dictionary(new Level(this.selectedLevel));
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/crud/RemoveWordView.fxml"));
        Parent root = (Parent)fxmlLoader.load();
        RemoveWordController controller = fxmlLoader.<RemoveWordController>getController();
        controller.setDictionary(dictionary);
        Scene scene = new Scene(root);
        window.setScene(scene);
        window.show();
    }

    public void back(ActionEvent actionEvent) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/crud/DictionaryLevelSelectView.fxml"));
        window.setScene(new Scene(root));
        window.show();
    }

    public void dictionaryList(ActionEvent actionEvent) throws IOException {
        this.dictionary = new Dictionary(new Level(this.selectedLevel));
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/crud/DictionaryListView.fxml"));
        Parent root = (Parent)fxmlLoader.load();
        DictionaryListController controller = fxmlLoader.<DictionaryListController>getController();
        controller.setDictionary(dictionary);
        Scene scene = new Scene(root);
        window.setScene(scene);
        window.show();
    }
}
