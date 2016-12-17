package pages;

import java.util.Iterator;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.IDataProvider;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;

import java_classes.Author;
import java_classes.AuthorService;

public class AuthorPage extends WebPage {

	private AuthorService authorService;
	public AuthorPage() {
		
		add(authorDataView());
		
	}
	
	private DataView<Author> authorDataView() {
		
		return new AuthorViewObjects("authors");
	}
	
	private class AuthorViewObjects extends DataView<Author> {
		
		protected AuthorViewObjects(String id) {
			super(id,new AuthorDataProvider());
		}

		@Override
		protected void populateItem(Item<Author> arg0) {
			// TODO Auto-generated method stub
			arg0.getModelObject();
			arg0.add(new Label("author_id"));
			arg0.add(new Label("author_name"));
			arg0.add(new Label("author_surname"));
			
		}
		
		
		
		
	}
	
	private class AuthorDataProvider implements IDataProvider<Author> {
	
		
		@Override
		public void detach() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Iterator<? extends Author> iterator(int arg0, int arg1) {
			// TODO Auto-generated method stub
			return authorService.getAllAuthors().iterator();
		}

		@Override
		public IModel<Author> model(Author arg0) {
			// TODO Auto-generated method stub
			return new CompoundPropertyModel<>(arg0);
		}

		@Override
		public int size() {
			// TODO Auto-generated method stub
			return authorService.getAllAuthors().size();
		}
		
	}
}
