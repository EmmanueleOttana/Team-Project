package start.repositories;

import start.entities.Contracts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ContractsRepository extends JpaRepository<Contracts,Long> {


}
