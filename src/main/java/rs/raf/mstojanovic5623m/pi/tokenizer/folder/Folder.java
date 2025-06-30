package rs.raf.mstojanovic5623m.pi.tokenizer.folder;

import rs.raf.mstojanovic5623m.pi.tokenizer.doc.Document;
import rs.raf.mstojanovic5623m.pi.tokenizer.doc.FoundDocument;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Folder {

    private final String name;
    private List<Document> documents = null;

    public Folder(String name) {
        this.name = name;
    }

    public List<Document> pipeline() {
        if (this.documents == null) {
            this.documents = this.find().stream()
                    .map(Document::analyseAsFar)
                    .collect(Collectors.toList());
            return this.documents;
        }
        throw new IllegalStateException();
    }

    public List<Document> find() {
        try {
            return Files.list(Paths.get(this.name)).map(Path::toFile)
                    .filter(File::isFile)
                    .map(FoundDocument::new)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
