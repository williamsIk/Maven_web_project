package java_classes;

import java.util.List;

import org.hibernate.Session;

public interface UserDAO {
	
	Session getCurrentSession();
	
	List<User> getAllUsers();
	
	User login(String username, String password);

	User findUserByUsername(String username);

}
