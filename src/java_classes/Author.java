package java_classes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="author")
public class Author {

	@Id
	@Column(name="author_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int author_id;
	
	@Column(name="author_name")
	private String author_name;
	
	@Column(name="author_surname")
	private String author_surname;
	
	@ManyToMany
	@JoinTable(name="books_authors", joinColumns=@JoinColumn(name="books_id_fk", referencedColumnName="book_Id"),
	inverseJoinColumns=@JoinColumn(name="authors_id_fk",referencedColumnName="author_id"))
	private List<Book> books;
	
	public Author() {
		
	}

	public Author(int author_id, String author_name, String author_surname) {
		super();
		this.author_id = author_id;
		this.author_name = author_name;
		this.author_surname = author_surname;;
	}

	public String getAuthor_name() {
		return author_name;
	}

	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}
	
	public String getAuthor_surname() {
		return author_surname;
	}

	public void setAuthor_surname(String author_surname) {
		this.author_name = author_surname;
	}

	public int getAuthor_id() {
		return author_id;
	}
	
	
	
	
	
}
