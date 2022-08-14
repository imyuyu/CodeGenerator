package org.imyuyu.cg.apps.filetype;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class FileTypeForm {
    private String name;
    /**
     * 机器可识别的名称
     */
    private String code;
    /**
     * 后缀
     */
    private String suffix;

    /**
     * 描述
     */
    private String description;
    private boolean enabled;
}
