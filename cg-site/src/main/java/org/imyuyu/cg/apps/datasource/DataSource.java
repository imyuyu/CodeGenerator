package org.imyuyu.cg.apps.datasource;

import lombok.Getter;
import lombok.Setter;
import org.imyuyu.cg.common.po.AbstractPO;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "cg_datasource")
@Getter
@Setter
public class DataSource extends AbstractPO {
    private String name;

    private String url;

    private String username;

    private String password;

    @Enumerated(EnumType.STRING)
    private DataSourceType type;
}
