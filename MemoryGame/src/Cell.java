class Cell {
    private char character;
    private boolean revealed;

    public Cell(char character) {
        this.character = character;
        this.revealed = false;
    }

    public char getCharacter() {
        return character;
    }

    public boolean isRevealed() {
        return revealed;
    }

    public void reveal() {
        this.revealed = true;
    }

    public void hide() {
        this.revealed = false;
    }

    @Override
    public String toString() {
        return revealed ? String.valueOf(character) : "*";
    }
}
