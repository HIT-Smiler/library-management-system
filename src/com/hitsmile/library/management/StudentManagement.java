package com.hitsmile.library.management;

public class StudentManagement {

	// �����ж�ѡ���ַ����е���һ��ֵ
	private int markObject = -1;
	// ������֪���Ե�����

	private String stringField = null;
	private String sql;
	// ���������ַ��������ݿ���Ϊ���Σ�����Ҫ����ת��Ϊ����
	private int intField;
	private String[] fixField;

	public StudentManagement(int functionFlag, String stringField, int markObject) {
		// super();
		this.markObject = markObject;
		this.stringField = stringField;

		fixField = new String[] { "id", "age", "name", "gender", "birthday", "major", "institute", "grade", "username",
				"password" };

		if (functionFlag == 2) {

			// ɾ�����

			if (markObject >= 2) {
				sql = "delete from library.student where " + fixField[markObject] + " like " + "'%" + stringField
						+ "%'";
			} else {
				intField = Integer.parseInt(stringField);
				sql = "delete from library.student where " + fixField[markObject] + " = " + intField;
			}

		} else if (functionFlag == 3) {

		} else if (functionFlag == 4) {
			// ��ѯ���
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
