package Arrays;

public class ScoreBoard {
  private int numOfEntries = 0;
  private GameEntry[] board;

  public ScoreBoard(int capacity) {
    board = new GameEntry[capacity];
  }

  public GameEntry[] sortBoardDescending(GameEntry[] brd) {
    for (int i = 1; i < brd.length; i++) {
      GameEntry key = brd[i];
      int j = i - 1;

      if (key == null)
        continue;

      while (j >= 0 && brd[j] != null && brd[j].getScore() < key.getScore()) {
        brd[j + 1] = brd[j];
        j--;
      }

      brd[j + 1] = key;
    }

    return brd;
  }

  public void addEntry(GameEntry e) {
    int newScore = e.getScore();

    if (numOfEntries < board.length || newScore > board[board.length - 1].getScore()) {

      if (numOfEntries < board.length) {
        board[numOfEntries] = e;
        numOfEntries++;
      } else if (newScore > board[board.length - 1].getScore()) {
        board[board.length - 1] = e;
        numOfEntries++;
      }

      board = sortBoardDescending(board);

    }
  }

  public GameEntry remove(int i) throws IndexOutOfBoundsException {
    if (i < 0 || i >= board.length)
      throw new IndexOutOfBoundsException();

    GameEntry e = board[i];

    for (int j = i; j < numOfEntries - 1; j++) {
      board[j] = board[j + 1];
    }
    board[numOfEntries - 1] = null;
    numOfEntries--;
    return e;
  }

  public class Main {
    public static void main(String[] args) {
      ScoreBoard board = new ScoreBoard(5);
      board.addEntry(new GameEntry("Alice", 80));
      board.addEntry(new GameEntry("Bob", 100));
      board.addEntry(new GameEntry("Charlie", 90));
      board.addEntry(new GameEntry("Dave", 70));
      board.addEntry(new GameEntry("Eve", 95));
      board.addEntry(new GameEntry("Frank", 60)); // Should not be added

      for (GameEntry entry : board.getBoard()) {
        if (entry != null) {
          System.out.println(entry.getName() + ": " + entry.getScore());
        }
      }
    }
  }

  public GameEntry[] getBoard() {
    // TODO Auto-generated method stub
    return board;
  }

}
