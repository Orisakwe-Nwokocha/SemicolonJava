package oop;

public class Main {
    public static void main(String[] args) {
        CardType ct = CardType.MASTER_CARD;

        System.out.println(ct.getAddress());

        Address address = new Address("lagos", "nigeria", "32",
                "emily akinola", "lagos");

        ct.setAddress(address);

        System.out.println(ct.getAddress());
    }
}
