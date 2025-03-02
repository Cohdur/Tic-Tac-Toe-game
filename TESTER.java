import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TESTER
{
    @Test
    public void TEST_COUNT_PLAYER1()
    {
        GameTask X = new GameTask();
        //Check end game toggle == 0 \ false
        assertEquals(false,X.endGameToggle);
        
        //Populate the array
        X.setPlayerSymbol('X','O');

        X.setBoard(0, 0, X.getPlayerSymbol());
        X.setBoard(0, 1, X.getPlayerSymbol());
        X.setBoard(0, 2, X.getPlayerSymbol());

        X.decideWinner();
        //Check end game toggle == 1 \ true now 
        assertEquals(true,X.endGameToggle);
        
        assertEquals(1, X.getWinCount_Player1());
        assertEquals(1, X.getLossCount_Player2());

    }

    @Test
    public void TEST_COUNT_PLAYER2()
    {
        GameTask X = new GameTask();
        //Check end game toggle == 0 \ false
        assertEquals(false,X.endGameToggle);

        
        //Populate the array
        X.setPlayerSymbol('X','O');

        X.setBoardPlayer2(0, 0, X.getPlayerSymbol_2());
        X.setBoardPlayer2(0, 1, X.getPlayerSymbol_2());
        X.setBoardPlayer2(0, 2, X.getPlayerSymbol_2());

        X.decideWinner();
        //Check end game toggle == 1 \ true now 
        assertEquals(true,X.endGameToggle);

        assertEquals(1, X.getWinCount_Player2());
        assertEquals(1, X.getLossCount_Player1());
    }

    @Test
    public void TEST_DRAW_COUNT()
    {
        GameTask X = new GameTask();
        //Check end game toggle == 0 \ false
        assertEquals(false,X.endGameToggle);

        
        //Populate the array
        X.setPlayerSymbol('X','O');

        X.setBoard(0, 0, X.getPlayerSymbol());
        X.setBoardPlayer2(0, 1, X.getPlayerSymbol_2());
        X.setBoard(0, 2, X.getPlayerSymbol());

        X.setBoard(1, 0, X.getPlayerSymbol());
        X.setBoardPlayer2(1, 1, X.getPlayerSymbol_2());
        X.setBoardPlayer2(1, 2, X.getPlayerSymbol_2());

        X.setBoardPlayer2(2, 0, X.getPlayerSymbol_2());
        X.setBoardPlayer2(2, 0, X.getPlayerSymbol_2());
        X.setBoard(2, 1, X.getPlayerSymbol());
        X.setBoard(2, 2, X.getPlayerSymbol());


        X.decideWinner();
        //Check end game toggle == 1 \ true now 
        assertEquals(true,X.endGameToggle);

        assertEquals(1, X.getDrawCount());
    }

    
}
