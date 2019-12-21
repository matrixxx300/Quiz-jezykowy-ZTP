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

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

import static Controllers.CRUD.DictionaryController.dictionary;
import static Controllers.CRUD.DictionaryController.loadDictionary;

public class RemoveWordController {
    public Stage window;

    public Button returnButton;
    @FXML
    public TextField polishTextField, englishTextField;
    public Label resultLabel;

    @FXML
    public void initialize(){
        this.window = Main.window;
    }

    public void back(ActionEvent actionEvent) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/CRUD/DictionaryView.fxml"));
        window.setScene(new Scene(root));
        window.show();
    }

    public void removeWord(ActionEvent actionEvent) throws IOException {
        if (!dictionary.containsKey(polishTextField.getText())) {
            resultLabel.setText("Danego słowa nie ma w słowniku!");
        } else if (!dictionary.containsValue(englishTextField.getText())) {
            resultLabel.setText("Danego słowa nie ma w słowniku!");
        }else if(polishTextField.getText().equals("") && englishTextField.getText().equals("")){
            resultLabel.setText("Pola nie mogą być puste!");
        } else{
            FileWriter writer = new FileWriter(new File(Objects.requireNonNull(MainLauncher.class.getClassLoader().getResource("dictionary")).getFile()), true);
            //dictionary.get(polishTextField.getText());
            //writer.write(polishTextField.getText() + "-" + englishTextField.getText() + "\n");
            resultLabel.setText("Usunięto słowo.");
            writer.close();
            loadDictionary();
        }
    }
}
