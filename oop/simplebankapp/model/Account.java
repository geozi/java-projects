package oop.simplebankapp.model;

import java.util.ArrayList;

/**
 * The {@link Account} class is an abstract representation of
 * a bank account.
 *
 * @author geozi
 */
public class Account {
    private String accountNumber;
    private ArrayList<Customer> accountHolders;
    private double balance;

    // Getters and setters

    /**
     * Returns the account number to the caller.
     * @return The account number of type String.
     */
    protected String getAccountNumber() {return this.accountNumber;}

    /**
     * Updates the account number.
     * @param accountNumber The new account number of type String.
     */
    protected void setAccountNumber(String accountNumber) {this.accountNumber = accountNumber;}

    /**
     * Returns the customers of the account as a list to the caller.
     * @return The customers as an ArrayList.
     */
    protected ArrayList<Customer> getAccountHolders() {
        return accountHolders;
    }

    /**
     * Updates the customers connected to the account.
     * @param accountHolders The new customer list as an ArrayList.
     */
    protected void setAccountHolders(ArrayList<Customer> accountHolders) {
        this.accountHolders = accountHolders;
    }

    /**
     * Returns the balance of the account to the caller.
     * @return The balance of type double.
     */
    protected double getBalance() {
        return balance;
    }

    /**
     * Updates the balance of the account.
     * @param balance The new balance of type double.
     */
    protected void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * The purpose of this method is to be overridden
     * by the subclasses.
     * @return A empty String.
     */
    String displayAccountInfo() { return ""; }
}
