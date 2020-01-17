package model.progress;

import model.Word;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

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
        FileWriter writer = new FileWriter("Quiz\\src\\main\\resources\\progress");
        for (Level level : levels) {
            writer.write("$ " + level.name + "\n");

            HashSet entrySet = new HashSet<>(level.getMap().entrySet());
            ArrayList<Map.Entry<Word, Integer>> entryList = new ArrayList<>(entrySet);
            entryList.sort(Map.Entry.comparingByValue());

            for (int j = 0; j < level.map.size(); j++) {
                writer.write(entryList.get(j).getKey() + ":" + entryList.get(j).getValue() + "\n");
            }
        }
        writer.close();
    }

    public void loadProgress() throws IOException {
        //todo sprawdzić, czy plik istnieje!
        Scanner scanner = new Scanner(new FileReader("Quiz\\src\\main\\resources\\progress"));
        while (scanner.hasNextLine()) {
            String[] levelLine = scanner.nextLine().split(" ");
            Level level = new Level(levelLine[1]);
            while (scanner.hasNextLine() && !scanner.hasNext("\\$")) {
                String line = scanner.nextLine();
                String[] columns = line.split("[=:]");
                levels[level.toInteger()].map.put(new Word(columns[0], columns[1]), Integer.parseInt(columns[2]));
            }
        }
        scanner.close();
    }
}