package ca.sheridancollege.ramchrav.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.ramchrav.beans.Rewards;

@Repository
public interface RewardsRepo extends JpaRepository<Rewards, Long> {

}
