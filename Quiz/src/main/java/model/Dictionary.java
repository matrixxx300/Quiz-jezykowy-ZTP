package model;

import main.MainLauncher;
import model.progress.Level;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Dictionary implements Iterable {
    private Level level;
    private List<Word> wordList;

    public Dictionary(Level level) throws FileNotFoundException {
        this.level = level;

        Scanner scanner = new Scanner(
                new FileReader(
                        new File(
                                Objects.requireNonNull(MainLauncher.class.getClassLoader().getResource(level.getName() + "dictionary")).getFile()
                        )
                )
        );
        wordList = new LinkedList<>();
        String line;

        while (scanner.hasNext()) {
            line = scanner.nextLine();
            if (!line.startsWith("#") && !line.isEmpty()) {
                String[] columns = line.split("=");
                wordList.add(new Word(columns[0], columns[1]));
            }
        }
        scanner.close();
    }

    public List<Word> getWordList() {
        return wordList;
    }

    public Level getLevel() {
        return level;
    }

    public Word getRandomWord() {
        HashSet<Word> set = new HashSet(this.getWordList());
        int size = set.size();
        int item = new Random().nextInt(size);
        int i = 0;
        for (Word word : set) {
            if (i == item) return word;
            i++;
        }
        return null;
    }

    public Word[] getRandomWords(int wordsNumber) {
        Word[] randomWords = new Word[wordsNumber];
        for (int j = 0; j < wordsNumber; j++) {
            randomWords[j] = this.getRandomWord();
        }
        return randomWords;
    }

    @Override
    public Iterator<Word> iterator() {
        return new Iterator<Word>() {
            private int before = 0;

            @Override
            public boolean hasNext() {
                return before<wordList.size();
            }

            @Override
            public Word next() {
                return wordList.get(before++);
            }

            @Override
            public void remove(){
                for (int i = 0; i <= wordList.size(); i++) {
                    if(this.before-1 == i){
                        wordList.remove(i);
                    }
                }
            }
        };
    }
}
