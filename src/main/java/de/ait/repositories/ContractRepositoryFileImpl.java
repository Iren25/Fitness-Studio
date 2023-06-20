package de.ait.repositories;

import de.ait.models.Contract;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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
            writer.write(contract.getContractId() + "|" +
                    contract.getDate().toString() + "|" +
                    contract.getTicketId() + "|" +
                    contract.getUserId());
            writer.newLine();
        } catch (IOException e) {
            throw new IllegalStateException("Проблемы с файлом");
        }
    }

    @Override
    public Contract findById(String id) {
        for (Contract contract : contracts) {
            if (id.equals(contract.getContractId())) {
                return contract;
            }
        }
        throw new IllegalArgumentException();
    }
}

