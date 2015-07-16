package com.hitsmile.library.myinterface;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.hitsmile.library.database.SearchAndChangeDatabase;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MySearchAndAlter {

	private JFrame frame;
	private ImageIcon background;
	private JPanel imagePanel;
	private JLabel imagelabel;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	private String stringUsername;
	private String stringPassword;
	private String stringNewPassword;
	private String sql;
	private SearchAndChangeDatabase searchAndChangeDatabase;
	private StudentsMainInterface studentMainInterface;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MySearchAndAlter window = new MySearchAndAlter();
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
	public MySearchAndAlter() {
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
		imagelabel = new JLabel(background);
		imagelabel.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());
		imagePanel = (JPanel) frame.getContentPane();
		frame.getContentPane().setLayout(null);

		textField = new JTextField();
		textField.setBounds(139, 120, 149, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel label_1 = new JLabel("\u8F93\u5165\u7528\u6237\u540D\uFF1A");
		label_1.setBounds(37, 123, 134, 15);
		frame.getContentPane().add(label_1);

		JLabel label = new JLabel("\u8F93\u5165\u5BC6\u7801\uFF1A");
		label.setBounds(37, 247, 168, 15);
		frame.getContentPane().add(label);

		textField_1 = new JTextField();
		textField_1.setBounds(139, 244, 149, 21);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		JButton button = new JButton("\u67E5\u8BE2\u4FE1\u606F");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stringUsername = textField.getText();
				stringPassword = textField_1.getText();
				// stringNewPassword = textField_2.getText();
				
				LoginInterface.showBackFlag = 4;
				
				searchAndChangeDatabase = new SearchAndChangeDatabase(stringUsername, stringPassword);
				frame.dispose();
				

			}
		});
		button.setBounds(447, 119, 93, 23);
		frame.getContentPane().add(button);

		JButton button_1 = new JButton("\u4FEE\u6539\u5BC6\u7801");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stringUsername = textField.getText();
				stringPassword = textField_1.getText();
				stringNewPassword = textField_2.getText();
				
				LoginInterface.showBackFlag = 4;
				
				searchAndChangeDatabase = new SearchAndChangeDatabase(stringUsername, stringPassword, stringNewPassword);

				frame.dispose();

			}
		});
		button_1.setBounds(447, 348, 93, 23);
		frame.getContentPane().add(button_1);

		JLabel label_2 = new JLabel(
				"\u63D0\u793A\uFF1A\u4E24\u4E2A\u64CD\u4F5C\u90FD\u9700\u8981\u5B8C\u6574\u5730\u586B\u5199\u5B8C\u524D\u4E24\u4E2A\u7A7A\u4F4D\uFF08\u4ECE\u4E0A\u5230\u4E0B\uFF09\uFF0C\u8FDB\u884C\u4FEE\u6539\u5BC6\u7801\u64CD\u4F5C\u65F6\uFF0C\u9700\u8981\u586B\u5199\u7B2C\u4E09\u4E2A\u7A7A\u4F4D\u3002");
		label_2.setBounds(42, 498, 758, 15);
		frame.getContentPane().add(label_2);

		textField_2 = new JTextField();
		textField_2.setBounds(139, 375, 149, 21);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);

		JLabel label_3 = new JLabel("\u8F93\u5165\u65B0\u5BC6\u7801\uFF1A");
		label_3.setBounds(37, 378, 111, 15);
		frame.getContentPane().add(label_3);
		
		JButton button_2 = new JButton("\u8FD4\u56DE");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				studentMainInterface = new StudentsMainInterface();
				frame.dispose();
			}
		});
		button_2.setBounds(790, 348, 93, 23);
		frame.getContentPane().add(button_2);

		imagePanel.setOpaque(false);
		frame.getLayeredPane().add(imagelabel, new Integer(Integer.MIN_VALUE));
		frame.setSize(1024, 596);

	}
}
