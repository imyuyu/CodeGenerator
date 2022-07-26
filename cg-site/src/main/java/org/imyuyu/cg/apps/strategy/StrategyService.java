package org.imyuyu.cg.apps.strategy;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class StrategyService {

    private StrategyRepository strategyRepository;

    public Strategy getStrategy(Long id) {
        return strategyRepository.findById(id).orElseThrow(() -> new StrategyNotFoundException(id));
    }
}
