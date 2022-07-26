package org.imyuyu.cg.apps.strategy;

import org.imyuyu.cg.common.exception.ResourceNotFoundException;

public class StrategyNotFoundException extends ResourceNotFoundException {

    public StrategyNotFoundException(Long id) {
        super("Could not find strategy with id " + id);
    }
}
