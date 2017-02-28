package com.perapoch.data;

import com.perapoch.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * This interface extends from the Spring Data JPA's repository. This makes it inherit 18 methods for performing
 * common persistence operations.
 * That interface will be implemented at runtime when the app is started by Spring Data.
 * Created by marcal.perapoch on 28/02/2017.
 */
public interface ReadingListRepository extends JpaRepository<Book, Long> {

    List<Book> findByReader(String reader);
}
