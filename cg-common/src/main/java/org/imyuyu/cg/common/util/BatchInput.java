package org.imyuyu.cg.common.util;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * batch processing param
 * 
 * @param <T>
 */
@Getter
@Setter
public class BatchInput<T> {

    public Method method;
    public List<T> data;

    public enum Method {
        DELETE, UPDATE
    }
}
