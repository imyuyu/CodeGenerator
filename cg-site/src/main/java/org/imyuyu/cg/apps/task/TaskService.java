package org.imyuyu.cg.apps.task;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.imyuyu.cg.apps.build.BuildService;
import org.imyuyu.cg.apps.user.User;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class TaskService {

    TaskRepository taskRepository;
    TaskFormAdapter taskFormAdapter;
    BuildService buildService;

    public Task addTask(TaskForm buildForm, User user) {
        Task task = taskFormAdapter.createTaskFromTaskForm(buildForm, user);
        taskRepository.save(task);
        return task;
    }

    public void postProcessBeforeBuild(Task task) {
        task.setStartDate(LocalDateTime.now());
        task.setStatus(TaskStatus.Processing);
        taskRepository.saveAndFlush(task);
    }

    @Scheduled(fixedDelay = 5000)
    public void init() {
        // 取数据库
        List<Task> pendingTask = taskRepository.findByStatusAndDeletedFalseAndEnabledTrue(TaskStatus.Pending);
        if (!CollectionUtils.isEmpty(pendingTask)) {
            for (Task task : pendingTask) {
                postProcessBeforeBuild(task);
                buildService.build(task);
            }
        }
    }
}
