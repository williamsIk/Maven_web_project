package java_classes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO user_dao;
	@Override
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<>();
		users = user_dao.getAllUsers();
		// TODO Auto-generated method stub
		return users;
	}
	@Override
	public User logIn(String username, String password) {
		return user_dao.login(username, password);
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = findUserByUSername(username);
		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		if (user != null) {
			authorities.add(new GrantedAuthorityImpl("ADMIN"));
		}

		org.springframework.security.core.userdetails.User securedUser = new org.springframework.security.core.userdetails.User(username, user.getUsers_password(), true,true, true, true, authorities);

		
		return securedUser;
	}
	@Override
	public User findUserByUSername(String username) {
		return user_dao.findUserByUsername(username);
	}

}
