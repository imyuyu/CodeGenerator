package org.imyuyu.cg.apps.filetype;

import org.imyuyu.cg.common.exception.ResourceNotFoundException;

@SuppressWarnings("serial")
public class FileTypeNotFoundException extends ResourceNotFoundException {

    public FileTypeNotFoundException(long id) {
        super("Could not find file type with id " + id);
    }

}