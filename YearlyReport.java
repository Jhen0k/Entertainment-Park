import java.util.List;

public class YearlyReport {
    public List<YearlyReportItem> items;

    public YearlyReport(List<YearlyReportItem> items) {
        this.items = items;
    }

    int profit() {
        int sum = 0;
        int counter = 0;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).isExpense == true) {
                sum += items.get(i).amount;
                counter++;
            }
        }
        sum = sum / counter;
        return sum;
    }

    int expenses() {
        int sum = 0;
        int counter = 0;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).isExpense == false) {
                sum += items.get(i).amount;
                counter++;
            }
        }
        sum = sum / counter;
        return sum;
    }
}

