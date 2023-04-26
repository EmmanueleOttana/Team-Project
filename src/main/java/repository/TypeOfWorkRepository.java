package repository;

import entity.TypeOfWorkEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface TypeOfWorkRepository extends JpaRepository<TypeOfWorkEntity,Long> {


}
