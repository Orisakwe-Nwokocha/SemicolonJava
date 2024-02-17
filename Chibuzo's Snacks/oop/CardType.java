package oop;

public enum CardType {
    MASTER_CARD(new Address("", "", "", "", "")),
    VISA_CARD(new Address("", "", "", "", "")),
    VERVE(new Address("", "", "", "", "")),
    AMERICA_EXPRESS(new Address("", "", "", "", ""));

    private Address address;

    CardType(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
