package books.service;

import java.util.List;
import java.util.Optional;

import books.entity.Book;

public interface BookService { 
	int addBook(Book book);

	Optional<Book> getBookById(int bookid);
	List<Book> getAllBooks(); 
	void delete(int id);
	void updateBook(Book book);
	List<Book> searchBookByTitle(String title);
}
