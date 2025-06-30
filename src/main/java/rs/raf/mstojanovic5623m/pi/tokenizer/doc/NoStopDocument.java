package rs.raf.mstojanovic5623m.pi.tokenizer.doc;

import opennlp.tools.stemmer.PorterStemmer;

import java.io.File;
import java.util.Arrays;
import java.util.stream.Collectors;

public class NoStopDocument implements Document {

    private final File file;
    private final String[] words;

    public NoStopDocument(File file, String[] words) {
        this.file = file;
        this.words = words;
    }

    @Override
    public String toString() {
        return "<NOSTOP> " + Arrays.stream(this.words).collect(Collectors.toList());
    }

    @Override
    public Document analyseFurther() {
        PorterStemmer stemmer = new PorterStemmer();
        return new StemmedDocument(this.file,
                Arrays.stream(this.words)
                        .map(w -> new StemmedDocument.StemmingEntry(w, stemmer.stem(w)))
                        .toArray(StemmedDocument.StemmingEntry[]::new));
    }
}
