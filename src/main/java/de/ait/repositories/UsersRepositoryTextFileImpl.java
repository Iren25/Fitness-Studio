package de.ait.repositories;

import de.ait.models.User;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
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
        try (FileWriter fileWriter = new FileWriter(fileName, true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            String line = user.toString();
            bufferedWriter.newLine();
            bufferedWriter.write(line);
        } catch (IOException e) {
            System.err.println("Произошла ошибка записи в файл");
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
        for (User user : users) {
            if (id.equals(user.getUserId())) {
                return user;
            }
        }
        throw new IllegalArgumentException();
    }
}
