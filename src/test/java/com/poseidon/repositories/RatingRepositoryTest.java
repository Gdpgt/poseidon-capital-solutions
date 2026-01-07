package com.poseidon.repositories;

import com.poseidon.domain.Rating;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;


@DataJpaTest
@ActiveProfiles("test")
class RatingRepositoryTest {

	@Autowired
	private RatingRepository ratingRepository;

	@Test
	void ratingTest() {
		Rating rating = new Rating("Moodys Rating", "Sand PRating", "Fitch Rating", 10);

		// Save
		rating = ratingRepository.save(rating);
		assertThat(rating.getId()).isNotNull();
		assertThat(rating.getOrderNumber()).isEqualTo(10);

		// Update
		rating.setOrderNumber(20);
		rating = ratingRepository.save(rating);
		assertThat(rating.getOrderNumber()).isEqualTo(20);

		// Find
		List<Rating> listResult = ratingRepository.findAll();
		assertThat(listResult).isNotEmpty();

		// Delete
		Integer id = rating.getId();
		ratingRepository.delete(rating);
		Optional<Rating> ratingList = ratingRepository.findById(id);
		assertThat(ratingList).isEmpty();
	}
}
