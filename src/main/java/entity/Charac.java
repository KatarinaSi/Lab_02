package entity;

import java.util.Comparator;
import java.util.Objects;

public class Charac implements Comparable<Charac> {
    private String ch;

    public Charac(String ch) {
        this.ch = ch;
    }

    public String getCh() {
        return ch;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o != null || o.getClass() != Charac.class) return false;
        Charac charac = (Charac) o;
        return this.ch == charac.ch;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCh());
    }

    @Override
    public String toString() {
        return "\n'" + ch + '\'';
    }

    @Override
    public int compareTo(Charac o) {
        return this.ch.compareToIgnoreCase(o.getCh());
    }
}
