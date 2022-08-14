package org.imyuyu.cg.apps.build;

import cn.hutool.core.util.ZipUtil;
import cn.hutool.db.meta.MetaUtil;
import cn.hutool.db.meta.Table;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.imyuyu.cg.apps.datasource.DataSource;
import org.imyuyu.cg.apps.directory.Directory;
import org.imyuyu.cg.apps.strategy.Strategy;
import org.imyuyu.cg.apps.strategy.StrategyDirectoriesRel;
import org.imyuyu.cg.apps.task.Task;
import org.imyuyu.cg.apps.template.Template;
import org.imyuyu.cg.generator.GeneratorContext;
import org.imyuyu.cg.generator.TemplateEngineFactory;
import org.imyuyu.cg.generator.TemplateEngineNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 *
 */
@Slf4j
@AllArgsConstructor
@Service
public class BuildService {

    public Table getTable(DataSource dataSource, String tableName) {
        Table table = MetaUtil.getTableMeta(null, null, null, tableName);
        return table;
    }

    public void build(Task task) {
        // 基于task构建模板
        DataSource dataSource = task.getDataSource();
        Strategy strategy = task.getStrategy();
        log.info("接收到代码生成任务:{},使用策略: {},使用数据源：{}", task.getId(), strategy.getId(), dataSource.getId());
        // 在临时目录生成一个文件夹,也是这一次构建的标识
        String uuid = UUID.randomUUID().toString();
        Path tempDirectory = null;
        try {
            tempDirectory = Files.createTempDirectory(uuid);
        } catch (IOException e) {
            // 文件没创建成功，换一个目录

        }

        if (tempDirectory != null) {

            Map<String, String> tableConfig = task.getTableConfig();
            for (Map.Entry<String, String> entry : tableConfig.entrySet()) {
                String key = entry.getKey();
                String columns = entry.getValue();
                String[] split = columns.split(",");

                // 获取数据库信息

                // 构建渲染上下文环境
                GeneratorContext generatorContext = new GeneratorContext();
                Map<String, Object> params = new HashMap<>();
                generatorContext.setProperties(params);

                List<StrategyDirectoriesRel> strategyDirectoriesRel = strategy.getStrategyDirectoriesRel();
                for (StrategyDirectoriesRel directoriesRel : strategyDirectoriesRel) {
                    Directory directory = directoriesRel.getDirectory();
                    Template template = directoriesRel.getTemplate();

                    Path rootPath = tempDirectory.resolve(directory.getValue());
                    try {
                        Files.createDirectories(rootPath);

                        generatorContext.setTemplate(template.getContent());
                        generatorContext.setTemplateEngine(template.getTemplateEngine());
                        // 渲染
                        String fileContent = null;
                        try {
                            fileContent = TemplateEngineFactory.getInstance()
                                .getTemplateEngine(template.getTemplateEngine()).resolve(generatorContext);
                        } catch (TemplateEngineNotFoundException e) {
                            throw new RuntimeException(e);
                        }

                        Path filePath = rootPath.resolve(template.getName() + "." + template.getFileType().getSuffix());

                        try {
                            Files.createFile(filePath);
                            try (FileOutputStream outputStream = new FileOutputStream(filePath.toFile())) {
                                StreamUtils.copy(fileContent, StandardCharsets.UTF_8, outputStream);
                            }
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            // 打个压缩包，下载完事
            ZipUtil.zip(tempDirectory.toFile(), StandardCharsets.UTF_8);
        }
    }

}
