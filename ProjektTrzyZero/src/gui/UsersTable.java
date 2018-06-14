package gui;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import net.UDPServer;

public class UsersTable extends JTable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	static DefaultTableModel dtm = new DefaultTableModel(0, 0);
	public boolean status = false;
	public String userName, userIP = "";
	public double userPort = 0;
	static User newUser;
	
	
	
	public UsersTable() {
	ArrayList<User> UsersList = new ArrayList(32);
		
		
		// add header of the table
		String header[] = new String[] { "User", "IP", "Port"};

		// add header in table model     
		 dtm.setColumnIdentifiers(header);		  									
		  this.setModel(dtm);	
		  
		  UsersList = UDPServer.sendUserData();
		  
		for(int ii = 0; ii<UsersList.size(); ii++) {
			newUser = UsersList.get(ii);
			addUserToTable(newUser);
		}
		  
		  addMouseListener(new java.awt.event.MouseAdapter(){
			  public void mouseClicked(java.awt.event.MouseEvent e){
				  if(getRowCount() != 0) {
					  int row = rowAtPoint(e.getPoint());
					  status = true;
					  userName = (String) getValueAt(row,0);
					  userIP =  (String) getValueAt(row,1);
					  userPort = (double) getValueAt(row,2);
					  newUser = new User(userName, userIP, userPort);
					  MainFrame.leftPanel.addTabe(newUser);
					  System.out.println(userName);
				  }
				 } 
		 });
	}
	public static void addUserToTable(User newUser) {		
		 dtm.addRow(new Object[] { newUser.getLogin(), newUser.getIP(), newUser.getPort()});
				
	}
		
	public static void RefreshTable() {
		ArrayList<User> UsersList2 = new ArrayList(32);
	
		UsersList2 = UDPServer.sendUserData();
		  
		for(int ii = 0; ii<UsersList2.size(); ii++) {
			newUser = UsersList2.get(ii);
			addUserToTable(newUser);	
	}
	}
		
	public boolean getStatus() {
		return status;
	}
	public String userName() {
			return userName;
	}
	}
		
	


