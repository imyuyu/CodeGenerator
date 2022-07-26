package org.imyuyu.cg.generator;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 生成器上下文
 */
public class GeneratorContext {
    private String template;
    private String templateEngine;

    private final Map<String, Object> properties = new HashMap<>();

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getTemplateEngine() {
        return templateEngine;
    }

    public void setTemplateEngine(String templateEngine) {
        this.templateEngine = templateEngine;
    }

    public void setProperties(Map<String, ?> properties) {
        this.properties.putAll(properties);
    }

    public Map<String, Object> getProperties() {
        return properties;
    }
}
