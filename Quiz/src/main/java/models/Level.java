package models;

import java.util.HashMap;

public class Level {
    String name;
    HashMap<Word, Integer> map;

    public Level(String name){
        this.name = name;
        map = new HashMap<>();
    }

    public String getName() {
        return name;
    }
    public HashMap getMap() {
        return map;
    }

    public void setMap(HashMap<Word, Integer> map) {
        this.map = map;
    }
}
