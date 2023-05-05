package start.repositories;

import start.entities.PeoplePower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeoplePowerRepository extends JpaRepository<PeoplePower,Long> {

}
