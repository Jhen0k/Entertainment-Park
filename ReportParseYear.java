import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReportParseYear {
    public static YearlyReport readYearlyReport(String fileName) {
        List<String> lines = readFileContents(fileName);
        ArrayList<YearlyReportItem> items = new ArrayList<>();

        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i);
            String[] lineContents = line.split(",");

            int month = Integer.parseInt(lineContents[0]);
            int amount = Integer.parseInt(lineContents[1]);
            boolean isExpense = Boolean.parseBoolean(lineContents[2]);

            YearlyReportItem item = new YearlyReportItem(
                    month,
                    amount,
                    isExpense
            );
            items.add(item);
        }
        return new YearlyReport(items);
    }

    private static List<String> readFileContents(String path) {
        try {
            return Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с годовым отчётом. Возможно файл не находится в нужной директории.");
            return Collections.emptyList();
        }
    }
}
