public class QueenBoard {

  private int count;
  private int size;
  private int[][] board;

  //main for testing
  public static void main(String[] args) {
    QueenBoard  board8 = new QueenBoard(4); // testing with size 8
    System.out.println(board8.countSolutions());
    // DRIVER 2 (THANKS TO VICTORIA!)
    /*QueenBoard a = new QueenBoard(4) ;
    if (a.solve()) System.out.println("The board (a) is solvable! Good!") ;
    else {
      System.out.println("Work on solve method! It's not working correctly right now...") ;
    }
    QueenBoard b = new QueenBoard(2) ;
    if (b.solve()) System.out.println("The board (b) is solvable! WHAT HAPPPENEDDDDDDDDDDDDDDDD!") ;
    else {
      System.out.println("Good job! (b) was not solvable!") ;
    }
    QueenBoard c = new QueenBoard(2) ;
    System.out.println("Let's create a QueenBoard of size 2 and run countSolutions. It should be 0 because there are no solutions!") ;
    //System.out.println("Here is the empty board:\n" + c.toString()) ;
    if (c.countSolutions() == 0) {
      System.out.println("Good job! countSolutions works on a board of size 2!") ;
    }
    else {
      System.out.println("There is something wrong with countSolutions because it didn't return 0 for a board of size 2!") ;
    }
    QueenBoard d = new QueenBoard(3) ;
    System.out.println("Let's create a QueenBoard of size 3 and run countSolutions. It should be 0 because there are no solutions!") ;
    //System.out.println("Here is the empty board:\n" + d.toString()) ;
    if (d.countSolutions() == 0) {
      System.out.println("Good job! countSolutions works on a board of size 3!") ;
    }
    else {
      System.out.println("There is something wrong with countSolutions because it didn't return 0 for a board of size 3!") ;
    }
    QueenBoard e = new QueenBoard(4) ;
    System.out.println("Let's create a QueenBoard of size 4 and run countSolutions. It should be 2!") ;
    //System.out.println("Here is the empty board:\n" + e.toString()) ;
    if (e.countSolutions() == 2) {
      System.out.println("Good job! countSolutions works on a board of size 4!") ;
    }
    else {
      System.out.println("There is something wrong with countSolutions because it didn't return 2 for a board of size 4!") ;
    }
    */
    /*
    // DRIVER 1
    QueenBoard  board = new QueenBoard(0); // testing with size 0
    System.out.println(board.countSolutions());
    System.out.println("0 \n"); // actual result to match with program's result
    QueenBoard  board1 = new QueenBoard(1); // testing with size 1
    System.out.println(board1.countSolutions());
    System.out.println("1 \n"); // actual result to match with program's result
    QueenBoard  board2 = new QueenBoard(2); // testing with size 2
    System.out.println(board.countSolutions());
    System.out.println("0 \n"); // actual result to match with program's result
    QueenBoard  board3 = new QueenBoard(3); // testing with size 3
    System.out.println(board3.countSolutions());
    System.out.println("0 \n"); // actual result to match with program's result
    QueenBoard  board4 = new QueenBoard(4); // testing with size 4
    System.out.println(board4.countSolutions());
    System.out.println("2 \n"); // actual result to match with program's result
    QueenBoard  board5 = new QueenBoard(5); // testing with size 5
    System.out.println(board5.countSolutions());
    System.out.println("10 \n"); // actual result to match with program's result
    QueenBoard  board6 = new QueenBoard(6); // testing with size 6
    System.out.println(board6.countSolutions());
    System.out.println("4 \n"); // actual result to match with program's result
    QueenBoard  board7 = new QueenBoard(7); // testing with size 7
    System.out.println(board7.countSolutions());
    System.out.println("40 \n"); // actual result to match with program's result
    QueenBoard  board8 = new QueenBoard(8); // testing with size 8
    System.out.println(board8.countSolutions());
    System.out.println("90 \n"); // actual result to match with program's result
    QueenBoard  board9 = new QueenBoard(9); // testing with size 9
    System.out.println(board9.countSolutions());
    System.out.println("352 \n"); // actual result to match with program's result
    QueenBoard  board10 = new QueenBoard(10); // testing with size 10
    System.out.println(board10.countSolutions());
    System.out.println("724 \n"); // actual result to match with program's result
    QueenBoard  board11 = new QueenBoard(11); // testing with size 11
    System.out.println(board11.countSolutions());
    System.out.println("2680 \n"); // actual result to match with program's result
    QueenBoard  board12 = new QueenBoard(12); // testing with size 12
    System.out.println(board12.countSolutions());
    System.out.println("14200 \n"); // actual result to match with program's result
    QueenBoard  board13 = new QueenBoard(13); // testing with size 13
    System.out.println(board13.countSolutions());
    System.out.println("73712 \n"); // actual result to match with program's result
    QueenBoard  board14 = new QueenBoard(14); // testing with size 14
    System.out.println(board14.countSolutions());
    System.out.println("365596	\n"); // actual result to match with program's result
    QueenBoard  board15 = new QueenBoard(16); // testing with size 15
    System.out.println(board.countSolutions());
    System.out.println("2279184 \n"); // actual result to match with program's result
    */
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
        if (addQueen(row, col)) {
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
      System.out.println("hit top");
      System.out.println(this.toString());
      if (row >= board.length){
        count ++;
        System.out.println("Solution!");
      }
        else{
          if (row < 0 ){
            throw new IllegalStateException("Negative Value");
          }
          for (int col = 0; col < board.length; col ++){
            if (addQueen(row,col)){
              System.out.println("added");
              System.out.println(this.toString());

              oneSolution(row + 1);


              System.out.println("removed");
              removeQueen(row, col);

            }
          }
        }
       // for testing
      }

      private boolean addQueen(int row, int col) {
        if (board[row][col] != 0 || row >= board.length || col >= board.length) return false;
        //Horizontal Add
        for (int x = 0; x < board[row].length; x ++) {
          board[row][x] = board[row][x] + 1;
        }
        //Diagonal Add
        int x  = col + 1;
        int y = row - 1;
        while (x < board.length && y >= 0) {
          board[y][x]  = board[y][x] + 1;
          x ++;
          y --;
        }
        x  = col + 1;
        y = row + 1;
        while (x < board.length && y < board.length) {
          board[y][x] = board[y][x] + 1;
          x ++;
          y ++;
        }
        x  = col - 1;
        y = row - 1;
        while (x >= 0 && y >= 0) {
          board[y][x] = board[y][x] + 1;
          x --;
          y --;
        }
        x  = col - 1;
        y = row + 1;
        while (x >= 0 && y < board.length) {
          board[y][x] = board[y][x] + 1;
          x --;
          y ++;
        }
        //Vertical
        for (int index = 0; index < board.length; index ++) {
          board[index][col] = board[index][col] + 1;
        }
        board[row][col] = -1;
        return true;
      }

      private boolean removeQueen(int row, int col) {
        if (board[row][col] != -1) return false;
        //Horizontal
        for (int x = 0; x < board[row].length; x ++) {
          board[row][x] = board[row][x] - 1;
        }
        //Diagonal
        int x  = col + 1;
        int y = row - 1;
        while (x < board.length && y >= 0) {
          board[y][x]  = board[y][x] - 1;
          x ++;
          y --;
        }
        x  = col + 1;
        y = row + 1;
        while (x < board.length && y < board.length) {
          board[y][x] = board[y][x] - 1;
          x ++;
          y ++;
        }
        x  = col - 1;
        y = row - 1;
        while (x >= 0 && y >= 0) {
          board[y][x] = board[y][x] - 1;
          x --;
          y --;
        }
        x  = col - 1;
        y = row + 1;
        while (x >= 0 && y < board.length) {
          board[y][x] = board[y][x] - 1;
          x --;
          y ++;
        }
        //Vertical
        for (int index = 0; index < board.length; index ++) {
          board[index][col] = board[index][col] - 1;
        }
        board[row][col] = 0;
        return true;
      }

    }
