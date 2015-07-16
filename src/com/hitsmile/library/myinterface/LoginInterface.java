package com.hitsmile.library.myinterface;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.hitsmile.library.database.StaffDatabase;
import com.hitsmile.library.database.StudentDatabase;

public class LoginInterface implements ActionListener {
	
	public static int backWindowFlag = 0;
	public static int showBackFlag = 0;

	private JFrame frame;
	private JRadioButton rdbtnNewRadioButton;
	private JLabel label;
	private JTextField textField;
	private JLabel label_1;
	private JPasswordField passwordField;

	private JPanel imagePanel;
	private ImageIcon background;
	private JLabel label_2;

	private String personUsername;
	private String personPassword;
	private int positionFlag = 0;

	private String stringTextField;
	private String stringPasswordField;

	private boolean booleanStringTextField;
	private boolean booleanStringPasswordField;

	private AdministratorMainInterface amf;
	private StudentsMainInterface smf;
	private StaffMainInterface fmf;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginInterface window = new LoginInterface();
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
	public LoginInterface() {
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

		background = new ImageIcon("loginPicture.jpg");
		JLabel label = new JLabel(background);
		label.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());
		imagePanel = (JPanel) frame.getContentPane();
		imagePanel.setOpaque(false);
		// imagePanel.setLayout(new );
		frame.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));

		frame.setSize(1024, 596);
		frame.setResizable(false);

		ButtonGroup positionButtonGroup = new ButtonGroup();
		frame.getContentPane().setLayout(null);

		label_2 = new JLabel("\u7528\u6237\u540D\uFF1A");
		label_2.setBounds(253, 57, 54, 15);
		frame.getContentPane().add(label_2);

		textField = new JTextField();
		textField.setBounds(253, 112, 352, 23);

		frame.getContentPane().add(textField);
		textField.setColumns(10);
		stringTextField = textField.getText();

		label_1 = new JLabel("\u5BC6  \u7801\uFF1A");
		label_1.setBounds(253, 325, 54, 15);
		frame.getContentPane().add(label_1);

		passwordField = new JPasswordField();
		passwordField.setBounds(253, 383, 352, 23);

		frame.getContentPane().add(passwordField);
		stringPasswordField = new String(passwordField.getPassword());

		JPanel panel = new JPanel();
		panel.setBounds(40, 225, 161, 219);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JRadioButton radioButton = new JRadioButton("\u7BA1\u7406\u5458");
		radioButton.setBounds(5, 33, 94, 23);
		radioButton.setOpaque(false);
		radioButton.addActionListener(this);

		JRadioButton radioButton_1 = new JRadioButton("\u5DE5\u4F5C\u4EBA\u5458");
		radioButton_1.setBounds(5, 99, 93, 23);
		radioButton_1.setOpaque(false);
		radioButton_1.addActionListener(this);

		JRadioButton radioButton_2 = new JRadioButton("\u5B66\u751F");
		radioButton_2.setBounds(5, 165, 94, 23);
		radioButton_2.setOpaque(false);
		radioButton_2.addActionListener(this);

		positionButtonGroup.add(radioButton);
		positionButtonGroup.add(radioButton_1);
		positionButtonGroup.add(radioButton_2);

		panel.setOpaque(false);
		panel.add(radioButton);
		panel.add(radioButton_1);
		panel.add(radioButton_2);

		JButton btnNewButton = new JButton("\u767B\u9646");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				stringTextField = textField.getText();
				stringPasswordField = new String(passwordField.getPassword());
				
				StudentDatabase sd = new StudentDatabase(stringTextField, stringPasswordField);
				StaffDatabase fd = new StaffDatabase(stringTextField, stringPasswordField);
				
//				System.out.println(sd.isResultsetIsNotNull());

				if ((positionFlag == 00) && (stringTextField.equals("myAdmin"))
						&& (stringPasswordField.equals("admin"))) {
					amf = new AdministratorMainInterface();
					frame.dispose();
				} else if ((positionFlag == 10) && fd.isResultsetIsNotNull()) {
					fmf = new StaffMainInterface();
					frame.dispose();
				} else if ((positionFlag == 11) && sd.isResultsetIsNotNull()) {
					smf = new StudentsMainInterface();
					frame.dispose();
				} else {
					JOptionPane.showMessageDialog(null,"用户名不存在或密码输入错误！", "系统信息", JOptionPane.WARNING_MESSAGE);
				}

			}
		});
		btnNewButton.setBounds(731, 274, 195, 51);
		frame.getContentPane().add(btnNewButton);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String selection = e.getActionCommand();
		if (selection.equals("\u7BA1\u7406\u5458")) {
			positionFlag = 00;
			backWindowFlag = 1;
		} else if (selection.equals("\u5DE5\u4F5C\u4EBA\u5458")) {
			positionFlag = 10;
			backWindowFlag = 2;
		} else if (selection.equals("\u5B66\u751F")) {
			positionFlag = 11;
			backWindowFlag = 3;
		} else {
			
		}

	}
}
