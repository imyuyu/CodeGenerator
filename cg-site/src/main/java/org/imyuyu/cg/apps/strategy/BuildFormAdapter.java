package org.imyuyu.cg.apps.strategy;

import lombok.AllArgsConstructor;
import org.imyuyu.cg.apps.datasource.DataSource;
import org.imyuyu.cg.apps.datasource.DataSourceService;
import org.imyuyu.cg.apps.user.User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class BuildFormAdapter {

    private DataSourceService dataSourceService;
    private StrategyService strategyService;

    public Build createBuildFromBuildForm(BuildForm buildForm, User user) {
        DataSource dataSource = dataSourceService.getDataSource(buildForm.getDataSource());
        Strategy strategy = strategyService.getStrategy(buildForm.getStrategy());
        Build build = new Build();
        build.setStatus(BuildStatus.Pending);
        build.setDataSource(dataSource);
        build.setStrategy(strategy);
        build.setCreatedBy(user);
        build.setCreatedDate(LocalDateTime.now());
        build.setEnabled(true);
        build.setDeleted(false);
        build.setNewId();

        return build;
    }
}
