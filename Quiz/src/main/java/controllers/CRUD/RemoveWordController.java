package controllers.CRUD;

import MainPackage.Main;
import MainPackage.MainLauncher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.Dictionary;

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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CRUD/RemoveWordView.fxml"));
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
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/CRUD/DictionaryView.fxml"));
        window.setScene(new Scene(root));
        window.show();
    }

    public void removeWord(ActionEvent actionEvent) throws IOException {
        if (!dictionary.getWordList().containsKey(polishTextField.getText())) {
            resultLabel.setText("Danego słowa nie ma w słowniku!");
        } else if (!dictionary.getWordList().containsValue(englishTextField.getText())) {
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
