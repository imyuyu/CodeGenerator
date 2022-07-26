package org.imyuyu.cg.generator.engine;

import org.imyuyu.cg.generator.GeneratorContext;

/**
 * 模板引擎
 */
public interface TemplateEngine {

    /**
     * 模板引擎名称
     * 
     * @return 模板引擎名称
     */
    String getName();

    /**
     * 解析模板
     * 
     * @param generatorContext 上下文
     * @return 解析之后的文本
     */
    String resolve(GeneratorContext generatorContext);
}
