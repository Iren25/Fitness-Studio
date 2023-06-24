package de.ait.services;
import de.ait.models.Contract;
import java.util.List;

public interface ContractService {
        List<Contract> getAll();
        void save(Contract contract);
        Contract findById(String id);

    String makeContract(String userId, String id);
}
