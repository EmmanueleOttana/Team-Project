package start.repositories;

import start.entities.Performance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PerformanceRepository extends JpaRepository<Performance,Long> {

}
