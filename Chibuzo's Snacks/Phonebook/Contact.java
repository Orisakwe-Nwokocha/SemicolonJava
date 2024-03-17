import java.util.InputMismatchException;

public class Contact {
    private String contactName;
    private String phoneNumber;

    public Contact(String contactName, String phoneNumber) {
        phoneNumber = validate(phoneNumber);

        this.contactName = contactName;
        this.phoneNumber = phoneNumber;
    }

    private static String validate(String phoneNumber) {
        String number = "";
        if (phoneNumber.startsWith("+")) {
            number = String.valueOf(phoneNumber.charAt(0));
            phoneNumber = phoneNumber.substring(1);
        }

        if (!phoneNumber.matches("\\d+")) throw new InputMismatchException("Phone number must consist of only digits");

        return number + phoneNumber;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public void setPhoneNumber(String phoneNumber) {
        phoneNumber = validate(phoneNumber);

        this.phoneNumber = phoneNumber;
    }

    public String getContactName() {
        return contactName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return String.format("%s:\n%s", this.contactName, this.phoneNumber);
    }
}
