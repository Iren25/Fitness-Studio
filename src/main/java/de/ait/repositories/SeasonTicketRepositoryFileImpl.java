package de.ait.repositories;


import de.ait.models.SeasonTicket;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SeasonTicketRepositoryFileImpl implements SeasonTicketRepository {
    private String fileName;
    private List<SeasonTicket> seasonTicketList;

    public SeasonTicketRepositoryFileImpl(String fileName) {
        this.fileName = fileName;
        this.seasonTicketList = new ArrayList<>();
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void save(SeasonTicket seasonTicket) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(seasonTicket.getId() + "|" +
                    seasonTicket.getBegin().toString() + "|" +
                    seasonTicket.getEnd() + "|" +
                    seasonTicket.getTypeOfTicket());
            writer.newLine();
        } catch (IOException e) {
            throw new IllegalStateException("Проблемы с файлом");
        }
    }

    @Override
    public SeasonTicket findById(String id) {
        for (SeasonTicket seasonTicket : seasonTicketList) {
            if (id.equals(seasonTicket.getId())) {
                return seasonTicket;
            }
        }
        throw new IllegalArgumentException();
    }

}
