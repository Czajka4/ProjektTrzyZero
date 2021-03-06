package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
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
	

	static JTextField loginField = new JTextField("");
	JLabel loginLabel = new JLabel("My Login:");
	JTextField ipField = new JTextField("192.168.1.1");
	JLabel ipLabel = new JLabel("My IP:   ");
	JRadioButton onlineButton = new JRadioButton("ONLINE");
	UsersTable usersTable = new UsersTable();
	JButton refreshButton = new JButton("REFRESH");

	
	public MainPanelRight() {
		setBackground(Color.WHITE);
		setBorder(new LineBorder(Color.BLACK, 5));
		
		loginLabel.setFont(new Font("Arial", Font.ITALIC, 22));	
		ipLabel.setFont(new Font("Arial", Font.ITALIC, 22));	
		loginField.setFont(new Font("Arial", Font.ITALIC, 22));	
		ipField.setFont(new Font("Arial", Font.ITALIC, 22));	
		ipField.setEditable(false);
		onlineButton.setBorder(new LineBorder(Color.BLACK, 5));
		
		
		refreshButton.addActionListener(new ActionListener(){   
            public void actionPerformed(ActionEvent e) {
            	       UsersTable.RefreshTable();         	          	
            	}
			});				
		
		 setLayout(new MigLayout("", "[] []","[] [] [] [] []"));	
	    add(loginLabel,"width 30%, height 6%,");
		add(loginField,"width 65%, height 6%, span");	
		add(ipLabel,"width 30%, height 5%,");
		add(ipField,"width 65%, height 5%, span");	
		add(onlineButton,"width 100%, height 5%, span");	
		add(usersTable,"width 100%, height 70%, span");
		add(refreshButton,"width 30%, height 5%, center");
	}
	
	public static String GetMyLogin() {
		return loginField.getText();
	}
	public void setIpe(String ipe) {
		ipField.setText(ipe);
	}
	
	public void addUser(User user) {
		UsersTable.addUserToTable(user);		
		}
	
	
}

	

