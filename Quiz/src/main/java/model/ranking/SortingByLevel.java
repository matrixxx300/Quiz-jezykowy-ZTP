package model.ranking;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

//TODO: Przenieść do modeli, w celu spełnienia wzorca MVC.
public class SortingByLevel implements Sorting {

    @Override
    public void sort(Ranking ranking) {
        ObservableList<String> rankingHelpList = FXCollections.observableArrayList("", "", "", "", "", "");
        String help;

        for (String s : ranking.rankingList) {
            help = s;
            if (help.charAt(0) == 'A' && help.charAt(1) == '1') {
                rankingHelpList.set(0, help);
            }
            if (help.charAt(0) == 'A' && help.charAt(1) == '2') {
                rankingHelpList.set(1, help);
            }
            if (help.charAt(0) == 'B' && help.charAt(1) == '1') {
                rankingHelpList.set(2, help);
            }
            if (help.charAt(0) == 'B' && help.charAt(1) == '2') {
                rankingHelpList.set(3, help);
            }
            if (help.charAt(0) == 'C' && help.charAt(1) == '1') {
                rankingHelpList.set(4, help);
            }
            if (help.charAt(0) == 'C' && help.charAt(1) == '2') {
                rankingHelpList.set(5, help);
            }
        }
        ranking.rankingList = rankingHelpList;
    }
}
