package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import MainPackage.Main;
import MainPackage.Ranking;

public class RankingController {
    public ListView list;
    private Ranking rankingModel;
    public Stage window;


    public Button returnButton;

    @FXML
    public void initialize(){
        this.rankingModel = new Ranking();
        this.window = Main.window;

        rankingModel.setList(list);
    }

    public void back(ActionEvent actionEvent) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/MenuView.fxml"));
        window.setScene(new Scene(root));
        window.show();
    }

    public void sortByPoints(ActionEvent actionEvent) {
        rankingModel.sortByPoints();
        rankingModel.setList(list);
    }

    public void sortByLevels(ActionEvent actionEvent) {
        rankingModel.sortByLevels();
        rankingModel.setList(list);
    }
}
