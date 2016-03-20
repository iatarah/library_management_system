package com.bfis.lms;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ListMembers  extends JPanel{
	
	private JTable table;
    private DefaultListModel model;
    private JScrollPane pane;
    public static final int DEFAULT_WIDTH = 600;
	public static final int DEFAULT_HEIGHT = 400;
	
    public ListMembers() {
    	
    	Object rowData[][] = { 
				{ "Fisseha", "Abebe","Middle" },
				{ "Fisseha1", "Abebe","Middle1" }, 
				{ "Fisseha2", "Abebe2","Middle2" },
				{ "Fisseha3", "Abebe3","Middle3" },
				{ "Fisseha4", "Abebe4","Middle4" },
				{ "Fisseha5", "Abebe5","Middle5" }
		};
    	Object columnNames[] = { "First Name", "Last Name","Member Type" };
	    table = new JTable(rowData,columnNames);
	    pane = new JScrollPane(table); // without it doesn't show columnNames
		add(pane);
		
		setVisible(true);
    	    
    }
    
	public static void main(String[] args) {
		JFrame frame = new JFrame("List Of Members");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setContentPane(new ListMembers());
	    frame.setSize(500, 500);
	    frame.setVisible(true);
		

	}

}
