package org.imyuyu.cg.common.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class R<T> {
    private int code;
    private String message;
    private String messageI18nKey;
    private T data;

    @NonNull
    public static <T> R<T> ok() {
        return ok(DefaultResultCode.SUCCESS, null);
    }

    @NonNull
    public static <T> R<T> ok(@Nullable T data) {
        return ok(DefaultResultCode.SUCCESS, data);
    }

    @NonNull
    public static <T> R<T> ok(@NonNull ResultCode resultCode, @Nullable T data) {
        return new R<>(resultCode.getCode(), resultCode.getMessage(), resultCode.getMessageI18nKey(), data);
    }
}
