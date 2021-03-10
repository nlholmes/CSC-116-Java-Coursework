import java.util.*;
/**
 * A different attempt at coding the connect four game
 * @author Nathan Holmes
 */
 
public class ConnectFourGame {
    
    // Can likely make a method for win condition, as the code is repeated for that in each method
    
    
    /**
     * Need to have the following:
     *
     *  Board constructor/initialization dependent on user input
     *  Board checking methods
     *
     * Need to check the following with methods:
     *
     *  Horizontal
     *  Vertical
     *  Diagonal
     *  (Can use counter for streaks)
     *
     * Only really need to check where the last move was, will tackle that later
     *
     * Need the following fields (to be updated by the user
     *
     *  width
     *  height
     *  streakToWin, number of adjacent tokens determining winner
     *
     * Improvements
     *  
     *  Check only the adjacent pieces to the last piece placed, instead of entire board
     *  Method for repeated win condition code
     *
     * New Idea
     *  Run the program from the GUI, make this an object class for hte board
     *  This is similar to what we did for RationalNumber, I don't know if making this the main program is feasible
     *  
     * Changes:
     *  Fields, changed methods to nonstatic
     *  To test, needed to make a ConnectFourGame object and then call methods like this:
     *      board.checkHorizontal()
     *  Created constructor for a ConnectFourGame board, so that when create the object, can give dimensions to the character matrix
     *  Added getter method for the board field
     *  Changed main method tests to fit new format
     *  Had to move win condition logic for all methods inside the loop (error with reset if height > streakToWin
     *      Ran into another ERROR: current diagonal check methods only check the corner diagonals, they need to check ALL diagonals (b/c board is bigger than streakToWin)
     *      ***Worrying about this later***
     
     * Changes, after moved on to GUI:
     *  Removed char[][] board parameter from each of the check methods, as board is now a field for this class
     *
     */
    
    // Fields initialized to default values
    private int streakToWin;// = 4;
    private int height;// = 2*streakToWin;
    private int width;// = 2*streakToWin;
    private char[][] board;// = new char[height][width]; // board field, set to default
    
    //for example: this.height = console.nextInt();
    
    //Class constant, change this to field later
    //public static final int WIN_NUM = 4; // number to win (streakToWin)
    
    /**
     * Constructor for the ConnectFourGame board object
     * This sort of repeats the default values, but lets the user make a new board if needed
     * So that the board can depend on how many tokens in a row the user wants to achieve victory
     * @param streakToWin number in a row to win, determines matrix size
     */
    public ConnectFourGame(int streakToWin) {
        this.height = 2*streakToWin; // this is how the dimensions are constructed
        this.width = 2*streakToWin;
        this.streakToWin = streakToWin;
        this.board = new char[height][width]; 
    }
    
    /**
     * Gets playing board
     * @return connect four character array matrix;
     */
    public char[][] getBoard() {
        return board;
    }
    
    /**
     * Gets streakToWin (for size)
     * @return streak to win for this ConnectFourGame board object
     */
    public int getStreakToWin() {
        return streakToWin;
    }
    
    /**
     * Checks for horizontal winner
     * @param board the game board to check
     * @return character color of winning piece or 'n' if not a winning streak
     */
    public char checkHorizontal() { 
        //board is char[rows][columns] = char[height][width]
        // width is cols
        // height is rows
        // to check horizontal, need to check every col in every row
        //      so loop through every row first (height)
        
        //Initialize count and loop variables
        int redCount = 0;
        int blackCount = 0;
        
        char currentElem;
        //int winNum = this.streakToWin;
        //int h = this.height;
        //int w = this.width;
        int h = board.length; // number of rows
        int w = board[1].length; // number of columns
        // indecies start at 0
        for(int i = 0; i < h; i++) { // for every row
            for(int j = 0; j < w; j++) { // for every column in that row
                currentElem = board[i][j]; // current horizontal element
                //System.out.println(redCount);
                if(currentElem == 'r') { // if red
                    redCount++;
                } else { // need to set to zero because we are considering streaks
                    redCount = 0;
                }
                if(currentElem == 'b') { // if black
                    blackCount++;
                } else {
                    blackCount = 0;
                }
                // Printing for testing
                //System.out.println("Horizontal Red (" + (i+0) + "," + (j+0) + "): " + redCount);
                //System.out.println("Horizontal Black (" + (i+0) + "," + (j+0) + "): " + blackCount);
                //System.out.println(redCount);
                //System.out.println(streakToWin);
                // Logic determining winner
                if(redCount >= streakToWin) { // was WIN_NUM
                    return 'r';
                } else if(blackCount >= streakToWin) { // can't be a tie and red goes first so its okay to nest; was WIN_NUM
                    return 'b';
                } //else {
                //    return 'n';
                //}
            }
        }
        return 'n'; // if it makes it through loop, no winner
        /** Had to move this inside the loop because loop resets counts after every row     
        // Logic determining winner
        // Might be able to do this with one if statement in nested loop
        // red || black, return current element
        // However, that requires doing the logic test for each element
        if(redCount >= winNum) {
            return 'r';
        } else if(blackCount >= winNum) { // can't be a tie and red goes first so its okay to nest
            return 'b';
        } else {
            return 'n';
        }
        */
    }
    
    
    public char checkVertical() {
        //Initialize count and loop variables
        int redCount = 0;
        int blackCount = 0;
        
        char currentElem;
        //int winNum = this.streakToWin;
        //int h = this.height;
        //int w = this.width;
        int h = board.length; // number of rows
        int w = board[1].length; // number of columns
        // indecies start at 0
        for(int i = 0; i < w; i++) { // for every column
            for(int j = 0; j < h; j++) { // for every row in that column
                currentElem = board[j][i]; // current vertical element (switched i and j from the checkHorizontal() method)
                if(currentElem == 'r') { // if red
                    redCount++;
                } else { // need to set to zero because we are considering streaks
                    redCount = 0;
                }
                if(currentElem == 'b') { // if black
                    blackCount++;
                } else {
                    blackCount = 0;
                }
                // Printing for testing
                //System.out.println("Vertical Red (" + (i+0) + "," + (j+0) + "): " + redCount);
                //System.out.println("Vertical Black (" + (i+0) + "," + (j+0) + "): " + blackCount);
                
                // Logic determining winner
                if(redCount >= this.streakToWin) {
                    return 'r';
                } else if(blackCount >= this.streakToWin) {
                    return 'b';
                }
            }
        }
        return 'n'; // if it makes it through loop, no winner
    }
    
    
    // For diagonal need to figure out how to index into the board
    
    public char checkDiagonalDR() {
        int h = board.length;
        int w = board[1].length;
        int redCount = 0;
        int blackCount = 0;
        
        //System.out.println(streakToWin);
        
        // I think we need two checks for diagonal
        //      one down and to the right change:(+-1,+1)
        //      one down and to the left change:(+1,-1)
        
        // down and to the right
        // starts at first element of board matrix
        //      first column, first row
        // add one to columns, add one to rows
        // start both cols and rows at 0
        // diagonals are dependent on height (rows), but do a number of diagonal checks equal to number of rows - some number
        int col = 0; // initial value of down and to the right diagonal
        char currentElem;
        for(int row = 0; row < h; row++) { // for every row, starting at top
            currentElem = board[row][col];
            if(currentElem == 'r') { // if red
                redCount++;
            } else { // need to set to zero because we are considering streaks
                redCount = 0;
            }
            if(currentElem == 'b') { // if black
                blackCount++;
            } else {
                blackCount = 0;
            }
            // Printing for testing
            //System.out.println("D-R Diagonal Red (" + row + "," + col + "): " + redCount);
            
            // Logic determining winner
            if(redCount >= streakToWin) {
                return 'r';
            } else if(blackCount >= streakToWin) {
                return 'b';
            }

            col++; // increases column by one for next element
        }
        return 'n';
    }
    
    
    public char checkDiagonalDL() {
        int h = board.length;
        int w = board[1].length;
        int redCount = 0;
        int blackCount = 0;
        
        // I think we need two checks for diagonal
        //      one down and to the right change:(+1,+1)
        //      one down and to the left change:(+1,-1)
        
        // down and to the left
        // starts at first element of board matrix
        //      first column, first row
        // add one to columns, add one to rows
        // start both cols and rows at 0
        // diagonals are dependent on height (rows), but do a number of diagonal checks equal to    number of rows - some number
        int col = w - 1; // initial value of down and to the right diagonal
        char currentElem;
        for(int row = 0; row < h; row++) { // for every row, starting at top
            currentElem = board[row][col];
            if(currentElem == 'r') { // if red
                redCount++;
            } else { // need to set to zero because we are considering streaks
                redCount = 0;
            }
            if(currentElem == 'b') { // if black
                blackCount++;
            } else {
                blackCount = 0;
            }
            // Printing for testing
            //System.out.println("D-L Diagonal Black (" + row + "," + col + "): " + blackCount);
            
            // Logic determining winner
            if(redCount >= streakToWin) {
                return 'r';
            } else if(blackCount >= streakToWin) {
                return 'b';
            }
            
            col--; // increases column by one for next element
        }
        return 'n'; // no winner this check
    }
    
    
    /**
     * Drops piece into desired column
     * //param board matrix of pieces, no longer need as made nonstatic
     * @param col column to drop piece in
     * @param color checker color
     * @return row that the piece fell into, returns negative col if that column is full
     */
    public int dropPiece(int col, char color) {
        int h = board.length;
        //int w = board[1].length;
        char currentElem;
        // Check each column for lowest open space on board
        // Start loop at bottom of each column
        for(int i = h - 1; i >= 0; i--) { // rows
            currentElem = board[i][col];
            //System.out.println("Row: " + i + ", Col: " + col + " " +
            //    !Character.isLetter(currentElem));
            if(!Character.isLetter(currentElem)) { // if the current element is not a character
                //currentElem = color;
                board[i][col] = color; // assigns value to board instead of the variable so it works
                //System.out.println(board[i][col]);
                //break; // don't drop more
                return i; // returns row
            }
        } 
        return -col;
    }
    
    public String toString() {
        // loop through all elements to print the matrix
        String printBoard = "";
        for(int i = 0; i < board.length; i++) { // rows
            for(int j = 0; j < board.length; j++) { // cols
                if(Character.isLetter(board[i][j])) { // if it is a piece color
                    //printBoard += board[i][j] + " "; // print the color
                    printBoard += String.format("%3s", board[i][j]);
                } else {
                    printBoard += String.format("%3s", '-'); // adds dash where there is no piece
                }
            }
            printBoard += "\n"; // adds new line after every row
        }
        return printBoard;
    }
    
    public boolean equals(Object o) {
        if (o instanceof ConnectFourGame) {
            ConnectFourGame otherGame = (ConnectFourGame) o;
            boolean equality = true;
            // if have different streakToWin fields, will be different sizes
            if(streakToWin != otherGame.getStreakToWin()) {
                return false;
            }
            // Need to loop through to see if all elements in each board are equal
            // first get boards of the other object
            char[][] otherBoard = otherGame.getBoard();
            for(int i = 0; i < otherBoard.length; i++) { // rows
                for(int j = 0; j < otherBoard[i].length; j++) { // cols
                    if(board[i][j] != otherBoard[i][j]) {
                        return false;
                    }
                }
            }
            
            return true; // made it through all checks
        } else {
            return false;
        }
    }
    
    public static void main(String args[]) {
        
        // Instructions
        /** Place instructions here 
        
        // Get input from user
        Scanner console = new Scanner(System.in);
            //System.out.print("Board Height (rows): ");
            //this.height = console.nextInt();
            //System.out.print("Board Width (columns): ");
            //this.width = console.nextInt();
        // Only need streakToWin from console as it controls both the width and the height
        // based off of the emailed improvement instructions
        System.out.print("Required streak to win: ");
        this.streakToWin = console.nextInt();
        // Dimensions for the square board matrix are twice the streak
        this.height = 2 * streakToWin;
        this.width = 2 * streakToWin;
        */
        
        
        // Something similar to this to get width and height
        //this.height = ConnectFourGUI.rows; //or getter method
        //this.width = ConnectFourGUI.cols;
        //this.streakToWin = ConnectFourGUI.winNum;
        // Create empty board
        // To fill board with "." or "+", loop through and assign each element
        //char[][] board = new char[height][width];
        
        
        // Play the game
        /** 
         * Need: How to play the game?
         *      Turns need to alternate between red and black (GUI)
         *      Pieces need to drop to bottom of board matrix (need method)
         *      Alternate turns with for loop for maximum possible turns
         *          No winner if all turns are unsuccessful in their checks
         *          Odd index is red turn, even index is black turn
         *      While loop/break statement to end the game when there is a winner
         */
    
    
        //ConnectFourGame board = new ConnectFourGame();
        int streakToWin = 4;
        /*
        
        //int height = 4;
        //int width = 4;
        
        // Making a horizontal winner board
        //char[][] horizWinBoard = new char[height][width];
        ConnectFourGame horizWinGame = new ConnectFourGame(streakToWin);
        char[][] horizWinBoard = horizWinGame.getBoard();
        horizWinBoard[2][0] = 'r'; // indecies start at 0
        horizWinBoard[2][1] = 'r';
        horizWinBoard[2][2] = 'r';
        horizWinBoard[2][3] = 'r';
        // Making a horizontal winner board
        //char[][] vertWinBoard = new char[height][width];
        ConnectFourGame vertWinGame = new ConnectFourGame(streakToWin);
        char[][] vertWinBoard = vertWinGame.getBoard();
        vertWinBoard[0][1] = 'b';
        vertWinBoard[1][1] = 'b';
        vertWinBoard[2][1] = 'b';
        vertWinBoard[3][1] = 'b';
        // Making a down-right diagonal winner board
        //char[][] drDiagWinBoard = new char[height][width];
        ConnectFourGame drDiagWinGame = new ConnectFourGame(streakToWin);
        char[][] drDiagWinBoard = drDiagWinGame.getBoard();
        drDiagWinBoard[0][0] = 'r';
        drDiagWinBoard[1][1] = 'r';
        drDiagWinBoard[2][2] = 'r';
        drDiagWinBoard[3][3] = 'r';
        // Making a down-left diagonal winner board
        //char[][] dlDiagWinBoard = new char[height][width];
        ConnectFourGame dlDiagWinGame = new ConnectFourGame(streakToWin);
        char[][] dlDiagWinBoard = dlDiagWinGame.getBoard();
        dlDiagWinBoard[0][3] = 'b';
        dlDiagWinBoard[1][2] = 'b';
        dlDiagWinBoard[2][1] = 'b';
        dlDiagWinBoard[3][0] = 'b';
        
        //System.out.println(streakToWin);
        char horizWinner = horizWinGame.checkHorizontal(horizWinBoard);
        System.out.println("Horizontal winner: " + horizWinner);
        char vertWinner = vertWinGame.checkVertical(vertWinBoard);
        System.out.println("Vertical winner: " + vertWinner);
        char drDiagWinner = drDiagWinGame.checkDiagonalDR(drDiagWinBoard);
        System.out.println("Down-right Diagonal winner: " + drDiagWinner);
        char dlDiagWinner = dlDiagWinGame.checkDiagonalDL(dlDiagWinBoard);
        System.out.println("Down-left Diagonal winner: " + dlDiagWinner);
        
        */
        
        /* These have also not been updated since the check methods had their parameters removed
        /** Testing dropPiece // Please note that these tests have not been updated since dropPiece was given a return statement
        ConnectFourGame vertWinGame = new ConnectFourGame(streakToWin);
        char[][] vertWinBoard = vertWinGame.getBoard();
        for (int m = 0; m < 4; m++) {
            vertWinGame.dropPiece(0,'b');
        }
        
        //System.out.println(streakToWin);
        char vertWinner = vertWinGame.checkVertical(vertWinBoard);
        System.out.println("Vertical winner: " + vertWinner);
        System.out.print(vertWinGame.toString());
        
        */
        
        //ConnectFourGame dropGame = new ConnectFourGame(streakToWin);
        //dropGame.dropPiece(1,'r'); // drops red piece in first col
        //System.out.print(dropGame.toString());
        
        
        
        // Testing horizontal after change, ran into error in GUI
        ConnectFourGame hGame = new ConnectFourGame(streakToWin);
        char[][] hBoard = hGame.getBoard();
        int black1 = hGame.dropPiece(0,'b');
        int red1 = hGame.dropPiece(2,'r');
        int black2 = hGame.dropPiece(1,'b');
        int red2 = hGame.dropPiece(3,'r');
        int black3 = hGame.dropPiece(2,'b');
        int black4 = hGame.dropPiece(3,'b');
        
        char hWin = hGame.checkHorizontal();
        System.out.println(hWin); // shows there is no winner, so its a problem with the GUI
        System.out.println(hGame.toString());
        
        // Diagonal checks not working for non-corner diagonals
    }
    
}
