package com.hitsmile.library.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.hitsmile.library.myinterface.LoginInterface;
import com.hitsmile.library.myinterface.ShowAll;

public class SearchAndChangeDatabase {
	final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	final static String DB_URL = "jdbc:mysql://localhost/library";

	final static String USERNAME = "root";
	final static String PASSWORD = "9564";

	// private String tempusername = null;
	// private String temppassword = null;

	private Connection conn = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;

	private ShowAll showAll;
	private String studentSumInformation;
	private LoginInterface loginInterface;
	

	public SearchAndChangeDatabase(String tempusername, String temppassword, String tempNewpassword) {
		// this.tempusername = tempusername;
		// this.temppassword = temppassword;

		try {
			Class.forName(JDBC_DRIVER);

			conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

			String sql = new String("update library.student set password = " + tempNewpassword + " where username = "
					+ tempusername + " and " + "password = " + temppassword);

			// System.out.println(sql);
			// String sql1 = "exec p_skill '"+ "AAA" +"',"+"\""+ "B" +"\"";
			//
			// System.out.println(sql1);

			pst = conn.prepareStatement(sql);

			pst.execute(sql);
			
			JOptionPane.showMessageDialog(null,"密码修改成功！", "系统信息", JOptionPane.INFORMATION_MESSAGE);
			loginInterface = new LoginInterface();


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

	public SearchAndChangeDatabase(String tempusername, String temppassword) {
		// this.tempusername = tempusername;
		// this.temppassword = temppassword;

		try {
			Class.forName(JDBC_DRIVER);

			conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

			String sql = new String("select * from library.student where username = " + "'" + tempusername + "'"
					+ " and password = " + "'" + temppassword + "'");

			// System.out.println(sql);
			// String sql1 = "exec p_skill '"+ "AAA" +"',"+"\""+ "B" +"\"";
			//
			// System.out.println(sql1);

			pst = conn.prepareStatement(sql);

			rs = pst.executeQuery(sql);
			showAll = new ShowAll();
			while (rs.next()) {
				int id = rs.getInt("id");
				int age = rs.getInt("age");
				String name = rs.getString("name");
				String gender = rs.getString("gender");
				String birthday = rs.getString("birthday");
				String major = rs.getString("major");
				String institute = rs.getString("institute");
				String grade = rs.getString("grade");
				String username = rs.getString("username");
				String password = rs.getString("password");

				studentSumInformation = "id:" + id + ",   " + "age:" + age + ",   " + "name:" + name + ",   "
						+ "gender:" + gender + ",   " + "birthday:" + birthday + ",   " + "major:" + major + ",   "
						+ "institute:" + institute + ",   " + "grade:" + grade + ",   " + "username:" + username
						+ ",   " + "password:" + password;

				showAll.addStaffInformation(studentSumInformation);

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
