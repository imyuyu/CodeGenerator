package org.imyuyu.cg.apps.template;

import lombok.Getter;
import lombok.Setter;
import org.imyuyu.cg.apps.strategy.Strategy;
import org.imyuyu.cg.common.po.AbstractPO;

import javax.persistence.*;

@Entity
@Table(name = "cg_template")
@Getter
@Setter
public class Template extends AbstractPO {
    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String code;
    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private FileType fileType;
    @Lob
    private String content;
}