package Repo.RepoDB;


import Domain.User;
import Domain.Validator.UserValidator;

import javax.xml.validation.Validator;
import java.sql.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class UtilizatorDbRepository {

    private String url;

    private String username;

    private String password;
    private UserValidator validatoruser;

    public UtilizatorDbRepository(String url, String username, String password, UserValidator validatoruser) {
        this.url = url;
        this.username = username;
        this.password = password;
        this.validatoruser = validatoruser;
    }

    public Optional<User> findOne(Long aLong) {
        return Optional.empty();
    }

    public Iterable<User> findAll() {
        Set<User> users = new HashSet<>();
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement("SELECT * from users");
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int age = resultSet.getInt("age");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");

                User utilizator = new User(id,age,firstName, lastName);
                //utilizator.setId(id);
                users.add(utilizator);
            }
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }


    public Optional<User> save(User entity) throws Exception {
        String sql = "insert into users (age,first_name, last_name) values (?, ?)";
        validatoruser.userValidate(entity);
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1,entity.getId());
            ps.setInt(2,entity.getAge());
            ps.setString(3, entity.getFirstName());
            ps.setString(4, entity.getLastName());

            ps.executeUpdate();
        } catch (SQLException e) {
            //e.printStackTrace();
            return Optional.ofNullable(entity);
        }
        return Optional.empty();
    }


    public Optional<User> delete(Long aLong) {
        return Optional.empty();
    }


    public Optional<User> update(User entity) {
        return Optional.empty();
    }
}
