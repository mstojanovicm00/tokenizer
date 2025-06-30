package rs.raf.mstojanovic5623m.pi.tokenizer.doc;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WordArrayDocument implements Document {

    private final File file;
    private final String[] words;

    public WordArrayDocument(File file, List<String> words) {
        this.file = file;
        this.words = new String[words.size()];
        for (int i = 0; i < words.size(); i++)
            this.words[i] = words.get(i);
    }

    @Override
    public String toString() {
        return "<WORDARRAY> " + Arrays.stream(this.words).collect(Collectors.toList());
    }

    @Override
    public Document analyseFurther() {
        return new LowercaseDocument(this.file,
                Arrays.stream(this.words).map(String::toLowerCase).toArray(String[]::new));
    }
}
