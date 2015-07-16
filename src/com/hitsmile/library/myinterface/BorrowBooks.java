package com.hitsmile.library.myinterface;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.hitsmile.library.database.BorrowDatabase;
import com.hitsmile.library.database.ReturnDatabase;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BorrowBooks {

	private JFrame frame;
	private ImageIcon background;
	private JPanel imagePanel;
	private JLabel imagelabel;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel lblbookidbookid;
	private JButton button_1;

	private StudentsMainInterface studentMainInterface;

	private String stringBookid;
	private String stringusername;
	private String stringpassword;
	private String stringId;

	private int intBookid;
	private int intId;

	private JButton button_2;
	private BorrowDatabase borrowDatabase;
	private ReturnDatabase returnDatabase;
	private JTextField textField_3;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BorrowBooks window = new BorrowBooks();
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
	public BorrowBooks() {
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

		JLabel lblbookid = new JLabel("bookid ");
		lblbookid.setBounds(65, 68, 207, 15);
		frame.getContentPane().add(lblbookid);

		textField = new JTextField();
		textField.setBounds(65, 120, 66, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		// 跳转到结果显示界面
		JButton button = new JButton("\u67E5\u8BE2\u5DF2\u501F\u56FE\u4E66");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				stringusername = textField_1.getText();
				stringpassword = textField_2.getText();
				LoginInterface.showBackFlag = 5;

				borrowDatabase = new BorrowDatabase(stringusername, stringpassword);
				frame.dispose();

			}
		});
		button.setBounds(65, 333, 142, 23);
		frame.getContentPane().add(button);

		textField_1 = new JTextField();
		textField_1.setBounds(310, 142, 129, 21);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(310, 245, 129, 21);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);

		label = new JLabel("\u8F93\u5165\u7528\u6237\u540D");
		label.setBounds(308, 104, 131, 15);
		frame.getContentPane().add(label);

		label_1 = new JLabel("\u8F93\u5165\u5BC6\u7801");
		label_1.setBounds(309, 220, 130, 15);
		frame.getContentPane().add(label_1);

		label_2 = new JLabel(
				"\u63D0\u793A\uFF1A\u8FDB\u884C\u4E24\u4E2A\u64CD\u4F5C\u65F6\uFF0C\u7528\u6237\u540D\u548C\u5BC6\u7801\u5FC5\u586B");
		label_2.setBounds(343, 445, 302, 15);
		frame.getContentPane().add(label_2);

		lblbookidbookid = new JLabel(
				"\u501F\u4E66\u64CD\u4F5C\u65F6\uFF0C\u5B66\u751Fid\u5FC5\u586B\uFF0Cbookid\u5FC5\u586B\u4E14\u4E3A\u6240\u501F\u56FE\u4E66bookid\uFF0C\u67E5\u8BE2\u64CD\u4F5C\u65F6\uFF0Cbookid\u4E0D\u586B");
		lblbookidbookid.setBounds(377, 470, 577, 15);
		frame.getContentPane().add(lblbookidbookid);

		button_1 = new JButton("\u8FD4\u56DE");

		// 借书，底层为更改数据库
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				studentMainInterface = new StudentsMainInterface();
				frame.dispose();
			}
		});
		button_1.setBounds(734, 333, 93, 23);
		frame.getContentPane().add(button_1);

		button_2 = new JButton("\u501F\u4E66");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				stringBookid = textField.getText();
				stringusername = textField_1.getText();
				stringpassword = textField_2.getText();
				stringId = textField_3.getText();

				if (!(stringBookid.equals(""))) {
					intBookid = Integer.parseInt(stringBookid);
				}
				if (!(stringId.equals(""))) {
					intId = Integer.parseInt(stringId);
				}

				borrowDatabase = new BorrowDatabase(intBookid, intId, stringusername, stringpassword);

			}
		});
		button_2.setBounds(65, 234, 142, 23);
		frame.getContentPane().add(button_2);

		textField_3 = new JTextField();
		textField_3.setBounds(310, 347, 129, 21);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);

		lblNewLabel = new JLabel("\u8F93\u5165\u5B66\u751Fid");
		lblNewLabel.setBounds(308, 322, 119, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JButton button_3 = new JButton("\u8FD8\u4E66");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				stringBookid = textField.getText();
				stringusername = textField_1.getText();
				stringpassword = textField_2.getText();
				stringId = textField_3.getText();

				if (!(stringBookid.equals(""))) {
					intBookid = Integer.parseInt(stringBookid);
				}
				if (!(stringId.equals(""))) {
					intId = Integer.parseInt(stringId);
				}
				
				
				returnDatabase = new ReturnDatabase(intBookid, intId, stringusername, stringpassword);
			}
		});
		button_3.setBounds(65, 441, 142, 23);
		frame.getContentPane().add(button_3);
		
		JLabel label_3 = new JLabel("\u8FD8\u4E66\u65F6\u56DB\u4E2A\u7A7A\u4F4D\u5FC5\u987B\u90FD\u586B");
		label_3.setBounds(377, 507, 450, 15);
		frame.getContentPane().add(label_3);
		imagePanel.setOpaque(false);
		frame.getLayeredPane().add(imagelabel, new Integer(Integer.MIN_VALUE));
		frame.setSize(1024, 596);
	}
}
