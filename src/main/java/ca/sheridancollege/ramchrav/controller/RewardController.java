package ca.sheridancollege.ramchrav.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.sheridancollege.ramchrav.beans.Rewards;
import ca.sheridancollege.ramchrav.repo.RewardsRepo;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/rewards") // API Controller Link
@AllArgsConstructor

/**
 * This RestController responds to various CRUD requests to the database.
 * 
 * @author Ravi Ramchand
 */

public class RewardController {
	private RewardsRepo rewardsRepo;

	/**
	 * 
	 * @return all of the records in the Rewards table
	 */
	@GetMapping(value = { "/", "" })
	public List<Rewards> getAllRewards() {
		return rewardsRepo.findAll();
	}

	/**
	 * 
	 * @param id
	 * @return a specific reward from the Rewards table else return nothing
	 */
	@GetMapping("/{id}")
	public Rewards getReward(@PathVariable Long id) {
		Optional<Rewards> reward = rewardsRepo.findById(id);

		if (reward.isPresent()) {
			return reward.get();
		}
		return null;
	}

	/**
	 * 
	 * @param reward getting the record from the user in a JSON format
	 * @return a string that tells the user their inputed reward was stored in the
	 *         table
	 */
	@PostMapping(value = { "/", "" }, headers = { "Content-type=application/json" })
	public String addReward(@RequestBody Rewards reward) {
		rewardsRepo.save(reward);
		return "Reward " + reward.getRewardName() + " was added";
	}

	/**
	 * 
	 * @param reward getting the record from the user in a JSON format
	 * @param id     accessing the specific id in the link using @PathVariable
	 * @return a string that tells the user the record has been updated
	 */
	@PutMapping(value = { "/{id}" }, headers = { "Content-type=application/json" })
	public String updateReward(@RequestBody Rewards reward, @PathVariable Long id) {
		reward.setId(id);
		rewardsRepo.save(reward);
		return "Reward: " + reward.getRewardName() + " was updated";
	}

	/**
	 * 
	 * @return a string that tells the user everything in the Rewards table was
	 *         deleted
	 */
	@DeleteMapping("/")
	public String deleteAllRewards() {
		String str = "All Rewards were deleted";
		rewardsRepo.deleteAll();
		return str;
	}

	/**
	 * 
	 * @param id accessing the specific id in the link using @PathVariable
	 * @return a string that tells the user the specific reward record was deleted
	 */
	@DeleteMapping("{id}")
	public String deleteReward(@PathVariable Long id) {
		Optional<Rewards> reward = rewardsRepo.findById(id);
		String str = "Reward " + reward.get().getRewardName() + " was deleted";
		if (reward.isPresent()) {
			rewardsRepo.deleteById(id);
		}
		return str;
	}
}
