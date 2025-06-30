package rs.raf.mstojanovic5623m.pi.tokenizer.doc;

import org.jsoup.Jsoup;

import java.io.File;

public class ReadDocument implements Document {

    private final File file;
    private final String text;

    public ReadDocument(File file, String text) {
        this.file = file;
        this.text = text;
    }

    @Override
    public String toString() {
        return "<READ> " + this.text;
    }

    @Override
    public Document analyseFurther() {
        StringBuilder sb = new StringBuilder();
        String[] lines = text.split("\n");
        boolean append = false;
        for (String line : lines) {
            if (line.startsWith("<"))
                append = true;
            if (append)
                sb.append(line);
        }
        return new ParsedDocument(this.file, Jsoup.parse(sb.toString()).body().text());
    }
}
