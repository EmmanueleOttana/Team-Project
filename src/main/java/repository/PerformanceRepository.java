package repository;

import entity.PerformanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PerformanceRepository extends JpaRepository<PerformanceEntity,Long> {

}
