package jpademo.repository;

import jpademo.model.Users;
import java.util.List;
import java.util.Optional;

public interface UsersRepository {
    List<Users> findAll();
    Optional<Users> findById(Long id);
    void deleteAll();
    Users save(Users user);
}