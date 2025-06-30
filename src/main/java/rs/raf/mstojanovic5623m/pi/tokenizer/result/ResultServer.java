package rs.raf.mstojanovic5623m.pi.tokenizer.result;

import rs.raf.mstojanovic5623m.pi.tokenizer.result.model.DocIndex;
import rs.raf.mstojanovic5623m.pi.tokenizer.result.model.Document;
import rs.raf.mstojanovic5623m.pi.tokenizer.result.model.Term;

import java.util.List;

public class ResultServer {

    final List<Document> documents;
    final List<Term> terms;
    final List<DocIndex> docIndices;

    private Writer writer;

    public ResultServer(List<Document> documents, List<Term> terms, List<DocIndex> docIndices) {
        this.documents = documents;
        this.terms = terms;
        this.docIndices = docIndices;
    }

    public void save() {
        this.writer = new Writer();
        this.writer.writeDocuments(this);
        this.writer.writeTerms(this);
        this.writer.writeDocIndeces(this);
    }
}
