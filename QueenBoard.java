public class QueenBoard {

  private int count;
  private int size;
  private int[][] board;

  //main for testing
  public static void main(String[] args) {
    QueenBoard  board = new QueenBoard(8); // testing with size 8
    System.out.println(board.countSolutions());

    QueenBoard  board2 = new QueenBoard(5); // testing with size 5
    System.out.println(board2.countSolutions());
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
        //  result += "\n"; // new line
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

      public boolean addQueen(int row, int col){
       if (board[row][col] > 0 || board[row][col] == -1){
         return false;
       }
       for (int y = 0; y < board.length; y++){
         board[y][col] += 1;//adds to entire row in front of it
       }
       int a = 0;
       for (int x = col; x < board.length; x++){//add 1 to each endangered spot in front of it
         board[row][x] = board[row][x] + 1;

         if (row - a >= 0){
           board[row-a][x] += 1;
         }
         if (row + a < board.length){
           board[row + a][x] += 1;
         }
         a += 1;
       }
       board[row][col] = -1;
       return true;
     }

     private boolean removeQueen(int row, int col) {
         if (board[row][col] != -1){ // value for Queen
           return false;
         }

         for (int x = 0; x < board[row].length; x ++) {
           board[row][x] = board[row][x] - 1;
         }

         int a = col + 1;
         int b = row - 1;
         while (a < board.length && b >= 0) {
           board[b][a]  = board[b][a] - 1;
           a ++;
           b --;
         }

         a = col + 1;
         b = row + 1;
         while (a < board.length && b < board.length) {
           board[b][a] = board[b][a] - 1;
           a ++;
           b ++;
         }

         a = col + 1;
         b = row + 1;
         while (a >= 0 && b >= 0) {
           board[b][a] = board[b][a] - 1;
           a --;
           b --;
         }

         a = col + 1;
         b = row + 1;
         while (a >= 0 && b < board.length) {
           board[b][a] = board[b][a] - 1;
           a --;
           b ++;
         }

         for (int index = 0; index < board.length; index ++) {
           board[index][col] = board[index][col] - 1;
         }
         board[row][col] = 0;
         return true;
       }

    }
