import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
/**
 * This class is for box objects inside the board i.e 
 * the 9 boards.
 * @author abraham chandafa
 * @version 1.0
 */
public class Box extends JPanel {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * when 0, box is empty. when 1, can draw/has X-red. when 2, can draw/already has O
	 */
	private int filled;
	
    /**
     * Constructor to initialize the Box with a filled state.
     */
    public Box() {
        this.filled = 0; // Set the initial filled state
    }
    
	@Override
	public void paintComponent(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());
		if (filled == 1) {
			Image image = new ImageIcon("images/X-red.png").getImage();
			g.drawImage(image, this.getWidth()/4, this.getHeight()/4, 100, 100, this);
		} else if (filled == 2) {
			Image image = new ImageIcon("images/O-green.png").getImage();
			g.drawImage(image, this.getWidth()/4, this.getHeight()/4, 100, 100, this);
		}
	}
	/**
	 * this method gets the filled value
	 * @return int specifies current value of filled for a given box
	 */
	public int getFilled() {
		return filled;
	}
	/**
	 * this method sets filled to 0, 1, or 2. called before repaint()
	 * @param filled value specifies what to draw. 
	 */
	public void setFilled(int filled) {
		this.filled = filled;
	}
}
