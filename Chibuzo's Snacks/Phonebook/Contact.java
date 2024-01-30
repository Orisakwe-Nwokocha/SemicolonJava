import java.util.InputMismatchException;

public class Contact {
    private String contactName;
    private String phoneNumber;

    public Contact(String contactName, String phoneNumber) {
        if (!phoneNumber.matches("\\d+")) throw new InputMismatchException("Phone number must consist of only digits");
        this.contactName = contactName;
        this.phoneNumber = phoneNumber;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (!phoneNumber.matches("\\d+")) throw new InputMismatchException("Phone number must consist of only digits");
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
        return String.format("%s: %s", getContactName(), getPhoneNumber());
    }
}
