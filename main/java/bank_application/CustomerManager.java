package bank_application;

import java.util.Arrays;
import java.util.Scanner;

public class CustomerManager {

    public static void main(String[] args) {

        int newCustomerIterator = 0;

        String[][] customerArray = new String[2][4];

        boolean addMoreCustomer = true;
        boolean searchFlag = true;
        String searchResult = "";
        Scanner confirmAddNewCustomer = new Scanner(System.in);

        while(addMoreCustomer) {
            System.out.println("Do you want add a new customer? (y/n)");
            String confirmation = confirmAddNewCustomer.nextLine();
            if(confirmation.equalsIgnoreCase("y") && newCustomerIterator < customerArray.length) {
                customerArray[newCustomerIterator] = addNewCustomer(customerArray);
                newCustomerIterator++;
            } else if (newCustomerIterator == customerArray.length) {
                System.out.println("The storage capacity is full. You cannot add any new customer. Please contact the admin.");
                while (searchFlag) {
                    if (!searchResult.equalsIgnoreCase("")) {
                        System.out.println(searchResult);
                    }
                    System.out.println("Do you want to search any customer? (y/n)");
                    String adminInput = confirmAddNewCustomer.nextLine();
                    if (adminInput.equalsIgnoreCase("n")) {
                        searchFlag = false;
                        addMoreCustomer = false;
                    } else {
                        searchResult = customerSearchEngine(customerArray);
                        if (searchResult.equalsIgnoreCase("No result found!")) {
                            addMoreCustomer = false;
                        }
                    }
                }
            } else {
                while (searchFlag) {
                    if (!searchResult.equalsIgnoreCase("")) {
                        System.out.println(searchResult);
                    }
                    System.out.println("Do you want to search any customer? (y/n)");
                    String adminInput = confirmAddNewCustomer.nextLine();
                    if (adminInput.equalsIgnoreCase("n")) {
                        searchFlag = false;
                        addMoreCustomer = false;
                    } else {
                        searchResult = customerSearchEngine(customerArray);
                        if (searchResult.equalsIgnoreCase("No result found!")) {
                            addMoreCustomer = false;
                        }
                    }
                }
            }
        }

        for (String[] customerInfo: customerArray
        ) {
            for (String customer: customerInfo
                 ) {
                if (customer != null) {
                    System.out.println(customer);
                }
            }
        }
    }

    public static String[] addNewCustomer(String[][] customerArray) {
        Scanner customerInput = new Scanner(System.in);
        System.out.println("Please enter the following information to add a new customer");
        System.out.println("Firstname: ");
        String firstName = customerInput.nextLine();
        System.out.println("Lastname: ");
        String lastName = customerInput.nextLine();
        System.out.println("Email: ");
        String email = customerInput.nextLine();
        String validatedEmail = customerEmailValidator(customerArray, email);
        if (validatedEmail == "Duplicate email is not accepted") {
            System.out.println("Duplicate email is not accepted. Please enter the email again.");
            email = customerInput.nextLine();
            validatedEmail = customerEmailValidator(customerArray, email);
        }
        System.out.println("Customer ID: ");
        String customerId = customerInput.nextLine();
        String validatedCustomerId = customerIdValidator(customerArray, customerId);
        if (validatedCustomerId == "Duplicate id is not accepted") {
            System.out.println("Duplicate id is not accepted. Please enter the id again.");
            customerId = customerInput.nextLine();
            validatedCustomerId = customerIdValidator(customerArray, customerId);
        }
        return createNewCustomer(firstName, lastName, validatedEmail, validatedCustomerId);
    }

    public static String customerEmailValidator(String[][] customerArray, String customerEmail) {
        for (String[] customerInfo : customerArray
             ) {
            for (String customer : customerInfo
                 ) {
                if (customer != null && customer.equalsIgnoreCase(customerEmail)) {
                    return "Duplicate email is not accepted";
                }
            }
        }
        return customerEmail;
    }

    public static String customerIdValidator(String[][] customerArray,  String customerId) {
        for (String[] customerInfo : customerArray
        ) {
            for (String customer : customerInfo
            ) {
                if (customer != null && customer.equalsIgnoreCase(customerId)) {
                    return "Duplicate id is not accepted";
                }
            }
        }
        return customerId;
    }

    public static String[] createNewCustomer(String firstName, String lastName, String email, String customerId) {
        Customer newCustomer = new Customer(firstName, lastName);
        newCustomer.setEmail(email);
        newCustomer.setCustomerId(customerId);
        String[] addNewCustomer = {
                newCustomer.getFirstName(),
                newCustomer.getLastName(),
                newCustomer.getEmail(),
                newCustomer.getCustomerId()};
        return addNewCustomer;
    }

    public static String customerSearchEngine(String[][] customerArray) {
        Scanner customerSearchInitiator = new Scanner(System.in);
        String searchQuery = "";
        System.out.println("Please enter customer info (first name, last name, email or customer id)");
        searchQuery = customerSearchInitiator.nextLine();
        for (String[] customerInfo : customerArray
        ) {
            for (String customer : customerInfo
            ) {
                if (customer != null && customer.equalsIgnoreCase(searchQuery)) {
                    return customer;
                }
            }
        }
        return "No result found!";
    }
}
