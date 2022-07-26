package org.imyuyu.cg.apps.strategy;

import lombok.Getter;
import lombok.Setter;
import org.imyuyu.cg.apps.datasource.DataSource;
import org.imyuyu.cg.common.po.AbstractPO;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "cg_build")
@Getter
@Setter
public class Build extends AbstractPO {

    private LocalDateTime startDate;

    private LocalDateTime completedDate;

    private Long runTime;

    @Enumerated(EnumType.STRING)
    private BuildStatus status;

    @Enumerated(EnumType.STRING)
    private BuildState state;

    @ManyToOne
    private DataSource dataSource;

    @ManyToOne
    private Strategy strategy;
}
