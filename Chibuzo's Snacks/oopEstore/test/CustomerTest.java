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

        phone = new Product(1, "Pixel", 350_000.0, "Smartphone", ProductCategory.ELECTRONICS);
        chocolate = new Product(2, "Magic", 2_000, "Chocolate", ProductCategory.GROCERIES);

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
        orisha.addToCart(phone, 1);
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
        orisha.addToCart(phone, 1);
        orisha.addToCart(chocolate, 5);
        assertEquals(2, orisha.viewCart().size());
        assertEquals(0, orisha.viewOrders().size());

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
    public void checkoutWithNullBillingInformation_unsuccessfulTransactionExceptionIsThrown() {
        orisha.addToCart(phone, 1);

        assertThrows(UnsuccessfulTransactionException.class, () -> orisha.checkout());
    }

}