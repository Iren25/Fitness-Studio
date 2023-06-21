package de.ait.services;

import de.ait.models.Contract;
import de.ait.models.SeasonTicket;
import de.ait.models.User;
import de.ait.repositories.ContractRepository;
import de.ait.repositories.SeasonTicketRepository;
import de.ait.repositories.UsersRepository;

import java.time.LocalDate;
import java.util.UUID;

public class ContractServiceImpl implements ContractService {
    private UsersRepository usersRepository;
    private SeasonTicketRepository seasonTicketRepository;
    private ContractRepository contractRepository;


    public ContractServiceImpl(UsersRepository usersRepository, SeasonTicketRepository seasonTicketRepository, ContractRepository contractRepository) {
        this.usersRepository = usersRepository;
        this.seasonTicketRepository = seasonTicketRepository;
        this.contractRepository = contractRepository;
    }

    @Override
    public String makeContract(String userId, String id) {
        User user = usersRepository.findById(userId);
        if (user == null){
            throw new IllegalArgumentException("Пользователь не найден");
        }
        SeasonTicket seasonTicket = seasonTicketRepository.findById(id);
        if (seasonTicket == null){
            throw new IllegalArgumentException("Абонемент не найден");
        }
        Contract contract = new Contract(UUID.randomUUID().toString(), LocalDate.now(),
                seasonTicket.getId(),user.getUserId());
        contractRepository.save(contract);
        return "Договор №" + contract.getId() + "был заключен с " + user.getFirstName()
                + " " + user.getLastName() + contract.getDate();
    }
}
