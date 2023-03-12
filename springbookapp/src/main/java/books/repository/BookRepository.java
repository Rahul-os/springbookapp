package books.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import books.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> { 
	
	//custom methods can be implemented in spring boot by following
	
	@Query(value = "select bk from Book bk where bk.title like %?1%")
	List<Book> searchByTitle(String title);

}
