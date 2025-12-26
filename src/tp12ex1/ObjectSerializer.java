package tp12ex1;

import java.io.*;
import java.util.List;

public class ObjectSerializer {

    // Sérialisation : Objet -> Fichier binaire
    public static void serialize(List<Record> data, String path) throws IOException {
        System.out.println("--- Sérialisation vers " + path + " ---");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(data);
            System.out.println("Objets sérialisés avec succès.");
        }
    }

    // Désérialisation : Fichier binaire -> Objet
    @SuppressWarnings("unchecked")
    public static List<Record> deserialize(String path) throws IOException, ClassNotFoundException {
        System.out.println("--- Désérialisation depuis " + path + " ---");
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            // On lit l'objet et on le cast vers le type attendu (List<Record>)
            return (List<Record>) ois.readObject();
        }
    }
}
