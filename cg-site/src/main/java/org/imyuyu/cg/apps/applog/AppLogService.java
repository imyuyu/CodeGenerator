package org.imyuyu.cg.apps.applog;

import lombok.AllArgsConstructor;
import org.imyuyu.cg.apps.user.User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class AppLogService {

    private AppLogRepository appLogRepository;

    public void addLog(Log log, String ip, User user) {
        AppLog appLog = new AppLog();
        appLog.setNewId();
        appLog.setType(log.value());
        appLog.setIp(ip);
        appLog.setCreatedBy(user);
        appLog.setCreatedDate(LocalDateTime.now());

        appLogRepository.save(appLog);
    }
}
