package rs.raf.mstojanovic5623m.pi.tokenizer.stop;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Stops {

    public static final Stops STOPS = new Stops();

    private final List<StopWord> stopWords = new ArrayList<>();

    private Stops() {
        try {
            List<String> words = Files.readAllLines(Paths.get("stoplist.txt"));
            words.stream().filter(w -> !w.isBlank())
                    .map(StopWord::new)
                    .forEach(this::addStopWord);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String[] ignoreStopWords(String[] words) {
        return Arrays.stream(words)
                .filter(w -> !this.isStopWord(w))
                .toArray(String[]::new);
    }

    private void addStopWord(StopWord stopWord) {
        this.stopWords.add(stopWord);
    }

    private boolean isStopWord(String word) {
        for (StopWord stopWord : stopWords) {
            if (stopWord.getWord().trim().equalsIgnoreCase(word.trim()))
                return true;
        }
        return false;
    }

}
