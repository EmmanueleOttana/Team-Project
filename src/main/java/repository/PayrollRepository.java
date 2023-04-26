package repository;

import entity.PayrollEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PayrollRepository extends JpaRepository<PayrollEntity,Long> {

}
