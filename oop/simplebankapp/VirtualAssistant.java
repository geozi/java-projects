package oop.simplebankapp;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The {@link VirtualAssistant} class is the driver class
 * of the simple bank app project. It:
 *
 * <ul>
 *     <li>Receives the input from the user</li>
 *     <li>Sends it for validation control to the {@link Validation} class methods</li>
 *     <li>If the input passes successfully the validation controls, it sends
 *     it to the {@link Bank} class methods.</li>
 * </ul>
 *
 * @author geozi
 */
public class VirtualAssistant {

    /**
     * Maps the user choice to an AccountType.
     * @param userChoice The user choice of type int.
     * @return The account type as an AccountType.
     */
    private static AccountType choiceToAccountType(int userChoice) {
        AccountType accountType = null;

        switch(userChoice){
            case 1:
                accountType = AccountType.SAVINGS;
                break;
            case 2:
                accountType = AccountType.PAYROLL;
                break;
            case 3:
                accountType = AccountType.DAY_TO_DAY;
                break;
        }

        return accountType;

    }

    /**
     * Receives the information of a new customer provided by the user.
     * @param input A Scanner object.
     * @return A Customer object with the information of the new customer.
     * @throws DateTimeParseException If the date of birth is provided in an invalid format.
     */
    private static Customer getNewCustomerInfo(Scanner input) throws DateTimeParseException{
        String firstname;
        String lastname;
        String address;
        String dateAsString;
        DateTimeFormatter dateFormatter= DateTimeFormatter.ofPattern("d/MM/yyyy");
        LocalDate dateOfBirth;
        String mobilePhoneNumber;


        while(true) {
            System.out.print("Enter your first name: ");
            firstname = input.nextLine().trim();

            if(firstname.isEmpty()) {
                System.out.println("You must enter a first name! Try again");
                continue;
            }

            if(Validation.isNameNotValid(firstname)) {
                System.out.println("The first name you provided is not valid! Try again.");
                continue;
            }
            break;
        }

        while(true) {
            System.out.print("\nEnter your last name: ");
            lastname = input.nextLine().trim();

            if(lastname.isEmpty()) {
                System.out.println("You must enter a last name! Try again");
                continue;
            }

            if(Validation.isNameNotValid(lastname)) {
                System.out.println("The last name you provided is not valid! Try again.");
                continue;
            }
            break;
        }

        while(true) {
            System.out.print("\nEnter your date of birth (dd/mm/yyyy): ");
            dateAsString = input.nextLine().trim();
            if(dateAsString.isEmpty()) {
                System.out.println("You must enter a date of birth! Try again.");
                continue;
            }

            try {
                dateOfBirth = LocalDate.parse(dateAsString, dateFormatter);
            } catch (DateTimeParseException exception) {
                System.out.println("The date of birth you inserted is not valid! Try again.");
                continue;
            }
            break;
        }

        while(true) {
            System.out.print("\nEnter your address: ");
            address = input.nextLine().trim();
            if(address.isEmpty()) {
                System.out.println("You  must enter an address! Try again.");
                continue;
            }
            break;
        }

        while(true) {
            System.out.print("\nEnter your mobile phone number (10 digits): ");
            mobilePhoneNumber = input.nextLine().trim();
            if(mobilePhoneNumber.isEmpty()) {
                System.out.println("You must enter a mobile phone number! Try again.");
                continue;
            }


            if(Validation.isMobilePhoneNumberNotValid(mobilePhoneNumber)) {
                System.out.println("The mobile phone number you inserted is not valid! Try again.");
                continue;
            }
            break;

        }

        return new Customer(firstname, lastname, dateOfBirth, address, mobilePhoneNumber);
    }

    /**
     * Receives the information of a new account provided by the user.
     * @param input  A Scanner object.
     * @return An ArrayList with the information of the new account.
     */
    private static ArrayList<Object> getNewAccountInfo(Scanner input) {
        ArrayList<Object> newAccountInfoList = new ArrayList<>();
        String userChoiceAsString;
        int userChoice;
        String accountHolderCountAsString;
        int accountHolderCount;
        ArrayList<Customer> customers = new ArrayList<>();
        AccountType accountType;

        while(true) {
            System.out.println("\nEnter the account type:\n1.Savings\n2.Payroll\n3.DayToDay");
            System.out.print(">> ");
            userChoiceAsString = input.nextLine().trim();


            if(Validation.isUserProvidedNumberNotValid(userChoiceAsString)) {
                System.out.println("Choose the correct account type! Try again");
                continue;
            }
            userChoice = Integer.parseInt(userChoiceAsString);


            if(Validation.isUserProvidedNumberOutOfRange(userChoice,MenuType.CREATE_ACCOUNT_MENU)) {
                System.out.println("There is no such account type! Please pick from 1 to 3.");
                continue;
            }

            accountType = choiceToAccountType(userChoice);

            System.out.println("\nEnter number of account holders: ");
            System.out.print(">> ");
            accountHolderCountAsString = input.nextLine().trim();
            if(Validation.isUserProvidedNumberNotValid(accountHolderCountAsString)) {
                System.out.println("You must enter a valid number! Try again.");
                continue;
            }
            accountHolderCount = Integer.parseInt(accountHolderCountAsString);

            if(Validation.isAccountHolderCountNotValid(accountHolderCount, accountType)) {
                System.out.println("This account type does not allow multiple account holders! Try again.");
                continue;
            }

            for (int i = 0; i < accountHolderCount; i++) {
                System.out.println("\nCustomer #" + (i + 1));
                System.out.println("=====================");
                customers.add(getNewCustomerInfo(input));
            }

            newAccountInfoList.add(accountType);
            newAccountInfoList.add(customers);
            break;
        }
        return newAccountInfoList;
    }

    /**
     * Displays the main menu to the user.
     */
    private static void displayMainMenu() {
        String consoleMenu = "\nWelcome to the Minimalist Bank! How may I help you?" +
                "\n1.Create account\n2.Deposit to account\n3.Withdraw from account\n4.Delete account\n5.Exit";
        System.out.println(consoleMenu);
    }

    /**
     * Receives the main menu choice of the user.
     * @param input A Scanner object.
     * @return The choice of type int.
     */
    private static int getMainMenuChoice(Scanner input) {
        int userChoice;
        String userChoiceAsString;

        while (true) {
            displayMainMenu();
            System.out.print(">> ");
            userChoiceAsString = input.nextLine().trim();

            if(Validation.isUserProvidedNumberNotValid(userChoiceAsString)) {
                System.out.println("You must enter a valid choice! Try again.");
                continue;
            }

            userChoice = Integer.parseInt(userChoiceAsString);

            if(Validation.isUserProvidedNumberOutOfRange(userChoice, MenuType.MAIN_MENU)) {
                System.out.println("There is no such financial operation! Please pick a number from 1 to 5.");
                continue;
            }

            break;
        }

        return userChoice;

    }

    /**
     * Performs an account creation.
     * @param input A Scanner object.
     * @param bank A Bank instance.
     */
    private static void performChoice1(Scanner input, Bank bank) {
        ArrayList<Object> newAccountInfo;
        AccountType accountType;
        ArrayList<Customer> accountHolders;
        String newAccountState;

        newAccountInfo = getNewAccountInfo(input);
        accountType = (AccountType) newAccountInfo.get(0);
        accountHolders = (ArrayList<Customer>) newAccountInfo.get(1);
        newAccountState = bank.createAccount(accountType, accountHolders);
        System.out.println(newAccountState);
    }

    /**
     * Performs a money deposit to a specified account.
     * @param input A Scanner object.
     * @param bank A Bank instance.
     */
    private static void performChoice2(Scanner input, Bank bank) {
        String accountNumber;
        String amountAsString;
        double amount;
        String accountState;

        while(true) {
            System.out.print("\nEnter account number (16 digits): ");
            accountNumber = input.nextLine().trim();

            if (Validation.isAccountNumberNotValid(accountNumber)) {
                System.out.println("You must enter a valid account number!");
                continue;
            }

            if(!bank.accountExists(accountNumber)) {
                System.out.println("Deposit operation failed, account not found.");
                break;
            }

            System.out.println("\nHow much would you like to deposit?");
            System.out.print(">> ");
            amountAsString = input.nextLine().trim();
            if (Validation.isUserProvidedNumberNotValid(amountAsString)) {
                System.out.println("You must enter a valid amount! Try again.");
                continue;
            }

            amount = Double.parseDouble(amountAsString);
            accountState = bank.deposit(amount,accountNumber);
            System.out.println(accountState);
            break;
        }
    }

    /**
     * Performs money withdrawal from a specified account.
     * @param input A Scanner object.
     * @param bank A Bank instance.
     */
    private static void performChoice3(Scanner input, Bank bank) {
        String accountNumber;
        String amountAsString;
        double amount;
        String accountState;

        while(true) {
            System.out.print("\nEnter account number (16 digits): ");
            accountNumber = input.nextLine().trim();

            if(Validation.isAccountNumberNotValid(accountNumber)) {
                System.out.println("You must enter a valid account number!");
                continue;
            }

            if(!bank.accountExists(accountNumber)) {
                System.out.println("Withdraw operation failed, account not found.");
                break;
            }

            System.out.println("\nHow much would you like to withdraw?");
            System.out.print(">> ");
            amountAsString = input.nextLine().trim();
            if(Validation.isUserProvidedNumberNotValid(amountAsString)){
                System.out.println("You must enter a valid amount! Try again.");
                continue;
            }
            amount = Double.parseDouble(amountAsString);
            if(bank.isOverBalance(accountNumber, amount) && !bank.isOverdraftAllowed(accountNumber)) {
                System.out.println("Overdraft is not allowed! Try again.");
                continue;
            }
            accountState = bank.withdraw(amount, accountNumber);
            System.out.println(accountState);
            break;
        }
    }

    /**
     * Performs an account deletion.
     * @param input A Scanner object.
     * @param bank A Bank instance.
     */
    private static void performChoice4(Scanner input, Bank bank) {
        String accountNumber;

        while(true) {
            System.out.print("\nEnter account number (16 digits): ");
            accountNumber = input.nextLine().trim();

            if(Validation.isAccountNumberNotValid(accountNumber)) {
                System.out.println("You must enter a valid account number!");
                continue;
            }

            if(!bank.accountExists(accountNumber)){
                System.out.println("Delete operation failed, account not found.");
                break;
            }

            bank.deleteAccount(accountNumber);
            System.out.println("\nYour account has been deleted!");
            break;
        }


    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Bank bank = new Bank();
        int userChoice;

        userChoice = getMainMenuChoice(input);

        while(userChoice != 5) {
            switch (userChoice) {
                case 1:
                    performChoice1(input, bank);
                    break;
                case 2:
                    performChoice2(input, bank);
                    break;
                case 3:
                    performChoice3(input, bank);
                    break;
                case 4:
                    performChoice4(input, bank);
                    break;
            }

            userChoice = getMainMenuChoice(input);
        }

        System.out.println("\nThank you for using our app!");
    }
}