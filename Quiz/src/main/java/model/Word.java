package model;

public class Word {
    private String englishWord;
    private String polishWord;

    public Word(String englishWord, String polishWord) {
        this.englishWord = englishWord;
        this.polishWord = polishWord;
    }

    public String getEnglishWord() {
        return englishWord;
    }

    public String getPolishWord() {
        return polishWord;
    }

    public String getAppropriateWord(boolean english) {
        return english ? englishWord : polishWord;
    }

    @Override
    public String toString() {
        return englishWord + " = " + polishWord;
    }

    public void setEnglishWord(String englishWord) {
        this.englishWord = englishWord;
    }

    public void setPolishWord(String polishWord) {
        this.polishWord = polishWord;
    }
}
