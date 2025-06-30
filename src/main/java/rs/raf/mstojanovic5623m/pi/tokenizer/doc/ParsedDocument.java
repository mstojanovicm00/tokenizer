package rs.raf.mstojanovic5623m.pi.tokenizer.doc;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParsedDocument implements Document {

    private final File file;
    private final String body;

    public ParsedDocument(File file, String body) {
        this.file = file;
        this.body = body;
    }

    @Override
    public String toString() {
        return "<PARSED> " + this.body;
    }

    @Override
    public Document analyseFurther() {
        Pattern pattern = Pattern.compile("\\w+(\\.?\\w+)*?");
        Matcher matcher = pattern.matcher(this.body);
        List<String> tokens = new ArrayList<>();
        while (matcher.find())
            tokens.add(matcher.group());
        return new WordArrayDocument(this.file, tokens);
    }
}
