package start.repositories;

import start.entities.Dismissal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface DismissalRepository extends JpaRepository<Dismissal,Long> {

}
