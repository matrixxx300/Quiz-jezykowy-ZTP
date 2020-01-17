package model.progress;

import model.Word;

import java.util.HashMap;

public class Level {
    String name;
    HashMap<Word, Integer> map;

    public Level(String name) {
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

    public int toInteger() {
        char letter = name.charAt(0);
        int letterValue = 6, number = name.charAt(1) - '0';
        switch (letter) {
            case 'A':
                letterValue = -1;
                break;
            case 'B':
                letterValue = 1;
                break;
            case 'C':
                letterValue = 3;
                break;
        }
        return letterValue + number;
    }
}
