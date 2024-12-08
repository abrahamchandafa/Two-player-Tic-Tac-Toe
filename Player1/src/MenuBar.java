import java.awt.event.*;
import java.io.PrintWriter;
import java.awt.*;

import javax.swing.*;
/**
 * This class handles the components on MenuBar
 * @author abraham chandafa
 * @version 1.0
 */
public class MenuBar extends JMenuBar {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * control menu
	 */
	JMenu control;
	/**
	 * help menu
	 */
	JMenu help;
	/**
	 * exit menu item
	 */
	JMenuItem exit;
	/**
	 * instructions menu item
	 */
	JMenuItem instructions;
	/**
	 * for sending messages
	 */
	PrintWriter writerObj;
	/**
	 * MenuBar object constructor
	 * @param writer for sending messages
	 */	
	public MenuBar(PrintWriter writer) {
		super();
		writerObj = writer;
		control = new JMenu("Control");
        control.setFont(new Font("Arial", Font.BOLD, 15));
		help = new JMenu("Help");
        help.setFont(new Font("Arial", Font.BOLD, 15));
		exit = new JMenuItem("Exit");
        exit.setFont(new Font("Arial", Font.BOLD, 15));
		instructions = new JMenuItem("Instructions");
        instructions.setFont(new Font("Arial", Font.BOLD, 15));
		
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				writer.println("1,0,-1");
				writer.flush();
				try {
					Thread.sleep(10);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				System.exit(0);
			}
		});
		
		instructions.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog dialog = new JDialog();
                dialog.setTitle("Instructions");
                dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                
                dialog.setLayout(new GridBagLayout());
                GridBagConstraints gbc = new GridBagConstraints();
                
                JLabel helpIcon = new JLabel(UIManager.getIcon("OptionPane.informationIcon"));
                gbc.gridx = 0; 
                gbc.gridy = 0; 
                gbc.gridheight = 2;
                gbc.insets = new Insets(10, 10, 10, 10);
                gbc.anchor = GridBagConstraints.NORTHWEST;
                dialog.add(helpIcon, gbc);
                
				JPanel myText = new JPanel();
				myText.setLayout(new GridBagLayout());
				
	            String[] lines = {
	                    "Some information about the game:",
	                    "",
	                    "Criteria for a valid move:",
	                    "- The move is not occupied by any mark.",
	                    "- The move is made in the player's turn.",
	                    "- The move is made within the 3 X 3 board.",
	                    "", 
	                    "The game would continue and switch among the opposite"
	                    + "player until it reaches "
	                    + "either one of the following conditions:",
	                    "- Player 1 wins.",
	                    "- Player 2 wins.",
	                    "- Draw.",
	                    "- One of the players leaves the game."
	            };
	            
	            
	            GridBagConstraints textGbc = new GridBagConstraints();
	            textGbc.gridx = 0;
	            textGbc.gridy = 0;
	            textGbc.anchor = GridBagConstraints.WEST;
	            textGbc.insets = new Insets(2, 0, 2, 0);

	            for (String line : lines) {
                    JLabel label = new JLabel(line);
                    label.setFont(new Font("Arial", Font.BOLD, 15));
                    myText.add(label, textGbc);
                    textGbc.gridy++;
	            }

	            gbc.gridx = 1;
	            gbc.gridy = 0; 
	            gbc.gridheight = 1; 
	            gbc.weightx = 1.0; 
	            gbc.weighty = 1.0; 
	            gbc.fill = GridBagConstraints.BOTH;
	            gbc.insets = new Insets(10, 10, 10, 10);
	            gbc.anchor = GridBagConstraints.CENTER;
	            dialog.add(myText, gbc);
            
            
				JButton yesB = new JButton("YES");
				yesB.addActionListener(ev -> dialog.dispose());        
				
				gbc.gridx = 0; 
		        gbc.gridy = 1; 
		        gbc.gridwidth = 2; 
		        gbc.gridheight = 1; 
		        gbc.weightx = 0; 
		        gbc.weighty = 0; 
		        gbc.insets = new Insets(10, 10, 10, 10);
		        gbc.anchor = GridBagConstraints.CENTER;
		        dialog.add(yesB, gbc);
		        
	            dialog.pack();
	            dialog.setPreferredSize(new Dimension(dialog.getPreferredSize().width + 20, dialog.getPreferredSize().height)); 
	            dialog.setSize(dialog.getPreferredSize());
	            dialog.setLocationRelativeTo(null);
				dialog.setVisible(true);
			}
		});
		
		help.add(instructions);
		control.add(exit);
		add(control);
		add(help);	
	}
}
