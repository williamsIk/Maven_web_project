package pages;

import java.util.Iterator;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.IDataProvider;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;

import java_classes.Book;
import java_classes.BookService;

public class HomePage extends WebPage {

	private BookService bookService;
	public HomePage() {
		add(bookDataView());
	}
	//in order to display on the page information about book
	private DataView<Book> bookDataView() {
		return new BookViewObjects("books");
		
		
	}
	//responsible for iterating through objects in Book list
	private class  BookViewObjects extends DataView<Book> {
		
		protected BookViewObjects(String id) {
			super(id,new BookDataProvider());
		}
	//processes objects in the list
		@Override
		protected void populateItem(Item<Book> arg0) {
			// TODO Auto-generated method stub
			arg0.getModelObject();//returns all objects in book list
			
			arg0.add(new Label("book_id"));
			arg0.add(new Label("title"));
			arg0.add(new Label("release_date"));
			arg0.add(new Label("pages"));
		}
	}
	
	private class BookDataProvider implements IDataProvider<Book> {

		@Override
		public void detach() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Iterator<? extends Book> iterator(int arg0, int arg1) {
			// TODO Auto-generated method stub
			
			return bookService.getAllBooks().iterator();
		}

		@Override
		public IModel<Book> model(Book arg0) {
			
			return new CompoundPropertyModel<Book>(arg0);
		}

		@Override
		public int size() {
			
			return bookService.getAllBooks().size();
		}
		
	}
}
