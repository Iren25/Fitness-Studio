package de.ait.repositories;
import de.ait.models.SeasonTicket;
import de.ait.models.TypeOfTicket;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class SeasonTicketRepositoryFileImpl implements SeasonTicketRepository {
    private String fileName;
    private List<SeasonTicket> seasonTicketList;

    public SeasonTicketRepositoryFileImpl(String fileName) {
        this.fileName = fileName;
        this.seasonTicketList = new ArrayList<>();
    }

    @Override
    public void save(SeasonTicket seasonTicket) {
        if(seasonTicket.getBegin().isAfter(seasonTicket.getEnd())){
            throw new RuntimeException("Дата начала не может быть позднее даты окончания абонемента");
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("seasonTickets.txt", true))) {
            writer.write(seasonTicket.getId() + "|" +
                    seasonTicket.getBegin().toString() + "|" +
                    seasonTicket.getEnd().toString() + "|" +
                    seasonTicket.getTypeOfTicket().toString());
            writer.newLine();
        } catch (IOException e) {
            throw new IllegalStateException("Проблемы с файлом");
        }
    }

    private static SeasonTicket parseLine(String line) {
        String[] parsed = line.split("\\|");
        String id = parsed[0];
        LocalDate begin = LocalDate.parse(parsed[1]);
        LocalDate end = LocalDate.parse(parsed[2], DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        TypeOfTicket typeOfTicket = TypeOfTicket.valueOf(parsed[3]);

        return new SeasonTicket(id, begin, end, typeOfTicket);
    }

    @Override
    public SeasonTicket findById(String id) {
        for (SeasonTicket seasonTicket : findAll()) {
            if (id.equals(seasonTicket.getId())) {
                return seasonTicket;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public List<SeasonTicket> findAll() {
        List<SeasonTicket> seasonTickets = new ArrayList<>();
        try (FileReader fileReader = new FileReader("seasonTickets.txt");
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line = bufferedReader.readLine();
            while (line != null) {
                SeasonTicket seasonTicket = parseLine(line);
                seasonTickets.add(seasonTicket);
                line = bufferedReader.readLine();
            }
            fileReader.close();
        } catch (IOException e) {
            System.err.println("Произошла ошибка");
        }
        return seasonTickets;
    }
}
