package org.imyuyu.cg.apps.applog;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Component
@Aspect
public class LogAspect {

    private AppLogService logService;
    private HttpServletRequest request;

    @Around("@annotation(log)")
    public Object invoked(ProceedingJoinPoint pjp, Log log) throws Throwable {
        try {
            return pjp.proceed();
        } finally {
            String remoteAddr = request.getRemoteAddr();
            logService.addLog(log, remoteAddr, null);
        }
    }
}
