package repository;

import entity.ContractsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ContractsRepository extends JpaRepository<ContractsEntity,Long> {


}
