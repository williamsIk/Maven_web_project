package java_classes;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
@Table(name="books")
public class Book {

	@Id
	@Column(name="book_Id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int book_id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="release_date")
	private Date release_date;
	
	@Column(name="pages")
	private String pages;


	
	@ManyToMany(mappedBy="books")
	private List<Author> authors;
	
	
	public Book(){
		
	}

	public Book(int book_id, String title, Date release_date, String pages ) {
		super();
		this.book_id = book_id;
		this.title = title;
		this.release_date = release_date;
		this.pages = pages;
	}

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getRelease_date() {
		return release_date;
	}

	public void setRelease_date(Date release_date) {
		this.release_date = release_date;
	}
	
	public String getPages() {
		return title;
	}

	public void setPages(String pages) {
		this.pages = pages;
	}
	
}
