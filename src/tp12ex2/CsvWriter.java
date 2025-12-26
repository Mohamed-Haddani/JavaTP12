package tp12ex2;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Générateur de fichiers CSV.
 */
public class CsvWriter {

    /**
     * Écrit en-tête et données dans un fichier CSV.
     *
     * @param path   chemin du fichier de sortie
     * @param header liste des noms de colonnes
     * @param rows   liste de lignes, chaque ligne est un tableau de valeurs
     */
    public static void writeCsv(String path, List<String> header, List<String[]> rows) {
        try (PrintWriter pw = new PrintWriter(path)) {
            // Écrire l'en-tête
            pw.println(String.join(",", header));
            // Écrire chaque ligne de données
            for (String[] row : rows) {
                pw.println(String.join(",", row));
            }
        } catch (FileNotFoundException e) {
            System.err.println("Impossible d’écrire le CSV : " + e.getMessage());
        }
    }
}