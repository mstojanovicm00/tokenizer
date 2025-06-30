package rs.raf.mstojanovic5623m.pi.tokenizer.doc;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FoundDocument implements Document {

    private final File file;

    public FoundDocument(File file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return "<FOUND> " + this.file.getName();
    }

    @Override
    public Document analyseFurther() {
//        try {
//            List<String> lines = Files.readAllLines(this.file.toPath());
//            System.out.println(lines);
//            if (lines.isEmpty())
//                return new ReadDocument("");
//            if (lines.size() != 1)
//                return new ReadDocument(
//                        String.join("\n", lines));
//            return new ReadDocument(lines.get(0));
//        } catch (IOException e) {
//            System.out.println(this.file.getName());
//            throw new RuntimeException(e);
//        }
        try {
            byte[] bytes = Files.readAllBytes(this.file.toPath());
            return new ReadDocument(this.file, new String(bytes));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
