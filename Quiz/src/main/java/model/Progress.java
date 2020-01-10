package model;

import java.util.HashMap;

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

    public Progress getInstance() {
        return Progress.instance;
    }

    public void updateProgressLevel(Level level, Word word, int value) {
        HashMap<Word, Integer> progressMap = level.getMap();
        if (progressMap.putIfAbsent(word, value) != null) {
            progressMap.replace(word, progressMap.get(word) + value);
        }
        level.setMap(progressMap);
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

    public void saveProgress() {
        // TODO:
    }
}