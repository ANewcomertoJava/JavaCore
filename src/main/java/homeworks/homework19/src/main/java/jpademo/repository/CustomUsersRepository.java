package jpademo.repository;

import jpademo.model.Users;
import java.util.List;

public interface CustomUsersRepository {
    List<Users> findUsersWithComplexCondition(String someParam);
}