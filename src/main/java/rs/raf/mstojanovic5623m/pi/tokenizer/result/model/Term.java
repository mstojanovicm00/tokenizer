package rs.raf.mstojanovic5623m.pi.tokenizer.result.model;

public class Term implements Comparable<Term> {
    private final int id;
    private final String word;

    public Term(int id, String word) {
        this.id = id;
        this.word = word;
    }

    public int getId() {
        return id;
    }

    public String getWord() {
        return word;
    }

    @Override
    public String toString() {
        return this.id + "\t" + this.word;
    }

    @Override
    public int compareTo(Term term) {
        return this.word.compareTo(term.word);
    }
}
