package gui;

import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTabbedPane;

public class MainTabbedPane extends JTabbedPane {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static List<chatPanel> panelList = new ArrayList<chatPanel>(32);
			
	public MainTabbedPane() {			
	}
	
	public  void addTabe(User user) {
		panelList.add(new chatPanel(user));
		int nn = panelList.size() - 1;
		addTab(user.getLogin(), panelList.get(nn));
		
	}
	
	public static void writeMessage(String IP, String message) throws IOException {
		
		InetAddress clientIP;
		for(int ii=0; ii<panelList.size(); ii++) {		
			clientIP = panelList.get(ii).getClientIP();
			if(clientIP.toString().equals(IP)) {
				panelList.get(ii).writeText(message);				
			}
			else {
				
				//MainPanelLeft.addTabs(new User( "NewClient",  panelList.get(ii).getClientIP(),  9000));
				
			}
		}
		
		
	}
	
	
	
	
	
	
	
}
