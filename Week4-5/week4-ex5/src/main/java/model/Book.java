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
}
