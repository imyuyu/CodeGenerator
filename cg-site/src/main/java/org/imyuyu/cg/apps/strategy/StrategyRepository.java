package org.imyuyu.cg.apps.strategy;

import org.imyuyu.cg.apps.strategy.Strategy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface StrategyRepository extends JpaRepository<Strategy, Long>, JpaSpecificationExecutor<Strategy> {}