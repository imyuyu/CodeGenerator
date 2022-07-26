package org.imyuyu.cg.common.po;

import cn.hutool.core.util.IdUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;
import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.domain.AbstractAuditable;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.util.ProxyUtils;
import org.springframework.lang.Nullable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import java.io.Serializable;

/**
 * po超类
 */
@MappedSuperclass
@Getter
@Setter
public abstract class BasePO implements Serializable, Persistable<Long> {
    @JsonIgnore
    @Transient
    private Integer hashCode;

    @Id
    @Nullable
    private Long id;

    /**
     * set new id use hutool snowflake id
     */
    public void setNewId() {
        setId(IdUtil.getSnowflakeNextId());
    }

    @Transient
    public boolean isNew() {
        return null == this.getId();
    }

    public String toString() {
        return String.format("Entity of type %s with id: %s", this.getClass().getName(), this.getId());
    }

    public boolean equals(Object obj) {
        if (null == obj) {
            return false;
        } else if (this == obj) {
            return true;
        } else if (!this.getClass().equals(ProxyUtils.getUserClass(obj))) {
            return false;
        } else {
            AbstractPersistable<?> that = (AbstractPersistable)obj;
            return null == this.getId() ? false : this.getId().equals(that.getId());
        }
    }

    @Override
    public int hashCode() {
        if (Integer.MIN_VALUE == this.hashCode) {
            if (null == this.getId()) {
                return super.hashCode();
            }

            int hashCode = 17;

            String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();

            this.hashCode = hashCode + hashStr.hashCode() * 31;
        }

        return this.hashCode;
    }
}
