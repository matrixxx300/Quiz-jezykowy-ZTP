package models;

import MainPackage.MainLauncher;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

import static Controllers.CRUD.DictionaryController.loadDictionary;

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
        level.setMap(new HashMap<Word, Integer>());
    }

    public void resetWholeProgress() {
        for (int i = 0; i < levels.length; i++) {
            resetLevelProgress(this.levels[i]);
        }
    }

    public void saveProgress() throws IOException {
        // TODO:
    }
}