package sut.se.g18.Repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import sut.se.g18.Entity.ContractEntity;
import sut.se.g18.Entity.MaidSelectEntity;
import sut.se.g18.Entity.PaymentStatusEntity;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface ContractRepository extends JpaRepository<ContractEntity, Long> {
    ContractEntity findByMaidAndStatus(MaidSelectEntity maid, PaymentStatusEntity Status);
    ContractEntity findByMaid(MaidSelectEntity maid);
    ContractEntity findBycontractId(Long contractId);
}
