public class YearlyReports {

    YearlyReport yearlyReport = ReportParseYear.readYearlyReport("y.2022.csv");

    void littleMonthReport() {
        for (int i = 1; i < 4; i++) {
            System.out.println("Краткий отчет за " + i + "-й месяц:");
            MonthlyReport monthlyReport = ReportParserMonth.readMonthlyReport("m.20220" + i + ".csv");
            for (int j = 0; j < monthlyReport.items.size(); j++) {
                System.out.println(" " + monthlyReport.items.get(j).name + " "
                        + monthlyReport.items.get(j).isExpense + " "
                        + monthlyReport.items.get(j).quantity + " "
                        + monthlyReport.items.get(j).price);
            }
        }
    }

    void littleYearReport() {
        for (int i = 0; i < yearlyReport.items.size(); i++) {
            System.out.println(yearlyReport.items.get(i).month + " "
                    + yearlyReport.items.get(i).amount + " "
                    + yearlyReport.items.get(i).isExpense);
        }
    }

    void collation() {
        int number = 1;
        for (int i = 0; i < yearlyReport.items.size(); i++) {
            if (yearlyReport.items.get(i).month == number) {
                collationSum(number, i);
            } else {
                number += 1;
                collationSum(number, i);
            }
        }
    }

    void collationSum(int number, int i) {
        MonthlyReport monthlyReport = ReportParserMonth.readMonthlyReport("m.20220" + number + ".csv");
        if (yearlyReport.items.get(i).isExpense == true) {
            if (yearlyReport.items.get(i).amount == monthlyReport.bigExpenses()) {
                System.out.println("Отчет трат за " + number + "-й месяц верен.");
            } else {
                System.out.println("Отчет трат за " + number + "-й месяц неверен.");
            }
        } else {
            if (yearlyReport.items.get(i).amount == monthlyReport.bigIncome()) {
                System.out.println("Отчет доходов за " + number + "-й месяц верен.");
            } else {
                System.out.println("Отчет доходов за " + number + "-й месяц неверен.");
            }
        }
    }

    void monthAndnameProductAndMostProfit() {

        int biggestWaste = 0;
        String nameProduct = "";
        String nameWest = "";
        int mostProfit = 0;
        for (int j = 1; j < 4; j++) {
            MonthlyReport monthlyReport = ReportParserMonth.readMonthlyReport("m.20220" + j + ".csv");
            for (int i = 0; i < monthlyReport.items.size(); i++) {
                if (monthlyReport.items.get(i).isExpense == false) {
                    mostProfit = monthlyReport.bigIncome();
                    nameProduct = monthlyReport.items.get(i).name;
                } else {
                    biggestWaste = monthlyReport.bigExpenses();
                    nameWest = monthlyReport.items.get(i).name;
                }
            }
            System.out.println("В " + j + " месяце самый прибыльный товар: " + nameProduct + " " + mostProfit);
            System.out.println("В " + j + " месяце самая большая трата: " + nameWest + " " + biggestWaste);

        }
    }

    void yearProfitAndExpenses() {
        for (int i = 1; i < 4; i++) {
            MonthlyReport monthlyReport = ReportParserMonth.readMonthlyReport("m.20220" + i + ".csv");
            int averageIncome = monthlyReport.sumIncome() - monthlyReport.sumExpenses();
            System.out.println("Прибыль за " + i + "-й месяц: " + averageIncome);
        }
        System.out.println("Средний доход за все месяцы в году: " + yearlyReport.profit());
        System.out.println("Средний расход за все месяцы в году: " + yearlyReport.expenses());


    }
}