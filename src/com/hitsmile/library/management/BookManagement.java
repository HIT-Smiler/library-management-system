package com.hitsmile.library.management;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

import com.hitsmile.library.information.Book;


public class BookManagement extends Management implements Comparator<Book>{
	
	public static final int BOOK_ID = 0;
	public static final int BOOK_NUM = 1;
	public static final int BOOK_PAGE_COUNT = 2;
	
	public static final int BOOK_PRICE = 3;
	
	public static final int BOOK_NAME = 4;
	public static final int BOOK_AUTHOR = 5;
	public static final int BOOK_LOCATION = 6;
	public static final int BOOK_PUB_DATE = 7;
	public static final int BOOK_PUB_COMP = 8;
	public static final int BOOK_IN_DATE = 9;
	
	private int markObject = -1;
	
	
	private ArrayList<Book> books = new ArrayList<Book>();
	private Iterator<Book> iterator;
	
	@Override
	public boolean mAdd(Object object) {
		if(object instanceof Book){
		    books.add((Book)object);
		    return true;
		}
		return false;
	}

	@Override
	public boolean mRemove(Object object) {
		if(object instanceof Book){
		    books.remove((Book)object);
		    return true;
		}
		return false;
	}

	@Override
	public void mTraverse() {
		iterator = books.iterator();
		while(iterator.hasNext()){
			Book book = iterator.next();
			System.out.println(book.toString());
		}
	}
	

	@Override
	public void mSort(int mark) {
		markObject = mark;
		books.sort(this);
		markObject = -1;
	}
	

	public ArrayList<Book> mSearch(int mark,int search){
		ArrayList<Book> searchBook = new ArrayList<Book>();
		iterator = searchBook.iterator();
		while(iterator.hasNext()){
			Book book = iterator.next();
			switch(mark){
			    case 0:
			    	if(book.getId() == search){
			    		searchBook.add(book);
			    	}
			    	break;
			    case 1:
			    	if(book.getNum() == search){
			    		searchBook.add(book);
			    	}
			    	break;
			    case 2:
			    	if(book.getPageCount() == search){
			    		searchBook.add(book);
			    	}
			    	break;
			}
		}
		return searchBook;
	}
	
	public ArrayList<Book> mSearch(int mark,double search){
		ArrayList<Book> searchBook = new ArrayList<Book>();
		iterator = searchBook.iterator();
		while(iterator.hasNext()){
			Book book = iterator.next();
			if(mark == 3){
				if(book.getPrice() == search){
					searchBook.add(book);
				}
			}
		}
		return searchBook;
	}
	
	public ArrayList<Book> mSearch(int mark,String search){
		ArrayList<Book> searchBook = new ArrayList<Book>();
		iterator = searchBook.iterator();
		while(iterator.hasNext()){
			Book book = iterator.next();
			switch(mark){
			    case 4:
			    	if(book.getName().equals(search)){
			    		searchBook.add(book);
			    	}
			    	break;
			    case 5:
			    	if(book.getAuthor().equals(search)){
			    		searchBook.add(book);
			    	}
			    	break;
			    case 6:
			    	if(book.getLocation().equals(search)){
			    		searchBook.add(book);
			    	}
			    	break;
			    case 7:
			    	if(book.getPubDate().equals(search)){
			    		searchBook.add(book);
			    	}
			    	break;
			    case 8:
			    	if(book.getPubComp().equals(search)){
			    		searchBook.add(book);
			    	}
			    	break;
			    case 9:
			    	if(book.getInDate().equals(search)){
			    		searchBook.add(book);
			    	}
			    	break;
			}
		}
		return searchBook;
	}

	@Override
	public String toString(){
		mTraverse();
		return null;
	}
	

	@Override
	public int compare(Book arg0, Book arg1) {
		int mark = 0;
		switch (markObject){
		    case 0:
		    	if(arg0.getId() < arg1.getId()){
		    		mark = -1;
		    	}else if(arg0.getId() > arg1.getId()){
		    		mark = 1;
		    	}else{
		    		mark = 0;
		    	}
		    	break;
		    case 1:
		    	if(arg0.getNum() < arg1.getNum()){
		    		mark = -1;
		    	}else if(arg0.getNum() > arg1.getNum()){
		    		mark = 1;
		    	}else{
		    		mark = 0;
		    	}
		    	break;
		    case 2:
		    	if(arg0.getPageCount() < arg1.getPageCount()){
		    		mark = -1;
		    	}else if(arg0.getPageCount() > arg1.getPageCount()){
		    		mark = 1;
		    	}else{
		    		mark = 0;
		    	}
		    	break;
		    case 3:
		    	if(arg0.getPrice() < arg1.getPrice()){
		    		mark = -1;
		    	}else if(arg0.getPrice() > arg1.getPrice()){
		    		mark = 1;
		    	}else{
		    		mark = 0;
		    	}
		    	break;
		    case 4:
		    	mark = arg0.getName().compareTo(arg1.getName());
		    	break;
		    case 5:
		    	mark = arg0.getAuthor().compareTo(arg1.getAuthor());
		    	break;
		    case 6:
		    	mark = arg0.getLocation().compareTo(arg1.getLocation());
		    	break;		    	
		    case 7:
		    	mark = arg0.getPubDate().compareTo(arg1.getPubDate());
		    	break;	
		    case 8:
		    	mark = arg0.getPubComp().compareTo(arg1.getPubComp());
		    	break;	
		    case 9:
		    	mark = arg0.getInDate().compareTo(arg1.getInDate());
		    	break;	
		}
		return mark;
	}
}