package controller.crud;

import controller.MenuController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import main.Main;
import model.Dictionary;
import model.progress.Level;

import java.util.Map;

public class DictionaryController {
    public static Map<String, String> oldDict;
    public Stage window;
    private String selectedLevel = "A1"; //TODO: unhardcode
    private Dictionary dictionary;

    public static void loadDictionary(String selectedLevel) {
    }

    @FXML
    public void initialize() {
        this.window = Main.window;
    }

    public Dictionary getDictionary() {
        return dictionary;
    }

    public void addWord(ActionEvent actionEvent) throws Exception {
        this.dictionary = new Dictionary(new Level(this.selectedLevel));
        AddWordController addWordController = new AddWordController(this);
    }

    public void editWord(ActionEvent actionEvent) throws Exception {
        this.dictionary = new Dictionary(new Level(this.selectedLevel));
        EditWordController editWordController = new EditWordController(this);
    }

    public void removeWord(ActionEvent actionEvent) throws Exception {
        this.dictionary = new Dictionary(new Level(this.selectedLevel));
        RemoveWordController removeWordController = new RemoveWordController(this);
    }

    public void back(ActionEvent actionEvent) throws Exception {
        new MenuController();
    }
}
