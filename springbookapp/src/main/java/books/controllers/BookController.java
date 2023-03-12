package books.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import books.entity.Book;
import books.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {
	@Autowired 
	BookService service ;
	@PostMapping 
	public ResponseEntity<String> addNewbook(@RequestBody Book book){
		int id = service.addBook(book);
		return new ResponseEntity<String>("book inserted"+id,HttpStatus.OK);
	}
	
	
	
	@GetMapping
	public ResponseEntity<List<Book>> getAllBooks(){
			List<Book> bookList = service.getAllBooks();
			return new ResponseEntity<List<Book>>(bookList, HttpStatus.OK);
		}
			
	@GetMapping("/{bookid}")
	public ResponseEntity<Optional<Book>> getBookId (@PathVariable("bookid") int bookid){
		Optional<Book> book = service.getBookById(bookid);
		return new ResponseEntity<Optional<Book>>(book,HttpStatus.OK);
	} 
		

			 
	@DeleteMapping("/{bookid}")

	public ResponseEntity<String> deleteBook(@PathVariable("bookid") int bookId) {
		service.delete(bookId);
		return new ResponseEntity<String>("book deleted" +bookId,HttpStatus.OK);
		}
					
	@PutMapping
	public ResponseEntity<String> updateBook(@RequestBody Book book){
		service.updateBook(book);
		return new ResponseEntity<String> ("updated",HttpStatus.OK);
						
						
	} 
	
	// 
	@GetMapping("/title/{title}")
	public ResponseEntity<List<Book>> searchByTitle(@PathVariable("title") String title){
		List<Book> bookList = service.searchBookByTitle(title);
		return new ResponseEntity<>(bookList , HttpStatus.OK);
	}
	
				 

	
	
}
