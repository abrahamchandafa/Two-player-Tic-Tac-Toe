import java.awt.Font;
import javax.swing.*;
/**
 * This class handles the component below the menubar,
 * where "enter your name", "welcome", "valid move" etc appear.
 * @author abraham chandafa
 * @version 1.0
 */
public class North extends JPanel {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * caption for asking to enter name, and gameplay actions
	 */
	private JLabel caption;
	/**
	 * North constructor
	 */
	public North() {
		caption = new JLabel("Enter your player name...");
		caption.setFont(new Font("Arial", Font.BOLD, 15));
		add(caption);		
	}
	/**
	 * this method updates the caption (not always a playerName, but 
	 * includes the gameplay comments as well (e.g valid move etc)
	 * @param newCap is the new caption
	 */
	public void setCaption(String newCap) {
		caption.setText(newCap);
	}
	/**
	 * this method returns the caption 
	 * @return String returns the caption
	 */
	public String getCaption() {
		return caption.getText();
	}
}
