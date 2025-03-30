package jpademo;

import jakarta.annotation.PostConstruct;
import jpademo.model.Orders;
import jpademo.model.Users;
import jpademo.service.UsersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
@Slf4j
public class JpaDemoApplication {
    private final UsersService usersService;

    public static void main(String[] args) {
        SpringApplication.run(JpaDemoApplication.class, args);
    }

    @PostConstruct
    public void init() {
        // Пример использования
        Users newUser = new Users();
        newUser.setFio("Иванов Иван Иванович");
        usersService.saveUser(newUser);

        List<Users> users = usersService.getUsers();
        log.info("Все пользователи: {}", users);
    }
    

}