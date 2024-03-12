import java.util.ArrayList;
import java.util.Scanner;

public class CheckOutAppMain {
    private static final CheckOutApp checkOutApp = new CheckOutApp();
    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayList<String> itemBought = new ArrayList<>();
    private static final ArrayList<Integer> quantityPurchased = new ArrayList<>();
    private static final ArrayList<Double> priceOfItem = new ArrayList<>();

    public static void main(String[] args) {
        startApp();
    }

    private static void startApp() {
        String customerInfo = input("What is the customer's Name?");
        checkOutApp.setCustomerName(customerInfo);

        while (true) {
            String itemInfo = input("What the user buy?");
            itemBought.add(itemInfo);
            collectQuantityPurchased();
            collectPriceOfItem();

            String sentinelValue = addMoreItems();

            if (sentinelValue.equals("NO")) break;
        }

        String cashierInfo = input("What is your name?");
        checkOutApp.setCashierName(cashierInfo);
        setCustomerDiscount();

        double sum = 0;
        for (int index = 0; index < itemBought.size(); index++) sum += priceOfItem.get(index) * quantityPurchased.get(index);
        checkOutApp.setSubTotal(sum);

        displayInvoice();
        setPayment();
        displayReceipt();

        print("\nThank you for shopping with us!");
    }

    private static void displayReceipt() {
        System.out.printf("%n%nSEMICOLON STORES%nMAIN BRANCH%nLOCATION: 312 HERBERT MACAULAY WAY, SABO YABA, LAGOS." +
                "%nTEL: 03293828343%nDate: %s%nCashier: %s%nCustomer Name: %s" +
                "%n", checkOutApp.getCurrentDateAndTime(), checkOutApp.getCashierName(), checkOutApp.getCustomerName());

        print("""
                =======================================================
                         ITEM           QTY     PRICE        TOTAL(NGN)
                -------------------------------------------------------""");

        for (int index = 0; index < itemBought.size(); index++) {
            System.out.printf("   %10s", itemBought.get(index));
            System.out.printf("            %2d", quantityPurchased.get(index));
            System.out.printf(" %10.2f", priceOfItem.get(index));
            System.out.printf("     %10.2f%n", priceOfItem.get(index) * quantityPurchased.get(index));
        }

        System.out.printf("%n%n" +
                        "-------------------------------------------------------%n" +
                        "\t\t\t%13s\t  %10.2f%n\t\t\t%13s\t  %10.2f%n" +
                        "\t\t\t%13s\t  %10.2f%n" +
                        "=======================================================%n" +
                        "\t\t\t%13s\t  %10.2f%n\t\t\t%13s\t  %10.2f%n\t\t\t%13s\t  %10.2f%n" +
                        "=======================================================%n" +
                        "\t  THANK YOU FOR YOUR PATRONAGE%n" +
                        "=======================================================%n",
                "Sub Total:", checkOutApp.getSubTotal(), "Discount:", checkOutApp.getDiscountedTotal(), "VAT @ 7.50%:",
                checkOutApp.getVAT(), "Bill Total:", checkOutApp.getBillTotal(),
                "Amount Paid:", checkOutApp.getAmountPaid(), "Balance:", checkOutApp.getBalance());
    }

    private static void setPayment() {
        String amountPaid = input("\nHow much did the customer give to you?");
        try {
            checkOutApp.setAmountPaid(Double.parseDouble(amountPaid));
        }
        catch (RuntimeException e) {
            if (e.getMessage().equals("Amount paid cannot be less than bill total")) print("Oga, oga oga... amount received is less than bill total");
            else print("Invalid input.");
            setPayment();
        }
    }

    private static void displayInvoice() {
        String format = "%nSEMICOLON STORES%nMAIN BRANCH%nLOCATION: 312 HERBERT MACAULAY WAY, SABO YABA, LAGOS." +
                "%nTEL: 03293828343%nDate: %s%nCashier: %s%nCustomer Name: %s" +
                "%n";
        System.out.printf(format, checkOutApp.getCurrentDateAndTime(), checkOutApp.getCashierName(), checkOutApp.getCustomerName());

        print("""
                =======================================================
                         ITEM           QTY     PRICE        TOTAL(NGN)
                -------------------------------------------------------""");

        for (int index = 0; index < itemBought.size(); index++) {
            System.out.printf("   %10s", itemBought.get(index));
            System.out.printf("           %3d", quantityPurchased.get(index));
            System.out.printf(" %10.2f", priceOfItem.get(index));
            System.out.printf("      %10.2f%n", priceOfItem.get(index) * quantityPurchased.get(index));
        }

        System.out.printf("%n%n" +
                        "-------------------------------------------------------%n" +
                        "\t\t\t%13s\t  %10.2f%n\t\t\t%13s\t  %10.2f%n" +
                        "\t\t\t%13s\t  %10.2f%n" +
                        "=======================================================%n" +
                        "\t\t\t%13s\t  %10.2f%n=======================================================%n" +
                        "   THIS IS NOT A RECEIPT, KINDLY PAY %.2f%n=======================================================%n",
                "Sub Total:", checkOutApp.getSubTotal(), "Discount:", checkOutApp.getDiscountedTotal(), "VAT @ 7.50%:",
                checkOutApp.getVAT(), "Bill Total:", checkOutApp.getBillTotal(), checkOutApp.getBillTotal());
    }

    private static void setCustomerDiscount() {
        String discount = input("How much discount will the customer get?");
        try {
            checkOutApp.setDiscount(Double.parseDouble(discount));
        }
        catch (RuntimeException e) {
            print("Invalid input.");
            setCustomerDiscount();
        }
    }

    private static String addMoreItems() {
        String sentinelValue = input("\nAdd more items (yes/no)?").toUpperCase();
        boolean wrongInput = !sentinelValue.equals("YES") && !sentinelValue.equals("NO");

        while (wrongInput) {
            sentinelValue = input("Invalid input\nAdd more items (yes/no)?").toUpperCase();
            wrongInput = !sentinelValue.equals("YES") && !sentinelValue.equals("NO");
        }
        return sentinelValue;
    }

    private static void collectPriceOfItem() {
        String priceInfo = input("How much per unit:");
        try {
            double price = Double.parseDouble(priceInfo);
            if (price <= 0.0) throw new IllegalArgumentException("Price must be positive.");

            priceOfItem.add(price);
        }
        catch (RuntimeException e) {
            print("Invalid input.");
            collectPriceOfItem();
        }
    }

    private static void collectQuantityPurchased() {
        String quantityInfo = input("How many pieces:");

        try {
            int quantity = Integer.parseInt(quantityInfo);
            if (quantity <= 0) throw new IllegalArgumentException("Quantity must be positive.");

            quantityPurchased.add(quantity);
        }
        catch (RuntimeException e) {
            print("Invalid input.");
            collectQuantityPurchased();
        }
    }

    private static void print(String prompt) {
        System.out.println(prompt);
    }

    private static String input(String prompt) {
        print(prompt);

        return scanner.nextLine();
    }
}
