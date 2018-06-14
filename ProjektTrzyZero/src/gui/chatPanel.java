package gui;

import java.awt.Font; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import net.Broadcast;
import net.Config;
import net.miginfocom.swing.MigLayout;

public class chatPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextField textField = new JTextField();
	JTextArea textArea = new JTextArea();
	JButton sendButton = new JButton("SEND");
	//JScrollPane areaScrollPane = new JScrollPane(textArea);	
	
	String textFieldValue = "";
	String youString = "You:";
	String cilentIP = "";
	
	public void sendText(User user) throws IOException, IOException {
		textFieldValue = textField.getText();
 	   	textArea.append(youString + "  " +  textFieldValue + "\n");     
 	   	textField.setText("");
 	   	Broadcast.send_message(textFieldValue, InetAddress.getByName( user.getIP()), (int) user.getPort());
 	   	
	};	
	
	
	
	public void writeText(String message) throws IOException, IOException {			
		//String message = textField.getText();
 	   //	textArea.append(user.getLogin() + "  " +  message + "\n");      	   	   	
	};	
	
	public chatPanel(User user) {			
		textArea.setEditable(false);
		textArea.setFont(new Font("Serif", Font.ITALIC, 16));
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);	
		
		//areaScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		cilentIP = user.getIP();
		
		sendButton.addActionListener(new ActionListener(){   
            public void actionPerformed(ActionEvent e) {
            	    try {
						sendText(user);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}            	          	
            	}
			});		
		
        textField.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    	 try {
							sendText(user);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}      
                    }
                }
            });
         
        setLayout(new MigLayout("", "[] []","[] []"));	
		add(textArea,"width 96%, height 90%,span");
		//add(areaScrollPane,"width 4%, height 90%, wrap, span");
		add(textField,"width 80%, height 10%");
		add(sendButton,"width 20%, height 10%, wrap, span");		
	}
	
	public String getClientLogin() {
		return cilentIP;
	}
	
	
	
}
