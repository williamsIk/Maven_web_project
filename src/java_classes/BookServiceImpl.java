package java_classes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookDAO book_dao;
	
	@Override
	public List<Book> getAllBooks() {
		List<Book> books = new ArrayList<>();
		books = book_dao.getAllBooks();
		// TODO Auto-generated method stub
		return books;
	}

}
