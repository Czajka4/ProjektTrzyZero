package gui;

import java.awt.Color; 
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import net.miginfocom.swing.MigLayout;

public class EnterNameFrame extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextField nameField;
	
	public EnterNameFrame() {
		this.setSize(300, 100);
		this.setAlwaysOnTop(true);
		this.setLocation(400, 400);
		this.setTitle("ENTER YOUR NAME");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(new MigLayout("","[]", ""));	
		
		nameField = new JTextField();
		nameField.setBorder(new LineBorder(Color.BLACK, 5));
		nameField.setFont(new Font("Arial", Font.ITALIC, 22));	
		nameField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                	String UserName = nameField.getText();   
                	MainPanelRight.loginField.setText(UserName);
                }
            }
        });
	
     this.add(nameField, "width 100%, height 100%, span");
		
		
	}

}
