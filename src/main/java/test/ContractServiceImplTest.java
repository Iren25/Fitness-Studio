package test;

import de.ait.models.Contract;
import de.ait.models.SeasonTicket;
import de.ait.models.TypeOfTicket;
import de.ait.models.User;
import de.ait.repositories.*;
import de.ait.services.ContractService;
import de.ait.services.ContractServiceImpl;
import de.ait.services.UsersServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class ContractServiceImplTest {
    private UsersRepositoryListImpl usersRepositoryList;
    private SeasonTicketRepositoryList seasonTicketRepositoryList;
    private ContractRepositoryList contractRepositoryList;
    private ContractServiceImpl contractService;

    @BeforeEach
    void setUp() {
        this.usersRepositoryList = new UsersRepositoryListImpl();
        this.seasonTicketRepositoryList = new SeasonTicketRepositoryList();
        this.contractRepositoryList = new ContractRepositoryList();
        this.contractService = new ContractServiceImpl(this.usersRepositoryList, this.seasonTicketRepositoryList,
                contractRepositoryList);
    }

    @Test
    void makeContract() {
        String actual = contractService.makeContract("1", "2");
        String expected = "Договор № " + UUID.randomUUID().toString() +
                " был заключен с User1 User1 " + LocalDate.now();
        assertEquals(expected, actual);
    }
}
