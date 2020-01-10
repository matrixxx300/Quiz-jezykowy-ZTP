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
    public TextField polishTextField, englishTextField;
    public Label resultLabel;

    public RemoveWordController(DictionaryController dictionaryController) throws IOException {
        this.dictionary = dictionaryController.getDictionary();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/crud/RemoveWordView.fxml"));
        loader.setController(this);

        this.window = Main.window;
        window.setScene(new Scene(loader.load()));
        window.setTitle("Usuwanie słowa");
        window.show();
    }

    @FXML
    public void initialize() {
    }

    public void back(ActionEvent actionEvent) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/crud/DictionaryView.fxml"));
        window.setScene(new Scene(root));
        window.show();
    }

    public void removeWord(ActionEvent actionEvent) throws IOException {
        Word wordToAdd = new Word(englishTextField.getText(), polishTextField.getText());
        if (!dictionary.getWordList().contains(wordToAdd)) {
            resultLabel.setText("Danego słowa nie ma w słowniku!");
        } else if (polishTextField.getText().equals("") && englishTextField.getText().equals("")) {
            resultLabel.setText("Pola nie mogą być puste!");
        } else {
            FileWriter writer = new FileWriter(new File(Objects.requireNonNull(MainLauncher.class.getClassLoader().getResource("dictionary")).getFile()), true);
            //dictionary.get(polishTextField.getText());
            //writer.write(polishTextField.getText() + "=" + englishTextField.getText() + "\n");
            resultLabel.setText("Usunięto słowo.");
            writer.close();
            dictionary = new Dictionary(dictionary.getLevel());
        }
    }
}
