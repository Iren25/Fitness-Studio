package de.ait.repositories;

import de.ait.models.Contract;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ContractRepositoryList implements ContractRepository {

    List<Contract> contracts = new ArrayList<>();

    @Override
    public void save(Contract model) {

        contracts.add(new Contract(UUID.randomUUID().toString(), LocalDate.now(), "2", "1"));
    }

    @Override
    public Contract findById(String id) {
        return null;
    }

    @Override
    public List<Contract> findAll() {
        return null;
    }
}
