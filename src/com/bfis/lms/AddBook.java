package com.bfis.lms;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AddBook extends JFrame  {
	
	private String title="Add Member";
	private JLabel lblTitle;
	private JLabel lblAuthor;
	private JLabel lblQuantity;
	
	private JTextField txtTitle;
	private JTextField txtAuthor;
	private JTextField txtQuantity;
	
	private JButton btnAdd;
	private JButton btnCancel;
	private Container mainContainer;
	
	public static final int DEFAULT_WIDTH = 500;
	public static final int DEFAULT_HEIGHT = 400;
	
	public  AddBook (){
		
		setLocationRelativeTo(null);
		setTitle(title);
	    lblTitle=new JLabel("Title:");
	    lblTitle.setBounds(50, 50, 200, 30);
		
		
		lblAuthor = new JLabel("Author:");
		lblAuthor.setBounds(50, 100, 200, 30);
	    
	
		lblQuantity = new JLabel("Quantity:");
		lblQuantity.setBounds(50, 150, 200, 30);
		
		
		txtTitle=new JTextField();
		txtTitle.setBounds(150, 50, 200, 30);
		
		
		txtAuthor= new JTextField();
		txtAuthor.setBounds(150, 100, 200, 30);		
	
		
		txtQuantity=new JTextField();
		txtQuantity.setBounds(150, 150, 200, 30);
		
		
		btnAdd= new JButton("Add");
		btnAdd.setBounds(150, 200, 100, 30);
		btnAdd.setBackground(Color.green);
		
		
		btnCancel= new JButton("Cancel");
		btnCancel.setBounds(260, 200, 100, 30);
		btnCancel.setBackground(Color.green);
		
		
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mainContainer = getContentPane();
		
		mainContainer.setLayout(null);
		mainContainer.add(lblTitle);
		mainContainer.add(lblAuthor);
		mainContainer.add(lblQuantity);
		mainContainer.add(txtTitle);
		mainContainer.add(txtAuthor);
		mainContainer.add(txtQuantity);
		mainContainer.add(btnAdd);
		mainContainer.add(btnCancel);
		
		
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub	
				
			}
		});
							
	}

	public Container getMainContainer() {
		return mainContainer;
	}
	
}
