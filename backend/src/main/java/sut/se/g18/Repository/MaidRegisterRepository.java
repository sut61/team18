package sut.se.g18.Repository;

import sut.se.g18.Entity.CompanyEntity;
import sut.se.g18.Entity.MaidRegisterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Collection;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")

public interface MaidRegisterRepository extends JpaRepository<MaidRegisterEntity, Long> {
    MaidRegisterEntity findByMaidId(Long maidId);

    MaidRegisterEntity findBymaidEmail(String maidEmail);

    MaidRegisterEntity findBymaidName(String maidName);

    Collection<MaidRegisterEntity> findBycompanyForMaid(CompanyEntity companyForMaid);

}
