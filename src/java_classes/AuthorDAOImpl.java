package java_classes;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class AuthorDAOImpl implements AuthorDAO {

	@Override
	public Session getCurrentSession() {
		// TODO Auto-generated method stub
		SessionFactory sf = HibernateUtils.getSessionFactory();
		Session session = sf.openSession();
		session = HibernateUtils.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		return session;
		
	}

	@Override
	public List<Author> getAllAuthors() {
		// TODO Auto-generated method stub
		List<Author> authors = new ArrayList<>();
		authors = getCurrentSession().createCriteria(Author.class).list();
			
		return authors;
	}

}
