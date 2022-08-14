package org.imyuyu.cg.apps.template;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.imyuyu.cg.apps.filetype.FileTypeDto;

import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class TemplateDto implements Serializable {
    private final Long id;
    private final boolean deleted;
    private final boolean enabled;
    private final Long createdBy;
    private final LocalDateTime createdDate;
    private final Long lastModifiedBy;
    private final LocalDateTime lastModifiedDate;
    private final String name;
    private final String code;
    private final FileTypeDto fileType;
    private final String content;
}
