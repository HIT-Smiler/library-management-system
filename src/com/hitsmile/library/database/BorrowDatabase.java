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
	// 加载JDBC驱动，同时预置mysql用户名及密码
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

			// 借书语句，向记录已借图书的数据库中插入语句
			String sql = "insert into library.borrow values (" + bookid + "," + id + ",'" + tempusername + "'," + "'"
					+ temppassword + "'" + ")";
			// System.out.println(sql);
			// String sql1 = "exec p_skill '"+ "AAA" +"',"+"\""+ "B" +"\"";
			//
			// System.out.println(sql1);

			pst = conn.prepareStatement(sql);

			pst.execute(sql);

			// 借书成功之后，图书数据库中的剩余图书将减少1
			JOptionPane.showMessageDialog(null, "借书成功！", "系统信息", JOptionPane.INFORMATION_MESSAGE);

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

	// 这个重载的构造器用来查询借书情况，连接borrow数据库，将用户名、密码符合的数据行输出
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

			//显示数据显示的界面
			showAll = new ShowAll();
			// 遍历满足条件数据行
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
