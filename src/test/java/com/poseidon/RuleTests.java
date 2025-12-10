package com.poseidon;

import com.poseidon.domain.RuleName;
import com.poseidon.repositories.RuleNameRepository;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;


@SpringBootTest
public class RuleTests {

	@Autowired
	private RuleNameRepository ruleNameRepository;

	@Test
	public void ruleTest() {
		RuleName rule = new RuleName("Rule Name", "Description", "Json", "Template", "SQL", "SQL Part");

		// Save
		rule = ruleNameRepository.save(rule);
		assertThat(rule.getId()).isNotNull();
		assertThat(rule.getName()).isEqualTo("Rule Name");

		// Update
		rule.setName("Rule Name Update");
		rule = ruleNameRepository.save(rule);
		assertThat(rule.getName()).isEqualTo("Rule Name Update");

		// Find
		List<RuleName> listResult = ruleNameRepository.findAll();
		assertThat(listResult).isNotEmpty();

		// Delete
		Integer id = rule.getId();
		ruleNameRepository.delete(rule);
		Optional<RuleName> ruleList = ruleNameRepository.findById(id);
		assertThat(ruleList).isEmpty();
	}
}
