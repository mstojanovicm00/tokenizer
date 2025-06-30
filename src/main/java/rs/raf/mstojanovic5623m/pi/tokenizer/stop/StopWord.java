package rs.raf.mstojanovic5623m.pi.tokenizer.stop;

public class StopWord {

    private final String word;

    public StopWord(String word) {
        this.word = word;
    }

    @Override
    public String toString() {
        return this.word;
    }

    String getWord() {
        return word;
    }
}
