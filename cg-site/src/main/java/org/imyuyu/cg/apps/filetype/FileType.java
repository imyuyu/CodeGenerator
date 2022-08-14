package org.imyuyu.cg.apps.filetype;

import lombok.Getter;
import lombok.Setter;
import org.imyuyu.cg.common.po.AbstractPO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 文件类型
 */
@Entity
@Table(name = "cg_file_type")
@Getter
@Setter
public class FileType extends AbstractPO {

    /**
     * 人类可识别的名称
     */
    @Column(nullable = false)
    private String name;
    /**
     * 机器可识别的名称
     */
    @Column(nullable = false, unique = true)
    private String code;
    /**
     * 后缀
     */
    @Column(nullable = false)
    private String suffix;

    /**
     * 描述
     */
    @Column(length = 2000)
    private String description;

}
