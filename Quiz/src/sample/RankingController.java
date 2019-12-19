package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class RankingController {
    public ListView list;
    private Ranking rankingModel;
    public Stage window;


    public Button powrot;

    @FXML
    public void initialize(){
        this.rankingModel = new Ranking();
        this.window = Main.window;

        rankingModel.setList(list);
    }

    public void back(ActionEvent actionEvent) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("MenuView.fxml"));
        window.setScene(new Scene(root));
        window.show();
    }
}
