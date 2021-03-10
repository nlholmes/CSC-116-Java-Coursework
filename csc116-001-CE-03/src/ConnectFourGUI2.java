import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *  GUI application for ConnectFourGame
 *
 *  @author Nathan Holmes
 *  @author Hayes Derbyshire
 */
 public class ConnectFourGUI2 extends JFrame implements ActionListener {

    /**
     * Needs
     *  Piece counter for each player
     *  Game win streak counter for each player
     *  Win/tie pop-up --> win/tie dialog method, call in actionPerformed
     *  Play again pop-up --> yes/no dialog method, call in main in while loop, after GUI
     *  Required streak to win pop-up --> win streak input dialog, call in main, before GUI and set this.streakToWin = input
     *  Catch index out of bounds exception for column overflow (only increase turn count if there was not a column overflow)
     *
     *  Really need like a status bar at the bottom -- do this with another panel?
     *      5 statuses needed:
     *          Red pieces remaining
     *          Black pieces remaining
     *          Red game win streak
     *          Black game win streak
     *          Whose turn it is
     */


    public static final String instructions = "(1) Once hitting Play, choose how many checkers you desire to connect in order to win the game.\n" +
                                              "(2) Choose two players for this game. Either one can go first.\n" +
                                              "(3) Have fun! You can see your win streak recorded at the bottom of the game.";

    /** The streak to win */
    private int streakToWin;// = 4; // only value we need to change
    /** The amount of rows from user (Height) */
    private int rows;// = 2*streakToWin; // adjusted both row and column calculation for default value
    /** The amount of cols from user (Width) */
    private int cols;// = 2*streakToWin;
    /** Boolean controlling restart of game */
    //private boolean newGame;

    /** Maximum number of moves possible in the game to fill the board*/
    private int maxMoves;// = rows * cols;
    private int redPieceCount;// = maxMoves/2 + maxMoves%2; // initialize current number of moves left in game for red (gets 1 more if odd number maxMoves)
    private int blackPieceCount;// = maxMoves/2;


    /** Player turn */
    private char turn = 'r'; // changed to char, initialized to red
    // Current turn count, initialized to zero
    private int turnCount = 0; // maximum number of turns is rows*cols, used for determining tie

    private JButton[][] buttons; // button matrix for board

    // Status panel labels
    private JLabel redPieces;
    private JLabel blackPieces;
    private JLabel turnLabel;
    private JLabel redStreak;
    private JLabel blackStreak;
    // Status panel fields
    private JTextField redPiecesField;
    private JTextField blackPiecesField;
    private JTextField turnField;
    private JTextField redStreakField;
    private JTextField blackStreakField;

    /*
    private JLabel turnLabel;
    private JTextField numRowsAndColumns;
    */



    /** ConnectFourGame and board initialization */
    private ConnectFourGame game;// = new ConnectFourGame(streakToWin); // construct game
    private char[][] board;// = game.getBoard(); // get board, do we actually need this... maybe not


    /**
     * Default constructor
     */
    public ConnectFourGUI2() {



        super("Connect Four Game");
        setSize(700, 700);
        setLocation(200, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Assign values to the fields that need them
        this.streakToWin = streakDialog(); // gets streak
        this.rows = 2 * streakToWin;
        this.cols = 2 * streakToWin;
        this.game = new ConnectFourGame(streakToWin);
        this.board = game.getBoard();
        this.maxMoves = rows * cols;
        this.redPieceCount = maxMoves/2 + maxMoves%2;
        this.blackPieceCount = maxMoves/2;

        // Create Multi-tier JPanel
        JPanel borderPanel = new JPanel(new BorderLayout()); // container panel
        JPanel boardPanel = new JPanel(new GridLayout(rows, cols, 10, 10)); // game board panel, with padding
        JPanel statusPanel = new JPanel(new GridLayout(2,2,5,5)); // 2x2 status panel, with padding

        // Add JPanels to the frame, nest board and status in border
        borderPanel.add(boardPanel, BorderLayout.CENTER); // puts game board in center
        borderPanel.add(statusPanel, BorderLayout.SOUTH); // puts status panel at bottom
        add(borderPanel);


        // Adding boardPanel buttons
        buttons = new JButton[rows][cols];
        for (int i = 0; i < buttons.length; i++) { // rows
            for (int j = 0; j < buttons[i].length; j++) { // cols
                /*
                buttons[rows - 1][cols - 1] = new JButton("0");
                buttons[rows - 1][cols - 1].setBackground(Color.WHITE);
                buttons[rows - 1][cols - 1].setForeground(Color.DARK_GRAY); // changed to dark gray because have black pieces
                panel1.add(buttons[rows - 1][cols - 1]);

                buttons[rows - 1][cols - 1].addActionListener(this); // adds action listener to each button
                */
                //System.out.println(buttons[rows - 1][cols - 1]);

                // Needed to be dependent on loop index
                buttons[i][j] = new JButton("0");
                buttons[i][j].setBackground(Color.WHITE);
                buttons[i][j].setForeground(Color.DARK_GRAY); // changed to dark gray because have black pieces
                boardPanel.add(buttons[i][j]);

                buttons[i][j].addActionListener(this); // adds action listener to each button

            }
        }

        // Status panel labels for players
        redPieces = new JLabel("Red Pieces"); // red
        redStreak = new JLabel("Red win streak");
        turnLabel = new JLabel("Current Turn"); // Turn count label
        blackPieces = new JLabel("Black Pieces"); // black
        blackStreak = new JLabel("Black win streak");
        // Adding them to status panel
        statusPanel.add(redPieces);
        statusPanel.add(redStreak);
        statusPanel.add(turnLabel);
        statusPanel.add(blackPieces);
        statusPanel.add(blackStreak);


        // Status panel fields for players, 5 col text fields
        redPiecesField = new JTextField(5); // red
        redStreakField = new JTextField(5);
        turnField = new JTextField(5); // turn field
        blackPiecesField = new JTextField(5); // black
        blackStreakField = new JTextField(5);
        // Adding them to status panel
        statusPanel.add(redPiecesField);
        statusPanel.add(redStreakField);
        statusPanel.add(turnField);
        statusPanel.add(blackPiecesField);
        statusPanel.add(blackStreakField);

        // Disable editing
        redPiecesField.setEditable(false);
        redStreakField.setEditable(false);
        turnField.setEditable(false);
        blackPiecesField.setEditable(false);
        blackStreakField.setEditable(false);

        setVisible(true);
    }

    /**
     * Performs specific actions based on the event that occurs
     *
     * @param e event that occured
     */
    public void actionPerformed(ActionEvent e) {
            /**
             * Need to:
             *  Construct ConnectFourGame game from streakToWin --> needs to be done as field
             *      Might need a text box/area/pop-up to first determine the streakToWin
             *      This could pop up after every game to get a new streakToWin
             *  Get board from the game using the getter method? not sure if need to do this --> needs to be done as field. Or not at all?
             *  Determine which player's turn it is
             *  Get column index of button pressed (also need row index to update GUI)
             *      Then drop piece in that column using the dropPiece method
             *      Update the GUI accordingly, so that the text in the index of the piece is replaced by the piece color
             *          Could also just change the color of the button to red/black
             *  Switch player turns

             *  PROBLEMS
             * x     1. buttons becomes all null when enter actionPerformed method
             *          FIX: changed button loop in ConnectFourGUI() so that buttons were dependent on index
             * x     2. button clicked changes color instead of the one at the bottom row
             *          FIX: changed dropPiece() method, so that it retruns the row of the piece when it is dropped
             *

             * NEW NEEDS
             *  Catch index out of bounds exception for when column is full, that player gets to try again
             *      Do after drop piece, either before or at same time check for win
             *  Once maximum moves have been made, game ends in tie
             *      Do after check for win
             *  Stop the game once the win streak has been met (i.e. use the checker methods every button click)
             *      Do after drop piece
             */
        //ConnectFourGame game = new ConnectFourGame(streakToWin); // construct game, moved to field
        //char[][] board = game.getBoard(); // get board, moved to field
        // Determining player turn will alternate on valid button click?

        // Below loops through buttons to determine which button was clicked
        // initialized variables:
        int pressedRow = 0;
        int pressedCol = 0;
        JButton currentButton = null;
        for(int i = 0; i < buttons.length; i++) { // rows
            for(int j = 0; j < buttons[i].length; j++) { // cols
                currentButton = buttons[i][j];
                //System.out.println(currentButton);
                if (e.getSource() == currentButton) { // if current button was the one clicked
                    pressedRow = i; // gets row index for updating GUI
                    pressedCol = j; // gets column index for dropPiece
                }
            }
        }

        //System.out.println(buttons.length);
        //System.out.println(buttons[pressedRow][pressedCol]);

        // Dropping the piece into the board
        // row is returned from dropPiece, placedCol will be the same as pressedCol
        int placedRow = game.dropPiece(pressedCol, turn); // turn represents player color as char, initially is 'r'

        // Check win conditions
        // stop game if there is a winner (maybe System.exit(1) will work)
        char horizCheck = game.checkHorizontal();
        char vertCheck = game.checkVertical();
        char drDiagCheck = game.checkDiagonalDR();
        char dlDiagCheck = game.checkDiagonalDL();
        // Win condition nested if statements
        // 'n' is returned from check method if there is no winner
        char winner = 'n'; // initialize winner variable
        //System.out.println("Horiz: " + horizCheck);
        if (horizCheck != 'n') {
            winner = horizCheck;
            //System.out.println("h " + winner);
        } else if (vertCheck != 'n') {
            winner = vertCheck;
            //System.out.println("v " + winner);
        } else if (drDiagCheck != 'n') {
            winner = drDiagCheck;
        } else if (dlDiagCheck != 'n') {
            winner = dlDiagCheck;
        }





        // Update GUI buttons to show where the piece was dropped
        // And switching player every valid button press
        // turn variable initialized to 'r'
        // Below if statements hold text updates as well
        //      Did not do the win streaks yet, havent gotten code to that point
        if (turn == 'r') {
            buttons[placedRow][pressedCol].setBackground(Color.RED); // sets current button color to the player who pressed a button
            turn = 'b'; // switch player turn
            // must be string in setText()
            redPieceCount--; // update maxMoves
            redPiecesField.setText("" + redPieceCount); // red will always get an extra move as they always go first (this was done for odd max pieces)

            turnField.setText("Black's Turn"); // indicated switch of turns
        } else if (turn == 'b') {
            buttons[placedRow][pressedCol].setBackground(Color.BLACK);
            turn = 'r'; // switch player turn
            blackPieceCount--; // update maxMoves
            blackPiecesField.setText("" + blackPieceCount); // black does not get an extra move

            turnField.setText("Red's Turn"); // indicate switch of turns
        }

        // Replaced code with pop up method, also add in newGameDialog
        turnCount++; // update turn counter variable
        boolean tie = turnCount >= maxMoves; // determines if it is a tie
        winTieDialog(winner, tie);
        boolean newGame = newGameDialog(winner, tie); // newGame is a boolean field used to run the main method while loop to repeat games
        //  there will be no new game dialog box if there was not a winner or a tie

            /*
            if (winner != 'n') { // only do this if someone won the game
                // Make a nice print statement
                String playerWinner = "";
                if (winner == 'r') { // if red won
                    playerWinner += "Red";
                } else { // if red didn't win, black did
                    playerWinner += "Black";
                }
                System.out.println(playerWinner + " has won the game!");
                //System.exit(1);
            }

            // Checking for a tie
            // uses the turnCount field
            // ONLY INCREASE COUNT IF THERE WAS NOT A COLUMN OVERFLOW
            turnCount++; // updates turn count by one every time
            if (turnCount >= maxMoves) { // rows * cols represents maximum possible turns
                System.out.println("It's a tie!");
                //System.exit(1);
            }
            */

        /*
        System.out.println(streakToWin);
        System.out.println(board.length);
        System.out.println(placedRow);
        System.out.println(game.toString());
        */

    }

    // Pop up for who won or if it was a tie
    public void winTieDialog(char winner, boolean tie) {
        //boolean newGame; // boolean controlling new game or not
        if (winner != 'n') { // only do this if someone won the game
            // Make a nice print statement
            String playerWinner = "";
            if (winner == 'r') { // if red won
                playerWinner += "Red";
            } else { // if red didn't win, black did
                playerWinner += "Black";
            }
            //System.out.println(playerWinner + " has won the game!");
            JOptionPane.showMessageDialog(null, playerWinner + " has won the game!");
            //System.exit(1);
            //newGame = newGameDialog(); // calls newGame pop up method
        }

        // Checking for a tie
        // uses the turnCount field
        // ONLY INCREASE COUNT IF THERE WAS NOT A COLUMN OVERFLOW
        //turnCount++; // updates turn count by one every time
        if (tie) { // rows * cols represents maximum possible turns
            // System.out.println("It's a tie!");
            JOptionPane.showMessageDialog(null, "It's a tie!");
            //System.exit(1);
            //newGame = newGameDialog();
        }
    }


    // Pop up for required streak to win input
    public int streakDialog() {
        String streakStr = JOptionPane.showInputDialog(null, "Enter required streak to win: ");
        int streak = 0;
        try { // try/catch in case bad input
            streak = Integer.parseInt(streakStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid integer value");
            System.exit(1);
        }
        // if successful parse, update the class field for streakToWin
        return streak;
    }



    // Pop up if want new game
    // Adapted code from class website
    // returns boolean if want to continue
    public boolean newGameDialog(char winner, boolean tie) {
        if(winner != 'n' || tie) { // if there was a winner or a tie, need to reprompt
            int choice = JOptionPane.showConfirmDialog(null, "Play again?");
            if (choice == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null, "Red starts");
                
                // wipe board for new game
                game = new ConnectFourGame(streakToWin); // resets board object, not GUI colors
                // Loop through and set all button colors to white again
                for(int i = 0; i < buttons.length; i++) { // rows
                    for(int j = 0; j < buttons[i].length; j++) { // cols
                        buttons[i][j].setBackground(Color.WHITE);
                    }
                }
                // Need to also set first player to go as red ('r') again
                turn = 'r';

                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Goodbye!");
                System.exit(1);
                return false;
            }
        }
        return false;
    }


    /**
     * Starts the program
     *
     * @param args array of comand line arguments
     */
    public static void main(String[] args) {
        /*
        boolean newGame = false;
        do {
            newGame = newGameDialog(); // moved inside GUI, at end
            //new streakDialog();
            ConnectFourGUI gui = new ConnectFourGUI();
            //gui.streakDialog(); // moved inside the GUI, right after super

        } while (newGame); // newGame is a boolean field for if want new game
        */

        /*
        Object[] options = {"Instructions", "Play", "Quit"};
        int n = JOptionPane.showOptionDialog(null, "Welcome to the Connect Four game!", "Connect Four",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[1]);
        if (n == JOptionPane.YES_OPTION) {
            while (n == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null, instructions, "Instructions", JOptionPane.INFORMATION_MESSAGE);

                n = JOptionPane.showOptionDialog(null, "Welcome to the Connect Four game!", "Connect Four",
                        JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[1]);
            }
        }
        if (n == JOptionPane.NO_OPTION) {

        } else if (n == JOptionPane.CANCEL_OPTION) {
            System.exit(1);
        }*/
        new ConnectFourGUI2();

    }

 }
