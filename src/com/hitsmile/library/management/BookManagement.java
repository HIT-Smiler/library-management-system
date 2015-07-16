package com.hitsmile.library.management;



public class BookManagement {

	// 用于判断选择字符串中的哪一个值
	private int markObject = -1;
	// 传入已知属性的内容
	private String stringField = null;
	private String sql;
	// 如果传入的字符串在数据库中为整形，则需要将其转化为整形
	private int intField;
	private String[] fixField;

	public BookManagement(int functionFlag, String stringField, int markObject) {
		this.markObject = markObject;
		this.stringField = stringField;

		fixField = new String[] { "bookid", "booknum", "pagecount", "bookprice", "bookname", "bookauthor",
				"booklocation", "bookpubdate", "bookpubcomp", "bookindate", "restnum", "sumnum" };

		if (functionFlag == 2) {

			// 删除语句
			if ((markObject >= 4) && (markObject <= 9)) {
				sql = "delete from library.book where " + fixField[markObject] + " like " + "'%" + stringField + "%'";
			} else {
				intField = Integer.parseInt(stringField);
				sql = "delete from library.book where " + fixField[markObject] + " = " + intField;
			}

		} else if (functionFlag == 3) {

		} else if (functionFlag == 4) {
			// 查询语句
			if ((markObject >= 4) && (markObject <= 9)) {
				sql = "select * from library.book where " + fixField[markObject] + " like " + "'%" + stringField + "%'";

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