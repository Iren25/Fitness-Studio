package de.ait.repositories;

import de.ait.models.Contract;
import de.ait.models.User;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ContractRepositoryFileImpl implements ContractRepository {
    private String fileName;
    private List<Contract> contracts;

    public ContractRepositoryFileImpl(String fileName) {
        this.fileName = fileName;
        this.contracts = new ArrayList<>();
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String toString() {
        return "ContractRepositoryFileImpl{" +
                "fileName='" + fileName + '\'' +
                '}';
    }

    @Override
    public void save(Contract contract) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(contract.getId() + "|" +
                    contract.getDate().toString() + "|" +
                    contract.getTicketId() + "|" +
                    contract.getUserId());
            writer.newLine();
        } catch (IOException e) {
            throw new IllegalStateException("Проблемы с файлом");
        }
    }
    private static Contract parseLine(String line) {
        String[] parsed = line.split("\\|");
        String id = parsed[0];
        LocalDate date = LocalDate.parse(parsed[1]);
        String ticketId = parsed[2];
        String userId = parsed[3];

        return new Contract(id,date,ticketId,userId);
    }

    @Override
    public Contract findById(String id) {
        for (Contract contract : contracts) {
            if (id.equals(contract.getId())) {
                return contract;
            }
        }
        throw new IllegalArgumentException();
    }
}

