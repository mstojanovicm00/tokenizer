package rs.raf.mstojanovic5623m.pi.tokenizer.result;

import rs.raf.mstojanovic5623m.pi.tokenizer.result.model.DocIndex;
import rs.raf.mstojanovic5623m.pi.tokenizer.result.model.Document;
import rs.raf.mstojanovic5623m.pi.tokenizer.result.model.Term;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;

public class Writer {

    public void writeDocIndeces(ResultServer resultServer) {
        FileWriter fileWriter = null;
        PrintWriter printWriter = null;
        try {
            fileWriter = new FileWriter("doc_index.txt");
            printWriter = new PrintWriter(fileWriter);
            for (DocIndex docIndex : resultServer.docIndices)
                printWriter.println(docIndex);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (printWriter != null) {
                printWriter.close();
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public void writeTerms(ResultServer resultServer) {
        FileWriter fileWriter = null;
        PrintWriter printWriter = null;
        resultServer.terms.sort(Comparator.comparingInt(Term::getId));
        try {
            fileWriter = new FileWriter("termids.txt");
            printWriter = new PrintWriter(fileWriter);
            for (Term t : resultServer.terms)
                printWriter.println(t);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (printWriter != null) {
                printWriter.close();
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public void writeDocuments(ResultServer resultServer) {
        FileWriter fileWriter = null;
        PrintWriter printWriter = null;
        try {
            fileWriter = new FileWriter("docids.txt");
            printWriter = new PrintWriter(fileWriter);
            for (Document doc : resultServer.documents)
                printWriter.println(doc);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (printWriter != null) {
                printWriter.close();
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
