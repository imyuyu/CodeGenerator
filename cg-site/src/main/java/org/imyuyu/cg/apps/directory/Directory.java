package org.imyuyu.cg.apps.directory;

import lombok.Getter;
import lombok.Setter;
import org.imyuyu.cg.apps.template.Template;
import org.imyuyu.cg.common.po.AbstractPO;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cg_directory")
@Getter
@Setter
public class Directory extends AbstractPO {

    /**
     * 名称
     */
    @Column(nullable = false)
    private String name;

    /**
     * 路径
     */
    @Column(nullable = false, unique = true)
    private String value;

    /**
     * 只读
     */
    private boolean readonly;
}
