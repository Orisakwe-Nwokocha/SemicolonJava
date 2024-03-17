package oopEstore;

import javax.swing.*;

public class ElectronicStoreApp {
    private static final Address dummyAddress = new Address("city", "country", "1",
            "street", "state");
    private static final Admin admin = new Admin(1, "admin", 47, "admin@mail.com",
            dummyAddress, "password", "phone");

    private static Customer customer = new Customer();
    private static Address address;
    private static boolean isLoggedIn;
    private static BillingInformation billingInformation;
    private static final ShoppingCart cart = customer.getCart();

    public static void startApp() {
        admin.addInitialInventory();

        print("Welcome to C19 Electronic Store", "Welcome");

        int choice = getChoice("Do you want to create an account?");
        if (choice == JOptionPane.YES_OPTION) createAccount();

        gotoMainMenu();
    }

    private static void gotoMainMenu() {
        String menu = """
                1. Create an account
                2. Browse products
                3. Add items to cart
                4. View cart
                5. Checkout
                6. View orders
                7. Remove items from cart
                8. Login
                9. Close account
                10. Logout
                11. Exit app
                
                Select option:
                """;
        String userChoice = input(menu);
        handleUserChoice(userChoice);
    }

    private static void handleUserChoice(String userChoice) {
        switch (userChoice) {
            case "1" -> createAccount();
            case "2" -> browseProducts();
            case "3" -> addToCart();
            case "4" -> viewCart();
            case "5" -> checkout();
            case "6" -> viewOrders();
            case "7" -> removeFromCart();
            case "8" -> login();
            case "9" -> deleteAccount();
            case "10" -> logout();
            case "11" -> exit();
            default -> gotoMainMenu();
        }
    }

    private static void deleteAccount() {
        checkLoginStatus();

        String customerId = input("Enter your customer ID:");
        String password = input("Enter your password:");

        try {
            customer = admin.findCustomer(Integer.parseInt(customerId));
        }
        catch (RuntimeException e) {
            displayErrorMessage(e.getMessage());
            gotoMainMenu();
        }
        finally {
            validate(password);
            admin.removeCustomerAccount(Integer.parseInt(customerId), password);
            isLoggedIn = false;
            print("Your account has been deleted successfully", "Account deleted");

            gotoMainMenu();
        }
    }

    private static void logout() {
        checkLoginStatus();
        isLoggedIn = false;
        print("You are now logged out", "Logout");

        gotoMainMenu();
    }

    private static void login() {
        if (isLoggedIn) gotoMainMenu();
        print("Welcome to C19 Electronic Store", "Login");

        String customerId = input("Enter your customer ID:");
        String password = input("Enter your password:");

        try {
            customer = admin.findCustomer(Integer.parseInt(customerId));
        }
        catch (RuntimeException e) {
            displayErrorMessage(e.getMessage());
            gotoMainMenu();
        }
        finally {
            validate(password);
            isLoggedIn = true;
            print("Your account has been logged in", "Login");
            customer.setShoppingCart(cart);

            gotoMainMenu();
        }
    }

    private static void viewOrders() {
        checkLoginStatus();
        checkOrderStatus();

        for (Order order : customer.viewOrders()) print(order.toString(), "Orders placed");

        gotoMainMenu();
    }

    private static void checkout() {
        checkLoginStatus();
        checkCartStatus();

        if (customer.getBillingInformation() == null) collectBillInformationDetails();
        customer.setBillingInformation(billingInformation);

        if (checkoutChoice() == JOptionPane.NO_OPTION) gotoMainMenu();

        try {
            customer.checkout();
            print("Your order has been successfully placed!!!", "Thank you for your order");
        }
        catch (RuntimeException e) {
            displayErrorMessage(e.getMessage());

            if (billingInformation.creditCardInfo().cardType() == null)updateCardInfo();
        }
        finally {
            gotoMainMenu();
        }
    }

    private static void removeFromCart() {
        checkCartStatus();
        String productId = input("Please enter the id of the product you want to remove from your cart:");

        try {
            customer.removeFromCart(Integer.parseInt(productId));
            print("Item successfully removed from cart", "Removed from cart");
        }
        catch (RuntimeException e) {
            displayErrorMessage(e.getMessage());
        }
        finally {
            gotoMainMenu();
        }
    }

    private static void viewCart() {
        if (customer.viewCart().isEmpty()) print("Your cart is empty!", "Items in cart");
        else for (Item item : customer.viewCart()) print(item.toString(), "Items in cart");

        gotoMainMenu();
    }

    private static void addToCart() {
        String productId = input("Please enter the id of the product you wish to add to cart:");
        String quantity = input("Please enter the quantity of the product you wish to add to cart:");

        try {
            Product product = admin.findProductById(Integer.parseInt(productId));
            customer.addToCart(product, Integer.parseInt(quantity));

            print("Product successfully added to your cart", "Success");
        }
        catch (RuntimeException e) {
            displayErrorMessage(e.getMessage());
        }
        finally {
            gotoMainMenu();
        }
    }

    private static void browseProducts() {
        for (Product product : admin.getProducts()) print(product.toString(), "Available products");

        gotoMainMenu();
    }

    private static void createAccount() {
        String name = input("Enter your name:");
        String age = input("Enter your age:");

        try {
            if (Integer.parseInt(age) < 13) throw new IllegalArgumentException("Age must be at least 13");
        }
        catch (RuntimeException e) {
            displayErrorMessage(e.getMessage());
            gotoMainMenu();
        }

        String email = input("Enter your email:");
        String password = input("Enter a password:");
        String phone = input("Enter your phone number:");

        print("Enter your home address details", "Thanks");
        initializeAddress();

        try {

            customer = admin.registerCustomer(name, Integer.parseInt(age), email, address, password, phone);
            print("Account created successfully", "Success");
            print("Your account id is " + customer.getId(), "Success");
        }
        catch (RuntimeException e) {
            displayErrorMessage(e.getMessage());
            gotoMainMenu();
        }
        finally {
            isLoggedIn = true;
            print("Your account has been logged in", "Login");
            customer.setShoppingCart(cart);

            gotoMainMenu();
        }
    }

    private static void exit() {
        print("Thank you for shopping with us!!!", "Goodbye");

        System.exit(0);
    }

    private static void initializeAddress() {
        String cityName = input("Enter your city name:");
        String countryName = input("Enter your country name:");
        String houseNumber = input("Enter your house number:");
        String streetName = input("Enter your street name:");
        String stateName = input("Enter your state name:");

        address = new Address(cityName, countryName, houseNumber, streetName, stateName);
    }

    private static void collectBillInformationDetails() {
        String receiverPhoneNumber = input("Enter the receiver's phone number:");
        String receiverName = input("Enter the receiver's name:");

        int choice = getChoice("Is the delivery address the same as your home address?");
        if (choice == 1) initializeAddress();

        print("Enter your credit card information", "Thanks");
        CreditCardInformation cardInformation = getCreditCardInformation();

        billingInformation = new BillingInformation(receiverPhoneNumber, receiverName, address, cardInformation);
    }

    private static CreditCardInformation getCreditCardInformation() {
        String creditCardNumber = input("Enter the credit card number:");
        String cardHolderName = input("Enter the card holder name:");
        String creditCardExpirationDate = input("Enter the credit card expiration date (mm/yy):");
        String creditCardCvv = input("Enter the credit card cvv:");
        CardType cardType = getCardType(creditCardNumber);

        return new CreditCardInformation(creditCardCvv, creditCardExpirationDate, creditCardNumber, cardHolderName, cardType);
    }

    private static CardType getCardType(String creditCardNumber) {
        if (creditCardNumber.charAt(0) == '4') return CardType.VISA_CARD;
        else if (creditCardNumber.charAt(0) == '5' && creditCardNumber.length() == 18) return CardType.VERVE;
        else if (creditCardNumber.charAt(0) == '5') return CardType.MASTER_CARD;
        else if (creditCardNumber.charAt(0) == '3' && creditCardNumber.charAt(1) == '7') return CardType.AMERICA_EXPRESS;

        return null;
    }

    private static void updateCardInfo() {
        int choice = getChoice("Do you want to update your card details?");
        if (choice == 1) gotoMainMenu();

        CreditCardInformation updatedCardInfo = getCreditCardInformation();

        billingInformation = new BillingInformation(billingInformation.receiverPhoneNumber(),
                billingInformation.receiverName(), address, updatedCardInfo);
    }

    private static void checkCartStatus() {
        if (customer.viewCart().isEmpty()) {
            displayErrorMessage("There are no items in your cart.");
            gotoMainMenu();
        }
    }

    private static void checkLoginStatus() {
        if (!isLoggedIn) {
            displayErrorMessage("You need to be logged in to perform this operation.");
            gotoMainMenu();
        }
    }

    private static void checkOrderStatus() {
        if (customer.viewOrders().isEmpty()) {
            displayErrorMessage("You haven't ordered any items yet.");
            gotoMainMenu();
        }
    }

    private static int checkoutChoice() {
        double totalPrice = Checkout.calculateTotalPrice(customer.getCart());
        String checkoutMessage = String.format("""
                The total price of items in your cart is ₦%,.2f
                Do you wish to proceed?""", totalPrice);

        return getChoice(checkoutMessage);
    }

    private static void validate(String password) {
        if (!customer.isCorrect(password)) {
            displayErrorMessage("Invalid Password");
            gotoMainMenu();
        }
    }

    private static void print(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    private static String input(String message) {
        return JOptionPane.showInputDialog(null, message, "Input", JOptionPane.QUESTION_MESSAGE);
    }

    private static int getChoice(String message) {
        return JOptionPane.showConfirmDialog(null, message,
                "Select option", JOptionPane.YES_NO_OPTION);
    }

    private static void displayErrorMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
