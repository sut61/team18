package sut.se.g18.Repository;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import sut.se.g18.Entity.AdminAccountEntity;
import sut.se.g18.Entity.CompanyEntity;
import sut.se.g18.Entity.WelfareAndSalaryEntity;
import sut.se.g18.Entity.WorkingDateEntity;


@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")

public interface WelfareAndSalaryRepository extends JpaRepository<WelfareAndSalaryEntity, Long> {
    WelfareAndSalaryEntity findBywelsaName(String welsaName);
}

