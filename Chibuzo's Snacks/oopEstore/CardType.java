package oopEstore;

public enum CardType {
    MASTER_CARD(new Address()),
    VISA_CARD(new Address()),
    VERVE(new Address()),
    AMERICA_EXPRESS(new Address());

    private Address address;

    CardType(Address address) {
        this.address = address;
    }
    
}
