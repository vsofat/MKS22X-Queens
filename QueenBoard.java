public class QueenBoard {

  private int count;
  private int size;
  private int[][] board;

  //main for testing
  public static void main(String[] args) {
    QueenBoard  board = new QueenBoard(0); // testing with size 0
    System.out.println(board.countSolutions());
    QueenBoard  board1 = new QueenBoard(1); // testing with size 1
    System.out.println(board1.countSolutions());
    QueenBoard  board2 = new QueenBoard(2); // testing with size 2
    System.out.println(board.countSolutions());
    QueenBoard  board3 = new QueenBoard(3); // testing with size 3
    System.out.println(board3.countSolutions());
    QueenBoard  board4 = new QueenBoard(4); // testing with size 4
    System.out.println(board4.countSolutions());
    QueenBoard  board5 = new QueenBoard(5); // testing with size 5
    System.out.println(board5.countSolutions());
    QueenBoard  board6 = new QueenBoard(6); // testing with size 6
    System.out.println(board6.countSolutions());
    QueenBoard  board7 = new QueenBoard(7); // testing with size 7
    System.out.println(board7.countSolutions());
    QueenBoard  board8 = new QueenBoard(8); // testing with size 8
    System.out.println(board8.countSolutions());
    QueenBoard  board9 = new QueenBoard(9); // testing with size 9
    System.out.println(board9.countSolutions());
    QueenBoard  board10 = new QueenBoard(10); // testing with size 10
    System.out.println(board10.countSolutions());
    QueenBoard  board11 = new QueenBoard(11); // testing with size 11
    System.out.println(board11.countSolutions());
    QueenBoard  board12 = new QueenBoard(12); // testing with size 12
    System.out.println(board12.countSolutions());
    QueenBoard  board13 = new QueenBoard(13); // testing with size 13
    System.out.println(board13.countSolutions());
    QueenBoard  board14 = new QueenBoard(14); // testing with size 14
    System.out.println(board14.countSolutions());
    QueenBoard  board15 = new QueenBoard(15); // testing with size 15
    System.out.println(board.countSolutions());
  }

  // constructor
  public QueenBoard(int size) {
    this.size = size;
    board = new int[size][size];
    for (int[] row: board) { // each row
      for (int col: row) { // each column in row
        col = 0; // set everything to 0
      }
    }
  }

  /**
  *@return The output string formatted as follows:
  *All numbers that represent queens are replaced with 'Q'
  *all others are displayed as underscores '_'
  *There are spaces between each symbol:
  *"""_ _ Q _
  *Q _ _ _
  *_ _ _ Q
  *_ Q _ _"""
  *(pythonic string notation for clarity,
  *excludes the character up to the *)
  */

  public String toString() {
    String result = "";
    for (int[] row : board) { //each row
      for (int col : row) {
        if (col == -1) { // value for queen
          result += " Q ";} // Q is symbol for queen
          else result += " 0 "; // if not a queen put a underscore to start with
        }
        result = result.substring(0, result.length() - 1);
        result += "\n"; // new line
      }
      return result;
    }

    /**
    *@return false when the board is not solveable and leaves the board filled with zeros;
    *        true when the board is solveable, and leaves the board in a solved state
    *@throws IllegalStateException when the board starts with any non-zero value
    */

    public boolean solve() {
      return helperSolve(0); // has to start at 0
    }

    /*
    HOW TO WRITE HELPER FOR SOLVE

    boolean solveR(int col)
    if col is past end of board:
    return true
    for each row:
    if addQueen:
    if solveR(col+1):
    return true
    removeQueen
    return false */

    private boolean helperSolve(int col) {
      if (col >= board.length){
        return true;
      }
      for (int row = 0; row < board.length; row ++) {
        if (addQueen(row, col)) { //needs to be defined
          if (helperSolve(col + 1)){
            return true;
          }
          removeQueen(row, col);
        }
      }
      return false;
    }

    public int countSolutions() {
      if (board.length == 0){
        return 0;
      }
      if (board[0][0] != 0){
        throw new IllegalStateException("Negative Value");
      }
      oneSolution(0);
      return count;
    }

    private void oneSolution(int row) {
      if (row >= board.length){
        count ++;}
        else{
          if (row < 0 ){
            throw new IllegalStateException("Negative Value");
          }
          for (int col = 0; col < board.length; col ++){
            if (addQueen(row,col)){
              oneSolution(row + 1);
              removeQueen(row, col);
            }
          }
        }
      }

      private boolean addQueen(int r, int c) {
     if (board[r][c] != 0 || r >= board.length || c >= board.length) return false;
     //Horizontal
     for (int x = 0; x < board[r].length; x ++) {
       board[r][x] = board[r][x] + 1;
     }
     //Diagonal up-right
     int x  = c + 1;
     int y = r - 1;
     while (x < board.length && y >= 0) {
       board[y][x]  = board[y][x] + 1;
       x ++;
       y --;
     }
     //Diagonal down-right
     x  = c + 1;
     y = r + 1;
     while (x < board.length && y < board.length) {
       board[y][x] = board[y][x] + 1;
       x ++;
       y ++;
     }
     //Diagonal up-left
     x  = c - 1;
     y = r - 1;
     while (x >= 0 && y >= 0) {
       board[y][x] = board[y][x] + 1;
       x --;
       y --;
     }
     //Diagonal down-left
     x  = c - 1;
     y = r + 1;
     while (x >= 0 && y < board.length) {
       board[y][x] = board[y][x] + 1;
       x --;
       y ++;
     }
     //Vertical
     for (int idx = 0; idx < board.length; idx ++) {
       board[idx][c] = board[idx][c] + 1;
     }
     board[r][c] = -1;
     return true;
   }

   private boolean removeQueen(int r, int c) {
     if (board[r][c] != -1) return false;
     //Horizontal
     for (int x = 0; x < board[r].length; x ++) {
       board[r][x] = board[r][x] - 1;
     }
     //Diagonal up-right
     int x  = c + 1;
     int y = r - 1;
     while (x < board.length && y >= 0) {
       board[y][x]  = board[y][x] - 1;
       x ++;
       y --;
     }
     //Diagonal down-right
     x  = c + 1;
     y = r + 1;
     while (x < board.length && y < board.length) {
       board[y][x] = board[y][x] - 1;
       x ++;
       y ++;
     }
     //Diagonal up-left
     x  = c - 1;
     y = r - 1;
     while (x >= 0 && y >= 0) {
       board[y][x] = board[y][x] - 1;
       x --;
       y --;
     }
     //Diagonal down-left
     x  = c - 1;
     y = r + 1;
     while (x >= 0 && y < board.length) {
       board[y][x] = board[y][x] - 1;
       x --;
       y ++;
     }
     //Vertical
     for (int idx = 0; idx < board.length; idx ++) {
       board[idx][c] = board[idx][c] - 1;
     }
     board[r][c] = 0;
     return true;
   }

    }
