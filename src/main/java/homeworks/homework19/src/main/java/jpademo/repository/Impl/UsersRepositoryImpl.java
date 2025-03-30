package jpademo.repository.Impl;

import jpademo.model.Users;
import jpademo.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UsersRepositoryImpl implements UsersRepository {

    private final JdbcTemplate jdbcTemplate;

    private final RowMapper<Users> userRowMapper = (rs, rowNum) -> new Users(
            rs.getLong("id"),
            rs.getString("fio")
    );

    @Override
    public List<Users> findAll() {
        String sql = "SELECT * FROM users";
        return jdbcTemplate.query(sql, userRowMapper);
    }

    @Override
    public Optional<Users> findById(Long id) {
        String sql = "SELECT * FROM users WHERE id = ?";
        return Optional.ofNullable(
                jdbcTemplate.queryForObject(sql, userRowMapper, id)
        );
    }

    @Override
    public void deleteAll() {
        String sql = "DELETE FROM users";
        jdbcTemplate.update(sql);
    }

    @Override
    public Users save(Users user) {
        if (user.getId() == null) {
            String sql = "INSERT INTO users (fio) VALUES (?) RETURNING id";
            Long id = jdbcTemplate.queryForObject(sql, Long.class, user.getFio());
            user.setId(id);
        } else {
            String sql = "UPDATE users SET fio = ? WHERE id = ?";
            jdbcTemplate.update(sql, user.getFio(), user.getId());
        }
        return user;
    }
}