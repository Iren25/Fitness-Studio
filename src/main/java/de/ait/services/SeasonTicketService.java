package de.ait.services;
import de.ait.models.SeasonTicket;
import java.util.List;

public interface SeasonTicketService {
    List<SeasonTicket> getAll();
    void save(SeasonTicket seasonTicket);
    SeasonTicket findById(String id);
}
