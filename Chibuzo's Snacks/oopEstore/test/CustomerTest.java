package oopEstore;

import oopEstore.exceptions.ItemNotFoundException;
import oopEstore.exceptions.UnsuccessfulTransactionException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {
    private Customer orisha;
    private Address address;
    private Product phone;
    private Product chocolate;
    private BillingInformation billingInformation;

    @BeforeEach
    public void startWithThis() {
        address = new Address("city", "country", "1", "street", "state");
        orisha = new Customer(1, "orisha", 15, "o@mail.com", address, "password", "phone");

        phone = new Product(1, "Pixel", 350_000.0, "Smartphone", ProductCategory.ELECTRONICS, 10);
        chocolate = new Product(2, "Magic", 2_000, "Chocolate", ProductCategory.GROCERIES, 100);

        CreditCardInformation cardInformation = new CreditCardInformation("123", "09/24",
                "5678 1234 9012 3456", "orisha", CardType.MASTER_CARD);

        billingInformation = new BillingInformation("08125358910", "orisha",
                address, cardInformation);
    }

    @Test
    public void given0Items_thenNumberOfItemsInCartIs0Test() {
        assertEquals(0, orisha.viewCart().size());
    }

    @Test
    public void addItemToCart_thenNumberOfItemsInCartIs1Test() {
        orisha.addToCart(phone, 1);
        assertEquals(1, orisha.viewCart().size());
    }

    @Test
    public void addItemTwiceToCart_thenNumberOfItemsInCartIs1Test() {
        orisha.addToCart(phone, 1);
        orisha.addToCart(chocolate, 5);
        assertEquals(2, orisha.viewCart().size());
        System.out.println(orisha.viewCart());
    }

    @Test
    public void givenItemInCart_viewItemTest() {
        orisha.addToCart(phone, 1);

        List<Item> expected = List.of(new Item(phone, 1));
        assertEquals(expected, orisha.viewCart());
    }

    @Test
    public void given1ItemInCart_whenRemoved_thenNumberOfItemsInCartIs0() {
        ShoppingCart cart = new ShoppingCart();
        cart.add(phone, 1);
        orisha.setShoppingCart(cart);
        assertEquals(1, orisha.viewCart().size());

        orisha.removeFromCart(phone.getId());
        assertEquals(0, orisha.viewCart().size());
    }

    @Test
    public void removeItemFromEmptyCart_illegalStateExceptionIsThrownTest() {
        assertThrows(IllegalStateException.class, () -> orisha.removeFromCart(phone.getId()));
    }

    @Test
    public void removeItemNotInCart_itemNotFoundExceptionIsThrownTest() {
        orisha.addToCart(phone, 1);
        assertThrows(ItemNotFoundException.class, () -> orisha.removeFromCart(2));

        try {
            orisha.removeFromCart(2);
        }
        catch (ItemNotFoundException e) {
            assertEquals("Item is not in the cart.", e.getMessage());
        }
    }

    @Test
    public void quantityOfProductXIs1_addQuantity_thenQuantityOfProductXIs2_numberOfItemsInCartIs1() {
        orisha.addToCart(phone, 1);
        List<Item> expected = List.of(new Item(phone, 1));
        assertEquals(expected, orisha.viewCart());
        assertEquals(1, orisha.viewCart().size());

        orisha.addToCart(phone, 2);

        expected = List.of(new Item(phone, 2));
        assertEquals(expected, orisha.viewCart());
        assertEquals(1, orisha.viewCart().size());
    }

    @Test
    public void addItemWithNonPositiveQuantityValue_illegalArgumentExceptionIsThrown() {
        assertThrows(IllegalArgumentException.class, () -> orisha.addToCart(phone, -1));
        assertThrows(IllegalArgumentException.class, () -> orisha.addToCart(phone, 0));

    }

    @Test
    public void updateItemQuantityWithNonPositiveValue_illegalArgumentExceptionIsThrown() {
        orisha.addToCart(phone, 1);
        assertEquals(1, orisha.viewCart().size());

        assertThrows(IllegalArgumentException.class, () -> orisha.addToCart(phone, 0));
        assertThrows(IllegalArgumentException.class, () -> orisha.addToCart(phone, -1));
    }

    @Test
    public void givenItemsInCart_whenCheckedOut_thenNumberOfOrdersIs1() {
        System.out.println(Checkout.calculateTotalPrice(orisha.getCart()));
        orisha.addToCart(phone, 1);
        orisha.addToCart(chocolate, 5);
        assertEquals(2, orisha.viewCart().size());
        assertEquals(0, orisha.viewOrders().size());
        System.out.println(Checkout.calculateTotalPrice(orisha.getCart()));

        orisha.setBillingInformation(billingInformation);
        orisha.checkout();
        assertEquals(1, orisha.viewOrders().size());

        System.out.println(orisha.viewOrders());
    }

    @Test
    public void checkoutWithEmptyCart_illegalStateExceptionIsThrown() {
        assertThrows(IllegalStateException.class, () -> orisha.checkout());
    }

    @Test
    public void checkoutWithInvalidCardType_unsuccessfulTransactionExceptionIsThrownTest() {
        orisha.addToCart(phone, 1);

        CreditCardInformation cardInformation = new CreditCardInformation("123", "09/24",
                "5678 1234 9012 3456", "orisha", null);
        billingInformation = new BillingInformation("08125358910",
                "orisha", address, cardInformation);
        if (orisha.getBillingInformation() == null) orisha.setBillingInformation(billingInformation);

        assertThrows(UnsuccessfulTransactionException.class, () -> orisha.checkout());

        try {
            orisha.checkout();
        }
        catch (UnsuccessfulTransactionException e) {
            assertEquals("Invalid card - payment unsuccessful", e.getMessage());
        }
    }

    @Test
    public void given10QuantityOfElectronics_customerBuys1Product_whenCheckedOut_thenNumberOfAvailableElectronicsIs9() {
        Inventory inventory = new Inventory();
        inventory.add(phone);

        assertEquals(10, inventory.getQuantityOf(1));
        orisha.addToCart(phone, 1);

        orisha.setBillingInformation(billingInformation);
        orisha.checkout();

        assertEquals(9, inventory.getQuantityOf(1));
    }

    @Test
    public void customerAddsToCartProductQuantityAboveAvailableStock_IllegalArgumentExceptionIsThrownTest() {
        Inventory inventory = new Inventory();
        inventory.add(phone);

        assertEquals(10, inventory.getQuantityOf(1));

        assertThrows(IllegalArgumentException.class, () -> orisha.addToCart(phone, 11));
        assertEquals(10, inventory.getQuantityOf(1));
    }

}