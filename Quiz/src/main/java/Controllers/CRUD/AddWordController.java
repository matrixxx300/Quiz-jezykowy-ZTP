package Controllers.CRUD;

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
import MainPackage.Main;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

import static Controllers.CRUD.DictionaryController.dictionary;
import static Controllers.CRUD.DictionaryController.loadDictionary;

public class AddWordController {
    public Stage window;

    @FXML
    public TextField polishTextField, englishTextField;
    public Label resultLabel;

    @FXML
    public void initialize() {
        this.window = Main.window;
    }

    public void addWord(ActionEvent actionEvent) throws IOException {
        if (dictionary.containsKey(polishTextField.getText())) {
            resultLabel.setText("Dane słowo już jest w słowniku!");
        } else if (dictionary.containsValue(englishTextField.getText())) {
            resultLabel.setText("Dane słowo już jest w słowniku!");
        }else if(polishTextField.getText().equals("") || englishTextField.getText().equals("")){
            resultLabel.setText("Pola nie mogą być puste!");
        } else{
            FileWriter writer = new FileWriter(new File(Objects.requireNonNull(MainLauncher.class.getClassLoader().getResource("dictionary")).getFile()), true);
            writer.write(polishTextField.getText() + "-" + englishTextField.getText() + "\n");
            resultLabel.setText("Dodano słowo.");
            writer.close();
            loadDictionary();
        }
    }

    public void back(ActionEvent actionEvent) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/CRUD/DictionaryView.fxml"));
        window.setScene(new Scene(root));
        window.show();
    }
}
