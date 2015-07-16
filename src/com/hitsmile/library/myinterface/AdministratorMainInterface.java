package com.hitsmile.library.myinterface;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JMenuItem;

public class AdministratorMainInterface {

	private JFrame frame;
	private ImageIcon background;
	private JPanel imagePanel;
	private JLabel label;

	private String sql;
	private StaffManage fm;
	private BookManage bm;
	private LoginInterface loginInterface;
	private StudentManage studentManage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdministratorMainInterface window = new AdministratorMainInterface();
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
	public AdministratorMainInterface() {
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
		imagePanel = (JPanel) frame.getContentPane();
		frame.getContentPane().setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 39, 21);
		frame.getContentPane().add(menuBar);

		JMenu menu = new JMenu("\u7BA1\u7406");
		menuBar.add(menu);
		// 三个菜单组件分别跳转不同界面
		JMenuItem menuItem = new JMenuItem("\u5DE5\u4F5C\u4EBA\u5458\u4FE1\u606F");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fm = new StaffManage();
				LoginInterface.showBackFlag = 1;
				frame.dispose();

			}
		});
		menu.add(menuItem);

		JMenuItem menuItem_1 = new JMenuItem("\u56FE\u4E66\u4FE1\u606F");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bm = new BookManage();
				LoginInterface.showBackFlag = 2;
				frame.dispose();

			}
		});
		menu.add(menuItem_1);

		JMenuItem menuItem_2 = new JMenuItem("\u5B66\u751F\u4FE1\u606F");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				studentManage = new StudentManage();
				LoginInterface.showBackFlag = 3;
				frame.dispose();

			}
		});
		menu.add(menuItem_2);

		// 返回登陆界面
		JButton button = new JButton("\u9000\u51FA\u767B\u5F55");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginInterface = new LoginInterface();
				frame.dispose();

			}
		});
		button.setBounds(814, 391, 93, 23);
		frame.getContentPane().add(button);
		imagePanel.setOpaque(false);
		frame.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
		frame.setSize(1024, 596);

	}
}
