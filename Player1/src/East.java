import java.awt.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;
/**
 * This class handles the components on the East, i.e 
 * the score board.
 * @author abraham chandafa
 * @version 1.0
 */
public class East extends JPanel {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * player win label
	 */
	JLabel pWin;	
	/**
	 * computer win label
	 */
	JLabel cWin;	
	/**
	 * draws label
	 */
	JLabel draw;
	
	/**
	 * constructor for East object
	 */
	public East() {
		pWin = new JLabel("Player 1 Wins:       0");
		pWin.setFont(new Font("Arial", Font.BOLD, 14));
		pWin.setPreferredSize(new Dimension(300,300));
		cWin = new JLabel("Player 2 Wins:       0");
		cWin.setFont(new Font("Arial", Font.BOLD, 14));
		cWin.setPreferredSize(new Dimension(300,300));
		draw = new JLabel("Draws:                 0");
		draw.setFont(new Font("Arial", Font.BOLD, 14));
		draw.setPreferredSize(new Dimension(300,300));
		setLayout(new GridLayout(3,1));
		add(pWin);
		add(cWin);
		add(draw);

		TitledBorder titledBorder = new TitledBorder("Score");
		titledBorder.setTitleFont(new Font("Arial", Font.BOLD, 16)); 
		setBorder(titledBorder);
	}
	/**
	 * this method updates the score on scoreboard
	 * @param p - new number of playerWins
	 * @param c - new number of computerWins
	 * @param d - new number of draw counts
	 */
	public void updateScore(int p, int c, int d) {
		pWin.setText("Player 1 Wins:       "+p);
		cWin.setText("Player 2 Wins:       "+c);
		draw.setText("Draws:                 "+d);
	}

}
