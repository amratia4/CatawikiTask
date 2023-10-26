package searchdata;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestDataHandler {

    private static final String CSV_FILE_PATH = System.getProperty("user.dir") + "/src/main/java/searchdata/searchItems.csv";

    public static List<String> getSearchItems() {
        // Create a list to store search items
        List<String> searchItems = new ArrayList<>();
        // Initialize CSVReader
        try (CSVReader reader = new CSVReader(new FileReader(CSV_FILE_PATH))) {
            String[] csvCell;
            // Read each line from the CSV file
            while ((csvCell = reader.readNext()) != null) {
                searchItems.add(csvCell[0]);
            }
        } catch (IOException | CsvValidationException e) {
            throw new RuntimeException("Error reading searchItems.csv: " + e.getMessage(), e);
        }

        return searchItems;
    }
}
