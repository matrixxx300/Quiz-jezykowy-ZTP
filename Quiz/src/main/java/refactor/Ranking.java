package refactor;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

// TODO: Rozdzielić tę klasę na model i kontroler, w celu spełnienia wzorca MVC.
public class Ranking {
    public ObservableList<String> rankingList;
    private Sorting sorting;

    public Ranking() {
        rankingList = FXCollections.observableArrayList(
                "C1 - 98/100", "B1 - 85/100", "A1 - 70/100", "B2 - 50/100", "A2 - 42/100", "C2 - 13/100");
        setSortingByPoints();
    }

    //używana po zakończeniu testu, sprawdza czy wynik otrzymany jest wyższy niż wynik w rankingu
    public void updateScore(int score, String level) {
        String compareLevel;
        int compareScore;
        int index = 0;

        for (int i = 0; i < rankingList.size(); i++) {
            compareLevel = rankingList.get(i);
            if (level.compareTo(compareLevel.charAt(0) + "" + compareLevel.charAt(1)) == 0) {
                index = i;
            }
        }

        compareLevel = rankingList.get(index);
        compareLevel = compareLevel.charAt(5) + "" + compareLevel.charAt(6);
        compareScore = Integer.parseInt(compareLevel);

        if (level.equals("A1") && score > compareScore) {
            rankingList.set(index, "A1 - " + score + "/100");
        }
        if (level.equals("A2") && score > compareScore) {
            rankingList.set(index, "A2 - " + score + "/100");
        }
        if (level.equals("B1") && score > compareScore) {
            rankingList.set(index, "B1 - " + score + "/100");
        }
        if (level.equals("B2") && score > compareScore) {
            rankingList.set(index, "B2 - " + score + "/100");
        }
        if (level.equals("C1") && score > compareScore) {
            rankingList.set(index, "C1 - " + score + "/100");
        }
        if (level.equals("C2") && score > compareScore) {
            rankingList.set(index, "C2 - " + score + "/100");
        }
    }

    public void setList(ListView list) {
        list.setItems(rankingList);
    }

    public void setSortingByLevel() {
        sorting = new SortingByLevel();
        sorting.sort(this);
    }

    public void setSortingByPoints() {
        sorting = new SortingByPoints();
        sorting.sort(this);
    }

}
