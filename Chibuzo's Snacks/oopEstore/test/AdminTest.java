package oopEstore;

import oopEstore.exceptions.IncorrectPasswordException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AdminTest {
    private Admin admin;
    private Address address;

    @BeforeEach
    public void initializeAdmin() {
        address = new Address("city", "country", "1", "street", "state");
        admin = new Admin(1, "orisha", 15, "o@mail.com", address, "password", "phone");

    }

    @Test
    public void given0CustomersRegistered_numberOfCustomersIs0Test() {
        assertEquals(0, admin.getCustomers().size());
    }

    @Test
    public void registerCustomer_numberOfCustomersIs1Test() {
        Customer orisha = new Customer(1, "orisha", 15, "o@mail.com", address, "password", "phone");
        admin.registerCustomer(orisha);

        assertEquals(1, admin.getCustomers().size());
    }

    @Test
    public void givenCustomer_whenRemoved_numberOfCustomersIs0Test() {
        admin.registerCustomer("orisha", 15, "o@mail.com", address, "correctPassword", "phone");
        assertEquals(1, admin.getCustomers().size());

        admin.removeCustomerAccount(1, "correctPassword");
        assertEquals(0, admin.getCustomers().size());
    }

    @Test
    public void removeCustomerWithIncorrectPassword_incorrectPasswordExceptionIsThrown_numberOfCustomersIs1Test() {
        Customer orisha = new Customer(1, "orisha", 15, "o@mail.com", address, "correctPassword", "phone");
        admin.registerCustomer(orisha);
        assertEquals(1, admin.getCustomers().size());

        assertThrows(IncorrectPasswordException.class, () -> admin.removeCustomerAccount(1, "incorrectPassword"));
        assertEquals(1, admin.getCustomers().size());
    }

    @Test
    public void removeCustomerWithIncorrectId_illegalArgumentExceptionIsThrown_numberOfCustomersIs1Test() {
        Customer orisha = new Customer(1, "orisha", 15, "o@mail.com", address, "correctPassword", "phone");
        admin.registerCustomer(orisha);
        assertEquals(1, admin.getCustomers().size());

        assertThrows(IllegalArgumentException.class, () -> admin.removeCustomerAccount(2, "incorrectPassword"));
        assertEquals(1, admin.getCustomers().size());
    }

    @Test
    public void testThatInitialNumberOfProductsAddedToStoreIs4() {
        admin.addInitialInventory();
        assertEquals(4, admin.getProducts().size());

        System.out.println(admin.getProducts());
    }

    @Test
    public void testThatProductsCanBeFoundById() {
        admin.addInitialInventory();
        Product product = new Product(1, "Pixel", 350_000.0, "Android smartphone",
                ProductCategory.ELECTRONICS);

        assertEquals(product, admin.findProductById(1));    }

    @Test
    public void findProductWithNonExistingId_illegalArgumentExceptionIsThrownTest() {
        admin.addInitialInventory();

        assertThrows(IllegalArgumentException.class, () -> admin.findProductById(5));
    }

}