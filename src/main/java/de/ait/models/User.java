package de.ait.models;
import java.time.LocalDate;

public class User {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String phoneNumber;
    private String userId;

    public User(String firstName, String lastName, LocalDate dateOfBirth, String phoneNumber, String userId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.userId=userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "Клиент: " +
                "имя: " + firstName +
                ", фамилия: " + lastName +
                ", дата рождения: " + dateOfBirth +
                ", номер телефона: " + phoneNumber +
                ", номер паспорта: " + userId;
    }
}

