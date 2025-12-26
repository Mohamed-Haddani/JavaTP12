package tp12ex1;

import java.io.Serializable;

// Ajout de "implements Serializable"
public class Record implements Serializable {
    // Il est recommandé d'ajouter un serialVersionUID pour la compatibilité de version
    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private double score;

    public Record(int id, String name, double score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getScore() { return score; }

    @Override
    public String toString() {
        return "Record{id=" + id + ", name='" + name + "', score=" + score + "}";
    }

    public String toCsvString() {
        return id + "," + name + "," + score;
    }
}