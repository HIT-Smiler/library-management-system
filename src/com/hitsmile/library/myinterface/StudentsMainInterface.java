package com.hitsmile.library.myinterface;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentsMainInterface {

	private JFrame frame;
	
	private ImageIcon background;
	private JPanel imagePanel;
	private JLabel label;
	
	private LoginInterface lif;
	private BookManage bookManage;
	private MySearchAndAlter mySearchAndAlter;
	private BorrowBooks borrowBooks;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentsMainInterface window = new StudentsMainInterface();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StudentsMainInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
		
		background = new ImageIcon("loginPicture.jpg");
		label = new JLabel(background);
		label.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());
		imagePanel = (JPanel)frame.getContentPane();
		frame.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 63, 21);
		frame.getContentPane().add(menuBar);
		
		JMenu menu = new JMenu("\u529F\u80FD\u64CD\u4F5C");
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("\u56FE\u4E66\u4FE1\u606F\u67E5\u8BE2");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookManage = new BookManage();
				frame.dispose();
				
				
			}
		});
		menu.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("\u4E2A\u4EBA\u4FE1\u606F\u67E5\u8BE2\u53CA\u5BC6\u7801\u4FEE\u6539");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mySearchAndAlter = new MySearchAndAlter();
				frame.dispose();
				
				
			}
		});
		menu.add(menuItem_1);
		
		JMenuItem menuItem_2 = new JMenuItem("\u501F\u4E66");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				borrowBooks = new BorrowBooks();
				frame.dispose();
				
			}
		});
		menu.add(menuItem_2);
		
		JButton button = new JButton("\u9000\u51FA\u767B\u9646");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				lif = new LoginInterface();
				frame.dispose();
			}
		});
		button.setBounds(633, 423, 93, 23);
		frame.getContentPane().add(button);
		imagePanel.setOpaque(false);
		frame.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
		frame.setSize(1024, 596);
		
	}
}
