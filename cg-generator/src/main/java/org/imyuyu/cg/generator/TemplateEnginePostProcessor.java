package org.imyuyu.cg.generator;

import org.imyuyu.cg.generator.engine.TemplateEngine;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class TemplateEnginePostProcessor implements BeanPostProcessor {

    @Nullable
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof TemplateEngine) {
            TemplateEngineFactory.getInstance().register((TemplateEngine)bean);
        }
        return bean;
    }
}
