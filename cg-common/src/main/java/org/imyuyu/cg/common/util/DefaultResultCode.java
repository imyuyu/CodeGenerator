package org.imyuyu.cg.common.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.servlet.http.HttpServletResponse;

@AllArgsConstructor
@Getter
public enum DefaultResultCode implements ResultCode {
    SUCCESS(HttpServletResponse.SC_OK, "操作成功！", null);
    ;

    private final int code;
    private final String message;
    private final String messageI18nKey;
}
