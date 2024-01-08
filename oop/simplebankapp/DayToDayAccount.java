package oop.simplebankapp;

import java.util.ArrayList;

/**
 * The {@link DayToDayAccount} class is a subclass of the {@link Account}
 * class. It is an abstract  representation of a checking account.
 *
 * @author geozi
 */
public class DayToDayAccount extends Account {
    private final double CHECKING_INTEREST = 0.001;

    /**
     * Initializes the fields of a newly-created {@link DayToDayAccount} instance
     * to the values provided by the caller.
     * @param accountNumber The account number of type String.
     * @param accountHolders The account holders as an ArrayList.
     */
    DayToDayAccount(String accountNumber, ArrayList<Customer> accountHolders) {
        this.setAccountNumber(accountNumber);
        this.setAccountHolders(accountHolders);
        this.setBalance(0);
        this.setAccountType(AccountType.DAY_TO_DAY);
    }

    /**
     * Returns the current state of the DayToDayAccount instance to the caller.
     * @return The current state of the account as a String.
     */
    @Override
    String displayAccountInfo() {
        StringBuilder consoleMsg = new StringBuilder("\nDayToDay Account");
        consoleMsg.append("\nMonthly Interest: ");
        consoleMsg.append(CHECKING_INTEREST);
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
