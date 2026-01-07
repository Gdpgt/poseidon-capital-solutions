package com.poseidon.repositories;

import com.poseidon.domain.Trade;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;


@DataJpaTest
@ActiveProfiles("test")
class TradeRepositoryTest {

	@Autowired
	private TradeRepository tradeRepository;

	@Test
	void tradeTest() {
		Trade trade = new Trade("Trade Account", "Type");

		// Save
		trade = tradeRepository.save(trade);
		assertThat(trade.getTradeId()).isNotNull();
		assertThat(trade.getAccount()).isEqualTo("Trade Account");

		// Update
		trade.setAccount("Trade Account Update");
		trade = tradeRepository.save(trade);
		assertThat(trade.getAccount()).isEqualTo("Trade Account Update");

		// Find
		List<Trade> listResult = tradeRepository.findAll();
		assertThat(listResult).isNotEmpty();

		// Delete
		Integer id = trade.getTradeId();
		tradeRepository.delete(trade);
		Optional<Trade> tradeList = tradeRepository.findById(id);
		assertThat(tradeList).isEmpty();
	}
}
