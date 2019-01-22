package sut.se.g18.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import sut.se.g18.Entity.MaidRegisterEntity;
import sut.se.g18.Entity.MaidSelectEntity;
import sut.se.g18.Entity.MaidStatusEntity;

import java.util.Collection;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface MaidSelectRepository extends JpaRepository<MaidSelectEntity, Long> {
    MaidSelectEntity findBymaidAndStatus(MaidRegisterEntity maid, MaidStatusEntity status);
    MaidSelectEntity findBymaid(MaidRegisterEntity maid);
    Collection<MaidSelectEntity> findBystatus(MaidStatusEntity status);
}
