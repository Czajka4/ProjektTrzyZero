package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import net.miginfocom.swing.MigLayout;




public class MainPanelRight extends JPanel {

	/**
	 * 
	 */	
	private static final long serialVersionUID = 1L;

	JTextField loginField = new JTextField("Random");
	JLabel loginLabel = new JLabel("My Login:");	
	JRadioButton onlineButton = new JRadioButton("ONLINE");
	
	public MainPanelRight() {
		setBackground(Color.WHITE);
		setBorder(new LineBorder(Color.BLACK, 5));
		
		loginLabel.setFont(new Font("Arial", Font.ITALIC, 20));	
		
	    setLayout(new MigLayout("", "[] []",""));	
	    add(loginLabel,"width 30%, height 5%,");
		add(loginField,"width 50%, height 5%, span");		
		add(onlineButton,"width 50%, height 5%");		
	}
	
	public String GetMyLogin() {
		return loginField.getText();
	}
}
