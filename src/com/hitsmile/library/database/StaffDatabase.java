package com.hitsmile.library.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hitsmile.library.myinterface.ShowAll;

public class StaffDatabase {
	final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	final static String DB_URL = "jdbc:mysql://localhost/library";

	final static String USERNAME = "root";
	final static String PASSWORD = "9564";

	// private String tempusername = null;
	// private String temppassword = null;

	private Connection conn = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;

	private boolean resultsetIsNotNull;

	private ShowAll showAll;
	private String staffSumInformation;

	public StaffDatabase() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StaffDatabase(String sql, int functionFlag) {
		try {
			Class.forName(JDBC_DRIVER);

			conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

			if (functionFlag == 1) {

				pst = conn.prepareStatement(sql);
				pst.execute(sql);

			} else if (functionFlag == 2) {

				pst = conn.prepareStatement(sql);
				pst.execute(sql);
				// rs = pst.executeQuery(sql);

			} else if (functionFlag == 3) {

				pst = conn.prepareStatement(sql);
				pst.execute(sql);

			} else if (functionFlag == 4) {

				pst = conn.prepareStatement(sql);
				rs = pst.executeQuery(sql);

				showAll = new ShowAll();
				while (rs.next()) {
					int id = rs.getInt("id");
					int age = rs.getInt("age");
					String name = rs.getString("name");
					String gender = rs.getString("gender");
					String birthday = rs.getString("birthday");
					String username = rs.getString("username");
					String password = rs.getString("password");
					String location = rs.getString("location");

					staffSumInformation = "id:" + id + ",   " + "age:" + age + ",   " + "name:" + name + ",   " + "gender:"
							+ gender + ",   " + "birthday:" + birthday + ",   " + "username:" + username + ",   " + "password:"
							+ password + ",   " + "location:" + location;
					
					showAll.addStaffInformation(staffSumInformation);
				}

			} else {

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

	public StaffDatabase(String tempusername, String temppassword) {
		// this.tempusername = tempusername;
		// this.temppassword = temppassword;

		try {
			Class.forName(JDBC_DRIVER);

			conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

			String sql = new String("select * from library.staff where username = " + "'" + tempusername + "'"
					+ " and password = " + "'" + temppassword + "'");

			// System.out.println(sql);
			// String sql1 = "exec p_skill '"+ "AAA" +"',"+"\""+ "B" +"\"";
			//
			// System.out.println(sql1);

			pst = conn.prepareStatement(sql);

			rs = pst.executeQuery(sql);

			if (rs.next()) {

				resultsetIsNotNull = true;
			} else {
				resultsetIsNotNull = false;
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

	public boolean isResultsetIsNotNull() {
		return resultsetIsNotNull;
	}

}
