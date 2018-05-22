package gui;

import java.awt.Color; 
import java.awt.Component;
import java.awt.Font;
import java.awt.Label;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import net.miginfocom.swing.MigLayout;

public class MainPanelTop extends JPanel {
	

	//Panel with title and timer buttons

	/**
	 * 
	 */
	private static final long serialVersionUID = 4163362475437360265L;
	
	
	
	
	
	public MainPanelTop() {
		
	setLayout(new MigLayout("","[] []", "[] []"));	
	
	JLabel Title = new JLabel("Projekt 3.0 - Super LAN Chat");		
	Title.setHorizontalAlignment(SwingConstants.CENTER);
	Title.setFont(new Font("Tahoma", Font.BOLD, 40));		
	Title.setToolTipText("Authors: MIKOĹ�AJ CZAJKA $ KAROL SCHEWE");
	add(Title,"width 100%, height 100%, span,wrap");
	
	}
	
}
