import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class CheckOutApp {

    private String customerName;
    private String cashierName;
    private double subTotal;
    private double discount;
    private double amountPaid;

    public String getCurrentDateAndTime() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MMM-yy hh:mm:ss a");

        String currentDateAndTime = currentDateTime.format(dateTimeFormatter);
        currentDateAndTime = currentDateAndTime.replace("AM", "am")
                .replace("PM", "pm");

        return currentDateAndTime;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCashierName(String cashierName) {
        this.cashierName = cashierName;
    }

    public String getCashierName() {
        return cashierName;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setDiscount(double discount) {
        if (discount < 0 || discount > 100) throw new IllegalArgumentException("Discount must be between 0 and 100");
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }

    public double getDiscountedTotal() {
        return (discount / 100.0) * subTotal;
    }

    public double getVAT() {
        return subTotal * (7.5 / 100);
    }

    public double getBillTotal() {
        return (subTotal - getDiscountedTotal()) + getVAT();
    }

    public void setAmountPaid(double amountPaid) {
        if (amountPaid < getBillTotal()) throw new IllegalArgumentException("Amount paid cannot be less than bill total");
        this.amountPaid = amountPaid;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public double getBalance() {
        double balance = 0.0;
        if (amountPaid > getBillTotal()) return amountPaid - getBillTotal();
        else return balance;
    }

}