package de.ait.services;

import de.ait.models.SeasonTicket;
import de.ait.models.User;
import de.ait.repositories.UsersRepository;


import java.util.*;

public class UsersServiceImpl implements UsersService {
    private UsersRepository usersRepository;
    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }
    @Override
    public List<User> getAll() {
        return usersRepository.findAll();
    }
    public void userSave(User user){
        usersRepository.save(user);
    }

    @Override
    public User findById(String id) {
        return usersRepository.findById(id);
    }
    @Override
    public SeasonTicket getSeasonTicketByPhone(String phoneNumber) {
        return usersRepository.getSeasonTicketByPhone(phoneNumber);
    }
}


