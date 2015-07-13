package com.hitsmile.library.management;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

import com.hitsmile.library.information.Book;


public class BookManagement implements Comparator<Book>{
	
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
	
	private static BookManagement bookManagement = new BookManagement();
	
	private static int markObject = -1;
	
	
	private static ArrayList<Book> books = new ArrayList<Book>();
	private static Iterator<Book> iterator;
	
	
	public static boolean mAdd(Book book) {
		return books.add(book);		    
	}

	public static boolean mRemove(Book book) {
		return books.remove(book);
	}

	
	public static void mTraverse() {
		iterator = books.iterator();
		while(iterator.hasNext()){
			Book book = iterator.next();
			System.out.println(book.toString());
		}
	}
	
	public static void mSort(int mark) {
		markObject = mark;
		books.sort(bookManagement);
		markObject = -1;
	}
	

	public static ArrayList<Book> mSearch(int mark,int search){
		ArrayList<Book> searchBook = new ArrayList<Book>();
		iterator = searchBook.iterator();
		while(iterator.hasNext()){
			Book book = iterator.next();
			switch(mark){
			    case BOOK_ID:
			    	if(book.getId() == search){
			    		searchBook.add(book);
			    	}
			    	break;
			    case BOOK_NUM:
			    	if(book.getNum() == search){
			    		searchBook.add(book);
			    	}
			    	break;
			    case BOOK_PAGE_COUNT:
			    	if(book.getPageCount() == search){
			    		searchBook.add(book);
			    	}
			    	break;
			}
		}
		return searchBook;
	}
	
	public static ArrayList<Book> mSearch(int mark,double search){
		ArrayList<Book> searchBook = new ArrayList<Book>();
		iterator = searchBook.iterator();
		while(iterator.hasNext()){
			Book book = iterator.next();
			if(mark == BOOK_PRICE){
				if(book.getPrice() == search){
					searchBook.add(book);
				}
			}
		}
		return searchBook;
	}
	
	public static ArrayList<Book> mSearch(int mark,String search){
		ArrayList<Book> searchBook = new ArrayList<Book>();
		iterator = searchBook.iterator();
		while(iterator.hasNext()){
			Book book = iterator.next();
			switch(mark){
			    case BOOK_NAME:
			    	if(book.getName().equals(search)){
			    		searchBook.add(book);
			    	}
			    	break;
			    case BOOK_AUTHOR:
			    	if(book.getAuthor().equals(search)){
			    		searchBook.add(book);
			    	}
			    	break;
			    case BOOK_LOCATION:
			    	if(book.getLocation().equals(search)){
			    		searchBook.add(book);
			    	}
			    	break;
			    case BOOK_PUB_DATE:
			    	if(book.getPubDate().equals(search)){
			    		searchBook.add(book);
			    	}
			    	break;
			    case BOOK_PUB_COMP:
			    	if(book.getPubComp().equals(search)){
			    		searchBook.add(book);
			    	}
			    	break;
			    case BOOK_IN_DATE:
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
		    case BOOK_ID:
		    	if(arg0.getId() < arg1.getId()){
		    		mark = -1;
		    	}else if(arg0.getId() > arg1.getId()){
		    		mark = 1;
		    	}else{
		    		mark = 0;
		    	}
		    	break;
		    case BOOK_NUM:
		    	if(arg0.getNum() < arg1.getNum()){
		    		mark = -1;
		    	}else if(arg0.getNum() > arg1.getNum()){
		    		mark = 1;
		    	}else{
		    		mark = 0;
		    	}
		    	break;
		    case BOOK_PAGE_COUNT:
		    	if(arg0.getPageCount() < arg1.getPageCount()){
		    		mark = -1;
		    	}else if(arg0.getPageCount() > arg1.getPageCount()){
		    		mark = 1;
		    	}else{
		    		mark = 0;
		    	}
		    	break;
		    case BOOK_PRICE:
		    	if(arg0.getPrice() < arg1.getPrice()){
		    		mark = -1;
		    	}else if(arg0.getPrice() > arg1.getPrice()){
		    		mark = 1;
		    	}else{
		    		mark = 0;
		    	}
		    	break;
		    case BOOK_NAME:
		    	mark = arg0.getName().compareTo(arg1.getName());
		    	break;
		    case BOOK_AUTHOR:
		    	mark = arg0.getAuthor().compareTo(arg1.getAuthor());
		    	break;
		    case BOOK_LOCATION:
		    	mark = arg0.getLocation().compareTo(arg1.getLocation());
		    	break;		    	
		    case BOOK_PUB_DATE:
		    	mark = arg0.getPubDate().compareTo(arg1.getPubDate());
		    	break;	
		    case BOOK_PUB_COMP:
		    	mark = arg0.getPubComp().compareTo(arg1.getPubComp());
		    	break;	
		    case BOOK_IN_DATE:
		    	mark = arg0.getInDate().compareTo(arg1.getInDate());
		    	break;	
		}
		return mark;
	}
}