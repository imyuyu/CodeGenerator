package org.imyuyu.cg.apps.strategy;

import javax.persistence.OneToMany;

public class TaskStrategyRel {

    @OneToMany
    private Task task;

    @OneToMany
    private Strategy strategy;
}
