package java_classes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private AuthorDAO author_dao;
	
	@Override
	public List<Author> getAllAuthors() {
		List<Author> authors = new ArrayList<>();
		authors = author_dao.getAllAuthors();
		// TODO Auto-generated method stub
		return authors;
	}

}
