package de.ait.app;

import de.ait.models.Contract;
import de.ait.models.SeasonTicket;
import de.ait.models.TypeOfTicket;
import de.ait.models.User;
import de.ait.repositories.*;
import de.ait.services.ContractService;
import de.ait.services.ContractServiceImpl;
import java.time.LocalDate;
import java.util.UUID;


public class Main {
    public static void main(String[] args) {
        UsersRepository usersRepository = new UsersRepositoryTextFileImpl("users.txt");
        SeasonTicketRepository seasonTicketRepository = new SeasonTicketRepositoryFileImpl("seasonTicket.txt");
        ContractRepository contractRepository = new ContractRepositoryFileImpl("contracts.txt");
        ContractService contractService = new ContractServiceImpl(usersRepository, seasonTicketRepository, contractRepository);
        /*List<User> users = new ArrayList<>();
        users.add(new User("User1", "User1",
                LocalDate.of(1980, 1, 10), "+49175758934", "1"));
        users.add(new User("User2", "User2",
                LocalDate.of(1976, 4, 4), "+491757785944", "2"));
        users.add(new User("User3", "User3",
                LocalDate.of(1984, 8, 25), "+49151943736", "3")); */
        //String check = contractService.makeContract("1", "1");
        //System.out.println(check);
        //List<SeasonTicket> seasonTicketList = seasonTicketRepository.findAll();
        //seasonTicketList.add(new SeasonTicket(TypeOfTicket.GYM, LocalDate.of(2023, 07, 14), LocalDate.of(2024, 07, 13), "1"));
        //List<SeasonTicket> seasonTicketList = seasonTicketRepository.findAll();
        //System.out.println(seasonTicketList);
        //System.out.println();
       //usersRepository.save(new User("Oleg", "Petrov", LocalDate.of(1990, 8, 10),
      // "+4978465725328", "3"));
       // String check2 = contractService.makeContract("3", "2");
        //System.out.println(check2);
        usersRepository.save(new User("Andrej","Semashko",LocalDate.of(1997,03,15),"+4569321456","33"));
        System.out.println(seasonTicketRepository.findById("24"));
        String check3 = contractService.makeContract("33","23");
        System.out.println(check3);
        seasonTicketRepository.save(new SeasonTicket(TypeOfTicket.GYMANDGROUP, LocalDate.of(2023,07,01),LocalDate.of(2024,06,30),"25"));

    }
    }

