public class QueenBoard {

  private int sum;
  private int[][] board;

  //main for testing
  public static void main(String[] args) {
    QueenBoard  board = new QueenBoard(8);
    System.out.println(board.toString());

    QueenBoard  board2 = new QueenBoard(5);
    System.out.println(board2.toString());
  }

  // constructor
  public QueenBoard(int size) {
    board = new int[size][size];
    for (int[] row: board) { // each row
      for (int col: row) { // each column in row
        col = 0; // set everything to 0
      }
    }
  }


  public String toString() {
    String result = "";
    for (int[] row : board) { //each row
      for (int col : row) {
        if (col == -1) { // value for queen
          result += "Q ";} // Q is symbol for queen
    else result += " 0 "; // if not a queen put a underscore to start with
  }
  result = result.substring(0, result.length() - 1);
  result += "\n";
}
return result;
  }

/*
  public boolean solve() {
  }

  public int countSolutions() {
  }

  private boolean addQueen(int r, int c) {
  }

  private boolean removeQueen(int r, int c) {
  }

  */

}
