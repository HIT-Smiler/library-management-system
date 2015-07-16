package com.hitsmile.library.myinterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import com.hitsmile.library.database.StaffDatabase;
import com.hitsmile.library.management.StaffManagement;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import java.awt.Scrollbar;

public class StaffManage implements ActionListener {

	// 结构和BookManage完全相同
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JLabel lblName;
	private JLabel lblGender;
	private JLabel lblBirthday;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JLabel lblLacation;
	private JLabel label;

	private ImageIcon background;
	private JPanel imagePanel;
	private JLabel imagelabel;

	private int functionFlag;

	private String stringId;
	private String stringAge;
	private String stringName;
	private String stringGender;
	private String stringBirthday;
	private String stringUsername;
	private String stringPassword;
	private String stringLocation;

	private int intId;
	private int intAge;

	private String sql;

	private StaffDatabase sdb;
	private String[] stringField;
	private String stringFieldNotNull;
	// private String initSql;
	private StaffManagement staffmanagement;
	private int i;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;

	private String conditionField;
	private String conditonContent;
	private String alterField;
	private String alterContent;

	private AdministratorMainInterface ami;
	private StaffMainInterface fmf;
	private StudentsMainInterface tmf;
	private LoginInterface lif;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StaffManage window = new StaffManage();
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
	public StaffManage() {
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
		textField.setBounds(30, 42, 66, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(30, 234, 66, 21);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(30, 410, 66, 21);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(162, 42, 66, 21);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setBounds(162, 234, 66, 21);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);

		textField_5 = new JTextField();
		textField_5.setBounds(162, 410, 66, 21);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);

		textField_6 = new JTextField();
		textField_6.setBounds(298, 42, 66, 21);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);

		textField_7 = new JTextField();
		textField_7.setBounds(298, 234, 66, 21);
		frame.getContentPane().add(textField_7);
		textField_7.setColumns(10);

		JLabel lblId = new JLabel("id\uFF1A");
		lblId.setBounds(30, 10, 54, 15);
		frame.getContentPane().add(lblId);

		JLabel lblAge = new JLabel("age\uFF1A");
		lblAge.setBounds(30, 209, 54, 15);
		frame.getContentPane().add(lblAge);

		lblName = new JLabel("name:");
		lblName.setBounds(30, 373, 54, 15);
		frame.getContentPane().add(lblName);

		lblGender = new JLabel("gender:");
		lblGender.setBounds(162, 10, 54, 15);
		frame.getContentPane().add(lblGender);

		lblBirthday = new JLabel("birthday:");
		lblBirthday.setBounds(162, 209, 54, 15);
		frame.getContentPane().add(lblBirthday);

		lblUsername = new JLabel("username:");
		lblUsername.setBounds(162, 373, 120, 15);
		frame.getContentPane().add(lblUsername);

		lblPassword = new JLabel("password:");
		lblPassword.setBounds(298, 10, 108, 15);
		frame.getContentPane().add(lblPassword);

		lblLacation = new JLabel("location:");
		lblLacation.setBounds(298, 209, 54, 15);
		frame.getContentPane().add(lblLacation);

		label = new JLabel(
				"\u63D0\u793A\uFF1A\u8FDB\u884C\u6DFB\u52A0\u64CD\u4F5C\u65F6\u5FC5\u987B\u586B\u5B8C\u6240\u6709\u7A7A\u4F4D");
		label.setBounds(62, 470, 440, 15);
		frame.getContentPane().add(label);

		ButtonGroup bg = new ButtonGroup();

		JRadioButton radioButton = new JRadioButton("\u6DFB\u52A0");
		radioButton.setBounds(532, 108, 121, 23);

		JRadioButton radioButton_1 = new JRadioButton("\u5220\u9664");
		radioButton_1.setBounds(532, 157, 121, 23);

		JRadioButton radioButton_2 = new JRadioButton("\u4FEE\u6539");
		radioButton_2.setBounds(532, 209, 121, 23);

		JRadioButton radioButton_3 = new JRadioButton("\u67E5\u8BE2");
		radioButton_3.setBounds(532, 262, 121, 23);

		bg.add(radioButton);
		bg.add(radioButton_1);
		bg.add(radioButton_2);
		bg.add(radioButton_3);

		frame.getContentPane().add(radioButton);
		frame.getContentPane().add(radioButton_1);
		frame.getContentPane().add(radioButton_2);
		frame.getContentPane().add(radioButton_3);

		radioButton.setOpaque(false);
		radioButton_1.setOpaque(false);
		radioButton_2.setOpaque(false);
		radioButton_3.setOpaque(false);

		radioButton.addActionListener(this);
		radioButton_1.addActionListener(this);
		radioButton_2.addActionListener(this);
		radioButton_3.addActionListener(this);

		JButton button = new JButton("\u786E\u8BA4");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stringId = textField.getText();
				stringAge = textField_1.getText();
				stringName = textField_2.getText();
				stringGender = textField_3.getText();
				stringBirthday = textField_4.getText();
				stringUsername = textField_5.getText();
				stringPassword = textField_6.getText();
				stringLocation = textField_7.getText();

				if (!stringId.equals("")) {
					intId = Integer.parseInt(stringId);
				}

				if (!stringAge.equals("")) {
					intAge = Integer.parseInt(stringAge);
				}

				stringField = new String[] { stringId, stringAge, stringName, stringGender, stringBirthday,
						stringUsername, stringPassword, stringLocation };

				for (i = 0; i < 8; i++) {
					if (!stringField[i].equals("")) {
						stringFieldNotNull = stringField[i];
						break;

					}
				}

				if ((functionFlag == 1)) {
					sql = "insert into library.staff values (" + intId + "," + intAge + "," + "'" + stringName + "',"
							+ "'" + stringGender + "'," + "'" + stringBirthday + "'," + "'" + stringUsername + "',"
							+ "'" + stringPassword + "'," + "'" + stringLocation + "'" + ")";
					// System.out.println(sql);
					// System.out.println(stringId);
					// System.out.println(stringAge);
					sdb = new StaffDatabase(sql, functionFlag);

				} else if ((functionFlag == 2)) {
					staffmanagement = new StaffManagement(functionFlag, stringFieldNotNull, i);
					sql = staffmanagement.getSql();
					sdb = new StaffDatabase(sql, functionFlag);

					// System.out.println(i);

				} else if ((functionFlag == 3)) {
					conditionField = textField_8.getText();
					conditonContent = textField_9.getText();

					alterField = textField_10.getText();
					alterContent = textField_11.getText();

					boolean judge1 = ((conditionField.equals(stringField[0])) || conditionField.equals(stringField[1]));
					boolean judge2 = ((alterField.equals(stringField[0])) || alterField.equals(stringField[1]));

					if ((!judge1) && (!judge2)) {
						sql = "update library.staff set " + alterField + " = " + "'" + alterContent + "'" + " where "
								+ conditionField + " = " + "'" + conditonContent + "'";

					} else if ((!judge1) && (judge2)) {
						sql = "update library.staff set " + alterField + " = " + "'" + alterContent + "'" + " where "
								+ conditionField + " = " + conditonContent;

					} else if ((judge1) && (!judge2)) {

						sql = "update library.staff set " + alterField + " = " + alterContent + " where "
								+ conditionField + " = " + "'" + conditonContent + "'";

					} else {
						sql = "update library.staff set " + alterField + " = " + alterContent + " where "
								+ conditionField + " = " + conditonContent;

					}

					sdb = new StaffDatabase(sql, functionFlag);

				} else if ((functionFlag == 4)) {

					staffmanagement = new StaffManagement(functionFlag, stringFieldNotNull, i);
					sql = staffmanagement.getSql();
					sdb = new StaffDatabase(sql, functionFlag);
					frame.dispose();

				} else {
					JOptionPane.showMessageDialog(null, "输入格式不正确，参考下方提示！", "系统信息", JOptionPane.WARNING_MESSAGE);

				}

			}
		});
		button.setBounds(558, 385, 73, 23);
		frame.getContentPane().add(button);

		JButton button_1 = new JButton("\u8FD4\u56DE");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (LoginInterface.backWindowFlag == 1) {
					ami = new AdministratorMainInterface();
					frame.dispose();

				} else if (LoginInterface.backWindowFlag == 2) {
					fmf = new StaffMainInterface();
					frame.dispose();

				} else if (LoginInterface.backWindowFlag == 3) {
					tmf = new StudentsMainInterface();
					frame.dispose();
				} else {
					lif = new LoginInterface();
					frame.dispose();
				}
			}
		});
		button_1.setBounds(558, 439, 73, 23);
		frame.getContentPane().add(button_1);

		JLabel label_1 = new JLabel(
				"\u5220\u9664\u548C\u67E5\u8BE2\u64CD\u4F5C\u5FC5\u987B\u4E14\u53EA\u80FD\u586B\u4E00\u4E2A\u7A7A\u4F4D\uFF0C\u5426\u5219\u4EE5\u7B2C\u4E00\u4E2A\u7A7A\u4F4D\u4E3A\u5173\u952E\u8BCD\uFF08\u4ECE\u4E0A\u5230\u4E0B\uFF0C\u4ECE\u5DE6\u5230\u53F3\uFF09");
		label_1.setBounds(100, 505, 553, 15);
		frame.getContentPane().add(label_1);

		JLabel lblnameMarry = new JLabel(
				"\u4FEE\u6539\u64CD\u4F5C\u65F6\uFF0C\u53EA\u586B\u5199\u6700\u540E\u56DB\u4E2A\u7A7A\u4F4D\uFF0C\u5176\u4F59\u7A7A\u4F4D\u65E0\u6548\uFF0C\u683C\u5F0F\u5982\uFF1A\uFF08\u66F4\u6539\u6761\u4EF6\uFF1Aname = Marry  \u6240\u6539\u5C5E\u6027\uFF1Aage = 18\uFF09");
		lblnameMarry.setBounds(100, 542, 861, 15);
		frame.getContentPane().add(lblnameMarry);

		textField_8 = new JTextField();
		textField_8.setBounds(298, 350, 66, 21);
		frame.getContentPane().add(textField_8);
		textField_8.setColumns(10);

		textField_9 = new JTextField();
		textField_9.setBounds(397, 350, 66, 21);
		frame.getContentPane().add(textField_9);
		textField_9.setColumns(10);

		textField_10 = new JTextField();
		textField_10.setBounds(298, 410, 66, 21);
		frame.getContentPane().add(textField_10);
		textField_10.setColumns(10);

		textField_11 = new JTextField();
		textField_11.setBounds(397, 410, 66, 21);
		frame.getContentPane().add(textField_11);
		textField_11.setColumns(10);

		JLabel label_2 = new JLabel("\u66F4\u6539\u6761\u4EF6");
		label_2.setBounds(298, 325, 54, 15);
		frame.getContentPane().add(label_2);

		JLabel label_3 = new JLabel("\u6240\u6539\u5C5E\u6027");
		label_3.setBounds(298, 389, 54, 15);
		frame.getContentPane().add(label_3);

		JLabel label_4 = new JLabel("=");
		label_4.setBounds(374, 353, 14, 15);
		frame.getContentPane().add(label_4);

		JLabel label_5 = new JLabel("=");
		label_5.setBounds(374, 413, 14, 15);
		frame.getContentPane().add(label_5);

		imagePanel.setOpaque(false);
		frame.getLayeredPane().add(imagelabel, new Integer(Integer.MIN_VALUE));
		frame.setSize(1024, 596);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String selection = e.getActionCommand();
		if (selection.equals("\u6DFB\u52A0")) {
			functionFlag = 1;
		} else if (selection.equals("\u5220\u9664")) {
			functionFlag = 2;
		} else if (selection.equals("\u4FEE\u6539")) {
			functionFlag = 3;
		} else if (selection.equals("\u67E5\u8BE2")) {
			functionFlag = 4;
		} else {

		}

	}
}
