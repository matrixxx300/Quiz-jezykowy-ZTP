package model;

public class Word {
    private String englishWord;
    private String polishWord;

    public String getEnglishWord() {
        return englishWord;
    }

    public String getPolishWord() {
        return polishWord;
    }

    public String getAppropriateWord(boolean english) {
        return english ? englishWord : polishWord;
    }

    public Word(String englishWord, String polishWord) {
        this.englishWord = englishWord;
        this.polishWord = polishWord;
    }
}
