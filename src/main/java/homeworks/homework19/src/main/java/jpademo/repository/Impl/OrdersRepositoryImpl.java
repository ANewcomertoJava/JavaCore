package jpademo.repository.Impl;

import jpademo.model.Orders;
import jpademo.repository.OrdersRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class OrdersRepositoryImpl implements OrdersRepository {

    private final JdbcTemplate jdbcTemplate;

    public OrdersRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static class OrdersRowMapper implements RowMapper<Orders> {
        @Override
        public Orders mapRow(ResultSet rs, int rowNum) throws SQLException {
            Orders order = new Orders();
            order.setId(rs.getLong("id"));
            order.setUserId(rs.getLong("user_id"));
            order.setOrderDate(new java.util.Date(rs.getTimestamp("order_date").getTime()));
            order.setTotalNumberOf(rs.getLong("total_number_of"));
            order.setBuyerDiscount(rs.getLong("buyer_discount"));
            return order;
        }
    }

    @Override
    public List<Orders> findAll() {
        return jdbcTemplate.query("SELECT * FROM orders", new OrdersRowMapper());
    }

    @Override
    public Optional<Orders> findById(Long id) {
        String sql = "SELECT * FROM orders WHERE id = ?";
        try {
            Orders order = jdbcTemplate.queryForObject(sql, new OrdersRowMapper(), id);
            return Optional.ofNullable(order);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public List<Orders> findByOrderDate(Date orderDate) {
        String sql = "SELECT * FROM orders WHERE DATE(order_date) = DATE(?)";
        return jdbcTemplate.query(
                sql,
                new OrdersRowMapper(),
                new java.sql.Timestamp(orderDate.getTime())
        );
    }

    @Override
    public void deleteAll() {
        jdbcTemplate.update("DELETE FROM orders");
    }

    @Override
    public Orders save(Orders order) {
        if (order.getId() == null) {
            String sql = "INSERT INTO orders (user_id, order_date, total_number_of, buyer_discount) " +
                    "VALUES (?, ?, ?, ?) RETURNING id";
            Long id = jdbcTemplate.queryForObject(
                    sql,
                    Long.class,
                    order.getUserId(),
                    new java.sql.Timestamp(order.getOrderDate().getTime()),
                    order.getTotalNumberOf(),
                    order.getBuyerDiscount()
            );
            order.setId(id);
        } else {
            String sql = "UPDATE orders SET user_id = ?, order_date = ?, " +
                    "total_number_of = ?, buyer_discount = ? WHERE id = ?";
            jdbcTemplate.update(
                    sql,
                    order.getUserId(),
                    new java.sql.Timestamp(order.getOrderDate().getTime()),
                    order.getTotalNumberOf(),
                    order.getBuyerDiscount(),
                    order.getId()
            );
        }
        return order;
    }
}