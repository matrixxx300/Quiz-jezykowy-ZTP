package controller.crud;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import main.Main;
import model.Dictionary;

import java.util.ArrayList;

public class DictionaryListController {
    public Stage window;
    public ObservableList<String> dictionaryList;
    public ListView<String> list;
    public ArrayList<String> array;

    private Dictionary dictionary;

    @FXML
    public void initialize() {
        this.window = Main.window;
    }

    void setDictionary(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public void back(ActionEvent actionEvent) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/crud/DictionaryView.fxml"));
        window.setScene(new Scene(root));
        window.show();
    }

    public void loadList() {
        array = new ArrayList<>();
        for (int i = 0; i < dictionary.getWordList().size(); i++) {
            array.add(dictionary.getWordList().get(i).getEnglishWord() + " = " + dictionary.getWordList().get(i).getPolishWord());
        }
        dictionaryList = FXCollections.observableArrayList(array);
        list.setItems(dictionaryList);
    }

}