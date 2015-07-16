package com.hitsmile.library.management;

public class StudentManagement {

	// 用于判断选择字符串中的哪一个值
	private int markObject = -1;
	// 传入已知属性的内容

	private String stringField = null;
	private String sql;
	// 如果传入的字符串在数据库中为整形，则需要将其转化为整形
	private int intField;
	private String[] fixField;

	public StudentManagement(int functionFlag, String stringField, int markObject) {
		// super();
		this.markObject = markObject;
		this.stringField = stringField;

		fixField = new String[] { "id", "age", "name", "gender", "birthday", "major", "institute", "grade", "username",
				"password" };

		if (functionFlag == 2) {

			// 删除语句

			if (markObject >= 2) {
				sql = "delete from library.student where " + fixField[markObject] + " like " + "'%" + stringField
						+ "%'";
			} else {
				intField = Integer.parseInt(stringField);
				sql = "delete from library.student where " + fixField[markObject] + " = " + intField;
			}

		} else if (functionFlag == 3) {

		} else if (functionFlag == 4) {
			// 查询语句
			if (markObject >= 2) {
				sql = "select * from library.student where " + fixField[markObject] + " like " + "'%" + stringField
						+ "%'";

			} else {
				intField = Integer.parseInt(stringField);
				sql = "select * from library.student where " + fixField[markObject] + " = " + intField;
			}

		}

	}

	public String getSql() {
		return sql;
	}

	public StudentManagement() {
		super();
		// TODO Auto-generated constructor stub
	}

}
