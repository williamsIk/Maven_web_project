package java_classes;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class BookDAOImpl implements BookDAO {

	@Override
	public List<Book> getAllBooks() {
		
		List<Book> books = new ArrayList<>();
		books = getCurrentSession().createCriteria(Book.class).list();
			
		return books;
	}

	@Override
	public Session getCurrentSession() {
		
		SessionFactory sf = HibernateUtils.getSessionFactory();
		Session session = sf.openSession();
		session = HibernateUtils.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		return session;
	}

	@Override
	public List<Book> getAllBooksByAuthorName(String authorName) {
		// TODO Auto-generated method stub
		List<Book> author_books = new ArrayList<>();
		author_books = getCurrentSession().createCriteria(Book.class).add(Restrictions.eq("author_name", authorName)).list();
		
		
		return author_books;
	}

}
