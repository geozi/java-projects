package oop.simplebankapp.model;

import java.util.ArrayList;

/**
 * The {@link SavingsAccount} class is a subclass of the {@link Account}
 * class. It is an abstract representation of a savings account.
 *
 * @author geozi
 */
public class SavingsAccount extends Account {
    private final double SAVINGS_INTEREST = 0.01;

    /**
     * Initializes the fields of a {@link SavingsAccount} instance to the
     * values provided by the caller.
     * @param accountNumber The account number of type String.
     * @param accountHolders The account holders as an ArrayList.
     */
    SavingsAccount(String accountNumber, ArrayList<Customer> accountHolders) {
        this.setAccountNumber(accountNumber);
        this.setAccountHolders(accountHolders);
        this.setBalance(0);
    }

    /**
     * Returns the current state of the SavingsAccount instance to the caller.
     * @return The current state of the account as a String.
     */
    @Override
    String displayAccountInfo() {
        StringBuilder consoleMsg = new StringBuilder("\nSavings Account");
        consoleMsg.append("\nMonthly Interest: ");
        consoleMsg.append(SAVINGS_INTEREST);
        consoleMsg.append("\nAccount Number: ");
        consoleMsg.append(this.getAccountNumber());
        consoleMsg.append("\nAccount Holder(s)\n============");
        for(Customer customer : this.getAccountHolders()) {
            consoleMsg.append("\n");
            consoleMsg.append(customer.displayCustomerInfo());
        }
        consoleMsg.append("\n============\nBalance: ");
        consoleMsg.append(this.getBalance());
        return consoleMsg.toString();
    }
}
