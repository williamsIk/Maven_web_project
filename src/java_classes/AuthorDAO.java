package java_classes;
import java.util.List;

import org.hibernate.Session;

public interface AuthorDAO {


	Session getCurrentSession();
	
	List<Author> getAllAuthors();
}
