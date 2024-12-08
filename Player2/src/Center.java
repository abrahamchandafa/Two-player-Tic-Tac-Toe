import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;
/**
 * This class handles the components on the Board, i.e 
 * the rendering, as well as the gameplay logic.
 * @author abraham chandafa
 * @version 1.0
 */
public class Center extends JPanel {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * prevents user from playing if user should not play
	 * e.g. when name not submitted, when computer playing,
	 * when move is invalid etc
	 */
	private boolean canPlay = false;
	/**
	 * enforces checking name input
	 */
	public boolean hasPutName = false;
	/**
	 * keeps track of moves, to cause draw if moves are 9 and no winner
	 */
	private int moveCount = 0;
	/**
	 * the North object
	 */
	North nObj;
	/**
	 * the North object caption
	 */
	private String nObjCaption;
	/**
	 * the East object
	 */
	East eObj;
	/**
	 * how many times player has won
	 */
	private int playerWins = 0;
	/**
	 * how many times Computer has won
	 */
	private int computerWins = 0;
	/**
	 * how many draws
	 */
	private int draws = 0;
	/**
	 * keeps track of available boxes, and helps check for winner
	 */
	int [] gamePlay = {0,0,0,
					   0,0,0,
					   0,0,0};
	/**
	 * box1
	 */
	Box box1;	
	/**
	 * box2
	 */
	Box box2;	
	/**
	 * box3
	 */ 
	Box box3; 	
	/**
	 * box4
	 */
	Box box4; 	
	/**
	 * box5
	 */
	Box box5;	
	/**
	 * box6
	 */ 
	Box box6; 	
	/**
	 * box7
	 */
	Box box7;	
	/**
	 * box8
	 */ 
	Box box8; 	
	/**
	 * box9
	 */
	Box box9;
	/**
	 *  for sending messages
	 */
	PrintWriter writerObj;
	/**
	 * a constructor for Center object
	 * @param n, a North object for communicating with center
	 * @param east, an East object for communicating with center
	 * @param writer, for sending messages
	 */
	public Center(North n, East east, PrintWriter writer) {
		super();
		nObj = n;
		eObj = east;
		writerObj = writer;
		box1 = new Box(); 
		box2 = new Box(); 
		box3 = new Box(); 
		box4 = new Box(); 
		box5 = new Box(); 
		box6 = new Box(); 
		box7 = new Box(); 
		box8 = new Box(); 
		box9 = new Box(); 
		
        Dimension preferredSize = new Dimension(220, 170);
        box1.setPreferredSize(preferredSize);
        box2.setPreferredSize(preferredSize);
        box3.setPreferredSize(preferredSize);
        box4.setPreferredSize(preferredSize);
        box5.setPreferredSize(preferredSize);
        box6.setPreferredSize(preferredSize);
        box7.setPreferredSize(preferredSize);
        box8.setPreferredSize(preferredSize);
        box9.setPreferredSize(preferredSize);
        
        box1.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if (hasPutName && canPlay && box1.getFilled() == 0) {
					box1.setFilled(2);
					gamePlay[0] = 2;
					box1.repaint();
					setMoveCount(getMoveCount() + 1);
					writerObj.println("2,0,0");
					writerObj.flush();
					setPlay(false);
					nObj.setCaption("Valid move, wait for your opponent.");
					checkGameStatus();
				}	
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub	
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub	
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub	
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub		
			}

        });
        box2.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if (hasPutName && canPlay && box2.getFilled() == 0) {
					box2.setFilled(2);
					gamePlay[1] = 2;
					box2.repaint();
					setMoveCount(getMoveCount() + 1);
					writerObj.println("2,1,0");
					writerObj.flush();
					setPlay(false);
					nObj.setCaption("Valid move, wait for your opponent.");
					checkGameStatus();
				}
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub		
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub		
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub			
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub		
			}

        });
        box3.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if (hasPutName && canPlay && box3.getFilled() == 0) {
					box3.setFilled(2);
					gamePlay[2] = 2;
					box3.repaint();
					setMoveCount(getMoveCount() + 1);
					writerObj.println("2,2,0");
					writerObj.flush();
					setPlay(false);
					nObj.setCaption("Valid move, wait for your opponent.");
					checkGameStatus();
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub			
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub		
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub		
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub			
			}

        });
        box4.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if (hasPutName && canPlay && box4.getFilled() == 0) {
					box4.setFilled(2);
					gamePlay[3] = 2;
					box4.repaint();
					setMoveCount(getMoveCount() + 1);
					writerObj.println("2,3,0");
					writerObj.flush();
					setPlay(false);
					nObj.setCaption("Valid move, wait for your opponent.");
					checkGameStatus();
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub			
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub			
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub			
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub			
			}

        });
        box5.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if (hasPutName && canPlay && box5.getFilled() == 0) {
					box5.setFilled(2);
					gamePlay[4] = 2;
					box5.repaint();
					setMoveCount(getMoveCount() + 1);
					writerObj.println("2,4,0");
					writerObj.flush();
					setPlay(false);
					nObj.setCaption("Valid move, wait for your opponent.");
					checkGameStatus();
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub			
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub			
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub			
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub				
			}

        });
        box6.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if (hasPutName && canPlay && box6.getFilled() == 0) {
					box6.setFilled(2);
					gamePlay[5] = 2;
					box6.repaint();
					setMoveCount(getMoveCount() + 1);
					writerObj.println("2,5,0");
					writerObj.flush();
					setPlay(false);
					nObj.setCaption("Valid move, wait for your opponent.");
					checkGameStatus();
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub				
			}

        });
        box7.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if (hasPutName && canPlay && box7.getFilled() == 0) {
					box7.setFilled(2);
					gamePlay[6] = 2;
					box7.repaint();
					setMoveCount(getMoveCount() + 1);
					writerObj.println("2,6,0");
					writerObj.flush();
					setPlay(false);
					nObj.setCaption("Valid move, wait for your opponent.");
					checkGameStatus();
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub				
			}

        });
        box8.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if (hasPutName && canPlay && box8.getFilled() == 0) {
					box8.setFilled(2);
					gamePlay[7] = 2;
					box8.repaint();
					setMoveCount(getMoveCount() + 1);
					writerObj.println("2,7,0");
					writerObj.flush();
					setPlay(false);
					nObj.setCaption("Valid move, wait for your opponent.");
					checkGameStatus();
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub			
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub				
			}

        });
        box9.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if (hasPutName && canPlay && box9.getFilled() == 0) {
					box9.setFilled(2);
					gamePlay[8] = 2;
					box9.repaint();
					setMoveCount(getMoveCount() + 1);
					writerObj.println("2,8,0");
					writerObj.flush();
					setPlay(false);
					nObj.setCaption("Valid move, wait for your opponent.");
					checkGameStatus();
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub		
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub	
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub		
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub			
			}

        });
        		
		setLayout(new GridLayout(3,3, 2, 2));
		add(box1);
		add(box2);
		add(box3);
		add(box4);
		add(box5);
		add(box6);
		add(box7);
		add(box8);
		add(box9);
		setBackground(Color.black);
		setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
	}
	/**
	 * sets the value of canPlay
	 * @param b, allow or disallow player to play
	 */
	public void setPlay(boolean b) {
		this.canPlay = b;
	}
	/**
	 * handles computerPlay logic
	 * @param message contains what was sent from server
	 */
	public void opponentPlay(String message) { //player, move (0-8), exit(1 exit, 0 no exit);
		String[] inbox = message.split(",");
    	int index = Integer.parseInt(inbox[1]);
		if (inbox[0].equals("1")) { 
			if (inbox[2].equals("-1")) { 
		        JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
		        Icon helpIcon = UIManager.getIcon("OptionPane.informationIcon");

		        int response = JOptionPane.showOptionDialog(parentFrame, 
		                "Game Ends. One of the players left", 
		                "Game Over", 
		                JOptionPane.YES_NO_OPTION,
		                JOptionPane.INFORMATION_MESSAGE, 
		                helpIcon, 
		                new Object[]{"OKAY"}, 
		                "OKAY");

		        if (response == JOptionPane.YES_OPTION) {
		            System.exit(0);
		        }
			} else {
				int cont = checkGameStatus();
				if (cont == -1) {
					gamePlay[index] = 1;
		        	if (index == 0) {
		    			box1.setFilled(1);
		    			gamePlay[0] = 1;
		    			box1.repaint();
		        	} else if (index == 1) {
		    			box2.setFilled(1);
		    			gamePlay[1] = 1;
		    			box2.repaint();
		        	} else if (index == 2) {
		    			box3.setFilled(1);
		    			gamePlay[2] = 1;
		    			box3.repaint();
		        	} else if (index == 3) {
		    			box4.setFilled(1);
		    			gamePlay[3] = 1;
		    			box4.repaint();
		        	} else if (index == 4) {
		    			box5.setFilled(1);
		    			gamePlay[4] = 1;
		    			box5.repaint();
		        	} else if (index == 5) {
		    			box6.setFilled(1);
		    			gamePlay[5] = 1;
		    			box6.repaint();
		        	} else if (index == 6) {
		    			box7.setFilled(1);
		    			gamePlay[6] = 1;
		    			box7.repaint();
		        	} else if (index == 7) {
		    			box8.setFilled(1);
		    			gamePlay[7] = 1;
		    			box8.repaint();
		        	} else if (index == 8) {
		    			box9.setFilled(1);
		    			gamePlay[8] = 1;
		    			box9.repaint();
		        	}
					setMoveCount(getMoveCount() + 1);
					nObj.setCaption("Your opponent has moved, now is your turn.");
		            setPlay(true);
					checkGameStatus();
				} else {
					setPlay(true);
				}
			}
		}
		
	}
	/**
	 * this method gets moveCount
	 * @return int is the moveCount
	 */
	public int getMoveCount() {
		return moveCount;
	}
	/**
	 * this method updates the moveCount
	 * @param moveCount is the new value of moveCount
	 */
	public void setMoveCount(int moveCount) {
		this.moveCount = moveCount;
	}
	/**
	 * this method checks game status after every move
	 * @return int whether or not game has ended
	 */
	public int checkGameStatus() {

		int result = -1; // 1 for player 1, 2 for player 2 win, 3 for draw
		if (gamePlay[0] != 0 && gamePlay[0] == gamePlay[3] && gamePlay[0] == gamePlay[6]) {
			result = (gamePlay[0] == 1)? 1 : 2;
		} else if (gamePlay[1] != 0 && gamePlay[1] == gamePlay[4] && gamePlay[1] == gamePlay[7]) {
			result = (gamePlay[1] == 1)? 1 : 2;
		} else if (gamePlay[2] != 0 && gamePlay[2] == gamePlay[5] && gamePlay[2] == gamePlay[8]) {
			result = (gamePlay[2] == 1)? 1 : 2;
		} else if (gamePlay[0] != 0 && gamePlay[0] == gamePlay[1] && gamePlay[1] == gamePlay[2]) {
			result = (gamePlay[0] == 1)? 1 : 2;
		} else if (gamePlay[3] != 0 && gamePlay[3] == gamePlay[4] && gamePlay[4] == gamePlay[5]) {
			result = (gamePlay[3] == 1)? 1 : 2;
		} else if (gamePlay[6] != 0 && gamePlay[6] == gamePlay[7] && gamePlay[7] == gamePlay[8]) {
			result = (gamePlay[6] == 1)? 1 : 2;
		} else if (gamePlay[0] != 0 && gamePlay[0] == gamePlay[4] && gamePlay[4] == gamePlay[8]) {
			result = (gamePlay[0] == 1)? 1 : 2;
		} else if (gamePlay[2] != 0 && gamePlay[2] == gamePlay[4] && gamePlay[4] == gamePlay[6]) {
			result = (gamePlay[2] == 1)? 1 : 2;
		} else if (getMoveCount() == 9) {
			result = 3;
		}
		// if result is not -1, we end game
		if (result != -1) {
			
			String message;
	        if (result == 2) { // player won
	            message = "Congratulations. You won! Do you want to play again?";
				setComputerWins(getComputerWins() + 1);			
	        } else if (result == 1) { // computer won
	            message = "You lose. Do you want to play again?";
				setPlayerWins(getPlayerWins() + 1);
	        } else { // draw
	            message = "It's a draw! Play again?";
				setDraws(getDraws() + 1);
	        }
	        JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
	        Icon helpIcon = UIManager.getIcon("OptionPane.informationIcon");

	        int response = JOptionPane.showOptionDialog(parentFrame, 
	                message, 
	                "Game Over", 
	                JOptionPane.YES_NO_OPTION,
	                JOptionPane.INFORMATION_MESSAGE, 
	                helpIcon, 
	                new Object[]{"YES", "NO"}, 
	                "YES");

	        if (response == JOptionPane.YES_OPTION) {
	    		setPlay(false);
	            gameClearUp();
	        } else {
	        	// exit
	        	writerObj.println("2,0,-1");
	        	writerObj.flush();
	        	try {
					Thread.sleep(15);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
	        	System.exit(0);
	        }	
			eObj.updateScore(getPlayerWins(), getComputerWins(), getDraws());			
		}
		return result;
	}
	/**
	 * this method gets number of playerWins
	 * @return int how many times player has won
	 */
	public int getPlayerWins() {
		return playerWins;
	}
	/**
	 * this method updates number of playerWins
	 * @param playerWins new value of playerWins
	 */
	public void setPlayerWins(int playerWins) {
		this.playerWins = playerWins;
	}
	/**
	 * this method gets number of computerWins
	 * @return int how many times computer has won
	 */
	public int getComputerWins() {
		return computerWins;
	}
	/**
	 * this method updates number of computerWins
	 * @param computerWins is the new value of computerWins
	 */
	public void setComputerWins(int computerWins) {
		this.computerWins = computerWins;
	}
	/**
	 * this method gets number of draws
	 * @return int how many times of draw game
	 */
	public int getDraws() {
		return draws;
	}
	/**
	 * this method updates number of draws
	 * @param draws is the new value of draws
	 */
	public void setDraws(int draws) {
		this.draws = draws;
	}
	/**
	 * this method gets the initial caption with name
	 * @return String initial caption
	 */
	public String getNObjCaption() {
		return nObjCaption;
	}
	/**
	 * this method updates the initial caption
	 * @param cap is the caption
	 */
	public void setNObjCaption(String cap) {
		this.nObjCaption = cap;
	}
	/**
	 * this method restarts the game, variables etc
	 */
	public void gameClearUp() {
		gamePlay[0] = 0;
		gamePlay[1] = 0;
		gamePlay[2] = 0;
		gamePlay[3] = 0;
		gamePlay[4] = 0;
		gamePlay[5] = 0;
		gamePlay[6] = 0;
		gamePlay[7] = 0;
		gamePlay[8] = 0;
		
		box1.setFilled(0);
		box1.repaint();
		
		box2.setFilled(0);
		box2.repaint();
		
		box3.setFilled(0);
		box3.repaint();
		
		box4.setFilled(0);
		box4.repaint();
		
		box5.setFilled(0);
		box5.repaint();
		
		box6.setFilled(0);
		box6.repaint();
		
		box7.setFilled(0);
		box7.repaint();
		
		box8.setFilled(0);
		box8.repaint();
		
		box9.setFilled(0);
		box9.repaint();
		
		setMoveCount(0);

		nObj.setCaption(nObjCaption);
		
		setPlay(false);
	}
}
