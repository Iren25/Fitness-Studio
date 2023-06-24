package de.ait.repositories;


import de.ait.models.SeasonTicket;
import de.ait.models.TypeOfTicket;
import de.ait.models.User;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UsersRepositoryTextFileImpl implements UsersRepository {

    private String fileName;
    private List<User> users;

    public UsersRepositoryTextFileImpl(String fileName) {

        this.fileName = fileName;
        this.users = new ArrayList<>();
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line = bufferedReader.readLine();
            while (line != null) {
                User user = parseLine(line);
                users.add(user);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            System.err.println("Произошла ошибка");
        }
        return users;
    }

    @Override
    public void save(User user) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("users.txt", true))) {
            writer.write(user.getFirstName() + "|" +
                    user.getLastName() + "|" +
                    user.getDateOfBirth().toString() + "|" +
                    user.getPhoneNumber() + "|" +
                    user.getUserId());
            writer.newLine();
        } catch (IOException e) {
            throw new IllegalStateException("Проблемы с файлом");
        }
    }

    private static User parseLine(String line) {
        String[] parsed = line.split("\\|");
        String firstName = parsed[0];
        String lastName = parsed[1];
        LocalDate dateOfBirth = LocalDate.parse(parsed[2]);
        String phoneNumber = parsed[3];
        String userId = parsed[4];
        return new User(
                firstName, lastName, dateOfBirth, phoneNumber, userId);
    }

    @Override
    public User findById(String id) {
        for (User user : findAll()) {
            if (id.equals(user.getUserId())) {
                return user;
            }
        }
        throw new IllegalArgumentException();
    }

    public SeasonTicket getSeasonTicketByPhone(String phoneNumber) {
        String userId = "";
        String ticketID = "";

        try (BufferedReader reader = new BufferedReader(new FileReader("users.txt"))) {
            userId = reader.lines()
                    .map(line -> line.split("\\|"))
                    .filter(parsed -> parsed[3].equals(phoneNumber))
                    .map(parsed -> parsed[4]).findAny().orElse(null);
        } catch (IOException e) {
            throw new IllegalStateException("Проблемы с файлом");
        }

        try (BufferedReader reader = new BufferedReader(new FileReader("contracts.txt"))) {
            final String id = userId;
            ticketID = reader.lines()
                    .map(line -> line.split("\\|"))
                    .filter(parsed -> parsed[3].equals(id))
                    .map(parsed -> parsed[2]).findAny().orElse(null);
        } catch (IOException e) {
            throw new IllegalStateException("Проблемы с файлом");
        }

        try (BufferedReader reader = new BufferedReader(new FileReader("seasonTickets.txt"))) {
            final String id = ticketID;
            List<String> list = reader.lines()
                    .map(line -> line.split("\\|"))
                    .filter(parsed -> parsed[0].equals(id))
                    .map(Arrays::asList)
                    .findFirst().orElse(Collections.emptyList());
            if (!list.isEmpty()) {
                String seasonTicketId = list.get(0);
                LocalDate begin = LocalDate.parse(list.get(1));
                LocalDate end = LocalDate.parse(list.get(2));
                TypeOfTicket type = TypeOfTicket.valueOf(list.get(3));

                return new SeasonTicket(seasonTicketId, begin, end, type);
            }
        } catch (IOException e) {
            throw new IllegalStateException("Проблемы с файлом");
        }
        return null;

    }
}


