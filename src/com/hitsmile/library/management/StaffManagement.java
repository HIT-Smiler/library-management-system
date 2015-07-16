package com.hitsmile.library.management;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

import com.hitsmile.library.information.Staff;

public class StaffManagement {

	private int markObject = -1;
	private String stringField = null;
	private String sql;
	private int intField;
	private String[] fixField;

	public StaffManagement(int functionFlag, String stringField, int markObject) {
		// super();
		this.markObject = markObject;
		this.stringField = stringField;

		fixField = new String[] { "id", "age", "name", "gender", "birthday", "username", "password", "location" };

		if (functionFlag == 2) {

			if (markObject >= 2) {
				sql = "delete from library.staff where " + fixField[markObject] + " like " + "'%" + stringField + "%'";
			} else {
				intField = Integer.parseInt(stringField);
				sql = "delete from library.staff where " + fixField[markObject] + " = " + intField;
			}

		} else if (functionFlag == 3) {

		} else if (functionFlag == 4) {
			if (markObject >= 2) {
				sql = "select * from library.staff where " + fixField[markObject] + " like " + "'%" + stringField
						+ "%'";

			} else {
				intField = Integer.parseInt(stringField);
				sql = "select * from library.staff where " + fixField[markObject] + " = " + intField;
			}

		}

	}

	public String getSql() {
		return sql;
	}

	public StaffManagement() {
		super();
		// TODO Auto-generated constructor stub
	}

}
