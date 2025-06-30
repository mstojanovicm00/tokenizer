package rs.raf.mstojanovic5623m.pi.tokenizer.result;

import rs.raf.mstojanovic5623m.pi.tokenizer.doc.StemmedDocument;
import rs.raf.mstojanovic5623m.pi.tokenizer.folder.Folder;
import rs.raf.mstojanovic5623m.pi.tokenizer.result.model.DocIndex;
import rs.raf.mstojanovic5623m.pi.tokenizer.result.model.Document;
import rs.raf.mstojanovic5623m.pi.tokenizer.result.model.Term;

import java.util.*;

public class ResultUtils {

    public static List<StemmedDocument> canAccept(Folder folder) {
        List<StemmedDocument> result = new ArrayList<>();
        for (rs.raf.mstojanovic5623m.pi.tokenizer.doc.Document doc : folder.pipeline()) {
            if (doc instanceof StemmedDocument) {
                result.add((StemmedDocument) doc);
                continue;
            }
            return null;
        }
        return result;
    }

    public static ResultServer accept(List<StemmedDocument> docs) {
        int docid = 1;
        int termid = 1;
        List<Document> documents = new ArrayList<>();
        List<Term> terms = new ArrayList<>();
        List<DocIndex> docIndices = new ArrayList<>();
        Map<String, Integer> termmap = new HashMap<>();
        for (StemmedDocument doc : docs) {
            Map<String, List<Integer>> positions = analyseDocument(doc);
            for (String s : positions.keySet())
                termmap.putIfAbsent(s, termid++);
            Document document = new Document(docid++, doc.getFile().getName());
            documents.add(document);
            for (Map.Entry<String, List<Integer>> e : positions.entrySet()) {
                int currtermid = termmap.get(e.getKey());
                DocIndex docIndex = new DocIndex(document.getId(), currtermid);
                for (Integer i : e.getValue())
                    docIndex.addPosition(i);
                docIndices.add(docIndex);
            }
        }
        for (Map.Entry<String, Integer> e : termmap.entrySet()) {
            Term term = new Term(e.getValue(), e.getKey());
            terms.add(term);
        }
        return new ResultServer(documents, terms, docIndices);
    }

    private static Map<String, List<Integer>> analyseDocument(StemmedDocument doc) {
        Map<String, List<Integer>> result = new HashMap<>();
        int pos = 1;
        for (StemmedDocument.StemmingEntry e : doc.getStemmingEntries()) {
            String stem = e.stem;
            result.putIfAbsent(stem, new ArrayList<>());
            result.get(stem).add(pos++);
        }
        return result;
    }

    private ResultUtils() {

    }
}
