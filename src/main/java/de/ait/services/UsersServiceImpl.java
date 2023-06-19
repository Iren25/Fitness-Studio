package de.ait.services;

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

        List<User> users = usersRepository.findAll();
        Map<Integer, User> usersMap = new HashMap<>();


    @Override
    public int getTicketIdByName(String firstName, String LastName, String dateOfBirth) {
        return 0;
    }
}
