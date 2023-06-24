package de.ait.app;
import de.ait.models.Contract;
import de.ait.models.SeasonTicket;
import de.ait.models.TypeOfTicket;
import de.ait.models.User;
import de.ait.repositories.*;
import de.ait.services.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;


public class
Main {
    public static void main(String[] args) {
        UsersRepository usersRepository = new UsersRepositoryTextFileImpl("users.txt");
        UsersService usersService = new UsersServiceImpl(usersRepository);

        SeasonTicketRepository seasonTicketRepository = new SeasonTicketRepositoryFileImpl("seasonTicket.txt");
        SeasonTicketService seasonTicketService = new SeasonTicketServiceImpl(seasonTicketRepository);
        ContractRepository contractRepository = new ContractRepositoryFileImpl("contracts.txt");
        ContractService contractService = new ContractServiceImpl(usersRepository, seasonTicketRepository, contractRepository);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Операции для заключения договора: ");
            System.out.println("1. Сохранить данные клиента");
            System.out.println("2. Сохранить описание абонемента");
            System.out.println("3. Заключить договор");

            System.out.println("4. Вывести на экран весь список клиентов");
            System.out.println("5. Вывести на экран список абонементов");
            System.out.println("6. Вывести на экран все договоры");

            System.out.println("7. Найти клиента по номеру его ID");
            System.out.println("8. Найти абонемент по номеру телефона клиента");
            System.out.println("9. Найти абонемент по его номеру ID");
            System.out.println("10. Найти договор по номеру его ID");
            System.out.println("0. Выход");

            int command = scanner.nextInt();
            scanner.nextLine();
            switch (command) {
                case 1:
                    System.out.println("Введите имя клиента: ");
                    String firstName = scanner.nextLine();
                    System.out.println("Введите фамилию клиента: ");
                    String lastName = scanner.nextLine();
                    System.out.println("Введите дату рождения клиента: ");
                    LocalDate dateOfBirth = LocalDate.parse(scanner.nextLine(),
                            DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    System.out.println("Введите номер телефона клиента: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.println("Введите номер паспорта клиента: ");
                    String userId = scanner.nextLine();
                    usersRepository.save(new User(firstName, lastName, dateOfBirth,
                            phoneNumber, userId));
                    break;
                case 2:
                    System.out.println("Введите название абонемента: ");
                    TypeOfTicket typeOfTicket = TypeOfTicket.valueOf(scanner.nextLine());
                    System.out.println("Введите дату начала абонемента: ");
                    LocalDate begin = LocalDate.parse(scanner.nextLine());
                    System.out.println("Введите дату окончания абонемента: ");
                    LocalDate end = LocalDate.parse(scanner.nextLine());
                    System.out.println("Введите номер абонемента: ");
                    String ticketId = scanner.nextLine();
                    seasonTicketRepository.save(new SeasonTicket(ticketId, begin, end, typeOfTicket));
                    break;
                case 3:
                    System.out.println("Введите номер паспорта клиента: ");
                    userId = scanner.nextLine();
                    System.out.println("Введите номер абонемента: ");
                    String contractId = scanner.nextLine();
                    String contract = contractService.makeContract(userId, contractId);
                    System.out.println(contract);
                    break;
                case 4:
                    System.out.println("Список клиентов:");
                    List<User> users = usersService.getAll();
                    for (User user : users) {
                        System.out.println(user);
                    }
                    break;
                case 5:
                    System.out.println("Список абонементов:");
                    List<SeasonTicket> seasonTickets = seasonTicketService.getAll();
                    for (SeasonTicket seasonTicket : seasonTickets) {
                        System.out.println(seasonTicket);
                    }
                    break;
                case 6:
                    System.out.println("Список договоров:");
                    List<Contract> contracts = contractService.getAll();
                    for (Contract contract1 : contracts) {
                        System.out.println(contract1);
                    }
                    break;
                case 7:
                    System.out.println("Введите номер паспорта клиента: ");
                    userId = scanner.nextLine();
                    System.out.println(usersService.findById(userId));
                    break;
                case 8:
                    System.out.println("Введите номер телефона клиента: ");
                    String phone = scanner.nextLine();
                    System.out.println(usersService.getSeasonTicketByPhone(phone));
                    break;

                case 9:
                    System.out.println("Введите номер абонемента: ");
                    ticketId = scanner.nextLine();
                    System.out.println(seasonTicketService.findById(ticketId));
                    break;
                case 10:
                    System.out.println("Введите номер договора: ");
                    contractId = scanner.nextLine();
                    System.out.println(contractService.findById(contractId));
                    break;
                case 0:
                    System.out.println("Выход");
                    System.exit(0);
                default:
                    System.out.println("Команда не распознана");
            }
        }
    }
}

