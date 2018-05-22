package gui;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

import net.miginfocom.swing.MigLayout;

public class MainTabbedPane extends JTabbedPane {
	
	List<JPanel> panelList = new ArrayList<JPanel>();

	// add your JPanel object like this way
	//panelList.add(yourPanel);

	// retrieve your JPanel object from list
	//JPanel panel = panelList.get(index);
	
	//panelList.get(1) = tab1;
	//addTab("user1", panelList.get(1));	
	
	chatPanel tab1,tab2;	
	public MainTabbedPane() {
		tab1 = new chatPanel();		
		addTab("user1", tab1);	
		
		
		tab2 = new chatPanel();	
		addTab("user2", tab2);
		
		
		
			
	}
	
	
	
	
	
	
	
	
	
	
	
}
