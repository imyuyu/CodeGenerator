package org.imyuyu.cg.generator;

import org.imyuyu.cg.generator.engine.TemplateEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TemplateEngineFactory {
    public static final Logger log = LoggerFactory.getLogger(TemplateEngineFactory.class);

    private final Map<String, TemplateEngine> TEMPLATE_ENGINE = new ConcurrentHashMap<>();
    private static final TemplateEngineFactory INSTANCE = new TemplateEngineFactory();

    private TemplateEngineFactory() {
        if (INSTANCE != null) {
            throw new IllegalStateException("only be instantiated once");
        }
    }

    public static TemplateEngineFactory getInstance() {
        return INSTANCE;
    }

    public void register(TemplateEngine templateEngine) {
        if (TEMPLATE_ENGINE.containsKey(templateEngine.getName())) {
            log.warn("模板引擎[{}]已存在，忽略", templateEngine.getName());
            return;
        }
        TEMPLATE_ENGINE.put(templateEngine.getName(), templateEngine);
    }

    /**
     * get by template engine name
     * 
     * @param name template engine name
     * @return TemplateEngine
     * @throws TemplateEngineNotFoundException if not found
     */
    public TemplateEngine getTemplateEngine(String name) {
        TemplateEngine templateEngine = TEMPLATE_ENGINE.get(name);
        if (templateEngine == null) {
            throw new TemplateEngineNotFoundException(name);
        }
        return templateEngine;
    }

}
