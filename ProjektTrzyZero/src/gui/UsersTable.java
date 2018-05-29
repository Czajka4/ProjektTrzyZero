package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class UsersTable extends JTable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static DefaultTableModel model;
	
	public UsersTable() {
		
 Object[] columns = {"User Login","IP","x","x"}; 
		 
	     model = new DefaultTableModel(); 
	     model.setColumnIdentifiers(columns);
	     setModel(model);						//Setting default model of table
	     setDefaultEditor(Object.class, null);
	     
	     // Table look //
	     setBackground(Color.LIGHT_GRAY);
	     setForeground(Color.black);
	     Font font = new Font("",1,14);
	     setFont(font);
	     setRowHeight(15);
	     setVisible(true);
	     
	}
		
		
		
	}


