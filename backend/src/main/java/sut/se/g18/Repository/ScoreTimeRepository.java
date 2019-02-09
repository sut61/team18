package sut.se.g18.Repository;
import sut.se.g18.Entity.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")

public interface ScoreTimeRepository extends JpaRepository<ScoreTimeEntity, Long>{
    ScoreTimeEntity findByscoreTiId(Long scoreId);
}