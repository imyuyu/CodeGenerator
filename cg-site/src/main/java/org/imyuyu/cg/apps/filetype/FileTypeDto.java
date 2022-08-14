package org.imyuyu.cg.apps.filetype;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class FileTypeDto implements Serializable {
    private final Long id;
    private final boolean deleted;
    private final boolean enabled;
    private final Long createdBy;
    private final LocalDateTime createdDate;
    private final Long lastModifiedBy;
    private final LocalDateTime lastModifiedDate;
    private final String name;
    private final String code;
    private final String suffix;
    private final String description;
}
