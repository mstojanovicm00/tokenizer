package rs.raf.mstojanovic5623m.pi.tokenizer.doc;

public interface Document {
    static Document analyseAsFar(Document document) {
        Document doc = document;
        while (doc != null) {
            document = doc;
            doc = doc.analyseFurther();
        }
        return document;
    }

    Document analyseFurther();
}
