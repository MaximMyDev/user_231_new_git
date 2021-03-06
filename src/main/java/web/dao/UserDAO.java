package web.dao;
import org.springframework.stereotype.Repository;
import web.model.User;
import java.util.List;

//@Repository
public interface UserDAO {
    List<User> allUsers();
    void add(User user);
    void delete(User user);
    void edit(User user);
    User getById(int id);
}