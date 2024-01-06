package oop.simplebankapp.model;

import java.time.LocalDate;

/**
 * The {@link Customer} class is an abstract representation of a bank customer.
 *
 * @author geozi
 */
public class Customer {
    private String firstname;
    private String lastname;
    private String address;
    private LocalDate dateOfBirth;
    private String mobilePhoneNumber;

    /**
     * Initializes the fields of a newly-created {@link Customer} instance to the values
     * provided by the caller.
     * @param firstname The firstname of type String.
     * @param lastname The lastname of type String.
     * @param dateOfBirth The date of birth of type LocalDate.
     * @param address The address of type String.
     * @param mobilePhoneNumber The mobile phone number of type String.
     */
    public Customer(String firstname, String lastname, LocalDate dateOfBirth, String address, String mobilePhoneNumber) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

    // Getters and setters

    /**
     * Returns the firstname of the customer to the caller.
     * @return The firstname of type String.
     */
    String getFirstname() {
        return firstname;
    }

    /**
     * Updates the firstname of the customer.
     * @param firstname The new firstname of type String.
     */
    void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * Returns the lastname of the customer to the caller.
     * @return The lastname of type String.
     */
    String getLastname() {
        return lastname;
    }

    /**
     * Updates the lastname of the customer.
     * @param lastname The new lastname of type String.
     */
    void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * Returns the address of the customer to the caller.
     * @return The address of type String.
     */
    String getAddress() {
        return address;
    }

    /**
     * Updates the address of the customer.
     * @param address The new address of type String.
     */
    void setAddress(String address) {
        this.address = address;
    }

    /**
     * Returns the date of birth of the customer to the caller.
     * @return The date of birth of type LocalDate.
     */
    LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Updates the date of birth of the customer.
     * @param dateOfBirth The new date of birth of type LocalDate.
     */
    void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Returns the mobile phone of the customer to the caller.
     * @return The mobile phone of type String.
     */
    String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    /**
     * Updates the mobile phone of the customer.
     * @param mobilePhoneNumber The new mobile phone of type String.
     */
    void setMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

    /**
     * Returns the current state of the Customer instance to the caller.
     * @return A limited version of the current state of type String.
     */
    String displayCustomerInfo() {
        return String.format("Name: %s %s", this.firstname, this.lastname);
    }
}
