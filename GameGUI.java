import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameGUI extends JFrame
{
    private boolean isXTurn = true;

    GameTask background_Noise = new GameTask();
    
    public GameGUI()
    {
        // GameTask features to keep track of progress
        background_Noise.setPlayerSymbol('X', 'O');

        setTitle("Tic Tac Toe");
        setLayout(new GridLayout(3, 3));
        

        // Create 9 buttons
        for(int i = 0; i < 9; i++)
        {
            JButton button = new JButton();
            button.addActionListener(new ButtonListener());
            add(button);
        }


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setVisible(true);

    }

    private class newGameButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {

            background_Noise.clearBoard();
            getContentPane().removeAll();
            
            for(int i = 0; i < 9; i++)
            {
                JButton button = new JButton();
                button.addActionListener(new ButtonListener());
                add(button);
            }

            setTitle("Tic Tac Toe");
            setLayout(new GridLayout(3, 3));
            getContentPane().revalidate();
            getContentPane().repaint();

        }
    }

    private class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            JButton button = (JButton) e.getSource();
            if (button.getText().equals("")) 
            { // Check if the button is not already clicked
                if (isXTurn)
                {
                    button.setText("X");
                    int index = getContentPane().getComponentZOrder(button);
                    int row = index / 3;
                    int col = index % 3;
                    background_Noise.setRow(row);
                    background_Noise.setCol(col);
                    background_Noise.setBoard(background_Noise.getRow(), background_Noise.getCol(), background_Noise.getPlayerSymbol());
                } 
                else 
                {
                    button.setText("O");
                    int index = getContentPane().getComponentZOrder(button);
                    int row = index / 3;
                    int col = index % 3;
                    background_Noise.setRow(row);
                    background_Noise.setCol(col);
                    background_Noise.setBoardPlayer2(background_Noise.getRow(), background_Noise.getCol(), background_Noise.getPlayerSymbol_2());
                }

                background_Noise.decideWinner();

                // Toggle the turn
                isXTurn = !isXTurn; 
                
                //test using terminal prompt to see array input for game task file "background_Noise"
                //background_Noise.outputboard();
                
                if(background_Noise.endGame() == 1)
                {
                    JPanel panel = new JPanel();

                    panel.setLayout(new GridLayout(4, 1));

                    JLabel label = new JLabel();        
                    JLabel label2 = new JLabel();        
                    JLabel label3 = new JLabel(); 

                    label.setText(" Player 1 wins: " + background_Noise.getWinCount_Player1());
                    label2.setText(" Player 2 wins: " + background_Noise.getWinCount_Player2());
                    label3.setText(" Draws: " + background_Noise.getDrawCount());

                    panel.add(label);
                    panel.add(label2);
                    panel.add(label3);

                    JButton newGameButton = new JButton("New Game");
                    newGameButton.addActionListener(new newGameButtonListener());
                    panel.add(newGameButton);

                    getContentPane().removeAll();
                    add(panel);
                    getContentPane().revalidate();
                    getContentPane().repaint();
                }  
                    
            }

        }
    }


    public static void main(String[] args) 
    {
        new GameGUI();
    }

}

