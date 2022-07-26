package org.imyuyu.cg.apps.datasource;

import org.imyuyu.cg.common.exception.ResourceNotFoundException;

public class DataSourceNotFoundException extends ResourceNotFoundException {

    public DataSourceNotFoundException(Long id) {
        super("Could not find datasource with id " + id);
    }
}
