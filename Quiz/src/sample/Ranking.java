package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

public class Ranking {
    private ObservableList<String> rankingList;

    public Ranking() {
        rankingList = FXCollections.observableArrayList (
                "A1 - 98/100", "A2 - 85/100", "B1 - 70/100", "B2 - 50/100", "C1 - 42/100", "C2 - 13/100");
    }

    public void setList(ListView list){
        list.setItems(rankingList);
    }
}
