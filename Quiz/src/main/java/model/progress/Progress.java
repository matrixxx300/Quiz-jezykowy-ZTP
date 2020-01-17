package model.progress;

import model.Word;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Progress {
    private static final Progress instance = new Progress();
    Level[] levels;

    private Progress() {
        levels = new Level[]{
                new Level("A1"),
                new Level("A2"),
                new Level("B1"),
                new Level("B2"),
                new Level("C1"),
                new Level("C2")
        };
    }

    public static Progress getInstance() {
        return Progress.instance;
    }

    public void updateProgressLevel(Level level, Word word, int value) {
        Integer val = levels[level.toInteger()].map.putIfAbsent(word, value);
        if (val != null) {
            level.map.replace(word, levels[level.toInteger()].map.get(word) + value);
        }
    }

    public void resetLevelProgress(Level level) {
        level.setMap(null);
        level.setMap(new HashMap<>());
    }

    public void resetWholeProgress() {
        for (Level level : levels) {
            resetLevelProgress(level);
        }
    }

    public void saveProgress() throws IOException {
        FileWriter writer = new FileWriter(new File("Quiz\\src\\main\\resources\\progress"));
        for (Level level : levels) {
            writer.write(level.name + "\n");

            HashSet entrySet = new HashSet<>(level.getMap().entrySet());
            ArrayList<Map.Entry<Word, Integer>> entryList = new ArrayList<>(entrySet);
            entryList.sort(Map.Entry.comparingByValue());

            for (int j = 0; j < level.map.size(); j++) {
                writer.write(entryList.get(j).getKey() + ":" + entryList.get(j).getValue() + "\n");
            }
        }
        writer.close();
    }
}