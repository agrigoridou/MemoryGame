import java.util.Scanner;

class MemoryGame {
    private Board board;
    private int attempts;
    private int failedAttempts;
    private final int maxFailures = 4;

    public MemoryGame() {
        board = new Board();
        attempts = 0;
        failedAttempts = 0;
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);

        while (!board.allRevealed() && failedAttempts < maxFailures) {
            board.display();
            int row1 = -1, col1 = -1, row2 = -1, col2 = -1;

            // Εισαγωγή πρώτης θέσης
            while (true) {
                System.out.print("Δώσε την πρώτη θέση (γραμμή και στήλη): ");
                String input = scanner.nextLine().trim();
                String[] parts = input.split("\\s+");
                if (parts.length == 2) {
                    try {
                        row1 = Integer.parseInt(parts[0]);
                        col1 = Integer.parseInt(parts[1]);
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Λανθασμένη είσοδος. Παρακαλώ εισάγετε ακέραιους αριθμούς.");
                    }
                } else {
                    System.out.println("Λανθασμένη είσοδος. Παρακαλώ εισάγετε δύο ακέραιους αριθμούς.");
                }
            }

            // Εισαγωγή δεύτερης θέσης
            while (true) {
                System.out.print("Δώσε τη δεύτερη θέση (γραμμή και στήλη): ");
                String input = scanner.nextLine().trim();
                String[] parts = input.split("\\s+");
                if (parts.length == 2) {
                    try {
                        row2 = Integer.parseInt(parts[0]);
                        col2 = Integer.parseInt(parts[1]);
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Λανθασμένη είσοδος. Παρακαλώ εισάγετε ακέραιους αριθμούς.");
                    }
                } else {
                    System.out.println("Λανθασμένη είσοδος. Παρακαλώ εισάγετε δύο ακέραιους αριθμούς.");
                }
            }

            if (isValidMove(row1, col1, row2, col2)) {
                Cell firstCell = board.getCell(row1, col1);
                Cell secondCell = board.getCell(row2, col2);

                firstCell.reveal();
                secondCell.reveal();
                board.display();
                attempts++;

                if (firstCell.getCharacter() != secondCell.getCharacter()) {
                    System.out.println("Αποτυχημένη προσπάθεια.");
                    firstCell.hide();
                    secondCell.hide();
                    failedAttempts++;
                } else {
                    System.out.println("Επιτυχία! Βρέθηκε το ζεύγος.");
                }
            } else {
                System.out.println("Μη έγκυρη κίνηση. Προσπάθησε ξανά.");
            }
        }

        // Τελικό μήνυμα νίκης ή ήττας
        board.display();
        if (board.allRevealed()) {
            System.out.println("Συγχαρητήρια! Αποκάλυψες όλες τις θέσεις και κέρδισες το παιχνίδι!");
        } else if (failedAttempts == maxFailures) {
            System.out.println("Έκανες 4 αποτυχημένες προσπάθειες. Έχασες το παιχνίδι.");
        }

        System.out.println("Σύνολο γύρων: " + attempts);
        scanner.close();
    }

    private boolean isValidMove(int row1, int col1, int row2, int col2) {
        return row1 >= 0 && row1 < 4 && col1 >= 0 && col1 < 5 &&
                row2 >= 0 && row2 < 4 && col2 >= 0 && col2 < 5 &&
                !(row1 == row2 && col1 == col2);
    }
}
