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
	public static  MainPanelRight rightPanel;			
	static boolean status;
	public User newUser;
	public static EnterNameFrame nameFrame;
	static int num_of_tabs;
	



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
		
	
	
	
	// MAIN MMMMMMMMMMMMMMMMMMMMMMMM
	
	public static void main(String[] args) throws Exception {
			
			
		
					
		Broadcast mySocket = new Broadcast(); // stworzenie socketa do s�uchania od ziom�w
		UDPServer broadcastListener = new UDPServer(9000);// creating a server to listen to new users
		
		
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		ExecutorService executorService2 = Executors.newFixedThreadPool(10);
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
		
		
		executorService.submit(broadcast); //w��czenie nas�uchiwania innych u�ytkownik�w
		executorService2.submit(connection); //nas�uchiwanie rozm�w
		
		nameFrame = new EnterNameFrame();
		nameFrame.setVisible(true);
		String testName = MainPanelRight.GetMyLogin();
		
		while(testName.equals("")) {
			Thread.sleep(50);
			testName = MainPanelRight.GetMyLogin();
		}
		mySocket.hello(); // wys�anie wiadomo�ci ze swoim nickiem
		//Scanner keyboard = new Scanner(System.in); 
		//System.out.println("wci�nij enter"); //wci�nij enter gdy pod��czy si� ju� drugi ziomek
		//keyboard.nextLine();
		
		Thread.sleep(10);
		mFrame = new MainFrame();//Creating Frame ( application )
		mFrame.setVisible(true);
		mFrame.setResizable(false);
		mFrame.rightPanel.setIpe(Config.IP_ADDRESS+"");
		
		
		
		while(true)
		{
			Thread.sleep(2000);
			if(broadcastListener.send_hello == true)
			{
				
				
				mySocket.hello();
				broadcastListener.send_hello = false;
				System.out.println("wysyłam heloł");
			}
			
			//System.out.println("Mozesz pisacc z:" + broadcastListener.existingClients.get(1)); // 0 to ty sam -- nast�pne to inni u�ytkownicy
			//String wiadomosc = keyboard.nextLine();
		//	mySocket.send_message(wiadomosc, broadcastListener.clientAddresses.get(1), broadcastListener.clientPorts.get(1));			
			
			
			// Elo, zrobić tak trzeba, że do tej definicji na dole się wpisze loign ip i port
			// User newUser = new User(userLogin, userIP, userPort);
			// Jak już będę miał tego usera z wpisanymi jego danymi to się mogę bawić w dodawanie go,
			// sprawdzanie czy juz taki jest, usuwanie go.
			// Spróbuj wymyślić funckje która dostaje wiadomosc adres ip i port i wysyla ja tam elo
			
		}	
	}			
	}
