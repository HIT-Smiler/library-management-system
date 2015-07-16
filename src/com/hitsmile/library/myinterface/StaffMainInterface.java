package com.hitsmile.library.myinterface;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StaffMainInterface {

	private JFrame frame;
	private ImageIcon background;
	private JPanel imagePanel;
	private JLabel label;
	private BookManage bm;
	private LoginInterface lif;
	private StudentManage studentManage;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StaffMainInterface window = new StaffMainInterface();
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
	public StaffMainInterface() {
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
		menuBar.setBounds(0, 0, 44, 21);
		frame.getContentPane().add(menuBar);
		
		JMenu menu = new JMenu("\u7BA1\u7406");
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("\u5B66\u751F\u4FE1\u606F");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				studentManage = new StudentManage();
				LoginInterface.showBackFlag = 3;
				frame.dispose();
				
				
			}
		});
		menu.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("\u56FE\u4E66\u4FE1\u606F");
		menuItem_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				LoginInterface.showBackFlag = 2;
				
				bm = new BookManage();
				frame.dispose();
			}
			
		});
		menu.add(menuItem_1);
		
		JButton button = new JButton("\u9000\u51FA\u767B\u9646");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lif = new LoginInterface();
				frame.dispose();
				
			}
		});
		button.setBounds(792, 427, 93, 23);
		frame.getContentPane().add(button);
		imagePanel.setOpaque(false);
		frame.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
		frame.setSize(1024, 596);
		
	}
}
