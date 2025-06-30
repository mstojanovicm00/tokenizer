package rs.raf.mstojanovic5623m.pi.tokenizer.result.model;

import java.util.ArrayList;
import java.util.List;

public class DocIndex {

    private final int document;
    private final int term;
    private final List<Integer> positions = new ArrayList<>();

    public DocIndex(int document, int term) {
        this.document = document;
        this.term = term;
    }

    public void addPosition(int position) {
        this.positions.add(position);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.document).append("\t").append(this.term);
        for (Integer pos : this.positions)
            sb.append("\t").append(pos);
        return sb.toString();
    }
}
