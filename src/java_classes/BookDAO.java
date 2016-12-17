package java_classes;

import java.util.List;

import org.hibernate.Session;

public interface BookDAO {

	Session getCurrentSession();
	
	List<Book> getAllBooks();
	List<Book> getAllBooksByAuthorName(String authorName);
}
