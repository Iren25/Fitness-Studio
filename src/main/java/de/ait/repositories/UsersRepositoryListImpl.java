package de.ait.repositories;
import de.ait.models.User;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UsersRepositoryListImpl implements UsersRepository {
    @Override
    public List<User> findAll() {
        User user = new User("User1", "User1",
                LocalDate.of(1980, 1, 10), "+49175758934", "1");
        User user1 = new User("User2", "User2",
                LocalDate.of(1976, 4, 4), "+491757785944", "2");
        User user2 = new User("User3", "User3",
                LocalDate.of(1984, 8, 25), "+49151i943736", "3");

        List<User> users = new ArrayList<>();
        users.add(user);
        users.add(user1);
        users.add(user2);

        return users;
    }

    @Override
    public User findById(String id) {
        return null;
    }

    @Override
    public void save(User user) {

    }
}
