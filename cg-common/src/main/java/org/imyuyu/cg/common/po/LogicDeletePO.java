package org.imyuyu.cg.common.po;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Getter
@Setter
public abstract class LogicDeletePO extends BasePO {

    /**
     * 是否删除
     */
    @Column(name = "is_delete")
    private boolean deleted;

    /**
     * 设置为已删除
     */
    public void setDeleted() {
        setDeleted(true);
    }
}
