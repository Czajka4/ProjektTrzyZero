package gui;

import java.net.InetAddress;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.UDPServer;

public class UsersTable extends JTable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	static DefaultTableModel dtm = new DefaultTableModel(0, 0);
	
	static User newUser;
	public String userName;
	InetAddress userIP;
	public int userPort = 0;
	
	
	
	
	
	public UsersTable() {
	ArrayList<User> UsersList = new ArrayList<User>(32);
		
		
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
					 
					  userName = (String) getValueAt(row,0);
					  userIP =  (InetAddress) getValueAt(row,1);
					  userPort =   (int) getValueAt(row,2);
					  newUser = new User(userName, userIP, userPort);
					  MainPanelLeft.addTabs(newUser);
					  System.out.println(userName);
				  }
				 } 
		 });
	}
	public static void addUserToTable(User newUser) {		
		 dtm.addRow(new Object[] { newUser.getLogin(), newUser.getIP(), newUser.getPort()});
				
	}
		
	public static void RefreshTable() {
		ArrayList<User> UsersList2 = new ArrayList<User>(32);
	
		UsersList2 = UDPServer.sendUserData();
		  
		for(int ii = 0; ii<UsersList2.size(); ii++) {
			newUser = UsersList2.get(ii);
			addUserToTable(newUser);	
	}
	}
		
	public String userName() {
			return userName;
	}
	}
		
	


