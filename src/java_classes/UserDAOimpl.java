package java_classes;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOimpl implements UserDAO {

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
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		List<User> users = new ArrayList<>();
		users = getCurrentSession().createCriteria(User.class).list();
			
		return users;
	}

	@Override
	public User login(String username, String password) {
		User user = new User();
		user = (User) getCurrentSession().createCriteria(User.class).add(Restrictions.eq("users_user_name", username)).add(Restrictions.eq("users_password", password)).uniqueResult();
		
		return user;
	}

	@Override
	public User findUserByUsername(String username) {
		User user = new User();
		user = (User) getCurrentSession().createCriteria(User.class).add(Restrictions.eq("users_user_name", username)).uniqueResult();
		return user;
	}

	
}
