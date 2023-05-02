package start.repositories;

import start.entities.TypeOfWork;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeOfWorkRepository extends JpaRepository<TypeOfWork,Long> {


}
