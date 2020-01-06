package refactor;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

//TODO: Przenieść do modeli, w celu spełnienia wzorca MVC.
public class SortingByPoints implements Sorting {
    @Override
    public void sort(Ranking ranking) {
        ObservableList<String> rankingHelpList = FXCollections.observableArrayList("", "", "", "", "", "");
        String help;
        int point;
        int[] points = new int[6];

        for (int i = 0; i < points.length; i++) {
            help = ranking.rankingList.get(i);
            help = help.charAt(5) + "" + help.charAt(6);
            point = Integer.parseInt(help);
            points[i] = point;
        }

        //sortowanie tablicy points
        for (int i = 0; i < points.length; i++) {
            int min;
            for (int j = 0; j < points.length; j++) {
                if (points[j] < points[i]) {
                    min = points[i];
                    points[i] = points[j];
                    points[j] = min;
                }
            }
        }

        for (String s : ranking.rankingList) {
            help = s;
            help = help.charAt(5) + "" + help.charAt(6);
            point = Integer.parseInt(help);

            if (point == points[0]) {
                rankingHelpList.set(0, s);
            }
            if (point == points[1]) {
                rankingHelpList.set(1, s);
            }
            if (point == points[2]) {
                rankingHelpList.set(2, s);
            }
            if (point == points[3]) {
                rankingHelpList.set(3, s);
            }
            if (point == points[4]) {
                rankingHelpList.set(4, s);
            }
            if (point == points[5]) {
                rankingHelpList.set(5, s);
            }
        }
        ranking.rankingList = rankingHelpList;
    }
}
