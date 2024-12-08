import java.awt.BorderLayout;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;
/**
 * This class handles the whole window display,
 * instantiating the other major classes, and the main JFrame
 * @author abraham chandafa
 * @version 1.0
 */
public class TicTacToe {
	/**
	 * the main frame
	 */
	JFrame frame;
	/**
	 * MenuBar object
	 */
	JMenuBar bar;
	/**
	 * North object
	 */
	North n;
	/**
	 * East object
	 */
	East e;
	/**
	 * South object
	 */
	South s;
	/**
	 * Center object
	 */
	Center c;
	/**
	 * MenuBar object
	 */
	MenuBar m;
	/**
	 * PrintWriter object
	 */
	PrintWriter writer;
	/**
	 * Socket object
	 */
	Socket sock;
	/**
	 * BufferedReader object for receiving messages
	 */
	BufferedReader reader;
	/**
	 * the no-argument constructor
	 */
	public TicTacToe() {
		
	}
	/**
	 * the main method of project
	 * @param args Unused.
	 */
	public static void main(String[] args) {
		TicTacToe game = new TicTacToe();		
		game.go();			
	}
	
	/**
	 * this method starts the game after its instantiated in the main method.
	 */
	public void go() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setUpNetworking();
		
		n = new North();
		e = new East();
		c = new Center(n,e, writer);
		m = new MenuBar(writer);
		s = new South(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = s.getName();
                if (!name.isEmpty()) {
                    n.setCaption("WELCOME " + name);
                    frame.setTitle("Tic Tac Toe - Player: " + name);
                    s.disableInputs();
                    c.setNObjCaption("WELCOME " + name);
                    c.hasPutName = true;
                    c.setPlay(true);
                }
            }
        });
		
		frame.setTitle("Tic Tac Toe");
		frame.setJMenuBar(m);

		frame.add(e, BorderLayout.EAST);
		frame.add(c, BorderLayout.WEST);
		frame.add(s, BorderLayout.SOUTH);
		frame.add(n, BorderLayout.NORTH);	
		
		Thread readerThread = new Thread(new IncomingReader());
		readerThread.start();
		
		frame.setSize(1000, 800);	
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}
	
	/**
	 * this method handles networking
	 */
	private void setUpNetworking(){
		try {
			sock = new Socket("127.0.0.1", 7777);
			writer = new PrintWriter(sock.getOutputStream());
			reader = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			System.out.println("(Player 1 says): networking established");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * This class is for a reader thread
	 * @author abraham chandafa
	 * @version 1.0
	 */
	public class IncomingReader implements Runnable {
		/**
		 * This method is run by thread
		 * @Override
		 */
		public void run() {
			String message;
			try {
				while ((message = reader.readLine()) != null) {
					//call opponent
					c.opponentPlay(message);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
