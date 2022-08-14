package org.imyuyu.cg.apps.task;

import lombok.AllArgsConstructor;
import org.imyuyu.cg.apps.datasource.DataSource;
import org.imyuyu.cg.apps.datasource.DataSourceService;
import org.imyuyu.cg.apps.strategy.Strategy;
import org.imyuyu.cg.apps.strategy.StrategyService;
import org.imyuyu.cg.apps.user.User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class TaskFormAdapter {

    private DataSourceService dataSourceService;
    private StrategyService strategyService;

    public Task createTaskFromTaskForm(TaskForm taskForm, User user) {
        DataSource dataSource = dataSourceService.getDataSource(taskForm.getDataSource());
        Strategy strategy = strategyService.getStrategy(taskForm.getStrategy());
        Task task = new Task();
        task.setStatus(TaskStatus.Pending);
        task.setDataSource(dataSource);
        task.setStrategy(strategy);
        task.setCreatedBy(user);
        task.setCreatedDate(LocalDateTime.now());
        task.setEnabled(true);
        task.setDeleted(false);
        task.setNewId();

        return task;
    }
}
