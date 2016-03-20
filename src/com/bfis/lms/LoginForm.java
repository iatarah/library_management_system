package com.bfis.lms;

import static com.bfis.lms.DatabaseConnector.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;

import static com.bfis.lms.DatabaseConnector.PASS;
import static com.bfis.lms.DatabaseConnector.URL;
import static com.bfis.lms.DatabaseConnector.USER;
import static com.bfis.lms.DatabaseConnector.JDBC_DRIVER;

public class LoginForm extends JFrame {

	private String title = "Login to LMS";
	private JLabel lblUserName;
	private JLabel lblPassword;
	private JTextField txtUserName;
	private JPasswordField password;
	private JButton btnLogin;

	public static final int DEFAULT_WIDTH = 400;
	public static final int DEFAULT_HEIGHT = 300;

	public LoginForm() {
		setTitle(title);
		// this.setUndecorated(true);
		this.setBackground(Color.darkGray);
		lblUserName = new JLabel("User Name:");
		lblUserName.setBounds(50, 50, 200, 30);
		add(lblUserName);

		lblPassword = new JLabel("Password:");
		lblPassword.setBounds(50, 100, 200, 30);
		add(lblPassword);

		txtUserName = new JTextField();
		txtUserName.setBounds(150, 50, 150, 30);
		add(txtUserName);

		password = new JPasswordField();
		password.setBounds(150, 100, 150, 30);
		add(password);

		btnLogin = new JButton("Login");
		btnLogin.setBounds(220, 150, 80, 30);
		btnLogin.setBorderPainted(true);
		// btnLogin.setBackground(Color.green);
		add(btnLogin);

		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		getContentPane().setLayout(null);
		Utility.setLocationOnCenter(this);

		btnLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Connection cn;
				ResultSet rs;
				try {
					//Class.forName("com.mysql.jdbc.Driver");
					cn = DriverManager.getConnection(URL, USER, PASS);
					Statement st = cn.createStatement();
					rs = st.executeQuery("select * from users");
					String inputUserName = txtUserName.getText();
					char[] inputPass = password.getPassword();
					String pass;
					String usr;					
					while (rs.next()) {
						usr = rs.getString("username");
						pass = rs.getString("password");
						if (pass.equals(new String(inputPass))
								&& usr.equals(inputUserName)) {
							MainFrame frame = new MainFrame();
							frame.setVisible(true);
							LoginForm.this.setVisible(false);
							break;
						} else {
							JOptionPane.showMessageDialog(LoginForm.this,
									"Invalid password. Try again.",
									"Error Message", JOptionPane.ERROR_MESSAGE);
						}

					}
					cn.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				

			}
		});

	}

}
