package rs.raf.mstojanovic5623m.pi.tokenizer.doc;

import rs.raf.mstojanovic5623m.pi.tokenizer.stop.Stops;

import java.io.File;
import java.util.Arrays;
import java.util.stream.Collectors;

public class LowercaseDocument implements Document {

    private final File file;
    private final String[] words;

    public LowercaseDocument(File file, String... words) {
        this.file = file;
        this.words = words;
    }

    @Override
    public String toString() {
        return "<LOWERCASE> " + Arrays.stream(this.words).collect(Collectors.toList());
    }

    @Override
    public Document analyseFurther() {
        return new NoStopDocument(this.file, Stops.STOPS.ignoreStopWords(this.words));
    }
}
