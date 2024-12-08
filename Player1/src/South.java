import java.awt.Font;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;
/**
 * This class handles the components on the South, i.e 
 * field for name entering, submit button, and current time.
 * @author abraham chandafa
 * @version 1.0
 */
public class South extends JPanel {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * holds nameField and submit
	 */
	JPanel southOne; 
	/**
	 * holds current time
	 */
	JPanel southTwo;
	/**
	 * "enter your name" label
	 */
	JLabel nameLabel;
	/**
	 * field to enter your name
	 */
	JTextField nameField;
	/**
	 * submit button
	 */
	JButton submit;
	/**
	 * time label
	 */
	JLabel timeText;
	/**
	 * this is a constructor for South
	 * @param submitNameListener handles the behavior
	 * when user presses enter after writting their name
	 */
	public South (ActionListener submitNameListener) {
		super();
		southOne = new JPanel();
		southTwo = new JPanel();

		nameLabel = new JLabel("Enter your name:");
		nameLabel.setFont(new Font("Arial", Font.BOLD, 18));
		nameField = new JTextField(20);
		nameField.setFont(new Font("Arial", Font.BOLD, 18));
		nameField.addActionListener(submitNameListener);
		submit = new JButton("Submit");
		submit.addActionListener(submitNameListener);
		southOne.add(nameLabel);
		southOne.add(nameField);
		southOne.add(submit);
		
		timeText = new JLabel("");
		timeText.setFont(new Font("Arial", Font.BOLD, 18));
		Timer timer = new Timer (1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ev) {
				updateTime();
			}
		});
		timer.start();
		updateTime();
		southTwo.add(timeText);
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(southOne);
		add(southTwo);
	}
	/**
	 * this method keeps the clock ticking... current time
	 */
	public void updateTime() {
		String now = new SimpleDateFormat("HH:mm:ss").format(new Date());
		timeText.setText("Current Time: "+now);
	}
	/**
	 * this method gets the name inputted by user
	 * @return String returns the name put by user
	 */
	public String getName() {
		return nameField.getText().strip();
	}
	/**
	 * this method disables submit button as well as nameField
	 */
	public void disableInputs() {
		// TODO Auto-generated method stub
		submit.setEnabled(false);
		nameField.setEnabled(false);
	}
}
