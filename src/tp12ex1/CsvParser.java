package tp12ex1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvParser {

    public static List<Record> readCsv(String path) throws IOException {
        List<Record> records = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            // On suppose que la première ligne est l'en-tête, on la lit pour l'ignorer
            br.readLine(); 

            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue; // Ignorer les lignes vides

                String[] parts = line.split(",");
                // Format attendu : id,name,score
                if (parts.length == 3) {
                    try {
                        int id = Integer.parseInt(parts[0].trim());
                        String name = parts[1].trim();
                        double score = Double.parseDouble(parts[2].trim());
                        
                        records.add(new Record(id, name, score));
                    } catch (NumberFormatException e) {
                        System.err.println("Erreur de format sur la ligne : " + line);
                    }
                }
            }
        }
        return records;
    }

    public static void writeCsv(List<Record> records, String path) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            // Écriture de l'en-tête
            bw.write("id,name,score");
            bw.newLine();

            for (Record record : records) {
                bw.write(record.toCsvString());
                bw.newLine();
            }
        }
    }
}