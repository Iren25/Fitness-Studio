package de.ait.app;

import de.ait.models.User;
import de.ait.repositories.*;
import de.ait.services.ContractService;
import de.ait.services.ContractServiceImpl;
import de.ait.services.UsersService;
import de.ait.services.UsersServiceImpl;
import org.w3c.dom.ls.LSOutput;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UsersRepository usersRepository = new UsersRepositoryTextFileImpl("users.txt");
        SeasonTicketRepository seasonTicketRepository = new SeasonTicketRepositoryFileImpl("seasonTicket.txt");
        ContractRepository contractRepository = new ContractRepositoryFileImpl("contracts.txt");
        ContractService contractService = new ContractServiceImpl(usersRepository, seasonTicketRepository, contractRepository);
       /* List<User> users = new ArrayList<>();
        users.add(new User("User1", "User1",
                LocalDate.of(1980, 1, 10), "+49175758934", "1"));
        users.add(new User("User2", "User2",
                LocalDate.of(1976, 4, 4), "+491757785944", "2"));
        users.add(new User("User3", "User3",
                LocalDate.of(1984, 8, 25), "+49151943736", "3"));
        String check = contractService.makeContract("1", "2");
        System.out.println(check); */




        }
    }

