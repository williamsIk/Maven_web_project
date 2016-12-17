package java_classes;

import org.apache.wicket.authorization.IAuthorizationStrategy;
import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.injection.Injector;
import org.apache.wicket.request.Request;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecureWebSession extends AuthenticatedWebSession {

	@SpringBean(name = "authenticationManager")
	private AuthenticationManager authentificationManager;
	Authentication authentication;
	
	public SecureWebSession(Request request) {
		super(request);
		Injector.get().inject(this);
		if (authentificationManager == null) {
			throw new IllegalStateException("Auhtentication Manager is empty");
			
		}
		
		
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public boolean authenticate(String username, String password) {
		// TODO Auto-generated method stub
		boolean flag = false;
		authentication = authentificationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		flag = authentication.isAuthenticated();
		return flag;
	}

	@Override
	public Roles getRoles() {
		
		// TODO Auto-generated method stub
		//roles defined by Spring
		Roles roles = new Roles();
		if (authentication != null) {
			
			for (GrantedAuthority grantedAuthority : authentication.getAuthorities()) {
				roles.add(grantedAuthority.getAuthority());
			}
			
		} else {
			//roles statically defined in ApplicationSecurityContext.xml
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			for (GrantedAuthority grantedAuthority : auth.getAuthorities()) {
				roles.add(grantedAuthority.getAuthority());
			}
		}
		
		return roles;
	}

}
