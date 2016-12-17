package java_classes;

import org.apache.wicket.Page;
import org.apache.wicket.Session;
import org.apache.wicket.authroles.authentication.AbstractAuthenticatedWebSession;
import org.apache.wicket.authroles.authentication.AuthenticatedWebApplication;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AnnotationsRoleAuthorizationStrategy;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Response;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
import org.apache.wicket.util.file.WebApplicationPath;

import pages.HomePage;
import pages.Index;

public class Application extends AuthenticatedWebApplication {


	private boolean flag = false;

	@Override
	public Class<Index> getHomePage() {
		// TODO Auto-generated method stub
		return Index.class;
	}
	@SuppressWarnings("deprecation")
	@Override
	protected void init() {
		if (!flag) {
			super.init();
			getComponentInstantiationListeners().add(new SpringComponentInjector(this));//defined relationship between application and spring context
			
			final WebApplicationPath resourceFinder = (WebApplicationPath) getResourceSettings().getResourceFinder();
			if (getServletContext().getRealPath("").contains("WebContent")) {
				resourceFinder.add("WebContent");
			} else {
				resourceFinder.add("");
			}
			flag = true;
		}
		
		getSecuritySettings().setAuthorizationStrategy(new AnnotationsRoleAuthorizationStrategy(this));
	}

	@Override
	public Session newSession(Request arg0, Response arg1) {
		return new SecureWebSession(arg0);
	}

	@Override
	protected Class<? extends WebPage> getSignInPageClass() {
		return Index.class;
	}

	@Override
	protected Class<? extends AbstractAuthenticatedWebSession> getWebSessionClass() {
		return SecureWebSession.class;
	}

	
}
