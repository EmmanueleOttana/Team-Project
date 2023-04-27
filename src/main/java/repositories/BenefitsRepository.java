package repositories;

import entities.Benefits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface BenefitsRepository extends JpaRepository<Benefits,Long> {

}
