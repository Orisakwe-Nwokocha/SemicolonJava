import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FairTaxCalculator {

    public static double calculateFairTax(Map<String, Double> expenses) {
        double totalExpenses = 0;
        for (double expense : expenses.values()) totalExpenses += expense;

        double fairTaxRate = 0.30;
        return totalExpenses * fairTaxRate;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Double> expenses = new HashMap<>();

        String[] expenseCategories = {"housing", "food", "clothing", "transportation", "education", "health care", "vacations"};

        for (String category : expenseCategories) {
            System.out.print("Enter expenses for " + category + ":\n$");
            double expense = scanner.nextDouble();
            expenses.put(category, expense);
        }
        double totalExpenses = expenses.values().stream().mapToDouble(Double::doubleValue).sum();

        double fairTax = calculateFairTax(expenses);
        System.out.printf("Total expenses: $%.2f%n", totalExpenses);
        System.out.printf("Estimated FairTax: $%.2f%n", fairTax);

        scanner.close();
    }
}
