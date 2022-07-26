package org.imyuyu.cg.apps.template;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
public class TemplateForm implements Serializable {
    private String name;
    private String code;
    private String content;
    private String templateEngine;
    private long fileType;
    private boolean enabled;
}
