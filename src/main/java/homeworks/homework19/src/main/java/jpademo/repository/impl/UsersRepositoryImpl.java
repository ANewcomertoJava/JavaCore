package jpademo.repository.impl;

import jpademo.model.Users;
import jpademo.repository.CustomUsersRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

public class UsersRepositoryImpl implements CustomUsersRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Users> findUsersWithComplexCondition(String someParam) {
        return entityManager.createQuery(
                        "SELECT u FROM Users u WHERE u.fio LIKE :param", Users.class)
                .setParameter("param", "%" + someParam + "%")
                .getResultList();
    }
}