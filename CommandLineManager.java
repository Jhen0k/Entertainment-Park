import java.util.Scanner;

public class CommandLineManager {
    YearlyReports yearlyReports = new YearlyReports();

    public static void printMenu() {
        System.out.println("1. Считать все месячные отчёты.");
        System.out.println("2. Считать годовой отчёт.");
        System.out.println("3. Сверить отчёты.");
        System.out.println("4. Вывести информацию о всех месячных отчётах.");
        System.out.println("5. Вывести информацию о годовом отчёте.");
    }

    public void handleInfinitele() {
        Scanner scanner = new Scanner(System.in);
        for (int userInput = scanner.nextInt(); userInput != 125; userInput = scanner.nextInt()) {
            if (userInput == 1) {
                readAndSaveMonthlyReports();
            } else if (userInput == 2) {
                readAndSaveYearlyReports();
            } else if (userInput == 3) {
                compareMonthlyAndYearlyReports();
            } else if (userInput == 4) {
                printMonthReport();
            } else if (userInput == 5) {
                printYearReport();
            } else {
                System.out.println("Несуществующая команда, выбирите от 1 до 5");
            }
            printMenu();
        }
        System.out.println("Программа завершена");
    }

    private void readAndSaveMonthlyReports() {
        yearlyReports.littleMonthReport();
    }

    private void readAndSaveYearlyReports() {
        yearlyReports.littleYearReport();
    }

    private void compareMonthlyAndYearlyReports() {
        yearlyReports.collation();
    }

    private void printMonthReport() {
        yearlyReports.monthAndnameProductAndMostProfit();
    }

    private void printYearReport() {
        yearlyReports.yearProfitAndExpenses();
    }
}

