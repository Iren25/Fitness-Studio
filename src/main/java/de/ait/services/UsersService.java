package de.ait.services;
import de.ait.models.SeasonTicket;
import de.ait.models.User;
import java.util.List;

public interface UsersService {

     List<User> getAll();

     void userSave(User user);
     User findById(String id);
     SeasonTicket getSeasonTicketByPhone(String phoneNumber);
}
