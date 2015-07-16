package com.hitsmile.library.myinterface;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.hitsmile.library.database.SearchAndChangeDatabase;

import javax.swing.JScrollBar;

public class ShowAll {

	private JFrame frame;

	private ImageIcon background;
	private JPanel imagePanel;
	private JLabel imagelabel;

	private StaffManage staffManage;
	private JTextArea staffArea;
	private JScrollPane staffScroll;
	private StudentManage studentManage;
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
					ShowAll window = new ShowAll();
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
	public ShowAll() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	public void addStaffInformation(String staffInformaiton) {

		staffArea.append(staffInformaiton + "\r\n");

	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);

		background = new ImageIcon("loginPicture.jpg");
		imagelabel = new JLabel(background);
		imagelabel.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());
		imagePanel = (JPanel) frame.getContentPane();
		frame.getContentPane().setLayout(null);

		JButton button = new JButton("\u8FD4\u56DE");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (LoginInterface.showBackFlag == 1) {
					staffManage = new StaffManage();

				} else if (LoginInterface.showBackFlag == 2) {

					bookManage = new BookManage();

				} else if (LoginInterface.showBackFlag == 3) {
					studentManage = new StudentManage();
				} else if (LoginInterface.showBackFlag == 4) {
					mySearchAndAlter = new MySearchAndAlter();
				} else if (LoginInterface.showBackFlag == 5) {
					borrowBooks = new BorrowBooks();
				} else {
					JOptionPane.showMessageDialog(null, "窗口返回错误，系统出现故障！", "系统信息", JOptionPane.WARNING_MESSAGE);

				}

				frame.dispose();
			}
		});
		button.setBounds(844, 455, 93, 23);
		frame.getContentPane().add(button);

		staffArea = new JTextArea();
		staffScroll = new JScrollPane(staffArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		staffScroll.setBounds(145, 194, 541, 235);
		frame.getContentPane().add(staffScroll);

		imagePanel.setOpaque(false);
		frame.getLayeredPane().add(imagelabel, new Integer(Integer.MIN_VALUE));
		frame.setSize(1024, 596);

	}
}
