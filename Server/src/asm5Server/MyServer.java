package asm5Server;
import java.io.*;
import java.net.*;
import java.util.*;
/**
 * This class handles the server
 * @author abraham chandafa
 * @version 1.0
 */
public class MyServer {
	/**
	 * Stores PrintWriters for all clients
	 */
	ArrayList<PrintWriter> clientOutputStreams;
	/**
	 *  To keep track of sockets
	 */
    ArrayList<Socket> clientSockets;
	/**
	 * Main method
	 * @param args unused.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyServer().go();
	}
	/**
	 * all the logic starts here
	 */
	public void go() {
		clientOutputStreams = new ArrayList<PrintWriter>();
		clientSockets = new ArrayList<Socket>();
		try {
			@SuppressWarnings("resource")
			ServerSocket serverSock = new ServerSocket(7777);
			
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                System.out.println("Shutting down server...");
                closeServer();
            }));
			
			while (true) {
				Socket clientSocket = serverSock.accept();
				PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
				clientOutputStreams.add(writer);
				clientSockets.add(clientSocket);
				
				Thread thr = new Thread(new ClientHandler(clientSocket));
				thr.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * For sending messages to all clients
	 * @param message replicates whatever message was received to broadcast it
	 */
	public void myBroadcast(String message) {
		Iterator<PrintWriter> it = clientOutputStreams.iterator();
		while(it.hasNext()) {
			PrintWriter writer = it.next();
			writer.println(message);
			writer.flush();
		}
	}
    /**
     * Close the server and all client connections
     */
    private void closeServer() {
        try {
            for (PrintWriter writer : clientOutputStreams) {
                writer.close(); 
            }
            for (Socket sock : clientSockets) {
                sock.close(); 
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Server closed.");
    }
	/**
	 * This class is for a listening thread.
	 * @author abraham chandafa
	 * @version 1.0
	 */
	public class ClientHandler implements Runnable {
		/**
		 * for receiving messages
		 */
		BufferedReader reader;
		/**
		 * for accepting new connections
		 */
		Socket sock;
		
		/**
		 * Constructor for our class
		 * @param clientSocket takes an individual socket and starts reading from it
		 */
		public ClientHandler (Socket clientSocket) {
			try {
				sock = clientSocket;
				reader = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		/**
		 * For listening thread
		 * @Override
		 */
		public void run() {
			String message;
			try {
				while ((message = reader.readLine()) != null) {
					//System.out.println(message);
					myBroadcast(message);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					sock.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
			
	}
	

}
