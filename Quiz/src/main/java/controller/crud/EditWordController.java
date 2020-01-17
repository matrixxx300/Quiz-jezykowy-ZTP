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

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

public class EditWordController {
    public Stage window;
    private Dictionary dictionary;

    @FXML
    public TextField polishTextField, englishTextField;
    public Label resultLabel;

    @FXML
    public void initialize() {
        this.window = Main.window;
    }

    public void editWord(ActionEvent actionEvent) throws IOException {
        String polishWord = polishTextField.getText();
        String englishWord = englishTextField.getText();
        if (polishTextField.getText().equals("") || englishTextField.getText().equals("")) {
            resultLabel.setText("Pola nie mogą być puste!");
            return;
        }
        for (int i = 0; i < dictionary.getWordList().size(); i++) {
            if (dictionary.getWordList().get(i).getPolishWord().equals(polishWord) || dictionary.getWordList().get(i).getEnglishWord().equals(englishWord)) {
                resultLabel.setText("Dane słowa już istnieją.");
                return;
            } else if (dictionary.getWordList().get(i).getPolishWord().equals(polishWord) && !dictionary.getWordList().get(i).getEnglishWord().equals(englishWord)) {
                dictionary.getWordList().get(i).setEnglishWord(englishWord);
                resultLabel.setText("Zedytowano słowo.");
                saveDictionary();
                return;
            } else if (dictionary.getWordList().get(i).getEnglishWord().equals(englishWord) && !dictionary.getWordList().get(i).getPolishWord().equals(polishWord)) {
                resultLabel.setText("Zedytowano słowo.");
                dictionary.getWordList().get(i).setPolishWord(polishWord);
                saveDictionary();
                return;
            }
        }
        resultLabel.setText("Nie znaleziono słowa.");
    }

    private void saveDictionary() throws IOException {
        FileWriter writer = new FileWriter(new File(Objects.requireNonNull(MainLauncher.class.getClassLoader().getResource(dictionary.getLevel().getName() + "dictionary")).getFile()), true);
        writer.write(englishTextField.getText() + " = " + polishTextField.getText() + "\n");
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
