package com.hitsmile.library.management;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

import com.hitsmile.library.information.Student;

public class StudentManagement implements Comparator<Student>{

	public static final int STUDENT_ID = 0;
	public static final int STUDENT_AGE = 1;
	
	public static final int STUDENT_NAME = 2;
	public static final int STUDENT_GENDER = 3;
	public static final int STUDENT_BIRTHDAY = 4;
	public static final int STUDENT_MAJOR = 5;
	public static final int STUDENT_INSTITUDE = 6;
	public static final int STUDENT_GRADE = 7;
	public static final int STUDENT_USER_NAME = 8;
	
	private static StudentManagement studentManagement = new StudentManagement();
	
	private static int markObject = -1;
	
	
	private static ArrayList<Student> students = new ArrayList<Student>();
	private static Iterator<Student> iterator;
	
	public static boolean mAdd(Student student) {
		return students.add(student);		    
	}

	public static boolean mRemove(Student student) {
		return students.remove(student);
	}

	
	public static void mTraverse() {
		iterator = students.iterator();
		while(iterator.hasNext()){
			Student student = iterator.next();
			System.out.println(student.toString());
		}
	}
	
	public static void mSort(int mark) {
		markObject = mark;
		students.sort(studentManagement);
		markObject = -1;
	}
	

	public static ArrayList<Student> mSearch(int mark,int search){
		ArrayList<Student> searchStudent = new ArrayList<Student>();
		iterator = searchStudent.iterator();
		while(iterator.hasNext()){
			Student student = iterator.next();
			switch(mark){
			    case STUDENT_ID:
			    	if(student.getId() == search){
			    		searchStudent.add(student);
			    	}
			    	break;
			    case STUDENT_AGE:
			    	if(student.getAge() == search){
			    		searchStudent.add(student);
			    	}
			    	break;
			}
		}
		return searchStudent;
	}
	
	
	public static ArrayList<Student> mSearch(int mark,String search){
		ArrayList<Student> searchStudent = new ArrayList<Student>();
		iterator = searchStudent.iterator();
		while(iterator.hasNext()){
			Student student = iterator.next();
			switch(mark){
			    case STUDENT_NAME:
			    	if(student.getName().equals(search)){
			    		searchStudent.add(student);
			    	}
			    	break;
			    case STUDENT_GENDER:
			    	if(student.getGender().equals(search)){
			    		searchStudent.add(student);
			    	}
			    	break;
			    case STUDENT_BIRTHDAY:
			    	if(student.getBirthday().equals(search)){
			    		searchStudent.add(student);
			    	}
			    	break;
			    case STUDENT_MAJOR:
			    	if(student.getMajor().equals(search)){
			    		searchStudent.add(student);
			    	}
			    	break;
			    case STUDENT_INSTITUDE:
			    	if(student.getInsitute().equals(search)){
			    		searchStudent.add(student);
			    	}
			    	break;			    
			    case STUDENT_GRADE:
				    if(student.getGrade().equals(search)){
				    	searchStudent.add(student);
				    }
				    break;
			    case STUDENT_USER_NAME:
			    	if(student.getUserName().equals(search)){
			    		searchStudent.add(student);
			    	}
			}
		}
		return searchStudent;
	}
	
	public static boolean isUser(String userName,String password){
		iterator = students.iterator();
		while(iterator.hasNext()){
			Student student = iterator.next();
			if(student.getUserName().equals(userName)){
				if(student.getPassword().equals(password)){
					return true;
				}else{
					return false;
				}
			}
		}
		return false;
	}

	@Override
	public String toString(){
		mTraverse();
		return null;
	}
	

	@Override
	public int compare(Student arg0, Student arg1) {
		int mark = 0;
		switch (markObject){
		    case STUDENT_ID:
		    	if(arg0.getId() < arg1.getId()){
		    		mark = -1;
		    	}else if(arg0.getId() > arg1.getId()){
		    		mark = 1;
		    	}else{
		    		mark = 0;
		    	}
		    	break;
		    case STUDENT_AGE:
		    	if(arg0.getAge() < arg1.getAge()){
		    		mark = -1;
		    	}else if(arg0.getAge() > arg1.getAge()){
		    		mark = 1;
		    	}else{
		    		mark = 0;
		    	}
		    case STUDENT_NAME:
		    	mark = arg0.getName().compareTo(arg1.getName());
		    	break;
		    case STUDENT_GENDER:
		    	mark = arg0.getGender().compareTo(arg1.getGender());
		    	break;
		    case STUDENT_BIRTHDAY:
		    	mark = arg0.getBirthday().compareTo(arg1.getBirthday());
		    	break;		    	
		    case STUDENT_MAJOR:
		    	mark = arg0.getMajor().compareTo(arg1.getMajor());
		    	break;	
		    case STUDENT_INSTITUDE:
		    	mark = arg0.getInsitute().compareTo(arg1.getInsitute());
		    	break;	
		    case STUDENT_GRADE:
		    	mark = arg0.getGrade().compareTo(arg1.getGrade());
		    	break;	
		    case STUDENT_USER_NAME:
		    	mark = arg0.getUserName().compareTo(arg1.getUserName());
		}
		return mark;
	}


}
