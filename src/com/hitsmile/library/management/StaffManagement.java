package com.hitsmile.library.management;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

import com.hitsmile.library.information.Staff;

public class StaffManagement implements Comparator<Staff>{

	public static final int STAFF_ID = 0;
	public static final int STAFF_AGE = 1;
	
	public static final int STAFF_NAME = 2;
	public static final int STAFF_GENDER = 3;
	public static final int STAFF_BIRTHDAY = 4;
	public static final int STAFF_USER_NAME = 5;
	public static final int STAFF_LOCATION = 6;
	
	private static StaffManagement staffManagement = new StaffManagement();
	
	private static int markObject = -1;
	
	
	private static ArrayList<Staff> staffs = new ArrayList<Staff>();
	private static Iterator<Staff> iterator;
	
	public static boolean mAdd(Staff staff) {
		return staffs.add(staff);		    
	}

	public static boolean mRemove(Staff staff) {
		return staffs.remove(staff);
	}

	
	public static void mTraverse() {
		iterator = staffs.iterator();
		while(iterator.hasNext()){
			Staff staff = iterator.next();
			System.out.println(staff.toString());
		}
	}
	
	public static void mSort(int mark) {
		markObject = mark;
		staffs.sort(staffManagement);
		markObject = -1;
	}
	

	public static ArrayList<Staff> mSearch(int mark,int search){
		ArrayList<Staff> searchStaff = new ArrayList<Staff>();
		iterator = searchStaff.iterator();
		while(iterator.hasNext()){
			Staff staff = iterator.next();
			switch(mark){
			    case STAFF_ID:
			    	if(staff.getId() == search){
			    		searchStaff.add(staff);
			    	}
			    	break;
			    case STAFF_AGE:
			    	if(staff.getAge() == search){
			    		searchStaff.add(staff);
			    	}
			    	break;
			}
		}
		return searchStaff;
	}
	
	
	public static ArrayList<Staff> mSearch(int mark,String search){
		ArrayList<Staff> searchStaff = new ArrayList<Staff>();
		iterator = searchStaff.iterator();
		while(iterator.hasNext()){
			Staff staff = iterator.next();
			switch(mark){
			    case STAFF_NAME:
			    	if(staff.getName().equals(search)){
			    		searchStaff.add(staff);
			    	}
			    	break;
			    case STAFF_GENDER:
			    	if(staff.getGender().equals(search)){
			    		searchStaff.add(staff);
			    	}
			    	break;
			    case STAFF_BIRTHDAY:
			    	if(staff.getBirthday().equals(search)){
			    		searchStaff.add(staff);
			    	}
			    	break;
			    case STAFF_USER_NAME:
			    	if(staff.getUserName().equals(search)){
			    		searchStaff.add(staff);
			    	}
			    case STAFF_LOCATION:
			    	if(staff.getLocation().equals(search)){
			    		searchStaff.add(staff);
			    	}
			}
		}
		return searchStaff;
	}
	
	public static boolean isUser(String userName,String password){
		iterator = staffs.iterator();
		while(iterator.hasNext()){
			Staff staff = iterator.next();
			if(staff.getUserName().equals(userName)){
				if(staff.getPassword().equals(password)){
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
	public int compare(Staff arg0, Staff arg1) {
		int mark = 0;
		switch (markObject){
		    case STAFF_ID:
		    	if(arg0.getId() < arg1.getId()){
		    		mark = -1;
		    	}else if(arg0.getId() > arg1.getId()){
		    		mark = 1;
		    	}else{
		    		mark = 0;
		    	}
		    	break;
		    case STAFF_AGE:
		    	if(arg0.getAge() < arg1.getAge()){
		    		mark = -1;
		    	}else if(arg0.getAge() > arg1.getAge()){
		    		mark = 1;
		    	}else{
		    		mark = 0;
		    	}
		    case STAFF_NAME:
		    	mark = arg0.getName().compareTo(arg1.getName());
		    	break;
		    case STAFF_GENDER:
		    	mark = arg0.getGender().compareTo(arg1.getGender());
		    	break;
		    case STAFF_BIRTHDAY:
		    	mark = arg0.getBirthday().compareTo(arg1.getBirthday());
		    	break;		
		    case STAFF_USER_NAME:
		    	mark = arg0.getUserName().compareTo(arg1.getUserName());
		    case STAFF_LOCATION:
		    	mark = arg0.getLocation().compareTo(arg1.getLocation());
		    }
		return mark;
	}

}
