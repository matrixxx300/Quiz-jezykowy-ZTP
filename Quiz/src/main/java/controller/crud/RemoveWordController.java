package controller.crud;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.Main;
import main.MainLauncher;
import model.Dictionary;
import model.Word;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

public class RemoveWordController {
    public Stage window;
    private Dictionary dictionary;

    @FXML
    public TextField wordTextField;
    public Label resultLabel;

    @FXML
    public void initialize() {
        this.window = Main.window;
    }

    public void removeWord(ActionEvent actionEvent) throws IOException {
        String word = wordTextField.getText();

        if (wordTextField.getText().equals("")) {
            resultLabel.setText("Pole nie moze być puste!");
            return;
        }
        for (int i = 0; i < dictionary.getWordList().size(); i++) {
            if (dictionary.getWordList().get(i).getPolishWord().equals(word) || dictionary.getWordList().get(i).getEnglishWord().equals(word)) {
                resultLabel.setText("Usunięto słowo.");
                dictionary.getWordList().remove(i);
                saveDictionary();
                return;
            }
        }
        resultLabel.setText("Nie znaleziono słowa.");
    }

    private void saveDictionary() throws IOException {
        FileWriter writer = new FileWriter(new File(Objects.requireNonNull(MainLauncher.class.getClassLoader().getResource(dictionary.getLevel().getName() + "dictionary")).getFile()), false);
        for (int i = 0; i < dictionary.getWordList().size(); i++) {
            writer.write(dictionary.getWordList().get(i).getEnglishWord() + " = " + dictionary.getWordList().get(i).getPolishWord() + "\n");
        }
        writer.close();
        dictionary = new Dictionary(dictionary.getLevel());
    }

    public void back(ActionEvent actionEvent) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/crud/DictionaryView.fxml"));
        window.setScene(new Scene(root));
        window.show();
    }

    public void setDictionary(Dictionary dictionary) {
        this.dictionary = dictionary;
    }
}

