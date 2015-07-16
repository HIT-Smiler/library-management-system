package com.hitsmile.library.management;



public class BookManagement {

	// �����ж�ѡ���ַ����е���һ��ֵ
	private int markObject = -1;
	// ������֪���Ե�����
	private String stringField = null;
	private String sql;
	// ���������ַ��������ݿ���Ϊ���Σ�����Ҫ����ת��Ϊ����
	private int intField;
	private String[] fixField;

	public BookManagement(int functionFlag, String stringField, int markObject) {
		this.markObject = markObject;
		this.stringField = stringField;

		fixField = new String[] { "bookid", "booknum", "pagecount", "bookprice", "bookname", "bookauthor",
				"booklocation", "bookpubdate", "bookpubcomp", "bookindate", "restnum", "sumnum" };

		if (functionFlag == 2) {

			// ɾ�����
			if ((markObject >= 4) && (markObject <= 9)) {
				sql = "delete from library.book where " + fixField[markObject] + " like " + "'%" + stringField + "%'";
			} else {
				intField = Integer.parseInt(stringField);
				sql = "delete from library.book where " + fixField[markObject] + " = " + intField;
			}

		} else if (functionFlag == 3) {

		} else if (functionFlag == 4) {
			// ��ѯ���
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