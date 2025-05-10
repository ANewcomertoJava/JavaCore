package spring.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import spring.entity.Book;
import spring.excpetion.BookNotFoundException;
import spring.repository.BookRepository;

import java.util.List;

@Service
@RequiredArgsConstructor // Lombok для внедрения зависимостей
@Slf4j
public class BookService {
    private final BookRepository bookRepository;

    public List<Book> findAll() {
        log.debug("Все книги");
        return bookRepository.findAll();
    }

    public Book save(Book book) {
        log.debug("Сохранение книги");
        return bookRepository.save(book);
    }

    public void deleteById(Long id) {
        log.debug("Удаление книги");
        bookRepository.deleteById(id);
    }
    public Book findById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
    }
}