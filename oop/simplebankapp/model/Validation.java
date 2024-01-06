package oop.simplebankapp.model;

/**
 * The {@link Validation} class contains static methods that
 * perform validation controls on user inputs.
 *
 * @author geozi
 */
public class Validation {

    /**
     * Checks if the user input is a valid number.
     * @param userChoiceAsString The user input of type String.
     * @return True if the user input is not a valid number, false otherwise.
     */
    static boolean isUserProvidedNumberNotValid(String userChoiceAsString) {
        boolean evalResult = false;
        if (userChoiceAsString.isEmpty()) {
            evalResult = true;
        } else {
            for (int i = 0; i < userChoiceAsString.length(); i++) {
                if (!Character.isDigit(userChoiceAsString.charAt(i))) {
                    evalResult = true;
                    break;
                }
            }
        }
        return evalResult;
    }

    /**
     * Checks if the user input is out of range based on the
     * menu being currently displayed to the user.
     * @param userChoice The user input of type String.
     * @param menu The menu type as a MenuType.
     * @return True if the number is out of range, false otherwise.
     */
    static boolean isUserProvidedNumberOutOfRange(int userChoice, MenuType menu) {
        boolean evalResult = false;
        if (menu == MenuType.MAIN_MENU) {
            evalResult = userChoice < 1 || userChoice > 5;
        } else if (menu == MenuType.CREATE_ACCOUNT_MENU) {
            evalResult = userChoice < 1 || userChoice > 3;
        }
        return evalResult;
    }

    /**
     * Checks if the name provided by the user is valid.
     * @param name The name of type String.
     * @return True if the name is not valid, false otherwise.
     */
    static boolean isNameNotValid(String name) {
        boolean evalResult = false;
        char ch;

        for (int i = 0; i < name.length(); i++) {
            ch = name.charAt(i);
            if (!Character.isLetter(ch)) {
                evalResult = true;
                break;
            }
        }
        return evalResult;
    }

    /**
     * Checks if an account number is valid.
     * @param accountNumber The account number of type String.
     * @return True if the account number is not valid, false otherwise.
     */
    static boolean isAccountNumberNotValid(String accountNumber) {
        boolean evalResult;

        if (accountNumber.length() != 16) {
            evalResult = true;
        } else {
            evalResult = isUserProvidedNumberNotValid(accountNumber);
        }
        return evalResult;
    }

    /**
     * Checks if a mobile phone number is valid.
     * @param mobilePhoneNumber The mobile phone number of type String.
     * @return True if the mobile phone number is not valid, false otherwise.
     */
    static boolean isMobilePhoneNumberNotValid(String mobilePhoneNumber) {
        boolean evalResult;

        if (mobilePhoneNumber.length() != 10) {
            evalResult = true;
        } else {
            evalResult = isUserProvidedNumberNotValid(mobilePhoneNumber);
        }
        return evalResult;
    }

    /**
     * Checks if the number of account holders is valid.
     * @param num The number of account holders of type int.
     * @param accountType The account type as an AccountType.
     * @return True if the number is not valid, false otherwise.
     */
    static boolean isAccountHolderCountNotValid(int num, AccountType accountType) {
        return num < 1 || (num > 1 && accountType == AccountType.DAY_TO_DAY);
    }
}
