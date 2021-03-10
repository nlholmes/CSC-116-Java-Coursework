import org.junit.Test;
import junit.framework.TestCase;
/**
 * Test program for ConnectFourGame
 */
public class ConnectFourGameTest extends TestCase {
    
    /** Tests a horizontal win from 0, 7 to 3, 7 */
    @Test
    public void testHorizWin() {
        int streakToWin = 4;
        ConnectFourGame testBoard = new ConnectFourGame(streakToWin);
        int red1 = testBoard.dropPiece(0,'r');
        int black1 = testBoard.dropPiece(7,'b');
        int red2 = testBoard.dropPiece(1,'r');
        int black2 = testBoard.dropPiece(6,'b');
        int red3 = testBoard.dropPiece(2,'r');
        int black3 = testBoard.dropPiece(5,'b');
        int red4 = testBoard.dropPiece(3,'r');
        assertEquals('r', testBoard.checkHorizontal());
    }
    
    /** Tests a vertical win from 1, 7 to 1, 5 */
    @Test
    public void testVertWin() {
        int streakToWin = 4;
        ConnectFourGame testBoard = new ConnectFourGame(streakToWin);
        int red1 = testBoard.dropPiece(1,'r');
        int black1 = testBoard.dropPiece(2,'b');
        int red2 = testBoard.dropPiece(1,'r');
        int black2 = testBoard.dropPiece(2,'b');
        int red3 = testBoard.dropPiece(1,'r');
        int black3 = testBoard.dropPiece(2,'b');
        int red4 = testBoard.dropPiece(1,'r');
        assertEquals('r', testBoard.checkVertical());
    }
    
    /** Tests a diagonal win from 0, 0 to 3, 3 */
    @Test
    public void testDiagCornerWinDL() {
        int streakToWin = 4;
        ConnectFourGame testBoard = new ConnectFourGame(streakToWin);
        int red1 = testBoard.dropPiece(0,'r');
        int black1 = testBoard.dropPiece(1,'b');
        int red2 = testBoard.dropPiece(1,'r');
        int black2 = testBoard.dropPiece(0,'b');
        int red3 = testBoard.dropPiece(2,'r');
        int black3 = testBoard.dropPiece(2,'b');
        int red4 = testBoard.dropPiece(2,'r');
        int black4 = testBoard.dropPiece(3,'b');
        int red5 = testBoard.dropPiece(3,'r');
        int black5 = testBoard.dropPiece(3,'b');
        int red6 = testBoard.dropPiece(3,'r');
        assertEquals('r', testBoard.checkDiagonalDL());
    }
    
    /** Tests a diagonal win from 4, 3 to 7, 0 */
    @Test
    public void testDiagCornerWinDR() {
        int streakToWin = 4;
        ConnectFourGame testBoard = new ConnectFourGame(streakToWin);
        int red1 = testBoard.dropPiece(7,'r');
        int black1 = testBoard.dropPiece(6,'b');
        int red2 = testBoard.dropPiece(6,'r');
        int black2 = testBoard.dropPiece(6,'b');
        int red3 = testBoard.dropPiece(5,'r');
        int black3 = testBoard.dropPiece(5,'b');
        int red4 = testBoard.dropPiece(5,'r');
        int black4 = testBoard.dropPiece(4,'b');
        int red5 = testBoard.dropPiece(4,'r');
        int black5 = testBoard.dropPiece(4,'b');
        int red6 = testBoard.dropPiece(4,'r');
        assertEquals('r', testBoard.checkDiagonalDR());
    }
    
    /** Tests a draw */
    @Test
    public void testTie() {
        int streakToWin = 3;
        ConnectFourGame testBoard = new ConnectFourGame(streakToWin);
        int red1 = testBoard.dropPiece(0,'r');
        int black1 = testBoard.dropPiece(1,'b');
        int red2 = testBoard.dropPiece(2,'r');
        int black2 = testBoard.dropPiece(3,'b');
        int red3 = testBoard.dropPiece(4,'r');
        int black3 = testBoard.dropPiece(5,'b');
        int red4 = testBoard.dropPiece(0,'r');
        int black4 = testBoard.dropPiece(1,'b');
        int red5 = testBoard.dropPiece(2,'r');
        int black5 = testBoard.dropPiece(3,'b');
        int red6 = testBoard.dropPiece(4,'r');
        int black6 = testBoard.dropPiece(5,'b');
        int red7 = testBoard.dropPiece(5,'r');
        int black7 = testBoard.dropPiece(4,'b');
        int red8 = testBoard.dropPiece(3,'r');
        int black8 = testBoard.dropPiece(2,'b');
        int red9 = testBoard.dropPiece(1,'r');
        int black9 = testBoard.dropPiece(0,'b');
        int red10 = testBoard.dropPiece(5,'r');
        int black10 = testBoard.dropPiece(4,'b');
        int red11 = testBoard.dropPiece(3,'r');
        int black11 = testBoard.dropPiece(2,'b');
        int red12 = testBoard.dropPiece(1,'r');
        int black12 = testBoard.dropPiece(0,'b');
        int red13 = testBoard.dropPiece(0,'r');
        int black13 = testBoard.dropPiece(1,'b');
        int red14 = testBoard.dropPiece(2,'r');
        int black14 = testBoard.dropPiece(3,'b');
        int red15 = testBoard.dropPiece(4,'r');
        int black15 = testBoard.dropPiece(5,'b');
        int red16 = testBoard.dropPiece(0,'r');
        int black16 = testBoard.dropPiece(1,'b');
        int red17 = testBoard.dropPiece(2,'r');
        int black17 = testBoard.dropPiece(3,'b');
        int red18 = testBoard.dropPiece(4,'r');
        int black18 = testBoard.dropPiece(5,'b');
        int red19 = testBoard.dropPiece(5,'r');
        int black19 = testBoard.dropPiece(4,'b');
        int red20 = testBoard.dropPiece(3,'r');
        int black20 = testBoard.dropPiece(2,'b');
        int red21 = testBoard.dropPiece(1,'r');
        int black21 = testBoard.dropPiece(0,'b');
       assertEquals('n', testBoard.checkHorizontal());
       assertEquals('n', testBoard.checkVertical());        
       assertEquals('n', testBoard.checkDiagonalDL());        
       assertEquals('n', testBoard.checkDiagonalDR());
    }
}
