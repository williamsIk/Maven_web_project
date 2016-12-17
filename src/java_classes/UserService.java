package java_classes;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

	public List<User> getAllUsers();
	public User logIn(String username, String password);
	public User findUserByUSername(String username);
}
