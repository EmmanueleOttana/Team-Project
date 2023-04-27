package repositories;

import entities.Payroll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PayrollRepository extends JpaRepository<Payroll,Long> {

}
