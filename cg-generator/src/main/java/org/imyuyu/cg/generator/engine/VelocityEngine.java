package org.imyuyu.cg.generator.engine;

import cn.hutool.extra.template.Template;
import cn.hutool.extra.template.TemplateConfig;
import cn.hutool.extra.template.engine.TemplateFactory;
import org.imyuyu.cg.generator.GeneratorContext;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;

@Component
public class VelocityEngine implements TemplateEngine, InitializingBean {

    private cn.hutool.extra.template.TemplateEngine engine;

    @Override
    public String getName() {
        return "Velocity";
    }

    @Override
    public String resolve(GeneratorContext generatorContext) {
        Template template = engine.getTemplate(generatorContext.getTemplate());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        template.render(generatorContext.getProperties(), byteArrayOutputStream);
        return byteArrayOutputStream.toString();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        TemplateConfig config = new TemplateConfig();
        config.setCustomEngine(cn.hutool.extra.template.engine.velocity.VelocityEngine.class);
        config.setResourceMode(TemplateConfig.ResourceMode.STRING);
        config.setCharset(StandardCharsets.UTF_8);
        engine = TemplateFactory.create(config);
        Assert.notNull(engine, "模板引擎初始化失败！");
    }
}
