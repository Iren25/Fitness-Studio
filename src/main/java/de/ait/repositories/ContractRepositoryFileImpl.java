package de.ait.repositories;

import de.ait.models.Contract;

import java.io.*;
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
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("contracts.txt", true))) {
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

        return new Contract(id, date, ticketId, userId);
    }

    @Override
    public Contract findById(String id) {
        for (Contract contract : findAll()) {
            if (id.equals(contract.getId())) {
                return contract;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public List<Contract> findAll() {
        List<Contract> contractList = new ArrayList<>();
        try (FileReader fileReader = new FileReader("contracts.txt");
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line = bufferedReader.readLine();
            while (line != null) {
                Contract contract = parseLine(line);
                contractList.add(contract);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            System.err.println("Произошла ошибка");
        }
        return contractList;
    }
}


