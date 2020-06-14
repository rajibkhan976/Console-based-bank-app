package test_bank_application;

import bank_application.Customer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestCustomer {

    private Customer testCustomer;

    @Before
    public void customerSetUp() {
        testCustomer = new Customer("Rajib Hossain", "Khan");
    }

    @Test
    public void testGetFirstname() {
        String expectedName = "Rajib Hossain";
        String actualName = testCustomer.getFirstName();
        Assert.assertEquals(expectedName, actualName);
    }

    @Test
    public void testGetLastname() {
        String expectedName = "Khan";
        String actualName = testCustomer.getLastName();
        Assert.assertEquals(expectedName, actualName);
    }

    @Test
    public void testGetEmail() {
        String expectedEmail = "rajibkhan976@gmail.com";
        testCustomer.setEmail(expectedEmail);
        String actualEmail = testCustomer.getEmail();
        Assert.assertEquals(expectedEmail, actualEmail);
    }

    @Test
    public void testGetCustomerId() {
        String expectedCustomerId = "2ergkn";
        testCustomer.setCustomerId(expectedCustomerId);
        String actualCustomerId = testCustomer.getCustomerId();
        Assert.assertEquals(expectedCustomerId, actualCustomerId);
    }
}
