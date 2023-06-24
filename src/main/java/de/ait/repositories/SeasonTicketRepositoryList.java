package de.ait.repositories;
import de.ait.models.SeasonTicket;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static de.ait.models.TypeOfTicket.GYM;

public class SeasonTicketRepositoryList implements SeasonTicketRepository {

    @Override
    public void save(SeasonTicket model) {

    }

    @Override
    public SeasonTicket findById(String id) {
        SeasonTicket ticket = new SeasonTicket("2", LocalDate.of(2023, 01, 01),
                LocalDate.of(2024, 01, 01), GYM);
        return ticket;

    }

    @Override
    public List<SeasonTicket> findAll() {
        return null;
    }
}
