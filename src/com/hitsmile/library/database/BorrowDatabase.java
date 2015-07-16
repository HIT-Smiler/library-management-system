package com.hitsmile.library.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.hitsmile.library.myinterface.BookManage;
import com.hitsmile.library.myinterface.ShowAll;

public class BorrowDatabase {
	// ����JDBC������ͬʱԤ��mysql�û���������
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/library";

	static final String USER = "root";
	static final String PASSWORD = "9564";

	private Connection conn = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;

	private ShowAll showAll;
	private String borrowSumInformation;
	private BookDatabase bookdatabase;

	public BorrowDatabase(int bookid, int id, String tempusername, String temppassword) {
		// this.tempusername = tempusername;
		// this.temppassword = temppassword;

		try {
			Class.forName(JDBC_DRIVER);

			conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);

			// ������䣬���¼�ѽ�ͼ������ݿ��в������
			String sql = "insert into library.borrow values (" + bookid + "," + id + ",'" + tempusername + "'," + "'"
					+ temppassword + "'" + ")";
			// System.out.println(sql);
			// String sql1 = "exec p_skill '"+ "AAA" +"',"+"\""+ "B" +"\"";
			//
			// System.out.println(sql1);

			pst = conn.prepareStatement(sql);

			pst.execute(sql);

			// ����ɹ�֮��ͼ�����ݿ��е�ʣ��ͼ�齫����1
			JOptionPane.showMessageDialog(null, "����ɹ���", "ϵͳ��Ϣ", JOptionPane.INFORMATION_MESSAGE);

			sql = "update library.book set restnum = restnum - 1 where bookid = " + bookid;
			bookdatabase = new BookDatabase(sql, 3);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				if (pst != null) {
					pst.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	// ������صĹ�����������ѯ�������������borrow���ݿ⣬���û�����������ϵ����������
	public BorrowDatabase(String tempusername, String temppassword) {
		// this.tempusername = tempusername;
		// this.temppassword = temppassword;

		try {
			Class.forName(JDBC_DRIVER);

			conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);

			String sql = new String("select * from library.borrow where borrowedstudentusername = " + "'" + tempusername
					+ "'" + " and borrowedstudentpassword = " + "'" + temppassword + "'");

			// System.out.println(sql);
			// String sql1 = "exec p_skill '"+ "AAA" +"',"+"\""+ "B" +"\"";
			//
			// System.out.println(sql1);

			pst = conn.prepareStatement(sql);

			rs = pst.executeQuery(sql);

			//��ʾ������ʾ�Ľ���
			showAll = new ShowAll();
			// ������������������
			while (rs.next()) {

				int bookid = rs.getInt("bookid");
				int borrowedstudentid = rs.getInt("borrowedstudentid");
				String borrowedstudentusername = rs.getString("borrowedstudentusername");
				String borrowedstudentpassword = rs.getString("borrowedstudentpassword");

				borrowSumInformation = "bookid:" + bookid + ",   " + "borrowedstudentid:" + borrowedstudentid + ",   "
						+ "borrowedstudentusername:" + borrowedstudentusername + ",   " + "borrowedstudentpassword:"
						+ borrowedstudentpassword;

				showAll.addStaffInformation(borrowSumInformation);
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				if (pst != null) {
					pst.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
