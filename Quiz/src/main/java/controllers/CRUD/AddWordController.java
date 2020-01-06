package controllers.CRUD;

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
import models.Dictionary;
import models.Word;

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

    public AddWordController(DictionaryController dictionaryController) throws IOException {
        this.dictionary = dictionaryController.getDictionary();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CRUD/AddWordView.fxml"));
        loader.setController(this);

        this.window = Main.window;
        this.window.setScene(new Scene(loader.load()));
        this.window.setTitle("Dodawanie słowa");
        this.window.show();
    }

    @FXML
    public void initialize() {
    }

    public void addWord(ActionEvent actionEvent) throws IOException {
        Word wordToAdd = new Word(englishTextField.getText(), polishTextField.getText());
        if (dictionary.getWordList().contains(wordToAdd)) {
            resultLabel.setText("Dane słowo już jest w słowniku!");
        } else if (polishTextField.getText().equals("") || englishTextField.getText().equals("")) {
            resultLabel.setText("Pola nie mogą być puste!");
        } else {
            FileWriter writer = new FileWriter(new File(Objects.requireNonNull(MainLauncher.class.getClassLoader().getResource(dictionary.getLevel().getName() + "dictionary")).getFile()), true);
            writer.write(polishTextField.getText() + "=" + englishTextField.getText() + "\n");
            resultLabel.setText("Dodano słowo.");
            writer.close();
            dictionary = new Dictionary(dictionary.getLevel());
        }
    }

    public void back(ActionEvent actionEvent) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/CRUD/DictionaryView.fxml"));
        window.setScene(new Scene(root));
        window.show();
    }
}
