import java.util.List;

public class MonthlyReport {

    public List<MonthlyReportItem> items;

    MonthlyReport(List<MonthlyReportItem> items) {
        this.items = items;
    }

    int bigExpenses() {
        int sumExpenses = 0;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).isExpense == true) {
                int sum = items.get(i).quantity * items.get(i).price;
                if (sumExpenses < sum) {
                    sumExpenses = sum;
                }
            }
        }
        return sumExpenses;
    }

    int bigIncome() {
        int sumIncome = 0;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).isExpense == false) {
                int sum = items.get(i).quantity * items.get(i).price;
                if (sumIncome < sum) {
                    sumIncome = sum;
                }
            }
        }
        return sumIncome;
    }

    int sumExpenses() {
        int sumExpenses = 0;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).isExpense == true) {
                int sum = items.get(i).quantity * items.get(i).price;
                if (sumExpenses < sum) {
                    sumExpenses += sum;
                }
            }
        }
        return sumExpenses;
    }

    int sumIncome() {
        int sumExpenses = 0;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).isExpense == false) {
                int sum = items.get(i).quantity * items.get(i).price;
                if (sumExpenses < sum) {
                    sumExpenses += sum;
                }
            }
        }
        return sumExpenses;
    }
}
