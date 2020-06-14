package bank_application;

public class Customer {

    private String firstName;
    private String lastName;
    private String email;
    private String customerId;

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        if(!email.equalsIgnoreCase(this.email)) {
            this.email = email;
        }
    }

    public String getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(String customerId) {
        if(!customerId.equalsIgnoreCase(this.customerId)) {
            this.customerId = customerId;
        }
    }
}
