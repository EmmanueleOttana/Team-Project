package start.repositories;

import start.entities.TypeOfWork;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface TypeOfWorkRepository extends JpaRepository<TypeOfWork,Long> {


}
