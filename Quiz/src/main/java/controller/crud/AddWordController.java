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

public class AddWordController {
    public Stage window;
    private Dictionary dictionary;

    @FXML
    public TextField polishTextField, englishTextField;
    public Label resultLabel;

    @FXML
    public void initialize() {
        this.window = Main.window;
    }

    public void addWord(ActionEvent actionEvent) throws IOException {
        String polishWord = polishTextField.getText();
        String englishWord = englishTextField.getText();
        for(int i=0; i<dictionary.getWordList().size(); i++){
            if(dictionary.getWordList().get(i).getPolishWord().equals(polishWord) || dictionary.getWordList().get(i).getEnglishWord().equals(englishWord)){
                resultLabel.setText("Dane słowo już jest w słowniku!");
                return;
            }
        } if (polishTextField.getText().equals("") || englishTextField.getText().equals("")) {
            resultLabel.setText("Pola nie mogą być puste!");
        } else {
            FileWriter writer = new FileWriter(new File(Objects.requireNonNull(MainLauncher.class.getClassLoader().getResource(dictionary.getLevel().getName() + "dictionary")).getFile()), true);
            writer.write(englishTextField.getText() + " = " + polishTextField.getText() + "\n");
            resultLabel.setText("Dodano słowo.");
            writer.close();
            dictionary = new Dictionary(dictionary.getLevel());
        }
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
