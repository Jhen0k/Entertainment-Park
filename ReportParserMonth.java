import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReportParserMonth {
    public static MonthlyReport readMonthlyReport(String fileName) {
        List<String> lines = readFileContents(fileName);
        ArrayList<MonthlyReportItem> items = new ArrayList<>();

        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i);
            String[] lineContents = line.split(",");


            String itemName = lineContents[0];
            boolean isExpense = Boolean.parseBoolean(lineContents[1]);
            int quantity = Integer.parseInt(lineContents[2]);
            int price = Integer.parseInt(lineContents[3]);

            MonthlyReportItem item = new MonthlyReportItem(
                    itemName,
                    isExpense,
                    quantity,
                    price
            );

            items.add(item);
        }

        return new MonthlyReport(items);
    }

    private static List<String> readFileContents(String path) {
        try {
            return Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно файл не находится в нужной директории.");
            return Collections.emptyList();
        }
    }
}
