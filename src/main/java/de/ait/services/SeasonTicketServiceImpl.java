package de.ait.services;

import de.ait.models.SeasonTicket;
import de.ait.repositories.SeasonTicketRepository;

import java.util.List;

public class SeasonTicketServiceImpl implements SeasonTicketService{
    private SeasonTicketRepository seasonTicketRepository;

    public SeasonTicketServiceImpl(SeasonTicketRepository seasonTicketRepository) {
        this.seasonTicketRepository = seasonTicketRepository;
    }

    @Override
    public List<SeasonTicket> getAll() {
        return seasonTicketRepository.findAll();
    }

    @Override
    public void save(SeasonTicket seasonTicket) {
        seasonTicketRepository.save(seasonTicket);
    }

    @Override
    public SeasonTicket findById(String id) {
        return seasonTicketRepository.findById(id);
    }
}
