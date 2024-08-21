package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private int id;
    private String title;
    private String author;
    private double price;
    private String isbn;
	public Book(int i, String string, String string2, double d, String string3) {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}
	public void setId(int id2) {
		// TODO Auto-generated method stub
		
	}
	public String getAuthor() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}
	public void setTitle(String title) {
		// TODO Auto-generated method stub
		
	}
	public void setAuthor(String author2) {
		// TODO Auto-generated method stub
		
	}
	public Object getPrice() {
		// TODO Auto-generated method stub
		return null;
	}
	public Object getIsbn() {
		// TODO Auto-generated method stub
		return null;
	}
	public void setPrice(Object price2) {
		// TODO Auto-generated method stub
		
	}
	public void setIsbn(Object isbn2) {
		// TODO Auto-generated method stub
		
	}
	
}
