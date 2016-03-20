package com.bfis.lms;

import static com.bfis.lms.DatabaseConnector.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;

import static com.bfis.lms.DatabaseConnector.PASS;
import static com.bfis.lms.DatabaseConnector.URL;
import static com.bfis.lms.DatabaseConnector.USER;
import static com.bfis.lms.DatabaseConnector.JDBC_DRIVER;

public class MainFrame extends JFrame {
	JPanel titlePanel;
	JPanel homePanel;
	JPanel leftMunuPanel;
	JPanel bookTitleWithChkb;
	JLabel lblToolTitle;
	JLabel lblBookTitle;
	JLabel lblBookAuthor;
	JLabel lblBookQuantity;
	JLabel lblleftMenuPanel;
	JTextField txtBookTitle;
	JTextField txtBookAuthor;
	JTextField txtBookQuantity;
	JTextField txtSearchField;
	JButton btnSearch;
	String bookTitle;
	String bookAuthor;
	JButton listBooks;
	JButton addNewBook;
	JButton listMembers;
	JButton addNewMember;
	JButton listBorrowedBooks;
	JComboBox<String> cmbSearchField = new JComboBox<>(searchSelection);
	JCheckBox chkbBook;
	Font font;
	Connection cn;
	ResultSet rs;
	int bookQuantity;
	private JMenu bookMenu;
	private JMenu memberMenu;
	AddBook addBook;
	AddMember addMember;
	private ArrayList<Book> bookList;
	private ArrayList<Member> memberList;
	Container mainFrame;
	Container addBookFrame;
	Container addMemberFrame;
	Container mainFrameCenterCmpt;
	static DatabaseConnector dbConn;

	public static final String toolTitle = "Library Management System";
	public static final int screenWidth = Utility.getScreenSize()[0];
	public static final int screenHeight = Utility.getScreenSize()[1];
	public static final String[] searchSelection = { "Book", "Member" };

	MainFrame() {
		super("Library Management System");
		bookList = new ArrayList<>();
		dbConn = new DatabaseConnector();
		setSize(screenWidth, screenHeight);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		mainFrame = getContentPane();

		// setLocationOnCenter(this);
		titlePanel = new JPanel();
		titlePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		titlePanel.setBackground(new Color(230, 230, 230));
		titlePanel.setPreferredSize(new Dimension(screenWidth, 50));
		titlePanel.setBorder(BorderFactory.createLineBorder(Color.BLUE, 1));

		homePanel = new JPanel();
		homePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		homePanel.setBorder(BorderFactory.createLineBorder(Color.BLUE, 1));
		homePanel.setBackground(new Color(248, 248, 248));

		leftMunuPanel = new JPanel();
		leftMunuPanel.setLayout(new FlowLayout());
		leftMunuPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE, 1));
		leftMunuPanel.setPreferredSize(new Dimension(280, screenHeight));

		lblleftMenuPanel = new JLabel("Functions");
		lblleftMenuPanel.setPreferredSize(new Dimension(260, 20));
		font = lblleftMenuPanel.getFont();
		lblleftMenuPanel.setFont(Utility.changeFontSize(font, 5));
		lblToolTitle = new JLabel(toolTitle);
		lblToolTitle.setPreferredSize(new Dimension(300, 40));
		font = lblToolTitle.getFont();
		lblToolTitle.setFont(Utility.changeFontSize(font, 6));

		UIManager.put("TextField.inactiveBackground", Color.WHITE);
		txtSearchField = new JTextField("", 50);
		btnSearch = new JButton("Search");

		// titlePanel.add(txtSearchField);
		titlePanel.add(lblToolTitle);
		titlePanel.add(cmbSearchField);
		titlePanel.add(txtSearchField);
		titlePanel.add(btnSearch);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menuBar.setBorder(BorderFactory.createLineBorder(Color.BLUE, 1));
		createBookMenu();
		createMemberMenu();
		menuBar.add(bookMenu);
		menuBar.add(memberMenu);
		menuBar.setBackground(Color.WHITE);

		bookTitleWithChkb = new JPanel();
		bookTitleWithChkb.setBackground(new Color(248, 248, 248));
		bookTitleWithChkb.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

		lblBookTitle = new JLabel("Book Title");
		lblBookTitle.setPreferredSize(new Dimension(400, 20));
		lblBookAuthor = new JLabel("Book Author");
		lblBookAuthor.setPreferredSize(new Dimension(250, 20));
		lblBookQuantity = new JLabel("Books Available");
		lblBookQuantity.setSize(100, 20);

		chkbBook = new JCheckBox();

		bookTitleWithChkb.add(chkbBook);
		bookTitleWithChkb.add(lblBookTitle);

		homePanel.add(bookTitleWithChkb);
		homePanel.add(lblBookAuthor);
		homePanel.add(lblBookQuantity);

		listBooks = new JButton("List Books");
		listBooks.addActionListener(new MenuManager());
		listBooks.setPreferredSize(new Dimension(260, 30));
		addNewBook = new JButton("Add New Book");
		addNewBook.setPreferredSize(new Dimension(260, 30));
		addNewBook.addActionListener(new MenuManager());
		listBorrowedBooks = new JButton("List Borrowed Books");
		listBorrowedBooks.setPreferredSize(new Dimension(260, 30));
		listBorrowedBooks.addActionListener(new MenuManager());
		listMembers = new JButton("List Members");
		listMembers.addActionListener(new MenuManager());
		listMembers.setPreferredSize(new Dimension(260, 30));
		addNewMember = new JButton("Add New Member");
		addNewMember.addActionListener(new MenuManager());
		addNewMember.setPreferredSize(new Dimension(260, 30));

		leftMunuPanel.add(lblleftMenuPanel);
		leftMunuPanel.add(listBooks);
		leftMunuPanel.add(addNewBook);
		leftMunuPanel.add(listBorrowedBooks);
		leftMunuPanel.add(listMembers);
		leftMunuPanel.add(addNewMember);

		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(URL, USER, PASS);
			Statement st = cn.createStatement();
			rs = st.executeQuery("select * from book");
			String title;
			String author;
			int quantity;
			Book book;
			while (rs.next()) {
				title = rs.getString("bookTitle");
				// System.out.println(title);
				author = rs.getString("bookAuthor");
				quantity = rs.getInt("quantity");
				// System.out.println(quantity);
				book = new Book(title, author, quantity);
				bookList.add(book);				
				
				bookTitleWithChkb = new JPanel();
				bookTitleWithChkb.setBackground(new Color(248, 248, 248));
				bookTitleWithChkb.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
				chkbBook = new JCheckBox();				

				homePanel.add(bookTitleWithChkb);
				txtBookTitle = new JTextField(title);
				txtBookTitle.setEditable(false);
				txtBookTitle.setPreferredSize(new Dimension(400, 20));
				// System.out.println(screenWidth);
				txtBookAuthor = new JTextField(author);
				txtBookAuthor.setEditable(false);
				txtBookAuthor.setPreferredSize(new Dimension(250, 20));
				txtBookQuantity = new JTextField("" + quantity);
				txtBookQuantity.setEditable(false);
				txtBookQuantity.setPreferredSize(new Dimension(100, 20));
				
				bookTitleWithChkb.add(chkbBook);
				bookTitleWithChkb.add(txtBookTitle);
				
				homePanel.add(bookTitleWithChkb);
				homePanel.add(txtBookAuthor);
				homePanel.add(txtBookQuantity);

			}
			mainFrameCenterCmpt = homePanel;
			cn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		mainFrame.add(titlePanel, BorderLayout.NORTH);
		mainFrame.add(homePanel, BorderLayout.CENTER);
		mainFrame.add(leftMunuPanel, BorderLayout.WEST);

	}

	private void createBookMenu() {
		JMenuItem item;

		bookMenu = new JMenu("Books");
		item = new JMenuItem("List Books"); // Save
		item.addActionListener(new MenuManager());
		bookMenu.add(item);

		item = new JMenuItem("Add New Book"); // New
		item.addActionListener(new MenuManager());
		bookMenu.add(item);

		item = new JMenuItem("Return Borrowed Book"); // Open...
		item.addActionListener(new MenuManager());
		bookMenu.add(item);

		bookMenu.addSeparator(); // add a horizontal separator line

	}

	private void createMemberMenu() {
		JMenuItem item;
		memberMenu = new JMenu("Members");
		item = new JMenuItem("List Members"); // Cut
		item.addActionListener(new MenuManager());
		memberMenu.add(item);

		item = new JMenuItem("Add New Member"); // Copy
		item.addActionListener(new MenuManager());
		memberMenu.add(item);

	}

	private void displayBooks(ArrayList<Book> bookList) {
		String title;
		String author;
		int quantity;
		Book book;
		int count = 0;
		homePanel.removeAll();
		homePanel.revalidate();
		mainFrame.remove(mainFrameCenterCmpt);
		mainFrame.revalidate();
		bookTitleWithChkb = new JPanel();
		bookTitleWithChkb.setBackground(new Color(248, 248, 248));
		bookTitleWithChkb.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		chkbBook = new JCheckBox();
		bookTitleWithChkb.add(chkbBook);
		bookTitleWithChkb.add(lblBookTitle);		
		homePanel.add(bookTitleWithChkb);
		homePanel.add(lblBookAuthor);
		homePanel.add(lblBookQuantity);
		while (count < bookList.size()) {
			book = bookList.get(count);
			title = book.bookTitle;
			author = book.bookAuthor;
			quantity = book.quantity;
			
			bookTitleWithChkb = new JPanel();
			bookTitleWithChkb.setBackground(new Color(248, 248, 248));
			bookTitleWithChkb.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
			chkbBook = new JCheckBox();

			txtBookTitle = new JTextField(title);
			txtBookTitle.setEditable(false);
			txtBookTitle.setPreferredSize(new Dimension(400, 20));
			// System.out.println(screenWidth);
			txtBookAuthor = new JTextField(author);
			txtBookAuthor.setEditable(false);
			txtBookAuthor.setPreferredSize(new Dimension(250, 20));
			txtBookQuantity = new JTextField("" + quantity);
			txtBookQuantity.setEditable(false);
			txtBookQuantity.setPreferredSize(new Dimension(100, 20));

			bookTitleWithChkb.add(chkbBook);
			bookTitleWithChkb.add(txtBookTitle);
			
			homePanel.add(bookTitleWithChkb);
			homePanel.add(txtBookAuthor);
			homePanel.add(txtBookQuantity);
			count++;
		}
		mainFrame.add(homePanel, BorderLayout.CENTER);
		mainFrame.revalidate();
		mainFrame.repaint();
		mainFrameCenterCmpt = homePanel;

	}

	class MenuManager implements ActionListener {
		String bookTitle;
		String bookAuthor;
		int bookQuantity;
		String memberName;
		int memberId;

		Connection cn;
		Statement st;
		ResultSet rs;

		public void actionPerformed(ActionEvent evt) {
			String menuName;
			menuName = evt.getActionCommand();

			if (evt.getSource() == listBooks) {
				displayBooks(bookList);

			} else if (evt.getSource() == addNewBook) {
				addBook = new AddBook();
				mainFrame.remove(mainFrameCenterCmpt);
				mainFrame.revalidate();
				addBookFrame = addBook.getMainContainer();
				mainFrame.add(addBookFrame, BorderLayout.CENTER);
				mainFrame.revalidate();
				mainFrame.repaint();
				mainFrameCenterCmpt = addBookFrame;

			} else if (evt.getSource() == addNewMember) {
				System.out.println("Add Member");
				addMember = new AddMember();
				mainFrame.remove(mainFrameCenterCmpt);
				mainFrame.revalidate();
				addMemberFrame = addMember.getMainContainer();
				mainFrame.add(addMemberFrame, BorderLayout.CENTER);
				mainFrame.revalidate();
				mainFrame.repaint();
				mainFrameCenterCmpt = addMemberFrame;

			} else if (menuName.equals("Add New Member")) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					cn = DriverManager.getConnection(URL, USER, PASS);
					st = cn.createStatement();
					// memberName = txtMemberName.getText();
					rs = st.executeQuery("insert into tableMembers Values(0, memberName)");
					cn.close();

				} catch (SQLException | ClassNotFoundException e) {
				}

			} else if (menuName.equals("Add New Member")) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					cn = DriverManager.getConnection(URL, USER, PASS);
					st = cn.createStatement();
					// memberName = txtMemberName.getText();
					rs = st.executeQuery("insert into tableMembers Values(0, memberName)");
					cn.close();

				} catch (SQLException | ClassNotFoundException e) {
				}

			}

		}

	}

	public static void main(String[] args) {
		MainFrame frame = new MainFrame();
		frame.setVisible(true);
	}

}
