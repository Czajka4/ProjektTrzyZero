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
	
	List<chatPanel> panelList = new ArrayList<chatPanel>(32);
	int nn = 0;

	// add your JPanel object like this way
	//panelList.add(yourPanel);

	// retrieve your JPanel object from list
	//JPanel panel = panelList.get(index);
	
	//panelList.get(1) = tab1;
	//addTab("user1", panelList.get(1));	
		
	public MainTabbedPane() {			
	}
	
	public void addTab(User user) {
		panelList.add(new chatPanel(user));
		addTab(user.getLogin(), panelList.get(nn));
		nn++;
	}
	
	
	
	
	
	
	
	
	
}
