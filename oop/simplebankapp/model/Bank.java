package oop.simplebankapp.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * The {@link Bank} class is an abstract representation of
 * a bank. It performs the following financial operations:
 *
 * <ul>
 *     <li>Account creation</li>
 *     <li>Money deposit</li>
 *     <li>Money withdrawal</li>
 *     <li>Account deletion</li>
 * </ul>
 *
 * @author geozi
 */
public class Bank {
    private final HashMap<String, ArrayList<Customer>> accountToCustomers;
    private final HashMap<String, Account> accounts;
    private static final Map<AccountType, Boolean> overdraftPerAccountType = Map.of(AccountType.SAVINGS, false, AccountType.PAYROLL, true, AccountType.DAY_TO_DAY, false);

    /**
     * Initializes the fields of a newly-created {@link Bank} instance to default values.
     */
    Bank() {
        accounts = new HashMap<>();
        accountToCustomers = new HashMap<>();
    }

    /**
     * Generates an account number.
     * @return The account number of type String.
     */
    private String generateAccountNumber() {
        StringBuilder numberBuilder = new StringBuilder("00000000");
        for (int i = 0; i < 8; i++) {
            numberBuilder.append((int) (Math.random()*10));
        }
        return numberBuilder.toString();
    }

    /**
     * Creates a new account and returns its current state to the caller.
     * @param accountType The type of the account as an AccountType.
     * @param accountHolders The account holders as an ArrayList.
     * @return The state of the newly-created account.
     */
    String createAccount(AccountType accountType, ArrayList<Customer> accountHolders) {
        String accountNumber = generateAccountNumber();
        String newAccountState;

        while(accountToCustomers.containsKey(accountNumber)) {
            accountNumber = generateAccountNumber();
        }

        if(accountType == AccountType.SAVINGS) {
            SavingsAccount newAccount = new SavingsAccount(accountNumber, accountHolders);
            accounts.put(accountNumber, newAccount);
            accountToCustomers.put(accountNumber, accountHolders);
            newAccountState = newAccount.displayAccountInfo();
        } else if (accountType == AccountType.PAYROLL) {
            PayrollAccount newAccount = new PayrollAccount(accountNumber, accountHolders);
            accounts.put(accountNumber, newAccount);
            accountToCustomers.put(accountNumber, accountHolders);
            newAccountState = newAccount.displayAccountInfo();
        } else {
            DayToDayAccount newAccount = new DayToDayAccount(accountNumber, accountHolders);
            accounts.put(accountNumber, newAccount);
            accountToCustomers.put(accountNumber, accountHolders);
            newAccountState = newAccount.displayAccountInfo();
        }

        return newAccountState;
    }

    /**
     * Performs money deposit to a specified account and
     * returns the current state of the account to the caller.
     * @param amount The amount to be deposited of type double.
     * @param accountNumber The number of the account of type String.
     * @return The state of the account as a String.
     */
    String deposit(double amount, String accountNumber) {
        Account account = accounts.get(accountNumber);
        account.setBalance(account.getBalance() + amount);
        return account.displayAccountInfo();
    }

    /**
     * Performs money withdrawal from a specified account and
     * returns the current state of the account to the caller.
     * @param amount The amount to be withdrawn of type double.
     * @param accountNumber The number of the account of type String.
     * @return The state of the account as a String.
     */
    String withdraw(double amount, String accountNumber) {
        Account account = accounts.get(accountNumber);
        account.setBalance(account.getBalance() - amount);
        return account.displayAccountInfo();
    }

    /**
     * Deletes an account.
     * @param accountNumber The number of the account to be deleted as a String.
     */
    void deleteAccount(String accountNumber) {
        accounts.remove(accountNumber);
        accountToCustomers.remove(accountNumber);
    }

    /**
     * Checks if the amount inserted by the user is over the account balance.
     * @param accountNumber The number of the account of type String.
     * @param amount The amount of type double.
     * @return True if the amount is over balance, false otherwise.
     */
    boolean isOverBalance(String accountNumber, double amount) {
        return accounts.get(accountNumber).getBalance() < amount;
    }

    /**
     * Checks if an overdraft is allowed.
     * @param accountNumber The number of the account of type String.
     * @return True if the account type allows for an overdraft, false otherwise.
     */
    boolean isOverdraftAllowed(String accountNumber) {
        boolean overdraftAllowed;
        Account account = accounts.get(accountNumber);

        if(account instanceof SavingsAccount) {
            overdraftAllowed = overdraftPerAccountType.get(AccountType.SAVINGS);
        } else if (account instanceof  PayrollAccount) {
            overdraftAllowed = overdraftPerAccountType.get(AccountType.PAYROLL);
        } else {
            overdraftAllowed = overdraftPerAccountType.get(AccountType.DAY_TO_DAY);
        }
        return overdraftAllowed;
    }

    /**
     * Checks if an account exists.
     * @param accountNumber The number of the account of type String.
     * @return True if the account exists, false otherwise.
     */
    boolean accountExists(String accountNumber) {
        return accountToCustomers.containsKey(accountNumber);
    }
}
