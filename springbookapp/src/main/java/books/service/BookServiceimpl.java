package books.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import books.entity.Book;
import books.exceptions.BookNotFoundException;
import books.repository.BookRepository;

@Service
public class BookServiceimpl implements BookService {
	@Autowired 
	BookRepository repo;
	
	@Override 
	public int addBook(Book book) {
		repo.save(book);
		return book.getBoookId();
	}

	@Override
	public Optional<Book> getBookById(int bookid) {
		Optional<Book> book = repo.findById(bookid);
		if(book.isEmpty())
			throw new BookNotFoundException();
		return book;
	}

	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub 
		return repo.findAll();
		
	}

	@Override
	public void delete(int id) {
		repo.deleteById(id);
		
	}

	@Override
	public void updateBook(Book book) {
		// TODO Auto-generated method stub
		repo.save(book);
		
	} 
	
	
	
	//userdefined method in springboot
	

	@Override
	public List<Book> searchBookByTitle(String title) {
		// TODO Auto-generated method stub
		return repo.searchByTitle(title);
	}
	
	
	

}
