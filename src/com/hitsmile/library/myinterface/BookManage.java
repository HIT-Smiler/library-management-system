package com.hitsmile.library.myinterface;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import javax.swing.JTextField;

import com.hitsmile.library.database.BookDatabase;
import com.hitsmile.library.management.BookManagement;

import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class BookManage implements ActionListener {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JLabel lblBooknum;
	private JLabel lblPagecount;
	private JLabel lblBookprice;

	private ImageIcon background;
	private JPanel imagePanel;
	private JLabel imagelabel;

	private JRadioButton radioButton;
	private JRadioButton radioButton_1;
	private JRadioButton radioButton_2;
	private JRadioButton radioButton_3;
	private JTextField textField_11;

	private ButtonGroup bookButton;

	// 接收文本框的输入信息
	private String stringBookId;
	private String stringBookNum;
	private String stringPageCount;
	private String stringBookPrice;
	private String stringBookName;
	private String stringBookAuthor;
	private String stringBookLocation;
	private String stringBookPubDate;
	private String stringBookPubComp;
	private String stringBookInDate;
	private String stringRestNum;
	private String stringSumNum;

	// 如果数据库中是整形，则将接收到的字符串转化为整形
	private int intBookId;
	private int intBookNum;
	private int intPageNum;
	private int intBookPrice;
	private int intRestNum;
	private int intSumNum;

	private int functionFlag;

	private AdministratorMainInterface ami;
	private StaffMainInterface fmf;
	private StudentsMainInterface tmf;
	private LoginInterface lif;

	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;

	private String[] stringField;
	private int i;
	private String stringFieldNotNull;
	private BookDatabase bookDatabase;
	private String sql;
	private BookManagement bookManagement;

	// 接收修改文本框的输入字符串
	private String conditionField;
	private String conditonContent;
	private String alterField;
	private String alterContent;

	private JLabel label_6;
	private JLabel label_7;
	private JLabel label_8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookManage window = new BookManage();
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
	public BookManage() {
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
		textField.setBounds(31, 50, 66, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(31, 224, 66, 21);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(31, 409, 66, 21);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(136, 50, 66, 21);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setBounds(156, 224, 66, 21);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);

		textField_5 = new JTextField();
		textField_5.setBounds(156, 409, 66, 21);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);

		textField_6 = new JTextField();
		textField_6.setBounds(262, 50, 66, 21);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);

		textField_7 = new JTextField();
		textField_7.setBounds(262, 224, 66, 21);
		frame.getContentPane().add(textField_7);
		textField_7.setColumns(10);

		textField_8 = new JTextField();
		textField_8.setBounds(262, 409, 66, 21);
		frame.getContentPane().add(textField_8);
		textField_8.setColumns(10);

		textField_9 = new JTextField();
		textField_9.setBounds(384, 50, 66, 21);
		frame.getContentPane().add(textField_9);
		textField_9.setColumns(10);

		textField_10 = new JTextField();
		textField_10.setBounds(384, 224, 66, 21);
		frame.getContentPane().add(textField_10);
		textField_10.setColumns(10);

		textField_11 = new JTextField();
		textField_11.setBounds(384, 409, 66, 21);
		frame.getContentPane().add(textField_11);
		textField_11.setColumns(10);

		// 修改使用
		textField_12 = new JTextField();
		textField_12.setBounds(784, 363, 66, 21);
		frame.getContentPane().add(textField_12);
		textField_12.setColumns(10);

		textField_13 = new JTextField();
		textField_13.setBounds(875, 363, 66, 21);
		frame.getContentPane().add(textField_13);
		textField_13.setColumns(10);

		textField_14 = new JTextField();
		textField_14.setBounds(784, 446, 66, 21);
		frame.getContentPane().add(textField_14);
		textField_14.setColumns(10);

		textField_15 = new JTextField();
		textField_15.setBounds(875, 446, 66, 21);
		frame.getContentPane().add(textField_15);
		textField_15.setColumns(10);

		JButton button = new JButton("\u786E\u8BA4");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				stringBookId = textField.getText();
				stringBookNum = textField_1.getText();
				stringPageCount = textField_2.getText();
				stringBookPrice = textField_3.getText();
				stringBookName = textField_4.getText();
				stringBookAuthor = textField_5.getText();
				stringBookLocation = textField_6.getText();
				stringBookPubDate = textField_7.getText();
				stringBookPubComp = textField_8.getText();
				stringBookInDate = textField_9.getText();
				stringRestNum = textField_10.getText();
				stringSumNum = textField_11.getText();

				// 字符串转化为整形
				if (!(stringBookId.equals(""))) {
					intBookId = Integer.parseInt(stringBookId);
				}
				if (!(stringBookNum.equals(""))) {
					intBookNum = Integer.parseInt(stringBookNum);
				}
				if (!(stringPageCount.equals(""))) {
					intPageNum = Integer.parseInt(stringPageCount);
				}
				if (!(stringBookPrice.equals(""))) {
					intBookPrice = Integer.parseInt(stringBookPrice);
				}
				if (!(stringRestNum.equals(""))) {
					intRestNum = Integer.parseInt(stringRestNum);
				}
				if (!(stringSumNum.equals(""))) {
					intSumNum = Integer.parseInt(stringSumNum);
				}

				// 储存接收到的字符串
				stringField = new String[] { stringBookId, stringBookNum, stringPageCount, stringBookPrice,
						stringBookName, stringBookAuthor, stringBookLocation, stringBookPubDate, stringBookPubComp,
						stringBookInDate, stringRestNum, stringSumNum };

				// 判断第几个文本框是非空
				for (i = 0; i < 12; i++) {
					if (!stringField[i].equals("")) {
						stringFieldNotNull = stringField[i];
						break;

					}
				}
				// 添加
				if (functionFlag == 1) {
					sql = "insert into library.book values (" + intBookId + "," + intBookNum + "," + intPageNum + ","
							+ intBookPrice + "," + "'" + stringBookName + "'," + "'" + stringBookAuthor + "'," + "'"
							+ stringBookLocation + "'," + "'" + stringBookPubDate + "'," + "'" + stringBookPubComp
							+ "'," + "'" + stringBookInDate + "'," + stringRestNum + "," + stringSumNum + ")";

					System.out.println(sql);

					bookDatabase = new BookDatabase(sql, functionFlag);

					// 删除
				} else if (functionFlag == 2) {
					bookManagement = new BookManagement(functionFlag, stringFieldNotNull, i);
					sql = bookManagement.getSql();
					bookDatabase = new BookDatabase(sql, functionFlag);

					// 修改
				} else if (functionFlag == 3) {
					conditionField = textField_12.getText();
					conditonContent = textField_13.getText();
					alterField = textField_14.getText();
					alterContent = textField_15.getText();

					boolean judge1 = ((conditionField.equals(stringField[0])) || (conditionField.equals(stringField[1]))
							|| (conditionField.equals(stringField[2])) || (conditionField.equals(stringField[3]))
							|| (conditionField.equals(stringField[10])) || (conditionField.equals(stringField[11])));

					boolean judge2 = ((alterField.equals(stringField[0])) || (alterField.equals(stringField[1]))
							|| (alterField.equals(stringField[2])) || (alterField.equals(stringField[3]))
							|| (alterField.equals(stringField[10])) || (alterField.equals(stringField[11])));

					if ((!judge1) && (!judge2)) {
						sql = "update library.book set " + alterField + " = " + "'" + alterContent + "'" + " where "
								+ conditionField + " = " + "'" + conditonContent + "'";

					} else if ((!judge1) && (judge2)) {
						sql = "update library.book set " + alterField + " = " + "'" + alterContent + "'" + " where "
								+ conditionField + " = " + conditonContent;

					} else if ((judge1) && (!judge2)) {

						sql = "update library.book set " + alterField + " = " + alterContent + " where "
								+ conditionField + " = " + "'" + conditonContent + "'";

					} else {
						sql = "update library.book set " + alterField + " = " + alterContent + " where "
								+ conditionField + " = " + conditonContent;

					}

					bookDatabase = new BookDatabase(sql, functionFlag);

					// 查询
				} else if (functionFlag == 4) {
					bookManagement = new BookManagement(functionFlag, stringFieldNotNull, i);
					sql = bookManagement.getSql();
					bookDatabase = new BookDatabase(sql, functionFlag);
					frame.dispose();

				} else {
					JOptionPane.showMessageDialog(null, "输入格式不正确，参考下方提示！", "系统信息", JOptionPane.WARNING_MESSAGE);
				}

			}
		});
		button.setBounds(592, 392, 103, 23);
		frame.getContentPane().add(button);

		JButton button_1 = new JButton("\u8FD4\u56DE");
		button_1.addActionListener(new ActionListener() {
			// 根据标记变量返回到相应的界面
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
		button_1.setBounds(592, 445, 103, 23);
		frame.getContentPane().add(button_1);

		JLabel lblBookid = new JLabel("bookid");
		lblBookid.setBounds(31, 25, 54, 15);
		frame.getContentPane().add(lblBookid);

		lblBooknum = new JLabel("booknum");
		lblBooknum.setBounds(31, 199, 96, 15);
		frame.getContentPane().add(lblBooknum);

		lblPagecount = new JLabel("pagecount");
		lblPagecount.setBounds(31, 384, 86, 15);
		frame.getContentPane().add(lblPagecount);

		lblBookprice = new JLabel("bookprice");
		lblBookprice.setBounds(136, 25, 86, 15);
		frame.getContentPane().add(lblBookprice);

		JLabel lblBookname = new JLabel("bookname");
		lblBookname.setBounds(156, 199, 96, 15);
		frame.getContentPane().add(lblBookname);

		JLabel lblBookauthor = new JLabel("bookauthor");
		lblBookauthor.setBounds(156, 384, 96, 15);
		frame.getContentPane().add(lblBookauthor);

		JLabel lblBooklaocation = new JLabel("booklocation");
		lblBooklaocation.setBounds(262, 25, 113, 15);
		frame.getContentPane().add(lblBooklaocation);

		JLabel lblBookpubdate = new JLabel("bookpubdate");
		lblBookpubdate.setBounds(262, 199, 89, 15);
		frame.getContentPane().add(lblBookpubdate);

		JLabel lblBookpubcomp = new JLabel("bookpubcomp");
		lblBookpubcomp.setBounds(262, 384, 89, 15);
		frame.getContentPane().add(lblBookpubcomp);

		JLabel lblBookindate = new JLabel("bookindate");
		lblBookindate.setBounds(385, 25, 161, 15);
		frame.getContentPane().add(lblBookindate);

		JLabel lblRestnum = new JLabel("restnum");
		lblRestnum.setBounds(384, 199, 113, 15);
		frame.getContentPane().add(lblRestnum);

		JLabel label = new JLabel(
				"\u63D0\u793A\uFF1A\u8FDB\u884C\u6DFB\u52A0\u64CD\u4F5C\u65F6\u5FC5\u987B\u586B\u5B8C\u6240\u6709\u7A7A\u4F4D\uFF0C\u5176\u4F59\u64CD\u4F5C\u4E0D\u9700\u8981");
		label.setBounds(52, 475, 369, 15);
		frame.getContentPane().add(label);

		radioButton = new JRadioButton("\u6DFB\u52A0");
		radioButton.setBounds(574, 89, 121, 23);

		radioButton_1 = new JRadioButton("\u5220\u9664");
		radioButton_1.setBounds(574, 150, 121, 23);

		radioButton_2 = new JRadioButton("\u4FEE\u6539");
		radioButton_2.setBounds(574, 210, 121, 23);

		radioButton_3 = new JRadioButton("\u67E5\u8BE2");
		radioButton_3.setBounds(574, 271, 121, 23);

		bookButton = new ButtonGroup();

		bookButton.add(radioButton);
		bookButton.add(radioButton_1);
		bookButton.add(radioButton_2);
		bookButton.add(radioButton_3);

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

		JLabel lblSubnum = new JLabel("subnum");
		lblSubnum.setBounds(384, 384, 96, 15);
		frame.getContentPane().add(lblSubnum);

		JLabel label_1 = new JLabel(
				"\u5220\u9664\u548C\u67E5\u8BE2\u64CD\u4F5C\u5FC5\u987B\u4E14\u53EA\u80FD\u586B\u4E00\u4E2A\u7A7A\u4F4D\uFF0C\u5426\u5219\u4EE5\u7B2C\u4E00\u4E2A\u7A7A\u4F4D\u4E3A\u5173\u952E\u8BCD\uFF08\u4ECE\u4E0A\u5230\u4E0B\uFF0C\u4ECE\u5DE6\u5230\u53F3\uFF09");
		label_1.setBounds(91, 503, 571, 15);
		frame.getContentPane().add(label_1);

		JLabel lblnameMarry = new JLabel(
				"\u4FEE\u6539\u64CD\u4F5C\u65F6\uFF0C\u53EA\u586B\u5199\u6700\u540E\u56DB\u4E2A\u7A7A\u4F4D\uFF0C\u5176\u4F59\u7A7A\u4F4D\u65E0\u6548\uFF0C\u683C\u5F0F\u5982\uFF1A\uFF08\u66F4\u6539\u6761\u4EF6\uFF1Abookid = 1  \u6240\u6539\u5C5E\u6027\uFF1Arestnum = 4\uFF09");
		lblnameMarry.setBounds(91, 531, 720, 15);
		frame.getContentPane().add(lblnameMarry);

		JLabel label_2 = new JLabel("\u66F4\u6539\u6761\u4EF6");
		label_2.setBounds(784, 338, 54, 15);
		frame.getContentPane().add(label_2);

		JLabel label_3 = new JLabel("\u6240\u6539\u5C5E\u6027");
		label_3.setBounds(784, 421, 54, 15);
		frame.getContentPane().add(label_3);

		JLabel label_4 = new JLabel("=");
		label_4.setBounds(858, 366, 15, 15);
		frame.getContentPane().add(label_4);

		JLabel label_5 = new JLabel("=");
		label_5.setBounds(860, 449, 15, 15);
		frame.getContentPane().add(label_5);

		label_6 = new JLabel(
				"\u5F53\u5B66\u751F\u64CD\u4F5C\u65F6\uFF0C\u56DB\u4E2A\u9009\u9879\u5747\u7B49\u6548\u4E8E\u67E5\u8BE2\uFF0C");
		label_6.setBounds(700, 189, 271, 15);
		frame.getContentPane().add(label_6);

		label_7 = new JLabel("\u7A7A\u4F4D\u586B\u5199\u6309\u7167\u67E5\u8BE2\u64CD\u4F5C\u7684\u89C4\u5219\u3002");
		label_7.setBounds(676, 214, 197, 15);
		frame.getContentPane().add(label_7);

		label_8 = new JLabel("\u63D0\u793A\uFF1A");
		label_8.setBounds(676, 164, 54, 15);
		frame.getContentPane().add(label_8);

		imagePanel.setOpaque(false);
		frame.getLayeredPane().add(imagelabel, new Integer(Integer.MIN_VALUE));
		frame.setSize(1024, 596);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String selection = e.getActionCommand();
		// 监听ButtonGroup

		if (LoginInterface.backWindowFlag != 3) {

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
		} else {
			functionFlag = 4;
		}

	}
}
