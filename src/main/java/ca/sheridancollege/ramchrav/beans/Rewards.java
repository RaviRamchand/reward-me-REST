package ca.sheridancollege.ramchrav.beans;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Bean with attributes to later be converted into a database entity.
 * 
 * @author Ravi Ramchand
 *
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity

public class Rewards {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String rewardName;
}
