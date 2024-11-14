# MemoryGame

Is a simple memory game implemented in Java, where the player matches pairs of characters hidden in a grid. The game board consists of a 4x5 grid (4 rows and 5 columns), with each cell containing a hidden character. The characters on the board are uppercase letters of the Latin alphabet (A–Z), placed randomly. There are 10 pairs of unique characters on the board.

## Game Rules

1. **Initial Setup**: The board is displayed with all cells hidden (shown as `*`).
2. **Turn Flow**:
   - The player guesses two positions by entering the coordinates (row and column) for each.
   - The characters at the chosen positions are revealed:
     - If the characters match, they remain visible.
     - If they don't match, the positions are hidden again.
3. **Game End Conditions**:
   - **Win**: The player matches all pairs on the board.
   - **Loss**: The player makes four unsuccessful pairing attempts.
4. **Game Conclusion**: At the end of the game, the final board with all characters revealed is displayed along with the total number of rounds played.

## Code Architecture

The project is organized into the following classes:

- **Main**: The main class that starts the game.
- **MemoryGame**: Manages the game flow, rounds, attempts, and final result.
- **Board**: Responsible for creating and managing the board, placing the characters, displaying the board, and handling coordinate input.
- **Cell**: A helper class representing each cell on the board, storing each cell's state (hidden or revealed).


## Example Gameplay

### Scenario 1: Winning the Game

In this scenario, the player successfully matches all character pairs within the allowed attempts.




### Scenario 1: Losing the Game


In this scenario, the player reaches four unsuccessful attempts without matching all pairs.
<div align="center">
    <img src="https://github.com/user-attachments/assets/b41be146-3cd3-4eec-9f6d-be267c484e4f" alt="Example GIF" >
</div>
![image](https://github.com/user-attachments/assets/b41be146-3cd3-4eec-9f6d-be267c484e4f)
