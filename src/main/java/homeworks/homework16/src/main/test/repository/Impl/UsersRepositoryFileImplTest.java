package attestation01.repository.Impl;


import attestations.attestation01.exceptions.UserNotFoundException;
import attestations.attestation01.model.User;
import attestations.attestation01.repository.Impl.UsersRepositoryFileImpl;
import attestations.attestation01.repository.UsersRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class UsersRepositoryFileImplTest {
    private UsersRepository repository;

    @BeforeEach
    void setUp() {
        repository = new UsersRepositoryFileImpl();
    }

    @Test
    void testCreateAndFindUser() {
        User user = new User("123", LocalDateTime.now(), "login", "password", "password", "Иванов", "Иван", "Иванович", 30, false);
        repository.create(user);
        User foundUser = repository.findById("123");
        assertEquals(user.getId(), foundUser.getId());
    }

    @Test
    void testUserNotFound() {
        assertThrows(UserNotFoundException.class, () -> repository.findById("999"));
    }

    @Test
    void testUpdateUser() {
        User user = new User("123", LocalDateTime.now(), "login", "password", "password", "Иванов", "Иван", "Иванович", 30, false);
        repository.create(user);
        user.setAge(35);
        repository.update(user);
        User updatedUser = repository.findById("123");
        assertEquals(35, updatedUser.getAge());
    }

    @Test
    void testDeleteUser() {
        User user = new User("123", LocalDateTime.now(), "login", "password", "password", "Иванов", "Иван", "Иванович", 30, false);
        repository.create(user);
        repository.deleteById("123");
        assertThrows(UserNotFoundException.class, () -> repository.findById("123"));
    }
}
