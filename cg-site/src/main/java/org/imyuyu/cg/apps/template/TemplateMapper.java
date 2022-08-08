package org.imyuyu.cg.apps.template;

import org.imyuyu.cg.apps.user.User;
import org.mapstruct.*;

import java.time.LocalDateTime;

@Mapper(componentModel = "spring", imports = {LocalDateTime.class})
public interface TemplateMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", source = "templateForm.name")
    @Mapping(target = "code", source = "templateForm.code")
    @Mapping(target = "enabled", source = "templateForm.enabled")
    @Mapping(target = "deleted", constant = "false")
    @Mapping(target = "lastModifiedBy", ignore = true)
    @Mapping(target = "lastModifiedDate", ignore = true)
    @Mapping(target = "fileType", source = "fileType")
    @Mapping(target = "createdBy", source = "user")
    @Mapping(target = "createdDate", expression = "java(LocalDateTime.now())")
    Template createTemplateFromTemplateForm(TemplateForm templateForm, FileType fileType, User user);
}
