package org.imyuyu.cg.apps.applog;

import lombok.Getter;
import lombok.Setter;
import org.imyuyu.cg.apps.user.User;
import org.imyuyu.cg.common.po.BasePO;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "cg_applog")
@Getter
@Setter
public class AppLog extends BasePO {
    @Enumerated(EnumType.STRING)
    private AppLogType type;

    /**
     * 所有参数转json
     */
    private String param;

    private String ip;

    @ManyToOne
    private @Nullable User createdBy;

    private @Nullable LocalDateTime createdDate;
}
