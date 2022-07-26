package org.imyuyu.cg.apps.template;

import org.imyuyu.cg.common.exception.ResourceNotFoundException;

@SuppressWarnings("serial")
public class TemplateNotFoundException extends ResourceNotFoundException {

    public TemplateNotFoundException(long id) {
        super("Could not find template with id " + id);
    }

}