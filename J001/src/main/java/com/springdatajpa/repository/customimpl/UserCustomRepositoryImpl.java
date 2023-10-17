package com.springdatajpa.repository.customimpl;

import com.springdatajpa.dto.UserDto;
import com.springdatajpa.model.User;
import com.springdatajpa.modelcustom.UserPost;
import com.springdatajpa.repository.custom.UserCustomRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserCustomRepositoryImpl implements UserCustomRepository {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;



    @Override
    public List<UserPost> getUserPost() {
        String sql = """
                select u.id, u.username, u.password, p.post_name
                from users u join posts p on u.id = p.user_id
                """;
        return namedParameterJdbcTemplate.query(sql, (rs, n) -> {
            return new UserPost(
                    rs.getLong(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4)
            );
        });
    }

    @Override
    public List<UserPost> getUserPostByName(String username) {
        String sql = """
                select u.id, u.username, u.password, p.post_name
                from users u join posts p on u.id = p.user_id
                where u.username = :username
                """;
        Map<String, Object> map = new HashMap<>();
        map.put("username", username);
        return namedParameterJdbcTemplate.query(sql, map, (rs, in) -> {
            return new UserPost(
                    rs.getLong(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4)
            );
        });
    }

    @Override
    public void saveUser(UserDto user) {
        entityManager.persist(new User(user.getUsername(), user.getPassword()));
    }
}
