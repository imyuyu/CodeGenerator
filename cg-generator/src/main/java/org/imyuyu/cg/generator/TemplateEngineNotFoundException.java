package org.imyuyu.cg.generator;

import org.imyuyu.cg.common.exception.ResourceNotFoundException;

public class TemplateEngineNotFoundException extends ResourceNotFoundException {

    public TemplateEngineNotFoundException(String name) {
        super("Could not find TemplateEngine with name " + name);
    }
}
