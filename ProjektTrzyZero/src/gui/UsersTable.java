package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class UsersTable extends JTable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	DefaultTableModel dtm = new DefaultTableModel(0, 0);
	public boolean status = false;
	public String userName, userIP = "";
	public double userPort = 0;
	User newUser;
	public UsersTable() {
		
		
		
		// add header of the table
		String header[] = new String[] { "User", "IP", "Port"};

		// add header in table model     
		 dtm.setColumnIdentifiers(header);		  									
		  this.setModel(dtm);	
		  
		  dtm.addRow(new Object[] { "JP2", "192.420.69.xD", "2137"});
		  
		  addMouseListener(new java.awt.event.MouseAdapter(){
			  public void mouseClicked(java.awt.event.MouseEvent e){
				  int row = rowAtPoint(e.getPoint());
				  status = true;
				  userName = (String) getValueAt(row,0);
				  userIP =  (String) getValueAt(row,1);
				  userPort = (double) getValueAt(row,2);
				  newUser = new User(userName, userIP, userPort);
				  MainFrame.leftPanel.addTabe(newUser);
				  System.out.println(userName);
				  } 
		 });
	}
	public void addUserToTable(User newUser) {		
		 dtm.addRow(new Object[] { newUser.getLogin(), newUser.getIP(), newUser.getPort()});
				
	}
		

		
	public boolean getStatus() {
		return status;
	}
	public String userName() {
			return userName;
	}
	}
		
	


