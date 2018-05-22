package gui;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import net.miginfocom.swing.MigLayout;

public class MainPanelLeft extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MainPanelLeft() {
		setLayout(new MigLayout());
		setBackground(Color.WHITE);
		setBorder(new LineBorder(Color.BLACK, 5));
	
		MainTabbedPane tabbedPane = new MainTabbedPane(); //pane with cards with chatting users
		add(tabbedPane,"width 100%, height 100%");
		
		
		
		
	
	}
}
