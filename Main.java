import java.util.Scanner;

class Main {

    public static String[] spaces = { "0", "1", "2", "3", "4", "5", "6", "7", "8" };

    // Main.
    public static void main(String[] args) {

        // Start game.
        startGame();
    }

    // Starts game.
    public static void startGame() {

        // Create scanner.
        Scanner scanner = new Scanner(System.in);

        // Game loop.
        while (true) {

            // Check for win.
            printBoard();
            if (endGame()) {
                System.out.println("Player2 wins!");
                break;
            }

            // Player1's turn.
            while (true) {
                System.out.print("Player1 >>> ");
                int response = Integer.parseInt(scanner.next());
                if (goodResponse(response)) {

                    // Place X.
                    spaces[response] = "X";

                    break;
                }
            }

            // Check for win.
            printBoard();
            if (endGame()) {
                System.out.println("Player1 wins!");
                break;
            }

            // Player2's turn.
            while (true) {
                System.out.print("Player2 >>> ");
                int response = Integer.parseInt(scanner.next());
                if (goodResponse(response)) {

                    // Place O.
                    spaces[response] = "O";

                    break;
                }
            }
        }

        // Close scanner.
        scanner.close();
    }

    // Prints board.
    public static void printBoard() {

        System.out.println("~===========~");
        System.out.println("{ " + spaces[0] + " | " + spaces[1] + " | " + spaces[2] + " }");
        System.out.println("|===+===+===|");
        System.out.println("{ " + spaces[3] + " | " + spaces[4] + " | " + spaces[5] + " }");
        System.out.println("|===+===+===|");
        System.out.println("{ " + spaces[6] + " | " + spaces[7] + " | " + spaces[8] + " }");
        System.out.println("*===========*");
    }

    // Check if response is valid.
    public static boolean goodResponse(int response) {

        // Check if space is taken.
        if (spaces[response] == "X" || spaces[response] == "O") {
            return false;
        }

        // If response is not from 1 to 9 or o than return false.
        for (int i = 0; i < 10; i++) {
            if (response == i) {
                return true;
            }
        }

        return false;
    }

    public static boolean endGame() {

        for (int i = 0; i < 2; i++) {

            String z = "X";

            if (i == 1) {
                z = "O";
            }

            if (spaces[0] == z && spaces[1] == z && spaces[2] == z ||

                    spaces[3] == z && spaces[4] == z && spaces[5] == z ||

                    spaces[6] == z && spaces[7] == z && spaces[8] == z ||

                    ///////////////////

                    spaces[0] == z && spaces[3] == z && spaces[6] == z ||

                    spaces[1] == z && spaces[4] == z && spaces[7] == z ||

                    spaces[2] == z && spaces[5] == z && spaces[8] == z) {
                return true;
            }
        }

        return false;
    }
}