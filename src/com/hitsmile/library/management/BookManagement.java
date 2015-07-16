package com.hitsmile.library.management;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

import com.hitsmile.library.information.Book;

public class BookManagement {

	private int markObject = -1;
	private String stringField = null;
	private String sql;
	private int intField;
	private String[] fixField;

	public BookManagement(int functionFlag, String stringField, int markObject) {
		this.markObject = markObject;
		this.stringField = stringField;

		fixField = new String[] { "bookid", "booknum", "pagecount", "bookprice", "bookname", "bookauthor",
				"booklocation", "bookpubdate", "bookpubcomp", "bookindate", "restnum", "sumnum" };

		if (functionFlag == 2) {

			if ((markObject >= 4) && (markObject <= 9)) {
				sql = "delete from library.book where " + fixField[markObject] + " like " + "'%" + stringField + "%'";
			} else {
				intField = Integer.parseInt(stringField);
				sql = "delete from library.book where " + fixField[markObject] + " = " + intField;
			}

		} else if (functionFlag == 3) {

		} else if (functionFlag == 4) {
			if ((markObject >= 4) && (markObject <= 9)) {
				sql = "select * from library.book where " + fixField[markObject] + " like " + "'%" + stringField
						+ "%'";

			} else {
				intField = Integer.parseInt(stringField);
				sql = "select * from library.book where " + fixField[markObject] + " = " + intField;
			}

		}

	}

	public String getSql() {
		return sql;
	}

	public BookManagement() {
		super();
		// TODO Auto-generated constructor stub
	}

}