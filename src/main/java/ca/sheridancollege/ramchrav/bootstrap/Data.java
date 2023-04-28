package ca.sheridancollege.ramchrav.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ca.sheridancollege.ramchrav.beans.Rewards;
import ca.sheridancollege.ramchrav.repo.RewardsRepo;
import lombok.AllArgsConstructor;

/**
 * Add default records to the database when project first runs.
 * 
 * @author Ravi Ramchand
 *
 */
@Component
@AllArgsConstructor
public class Data implements CommandLineRunner {
	private RewardsRepo rewardsRepo;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Rewards r1 = Rewards.builder().rewardName("Watch a tv show episode").build();
		Rewards r2 = Rewards.builder().rewardName("Play a video game").build();
		Rewards r3 = Rewards.builder().rewardName("Take a nap").build();
		Rewards r4 = Rewards.builder().rewardName("Watch a movie").build();
		Rewards r5 = Rewards.builder().rewardName("Go for a walk").build();

		rewardsRepo.save(r1);
		rewardsRepo.save(r2);
		rewardsRepo.save(r3);
		rewardsRepo.save(r4);
		rewardsRepo.save(r5);
	}

}
