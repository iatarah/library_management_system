package com.bfis.lms;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AddMember extends JFrame {
	
	private String title="Add Member";
	private JLabel lblFirstName;
	private JLabel lblLastNme;
    private JLabel lblMemberType;
    
    private JTextField txtFirstName;
	private JTextField txtLastName;
	private JComboBox cBoxMemberType;
	
	private JButton btnAdd;
	private JButton btnCancel;
	private Container mainContainer;
	
	public static final int DEFAULT_WIDTH = 500;
	public static final int DEFAULT_HEIGHT = 400;
	
	public AddMember () {
		
		setTitle(title);
		//pack();
		setLocationRelativeTo(null);
		
		lblFirstName=new JLabel("First Name:");
		lblFirstName.setBounds(50, 50, 200, 30);
		
		
		lblLastNme = new JLabel("Last Name:");
		lblLastNme.setBounds(50, 100, 200, 30);
	    
	
		lblMemberType = new JLabel("Member type:");
		lblMemberType.setBounds(50, 150, 200, 30);
		
		
		txtFirstName=new JTextField();
		txtFirstName.setBounds(150, 50, 200, 30);
		
		
		txtLastName= new JTextField();
		txtLastName.setBounds(150, 100, 200, 30);		
		
		
		cBoxMemberType=new JComboBox<>();
		cBoxMemberType.setBounds(150, 150, 200, 30);
		
		populateComboBox();
		
		
		btnAdd= new JButton("Add");
		btnAdd.setBounds(150, 200, 100, 30);
		//btnAdd.setBackground(Color.green);
		
		
		btnCancel= new JButton("Cancel");
		btnCancel.setBounds(260, 200, 100, 30);
		//btnCancel.setBackground(Color.green);
		
		
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mainContainer=getContentPane();
		mainContainer.setLayout(null);
		mainContainer.add(btnCancel);
		mainContainer.add(btnAdd);
		mainContainer.add(cBoxMemberType);
		mainContainer.add(txtLastName);
		mainContainer.add(txtFirstName);
		mainContainer.add(lblMemberType);
		mainContainer.add(lblLastNme);
		mainContainer.add(lblFirstName);
		
		
		
	   btnAdd.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
	});
	   
	 btnCancel.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			/*txtFirstName.setText("");
			txtLastName.setText("");
			cBoxMemberType.setSelectedIndex(0);*/
		}
	});
				
	}
    
	
	public void populateComboBox()
	{
		cBoxMemberType.addItem("Labrarian");
		cBoxMemberType.addItem("Student");
		cBoxMemberType.addItem("Staff");
	}
  	
	public Container getMainContainer() {
		return mainContainer;
	}
	

}
