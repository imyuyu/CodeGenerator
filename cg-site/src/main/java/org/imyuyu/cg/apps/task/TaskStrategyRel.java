package org.imyuyu.cg.apps.task;

import org.imyuyu.cg.apps.strategy.Strategy;

import javax.persistence.OneToMany;

public class TaskStrategyRel {

    @OneToMany
    private Task task;

    @OneToMany
    private Strategy strategy;
}
