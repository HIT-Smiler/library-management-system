package com.hitsmile.library.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hitsmile.library.myinterface.ShowAll;

public class StaffDatabase {
	// 加载JDBC驱动，同时预置mysql用户名及密码
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

	// 增删改查操作所调用的构造器
	public StaffDatabase(String sql, int functionFlag) {
		try {
			// 加载驱动
			Class.forName(JDBC_DRIVER);

			conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

			// 添加
			if (functionFlag == 1) {

				pst = conn.prepareStatement(sql);
				pst.execute(sql);

				// 删除
			} else if (functionFlag == 2) {

				pst = conn.prepareStatement(sql);
				pst.execute(sql);
				// rs = pst.executeQuery(sql);

				// 修改
			} else if (functionFlag == 3) {

				pst = conn.prepareStatement(sql);
				pst.execute(sql);

				// 查询
			} else if (functionFlag == 4) {

				pst = conn.prepareStatement(sql);
				rs = pst.executeQuery(sql);

				showAll = new ShowAll();
				// 遍历
				while (rs.next()) {
					int id = rs.getInt("id");
					int age = rs.getInt("age");
					String name = rs.getString("name");
					String gender = rs.getString("gender");
					String birthday = rs.getString("birthday");
					String username = rs.getString("username");
					String password = rs.getString("password");
					String location = rs.getString("location");

					staffSumInformation = "id:" + id + ",   " + "age:" + age + ",   " + "name:" + name + ",   "
							+ "gender:" + gender + ",   " + "birthday:" + birthday + ",   " + "username:" + username
							+ ",   " + "password:" + password + ",   " + "location:" + location;

					// 显示结果
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

	// 用户登录时用于用户名密码匹配时调用的构造器
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
