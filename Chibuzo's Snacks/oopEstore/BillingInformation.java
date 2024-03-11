package oopEstore;

public record BillingInformation(String receiverPhoneNumber, String receiverName, Address deliveryAddress, CreditCardInformation creditCardInfo) {

}
