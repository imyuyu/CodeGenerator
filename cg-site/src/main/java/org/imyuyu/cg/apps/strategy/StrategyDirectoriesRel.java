package org.imyuyu.cg.apps.strategy;

import lombok.Getter;
import lombok.Setter;
import org.imyuyu.cg.apps.directory.Directory;
import org.imyuyu.cg.apps.template.Template;
import org.imyuyu.cg.common.po.BasePO;

import javax.persistence.*;

@Entity
@Table(name = "strategy_directories_rel")
@Getter
@Setter
public class StrategyDirectoriesRel extends BasePO {

    @ManyToOne
    @JoinColumn(name = "strategy_id")
    private Strategy strategy;
    @ManyToOne
    @JoinColumn(name = "directory_id")
    private Directory directory;
    @ManyToOne
    @JoinColumn(name = "template_id")
    private Template template;
}
