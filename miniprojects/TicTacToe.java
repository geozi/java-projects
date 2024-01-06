package miniprojects;

import java.util.HashMap;
import java.util.Scanner;

public class TicTacToe {

    final static int THREE_X_SUM = 264;
    final static int THREE_O_SUM= 237;

    /**
     * Creates the map of the game.
     * @return A game map of type HashMap.
     */
    static HashMap<Integer, Character> createGameMap() {
        HashMap<Integer, Character> gameMap = new HashMap<>();

        gameMap.put(1, '-');
        gameMap.put(2, '-');
        gameMap.put(3, '-');
        gameMap.put(4, '-');
        gameMap.put(5, '-');
        gameMap.put(6, '-');
        gameMap.put(7, '-');
        gameMap.put(8, '-');
        gameMap.put(9, '-');

        return gameMap;
    }

    /**
     * Checks if the game is solved after each input.
     * @param gameMap A game map of type HashMap.
     * @return True if the game is solved, false otherwise.
     */
    static boolean isGameSolved(HashMap<Integer, Character> gameMap) {
        boolean compResult = false;
        if (gameMap.get(1) + gameMap.get(2) + gameMap.get(3) == THREE_X_SUM
                || gameMap.get(1) + gameMap.get(2) + gameMap.get(3) == THREE_O_SUM) {
            compResult = true;
        } else if (gameMap.get(4) + gameMap.get(5) + gameMap.get(6) == THREE_X_SUM
                || gameMap.get(4) + gameMap.get(5) + gameMap.get(6) == THREE_O_SUM) {
            compResult = true;
        } else if (gameMap.get(7) + gameMap.get(8) + gameMap.get(9) == THREE_X_SUM
                || gameMap.get(7) + gameMap.get(8) + gameMap.get(9) == THREE_O_SUM) {
            compResult = true;
        } else if (gameMap.get(1) + gameMap.get(4) + gameMap.get(7) == THREE_X_SUM
                || gameMap.get(1) + gameMap.get(4) + gameMap.get(7) == THREE_O_SUM) {
            compResult = true;
        } else if (gameMap.get(2) + gameMap.get(5) + gameMap.get(8) == THREE_X_SUM
                || gameMap.get(2) + gameMap.get(5) + gameMap.get(8) == THREE_O_SUM) {
            compResult = true;
        } else if (gameMap.get(3) + gameMap.get(6) + gameMap.get(9) == THREE_X_SUM
                || gameMap.get(3) + gameMap.get(6) + gameMap.get(9) == THREE_O_SUM) {
            compResult = true;
        } else if (gameMap.get(1) + gameMap.get(5) + gameMap.get(9) == THREE_X_SUM
                || gameMap.get(1) + gameMap.get(5) + gameMap.get(9) == THREE_O_SUM) {
            compResult = true;
        } else if (gameMap.get(3) + gameMap.get(5) + gameMap.get(7) == THREE_X_SUM
                || gameMap.get(3) + gameMap.get(5) + gameMap.get(7) == THREE_O_SUM) {
            compResult = true;
        }

        return compResult;
    }

    /**
     * Checks if the inserted letter is a valid letter.
     * @param str An input of type String.
     * @return True if the inserted letter is a valid letter, false otherwise.
     */
    static boolean isValidLetter(String str) {
        boolean compResult;
        char ch;

        if(str.isEmpty()) {
            compResult = false;
        } else {
            ch = str.trim().charAt(0);
            compResult = (ch == 'X'|| ch == 'x') || (ch == 'O' || ch == 'o');
        }

        return compResult;
    }

    /**
     * Checks if the inserted letter is the same as the one
     * inserted in the previous round.
     * @param ch The inserted letter of type String.
     * @param prevLetter The ASCII code of the previously inserted letter
     * @return True if the inserted letter is valid, false otherwise.
     */
    static boolean isSameAsPrevLetter(char ch, int prevLetter) {
        return ch == (char) prevLetter;
    }

    /**
     * Checks if the inserted position is a valid number.
     * @param str The inserted position of type String.
     * @return True if the inserted position is valid, false otherwise.
     */
    static boolean isValidPos(String str) {
        boolean compResult = true;
        int pos;

        if(str.isEmpty()) {
            compResult = false;
        } else {
            for (int i = 0; i < str.length(); i++) {
                if(!Character.isDigit(str.charAt(i))) {
                    compResult = false;
                    break;
                }
            }

            if(compResult) {
                pos = Integer.parseInt(str);
                compResult = pos > 0 && pos < 10;
            }
        }

        return compResult;
    }

    /**
     * Checks if the inserted position is already used.
     * @param pos The position of type int.
     * @param gameMap The game map of type HashMap.
     * @return True if the position can be used, false otherwise.
     */
    static boolean isPosFree(int pos, HashMap<Integer, Character> gameMap) {
        return gameMap.get(pos) == '-';
    }

    /**
     * Gets the inputs from the user.
     * @param gameMap The game map of type HashMap.
     * @param userInputs The inputs of the user from the previous round as an int array.
     */
    static void getInput(HashMap<Integer, Character> gameMap, int[] userInputs) {
        Scanner input = new Scanner(System.in);
        String inCharAsString;
        String inPosAsString;
        char inChar;
        int inPos;

        while(true) {
            System.out.print("\nEnter X or O: ");
            inCharAsString =input.nextLine().trim();

            if(!isValidLetter(inCharAsString)) {
                System.out.println("Invalid choice! Try again.");
                continue;
            }

            inChar = Character.toUpperCase(inCharAsString.charAt(0));

            if(isSameAsPrevLetter(inChar, userInputs[0])) {
                System.out.println("The letter was used in the previous round! Try again.");
                continue;
            }

            userInputs[0] = inChar;
            break;
        }

        while(true) {
            System.out.println("\nCurrent state of (m x n) array: ");
            displayGameMap(gameMap);
            System.out.println("\nPositions: ");
            System.out.println(1 + " " + 2 + " " + 3 +
                    "\n" + 4 + " " + 5 + " " + 6 +
                    "\n" + 7 + " " + 8 + " " + 9);
            System.out.print("Enter position (1 to 9): ");
            inPosAsString = input.nextLine();

            if(!isValidPos(inPosAsString)){
                System.out.println("Invalid position! Try again.");
                continue;
            }

            inPos = Integer.parseInt(inPosAsString);

            if(!isPosFree(inPos, gameMap)){
                System.out.println("Position is already used! Try again.");
                continue;
            }

            userInputs[1] = inPos;
            break;
        }
    }

    /**
     * Updates the game map.
     * @param chAsInt The ASCII code of the inserted letter.
     * @param pos The inserted position of type int.
     * @param gameMap The game map of type HashMap.
     */
    static void updateGameMap(int chAsInt, int pos, HashMap<Integer, Character> gameMap) {
        char ch = (char) chAsInt;
        gameMap.put(pos, ch);
    }

    /**
     * Displays the game map.
     * @param gameMap The game map of type HashMap.
     */
    static void displayGameMap(HashMap<Integer, Character> gameMap) {
        System.out.println(
                gameMap.get(1) + " " + gameMap.get(2) + " " + gameMap.get(3));
        System.out.println(
                gameMap.get(4) + " " + gameMap.get(5) + " " + gameMap.get(6));
        System.out.println(
                gameMap.get(7) + " " + gameMap.get(8) + " " + gameMap.get(9));
    }

    public static void main(String[] args) {
        HashMap<Integer, Character> ticTacToeMap = createGameMap();
        int[] userInputs = new int[2];
        int round = 1;

        while(ticTacToeMap.containsValue('-')) {
            System.out.println("\nRound #" + round);
            System.out.println("===========================");

            getInput(ticTacToeMap, userInputs);
            updateGameMap(userInputs[0], userInputs[1], ticTacToeMap);

            if(isGameSolved(ticTacToeMap)) {
                System.out.println();
                System.out.println("===========================");
                displayGameMap(ticTacToeMap);
                System.out.println("\nThe game is solved!");
                System.exit(0);
            }
            round++;
        }

        System.out.println();
        System.out.println("===========================");
        displayGameMap(ticTacToeMap);
        System.out.println("\nIt is a tie!");
    }
}
