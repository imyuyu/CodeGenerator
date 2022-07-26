package org.imyuyu.cg.common.po;

/**
 * 启用停用接口
 */
public interface Enableable {

    /**
     * 是否启用
     * 
     * @return true表示启用
     */
    boolean isEnabled();

    /**
     * 设置启用状态
     * 
     * @param enabled true表示启用，false 停用
     */
    void setEnabled(boolean enabled);

}
