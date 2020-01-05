package controllers;

import MainPackage.Main;
import Ranking.Ranking;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class RankingController {
    private Stage window;
    private Ranking rankingModel;

    @FXML
    private ListView list;

    @FXML
    public void initialize() {
        this.rankingModel = new Ranking();
        this.window = Main.window;

        rankingModel.setList(list);
    }

    public void back(ActionEvent actionEvent) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/MenuView.fxml"));
        window.setScene(new Scene(root));
        window.show();
    }

    public void sortByPoints(ActionEvent actionEvent) {
        rankingModel.setSortingByPoints();
        rankingModel.setList(list);
    }

    public void sortByLevels(ActionEvent actionEvent) {
        rankingModel.setSortingByLevel();
        rankingModel.setList(list);
    }
}
