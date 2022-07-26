package org.imyuyu.cg.common.po;

import lombok.Getter;
import lombok.Setter;
import org.imyuyu.cg.apps.user.User;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
public class AbstractPO extends LogicDeletePO implements Enableable {

    @Column(name = "is_enable")
    private boolean enabled;

    @ManyToOne
    private @Nullable User createdBy;

    private @Nullable LocalDateTime createdDate;

    @ManyToOne
    private @Nullable User lastModifiedBy;

    private @Nullable LocalDateTime lastModifiedDate;
}
