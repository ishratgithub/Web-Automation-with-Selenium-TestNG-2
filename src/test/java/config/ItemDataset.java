package config;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ItemDataset {
    @DataProvider(name = "itemCSVData")
    public Object[][] getCSVData() throws IOException {
        String filePath = "./src/test/resources/items.csv";
        List<Object[]> data = new ArrayList<>();

        CSVParser csvParser = new CSVParser(new FileReader(filePath), CSVFormat.DEFAULT.withFirstRecordAsHeader());
        for (CSVRecord csvRecord : csvParser) {
            String name = csvRecord.get("name");
            int quantity = Integer.parseInt(csvRecord.get("quantity"));
            String amount = csvRecord.get("amount");
            String purchaseDate = csvRecord.get("purchaseDate");
            String month = csvRecord.get("month");
            String remark = csvRecord.get("remark");
            data.add(new Object[]{name, quantity, amount, purchaseDate, month, remark});
        }
        return data.toArray(new Object[0][]);
    }
}
