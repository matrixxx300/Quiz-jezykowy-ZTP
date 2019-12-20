package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MenuController {
    private Menu menuModel;
    public Stage window;

    public Button ranking;
    public Button wyjdz;

    @FXML
    public void initialize(){
        this.menuModel = new Menu();
        this.window = Main.window;
    }

    public void ranking(ActionEvent actionEvent) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("RankingView.fxml"));
        window.setScene(new Scene(root));
        window.show();
    }

    public void exit(ActionEvent actionEvent) throws Exception{
        System.exit(1);
    }

}
