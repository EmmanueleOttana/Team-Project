package repository;

import entity.PeoplePowerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PeoplePowerRepository extends JpaRepository<PeoplePowerEntity,Long> {

}
