package entity;

import java.util.Objects;

public class Word implements Comparable<Word>{
    private final String word;

    public Word(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != Word.class) return false;
        Word word1 = (Word) o;
        return this.word == word1.getWord();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getWord());
    }

    @Override
    public String toString() {
        return "\n'" + word + '\'';
    }

    @Override
    public int compareTo(Word o) {
        return this.word.compareToIgnoreCase(o.getWord());
    }
}
