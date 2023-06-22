package de.ait.services;
import de.ait.models.User;
import java.util.List;

public interface UsersService {
    List<User> getAll();
    int getTicketIdByName(String firstName, String LastName, String dateOfBirth);

}
