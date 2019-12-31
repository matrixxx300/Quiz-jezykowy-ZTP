package MainPackage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

public class Ranking {
    private ObservableList<String> rankingList;

    public Ranking() {
        rankingList = FXCollections.observableArrayList (
                "C1 - 98/100", "B1 - 85/100", "A1 - 70/100", "B2 - 50/100", "A2 - 42/100", "C2 - 13/100");
    }

    public void setList(ListView list){
        list.setItems(rankingList);
    }

    public void sortByPoints(){
        ObservableList<String> rankingHelpList = FXCollections.observableArrayList ("", "", "", "", "", "");
        String help = "";
        int point = 0;
        int[] points = new int[6];

        for(int i=0; i<points.length; i++){
            help = rankingList.get(i);
            help = help.charAt(5)+""+help.charAt(6);
            point = Integer.parseInt(help);
            points[i] = point;
        }

        //sortowanie tablicy points
        for(int i=0; i<points.length; i++){
            int min;
            for(int j=0; j<points.length; j++){
                if(points[j] < points[i]){
                    min = points[i];
                    points[i]=points[j];
                    points[j]=min;
                }
            }
        }

        for (String s : rankingList) {
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
        rankingList=rankingHelpList;
    }

    public void sortByLevels(){
        ObservableList<String> rankingHelpList = FXCollections.observableArrayList ("", "", "", "", "", "");
        String help = "";

        for (String s : rankingList) {
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
        rankingList=rankingHelpList;
    }

}
