package org.imyuyu.cg.apps.applog;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
    /**
     * 类型
     * 
     * @return
     */
    AppLogType value();

    /**
     * 参数
     * 
     * @return
     */
    Param[] params() default {};

    @Target({ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface Param {

        String value();
    }
}
