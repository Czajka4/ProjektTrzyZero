package gui;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JLabel;

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



	 
	 
	               

		
		
		public static void main(String[] args) {
		mFrame = new MainFrame();//Creating Frame ( application )
		mFrame.setVisible(true);
		mFrame.setResizable(false);
		

		}
	}
