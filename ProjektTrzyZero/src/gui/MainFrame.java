package gui;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JFrame;
import javax.swing.JLabel;

import net.Broadcast;
import net.Config;
import net.UDPServer;
import net.miginfocom.swing.MigLayout;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;


	public static MainFrame mFrame;
	Dimension screenSize, leftPanelDim, labelDim, rightPanelDim; //definition of dimension of panels in main frame
	static Dimension addFrameDim; //dimension for small frame "adding charges"
	MainPanelTop topPanel;
	public static MainPanelLeft leftPanel; //panel where charges are display
	static MainPanelRight rightPanel;			
	





	public MainFrame() throws HeadlessException {
		setLayout(new MigLayout());
		setTitle("Projekt 3.0");
		setDefaultCloseOperation(EXIT_ON_CLOSE);




	// SETTING SIZE OF MAIN FRAME //////////////////////////////////////////////////////////

	 screenSize = Toolkit.getDefaultToolkit().getScreenSize();			
	//double leftPanelWidth =screenSize.height; unused by now
	double leftPanelHeight =0.7 * screenSize.height;
	 leftPanelDim = new Dimension((int) (leftPanelHeight * 1) , (int) (leftPanelHeight));	

	double labelHeight = 0.15 * screenSize.height;
	double lebelWidth = leftPanelHeight;
	labelDim = new Dimension((int)lebelWidth, (int) labelHeight);

	double rightPanelWidth = leftPanelHeight / 2;		
	double rightPanelHeight = leftPanelHeight + labelHeight;
	rightPanelDim = new Dimension((int) rightPanelWidth, (int) rightPanelHeight);	

	double addFrameHeight = 0.2 * rightPanelHeight;
	double addFrameWidth = 0.9 * rightPanelWidth;
	addFrameDim = new Dimension((int) addFrameWidth, (int) addFrameHeight);		


	leftPanel = new MainPanelLeft();
	rightPanel = new MainPanelRight();
	topPanel = new MainPanelTop();


	leftPanel.setPreferredSize(leftPanelDim);	//left panel will be always a square
	rightPanel.setPreferredSize(rightPanelDim);	
	topPanel.setPreferredSize(labelDim);




	// ADDING ELEMENTS OF MAIN FRAME ///////

	add(topPanel);
	add(rightPanel, "wrap, spany");
	add(leftPanel);		
	pack();	
	}

	////////////////////////////////////////



	static Dimension getAddFrameDim(){ 	//dimension of small frames - adding and deleting charges
		return addFrameDim;
	}



	 
	 
	               

		
		
	public static void main(String[] args) throws Exception {
		
		Broadcast mySocket = new Broadcast(); // stworzenie socketa do s³uchania od ziomów
		UDPServer broadcastListener = new UDPServer(9000);// creating a server to listen to new users
		
		
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		ExecutorService executorService2 = Executors.newFixedThreadPool(10);
		mFrame = new MainFrame();//Creating Frame ( application )
		Runnable broadcast = new Runnable() {
            @Override
            public void run() {

                
                	try {
                		broadcastListener.serwer();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                	
            }
           
		};
		Runnable connection = new Runnable() {
            @Override
            public void run() {

                
                	try {
                		mySocket.message_listener();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                	
            }
           
		};
		mFrame.setVisible(true);
		mFrame.setResizable(false);
		mFrame.rightPanel.setIpe(Config.IP_ADDRESS+"");
		
		executorService.submit(broadcast); //w³¹czenie nas³uchiwania innych u¿ytkowników
		executorService2.submit(connection); //nas³uchiwanie rozmów
		mySocket.hello(); // wys³anie wiadomoœci ze swoim nickiem
		Scanner keyboard = new Scanner(System.in); 
		System.out.println("wciœnij enter"); //wciœnij enter gdy pod³¹czy siê ju¿ drugi ziomek
		keyboard.nextLine();
		while(true)
		{
			
			System.out.println("Mo¿esz pisaæ z:" + broadcastListener.existingClients.get(1)); // 0 to ty sam -- nastêpne to inni u¿ytkownicy
			String wiadomoœæ = keyboard.nextLine();
			mySocket.send_message(wiadomoœæ, broadcastListener.clientAddresses.get(1), broadcastListener.clientPorts.get(1));
			
		}
		
		
		


		

		}
		
	}
