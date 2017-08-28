package javabeans;

import java.util.ArrayList;
import java.util.*;

public class BookBean {
	List<String> books;
	public BookBean(){
		this.books=new ArrayList<String>();
	}
	public void addBook(String book[]){
		for(String s:book){
			this.books.add(s);
		}
	}
	public List<String> getBook(){
		return books;
	}
}
