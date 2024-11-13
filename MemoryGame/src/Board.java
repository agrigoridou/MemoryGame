import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

class Board {
    private Cell[][] grid;
    private final int rows = 4;
    private final int cols = 5;

    public Board() {
        grid = new Cell[rows][cols];
        fillBoard();
    }

    private void fillBoard() {
        ArrayList<Character> characters = new ArrayList<>();
        Random random = new Random();

        // Δημιουργία 10 ζευγών τυχαίων χαρακτήρων από το αλφάβητο
        for (int i = 0; i < 10; i++) {
            char randomChar = (char) ('A' + random.nextInt(26));
            characters.add(randomChar);
            characters.add(randomChar);
        }

        // Ανακατεύει τη λίστα χαρακτήρων
        Collections.shuffle(characters);

        // Γεμίζει τον πίνακα με τους χαρακτήρες
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = new Cell(characters.get(index++));
            }
        }
    }

    public void display() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public Cell getCell(int row, int col) {
        return grid[row][col];
    }

    public boolean allRevealed() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!grid[i][j].isRevealed()) {
                    return false;
                }
            }
        }
        return true;
    }
}
