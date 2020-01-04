package Controllers.CRUD;

import MainPackage.Main;
import MainPackage.MainLauncher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.Dictionary;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

public class EditWordController {
    public Stage window;

    public Button returnButton;

    @FXML
    public TextField polishTextField, englishTextField;
    public Label resultLabel;
    private Dictionary dictionary;
    private String selectedLevel = "A1"; //TODO: unhardcode

    public EditWordController(DictionaryController dictionaryController) {
        this.dictionary = dictionaryController.getDictionary();
    }

    @FXML
    public void initialize() {
        this.window = Main.window;
    }

    public void editWord(ActionEvent actionEvent) throws IOException {
        //TODO WSTAWIC ITERATOR
//        if (!dictionary.getWordList().containsKey(polishTextField.getText())) {
//            resultLabel.setText("Danego słowa nie ma w słowniku!");
//        } else if (!dictionary.getWordList().containsValue(englishTextField.getText())) {
//            resultLabel.setText("Danego słowa nie ma w słowniku!");
        if (polishTextField.getText().equals("") || englishTextField.getText().equals("")) {
            resultLabel.setText("Pola nie mogą być puste!");
        } else {
            FileWriter writer = new FileWriter(new File(Objects.requireNonNull(MainLauncher.class.getClassLoader().getResource("dictionary")).getFile()), true);
            //TODO WSTAWIC ITERATOR
//            if (dictionary.getWordList().containsKey(polishTextField.getText())){
//                dictionary.getWordList().replace(polishTextField.getText(), englishTextField.getText());
//            }else if (dictionary.getWordList().containsValue(englishTextField.getText())) {
//                dictionary.getWordList().replace(polishTextField.getText(), englishTextField.getText());
//            }
//            writer.
//            //writer.write(polishTextField.getText() + "-" + englishTextField.getText() + "\n");
//            resultLabel.setText("Zedytowano słowo.");
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
