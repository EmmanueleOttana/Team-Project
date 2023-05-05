package start.repositories;

import start.entities.Dismissal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DismissalRepository extends JpaRepository<Dismissal,Long> {

}
