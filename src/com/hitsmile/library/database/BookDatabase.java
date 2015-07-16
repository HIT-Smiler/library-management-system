package com.hitsmile.library.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hitsmile.library.myinterface.ShowAll;

public class BookDatabase {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/library";

	static final String USER = "root";
	static final String PASSWORD = "9564";

	private Connection conn = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;

	private ShowAll showAll;
	private String bookSumInformation;

	public BookDatabase(String sql, int functionFlag) {

		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);

			if (functionFlag == 1) {

				pst = conn.prepareStatement(sql);
				pst.execute(sql);

			} else if (functionFlag == 2) {

				pst = conn.prepareStatement(sql);
				pst.execute(sql);

			} else if (functionFlag == 3) {

				pst = conn.prepareStatement(sql);
				pst.execute(sql);

			} else if (functionFlag == 4) {
				pst = conn.prepareStatement(sql);
				rs = pst.executeQuery(sql);

				showAll = new ShowAll();
				while (rs.next()) {
					int bookid = rs.getInt("bookid");
					int booknum = rs.getInt("booknum");
					String pagecount = rs.getString("pagecount");
					String bookprice = rs.getString("bookprice");
					String bookname = rs.getString("bookname");
					String bookauthor = rs.getString("bookauthor");
					String booklocation = rs.getString("booklocation");
					String bookpubdate = rs.getString("bookpubdate");
					String bookpubcomp = rs.getString("bookpubcomp");
					String bookindate = rs.getString("bookindate");
					int restnum = rs.getInt("restnum");
					int sumnum = rs.getInt("sumnum");

					bookSumInformation = "bookid:" + bookid + ",   " + "booknum:" + booknum + ",   " + "pagecount:"
							+ pagecount + ",   " + "bookprice:" + bookprice + ",   " + "bookname:" + bookname + ",   "
							+ "bookauthor:" + bookauthor + ",   " + "booklocation:" + booklocation + ",   "
							+ "bookpubdate:" + bookpubdate + ",   " + "bookpubcomp:" + bookpubcomp + ",   "
							+ "bookindate:" + bookindate + ",   " + "restnum:" + restnum + ",   " + "sumnum:" + sumnum;

					showAll.addStaffInformation(bookSumInformation);
				}

			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
