package Controllers.CRUD;

import MainPackage.Main;
import MainPackage.MainLauncher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class DictionaryController {
    public Stage window;

    public Button returnButton;

    public static Map<String, String> dictionary;
    private String selectedLevel = "A1"; //TODO: unhardcode

    @FXML
    public void initialize() {
        this.window = Main.window;
    }

    public static void loadDictionary(String selectedLevel) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader(new File(Objects.requireNonNull(MainLauncher.class.getClassLoader().getResource(selectedLevel + "dictionary")).getFile())));
        dictionary = new LinkedHashMap<>();
        String line;

        while (scanner.hasNext()) {
            line = scanner.nextLine();
            if (!line.startsWith("#") && !line.isEmpty()) {
                String[] columns = line.split("=");
                dictionary.put(columns[0], columns[1]);
            }
        }
        scanner.close();
    }

    public void addWord(ActionEvent actionEvent) throws Exception {
        loadDictionary(this.selectedLevel);
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/CRUD/AddWordView.fxml"));
        window.setScene(new Scene(root));
        window.show();
    }

    public void editWord(ActionEvent actionEvent) throws Exception {
        loadDictionary(this.selectedLevel);
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/CRUD/EditWordView.fxml"));
        window.setScene(new Scene(root));
        window.show();
    }

    public void removeWord(ActionEvent actionEvent) throws Exception {
        loadDictionary(this.selectedLevel);
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/CRUD/RemoveWordView.fxml"));
        window.setScene(new Scene(root));
        window.show();
    }

    public void back(ActionEvent actionEvent) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/MenuView.fxml"));
        window.setScene(new Scene(root));
        window.show();
    }
}
