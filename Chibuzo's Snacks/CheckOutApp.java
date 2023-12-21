import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class CheckOutApp {
    private static final Scanner input = new Scanner(System.in);
    private static String customerName;
    private static String cashierName;
    private static double subTotal;
    private static double discount;
    private static double amountPaid;

    public static String getCurrentDateAndTime() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MMM-yy hh:mm:ss a");

        String currentDateAndTime = currentDateTime.format(dateTimeFormatter);
        currentDateAndTime = currentDateAndTime.replace("AM", "am")
                .replace("PM", "pm");

        return currentDateAndTime;
    }

    public static void setCustomerName(String customerName) {
        CheckOutApp.customerName = customerName;
    }

    public static String getCustomerName() {
        return customerName;
    }

    public static void setCashierName(String cashierName) {
        CheckOutApp.cashierName = cashierName;
    }

    public static String getCashierName() {
        return cashierName;
    }

    public static void setSubTotal(double subTotal) {
        CheckOutApp.subTotal = subTotal;
    }

    public static double getSubTotal() {
        return subTotal;
    }

    public static void setDiscount(double discount) {
        if (discount < 0) {
            CheckOutApp.discount = 0.0;
        }
        else {
            CheckOutApp.discount = discount;
        }
    }

    public static double getDiscount() {
        return discount;
    }

    public static double getDiscountedTotal() {
        return (discount / 100.0) * subTotal;
    }

    public static double getVAT() {
        return subTotal * (7.5 / 100);
    }

    public static double getBillTotal() {
        return (subTotal - getDiscountedTotal()) + getVAT();
    }

    public static void setAmountPaid(double amountPaid) {
        CheckOutApp.amountPaid = amountPaid;
    }

    public static double getAmountPaid() {
        return amountPaid;
    }

    public static double getBalance() {
        double balance = 0.0;
        if (amountPaid > getBillTotal()) {
            return amountPaid - getBillTotal();
        }
        else {
            return balance;
        }
    }

    public static void main(String[] args) {
        CheckOutApp checkOutApp = new CheckOutApp();

        System.out.println("What is the customer's Name?");
        String customerInfo = input.nextLine();
        setCustomerName(customerInfo);

        ArrayList<String> itemBought = new ArrayList<>();
        ArrayList<Integer> quantityOfItem = new ArrayList<>();
        ArrayList<Double> priceOfItem = new ArrayList<>();

        while (true) {
            System.out.println("What did the user buy?");
            String itemInfo = input.nextLine();
            itemBought.add(itemInfo);

            System.out.println("How many pieces?");
            int quantityInfo = input.nextInt();
            quantityOfItem.add(quantityInfo);

            System.out.println("How much per unit?");
            double priceInfo = input.nextDouble();
            priceOfItem.add(priceInfo);

            System.out.println();
            System.out.println("Add more items (yes/no)?");
            String sentinelValue = input.next();
            input.nextLine();
            System.out.println();

            while (!sentinelValue.equalsIgnoreCase("YES") &&
                    !sentinelValue.equalsIgnoreCase("NO")) {
                System.out.println("Invalid input\nAdd more items (yes/no) ?");
                sentinelValue = input.next();
                input.nextLine();
                System.out.println();
            }

            if (sentinelValue.equalsIgnoreCase("NO")) {
                break;
            }

        }

        System.out.println("What is your name?");
        String cashierInfo = input.nextLine();
        setCashierName(cashierInfo);

        System.out.println("How much discount will the customer get?");
        double discountInfo = input.nextDouble();
        setDiscount(discountInfo);

        double sumOfItemsBought = 0;
        for (int index = 0; index < itemBought.size(); index++) {
            sumOfItemsBought += priceOfItem.get(index) * quantityOfItem.get(index);
        }
        setSubTotal(sumOfItemsBought);




        System.out.printf("%nSEMICOLON STORES%nMAIN BRANCH%nLOCATION: 312 HERBERT MACAULAY WAY, SABO YABA, LAGOS." +
                "%nTEL: 03293828343%nDate: %s%nCashier: %s%nCustomer Name: %s" +
                "%n", getCurrentDateAndTime(), getCashierName(), getCustomerName());

        System.out.println("""
                =======================================================
                         ITEM           QTY     PRICE        TOTAL(NGN)
                -------------------------------------------------------""");

        for (int index = 0; index < itemBought.size(); index++) {
            System.out.printf("   %10s", itemBought.get(index));
            System.out.printf("           %3d", quantityOfItem.get(index));
            System.out.printf(" %10.2f", priceOfItem.get(index));
            System.out.printf("      %10.2f", priceOfItem.get(index) * quantityOfItem.get(index));
            System.out.println();
        }

        System.out.printf("%n%n" +
                "-------------------------------------------------------%n" +
                "\t\t\t%13s\t  %10.2f%n\t\t\t%13s\t  %10.2f%n" +
                "\t\t\t%13s\t  %10.2f%n" +
                "=======================================================%n" +
                "\t\t\t%13s\t  %10.2f%n=======================================================%n" +
                "   THIS IS NOT A RECEIPT, KINDLY PAY %.2f%n=======================================================%n",
                "Sub Total:", getSubTotal(), "Discount:", getDiscountedTotal(), "VAT @ 7.50%:", getVAT(),
                "Bill Total:", getBillTotal(), getBillTotal());

        System.out.println("\nHow much did the customer give to you?");
        double amountPaidInfo = input.nextDouble();
        while (amountPaidInfo < getBillTotal()) {
            System.out.println("Oga, oga oga... amount received is less than bill total");
            System.out.println("How much did the customer give to you?");
            amountPaidInfo = input.nextDouble();
        }
        setAmountPaid(amountPaidInfo);

        System.out.printf("%n%nSEMICOLON STORES%nMAIN BRANCH%nLOCATION: 312 HERBERT MACAULAY WAY, SABO YABA, LAGOS." +
                "%nTEL: 03293828343%nDate: %s%nCashier: %s%nCustomer Name: %s" +
                "%n", getCurrentDateAndTime(), getCashierName(), getCustomerName());

        System.out.println("""
                =======================================================
                         ITEM           QTY     PRICE        TOTAL(NGN)
                -------------------------------------------------------""");

        for (int index = 0; index < itemBought.size(); index++) {
            System.out.printf("   %10s", itemBought.get(index));
            System.out.printf("            %2d", quantityOfItem.get(index));
            System.out.printf(" %10.2f", priceOfItem.get(index));
            System.out.printf("     %10.2f", priceOfItem.get(index) * quantityOfItem.get(index));
            System.out.println();
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
                        "Sub Total:",getSubTotal(), "Discount:", getDiscountedTotal(),
                        "VAT @ 7.50%:", getVAT(), "Bill Total:", getBillTotal(),
                        "Amount Paid:", getAmountPaid(), "Balance:", getBalance());


    }





}
