package jpademo.service;

import jpademo.model.Users;
import jpademo.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsersService {
    private final UsersRepository usersRepository;

    public List<Users> getUsers() {
        return usersRepository.findAll();
    }

    public Users getById(Long id) {
        return usersRepository.findById(id).orElse(null);
    }

    public void deleteAll() {
        usersRepository.deleteAll();
    }

    public Users saveUser(Users user) {
        return usersRepository.save(user);
    }
}