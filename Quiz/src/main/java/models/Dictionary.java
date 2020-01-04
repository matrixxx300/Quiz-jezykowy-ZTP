package models;

import MainPackage.MainLauncher;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Dictionary {
    private Level level;
    private Map<String, String> wordList;

    public Dictionary(Level level) throws FileNotFoundException {
        this.level = level;

        Scanner scanner = new Scanner(
                new FileReader(
                        new File(
                                Objects.requireNonNull(MainLauncher.class.getClassLoader().getResource(level.getName() + "dictionary")).getFile()
                        )
                )
        );
        wordList = new LinkedHashMap<>();
        String line;

        while (scanner.hasNext()) {
            line = scanner.nextLine();
            if (!line.startsWith("#") && !line.isEmpty()) {
                String[] columns = line.split("=");
                wordList.put(columns[0], columns[1]);
            }
        }
        scanner.close();
    }

    public Map<String, String> getWordList() {
        return wordList;
    }

    public Level getLevel() {
        return level;
    }
}
