package pages;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxSubmitLink;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;

import java_classes.User;
import java_classes.UserService;

@AuthorizeInstantiation("ADMIN")
public class Index extends WebPage {
	public Index()	{
		
	}
	
	protected class LoginForm extends Form<Void> {
		
		User user;
		
		private UserService userService;
		private String loginInputId;
		private String passwordInputId;
		
		public LoginForm(String id) {
			super(id);
			
			user = new User();
			setModel(new CompoundPropertyModel(this));
			
			TextField<String> loginInput = new TextField<String>("loginInputId");
			add(loginInput);
			PasswordTextField passwordInput = new PasswordTextField("passwordInputId");
			add(passwordInput);
			add(new AjaxSubmitLink("buttonSubmit") {

				@Override
				protected void onError(AjaxRequestTarget target, Form<?> form) {
					// TODO Auto-generated method stub
					super.onError(target, form);
				}

				@Override
				protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
					super.onSubmit(target, form);
//					userService.logIn(loginInputId, passwordInputId);
					user = userService.findUserByUSername(loginInputId);
					
				}
				
			});
		}
		
	}
}
