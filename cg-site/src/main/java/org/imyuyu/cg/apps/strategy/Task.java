package org.imyuyu.cg.apps.strategy;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import javax.persistence.*;

import org.imyuyu.cg.apps.datasource.DataSource;
import org.imyuyu.cg.common.po.AbstractPO;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cg_task")
@Getter
@Setter
public class Task extends AbstractPO {

    private LocalDateTime startDate;

    private LocalDateTime completedDate;

    private Long runTime;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    @Enumerated(EnumType.STRING)
    private TaskState state;

    @ManyToOne
    private DataSource dataSource;

    @ManyToOne
    private Strategy strategy;

    @ElementCollection
    private Map<String, String> tableConfig;
}
