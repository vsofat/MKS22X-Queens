public class QueenBoard {

  private int sum;
  private int[][] board;

  //main for testing
  public static void main(String[] args) {
  }

  // constructors
  public QueenBoard(int size) {
    board = new int[size][size];
    for (int[] x: board) {
      for (int y: x) {
        y = 0;
      }
    }
  }

  public String toString() {
  }

  public boolean solve() {
  }

  public int countSolutions() {
  }

  private boolean addQueen(int r, int c) {
  }

  private boolean removeQueen(int r, int c) {
  }

}
