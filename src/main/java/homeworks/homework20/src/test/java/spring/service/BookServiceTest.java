package homeworks.homework20.src.test.java.spring.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import spring.entity.Book;
import spring.repository.BookRepository;
import spring.service.BookService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {
    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @Test
    void findAll_ShouldReturnAllBooks() {
        Book book = new Book(1L, "Test Book", "Author", 2023);
        when(bookRepository.findAll()).thenReturn(List.of(book));

        List<Book> result = bookService.findAll();

        assertEquals(1, result.size());
        assertEquals("Test Book", result.get(0).getTitle());
    }

    @Test
    void findById_ShouldReturnBook() {
        Book book = new Book(1L, "Test Book", "Author", 2023);
        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));

        Book result = bookService.findById(1L);

        assertEquals("Test Book", result.getTitle());
    }

    @Test
    void findById_ShouldThrowExceptionWhenNotFound() {
        when(bookRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> bookService.findById(1L));
    }
}