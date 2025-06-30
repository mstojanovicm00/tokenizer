package rs.raf.mstojanovic5623m.pi.tokenizer.doc;

import java.io.File;
import java.util.Arrays;
import java.util.stream.Collectors;

public class StemmedDocument implements Document {

    private static int lastId = 0;

    private final int id;
    private final File file;
    private final StemmingEntry[] stemmingEntries;

    public StemmedDocument(File file, StemmingEntry[] stemmingEntries) {
        this.id = ++lastId;
        this.file = file;
        this.stemmingEntries = stemmingEntries;
    }

    @Override
    public String toString() {
        return "<STEMMED> " + Arrays.stream(this.stemmingEntries)
                .map(e -> e.stem)
                .collect(Collectors.toList());
    }

    @Override
    public Document analyseFurther() {
        return null;
    }

    public int getId() {
        return id;
    }

    public File getFile() {
        return file;
    }

    public StemmingEntry[] getStemmingEntries() {
        return stemmingEntries;
    }

    public static class StemmingEntry {
        public final String word;
        public final String stem;
        public StemmingEntry(String word, String stem) {
            this.word = word;
            this.stem = stem;
        }
    }
}
