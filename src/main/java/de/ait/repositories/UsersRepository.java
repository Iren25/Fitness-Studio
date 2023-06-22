package de.ait.repositories;

import de.ait.models.SeasonTicket;
import de.ait.models.User;

import java.util.List;

public interface UsersRepository {
    List<User> findAll();
    User findById(String id);

    void save(User user);
    SeasonTicket getSeasonTicketByPhone(String phoneNumber);
}
