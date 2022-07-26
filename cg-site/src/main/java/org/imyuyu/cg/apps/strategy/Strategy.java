package org.imyuyu.cg.apps.strategy;

import lombok.Getter;
import lombok.Setter;
import org.imyuyu.cg.apps.directory.Directory;
import org.imyuyu.cg.common.po.AbstractPO;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "cg_strategy")
@Getter
@Setter
public class Strategy extends AbstractPO {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String code;

    @OneToMany(mappedBy = "strategy", cascade = CascadeType.ALL)
    private List<StrategyDirectoriesRel> strategyDirectoriesRel;

    private LocalDateTime lastUsedDate;
}
