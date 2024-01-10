public class TicTacToe {

    // Constants to represent players and empty cells
    public static final int X = 1;
    public static final int O = -1;
    public static final int EMPTY = 0;

    // The current player
    private int currentPlayer;

    // The game board
    private int[][] board;

    public TicTacToe() {
        board = new int[3][3];
        currentPlayer = X; // Start with player X
    }
    private final static int[][][] winnerIndices = {
            {{0,0}, {0,1}, {0,2}},
            {{1,0}, {1,1}, {1,2}},
            {{2,0}, {2,1}, {2,2}},
            {{0,0}, {1,0}, {2,0}},
            {{0,1}, {1,1}, {2,1}},
            {{0,2}, {1,2}, {2,2}},
            {{0,0}, {1,1}, {2,2}},
            {{0,2}, {1,1}, {2,0}},
    };

    public void putMarks(int posx, int posy) {
        if (board[posx][posy] != EMPTY) {
            throw new IllegalArgumentException("Cell is already occupied");
        }

        board[posx][posy] = currentPlayer;
        currentPlayer = -currentPlayer; // Switch players
    }

    public boolean isEmpty(int posx, int posy) {
        return board[posx][posy] == EMPTY;
    }

    public void clearBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = EMPTY;
            }
        }
        currentPlayer = X; // Reset to player X
    }

    public boolean isAvailable() {
        // Implement this method to check if there are any available moves
        // You can iterate through the board and check if there are any empty cells
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == EMPTY) {
                    return true; // There's an available move
                }
            }
        }
        return false; // No available moves
    }

    public boolean isWinner(int player) {
        // Implement this method to check if the player has won the game
        // You can use the winnerIndices array to check for winning combinations
        for (int[][] winningCombo : winnerIndices) {
            int count = 0;
            for (int[] cell : winningCombo) {
                if (board[cell[0]][cell[1]] == player) {
                    count++;
                }
            }
            if (count == 3) {
                return true; // Player has won
            }
        }
        return false; // Player has not won
    }

    public void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == X) {
                    System.out.print("X ");
                } else if (board[i][j] == O) {
                    System.out.print("O ");
                } else {
                    System.out.print("_"); // Print empty space for EMPTY cells
                }
            }
            System.out.println();
        }
    }
}