package org.imyuyu.cg.apps.strategy;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.imyuyu.cg.apps.user.User;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class BuildService implements InitializingBean {

    BuildRepository buildRepository;
    BuildFormAdapter buildFormAdapter;

    public Build addBuild(BuildForm buildForm, User user) {
        Build build = buildFormAdapter.createBuildFromBuildForm(buildForm, user);
        buildRepository.save(build);
        return build;
    }

    public void doBuild(Build build) {
        build.setStartDate(LocalDateTime.now());
        build.setStatus(BuildStatus.Processing);
        buildRepository.save(build);
    }

    public void init() {
        Thread thread = new Thread(() -> {
            while (Thread.currentThread().isInterrupted()) {

                // 取数据库
                List<Build> pendingBuild =
                    buildRepository.findByStatusAndDeletedFalseAndEnabledTrue(BuildStatus.Pending);
                if (!CollectionUtils.isEmpty(pendingBuild)) {
                    for (Build build : pendingBuild) {
                        doBuild(build);
                    }
                }

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    log.error("线程被中断！", e);
                }
            }
        });
        thread.setName("BUILD THREAD");
        thread.setDaemon(true);
        thread.start();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        init();
    }
}
