package rs.raf.mstojanovic5623m.pi.tokenizer.result.model;

public class Document {

    private final int id;
    private final String name;

    public Document(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return this.id + "\t" + this.name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
