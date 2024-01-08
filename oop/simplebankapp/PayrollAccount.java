package oop.simplebankapp;

import java.util.ArrayList;

/**
 * The {@link PayrollAccount} class is a subclass of the {@link Account}
 * class. It is an abstract  representation of a payroll account.
 *
 * @author geozi
 */
public class PayrollAccount extends Account {
    private final double PAYROLL_INTEREST = 0.02;

    /**
     * Initializes the fields of a {@link PayrollAccount} instance to the
     * values provided by the caller.
     * @param accountNumber The account number of type String.
     * @param accountHolders The account holders as an ArrayList.
     */
    PayrollAccount(String accountNumber, ArrayList<Customer> accountHolders) {
        this.setAccountNumber(accountNumber);
        this.setAccountHolders(accountHolders);
        this.setBalance(0);
        this.setAccountType(AccountType.PAYROLL);
    }

    /**
     * Returns the current state of the PayrollAccount instance to the caller.
     * @return The current state of the account as a String.
     */
    @Override
    String displayAccountInfo() {
        StringBuilder consoleMsg = new StringBuilder("\nPayroll Account");
        consoleMsg.append("\nMonthly Interest: ");
        consoleMsg.append(PAYROLL_INTEREST);
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
